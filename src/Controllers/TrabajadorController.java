package Controllers;

import Models.Cargo;
import Models.CentrarColumnas;
import Models.ColorearLabels;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Models.Validaciones;

import Views.FrmMenu;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TrabajadorController implements ActionListener, MouseListener, KeyListener {

    Cargo cargo = null;

    //  Instancias de clases
    private Trabajador tra;
    private TrabajadorDAO traDAO;
    private FrmMenu frmMenu;

    private String[] filtros = {"Nombre", "DNI", "Celular", "Cargo"};  //  Array de filtros

    public TrabajadorController(Trabajador tra, TrabajadorDAO traDAO, FrmMenu frmMenu) {
        this.tra = tra;
        this.traDAO = traDAO;
        this.frmMenu = frmMenu;
        interfaces();
        diseñoPanel();
        limpiarInputs();
        limpiarMensajesError();
        cargarTabla();
        enableButtons();
        cargarFiltros();
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
        frmMenu.btnActualizarTrabajador.addActionListener(this);
        frmMenu.cboFiltrarTrabajadorPor.addActionListener(this);
        frmMenu.JReingresarTrabajador.addActionListener(this);
        frmMenu.JCesarTrabajador.addActionListener(this);

        frmMenu.opFemenino.addActionListener(this);
        frmMenu.opMasculino.addActionListener(this);
        frmMenu.opSoltero.addActionListener(this);
        frmMenu.opCasado.addActionListener(this);
        frmMenu.opConviviente.addActionListener(this);
        frmMenu.opPrimaria.addActionListener(this);
        frmMenu.opSecundaria.addActionListener(this);
        frmMenu.opTecnico.addActionListener(this);
        frmMenu.opUniversitaria.addActionListener(this);
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
        frmMenu.tblTrabajadores.addKeyListener(this);
        frmMenu.txtBusquedaTrabajador.addKeyListener(this);
        frmMenu.txtFiltroTrabajadorLista.addKeyListener(this);

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
        frmMenu.btnSeleccionarCargo.addMouseListener(this);
    }

    //  Metodo de diseño del panel Trabajador
    private void diseñoPanel() {
        frmMenu.mProfesion.setText("Opcional");
        frmMenu.mProfesion.setForeground(new Color(3, 155, 216));
        frmMenu.txtCodCargoAsignado.setForeground(Color.white); //  color blanco de codCargo
        frmMenu.mFotoTrabajador.setText("Click en FOTO para seleccionar");
        frmMenu.mFotoTrabajador.setForeground(new Color(3, 155, 216));

        //Diseño popup
        frmMenu.popupTrabajador.setFont(new Font("Dialog", Font.PLAIN, 14));
    }

    //  Metodo para llenar comboBox de filtros
    private void cargarFiltros() {
        for (String filtro : filtros) { //  Capturar el array de filtros
            frmMenu.cboFiltrarTrabajadorPor.addItem(filtro); // Llenar filtros en comboBox
        }
    }

    //  Metodo para listar trabajadores
    public void cargarTabla() {
        //    Cargar datos para la tabla de trabajadores - VISTA DE USUARIO 
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblTrabajadores.getModel();  // Obtener el modelo de la tabla de listar trabajadores
        int anchos[] = {8, 30, 250, 200, 50, 150, 60}; // anchos de columnas 
        model.setRowCount(0); // devolver todas las filas 
        for (int i = 0; i < frmMenu.tblTrabajadores.getColumnCount(); i++) { // Devuelve el número de columnas del conjunto de resultados
            frmMenu.tblTrabajadores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblTrabajadores.setDefaultRenderer(Object.class, new CentrarColumnas()); //  Centrado de valores de las columnas
        frmMenu.tblTrabajadores.getColumnModel().getColumn(6).setCellRenderer(new ColorearLabels(6));
        frmMenu.tblTrabajadores.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        frmMenu.tblTrabajadores.getTableHeader().setOpaque(false);
        frmMenu.tblTrabajadores.getTableHeader().setBackground(Color.decode("#10316B"));
        frmMenu.tblTrabajadores.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        //        pintarColumna();
        traDAO.listarTrabajadores(model); // metodo para llenar datos en la tabla

        //    Cargar datos para la tabla de trabajadores - VISTA DE ADMINISTRADOR 
        DefaultTableModel model1 = (DefaultTableModel) frmMenu.tblListaTrabajadores.getModel(); // Obtener el modelo de la tabla de listar trabajadores
        int anchosLista[] = {30, 250, 200, 50, 150, 60}; // anchos de columnas 
        model1.setRowCount(0); // devolver todas las filas 
        for (int j = 0; j < frmMenu.tblListaTrabajadores.getColumnCount(); j++) { // Devuelve el número de columnas del conjunto de resultados
            frmMenu.tblListaTrabajadores.getColumnModel().getColumn(j).setPreferredWidth(anchosLista[j]);
        }
        frmMenu.tblListaTrabajadores.setDefaultRenderer(Object.class, new CentrarColumnas()); //  Centrado de valores de las columnas
        frmMenu.tblListaTrabajadores.getColumnModel().getColumn(5).setCellRenderer(new ColorearLabels(5));
        frmMenu.tblListaTrabajadores.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        frmMenu.tblListaTrabajadores.getTableHeader().setOpaque(false);
        frmMenu.tblListaTrabajadores.getTableHeader().setBackground(Color.decode("#10316B"));
        frmMenu.tblListaTrabajadores.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        traDAO.mostrarTrabajadores(model1); // metodo para llenar datos en la tabla
    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtIdTrabajador.setText("");
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
        frmMenu.lblFotoTrabajador.setText("FOTO");
        frmMenu.txtRutaFotoTrabajador.setText("");
        frmMenu.txtCodCargoAsignado.setText("");
        frmMenu.txtCargoAsignado.setText("");
        frmMenu.tblTrabajadores.clearSelection();
        frmMenu.txtBusquedaTrabajador.setText("");
        frmMenu.txtDni.requestFocus();
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
        frmMenu.mFotoTrabajador.setText("");
        frmMenu.mCargoAsignado.setText("");
    }

    //  Habilitar botones
    private void enableButtons() {
        frmMenu.btnRegistrarTrabajador.setEnabled(true);
        frmMenu.btnActualizarTrabajador.setEnabled(false);
    }

    //  Deshabilitar botones
    private void disableButtons() {
        frmMenu.btnRegistrarTrabajador.setEnabled(false);
        frmMenu.btnActualizarTrabajador.setEnabled(true);
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean valor = true;
        if (frmMenu.txtDni.getText().trim().equals("")) {
            frmMenu.mDni.setText("Ingrese DNI");
            frmMenu.mDni.setForeground(Color.decode("#E94560"));
            frmMenu.txtDni.requestFocus();
            valor = false;
        } else if (frmMenu.txtFechaNacimiento.getText().trim().equals("")) {
            frmMenu.mFechaNacimiento.setText("Ingrese o seleccione una fecha");
            frmMenu.mFechaNacimiento.setForeground(Color.decode("#E94560"));
            frmMenu.txtFechaNacimiento.requestFocus();
            valor = false;
        } else if (frmMenu.txtApePaterno.getText().trim().equals("")) {
            frmMenu.mApePaterno.setText("Ingrese apellido paterno");
            frmMenu.mApePaterno.setForeground(Color.decode("#E94560"));
            frmMenu.txtApePaterno.requestFocus();
            valor = false;
        } else if (frmMenu.txtApeMaterno.getText().trim().equals("")) {
            frmMenu.mApeMaterno.setText("Ingrese apellido materno");
            frmMenu.mApeMaterno.setForeground(Color.decode("#E94560"));
            frmMenu.txtApeMaterno.requestFocus();
            valor = false;
        } else if (frmMenu.txtNombreTrabajador.getText().trim().equals("")) {
            frmMenu.mNombresTrabajador.setText("Ingrese nombres");
            frmMenu.mNombresTrabajador.setForeground(Color.decode("#E94560"));
            frmMenu.txtNombreTrabajador.requestFocus();
            valor = false;
        } else if (frmMenu.txtTelefono.getText().trim().equals("")) {
            frmMenu.mTelefono.setText("Ingresar telefono");
            frmMenu.mTelefono.setForeground(Color.decode("#E94560"));
            frmMenu.txtTelefono.requestFocus();
            valor = false;
        } else if (frmMenu.Genero.isSelected(null)) {
            frmMenu.mGenero.setText("Marque una opción");
            frmMenu.mGenero.setForeground(Color.decode("#E94560"));
            valor = false;
        } else if (frmMenu.EstadoCivil.isSelected(null)) {
            frmMenu.mEstadoCivil.setText("Marque una opción");
            frmMenu.mEstadoCivil.setForeground(Color.decode("#E94560"));
            valor = false;
        } else if (frmMenu.txtDireccion.getText().trim().equals("")) {
            frmMenu.mDireccion.setText("Ingrese dirección domiciliaria");
            frmMenu.mDireccion.setForeground(Color.decode("#E94560"));
            frmMenu.txtDireccion.requestFocus();
            valor = false;
        } else if (frmMenu.GradoIntruccion.isSelected(null)) {
            frmMenu.mGradoInstruccion.setText("Marque una opción");
            frmMenu.mGradoInstruccion.setForeground(Color.decode("#E94560"));
            valor = false;
//        } else if (frmMenu.lblFotoTrabajador.getText().equals("FOTO")) {
//            frmMenu.mFotoTrabajador.setText("Seleccione foto del trabajador");
//            frmMenu.mFotoTrabajador.setForeground(Color.red);
//            valor = false;
        } else if (frmMenu.txtCodCargoAsignado.getText().equals("")) {
            frmMenu.mCargoAsignado.setText("Asigne un cargo");
            frmMenu.mCargoAsignado.setForeground(Color.decode("#E94560"));
            valor = false;
        }
        return valor;
    }

    //  Metodo para validar existencia de dni
    private boolean validarExistenciaDNI() {
        boolean valor = true;   //  Valor inicial verdadero
        if (traDAO.existeDNI(frmMenu.txtDni.getText()) != 0) {
            frmMenu.mDni.setText("DNI ya existe");
            frmMenu.mDni.setForeground(Color.decode("#E94560"));
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
            frmMenu.mTelefono.setForeground(Color.decode("#E94560"));
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
            tra.setPath(x.getPath());
            tra.setCodCargo(x.getCodCargo());
        } catch (IOException ex) {
            tra.setFoto(null);
        }
        traDAO.registrarTrabajador(x);
        limpiarInputs();
    }

    //  Metodo para modificar datos del trabajador con foto
    private void modificarConFoto(Trabajador t, File ruta) {
        tra.setIdTrabajador(t.getIdTrabajador());
        tra.setDni(t.getDni());
        tra.setApePaterno(t.getApePaterno());
        tra.setApeMaterno(t.getApeMaterno());
        tra.setNombres(t.getNombres());
        tra.setSexo(t.getSexo());
        tra.setEstadoCivil(t.getEstadoCivil());
        tra.setFechaNacimiento(t.getFechaNacimiento());
        tra.setDireccion(t.getDireccion());
        tra.setTelefono(t.getTelefono());
        tra.setGradoInstruccion(t.getGradoInstruccion());
        tra.setProfesion(t.getProfesion());
        try {
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            tra.setFoto(icono);
        } catch (IOException e) {
            tra.setFoto(null);
        }
        tra.setCodCargo(t.getCodCargo());

        traDAO.modificarTrabajadorConFoto(tra);
    }

    //  Metodo para modificar datos del trabajados sin foto
    private void modificarSinFoto(Trabajador t) {
        tra.setIdTrabajador(t.getIdTrabajador());
        tra.setDni(t.getDni());
        tra.setApePaterno(t.getApePaterno());
        tra.setApeMaterno(t.getApeMaterno());
        tra.setNombres(t.getNombres());
        tra.setSexo(t.getSexo());
        tra.setEstadoCivil(t.getEstadoCivil());
        tra.setFechaNacimiento(t.getFechaNacimiento());
        tra.setDireccion(t.getDireccion());
        tra.setTelefono(t.getTelefono());
        tra.setGradoInstruccion(t.getGradoInstruccion());
        tra.setProfesion(t.getProfesion());
        tra.setCodCargo(t.getCodCargo());

        traDAO.modificarTrabajadorSinFoto(tra);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Metodo para llenar cargos en el comboBox
//        if (e.getSource().equals(frmMenu.cboCargo)) {
//            HashMap<String, Integer> map = caDAO.populateCombo();
//            frmMenu.txtCodCargoAsignado.setText(map.get(frmMenu.cboCargo.getSelectedItem().toString()).toString());
//        }
        //  Evento ACtionListener para boton REGISTRAR 
        if (e.getSource().equals(frmMenu.btnRegistrarTrabajador)) {
            //  validaciones
            boolean validarVacios = validarCamposVacios();
            boolean validarDNI = validarExistenciaDNI();
            boolean validarTelefono = validarExistenciaTelefono();

            if (validarVacios == false) { // si los campos estan vacios
                validarCamposVacios(); // mostrar mensaje
            } else {
                if (validarDNI == false || validarTelefono == false) { // si existen dni y telefono
                    //  mostrar mensajes
                    validarExistenciaDNI();
                    validarExistenciaTelefono();
                } else {
                    tra.setDni(frmMenu.txtDni.getText());
                    tra.setApePaterno(frmMenu.txtApePaterno.getText().trim());
                    tra.setApeMaterno(frmMenu.txtApeMaterno.getText().trim());
                    tra.setNombres(frmMenu.txtNombreTrabajador.getText().trim());
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
                    tra.setDireccion(frmMenu.txtDireccion.getText().trim());
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
                    tra.setProfesion(frmMenu.txtProfesion.getText().trim());
                    File ruta = new File(frmMenu.txtRutaFotoTrabajador.getText());
                    tra.setPath(frmMenu.txtRutaFotoTrabajador.getText());
                    tra.setCodCargo(Integer.parseInt(frmMenu.txtCodCargoAsignado.getText()));
                    try {
                        registrar(tra, ruta);
                        cargarTabla();
                        JOptionPane.showMessageDialog(frmMenu.tblTrabajadores, "Trabajador registrado");
                        limpiarInputs();
                    } catch (Exception ex) {
                        System.out.println("Error de registrar trabajador frmMenu: " + ex.getMessage());
                    }
                }
            }
        }

        //  Evento ActionListener del boton ACTUALIZAR
        if (e.getSource().equals(frmMenu.btnActualizarTrabajador)) {
            tra.setIdTrabajador(Integer.parseInt(frmMenu.txtIdTrabajador.getText()));
            tra.setDni(frmMenu.txtDni.getText());
            tra.setApePaterno(frmMenu.txtApePaterno.getText().trim());
            tra.setApeMaterno(frmMenu.txtApeMaterno.getText().trim());
            tra.setNombres(frmMenu.txtNombreTrabajador.getText().trim());
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
            tra.setDireccion(frmMenu.txtDireccion.getText().trim());
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
            tra.setProfesion(frmMenu.txtProfesion.getText().trim());
            tra.setPath(frmMenu.txtRutaFotoTrabajador.getText());
            File ruta = new File(frmMenu.txtRutaFotoTrabajador.getText());
            tra.setCodCargo(Integer.parseInt(frmMenu.txtCodCargoAsignado.getText()));

            if (ruta != null) {
                modificarConFoto(tra, ruta);
                cargarTabla();
                JOptionPane.showMessageDialog(frmMenu.tblTrabajadores, "Datos actualizados");
                limpiarInputs();
                enableButtons();
            } else {
                modificarSinFoto(tra);
                cargarTabla();
                JOptionPane.showMessageDialog(frmMenu.tblTrabajadores, "Datos actualizados");
                limpiarInputs();
                enableButtons();
            }
        }

        //  Evento ActionListener para el comboBox filtro - VISTA ADMINISTRADOR
        if (e.getSource().equals(frmMenu.cboFiltrarTrabajadorPor)) {
            if (frmMenu.cboFiltrarTrabajadorPor.getSelectedItem().equals("Nombre")) {
                cargarTabla();
                frmMenu.txtFiltroTrabajadorLista.setLabelText("Nombre del trabajador"); // establecer titulo de la caja de texto filtro
                frmMenu.txtFiltroTrabajadorLista.setText("");
                frmMenu.txtFiltroTrabajadorLista.requestFocus();
            } else if (frmMenu.cboFiltrarTrabajadorPor.getSelectedItem().equals("DNI")) {
                cargarTabla();
                frmMenu.txtFiltroTrabajadorLista.setLabelText("DNI"); // establecer titulo de la caja de texto filtro
                frmMenu.txtFiltroTrabajadorLista.setText("");
                frmMenu.txtFiltroTrabajadorLista.requestFocus();
            } else if (frmMenu.cboFiltrarTrabajadorPor.getSelectedItem().equals("Celular")) {
                cargarTabla();
                frmMenu.txtFiltroTrabajadorLista.setLabelText("Celular"); // establecer titulo de la caja de texto filtro
                frmMenu.txtFiltroTrabajadorLista.setText("");
                frmMenu.txtFiltroTrabajadorLista.requestFocus();
            } else {
                cargarTabla();
                frmMenu.txtFiltroTrabajadorLista.setLabelText("Cargo"); // establecer titulo de la caja de texto filtro
                frmMenu.txtFiltroTrabajadorLista.setText("");
                frmMenu.txtFiltroTrabajadorLista.requestFocus();
            }
        }
        // Evento ActionListener para los itemsPopUp de la tabla trabajador
        if (e.getSource().equals(frmMenu.JReingresarTrabajador)) {
            if (frmMenu.txtIdTrabajador.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmMenu.tblTrabajadores, "Seleccione una fila");
            } else {
                int id = Integer.parseInt(frmMenu.txtIdTrabajador.getText());
                traDAO.reingresarTrabajador(id);

                cargarTabla();
                limpiarInputs();
            }
        } else if (e.getSource().equals(frmMenu.JCesarTrabajador)) {
            if (frmMenu.txtIdTrabajador.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frmMenu.tblTrabajadores, "Seleccione una fila");
            } else {
                int id = Integer.parseInt(frmMenu.txtIdTrabajador.getText());
                traDAO.suspenderTrabajador(id);
                cargarTabla();
                limpiarInputs();
            }
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
            se.setFileSelectionMode(JFileChooser.FILES_ONLY);   //  Permiso solo de archivos
            File nuevaRuta = new File("C:\\Users\\Acer\\Pictures\\Mis escaneos");  // ruta del directorio
            se.setCurrentDirectory(nuevaRuta);
            se.setDialogTitle("Seleccionar foto del trabajador"); // titulo de dialog
            se.setCurrentDirectory(new File("C:\\Imágenes\\"));   //  Directorio para abrir
            se.setMultiSelectionEnabled(false); //solo puedo seleccionar un archivo a la vez 
            se.setApproveButtonText("Seleccionar"); //  Boton seleccionar
            se.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpeg", "jpg", "png"));  //Formatos permitidos
            int estado = se.showOpenDialog(null);
            if (estado == JFileChooser.APPROVE_OPTION) {
                String ruta = se.getSelectedFile().getAbsolutePath();
                frmMenu.txtRutaFotoTrabajador.setText(ruta);
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
                frmMenu.mFotoTrabajador.setForeground(Color.decode("#E94560"));
            }
        }
        // Evento MouseListener de txtFechaNacimiento para borrar mensaje de error
        if (e.getSource().equals(frmMenu.txtFechaNacimiento)) {
            frmMenu.mFechaNacimiento.setText("");  //  Ocultar mensaje de error
        }
        //  Evento MouseListener para la tabla tblTrabajadores para setear datos
        if (e.getSource().equals(frmMenu.tblTrabajadores)) {
            disableButtons(); // deshabilitar botones (registrar)
            limpiarMensajesError();
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
                switch (tra.getEstadoCivil()) {
                    case "Soltero":
                        frmMenu.opSoltero.setSelected(true);
                        break;
                    case "Casado":
                        frmMenu.opCasado.setSelected(true);
                        break;
                    default:
                        frmMenu.opConviviente.setSelected(true);
                        break;
                }
                frmMenu.txtFechaNacimiento.setText(String.valueOf(tra.getFechaNacimiento()));
                frmMenu.txtTelefono.setText(tra.getTelefono());
                frmMenu.txtDireccion.setText(tra.getDireccion());
                switch (tra.getGradoInstruccion()) {
                    case "Primaria completa":
                        frmMenu.opPrimaria.setSelected(true);
                        break;
                    case "Secundaria completa":
                        frmMenu.opSecundaria.setSelected(true);
                        break;
                    case "Técnico":
                        frmMenu.opTecnico.setSelected(true);
                        break;
                    default:
                        frmMenu.opUniversitaria.setSelected(true);
                        break;
                }
                frmMenu.txtProfesion.setText(tra.getProfesion());
                frmMenu.txtCodCargoAsignado.setText(String.valueOf(tra.getCargo().getCodigo()));
                frmMenu.txtCargoAsignado.setText(tra.getCargo().getNombreCargo());
                frmMenu.txtRutaFotoTrabajador.setText(tra.getPath());
                //  Set foto del trabajador.
                if (tra.getFoto() == null) {
                    frmMenu.mFotoTrabajador.setText("Trabajador sin foto");
                    frmMenu.lblFotoTrabajador.setIcon(null);
                    frmMenu.mFotoTrabajador.setForeground(new Color(3, 155, 216));
                } else {
                    ImageIcon icon = new ImageIcon(tra.getFoto());
                    Image newImg = icon.getImage().getScaledInstance(frmMenu.lblFotoTrabajador.getWidth(), frmMenu.lblFotoTrabajador.getHeight(), Image.SCALE_DEFAULT);
                    frmMenu.lblFotoTrabajador.setIcon(new ImageIcon(newImg));
                    frmMenu.lblFotoTrabajador.setText("");
                    frmMenu.mFotoTrabajador.setText("Click en la foto para actualizar");
                }

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

        //  Evento KeyListener de teclas arriba y abajo para setear datos - Vista Usuario
        if (e.getSource().equals(frmMenu.tblTrabajadores)) {
            //  seteo de datos con las flechas arriba y abajo sobre la tabla
            if ((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_UP)) {
                disableButtons();
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
                    switch (tra.getEstadoCivil()) {
                        case "Soltero":
                            frmMenu.opSoltero.setSelected(true);
                            break;
                        case "Casado":
                            frmMenu.opCasado.setSelected(true);
                            break;
                        default:
                            frmMenu.opConviviente.setSelected(true);
                            break;
                    }
                    frmMenu.txtFechaNacimiento.setText(String.valueOf(tra.getFechaNacimiento()));
                    frmMenu.txtTelefono.setText(tra.getTelefono());
                    frmMenu.txtDireccion.setText(tra.getDireccion());
                    switch (tra.getGradoInstruccion()) {
                        case "Primaria completa":
                            frmMenu.opPrimaria.setSelected(true);
                            break;
                        case "Secundaria completa":
                            frmMenu.opSecundaria.setSelected(true);
                            break;
                        case "Técnico":
                            frmMenu.opTecnico.setSelected(true);
                            break;
                        default:
                            frmMenu.opUniversitaria.setSelected(true);
                            break;
                    }
                    frmMenu.txtProfesion.setText(tra.getProfesion());
                    frmMenu.txtCodCargoAsignado.setText(String.valueOf(tra.getCargo().getCodigo()));
                    frmMenu.txtCargoAsignado.setText(tra.getCargo().getNombreCargo());
                    frmMenu.txtRutaFotoTrabajador.setText(tra.getPath());
                    //  Set foto del trabajador.
                    if (tra.getFoto() == null) {
                        frmMenu.mFotoTrabajador.setText("Trabajador sin foto");
                        frmMenu.lblFotoTrabajador.setIcon(null);
                        frmMenu.mFotoTrabajador.setForeground(new Color(3, 155, 216));
                    } else {
                        ImageIcon icon = new ImageIcon(tra.getFoto());
                        Image newImg = icon.getImage().getScaledInstance(frmMenu.lblFotoTrabajador.getWidth(), frmMenu.lblFotoTrabajador.getHeight(), Image.SCALE_DEFAULT);
                        frmMenu.lblFotoTrabajador.setIcon(new ImageIcon(newImg));
                        frmMenu.lblFotoTrabajador.setText("");
                        frmMenu.mFotoTrabajador.setText("Click en la foto para actualizar");
                    }
                }
                //  Limpiar textos con Escape despues de clickear tabla
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                limpiarInputs();
                limpiarMensajesError();
                cargarTabla();
                enableButtons();
            }
        }
        //  Evento KeyListener de filtrado de busqueda por nombre del trabajador  - Vista Usuario
        if (e.getSource().equals(frmMenu.txtBusquedaTrabajador)) {
            DefaultTableModel model = (DefaultTableModel) frmMenu.tblTrabajadores.getModel();
            String nombreTrabajador = frmMenu.txtBusquedaTrabajador.getText();
            traDAO.filtrarNombre(nombreTrabajador, model);
        }

        //  Evento KeyListener de filtrado de busqueda - Vista Administrador
        if (e.getSource().equals(frmMenu.txtFiltroTrabajadorLista)) {
            //  Capturar el modelo de la tabla Listar Trabajador (Administrador)
            DefaultTableModel model = (DefaultTableModel) frmMenu.tblListaTrabajadores.getModel();
            //  Establecer metodos por cada opcion 
            switch (frmMenu.txtFiltroTrabajadorLista.getLabelText()) {
                case "Nombre del trabajador":
                    String nombreTrabajador = frmMenu.txtFiltroTrabajadorLista.getText();
                    traDAO.filtrarBusquedaNombre(nombreTrabajador, model);
                    break;
                case "DNI":
                    String dniTrabajador = frmMenu.txtFiltroTrabajadorLista.getText();
                    traDAO.filtrarBusquedaDNI(dniTrabajador, model);
                    break;
                case "Celular":
                    String celularTrabajador = frmMenu.txtFiltroTrabajadorLista.getText();
                    traDAO.filtrarBusquedaCelular(celularTrabajador, model);
                    break;
                default:
                    String cargoTrabajador = frmMenu.txtFiltroTrabajadorLista.getText();
                    traDAO.filtrarBusquedaCargoTrabajador(cargoTrabajador, model);
                    break;
            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                limpiarInputs();
                limpiarMensajesError();
                enableButtons();
                cargarTabla();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //  Eventos KeyTyped limitados por validaciones de tipeo
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
        } else if (e.getSource().equals(frmMenu.txtApePaterno) || e.getSource().equals(frmMenu.txtApeMaterno) || e.getSource().equals(frmMenu.txtNombreTrabajador) || e.getSource().equals(frmMenu.txtProfesion) || e.getSource().equals(frmMenu.txtBusquedaTrabajador)) {
            Validaciones.soloLetras(e);
        } else if (e.getSource().equals(frmMenu.txtFiltroTrabajadorLista)) {
            switch (frmMenu.txtFiltroTrabajadorLista.getLabelText()) {
                case "Nombre del trabajador":
                    Validaciones.soloLetras(e);
                    break;
                case "DNI":
                    Validaciones.soloDigitos(e);
                    int limiteDNI = 8;
                    if (frmMenu.txtFiltroTrabajadorLista.getText().length() == limiteDNI) {
                        e.consume();
                    }
                    break;
                case "Celular":
                    Validaciones.soloDigitos(e);
                    int limiteTelefono = 9;
                    if (frmMenu.txtFiltroTrabajadorLista.getText().length() == limiteTelefono) {
                        e.consume();
                    }
                    break;
                default:
                    Validaciones.soloLetras(e);
                    break;
            }
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
        if (e.getSource().equals(frmMenu.btnSeleccionarCargo)) {
            frmMenu.mCargoAsignado.setText("");
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
