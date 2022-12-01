package Models;

import java.sql.*;

public class TipoVehiculoDAO extends Conexion {

    //  Atributos de la clase Conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Metodo para registar vehiculo
    private boolean registrarTipoVehiculo(TipoVehiculo x) {
        cn = getConexion();
        String sql = "";
        try {
            cn.setAutoCommit(true);
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getNombreTipo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: registrarTipoVehiculo... " + e.getMessage());
            return false;
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarTipoVehiculo... " + e.getMessage());
            }
        }
    }
}
