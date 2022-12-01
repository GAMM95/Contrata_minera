package Models;

import java.sql.*;

public class VehiculoDAO extends Conexion {

//  Atributos de la clase Conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Metodo para registar vehiculo
    private boolean registrarVehiculo(Vehiculo x) {
        cn = getConexion();
        String sql = "";
        try {
            cn.setAutoCommit(true);
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getIdVehiculo());
            ps.setString(2, x.getPlaca());
            ps.setString(3, x.getModelo());
            ps.setString(4, x.getMarca());
            if (x.getFechaIngreso() != null) {
                ps.setDate(5, new java.sql.Date(x.getFechaIngreso().getTime()));
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
}
