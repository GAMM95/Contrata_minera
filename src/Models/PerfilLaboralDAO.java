package Models;

import Models.Conexion;
import java.sql.*;

public class PerfilLaboralDAO extends Conexion {

    //  Atributos de conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;

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
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            if (x.getFechaIngreso() != null) {
                cs.setDate(1, new java.sql.Date(x.getFechaIngreso().getTime()));
            } else {
                cs.setDate(1, null);
            }
            cs.setString(2, x.getArea());
            cs.setDouble(3, x.getSueldo());
            if (x.getFechaCese() != null) {
                cs.setDate(4, new java.sql.Date(x.getFechaCese().getTime()));
            } else {
                cs.setDate(4, null);
            }
            cs.setString(5, x.getMotivoCese());
            cs.setInt(6, x.getIdTrabajador());
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error DAO de registro de perfil: " + ex.getMessage());
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
                System.out.println("Error de conexion de regisstrar perfil: " + ex.getMessage());
            }
        }
    }

}
