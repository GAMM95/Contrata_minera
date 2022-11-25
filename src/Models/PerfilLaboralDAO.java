package Models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class PerfilLaboralDAO extends Conexion {

    //  Atributos de conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Establecer formato para el ingreso de la fecha
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

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
            cn.setAutoCommit(true); //cancelar el control de transacciones
            cs = cn.prepareCall(sql);
            if (x.getFechaIngreso() != null) {
                cs.setDate(1, java.sql.Date.valueOf(df.format(x.getFechaIngreso())));
            } else {
                cs.setDate(1, null);
            }
            cs.setString(2, x.getArea());
            cs.setDouble(3, x.getSueldo());
//            if (x.getFechaCese() != null) { //  Custom calendar
//                cs.setDate(4, java.sql.Date.valueOf(df.format(x.getFechaCese())));
//            } else {
//                cs.setDate(4, null);
//            }
            if (x.getFechaCese() != null) {   //DateChooser jCalendar
                cs.setDate(4, new java.sql.Date(x.getFechaCese().getTime()));
            } else {
                cs.setDate(4, null);
            }
            cs.setString(5, x.getMotivoCese());
            cs.setInt(6, x.getIdTrabajador());
            cs.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Error DAO: registrarPerfil... " + ex.getMessage());
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
                System.out.println("Error SQLException: registrarPerfil.... " + ex.getMessage());
            }

        }
    }

    //  Metodo para cargar tabla de perfile
    public void listarPerfilLaboral(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_perfil";
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
            System.out.println("ERROR DAO: listarPerfilLaboral... " + e.getMessage());
        } finally {

            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: listarPerfilLaboral... " + ex.getMessage());
            }

        }
    }

    //  Metodo para consultar perfil por cod
    public PerfilLaboral consultarPerfil(int cod) {
        cn = getConexion();
        PerfilLaboral perfilLaboral = null;
        String sql = "select * from perfilLaboral where codPerfil = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()) {
                Date fechaIngreso = rs.getDate("fechaIngreso");
                String area = rs.getString("area");
                double sueldo = rs.getDouble("sueldo");
                Date fechaCese = rs.getDate("fechaCese");
                String motivoCese = rs.getString("motivoCese");
                int idTrabajador = rs.getInt("idTrabajador");
                Trabajador trabajador = TrabajadorDAO.getInstancia().consultarTrabajador(idTrabajador);

                perfilLaboral = new PerfilLaboral(fechaIngreso, area, sueldo, fechaCese, motivoCese, trabajador);
            }
        } catch (Exception e) {
            System.out.println("ERROR DAO: consultarPerfil... " + e.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: consultarPerfil... " + ex.getMessage());
            }
        }
        return perfilLaboral;
    }
}
