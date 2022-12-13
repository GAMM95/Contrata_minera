package Models;

import java.sql.*;

public class EmpresaDAO extends Conexion {

    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;

    /*Metodo agregar datos*/
    public void agregar(Empresa e) {
        cn = getConexion();
        String sql = "call usp_registrarEmpresa(?,?,?,?,?,?,?,?,?,?)";
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, e.getRuc());
            cs.setString(2, e.getRazonSocial());
            cs.setString(3, e.getCiiu());
            cs.setString(4, e.getTelefono());
            cs.setString(5, e.getCelular());
            cs.setString(6, e.getDireccionLegal());
            cs.setString(7, e.getEmail());
            cs.setString(8, e.getPaginaWeb());
            cs.setBytes(9, e.getLogo());
            cs.setString(10, e.getPath());
            cs.executeUpdate();
        } catch (Exception ex) {
            System.out.println("A " + ex.getMessage());
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: agregar... " + ex.getMessage());
            }
        }
    }

    public Empresa mostrarDatos(int id) {
        cn = getConexion();
        Empresa empresa = null;
        try {
            String sql = "select * from empresa where codEmpresa = ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String ruc = rs.getString("ruc");
                String razonSocial = rs.getString("razonSocial");
                String ciiu = rs.getString("ciiu");
                String telefono = rs.getString("telefono");
                String celular = rs.getString("celular");
                String direccionLegal = rs.getString("direccionLegal");
                String email = rs.getString("email");
                String paginaWeb = rs.getString("paginaWeb");
                byte[] logo = rs.getBytes("logo");
                String path = rs.getString("ruta");
                empresa = new Empresa(ruc, razonSocial, ciiu, telefono, celular, direccionLegal, email, paginaWeb, logo, path);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR de busqueda: " + ex.getMessage());
        } finally {
            try {
                cn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error de finally" + ex.getMessage());
            }

        }
        return empresa;
    }

    //    /*Metodo Modificar*/
    public void modificar_EmpresaConFoto(Empresa e) {
        cn = getConexion();
        String sql = "UPDATE empresa SET ruc = ?, razonSocial = ?, ciiu = ?,telefono = ?, celular = ?, direccionLegal = ?, email = ?, paginaWeb = ?, logo = ?, ruta = ? WHERE codEmpresa = ?";

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getRuc());
            ps.setString(2, e.getRazonSocial());
            ps.setString(3, e.getCiiu());
            ps.setString(4, e.getTelefono());
            ps.setString(5, e.getCelular());
            ps.setString(6, e.getDireccionLegal());
            ps.setString(7, e.getEmail());
            ps.setString(8, e.getPaginaWeb());
            ps.setBytes(9, e.getLogo());
            ps.setString(10, e.getPath());
            ps.setInt(11, e.getCodEmpresa());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error finally modificar_Empresa: " + ex.getMessage());
            }
        }
    }

    public void modificar_EmpresaSinFoto(Empresa e) {
        cn = getConexion();
        String sql = "UPDATE empresa SET ruc = ?, razonSocial = ?, ciiu = ?,telefono = ?, celular = ?, direccionLegal = ?, email = ?, paginaWeb = ? WHERE codEmpresa = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, e.getRuc());
            ps.setString(2, e.getRazonSocial());
            ps.setString(3, e.getCiiu());
            ps.setString(4, e.getTelefono());
            ps.setString(5, e.getCelular());
            ps.setString(6, e.getDireccionLegal());
            ps.setString(7, e.getEmail());
            ps.setString(8, e.getPaginaWeb());
            ps.setInt(9, e.getCodEmpresa());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error finally modificar_Empresa2: " + ex.getMessage());
            }
        }
    }

}
