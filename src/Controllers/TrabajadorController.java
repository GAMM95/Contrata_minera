package Controllers;

import Models.Cargo;
import Models.CargoDAO;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TrabajadorController implements ActionListener, MouseListener, KeyListener {

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
        limpiarMensajesError();
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
        //  Eventos ActionListener
        frmMenu.btnRegistrarTrabajador.addActionListener(this);
        frmMenu.lblFotoTrabajador.addMouseListener(this);

        //  Eventos KeyListener
        frmMenu.txtDni.addKeyListener(this);
        frmMenu.txtApePaterno.addKeyListener(this);

        //  Eventos MouseListener
        frmMenu.opFemenino.addMouseListener(this);
        frmMenu.opMasculino.addMouseListener(this);
        frmMenu.opSoltero.addMouseListener(this);
        frmMenu.opCasado.addMouseListener(this);
        frmMenu.opConviviente.addMouseListener(this);
        frmMenu.opPrimaria.addMouseListener(this);
        frmMenu.opSecundaria.addMouseListener(this);
        frmMenu.opTecnico.addMouseListener(this);
        frmMenu.opUniversitaria.addMouseListener(this);
    }

    //  Metodo de diseño del panel Trabajador
    private void diseñoPanel() {

    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtDni.setText("");
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mDni.setText("");
        frmMenu.mApePaterno.setText("");
        frmMenu.mApeMaterno.setText("");
        frmMenu.mNombresTrabajador.setText("");
        frmMenu.mTelefono.setText("");
        frmMenu.mGenero.setText("");
        frmMenu.mEstadoCivil.setText("");
        frmMenu.mDireccion.setText("");
        frmMenu.mGradoInstruccion.setText("");
        frmMenu.mProfesion.setText("Opcional");
        frmMenu.mProfesion.setForeground(Color.green);
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmMenu.txtDni.getText().trim().equals("")) {
            frmMenu.mDni.setText("Ingrese DNI");
            frmMenu.mDni.setForeground(Color.red);
            frmMenu.txtDni.requestFocus();
            action = false;
        } else if (frmMenu.txtApePaterno.getText().trim().equals("")) {
            frmMenu.mApePaterno.setText("Ingrese apellido paterno");
            frmMenu.mApePaterno.setForeground(Color.red);
            frmMenu.txtApePaterno.requestFocus();
            action = false;
        } else if (frmMenu.txtApeMaterno.getText().trim().equals("")) {
            frmMenu.mApeMaterno.setText("Ingrese apellido materno");
            frmMenu.mApeMaterno.setForeground(Color.red);
            frmMenu.txtApeMaterno.requestFocus();
            action = false;
        } else if (frmMenu.txtNombreTrabajador.getText().trim().equals("")) {
            frmMenu.mNombresTrabajador.setText("Ingrese nombres");
            frmMenu.mNombresTrabajador.setForeground(Color.red);
            frmMenu.txtNombreTrabajador.requestFocus();
            action = false;
        } else if (frmMenu.txtTelefono.getText().trim().equals("")) {
            frmMenu.mTelefono.setText("Ingresar telefono");
            frmMenu.mTelefono.setForeground(Color.red);
            frmMenu.txtTelefono.requestFocus();
            action = false;
        } else if (frmMenu.Genero.isSelected(null)) {
            frmMenu.mGenero.setText("Marque una opción");
            frmMenu.mGenero.setForeground(Color.red);
            action = false;
        } else if (frmMenu.EstadoCivil.isSelected(null)) {
            frmMenu.mEstadoCivil.setText("Marque una opción");
            frmMenu.mEstadoCivil.setForeground(Color.red);
            action = false;
        } else if (frmMenu.txtDireccion.getText().trim().equals("")) {
            frmMenu.mDireccion.setText("Ingrese dirección domiciliaria");
            frmMenu.mDireccion.setForeground(Color.red);
            frmMenu.txtDireccion.requestFocus();
            action = false;
        } else if (frmMenu.GradoIntruccion.isSelected(null)) {
            frmMenu.mGradoInstruccion.setText("Marque una opción");
            frmMenu.mGradoInstruccion.setForeground(Color.red);
            action = false;
        } else if (frmMenu.lblFotoTrabajador.getText().equals("FOTO")) {
            frmMenu.mFotoTrabajador.setText("Seleecione foto del trabajador");
            frmMenu.mFotoTrabajador.setForeground(Color.red);
            action = false;
        }
        return action;
    }

    //  Metodo para validar existencia de dni
    private boolean validarExistenciaDNI() {
        boolean valor = true;   //  Valor inicial verdadero
        if (traDAO.existeDNI(frmMenu.txtDni.getText()) != 0) {
            frmMenu.mDni.setText("DNI ya existe");
            frmMenu.mDni.setForeground(Color.red);
            frmMenu.txtDni.requestFocus();
            valor = false;
        }
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmMenu.btnRegistrarTrabajador)) {
            //  validaciones
            boolean validarVacios = validarCamposVacios();
            boolean validarDNI = validarExistenciaDNI();

            if (validarVacios == false) {
                validarCamposVacios();
            } else {
                if (validarDNI == false) {
                    validarExistenciaDNI();
                    frmMenu.txtDni.setText("");
                } else {
                    tra.setDni(frmMenu.txtDni.getText().trim());
                    tra.setApePaterno(frmMenu.txtApePaterno.getText().trim());
                    tra.setApeMaterno(frmMenu.txtApeMaterno.getText().trim());
                    tra.setNombres(frmMenu.txtNombreTrabajador.getText().trim());
                    tra.setTelefono(frmMenu.txtTelefono.getText().trim());
                    String genero;
                    if (frmMenu.opFemenino.isSelected()) {
                        genero = "Femenino";
                    } else {
                        genero = "Masculino";
                    }
                    tra.setSexo(genero);
                    String estadoCivil;
                    if (frmMenu.opSoltero.isSelected()) {
                        estadoCivil = "Soltero";

                    } else if (frmMenu.opCasado.isSelected()) {
                        estadoCivil = "Casado";
                    } else {
                        estadoCivil = "Conviviente";
                    }
                    tra.setEstadoCivil(estadoCivil);
                    tra.setDireccion(frmMenu.txtDireccion.getText().trim());
                    String gradoInstruccion;
                    if (frmMenu.opPrimaria.isSelected()) {
                        gradoInstruccion = "Primaria completa";
                    } else if (frmMenu.opSecundaria.isSelected()) {
                        gradoInstruccion = "Secundaria completa";
                    } else if (frmMenu.opTecnico.isSelected()) {
                        gradoInstruccion = "Técnico";
                    } else {
                        gradoInstruccion = "Universitaria";
                    }
                    tra.setGradoInstruccion(gradoInstruccion);
                    tra.setProfesion(frmMenu.txtProfesion.getText().trim());
                    try {
                        traDAO.registrarTrabajador(tra);
                    } catch (SQLException ex) {
                        System.out.println("Error de registrar trabajador frmMenu: " + ex.getMessage());
                    }
                }
            }
        }
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
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(frmMenu.txtDni)) {
            frmMenu.mDni.setText("");
        } else if (e.getSource().equals(frmMenu.txtApePaterno)) {
            frmMenu.mApePaterno.setText("");
        } else if (e.getSource().equals(frmMenu.txtApeMaterno)) {
            frmMenu.mApeMaterno.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource().equals(frmMenu.opFemenino) || e.getSource().equals(frmMenu.opMasculino)) {
            frmMenu.mGenero.setText("");
        } else if (e.getSource().equals(frmMenu.opSoltero) || e.getSource().equals(frmMenu.opCasado) || e.getSource().equals(frmMenu.opConviviente)) {
            frmMenu.mEstadoCivil.setText("");
        } else if (e.getSource().equals(frmMenu.opPrimaria) || e.getSource().equals(frmMenu.opSecundaria) || e.getSource().equals(frmMenu.opTecnico) || e.getSource().equals(frmMenu.opUniversitaria)) {
            frmMenu.mGradoInstruccion.setText("");
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
