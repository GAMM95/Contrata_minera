package Models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TrabajadorDAO extends Conexion {

    //  Atributos de la clase
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Establecer formato para el ingreso de la fecha
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    //  Instancia de la clase TrabajadorDAO
    private static TrabajadorDAO instancia;

    public static TrabajadorDAO getInstancia() {
        if (instancia == null) {
            instancia = new TrabajadorDAO();
        }
        return instancia;
    }

    //  Metodo para registrar Trabajador
    public boolean registrarTrabajador(Trabajador x) {
        cn = getConexion();
        String sql = "{call usp_registrar_trabajador(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getDni());
            cs.setString(2, x.getApePaterno());
            cs.setString(3, x.getApeMaterno());
            cs.setString(4, x.getNombres());
            cs.setString(5, x.getSexo());
            cs.setString(6, x.getEstadoCivil());
            if (x.getFechaNacimiento() != null) {
                cs.setDate(7, java.sql.Date.valueOf(df.format(x.getFechaNacimiento())));
            } else {
                cs.setDate(7, null);
            }
            cs.setString(8, x.getDireccion());
            cs.setString(9, x.getTelefono());
            cs.setString(10, x.getGradoInstruccion());
            cs.setString(11, x.getProfesion());
            cs.setBytes(12, x.getFoto());
            cs.setInt(13, x.getCodCargo());
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error DAO: registrarTrabajador... " + ex.getMessage());
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarTrabajador... " + e.getMessage());
            }
        }
    }

    //  Metodo para validar existencia de dni
    public int existeDNI(String dni) {
        cn = getConexion();
        String sql = "select count(idTrabajador) from trabajador where dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception ex) {
            System.out.println("ERROR DAO: existeDNI... " + ex.getMessage()); //Propagar la excepcion
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
                System.out.println("Error SQLException: existeDNI... " + ex.getMessage());
            }
        }
    }

    //  Metodo para validar existencia de telefono de celular
    public int existeTelefono(String telefono) {
        cn = getConexion();
        String sql = "select count(idTrabajador) from trabajador where telefono =?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, telefono);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERROR de existencia de telefono: " + ex.getMessage()); //Propagar la excepcion
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
                System.out.println("Error de finally en telefono: " + ex.getMessage());
            }
        }
    }

    //metodo para cargar la tabla de cargos
    public void listarTrabajadores(DefaultTableModel modelo) {
        cn = getConexion();
//        String titulos[] = {"DNI", "TRABAJADOR", "DIRECCION", "TELEFONO", "CARGO", "ESTADO"};
//        modelo.getDataVector().removeAllElements();
//        modelo.setColumnIdentifiers(titulos);
        int columnas;
        String sql = "select * from listar_trabajador";
        try {

            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            while (rs.next()) {
//                Trabajador x = new Trabajador();
//                Cargo c = new Cargo();
//                x.setDni(rs.getString("dni"));
//                x.setApePaterno(rs.getString("apePaterno"));
//                x.setApeMaterno(rs.getString("apeMaterno"));
//                x.setNombres(rs.getString("nombres"));
//                x.setTelefono(rs.getString("telefono"));
//                c.setNombreCargo(rs.getString("nombreCargo"));
//                x.setEstado(rs.getString("estado"));
//                String fila[] = {x.getDni(), x.getApePaterno(), x.getApeMaterno(), x.getNombres(), x.getDireccion(), x.getTelefono(), c.getNombreCargo(), x.getEstado()};
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("ERROR listarTrabajadores: " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: " + ex.getMessage());
            }
        }
    }

    //metodo para cargar la tabla de Selector de trabajadores
    public void listarTrabajadoresDialog(DefaultTableModel modelo) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_trabajador_dialog";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DAO: listarTrabajadoresDialog... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: listarTrabajadoresDialog..." + ex.getMessage());
            }
        }
    }

    //  Metodo para llenar comboBox en otros formularios que necesiten escoger al trabajador
    public void llenarComboTrabajador(JComboBox cboTrabajador) {
        cn = getConexion();
        String sql = "select idTrabajador, concat(apePaterno, ' ', apeMaterno, ' ', nombres) Trabajador from trabajador";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            cboTrabajador.removeAllItems();
            while (rs.next()) {
                cboTrabajador.addItem(new Cargo(rs.getInt("idTrabajador"), rs.getString("Trabajador")));
            }
        } catch (SQLException ex) {
            System.out.println("Error de llenar combo de trabajador: " + ex.getMessage());
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
                System.out.println("Error cerrar conexiones llenarComboTrabajador: " + ex.getMessage());
            }
        }
    }

    //  Metodo para consultar trabajaddor por su id
    public Trabajador consultarTrabajador(int id) {
        cn = getConexion();
        Trabajador trabajador = null;
        String sql = "select * from trabajador where idTrabajador = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()) {
                String dni = rs.getString("dni");
                String apePaterno = rs.getString("apePaterno");
                String apeMaterno = rs.getString("apeMaterno");
                String nombres = rs.getString("nombres");
                String sexo = rs.getString("sexo");
                String estadoCivil = rs.getString("estadoCivil");
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String gradoInstruccion = rs.getString("gradoInstruccion");
                String profesion = rs.getString("profesion");
                byte[] foto = rs.getBytes("foto");
                int codCargo = rs.getInt("codCargo");
                Cargo cargo = CargoDAO.getInstancia().consultarCargo(codCargo);

                trabajador = new Trabajador(id, dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, cargo);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR de busqueda: " + ex.getMessage());
        } finally {
            try {
                cn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error de finally" + ex.getMessage());
            }

        }
        return trabajador;
    }

    //  Metodo para actualizar datos de trabajador
    public boolean modificarTrabajador(Trabajador x) {
        cn = getConexion();
        String sql = "update trabajador set dni = ?, apePaterno = ?, apeMaterno = ?, nombres = ?, sexo = ?, estadoCivil = ?, fechaNacimiento = ?, direccion = ?, telefono = ?, gradoInstruccion = ?, profesion = ?, foto = ?, codCargo = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getDni());
            ps.setString(2, x.getApePaterno());
            ps.setString(3, x.getApeMaterno());
            ps.setString(4, x.getNombres());
            ps.setString(5, x.getSexo());
            ps.setString(6, x.getEstadoCivil());
            if (x.getFechaNacimiento() != null) {
                ps.setDate(7, java.sql.Date.valueOf(df.format(x.getFechaNacimiento())));
            } else {
                ps.setDate(7, null);
            }
            ps.setString(8, x.getDireccion());
            ps.setString(9, x.getTelefono());
            ps.setString(10, x.getGradoInstruccion());
            ps.setString(11, x.getProfesion());
            ps.setBytes(12, x.getFoto());
            ps.setInt(13, x.getCodCargo());
            ps.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Error DAO: modificarTrabajador... " + ex.getMessage());
            return false;
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: modificarTrabajador... " + ex.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda de nombres de trabajadores en el Dialog Selector de trabajadores
    public void filtrarBusqueda(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listar_trabajador_dialog where Trabajador like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                int idTrabajador = rs.getInt("idTrabajador");
                String trabajador = rs.getString("Trabajador");
                String fila[] = {String.valueOf(idTrabajador), trabajador};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusqueda ..." + ex.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();;
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("Error SQLException: filtrarBusqueda ... " + e.getMessage());
            }
        }
    }
}
