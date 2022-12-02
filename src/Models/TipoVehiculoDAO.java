package Models;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class TipoVehiculoDAO extends Conexion {

    //  Atributos de la clase Conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Metodo para registar vehiculo
    public boolean registrarTipoVehiculo(TipoVehiculo x) {
        cn = getConexion();
        String sql = "call usp_registrar_tipoVehiculo(?)";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getNombreTipo());
            cs.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: registrarTipoVehiculo... " + e.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarTipoVehiculo... " + e.getMessage());
            }
        }
    }

    //  Metodo para listar tipos de vehiculo
    public void listarTipoVehiculo(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_tipoVehiculo";
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
            System.out.println("Error DAO: listarTipoVehiculo... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarTipoVehiculo... " + e.getMessage());
            }
        }
    }

    //  Metodo para validar la existencia del nombre del tipo de vehiculo
    public int existeNombre(String nombre) {
        cn = getConexion();
        String sql = "select count(codTipo) from tipoVehiculo where nombreTipo = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception ex) {
            System.out.println("ERROR DAO: existeNombre... " + ex.getMessage()); //Propagar la excepcion
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existeNombre..." + ex.getMessage());
            }
        }
    }
}
