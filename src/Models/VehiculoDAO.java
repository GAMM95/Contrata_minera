package Models;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class VehiculoDAO extends Conexion {

    //  Atributos de la clase Conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Instancia de la clase TrabajadorDAO
    private static VehiculoDAO instancia;

    public static VehiculoDAO getInstancia() {
        if (instancia == null) {
            instancia = new VehiculoDAO();
        }
        return instancia;
    }

    //  Metodo para registar vehiculo
    public boolean registrarVehiculo(Vehiculo x) {
        cn = getConexion();
        String sql = "call usp_registrar_vehiculo(?,?,?,?,?,?,?)";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getIdVehiculo());
            cs.setString(2, x.getPlaca());
            cs.setString(3, x.getModelo());
            cs.setString(4, x.getMarca());
            if (x.getFechaCompra() != null) {
                cs.setDate(5, new java.sql.Date(x.getFechaCompra().getTime()));
            } else {
                cs.setDate(5, null);
            }
            cs.setString(6, x.getAño());
            cs.setInt(7, x.getCodTipoVehiculo());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: registrarVehiculo... " + e.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarVehiculo... " + e.getMessage());
            }
        }
    }

    //  Metodo para listar vehiculos
    public void listarVehiculos(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_vehiculos";
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
            System.out.println("Error DAO: listarVehiculos... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarVehiculos... " + e.getMessage());
            }
        }
    }

    //  Metodo para validar la existencia id del vehiculo
    public int existeId(String id) {
        cn = getConexion();
        String sql = "select count(codVehiculo) from vehiculo where idVehiculo = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception ex) {
            System.out.println("ERROR DAO: existeId... " + ex.getMessage()); //Propagar la excepcion
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existeId..." + ex.getMessage());
            }
        }
    }

    //  Metodo para validar la existencia dela placa del vehiculo
    public int existePlaca(String placa) {
        cn = getConexion();
        String sql = "select count(codVehiculo) from vehiculo where placa = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception ex) {
            System.out.println("ERROR DAO: existePlaca... " + ex.getMessage()); //Propagar la excepcion
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existePlaca..." + ex.getMessage());
            }
        }
    }

    //  Metodo para listar vehiculos en el selector de vehiculos
    public void listarVehiculosDialog(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_vehiculos_dialog";
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
            System.out.println("Error DAO: listarVehiculosDialog... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarVehiculosDialog... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda de nombres de trabajadores en el Dialog Selector de trabajadores
    public void filtrarBusquedaSelector(String id, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listar_vehiculos_dialog where idVehiculo like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, id + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                int codVehiculo = rs.getInt("codVehiculo");
                String idVehiculo = rs.getString("idVehiculo");
                String nombreTipo = rs.getString("nombreTipo");
                String fila[] = {String.valueOf(codVehiculo), idVehiculo, nombreTipo};
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

    public Vehiculo consultarVehiculo(int cod) {
        cn = getConexion();
        Vehiculo vehiculo = null;
        String sql = "select from vehiculo where codVehiculo = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()) {

            }
        } catch (Exception ex) {
            System.out.println("ERROR DAO: consultarVehiculo... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: consultarVehiculo... " + ex.getMessage());
            }
        }
        return vehiculo;
    }

}
