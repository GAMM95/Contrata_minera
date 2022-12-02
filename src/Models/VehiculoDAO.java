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

    //  Metodo para registar vehiculo
    public boolean registrarVehiculo(Vehiculo x) {
        cn = getConexion();
        String sql = "";
        try {
            cn.setAutoCommit(true);
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getIdVehiculo());
            ps.setString(2, x.getPlaca());
            ps.setString(3, x.getModelo());
            ps.setString(4, x.getMarca());
            if (x.getFechaCompra()!= null) {
                ps.setDate(5, new java.sql.Date(x.getFechaCompra().getTime()));
            } else {
                ps.setDate(5, null);
            }
            ps.setString(6, x.getAño());
            ps.setInt(7, x.getTipoVehiculo().getCodTipo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: registrarVehiculo... " + e.getMessage());
            return false;
        } finally {
            try {
                ps.close();
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
}
