package Models;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class GuardiaDAO extends Conexion {

    //  Atributos de la clase conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Instancia de la clase TrabajadorDAO
    private static GuardiaDAO instancia;

    public static GuardiaDAO getInstancia() {
        if (instancia == null) {
            instancia = new GuardiaDAO();
        }
        return instancia;
    }

    //  Metodo para registrar guardia
    public boolean registrarGuardia(Guardia x) {
        cn = getConexion();
        String sql = "call usp_registrar_guardia(?,?)";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getNombreGuardia());
            cs.setInt(2, x.getCodTurno());
            cs.executeQuery();
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: registrarGuardia... " + e.getMessage());
            return false;
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: registrarGuardia... " + e.getMessage());
            }
        }
    }

    //  Metodo para listar guardias
    public void listarGuardias(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_guardias";
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
            System.out.println("Error DAO: listarGuardias... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarGuardias... " + e.getMessage());
            }
        }
    }

    //  Metodo para consultar guardias por codigo
    public Guardia consultarGuardia(int cod) {
        cn = getConexion();
        Guardia guardia = null;
        String sql = "select * from guardia where codGuardia = ? ";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()) {
                String nombreGuardia = rs.getString("nombreGuardia");
                int codTurno = rs.getInt("codTurno");
                Turno turno = TurnoDAO.getInstancia().consultarTurno(codTurno);

                guardia = new Guardia(nombreGuardia, turno);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DAO: consultarGuardia... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: consultarGuardia... " + ex.getMessage());
            }
        }
        return guardia;
    }

    //  Metodo para validar existencia de guardia
    public int existeGuardia(String nombreGuardia, int codTurno) {
        cn = getConexion();
        String sql = "select count(codGuardia) from guardia where nombreGuardia =? and codTurno = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombreGuardia);
            ps.setInt(2, codTurno);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (Exception e) {
            System.out.println("Error DAO: existeGuardia... " + e.getMessage());
            return 1;
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: existeGuardia... " + ex.getMessage());
            }
        }
    }

    //  Metodo para listar guardias en el selector de guardias
    public void listarGuardiasDialog(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_guardias_dialog";
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
            System.out.println("Error DAO: listarGuardiasDialog... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarGuardiasDialog... " + e.getMessage());
            }
        }
    }

    //  Metodo para filtrar busqueda de nombres de trabajadores en el Dialog Selector de trabajadores
    public void filtrarBusquedaSelector(String nombre, DefaultTableModel model) {
        cn = getConexion();
        model.getDataVector().removeAllElements();
        String sql = "select * from listar_guardias_dialog where nombreGuardia like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            rsmd = (ResultSetMetaData) rs.getMetaData();
            while (rs.next()) {
                int codGuardia = rs.getInt("codGuardia");
                String nombreGuardia = rs.getString("nombreGuardia");
                String nombreTurno = rs.getString("nombreTurno");
                String fila[] = {String.valueOf(codGuardia), nombreGuardia, nombreTurno};
                model.addRow(fila);
            }
        } catch (Exception ex) {
            System.out.println("Error DAO: filtrarBusqueda ..." + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: filtrarBusqueda ... " + e.getMessage());
            }
        }
    }
}
