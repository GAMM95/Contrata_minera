package Models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class ValeDAO extends Conexion {

    //  Atributos de la clase conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Establecer formato para el ingreso de la fecha
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    // Metodo para registrar vale de combustible
    public boolean registrarVale(Vale x) {
        cn = getConexion();
        String sql = "call usp_registrar_vales(?,?,?,?,?,?,?)";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getCodVale());
            if (x.getFecha() != null) {
                cs.setDate(2, java.sql.Date.valueOf(df.format(x.getFecha())));
            } else {
                cs.setDate(2, null);
            }
            cs.setString(3, x.getHora());
            cs.setString(4, x.getLugar());
            cs.setDouble(5, x.getHorometro());
            cs.setDouble(6, x.getGalones());
            cs.setInt(7, x.getCodReparto());
            cs.executeUpdate();
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

    //  Metodo para validar existencia de codigo de boucher
    public int existenciaCodVale(String cod) {
        cn = getConexion();
        String sql = "select count(idVale) from vale where codVale = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception e) {
            System.out.println("Error DAO: existenciaCodVale... " + e.getMessage());
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existenciaCodVale... " + ex.getMessage());
            }
        }
    }
}
