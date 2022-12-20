package Models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
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

    /*
    ----------------------------------------------------------------------------
    METODOS DE USUARIO
    ----------------------------------------------------------------------------
     */
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
        } catch (Exception ex) {
            System.out.println("Error DAO: llenarComboTrabajador... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: llenarComboTrabajador... " + ex.getMessage());
            }
        }
    }

    //  Metodo para registrar Trabajador
    public boolean registrarTrabajador(Trabajador x) {
        cn = getConexion();
        String sql = "{call usp_registrar_trabajador(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
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
            cs.setString(13, x.getPath());
            cs.setInt(14, x.getCodCargo());
            cs.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Error DAO: registrarTrabajador... " + ex.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarTrabajador... " + e.getMessage());
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
                String path = rs.getString("ruta");
                int codCargo = rs.getInt("codCargo");
                Cargo cargo = CargoDAO.getInstancia().consultarCargo(codCargo);

                trabajador = new Trabajador(id, dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, path, cargo);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DAO: consultarTrabajador... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: consultarTrabajador... " + ex.getMessage());
            }
        }
        return trabajador;
    }

    //  Metodo para actualizar datos de trabajador
    public boolean modificarTrabajadorConFoto(Trabajador x) {
        cn = getConexion();
        String sql = "call usp_actualizar_trabajadorConFoto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
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
            cs.setString(13, x.getPath());
            cs.setInt(14, x.getCodCargo());
            cs.setInt(15, x.getIdTrabajador());
            cs.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Error DAO: modificarTrabajadorConFoto... " + ex.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: modificarTrabajadorConFoto... " + ex.getMessage());
            }
        }
    }

    //  Metodo para actualizar datos de trabajador
    public boolean modificarTrabajadorSinFoto(Trabajador x) {
        cn = getConexion();
        String sql = "call usp_actualizar_trabajadorSinFoto(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
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
            cs.setInt(12, x.getCodCargo());
            cs.setInt(13, x.getIdTrabajador());
            cs.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Error DAO: modificarTrabajadorSinFoto... " + ex.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: modificarTrabajadorSinFoto... " + ex.getMessage());
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
                ps.close();
                rs.close();
                cn.close();
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
        } catch (Exception ex) {
            System.out.println("ERROR DAO: existeTelefono... " + ex.getMessage()); //Propagar la excepcion
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existeTelefono..." + ex.getMessage());
            }
        }
    }

    //metodo para cargar la tabla de trabajadores
    public void listarTrabajadores(DefaultTableModel modelo) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_trabajador";
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
        } catch (Exception ex) {
            System.out.println("ERROR DAO: listarTrabajadores... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: listarTrabajadores... " + ex.getMessage());
            }
        }
    }

    //  Metodo para filtrar nombres de trabajadores en la lista de trabajadores
    public void filtrarNombre(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listar_trabajador where Trabajador like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                int id = rs.getInt("idTrabajador");
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String nombreCargo = rs.getString("nombreCargo");
                String estado = rs.getString("estado");
                String fila[] = {String.valueOf(id), dni, trabajador, direccion, telefono, nombreCargo, estado};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusquedaNombre ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusquedaNombre ... " + e.getMessage());
            }
        }
    }

    //  Metodo para reingresar trabajador desde los items PopUp de la tabla trabajador
    public void suspenderTrabajador(int id) {
        cn = getConexion();
        String sql = "call usp_suspender_trabajador (?)";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (Exception ex) {
            System.out.println("ERROR DAO: suspenderTrabajador... " + ex.getMessage());
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: suspenderTrabajador... " + ex.getMessage());
            }
        }
    }

    public void reingresarTrabajador(int id) {
        cn = getConexion();
        String sql = "call usp_reingresar_trabajador (?);";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (Exception ex) {
            System.out.println("ERROR DAO: suspenderTrabajador... " + ex.getMessage());
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: suspenderTrabajador... " + ex.getMessage());
            }
        }
    }
    
    /////////////////////  DIALOG SELECTOR DE TRABAJADORES /////////////////////
    //metodo para cargar datos de trabajadores en el selector
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
        } catch (Exception ex) {
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

    //  Metodo para filtrar busqueda de nombres de trabajadores en el Dialog Selector de trabajadores
    public void filtrarBusquedaSelector(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listar_trabajador_dialog where Trabajador like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                int idTrabajador = rs.getInt("idTrabajador");
                String trabajador = rs.getString("Trabajador");
                String nombreCargo = rs.getString("nombreCargo");
                String fila[] = {String.valueOf(idTrabajador), trabajador, nombreCargo};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusqueda ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusqueda ... " + e.getMessage());
            }
        }
    }

    /*
    ----------------------------------------------------------------------------
    METODOS DE ADMINISTRADOR
    ----------------------------------------------------------------------------
     */
    //metodo para cargar la tabla listar trabajadores - Vista Administrador
    public void mostrarTrabajadores(DefaultTableModel modelo) {
        cn = getConexion();
        int columnas;
        String sql = "select * from mostrarTrabajadores";
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
        } catch (Exception ex) {
            System.out.println("ERROR DAO: mostrarTrabajadores... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: mostrarTrabajadores... " + ex.getMessage());
            }
        }
    }

    //  Metodo para filtrar nombres de trabajadores en la lista de trabajadores
    public void filtrarBusquedaNombre(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from mostrarTrabajadores where Trabajador like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String nombreCargo = rs.getString("nombreCargo");
                String estado = rs.getString("estado");
                String fila[] = {dni, trabajador, direccion, telefono, nombreCargo, estado};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusquedaNombre ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusquedaNombre ... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda de dni de trabajadores en la lista de trabajadores
    public void filtrarBusquedaDNI(String d, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from mostrarTrabajadores where dni like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, d + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String nombreCargo = rs.getString("nombreCargo");
                String estado = rs.getString("estado");
                String fila[] = {dni, trabajador, direccion, telefono, nombreCargo, estado};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusqueda ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusqueda ... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda de celular de trabajadores en la lista de trabajadores
    public void filtrarBusquedaCelular(String cel, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from mostrarTrabajadores where telefono like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cel + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String nombreCargo = rs.getString("nombreCargo");
                String estado = rs.getString("estado");
                String fila[] = {dni, trabajador, direccion, telefono, nombreCargo, estado};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusqueda ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusqueda ... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda de celular de trabajadores en la lista de trabajadores
    public void filtrarBusquedaCargoTrabajador(String cargo, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from mostrarTrabajadores where nombreCargo like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cargo + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String nombreCargo = rs.getString("nombreCargo");
                String estado = rs.getString("estado");
                String fila[] = {dni, trabajador, direccion, telefono, nombreCargo, estado};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusquedaCargoTrabajador ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusquedaCargoTrabajador ... " + e.getMessage());
            }
        }
    }
}
