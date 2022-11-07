package Models;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CargoDAO extends Conexion {

    //  Atributos
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;

    //  Instancia de la clase cargoDAO
    private static CargoDAO instancia;

    public static CargoDAO getInstancia() {
        if (instancia == null) {
            instancia = new CargoDAO();
        }
        return instancia;
    }

    //  Metodo para llenar el comboBox Cargo en el panel de RegistrarTrabajador
    public HashMap<String, Integer> populateCombo() {
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> map = new HashMap<>();
        cn = getConexion();
        Statement st;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("select codCargo, nombreCargo from cargo");
            while (rs.next()) {
                Cargo c;
                c = new Cargo(rs.getInt(1), rs.getString(2));
                map.put(c.getNombreCargo(), c.getCodigo());
            }
        } catch (SQLException ex) {
            System.out.println("Error de hashmap: " + ex.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch(SQLException ex)  {
                System.out.println("Error finalizar conexion HashMap: " + ex.getMessage());
            }
        }
        return map;

    }

    // Metodo para ingresar nuevos cargos
    public void registrarCargo(Cargo x) throws SQLException {
        cn = getConexion();
        try {
            cn.setAutoCommit(true); //cancelar el control de transacciones
            String query = "{call usp_registrar_cargo(?,?)}";
            cs = cn.prepareCall(query);
            cs.setString(1, x.getNombreCargo());
            cs.setString(2, x.getCategoria());
            cs.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage()); //Propagar la excepcion
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    //  Metodo para cargar la tabla de cargos
    public void listarCargos(DefaultTableModel modelo) throws SQLException {
        cn = getConexion();
        String titulos[] = {"COD", "CARGO", "CATEGORÍA"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql = "select * from listar_cargos";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargo x = new Cargo();
                x.setCodigo(rs.getInt("codcargo"));
                x.setNombreCargo(rs.getString("nombreCargo"));
                x.setCategoria(rs.getString("categoria"));
                String fila[] = {String.valueOf(x.getCodigo()), x.getNombreCargo(), x.getCategoria()};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR listarCargos: " + ex.getMessage());
        } finally {
            ps.close();
            cn.close();
        }
    }

    //  Metodo para editar y actualizar informacion de los cargos
    public boolean modificarCargos(Cargo x) throws SQLException {
        cn = getConexion();
        String sql = "Update cargo set nombreCargo = ?, categoria = ? where codCargo = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, x.getNombreCargo());
            ps.setString(2, x.getCategoria());
            ps.setInt(3, x.getCodigo());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR de modificar cargo: " + ex.getMessage());
            return false;
        } finally {
            if (cs != null) {
                cs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
    }

    //  Metodo para eliminar cargo seleccionado
    public boolean eliminarCargos(int codigo) throws SQLException {
        cn = getConexion();
        String sql = "delete from cargo where codCargo=?";
        try {
            cs = cn.prepareCall(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("Error de eliminacion: " + ex.getMessage());
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

    // Validar ingreso de digitos
    public static void soloDigitos(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo dígitos", " Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Validar ingreso de letras
    public static void soloLetras(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras", " Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //metodo para agregar los nombres de los conductores al combo box
//    public DefaultComboBoxModel llenarCombo() {
//        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
//        modelo.addElement("seleccionar");
//        ResultSetMetaData rsmd = null;
//        String sql = "select codCargo, nombreCargo from cargo";
//        try {
//            cn = getConexion();
//            ps = cn.prepareStatement(sql);
//            rs = ps.executeQuery(); //ejecutar la consulta
//            rsmd = rs.getMetaData(); //traer los datos de la consulta
//            while (rs.next()) {      //realizamos el recorrido          
//                modelo.addElement(rs.getString(2)); //agregamos los datos encontrados
//            }
//        } catch (SQLException ex) {
//            System.out.println("ERROR de llenado de combo: " + ex.getMessage()); //Propagar la excepcion
//        }
//        return modelo;
//    }
//    public void llenarCombo(JComboBox cboCargo) throws SQLException {
//        cn = getConexion();
//        String sql = "select codCargo, nombreCargo from cargo";
//        try {
//            ps = cn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            cboCargo.removeAllItems();
//            while (rs.next()) {
//                cboCargo.addItem(new Cargo(rs.getInt("codCargo"), rs.getString("nombreCargo")));
//            }
//        } catch (SQLException ex) {
//            System.out.println("ERROR: " + ex.getMessage()); //Propagar la excepcion
//        } finally {
//            if (ps != null) {
//                ps.close();
//            }
//            if (rs != null) {
//                rs.close();
//            }
//            if (cn != null) {
//                cn.close();
//            }
//        }
//    }
}
