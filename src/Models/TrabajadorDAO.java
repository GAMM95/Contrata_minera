package Models;

import java.sql.*;

public class TrabajadorDAO extends Conexion {

    //  Atributos de la clase
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;

    //  Instancia de la clase TrabajadorDAO
    private static TrabajadorDAO instancia;

    public static TrabajadorDAO getInstancia() {
        if (instancia == null) {
            instancia = new TrabajadorDAO();
        }
        return instancia;
    }

    //  Metodo para registrar Trabajador
    public boolean registrarTrabajador(Trabajador x) throws SQLException {
        cn = getConexion();
        String sql = "insert into trabajador (dni, apePaterno, apeMaterno, nombres, sexo, estadoCivil, fechaNacimiento, direccion, telefono, gradoInstruccion, profesion, foto, codCargo) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getDni());
            ps.setString(2, x.getApePaterno());
            ps.setString(3, x.getApeMaterno());
            ps.setString(4, x.getNombres());
            ps.setString(5, x.getSexo());
            ps.setString(6, x.getEstadoCivil());
            if (x.getFechaNacimiento() != null) {
                cs.setDate(7, new java.sql.Date(x.getFechaNacimiento().getTime()));
            } else {
                cs.setDate(7, null);
            }
            ps.setString(8, x.getDireccion());
            ps.setString(9, x.getTelefono());
            ps.setString(10, x.getGradoInstruccion());
            ps.setString(11, x.getProfesion());
            ps.setBytes(12, x.getFoto());
            ps.setInt(13, x.getCodCargo());
            ps.executeQuery();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR de registro de trabajador " + ex.getMessage());
            return false;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }
}
