// entity data. chevris.. oracle 
/*
    cv - practicante...
    c#. - practicar. (


*/
package Controllers;

import Models.CentrarColumnas;
import Models.ColorearLabels;
import Models.Licencia;
import Models.LicenciaDAO;
import Models.Trabajador;
import Models.TrabajadorDAO;

import Views.FrmMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LicenciaController implements ActionListener, KeyListener, MouseListener {

    Trabajador trabajador = null;

    //  Instancias de clases
    private Licencia lic;
    private LicenciaDAO licDAO;
    private FrmMenu frmMenu;

    private String[] categoriaLicencias = {"seleccionar", "AI", "AIIB", "AIIIB", "AIIIC"};  //  Array de areas
    private String[] filtros = {"Nombre", "DNI", "Categoría"};  //  Array de filtros

    public LicenciaController(Licencia lic, LicenciaDAO licDAO, FrmMenu frmMenu) {
        this.lic = lic;
        this.licDAO = licDAO;
        this.frmMenu = frmMenu;
        diseñarIntefaz();
        interfaces();
        cargarTabla();
        limpiarInputs();
        limpiarMensajesError();
        enableButtons();
        cargarAreas();
        cargarFiltros();
    }

    //  Metodo para diseñar el panel de perfil laboral de trabajadores
    private void diseñarIntefaz() {
        frmMenu.txtIdTrabajadorLicencia.setBackground(Color.white);
    }

    //  Metodo para importar las interfaces utilizadas
    private void interfaces() {
        //  Eventos Action listener
        frmMenu.btnRegistrarLicencia.addActionListener(this);
        frmMenu.cboCategoriaLicencia.addActionListener(this);
        frmMenu.cboFiltrarLicenciaPor.addActionListener(this);

        //  Eventos MouseListener
        frmMenu.cboCategoriaLicencia.addMouseListener(this);
        frmMenu.txtFechaEmsion.addMouseListener(this);
        frmMenu.txtFechaCaducidad.addMouseListener(this);
        frmMenu.tblLicencias.addMouseListener(this);
        frmMenu.btnSeleccionarTrabajadorLicencia.addMouseListener(this);

        //  Eventos KeyListener
        frmMenu.tblLicencias.addKeyListener(this);
        frmMenu.txtNumLicencia.addKeyListener(this);
        frmMenu.tblLicencias.addKeyListener(this);
    }

    //  Metodo para llenar comboBox de areas
    private void cargarAreas() {
        for (String categoriaLicencia : categoriaLicencias) {
            frmMenu.cboCategoriaLicencia.addItem(categoriaLicencia);
        }
    }

    //  Metodo para llenar comboBox de filtros
    private void cargarFiltros() {
        for (String filtro : filtros) {
            frmMenu.cboFiltrarLicenciaPor.addItem(filtro);
        }
    }

    //  Metodo para listar perfiles laborales de los trabajadores
    private void cargarTabla() {
        int anchos[] = {10, 200, 30, 10, 80, 80};  //anchos de las columnas
        //  Diseño de la tabla Perfil Laboral
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblLicencias.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblLicencias.getColumnCount(); i++) {
            frmMenu.tblLicencias.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblLicencias.setDefaultRenderer(Object.class, new CentrarColumnas()); //    centrado de datos
        frmMenu.tblLicencias.getColumnModel().getColumn(5).setCellRenderer(new ColorearLabels(5));
        frmMenu.tblLicencias.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        frmMenu.tblLicencias.getTableHeader().setOpaque(false);
        frmMenu.tblLicencias.getTableHeader().setBackground(Color.decode("#10316B"));
        frmMenu.tblLicencias.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        licDAO.listarLicencias(model); // llamada del metodo dao listar

        int ancho[] = {100, 180, 30, 30, 30, 80, 80};
        //  Diseño de la tabla Perfil Laboral
        DefaultTableModel model1 = (DefaultTableModel) frmMenu.tblListaLicencias.getModel();
        model1.setRowCount(0);
        for (int i = 0; i < frmMenu.tblListaLicencias.getColumnCount(); i++) {
            frmMenu.tblListaLicencias.getColumnModel().getColumn(i).setPreferredWidth(ancho[i]);
        }
        frmMenu.tblListaLicencias.setDefaultRenderer(Object.class, new CentrarColumnas()); //    centrado de datos
        frmMenu.tblListaLicencias.getColumnModel().getColumn(6).setCellRenderer(new ColorearLabels(6));
        frmMenu.tblListaLicencias.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        frmMenu.tblListaLicencias.getTableHeader().setOpaque(false);
        frmMenu.tblListaLicencias.getTableHeader().setBackground(Color.decode("#10316B"));
        frmMenu.tblListaLicencias.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        licDAO.mostrarLicencias(model1); // llamada del metodo dao listar

    }

    //  Metodo para activar botones
    private void enableButtons() {
        frmMenu.btnRegistrarLicencia.setEnabled(true);
    }

    //  Metodo para desactivar botones
    private void disableButtons() {
        frmMenu.btnRegistrarLicencia.setEnabled(false);
    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtIdTrabajadorLicencia.setText("");
        frmMenu.txtCodLicencia.setText("");
        frmMenu.txtTrabajadorAsignadoLicencia.setText("");
        frmMenu.txtCargoAsignadoLicencia.setText("");
        frmMenu.txtNumLicencia.setText("");
        frmMenu.cboCategoriaLicencia.setSelectedItem("seleccionar");
        frmMenu.txtFechaEmsion.setText("");
        frmMenu.txtFechaCaducidad.setText("");
        frmMenu.tblLicencias.clearSelection();
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mTrabajadorAsignadoLicencia.setText("");
        frmMenu.mNumLicencia.setText("");
        frmMenu.mCategoriaLicencia.setText("");
        frmMenu.mFechaEmision.setText("");
        frmMenu.mFechaCaducidad.setText("");
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmMenu.txtTrabajadorAsignadoLicencia.getText().equals("")) {
            frmMenu.mTrabajadorAsignadoLicencia.setText("Seleccione un trabajador");
            frmMenu.mTrabajadorAsignadoLicencia.setForeground(Color.red);
            frmMenu.txtTrabajadorAsignadoLicencia.requestFocus();
            action = false;
        } else if (frmMenu.txtNumLicencia.getText().equals("")) {
            frmMenu.mNumLicencia.setText("Ingrese número de licencia");
            frmMenu.mNumLicencia.setForeground(Color.red);
            frmMenu.txtNumLicencia.requestFocus();
            action = false;
        } else if (frmMenu.cboCategoriaLicencia.getSelectedItem().equals("seleccionar")) {
            frmMenu.mCategoriaLicencia.setText("Seleccione una categoría");
            frmMenu.mCategoriaLicencia.setForeground(Color.red);
            action = false;
        } else if (frmMenu.txtFechaEmsion.getText().equals("")) {
            frmMenu.mFechaEmision.setText("Ingrese o seleccione una fecha");
            frmMenu.mFechaEmision.setForeground(Color.red);
            frmMenu.txtFechaEmsion.requestFocus();
            action = false;
        } else if (frmMenu.txtFechaCaducidad.getText().isEmpty()) {
            frmMenu.mFechaCaducidad.setText("Ingrese o seleccione una fecha");
            frmMenu.mFechaCaducidad.setForeground(Color.red);
            frmMenu.txtFechaCaducidad.requestFocus();
            action = false;
        }
        return action;
    }

    //  Metodo para validar existencia de numero de licencia
    private boolean validarExistenciaNumLicencia() {
        boolean valor = true;   //  Valor inicial
        if (licDAO.existeNumLicencia(frmMenu.txtNumLicencia.getText()) != 0) {
            frmMenu.mNumLicencia.setText("Número de licencia ya existe");
            frmMenu.mNumLicencia.setForeground(Color.red);
            frmMenu.txtNumLicencia.requestFocus();
            valor = false;
        }
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento boton registrarPerfilLaboral
        if (e.getSource().equals(frmMenu.btnRegistrarLicencia)) {
            boolean validarVacios = validarCamposVacios();
            boolean validarNumLicencia = validarExistenciaNumLicencia();

            if (validarVacios == false) {
                validarCamposVacios();
            } else {
                if (validarNumLicencia == false) {
                    validarExistenciaNumLicencia();
                } else {
                    String numLicencia = frmMenu.txtNumLicencia.getText();
                    String categoria = frmMenu.cboCategoriaLicencia.getSelectedItem().toString();
                    Date fechaEmision = Date.valueOf(frmMenu.txtFechaEmsion.getText());//primero
                    Date fechaCaducidad = Date.valueOf(frmMenu.txtFechaCaducidad.getText());
                    int idTrabajador = Integer.parseInt(frmMenu.txtIdTrabajadorLicencia.getText());
                    lic = new Licencia(numLicencia, categoria, fechaEmision, fechaCaducidad, idTrabajador);
                    if (licDAO.registrarLicencia(lic)) {
                        cargarTabla();
                        limpiarInputs();
                        JOptionPane.showMessageDialog(null, "Licencia registrada");
                    } else {
                        JOptionPane.showMessageDialog(null, "Licencia no registrada");
                    }
                }
            }
        }
        //  Evento ActionListener del comboBox de filtros
        if (e.getSource().equals(frmMenu.cboFiltrarLicenciaPor)) {
            if (frmMenu.cboFiltrarLicenciaPor.getSelectedItem().equals("Nombre")) {
                frmMenu.txtFiltroLicenciaLista.setLabelText("Nombre del trabajador");
                frmMenu.txtFiltroLicenciaLista.setText("");
                frmMenu.txtFiltroLicenciaLista.requestFocus();
            } else if (frmMenu.cboFiltrarLicenciaPor.getSelectedItem().equals("DNI")) {
                frmMenu.txtFiltroLicenciaLista.setLabelText("DNI");
                frmMenu.txtFiltroLicenciaLista.setText("");
                frmMenu.txtFiltroLicenciaLista.requestFocus();
            } else if (frmMenu.cboFiltrarLicenciaPor.getSelectedItem().equals("Categoría")) {
                frmMenu.txtFiltroLicenciaLista.setLabelText("Categoría");
                frmMenu.txtFiltroLicenciaLista.setText("");
                frmMenu.txtFiltroLicenciaLista.requestFocus();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //  Evecntos limitado por validaciones de tipeo
        if (e.getSource().equals(frmMenu.txtNumLicencia)) {
            int limite = 9;
            if (frmMenu.txtNumLicencia.getText().length() == limite) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //  Eventos que al escribir contenido en cajas de texto, los mensajes de error se ocultan
        if (e.getSource().equals(frmMenu.txtNumLicencia)) {
            frmMenu.mNumLicencia.setText("");
        }
        //  Evento de teclas arriba y abajo  para setear datos de la tabla de guardias a los inputs
        if (e.getSource().equals(frmMenu.tblLicencias)) {
            //  seteo de datos con las flechas arriba y abajo sobre la tabla
            if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
                disableButtons(); // Deshabilitar botones
                limpiarMensajesError(); // Limpiar mensajes de error
                //seleccionar fila de tabla
                int fila = frmMenu.tblLicencias.getSelectedRow();
                // extraer la primera columna de la tabla
                int codPerfil = Integer.parseInt(frmMenu.tblLicencias.getValueAt(fila, 0).toString());
                //  setear el valor extraido 
                frmMenu.txtCodLicencia.setText(String.valueOf(codPerfil));

                if (!frmMenu.txtCodLicencia.getText().isEmpty()) { // cuando se setee el codigo de licencia
                    // Obtener el valor de la caja de texto del codigo de licencia
                    int cod = Integer.parseInt(frmMenu.txtCodLicencia.getText());
                    //  Ejecutar el metodo consultar licencia por codigo
                    lic = licDAO.consultarLicencia(cod);
                    // Seteo de datos
                    frmMenu.txtNumLicencia.setText(String.valueOf(lic.getNumLicencia()));
                    frmMenu.cboCategoriaLicencia.setSelectedItem(String.valueOf(lic.getCategoria()));
                    frmMenu.txtFechaEmsion.setText(String.valueOf(lic.getFechaEmision()));
                    frmMenu.txtFechaCaducidad.setText(String.valueOf(lic.getFechaCaducidad()));
                    frmMenu.txtTrabajadorAsignadoLicencia.setText(String.valueOf(lic.getTrabajador()));
                    frmMenu.txtIdTrabajadorLicencia.setText(String.valueOf(lic.getTrabajador().getIdTrabajador()));
                    int id = Integer.parseInt(frmMenu.txtIdTrabajadorLicencia.getText());
                    trabajador = TrabajadorDAO.getInstancia().consultarTrabajador(id);
                    frmMenu.txtCargoAsignadoLicencia.setText(String.valueOf(trabajador.getCargo()));
                }
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) { // Evento tecla escape
                limpiarInputs();
                limpiarMensajesError();
                enableButtons();
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  Evento de clickeo en la caja de fechas
        if (e.getSource().equals(frmMenu.cboCategoriaLicencia)) {
            frmMenu.mCategoriaLicencia.setText("");
        }
        if (e.getSource().equals(frmMenu.txtFechaEmsion)) {
            frmMenu.mFechaEmision.setText("");
        }
        if (e.getSource().equals(frmMenu.txtFechaCaducidad)) {
            frmMenu.mFechaCaducidad.setText("");
        }
        //  Evento de clickeo para la tabla de perfilLaboral
        if (e.getSource().equals(frmMenu.tblLicencias)) {
            disableButtons(); // Deshabilitar botones
            limpiarMensajesError(); // Limpiar mensajes de error
            //seleccionar fila de tabla
            int fila = frmMenu.tblLicencias.getSelectedRow();
            // extraer la primera columna de la tabla
            int codPerfil = Integer.parseInt(frmMenu.tblLicencias.getValueAt(fila, 0).toString());
            //  setear el valor extraido 
            frmMenu.txtCodLicencia.setText(String.valueOf(codPerfil));

            if (!frmMenu.txtCodLicencia.getText().isEmpty()) { // cuando se setee el codigo de licencia
                // Obtener el valor de la caja de texto del codigo de licencia
                int cod = Integer.parseInt(frmMenu.txtCodLicencia.getText());
                //  Ejecutar el metodo consultar licencia por codigo
                lic = licDAO.consultarLicencia(cod);
                // Seteo de datos
                frmMenu.txtNumLicencia.setText(String.valueOf(lic.getNumLicencia()));
                frmMenu.cboCategoriaLicencia.setSelectedItem(String.valueOf(lic.getCategoria()));
                frmMenu.txtFechaEmsion.setText(String.valueOf(lic.getFechaEmision()));
                frmMenu.txtFechaCaducidad.setText(String.valueOf(lic.getFechaCaducidad()));
                frmMenu.txtTrabajadorAsignadoLicencia.setText(String.valueOf(lic.getTrabajador()));
                frmMenu.txtIdTrabajadorLicencia.setText(String.valueOf(lic.getTrabajador().getIdTrabajador()));
                int id = Integer.parseInt(frmMenu.txtIdTrabajadorLicencia.getText());
                trabajador = TrabajadorDAO.getInstancia().consultarTrabajador(id);
                frmMenu.txtCargoAsignadoLicencia.setText(String.valueOf(trabajador.getCargo()));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorLicencia)) {
            frmMenu.mTrabajadorAsignadoLicencia.setText("");
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
