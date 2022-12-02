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
}
