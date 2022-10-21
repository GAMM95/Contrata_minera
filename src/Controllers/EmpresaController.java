package Controllers;

import Models.Empresa;
import Models.EmpresaDAO;
import Views.FrmMenu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EmpresaController implements ActionListener {

    private final Empresa em;
    private EmpresaDAO emDAO;
    private FrmMenu frmMenu;

    private FileInputStream fis;
    private int longitudBytes;

    public EmpresaController(Empresa em, EmpresaDAO emDAO, FrmMenu frmMenu) {
        this.em = em;
        this.emDAO = emDAO;
        this.frmMenu = frmMenu;
        interfaces();
        diseñoInterfaz();
        deshabilitar();
        mostrarDatos();
    }

    private void interfaces() {
        frmMenu.btnSeleccionarLogo.addActionListener(this);
        frmMenu.btnActualizarDatosEmpresa.addActionListener(this);
        frmMenu.btnHabilitar.addActionListener(this);
        frmMenu.btnCancelarEmpresa.addActionListener(this);
    }

    private void diseñoInterfaz() {
        frmMenu.txtIdEmpresaUpdate.setForeground(Color.white);
        frmMenu.txtIdEmpresaUpdate.setBackground(Color.white);
        frmMenu.txtIdEmpresaUpdate.setForeground(Color.white);
        frmMenu.txtRutaUpdate.setBackground(Color.white);
        frmMenu.txtRutaUpdate.setForeground(Color.lightGray);
        frmMenu.txtIdEmpresaUpdate.setBorder(null);
    }

    private void habilitar() {
        frmMenu.txtRucUpdate.setEditable(true);
        frmMenu.txtRazonSocialUpdate.setEditable(true);
        frmMenu.txtCiiuUpdate.setEditable(true);
        frmMenu.txtTelefonoUpdate.setEditable(true);
        frmMenu.txtCelularUpdate.setEditable(true);
        frmMenu.txtDireccionUpdate.setEditable(true);
        frmMenu.txtEmailUpdate.setEditable(true);
        frmMenu.txtPagWebUpdate.setEditable(true);
        frmMenu.btnHabilitar.setEnabled(false);
        frmMenu.btnActualizarDatosEmpresa.setEnabled(true);
        frmMenu.btnSeleccionarLogo.setEnabled(true);
        frmMenu.btnCancelarEmpresa.setEnabled(true);
    }

    private void deshabilitar() {
        frmMenu.txtRucUpdate.setEditable(false);
        frmMenu.txtRazonSocialUpdate.setEditable(false);
        frmMenu.txtCiiuUpdate.setEditable(false);
        frmMenu.txtTelefonoUpdate.setEditable(false);
        frmMenu.txtCelularUpdate.setEditable(false);
        frmMenu.txtDireccionUpdate.setEditable(false);
        frmMenu.txtEmailUpdate.setEditable(false);
        frmMenu.txtPagWebUpdate.setEditable(false);
        frmMenu.btnHabilitar.setEnabled(true);
        frmMenu.btnActualizarDatosEmpresa.setEnabled(false);
        frmMenu.btnSeleccionarLogo.setEnabled(false);
        frmMenu.btnCancelarEmpresa.setEnabled(false);
    }

    private void modificar(Empresa e, File ruta) {
        emDAO = new EmpresaDAO();

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
        emDAO.modificar_Empresa(em);
    }

    public void modificar2(Empresa e) {
        emDAO = new EmpresaDAO();

        em.setCodEmpresa(e.getCodEmpresa());
        em.setRuc(e.getRuc());
        em.setRazonSocial(e.getRazonSocial());
        em.setCiiu(e.getCiiu());
        em.setTelefono(e.getTelefono());
        em.setCelular(e.getCelular());
        em.setDireccionLegal(e.getDireccionLegal());
        em.setEmail(e.getEmail());
        em.setPaginaWeb(e.getPaginaWeb());

        emDAO.modificar_Empresa2(em);
    }

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
            ImageIcon icon = new ImageIcon(x.getLogo());
            Image newImg = icon.getImage().getScaledInstance(frmMenu.lblLogoUpdate.getWidth(), frmMenu.lblLogoUpdate.getHeight(), Image.SCALE_DEFAULT);
            frmMenu.lblLogoUpdate.setIcon(new ImageIcon(newImg));
            frmMenu.lblLogoUpdate.setText("");

        } else {
            JOptionPane.showMessageDialog(this.frmMenu, "Datos vacíos");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmMenu.btnSeleccionarLogo)) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.out.println("Error de lookAndFeel: " + ex.getMessage());
            }
            JFileChooser se = new JFileChooser();
            se.setFileSelectionMode(JFileChooser.FILES_ONLY);
            se.setDialogTitle("Seleccionar imagen");
            FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
            se.setFileFilter(fil);
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
        if (e.getSource().equals(frmMenu.btnActualizarDatosEmpresa)) {
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
                modificar(em, ruta);
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                deshabilitar();
            } else {
                modificar2(em);
                JOptionPane.showMessageDialog(null, "Datos actualizados");
                deshabilitar();
            }
        }
        if (e.getSource().equals(frmMenu.btnHabilitar)) {
            habilitar();
        }
        if (e.getSource().equals(frmMenu.btnCancelarEmpresa)) {
            deshabilitar();
        }
    }
}
