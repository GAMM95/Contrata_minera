package Models;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class UsuarioDAO extends Conexion {

    //  Atributos
    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;

    private Image data;

    private static UsuarioDAO instancia;

    public static UsuarioDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public void llenarCombo(JComboBox cboTipoUsuario) throws SQLException {
        cn = getConexion();
        String sql = "select idRol, nombreRol from rol";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            cboTipoUsuario.removeAllItems();
            while (rs.next()) {
                cboTipoUsuario.addItem(new Rol(rs.getInt("idRol"), rs.getString("nombreRol")));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage()); //Propagar la excepcion
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean registrarUsuario(Usuario u, FileInputStream foto, int longitudBytes) {
        cn = getConexion();
        String sql = "{call usp_registrar_usuario(?,?,?,?,?,?)}"; // (username,password,nombre,email,idRol,foto)
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, u.getUsername());
            cs.setString(2, u.getPassword());
            cs.setString(3, u.getNombre());
            cs.setString(4, u.getEmail());
            cs.setInt(5, u.getIdRol());
            cs.setBlob(6, foto, longitudBytes);
            cs.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR registrar usuario el primero: " + ex.getMessage()); //Propagar la excepcion
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error de finally en registrarUsuario: " + ex.getMessage());
            }

        }
    }

//    public boolean registrarUsuario(String username, String password, String nombre, String email, int idRol, FileInputStream foto, int longitudBytes) throws SQLException {
//        cn = getConexion();
//        String sql = "insert into usuario (username,password,nombre,email,idRol,foto) values (?,?,?,?,?,?)";
//        try {
//            ps = cn.prepareStatement(sql);
//            ps.setString(1, username);
//            ps.setString(2, password);
//            ps.setString(3, nombre);
//            ps.setString(4, email);
//            ps.setInt(5, idRol);
//            ps.setBlob(6, foto, longitudBytes);
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException ex) {
//            System.out.println("ERROR: " + ex.getMessage()); //Propagar la excepcion
//            return false;
//        } finally {
//            if (ps != null) {
//                ps.close();
//            }
//            if (cn != null) {
//                cn.close();
//            }
//        }
//    }
    public int existeUsuario(String username){
        cn = getConexion();
        String sql = "select count(idUsuario) from usuario where username = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, username);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERROR de existencia de usuario: " + ex.getMessage()); //Propagar la excepcion
            return 1;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error de finally en existeUsuario: " + ex.getMessage());
            }
        }
    }

    public boolean esEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); //patron de validacion
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean login(Usuario u, Rol tu) throws SQLException {
        cn = getConexion();
        String sql = "select idUsuario, username, password, u.nombre, u.idRol, r.nombreRol from usuario u inner join rol r on u.idRol = r.idRol where username = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (u.getPassword().equals(rs.getString(3))) {

                    String query = "update usuario set lastSesion = ? where idUsuario =?";
                    ps = cn.prepareStatement(query);
                    ps.setString(1, u.getLastSesion());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();

                    u.setIdUsuario(rs.getInt(1));
                    u.setNombre(rs.getString(4));
                    tu.setIdRol(rs.getInt(5));
                    tu.setNombreRol(rs.getString(6));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage()); //Propagar la excepcion
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    public boolean recuperarPassword(Usuario u) throws SQLException {
        cn = getConexion();
        String sql = "select username, password from usuario where username=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (u.getUsername().equals(rs.getString(1))) {
                    u.setPassword(rs.getString(2));
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return false;
    }

    public void cambiarPass(Usuario x) throws SQLException {
        cn = getConexion();
        String sql = "{call usp_cambiarPass(?,?)}";
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getUsername());
            cs.setString(2, x.getPassword());
            cs.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage()); //Propagar la excepcion
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    //  Metodo para cargar la tabla de usuarios
    public void listarUsuarios(DefaultTableModel modelo) throws SQLException {
        cn = getConexion();
        String titulos[] = {"USERNAME", "NOMBRE COMPLETO", "EMAIL", "ULTIMA SESIÓN", "ROL"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql = "select * from listar_usuarios";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                Rol r = new Rol();
                u.setUsername(rs.getString("username"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setLastSesion(rs.getString("lastSesion"));
                r.setNombreRol(rs.getString("nombreRol"));
                String fila[] = {u.getUsername(), u.getNombre(), u.getEmail(), u.getLastSesion(), r.getNombreRol()};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR listarCargos: " + ex.getMessage());
        } finally {
            ps.close();
            cn.close();
        }
    }

    public ImageIcon getFoto(String user) {
        cn = getConexion();
        String sql = "select foto from usuario where username = ?";
        ImageIcon ii = null;
        InputStream is = null;

        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ps.setString(1, user);
            while (rs.next()) {
                is = rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                ii = new ImageIcon(bi);
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return ii;
    }

    //  Metodo para devolver imagen segun los parametros user y pass
    public Image cargarFoto(String user, String pass) {
        cn = getConexion();
        String sql = "select foto from usuario where username = ? and password = ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                byte[] b = rs.getBytes("foto"); // Se lee la cadena de  de bytes de la base de datos
                data = convertirImagen(b);  // esta cadena sera convertida en una imagen
                i++;
            }
        } catch (IOException ex) {
            System.out.println("Error de IO cargarFoto " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error de SQL cargarFoto " + ex.getMessage());
        }
        return data;
    }

    // Metodo que dada una cadena de bytes la convierte en una imagen extension .jpeg
    private Image convertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg"); // Se le aplica el formato ue admitira
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }
}
