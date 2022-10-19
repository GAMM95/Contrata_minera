package Modelo;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class FotosDAO extends Conexion {

    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;

    private static FotosDAO instancia;

    public static FotosDAO getInstancia() {
        if (instancia == null) {
            instancia = new FotosDAO();
        }
        return instancia;
    }

    public void insertarFoto(Fotos p, FileInputStream foto, int longitudBytes) throws SQLException {
        cn = getConexion();
        String sql = "{call registrar(?,?)}"; // p_nombre varchar(10), p_foto longblob
        try {
            cs = cn.prepareCall(sql);
            cs.setString(1, p.getNombre());
            cs.setBlob(2, foto, longitudBytes);
            cs.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error al guardar foto: " + ex.getMessage());
        } finally {
            cn.close();
            cs.close();
        }
    }

    public ImageIcon getFoto(int id) {
        cn = getConexion();
        String sql = "select foto from prueba where id= " + id;
        ImageIcon ii = null;
        InputStream is = null;
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                is = rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                ii = new ImageIcon(bi);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ii;
    }

    public Fotos buscarFoto(int id) throws SQLException {
        cn = getConexion();
        Fotos fotos = null;
        try {
            String sql = "select * from prueba where id= ?";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                fotos = new Fotos(id, nombre);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            cn.close();
            ps.close();
        }
        return fotos;
    }
}
