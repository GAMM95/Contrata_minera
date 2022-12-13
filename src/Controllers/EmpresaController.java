package Controllers;

import Models.Empresa;
import Models.EmpresaDAO;
import Models.Validaciones;
import Views.FrmMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EmpresaController implements ActionListener, KeyListener {

    //  Instancias de clases
    private final Empresa em;
    private EmpresaDAO emDAO;
    private FrmMenu frmMenu;

    //  Objetos para abrir logo
    private FileInputStream fis;
    private int longitudBytes;

    //  Controlador de clase
    public EmpresaController(Empresa em, EmpresaDAO emDAO, FrmMenu frmMenu) {
        this.em = em;
        this.emDAO = emDAO;
        this.frmMenu = frmMenu;
        interfaces();   // interfaces implementadas
        diseñoInterfaz();
        //  Vista Administrador
        deshabilitarAdmin();
        mostrarDatos();
        //  Vista Usuario
        deshabilitarUser();
        mostrarDatosUser();
    }

    //  Metodo para implementar las interfaces utilizadas
    private void interfaces() {
        // Eventos ActionListener
        frmMenu.btnSeleccionarLogo.addActionListener(this);
        frmMenu.btnModificarEmpresa.addActionListener(this);
        frmMenu.btnHabilitar.addActionListener(this);
        frmMenu.btnCancelarEmpresa.addActionListener(this);
        frmMenu.ckbAgregarCelular.addActionListener(this);

        //  Eventos KeyListener
        frmMenu.txtRucUpdate.addKeyListener(this);
        frmMenu.txtRazonSocialUpdate.addKeyListener(this);
        frmMenu.txtCiiuUpdate.addKeyListener(this);
        frmMenu.txtTelefonoUpdate.addKeyListener(this);
        frmMenu.txtCelularUpdate.addKeyListener(this);
    }

    private void diseñoInterfaz() {
        // Diseño panel - Vista Administrador
        frmMenu.txtIdEmpresaUpdate.setForeground(Color.white);
        frmMenu.txtIdEmpresaUpdate.setBackground(Color.white);
        frmMenu.txtIdEmpresaUpdate.setForeground(Color.white);
        frmMenu.txtRutaUpdate.setBackground(Color.white);
        frmMenu.txtRutaUpdate.setForeground(Color.lightGray);
        frmMenu.txtIdEmpresaUpdate.setBorder(null);

        // Diseño panel - Vista Usuario
        frmMenu.txtIdEmpresaDatos.setBackground(Color.white);
        frmMenu.txtIdEmpresaDatos.setForeground(Color.white);
        frmMenu.txtRutaEmpresaDatos.setBackground(Color.white);
    }

    //  Metodo para habilitar campos . Vista Administrador
    private void habilitarAdmin() {
        frmMenu.txtRucUpdate.setEditable(true);
        frmMenu.txtRazonSocialUpdate.setEditable(true);
        frmMenu.txtCiiuUpdate.setEditable(true);
        frmMenu.txtTelefonoUpdate.setEditable(true);
        frmMenu.ckbAgregarCelular.setEnabled(true);
        frmMenu.txtDireccionUpdate.setEditable(true);
        frmMenu.txtEmailUpdate.setEditable(true);
        frmMenu.txtPagWebUpdate.setEditable(true);
        frmMenu.btnHabilitar.setEnabled(false);
        frmMenu.btnModificarEmpresa.setEnabled(true);
        frmMenu.btnSeleccionarLogo.setEnabled(true);
        frmMenu.btnCancelarEmpresa.setEnabled(true);
    }

    //  Metodo para deshabilitar campos de entrada - Vista Administrador
    private void deshabilitarAdmin() {
        frmMenu.txtRucUpdate.setEditable(false);
        frmMenu.txtRazonSocialUpdate.setEditable(false);
        frmMenu.txtCiiuUpdate.setEditable(false);
        frmMenu.txtTelefonoUpdate.setEditable(false);
        frmMenu.ckbAgregarCelular.setEnabled(false);
        frmMenu.txtDireccionUpdate.setEditable(false);
        frmMenu.txtEmailUpdate.setEditable(false);
        frmMenu.txtPagWebUpdate.setEditable(false);
        frmMenu.btnHabilitar.setEnabled(true);
        frmMenu.btnModificarEmpresa.setEnabled(false);
        frmMenu.btnSeleccionarLogo.setEnabled(false);
        frmMenu.btnCancelarEmpresa.setEnabled(false);
    }

    //  Metodo para deshabilitar campos de entrada - Vista Usuario
    private void deshabilitarUser() {
        frmMenu.txtRucDatos.setEditable(false);
        frmMenu.txtRucDatos.setEditable(false);
        frmMenu.txtRazonSocialDatos.setEditable(false);
        frmMenu.txtCiiuDatos.setEditable(false);
        frmMenu.txtTelefonoEmpresaDatos.setEditable(false);
        frmMenu.txtDireccionEmpresaDatos.setEditable(false);
        frmMenu.txtCelularEmpresaDatos.setEditable(false);
        frmMenu.txtEmailEmpresaDatos.setEditable(false);
        frmMenu.txtPaginaWebEmpresaDatos.setEditable(false);
    }

    //  Metodo para omdificar logo de empresa - Vista Administrador
    private void modificarConFoto(Empresa e, File ruta) {
        em.setCodEmpresa(e.getCodEmpresa());
        em.setRuc(e.getRuc());
        em.setRazonSocial(e.getRazonSocial());
        em.setCiiu(e.getCiiu());
        em.setTelefono(e.getTelefono());
        em.setCelular(e.getCelular());
        em.setDireccionLegal(e.getDireccionLegal());
        em.setEmail(e.getEmail());
        em.setPaginaWeb(e.getPaginaWeb());
        em.setPath(e.getPath());
        try {
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            em.setLogo(icono);
        } catch (IOException ex) {
            em.setLogo(null);
            System.out.println("Error modificar 1 " + ex.getMessage());
        }
        emDAO.modificar_EmpresaConFoto(em);
    }

    //  Metodo para modificar datos sin logo de empresa - Vista Administrador 
    public void modificarSinFoto(Empresa e) {
        em.setCodEmpresa(e.getCodEmpresa());
        em.setRuc(e.getRuc());
        em.setRazonSocial(e.getRazonSocial());
        em.setCiiu(e.getCiiu());
        em.setTelefono(e.getTelefono());
        em.setCelular(e.getCelular());
        em.setDireccionLegal(e.getDireccionLegal());
        em.setEmail(e.getEmail());
        em.setPaginaWeb(e.getPaginaWeb());
        // llamada al metodo DAO 
        emDAO.modificar_EmpresaSinFoto(em);
    }

    //  Metodo para setear datos de empresa
    private void mostrarDatos() {
        int id = Integer.parseInt(frmMenu.txtIdEmpresaUpdate.getText());

        Empresa x = emDAO.mostrarDatos(id);
        if (x != null) {
            frmMenu.txtRucUpdate.setText(x.getRuc());
            frmMenu.txtRazonSocialUpdate.setText(x.getRazonSocial());
            frmMenu.txtCiiuUpdate.setText(x.getCiiu());
            frmMenu.txtTelefonoUpdate.setText(x.getTelefono());
            frmMenu.txtCelularUpdate.setText(x.getCelular());
            frmMenu.txtDireccionUpdate.setText(x.getDireccionLegal());
            frmMenu.txtEmailUpdate.setText(x.getEmail());
            frmMenu.txtPagWebUpdate.setText(x.getPaginaWeb());
            frmMenu.txtRutaUpdate.setText(x.getPath());
            if (em.getLogo() == null) {
                frmMenu.mLogoUpdate.setText("Sin logo de empresa");
                frmMenu.mLogoUpdate.setForeground(new Color(3, 155, 216));
            } else {
                ImageIcon icon = new ImageIcon(x.getLogo());
                Image newImg = icon.getImage().getScaledInstance(frmMenu.lblLogoUpdate.getWidth(), frmMenu.lblLogoUpdate.getHeight(), Image.SCALE_DEFAULT);
                frmMenu.lblLogoUpdate.setIcon(new ImageIcon(newImg));
                frmMenu.lblLogoUpdate.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this.frmMenu.INICIO, "Datos vacíos");
            frmMenu.mLogoUpdate.setText("Datos de empresa vacíos");

        }
    }

    //  Mostrar datos seteados de la empresa - Vista Usuario
    private void mostrarDatosUser() {
        int id = Integer.parseInt(frmMenu.txtIdEmpresaDatos.getText());   //  Id seteado 

        Empresa x = emDAO.mostrarDatos(id);
        if (x != null) {
            frmMenu.txtRucDatos.setText(x.getRuc());
            frmMenu.txtRazonSocialDatos.setText(x.getRazonSocial());
            frmMenu.txtCiiuDatos.setText(x.getCiiu());
            frmMenu.txtTelefonoEmpresaDatos.setText(x.getTelefono());
            frmMenu.txtCelularEmpresaDatos.setText(x.getCelular());
            frmMenu.txtDireccionEmpresaDatos.setText(x.getDireccionLegal());
            frmMenu.txtEmailEmpresaDatos.setText(x.getEmail());
            frmMenu.txtPaginaWebEmpresaDatos.setText(x.getPaginaWeb());
            frmMenu.txtRutaEmpresaDatos.setText(x.getPath());
            //  Seteado del logo de la empresa
            ImageIcon icon = new ImageIcon(x.getLogo());
            Image im = icon.getImage();
            Image miImage = im.getScaledInstance(frmMenu.lblLogoEmpresaDatos.getWidth(), frmMenu.lblLogoEmpresaDatos.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(miImage);
            frmMenu.lblLogoEmpresaDatos.setIcon(newImage);
            frmMenu.lblLogoEmpresaDatos.setText("");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento ActionPerformerd para abrir JFileChooser y seleccionar foto
        if (e.getSource().equals(frmMenu.btnSeleccionarLogo)) {
            //  Cambiamos la forma de diseño de dialogo
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.out.println("Error de lookAndFeel: " + ex.getMessage());
            }
            //  Abrir el Selector de archivos
            JFileChooser se = new JFileChooser();
            se.setFileSelectionMode(JFileChooser.FILES_ONLY); // Establecer modo de seleccion (Solo archivos)
            se.setDialogTitle("Seleccionar imagen"); // Titulo de dialogo
            FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif"); // Filtro de formatos
            se.setFileFilter(fil); // Mostrar en el dialog los formatos filtrados
            int estado = se.showOpenDialog(null);
            if (estado == JFileChooser.APPROVE_OPTION) {
                try {
                    String ruta = se.getSelectedFile().getAbsolutePath();
                    fis = new FileInputStream(se.getSelectedFile());
                    this.longitudBytes = (int) se.getSelectedFile().length();
                    Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(frmMenu.lblLogoUpdate.getWidth(), frmMenu.lblLogoUpdate.getHeight(), Image.SCALE_DEFAULT);
                    frmMenu.lblLogoUpdate.setIcon(new ImageIcon(icono));
                    frmMenu.lblLogoUpdate.updateUI();
                    frmMenu.lblLogoUpdate.setText("");
                    frmMenu.txtRutaUpdate.setText(ruta);
                } catch (FileNotFoundException ex) {
                    System.out.println("Error en el primer catch");
                } catch (IOException ex) {
                    System.out.println("Error en el segundo catch");
                }
            }
        }
        //  Evento para actualizar datos de la empresa
        if (e.getSource().equals(frmMenu.btnModificarEmpresa)) {
            em.setCodEmpresa(Integer.parseInt(frmMenu.txtIdEmpresaUpdate.getText()));
            em.setRuc(frmMenu.txtRucUpdate.getText());
            em.setRazonSocial(frmMenu.txtRazonSocialUpdate.getText());
            em.setCiiu(frmMenu.txtCiiuUpdate.getText());
            em.setTelefono(frmMenu.txtTelefonoUpdate.getText());
            em.setCelular(frmMenu.txtCelularUpdate.getText());
            em.setDireccionLegal(frmMenu.txtDireccionUpdate.getText());
            em.setEmail(frmMenu.txtEmailUpdate.getText());
            em.setPaginaWeb(frmMenu.txtPagWebUpdate.getText());
            em.setPath(frmMenu.txtRutaUpdate.getText());
            File ruta = new File(frmMenu.txtRutaUpdate.getText());
            if (ruta != null) {
                modificarConFoto(em, ruta);
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                deshabilitarAdmin();
            } else {
                modificarSinFoto(em);
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                deshabilitarAdmin();
            }
        }
        if (e.getSource().equals(frmMenu.btnHabilitar)) {
            habilitarAdmin();
        }
        if (e.getSource().equals(frmMenu.btnCancelarEmpresa)) {
            deshabilitarAdmin();
        }
        if (e.getSource().equals(frmMenu.ckbAgregarCelular)) {
            if (frmMenu.ckbAgregarCelular.isSelected()) {
                frmMenu.txtCelularUpdate.setEnabled(true);
            } else {
                frmMenu.txtCelularUpdate.setEnabled(false);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //  Evento KeyTyped para validar la cantidad de caracteres
        if (e.getSource().equals(frmMenu.txtRucUpdate)) {
            Validaciones.soloDigitos(e);
            int limite = 11;
            if (frmMenu.txtRucUpdate.getText().length() == limite) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtRazonSocialUpdate)) {
            int limite = 60;
            if (frmMenu.txtRazonSocialUpdate.getText().length() == limite) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtCiiuUpdate)) {
            Validaciones.soloDigitos(e);
            int limite = 5;
            if (frmMenu.txtCiiuUpdate.getText().length() == limite) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtTelefonoUpdate)) {
            Validaciones.soloDigitos(e);
            int limite = 9;
            if (frmMenu.txtTelefonoUpdate.getText().length() == limite) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtCelularUpdate)) {
            Validaciones.soloDigitos(e);
            int limite = 9;
            if (frmMenu.txtCelularUpdate.getText().length() == limite) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
