package Controllers;

import Models.Cargo;
import Models.CargoDAO;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Views.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TrabajadorController implements ActionListener, MouseListener {

    Cargo cargo = null;

    //  Instancias de clases
    private CargoDAO caDAO;
    private Trabajador tra;
    private TrabajadorDAO traDAO;
    private FrmMenu frmMenu;

    public TrabajadorController(CargoDAO caDAO, Trabajador tra, TrabajadorDAO traDAO, FrmMenu frmMenu) {
        this.caDAO = caDAO;
        this.tra = tra;
        this.traDAO = traDAO;
        this.frmMenu = frmMenu;
        interfaces();
        diseñoPanel();
        limpiarInputs();
        try {
            llenarCargos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    //  Metodo para llenar cargos en el comboBox 
    public void llenarCargos() throws SQLException {
        HashMap<String, Integer> map = caDAO.populateCombo();
        for (String s : map.keySet()) {
            frmMenu.cboCargo.addItem(s);
        }
    }

    //  Metodo para incorporar las interfaces implementadas
    private void interfaces() {
        frmMenu.btnRegistrarTrabajador.addActionListener(this);
        frmMenu.lblFotoTrabajador.addMouseListener(this);

    }

    //  Metodo de diseño del panel Trabajador
    private void diseñoPanel() {

    }

    //  MEtodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtDni.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(frmMenu.lblFotoTrabajador)) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.out.println("Error de lookAndFeel: " + ex.getMessage());
            }

            JFileChooser se = new JFileChooser();
            se.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int estado = se.showOpenDialog(null);
            if (estado == JFileChooser.APPROVE_OPTION) {
                String ruta = se.getSelectedFile().getAbsolutePath();

            }

        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
}
