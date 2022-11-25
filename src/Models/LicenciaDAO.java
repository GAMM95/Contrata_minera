package Models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class LicenciaDAO extends Conexion {
    //  Atributos de conexion

    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Establecer formato para el ingreso de la fecha
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    //  Instancia de la clase
    private static LicenciaDAO instancia;

    public static LicenciaDAO getInstancia() {
        if (instancia == null) {
            instancia = new LicenciaDAO();
        }
        return instancia;
    }

    //  Metodo para registrar licencias de trabajador
    public boolean registrarLicencia(Licencia x) {
        cn = getConexion();
        String sql = "{call usp_registrar_perfil(?,?,?,?,?,?)}";
        try {
            cn.setAutoCommit(true); //cancelar el control de transacciones
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getNumLicencia());
            cs.setString(2, x.getCategoria());
            if (x.getFechaEmision() != null) {
                cs.setDate(3, java.sql.Date.valueOf(df.format(x.getFechaEmision())));
            } else {
                cs.setDate(3, null);
            }
            if (x.getFechaCaducidad() != null) {
                cs.setDate(4, java.sql.Date.valueOf(df.format(x.getFechaCaducidad())));
            } else {
                cs.setDate(4, null);
            }
            cs.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Error DAO: registrarLicencia... " + ex.getMessage());
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
                System.out.println("Error SQLException: registrarLicencia.... " + ex.getMessage());
            }

        }
    }
}
