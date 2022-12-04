package Models;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class TurnoDAO extends Conexion {

    //  Atributos de la clase Conexion
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;
    private ResultSetMetaData rsmd = null;

    //  Instancia de la clase turnoDAO
    private static TurnoDAO instancia;

    public static TurnoDAO getInstancia() {
        if (instancia == null) {
            instancia = new TurnoDAO();
        }
        return instancia;
    }

    // Metodo para listarTurnos
    public void listarTurnos(DefaultTableModel model) {
        cn = getConexion();
        int columnas;
        String sql = "select * from listar_turnos";
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
            System.out.println("Error DAO: listarTurnos... " + e.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error SQLException: listarTurnos... " + e.getMessage());
            }
        }
    }

    //  Metodo para modificar turnos
    public boolean modificarTurno(Turno x) {
        cn = getConexion();
        String sql = "update turno set nombreTurno = ?, horaEntrada = ?, horaSalida = ? where codTurno =  ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getNombreTurno());
            ps.setString(2, x.getHoraEntrada());
            ps.setString(3, x.getHoraSalida());
            ps.setInt(4, x.getCodTurno());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error DAO: modificarTurno... " + e.getMessage());
            return false;
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SQLException: modificarTurno... " + ex.getMessage());
            }
        }
    }

    //  Metodo para consultar turno por su codigo
    public Turno consultarTurno(int cod) {
        cn = getConexion();
        Turno turno = null;
        String sql = "select * from turno where codTurno = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cod);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()) {
                String nombreTurno = rs.getString("nombreTurno");
                String horaEntrada = rs.getString("horaEntrada");
                String horaSalida = rs.getString("horaSalida");
                turno = new Turno(nombreTurno, horaEntrada, horaSalida);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DAO: consultarTurno ... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SLQException: consultarTurno ... " + ex.getMessage());
            }
        }
        return turno;
    }
}
