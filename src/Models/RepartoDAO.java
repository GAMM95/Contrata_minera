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
}
