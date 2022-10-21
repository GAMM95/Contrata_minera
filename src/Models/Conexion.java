package Models;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    //  Instancia de la clase conexion
    private static Conexion instancia;

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();

        }
        return instancia;
    }

    //  Constructor vacio de la clase
    public Conexion() {

    }

    //  Atributos estaticos
    public static final String url = "jdbc:mysql://localhost:3306/ContrataMinera";
    public static final String user = "root";
    public static final String pass = "abc123";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //  Driver mysql
            con = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    //  Metodo main para comprobar la conexion
    public static void main(String[] argumentos) {
        try {
            JOptionPane.showMessageDialog(null, Conexion.getInstancia().getConexion(), "Conexion establecida", JOptionPane.INFORMATION_MESSAGE);    //  Mensaje exitoso
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion\nRevisar Driver" + ex.getMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE); // Mensaje de error

        }
    }
}
