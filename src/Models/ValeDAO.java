package Models;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ValeDAO extends Conexion {

    //  Atributos de la clase conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    // Metodo para registrar vale de combustible
    public boolean registrarVale(Vale x) {
        cn = getConexion();
        String sql = "call usp_registrar_vales(?,?,?,?,?,?,?,?)";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getCodVale());
            if (x.getFecha() != null) {
                cs.setDate(2, new java.sql.Date(x.getFecha().getTime()));
            } else {
                cs.setDate(2, null);
            }
            cs.setString(3, x.getLugar());
            cs.setDouble(4, x.getHorometro());
            cs.setDouble(5, x.getGalones());
            cs.setInt(6, x.getCodGuardia());
            cs.setInt(7, x.getIdTrabajador());
            cs.setInt(8, x.getCodVehiculo());
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: registrarVale... " + e.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarVale... " + e.getMessage());
            }
        }
    }
    
    
    //  Metodo para listar vales de combustible
    public void listarVales(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_vales";
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
            System.out.println("Error DAO: listarVales... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarVales... " + e.getMessage());
            }
        }
    }

    //  M
}
