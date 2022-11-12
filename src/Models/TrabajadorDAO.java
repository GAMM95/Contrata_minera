package Models;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class TrabajadorDAO extends Conexion {

    //  Atributos de la clase
    private Connection cn = null;
    private ResultSet rs = null;
    private CallableStatement cs = null;
    private PreparedStatement ps = null;

    //  Establecer formato para el ingreso de la fecha
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    //  Instancia de la clase TrabajadorDAO
    private static TrabajadorDAO instancia;

    public static TrabajadorDAO getInstancia() {
        if (instancia == null) {
            instancia = new TrabajadorDAO();
        }
        return instancia;
    }

    //  Metodo para registrar Trabajador
    public boolean registrarTrabajador(Trabajador x) {
        cn = getConexion();
        String sql = "{call usp_registrar_trabajador(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            cn.setAutoCommit(true);
            cs = cn.prepareCall(sql);
            cs.setString(1, x.getDni());
            cs.setString(2, x.getApePaterno());
            cs.setString(3, x.getApeMaterno());
            cs.setString(4, x.getNombres());
            cs.setString(5, x.getSexo());
            cs.setString(6, x.getEstadoCivil());
            if (x.getFechaNacimiento() != null) {
                cs.setDate(7, java.sql.Date.valueOf(df.format(x.getFechaNacimiento())));
            } else {
                cs.setDate(7, null);
            }
            cs.setString(8, x.getDireccion());
            cs.setString(9, x.getTelefono());
            cs.setString(10, x.getGradoInstruccion());
            cs.setString(11, x.getProfesion());
            cs.setBytes(12, x.getFoto());
            cs.setInt(13, x.getCodCargo());
            cs.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("DAO ERROR de registro de trabajador " + ex.getMessage());
            return false;
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                System.out.println("Error DAO" + e.getMessage());
            }

        }
    }

    //  Metodo para validar existencia de dni
    public int existeDNI(String dni) {
        cn = getConexion();
        String sql = "select count(idTrabajador) from trabajador where dni = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERROR de existencia de dni: " + ex.getMessage()); //Propagar la excepcion
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
                System.out.println("Error de finally en existeDNI: " + ex.getMessage());
            }
        }
    }

    //  Metodo para validar existencia de telefono de celular
    public int existeTelefono(String telefono) {
        cn = getConexion();
        String sql = "select count(idTrabajador) from trabajador where telefono =?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, telefono);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            System.out.println("ERROR de existencia de telefono: " + ex.getMessage()); //Propagar la excepcion
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
                System.out.println("Error de finally en telefono: " + ex.getMessage());
            }
        }
    }

    //metodo para cargar la tabla de cargos
    public void listarTrabajadores(DefaultTableModel modelo1) throws SQLException {
        cn = getConexion();
        String titulos[] = {"DNI", "TRABAJADOR", "DIRECCION", "TELEFONO", "CARGO"};
        modelo1.getDataVector().removeAllElements();
        modelo1.setColumnIdentifiers(titulos);
        try {
            String sql = "select * from listar_trabajadores";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Trabajador x = new Trabajador();
                Cargo c = new Cargo();
                x.setDni(rs.getString("dni"));
                String trabajador = rs.getString("Trabajador");
                x.setDireccion(rs.getString("direccion"));
                x.setTelefono(rs.getString("telefono"));
                c.setNombreCargo(rs.getString("nombreCargo"));
                String fila[] = {x.getDni(), trabajador, x.getDireccion(), x.getTelefono(), c.getNombreCargo()};
                modelo1.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR listarCargos: " + ex.getMessage());
        } finally {
            ps.close();
            cn.close();
        }
    }

    //metodo para cargar la tabla de cargos
    public void listarTrabajadoresDialog(DefaultTableModel modelo) {
        cn = getConexion();
        String titulos[] = {"DNI", "TRABAJADOR", "DIRECCION", "TELEFONO", "CARGO", "ESTADO"};
        modelo.getDataVector().removeAllElements();
        modelo.setColumnIdentifiers(titulos);
        try {
            String sql = "select * from listar_trabajador_dialog";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Trabajador x = new Trabajador();
                Cargo c = new Cargo();
                x.setDni(rs.getString("dni"));
                String trabajador = rs.getString("Trabajador");
                x.setDireccion(rs.getString("direccion"));
                x.setTelefono(rs.getString("telefono"));
                c.setNombreCargo(rs.getString("nombreCargo"));
//                x.setEstado
                String fila[] = {x.getDni(), trabajador, x.getDireccion(), x.getTelefono(), c.getNombreCargo()};
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR listarCargos: " + ex.getMessage());
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (Exception e) {
            }

        }
    }

    //  Metodo para llenar comboBox en otros formularios que necesiten escoger al trabajador
    public void llenarComboTrabajador(JComboBox cboTrabajador) {
        cn = getConexion();
        String sql = "select idTrabajador, concat(apePaterno, ' ', apeMaterno, ' ', nombres) Trabajador from trabajador";
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            cboTrabajador.removeAllItems();
            while (rs.next()) {
                cboTrabajador.addItem(new Cargo(rs.getInt("idTrabajador"), rs.getString("Trabajador")));
            }
        } catch (SQLException ex) {
            System.out.println("Error de llenar combo de trabajador: " + ex.getMessage());
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
                System.out.println("Error cerrar conexiones llenarComboTrabajador: " + ex.getMessage());
            }
        }
    }
//    public void llenarComboTrabajador(JComboBox cbo) {
//        cn = getConexion();
//        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
//        modelo.addElement("seleccionar");
//        String sql = "select idTrabajador, concat(apePaterno, ' ', apeMaterno, ' ', nombres) Trabajador from trabajador";
//        try {
//            ps = cn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            cbo.removeAllItems();
//            if (rs.next()) {
//                cbo.addItem(new Cargo(rs.getInt("idTrabajador"), rs.getString("Trabajador")));
//            }
//        } catch (SQLException ex) {
//            System.out.println("Error de llenar combo de trabajador: " + ex.getMessage());
//        } finally {
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (rs != null) {
//                    rs.close();
//                }
//                if (cn != null) {
//                    cn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println("Error cerrar conexiones llenarComboTrabajador: " + ex.getMessage());
//            }
//        }
//    }
}
