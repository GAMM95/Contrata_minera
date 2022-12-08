package Models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class PerfilLaboralDAO extends Conexion {

    //  Atributos de conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Establecer formato para el ingreso de la fecha
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    //  Instancia de la clase
    private static PerfilLaboralDAO instancia;

    public static PerfilLaboralDAO getInstancia() {
        if (instancia == null) {
            instancia = new PerfilLaboralDAO();
        }
        return instancia;
    }

    //  Metodo para registrar perfil laboral de trabajador
    public boolean registrarPerfil(PerfilLaboral x) {
        cn = getConexion();
        String sql = "{call usp_registrar_perfil(?,?,?,?,?,?)}";
        try {
            cn.setAutoCommit(true); //cancelar el control de transacciones
            cs = cn.prepareCall(sql);
            if (x.getFechaIngreso() != null) {
                cs.setDate(1, java.sql.Date.valueOf(df.format(x.getFechaIngreso())));
            } else {
                cs.setDate(1, null);
            }
            cs.setString(2, x.getArea());
            cs.setDouble(3, x.getSueldo());
//            if (x.getFechaCese() != null) { //  Custom calendar
//                cs.setDate(4, java.sql.Date.valueOf(df.format(x.getFechaCese())));
//            } else {
//                cs.setDate(4, null);
//            }
            if (x.getFechaCese() != null) {   //DateChooser jCalendar
                cs.setDate(4, new java.sql.Date(x.getFechaCese().getTime()));
            } else {
                cs.setDate(4, null);
            }
            cs.setString(5, x.getMotivoCese());
            cs.setInt(6, x.getIdTrabajador());
            cs.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Error DAO: registrarPerfil... " + ex.getMessage());
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
                System.out.println("Error SQLException: registrarPerfil.... " + ex.getMessage());
            }

        }
    }

        //  Metodo para validar existencia de dni
    public int existeContrato(int id) {
        cn = getConexion();
        String sql = "select count(idTrabajador) from perfillaboral where idTrabajador = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception ex) {
            System.out.println("ERROR DAO: existeContrato... " + ex.getMessage()); //Propagar la excepcion
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existeContrato... " + ex.getMessage());
            }
        }
    }
    
    //  Metodo para cargar tabla de perfile
    public void listarPerfilLaboral(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_perfil";
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
                model.addRow(fila);
            }
        } catch (Exception e) {
            System.out.println("ERROR DAO: listarPerfilLaboral... " + e.getMessage());
        } finally {

            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: listarPerfilLaboral... " + ex.getMessage());
            }

        }
    }

    //  Metodo para consultar perfil por cod
    public PerfilLaboral consultarPerfil(int cod) {
        cn = getConexion();
        PerfilLaboral perfilLaboral = null;
        String sql = "select * from perfilLaboral where codPerfil = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()) {
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                double sueldo = rs.getDouble("sueldo");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                int idTrabajador = rs.getInt("idTrabajador");
                Trabajador trabajador = TrabajadorDAO.getInstancia().consultarTrabajador(idTrabajador);

                perfilLaboral = new PerfilLaboral(fechaIngreso, area, sueldo, fechaCese, motivoCese, trabajador);
            }
        } catch (Exception e) {
            System.out.println("ERROR DAO: consultarPerfil... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: consultarPerfil... " + ex.getMessage());
            }
        }
        return perfilLaboral;
    }

    //  Metodo para filtrar busqueda de trabajadores
    public void filtrarBusqueda(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listar_perfil where Trabajador like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                int codPerfil = rs.getInt("codPerfil");
                String trabajador = rs.getString("Trabajador");
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                String fila[] = {String.valueOf(codPerfil), trabajador, String.valueOf(fechaIngreso), area, String.valueOf(fechaCese), motivoCese};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusqueda ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();;
                cn.close();
            } catch (Exception e) {
                System.out.println("Error SQLException: filtrarBusqueda ... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda por nombre de trabajador en el panel ListarContratos - Vista Administrador
    public void filtrarBusquedaNombre(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listarContratos where Trabajador like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                String cargo = rs.getString("nombreCargo");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                String fila[] = {dni, trabajador, String.valueOf(fechaIngreso), area, cargo, String.valueOf(fechaCese), motivoCese};
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

    //  Metodo para filtrar busqueda por dni de trabajador en el panel ListarContratos - Vista Administrador
    public void filtrarBusquedaDni(String dniTrabajador, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listarContratos where dni like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dniTrabajador + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                String cargo = rs.getString("nombreCargo");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                String fila[] = {dni, trabajador, String.valueOf(fechaIngreso), area, cargo, String.valueOf(fechaCese), motivoCese};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusquedaDni... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusquedaDni... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda por area de trabajador en el panel ListarContratos - Vista Administrador
    public void filtrarBusquedaArea(String areaTrabajador, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listarContratos where area like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, areaTrabajador + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                String cargo = rs.getString("nombreCargo");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                String fila[] = {dni, trabajador, String.valueOf(fechaIngreso), area, cargo, String.valueOf(fechaCese), motivoCese};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusquedaArea... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusquedaArea... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda por area de trabajador en el panel ListarContratos - Vista Administrador
    public void filtrarBusquedaCargo(String cargoTrabajador, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listarContratos where nombreCargo like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cargoTrabajador + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                String cargo = rs.getString("nombreCargo");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                String fila[] = {dni, trabajador, String.valueOf(fechaIngreso), area, cargo, String.valueOf(fechaCese), motivoCese};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusquedaCargo... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusquedaCargo... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda por estado de trabajador en el panel ListarContratos - Vista Administrador
    public void filtrarBusquedaEstado(String estado, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listarContratos where estado like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, estado + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                String cargo = rs.getString("nombreCargo");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                String fila[] = {dni, trabajador, String.valueOf(fechaIngreso), area, cargo, String.valueOf(fechaCese), motivoCese};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusquedaEstado... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusquedaEstado... " + e.getMessage());
            }
        }
    }

    //  Metodo para mostrar contratos activos
    public void mostrarContratosActivos(DefaultTableModel modelo) {
        cn = getConexion();
        modelo.getDataVector().removeAllElements();
        String sql = "select * from listar_perfilActivos";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codPerfil");
                String trabajador = rs.getString("Trabajador");
                String fechaIngreso = rs.getString("fechaIngreso");
                String area = rs.getString("area");
                String fechaCese = rs.getString("fechaCese");
                String motivo = rs.getString("motivoCese");
                String fila[] = {cod, trabajador, fechaIngreso, area, fechaCese, motivo};
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DAO: mostrarContratosActivos... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: mostrarContratosActivos..." + ex.getMessage());
            }
        }
    }

    //  Metodo para mostrar contratos activos
    public void mostrarContratosCesados(DefaultTableModel modelo) {
        cn = getConexion();
        modelo.getDataVector().removeAllElements();
        String sql = "select * from listar_perfilCesados";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codPerfil");
                String trabajador = rs.getString("Trabajador");
                String fechaIngreso = rs.getString("fechaIngreso");
                String area = rs.getString("area");
                String fechaCese = rs.getString("fechaCese");
                String motivo = rs.getString("motivoCese");
                String fila[] = {cod, trabajador, fechaIngreso, area, fechaCese, motivo};
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DAO: mostrarContratosCesados... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: mostrarContratosCesados..." + ex.getMessage());
            }
        }
    }

    //  Metodo para mostrar contratos activos
    public void mostrarContratos(DefaultTableModel modelo) {
        cn = getConexion();
        modelo.getDataVector().removeAllElements();
        String sql = "select * from listarContratos";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String dni = rs.getString("dni");
                String trabajador = rs.getString("Trabajador");
                String fechaIngreso = rs.getString("fechaIngreso");
                String area = rs.getString("area");
                String nombreCargo = rs.getString("nombreCargo");
                String fechaCese = rs.getString("fechaCese");
                String motivo = rs.getString("motivoCese");
                String fila[] = {dni, trabajador, fechaIngreso, area, nombreCargo, fechaCese, motivo};
                modelo.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DAO: mostrarContratos... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: mostrarContratos..." + ex.getMessage());
            }
        }
    }

    
}
