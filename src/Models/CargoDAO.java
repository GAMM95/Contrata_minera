package Models;

import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.sql.*;
import java.util.HashMap;
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
            } catch (SQLException ex) {
                System.out.println("ERROR FINALLY: conexion HashMap..." + ex.getMessage());
            }
        }
        return map;
    }

    // Metodo para ingresar nuevos cargos
    public void registrarCargo(Cargo x) {
        cn = getConexion();
        try {
            cn.setAutoCommit(true); //cancelar el control de transacciones
            String query = "{call usp_registrar_cargo(?,?)}";
            cs = cn.prepareCall(query);
            cs.setString(1, x.getNombreCargo());
            cs.setString(2, x.getCategoria());
            cs.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR DAO: registrarCargo... " + ex.getMessage()); //Propagar la excepcion
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR FINALLY: registrarCargo..." + ex.getMessage());
            }
        }
    }

    //  Metodo para cargar la tabla de cargos
    public void listarCargos(DefaultTableModel model) {
        cn = getConexion();
        String sql = "select * from listar_cargos";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DAO: listarCargos... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR FINALLY: listarCargos... " + ex.getMessage());
            }
        }
    }

    //  Metodo para mostrar cargos en la tabla del Dialog Selector de cargos
    public void listarCargosDialog(DefaultTableModel model) {
        cn = getConexion();
        String titulos[] = {"COD", "CARGO"};
        model.getDataVector().removeAllElements();
        model.setColumnIdentifiers(titulos);
        try {
            String sql = "select * from listar_cargos_dialog";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargo x = new Cargo();
                x.setCodigo(rs.getInt("codcargo"));
                x.setNombreCargo(rs.getString("nombreCargo"));
                String fila[] = {String.valueOf(x.getCodigo()), x.getNombreCargo()};
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DAO: listarCargosDialog... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error SQLException: " + ex.getMessage());
            }
        }
    }

    //  Metodo para validar existencia de cargo
    public int existeCargo(String nombreCargo) {
        cn = getConexion();
        String sql = "select count(codCargo) from cargo where nombreCargo=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombreCargo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERROR DAO: existeCargo... " + ex.getMessage());
            return 1;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR Finally: existeCargo... " + ex.getMessage());
            }
        }
    }

    //  Metodo para editar y actualizar informacion de los cargos
    public boolean modificarCargos(Cargo x) {
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
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
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
    public void buscarCargo(String nombre, DefaultTableModel model) {
        cn = getConexion();
        String titulos[] = {"COD", "CARGO"};
        model.getDataVector().removeAllElements();
        model.setColumnIdentifiers(titulos);
        String sql = "select * from cargo where nombreCargo like ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int codCargo = rs.getInt("codCargo");
                String nombreCargo = rs.getString("nombreCargo");
                String fila[] = {String.valueOf(codCargo), nombreCargo};
                model.addRow(fila);
            }
//            return true;
        } catch (SQLException ex) {
            System.out.println("Error DAO: buscarCargo ..." + ex.getMessage());
//            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();;
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("Error cerrar conexion: BuscarCargo DAO... " + e.getMessage());
            }

        }
    }

    //  Metodo para consultar cargos
    public Cargo consultarCargo(int codigo) {
        cn = getConexion();
        Cargo cargo = null;
        String sql = "select * from cargo where codCargo = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                String nombre = rs.getString("nombreCargo");
                String categoria = rs.getString("categoria");
                cargo = new Cargo(codigo, nombre, categoria);
            }
        } catch (Exception ex) {
            System.out.println("ERROR DAO: consultarCargo ... " + ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("ERROR SLQException: mostrarCargos ... " + ex.getMessage());
            }
        }
        return cargo;
    }
}
