package Models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class RepartoDAO extends Conexion {

    //  Atributos de la clase conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Establecer formato para el ingreso de la fecha
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    // Metodo para registrar vale de combustible
    public boolean registrarReparto(Reparto x) {
        cn = getConexion();
        String sql = "call usp_registrar_reparto(?,?,?,?,?)";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            if (x.getFechaReparto() != null) {
                cs.setDate(1, java.sql.Date.valueOf(df.format(x.getFechaReparto())));
            } else {
                cs.setDate(1, null);
            }
            cs.setInt(2, x.getCodGuardia());
            cs.setInt(3, x.getIdTrabajador());
            cs.setInt(4, x.getCodVehiculo());
            cs.setString(5, x.getAsistencia());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: registrarReparto... " + e.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarReparto... " + e.getMessage());
            }
        }
    }

    //  Metodo para listar vales de combustible
    public void listarRepartoA(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listarRepartoA";
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
            System.out.println("Error DAO: listarRepartoA... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarRepartoA... " + e.getMessage());
            }
        }
    }

    public void listarRepartoB(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listarRepartoB";
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
            System.out.println("Error DAO: listarRepartoB... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarRepartoB... " + e.getMessage());
            }
        }
    }

    public void listarRepartoC(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listarRepartoC";
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
            System.out.println("Error DAO: listarRepartoC... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarRepartoC... " + e.getMessage());
            }
        }
    }

    //  Metodo para validar existencia de codigo de boucher
    public int existenciaRepartoDiario(int id) {
        cn = getConexion();
        String sql = "select count(codReparto) from reparto where idTrabajador = ? and fechaReparto = curdate()";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception e) {
            System.out.println("Error DAO: existenciaRepartoDiario... " + e.getMessage());
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existenciaRepartoDiario... " + ex.getMessage());
            }
        }
    }

    //  Metodo para consultar repartos
    public Reparto consultarReparto(int codigo) {
        cn = getConexion();
        Reparto reparto = null;
        String sql = "call usp_consultar_reparto(?)";
        try {
            cs = cn.prepareCall(sql);
            cs.setInt(1, codigo);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {
                Date fechaReparto = rs.getDate("fechaReparto");
                int codGuardia = rs.getInt("codGuardia");
                Guardia guardia = GuardiaDAO.getInstancia().consultarGuardia(codGuardia);
                int idTrabajador = rs.getInt("idTrabajador");
                Trabajador trabajador = TrabajadorDAO.getInstancia().consultarTrabajador(idTrabajador);
                int codVehiculo = rs.getInt("codVehiculo");
                Vehiculo vehiculo = VehiculoDAO.getInstancia().consultarVehiculo(codVehiculo);
                String asistencia = rs.getString("asistencia");

                reparto = new Reparto(codVehiculo, fechaReparto, guardia, trabajador, vehiculo, asistencia);
            }
        } catch (Exception ex) {
            System.out.println("ERROR Exception: consultarReparto ... " + ex.getMessage());
        } finally {
            try {
                cs.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SLQException: consultarReparto ... " + ex.getMessage());
            }
        }
        return reparto;
    }

    //  Metodo para filtrar trabajadores en la lista de repartos
    public void filtrarNombre(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listarRepartoA where Trabajador like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(0, nombre + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                int cod = rs.getInt("codReparto");
                Date fechaReparto = rs.getDate("fechaReparto");
                String Trabajador = rs.getString("Trabajador");
                int idVehiculo = rs.getInt("idVehiculo");
                String asistencia = rs.getString("asistencia");
                String fila[] = {String.valueOf(cod), String.valueOf(fechaReparto), Trabajador, String.valueOf(idVehiculo), asistencia};

                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarNombre ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: filtrarNombre ... " + ex.getMessage());
            }
        }
    }

}
