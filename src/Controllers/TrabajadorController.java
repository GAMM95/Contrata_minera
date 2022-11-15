package Controllers;

import Models.Cargo;
import Models.CargoDAO;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Models.Validaciones;

import Views.FrmMenu;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.Date;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

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
        cargarTabla();
    }

    //  Metodo para llenar cargos en el comboBox 
//    public void llenarCargos() {
//        HashMap<String, Integer> map = caDAO.populateCombo();
//        map.keySet().forEach((s) -> {
//            frmMenu.cboCargo.addItem(s);
//        });//        HashMap<String, Integer> map = caDAO.populateCombo();
////        for (String s : map.keySet()) {
////            frmMenu.cboCargo.addItem(s);
////        }
//    }
    //  Metodo para incorporar las interfaces implementadas
    private void interfaces() {
        //  Eventos ActionListener
        frmMenu.btnRegistrarTrabajador.addActionListener(this);
        frmMenu.opFemenino.addActionListener(this);
        frmMenu.opMasculino.addActionListener(this);
        frmMenu.opSoltero.addActionListener(this);
        frmMenu.opCasado.addActionListener(this);
        frmMenu.opConviviente.addActionListener(this);
        frmMenu.opPrimaria.addActionListener(this);
        frmMenu.opSecundaria.addActionListener(this);
        frmMenu.opTecnico.addActionListener(this);
        frmMenu.opUniversitaria.addActionListener(this);
//        frmMenu.cboCargo.addActionListener(this);
//        frmMenu.btnSeleccionarCargo.addActionListener(this); //No funciona el selector
        //  Eventos KeyListener
        frmMenu.txtDni.addKeyListener(this);
        frmMenu.txtFechaNacimiento.addKeyListener(this);
        frmMenu.txtApePaterno.addKeyListener(this);
        frmMenu.txtApeMaterno.addKeyListener(this);
        frmMenu.txtNombreTrabajador.addKeyListener(this);
        frmMenu.txtTelefono.addKeyListener(this);
        frmMenu.txtDireccion.addKeyListener(this);
        frmMenu.txtProfesion.addKeyListener(this);
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
        frmMenu.lblFotoTrabajador.addMouseListener(this);
        frmMenu.txtFechaNacimiento.addMouseListener(this);
        frmMenu.tblTrabajadores.addMouseListener(this);
    }

    //  Metodo de diseño del panel Trabajador
    private void diseñoPanel() {
        frmMenu.mProfesion.setText("Opcional");
        frmMenu.mProfesion.setForeground(new Color(3, 155, 216));
        frmMenu.txtCodCargoAsignado.setForeground(Color.white); //  color blanco de codCargo
        frmMenu.mFotoTrabajador.setText("Click en FOTO para seleccionar");
        frmMenu.mFotoTrabajador.setForeground(new Color(3, 155, 216));
    }

    //  Metodo para diseñar tabla trabajadores del panel "Nuevo trabajador"
    private void diseñoTabla() {
        DefaultTableModel model = new DefaultTableModel();

        model.setRowCount(0);
        int anchos[] = {8, 10, 20, 20, 20, 10, 200, 80, 30};
        for (int i = 0; i < frmMenu.tblTrabajadores.getColumnCount(); i++) {
            frmMenu.tblTrabajadores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        traDAO.listarTrabajadores(model);
    }

    //  Metodo para listar trabajadores
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblTrabajadores.getModel();
        diseñoTabla();
        traDAO.listarTrabajadores(model);
    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtDni.setText("");
        frmMenu.txtFechaNacimiento.setText("");
        frmMenu.txtApePaterno.setText("");
        frmMenu.txtApeMaterno.setText("");
        frmMenu.txtNombreTrabajador.setText("");
        frmMenu.txtTelefono.setText("");
        frmMenu.Genero.clearSelection();
        frmMenu.EstadoCivil.clearSelection();
        frmMenu.txtDireccion.setText("");
        frmMenu.GradoIntruccion.clearSelection();
        frmMenu.txtDireccion.setText("");
        frmMenu.txtProfesion.setText("");
        frmMenu.lblFotoTrabajador.setIcon(null);
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mDni.setText("");
        frmMenu.mFechaNacimiento.setText("");
        frmMenu.mApePaterno.setText("");
        frmMenu.mApeMaterno.setText("");
        frmMenu.mNombresTrabajador.setText("");
        frmMenu.mTelefono.setText("");
        frmMenu.mGenero.setText("");
        frmMenu.mEstadoCivil.setText("");
        frmMenu.mDireccion.setText("");
        frmMenu.mGradoInstruccion.setText("");
        frmMenu.mCargoAsignado.setText("");
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmMenu.txtDni.getText().trim().equals("")) {
            frmMenu.mDni.setText("Ingrese DNI");
            frmMenu.mDni.setForeground(Color.red);
            frmMenu.txtDni.requestFocus();
            action = false;
        } else if (frmMenu.txtFechaNacimiento.getText().trim().equals("")) {
            frmMenu.mFechaNacimiento.setText("Ingrese o seleccione una fecha");
            frmMenu.mFechaNacimiento.setForeground(Color.red);
            frmMenu.txtFechaNacimiento.requestFocus();
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
            frmMenu.mFotoTrabajador.setText("Seleccione foto del trabajador");
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

    //  Metodo para validar existencia de telefono
    private boolean validarExistenciaTelefono() {
        boolean valor = true; //    Valor inicial verdadero
        if (traDAO.existeTelefono(frmMenu.txtTelefono.getText()) != 0) {
            frmMenu.mTelefono.setText("Teléfono ya existe");
            frmMenu.mTelefono.setForeground(Color.red);
            frmMenu.txtTelefono.requestFocus();
            valor = false;
        }
        return valor;
    }

    //  Metodo para registrar trabajador y ruta de la foto del trabajador
    private void registrar(Trabajador x, File ruta) {
        try {
            tra.setDni(x.getDni());
            tra.setApePaterno(x.getApePaterno());
            tra.setApeMaterno(x.getApeMaterno());
            tra.setNombres(x.getNombres());
            tra.setSexo(x.getSexo());
            tra.setEstadoCivil(x.getEstadoCivil());
            tra.setFechaNacimiento(x.getFechaNacimiento());
            tra.setDireccion(x.getDireccion());
            tra.setTelefono(x.getTelefono());
            tra.setGradoInstruccion(x.getGradoInstruccion());
            tra.setProfesion(x.getProfesion());
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            tra.setFoto(icono);
            tra.setCodCargo(x.getCodCargo());
        } catch (IOException ex) {
            tra.setFoto(null);
        }
        traDAO.registrarTrabajador(x);
        cargarTabla();
        limpiarInputs();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Metodo para llenar cargos en el comboBox
//        if (e.getSource().equals(frmMenu.cboCargo)) {
//            HashMap<String, Integer> map = caDAO.populateCombo();
//            frmMenu.txtCodCargoAsignado.setText(map.get(frmMenu.cboCargo.getSelectedItem().toString()).toString());
//        }
        //  Evento boton registrar
        if (e.getSource().equals(frmMenu.btnRegistrarTrabajador)) {
            //  validaciones
            boolean validarVacios = validarCamposVacios();
            boolean validarDNI = validarExistenciaDNI();
            boolean validarTelefono = validarExistenciaTelefono();
            if (validarVacios == false) {
                validarCamposVacios();
            } else {
                if (validarDNI == false || validarTelefono == false) {
                    validarExistenciaDNI();
                    validarExistenciaTelefono();
                } else {
                    tra.setDni(frmMenu.txtDni.getText());
                    tra.setApePaterno(frmMenu.txtApePaterno.getText());
                    tra.setApeMaterno(frmMenu.txtApeMaterno.getText());
                    tra.setNombres(frmMenu.txtNombreTrabajador.getText());
                    String genero;
                    if (frmMenu.opFemenino.isSelected()) {
                        genero = "Femenino";
                    } else {
                        genero = "Masculino";
                    }
                    tra.setSexo(genero);
                    String estadoCivil; //  RadioButton EstadoCivil
                    if (frmMenu.opSoltero.isSelected()) {
                        estadoCivil = "Soltero";
                    } else if (frmMenu.opCasado.isSelected()) {
                        estadoCivil = "Casado";
                    } else {
                        estadoCivil = "Conviviente";
                    }
                    tra.setEstadoCivil(estadoCivil);
                    tra.setFechaNacimiento(Date.valueOf(frmMenu.txtFechaNacimiento.getText()));
                    tra.setDireccion(frmMenu.txtDireccion.getText());
                    tra.setTelefono(frmMenu.txtTelefono.getText());
                    String gradoInstruccion;    //  RadioButton Grado de instruccion
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
                    tra.setProfesion(frmMenu.txtProfesion.getText());
                    File ruta = new File(frmMenu.txtRuta.getText());
                    tra.setCodCargo(Integer.parseInt(frmMenu.txtCodCargoAsignado.getText()));
                    try {
                        registrar(tra, ruta);
                        JOptionPane.showMessageDialog(null, "Trabajador registrado");
                        limpiarInputs();
                    } catch (Exception ex) {
                        System.out.println("Error de registrar trabajador frmMenu: " + ex.getMessage());
                    }
                }
            }
        }

        // Evento boton seleccionar cargo
        if (e.getSource().equals(frmMenu.btnSeleccionarCargo)) {
//            DSelectorCargo dsc = new DSelectorCargo();
//            dsc.setVisible(true);
//            Cargo c = dsc.cargoSelected;
//            try {
//                frmMenu.txtCodCargoAsignado.setText(String.valueOf(c.getCodigo()));
//                frmMenu.txtCargoAsignado.setText(c.getNombreCargo());
//            } catch (Exception exx) {
//                System.out.println(exx.getMessage());
//            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  Evento de abrir JFileChooser al clickeo del label Foto Trabajador
        if (e.getSource().equals(frmMenu.lblFotoTrabajador)) {
            try {   // Cambiar formato de LookAndFeel modo Windows
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.out.println("Error de lookAndFeel: " + ex.getMessage());
            }
            //  Abrir JFileChooser
            JFileChooser se = new JFileChooser();
            se.setFileSelectionMode(JFileChooser.FILES_ONLY);   //  Permiso de carpetas y archivos
            se.setCurrentDirectory(new File("C:\\Imágenes"));   //  Directorio para abrir
            se.setFileFilter(new FileNameExtensionFilter(".jpeg, .jpg & .png", "jpeg", "jpg", "png"));  //Formatos permitidos
            int estado = se.showOpenDialog(null);
            if (estado == JFileChooser.APPROVE_OPTION) {
                String ruta = se.getSelectedFile().getAbsolutePath();
                frmMenu.txtRuta.setText(ruta);
                try {
                    Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(frmMenu.lblFotoTrabajador.getWidth(), frmMenu.lblFotoTrabajador.getHeight(), Image.SCALE_DEFAULT);
                    frmMenu.lblFotoTrabajador.setIcon(new ImageIcon(icono));
                    frmMenu.lblFotoTrabajador.updateUI();
                    frmMenu.lblFotoTrabajador.setText("");
                    frmMenu.mFotoTrabajador.setText("");
                } catch (IOException ex) {
                    System.out.println("Error en el primer catch" + ex.getMessage());
                }
            } else {
                frmMenu.mFotoTrabajador.setText("No se ha seleccionado ninguna foto");
                frmMenu.mFotoTrabajador.setForeground(Color.red);
            }
        }
        // Evento de clickeo en la caja de texto Fecha Nacimiento
        if (e.getSource().equals(frmMenu.txtFechaNacimiento)) {
            frmMenu.mFechaNacimiento.setText("");  //  Ocultar mensaje de error
        }
        //  evento de clickeo para la tabla de trabajadores
        if (e.getSource().equals(frmMenu.tblTrabajadores)) {
            int fila = frmMenu.tblTrabajadores.getSelectedRow();
            int idTrabajador = Integer.parseInt(frmMenu.tblTrabajadores.getValueAt(fila, 0).toString());
            frmMenu.txtIdTrabajador.setText(String.valueOf(idTrabajador)); //   setear id del trabajador
            if (!frmMenu.txtIdTrabajador.getText().isEmpty()) {
                int id = Integer.parseInt(frmMenu.txtIdTrabajador.getText());
                tra = traDAO.consultarTrabajador(id);
                // seteo de datos
                frmMenu.txtDni.setText(tra.getDni());
                frmMenu.txtApePaterno.setText(tra.getApePaterno());
                frmMenu.txtApeMaterno.setText(tra.getApeMaterno());
                frmMenu.txtNombreTrabajador.setText(tra.getNombres());
                if (tra.getSexo().equals("Femenino")) {
                    frmMenu.opFemenino.setSelected(true);
                } else {
                    frmMenu.opMasculino.setSelected(true);
                }
                if (tra.getEstadoCivil().equals("Soltero")) {
                    frmMenu.opSoltero.setSelected(true);
                } else if (tra.getEstadoCivil().equals("Casado")) {
                    frmMenu.opCasado.setSelected(true);
                } else {
                    frmMenu.opConviviente.setSelected(true);
                }
                frmMenu.txtFechaNacimiento.setText(String.valueOf(tra.getFechaNacimiento()));
                frmMenu.txtTelefono.setText(tra.getTelefono());
                frmMenu.txtDireccion.setText(tra.getDireccion());
                if (tra.getGradoInstruccion().equals("Primaria completa")) {
                    frmMenu.opPrimaria.setSelected(true);
                } else if (tra.getGradoInstruccion().equals("Secundaria completa")) {
                    frmMenu.opSecundaria.setSelected(true);
                } else if (tra.getGradoInstruccion().equals("Técnico")) {
                    frmMenu.opTecnico.setSelected(true);
                } else {
                    frmMenu.opUniversitaria.setSelected(true);
                }
               frmMenu. txtProfesion.setText(tra.getProfesion());
               frmMenu. txtCodCargoAsignado.setText(String.valueOf(tra.getCargo().getCodigo()));
                frmMenu.txtCargoAsignado.setText(tra.getCargo().getNombreCargo());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //  Eventos que al escribir contenido en cajas de texto, los mensajes de error se ocultan
        if (e.getSource().equals(frmMenu.txtDni)) {
            frmMenu.mDni.setText("");
        } else if (e.getSource().equals(frmMenu.txtFechaNacimiento)) {
            frmMenu.mFechaNacimiento.setText("");
        } else if (e.getSource().equals(frmMenu.txtApePaterno)) {
            frmMenu.mApePaterno.setText("");
        } else if (e.getSource().equals(frmMenu.txtApeMaterno)) {
            frmMenu.mApeMaterno.setText("");
        } else if (e.getSource().equals(frmMenu.txtNombreTrabajador)) {
            frmMenu.mNombresTrabajador.setText("");
        } else if (e.getSource().equals(frmMenu.txtTelefono)) {
            frmMenu.mTelefono.setText("");
        } else if (e.getSource().equals(frmMenu.txtDireccion)) {
            frmMenu.mDireccion.setText("");
        } else if (e.getSource().equals(frmMenu.txtProfesion)) {
            frmMenu.mProfesion.setText("Opcional");
            frmMenu.mProfesion.setForeground(new Color(3, 155, 216));
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //  Eventos limitados por validaciones de tipeo
        if (e.getSource().equals(frmMenu.txtDni)) {
            Validaciones.soloDigitos(e);
            //  Variables de longitud;
            int limiteDNI = 8;
            if (frmMenu.txtDni.getText().length() == limiteDNI) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtTelefono)) {
            Validaciones.soloDigitos(e);
            int limiteTelefono = 9;
            if (frmMenu.txtTelefono.getText().length() == limiteTelefono) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtApePaterno) || e.getSource().equals(frmMenu.txtApeMaterno) || e.getSource().equals(frmMenu.txtNombreTrabajador) || e.getSource().equals(frmMenu.txtProfesion)) {
            Validaciones.soloLetras(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //  Evento para desaparecer mensajes de error al clickear RadioButton
        if (e.getSource().equals(frmMenu.opFemenino) || e.getSource().equals(frmMenu.opMasculino)) {
            frmMenu.mGenero.setText("");
        } else if (e.getSource().equals(frmMenu.opSoltero) || e.getSource().equals(frmMenu.opCasado) || e.getSource().equals(frmMenu.opConviviente)) {
            frmMenu.mEstadoCivil.setText("");
        } else if (e.getSource().equals(frmMenu.opPrimaria) || e.getSource().equals(frmMenu.opSecundaria) || e.getSource().equals(frmMenu.opTecnico) || e.getSource().equals(frmMenu.opUniversitaria)) {
            frmMenu.mGradoInstruccion.setText("");
        }
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
