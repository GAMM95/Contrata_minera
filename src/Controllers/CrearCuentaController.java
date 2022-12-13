package Controllers;

import Models.Usuario;
import Models.UsuarioDAO;
import Views.FrmCrearCuenta;
import Views.FrmLogin;
//import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CrearCuentaController implements ActionListener, KeyListener, MouseListener {

    private final Usuario us;
    private final UsuarioDAO usDAO;
    private final FrmCrearCuenta frmCrearCuenta;

    private FileInputStream fis;
    private int longitudBytes;

    public CrearCuentaController(Usuario us, UsuarioDAO usDAO, FrmCrearCuenta frmCrearCuenta) {
        this.us = us;
        this.usDAO = usDAO;
        this.frmCrearCuenta = frmCrearCuenta;
        interfaces();
        diseñoInterfaz();
        llenarPrivilegios();
        limpiarInputs();
        limpiarMensajesError();
    }

    private void interfaces() {
        frmCrearCuenta.btnRegistrar.addActionListener(this);
        frmCrearCuenta.btnLogin.addActionListener(this);
        frmCrearCuenta.txtUsername.addKeyListener(this);
        frmCrearCuenta.txtPassword.addKeyListener(this);
        frmCrearCuenta.txtPasswordConfirm.addKeyListener(this);
        frmCrearCuenta.txtNombre.addKeyListener(this);
        frmCrearCuenta.txtEmail.addKeyListener(this);
        frmCrearCuenta.lblFoto.addMouseListener(this);
    }

    private void diseñoInterfaz() {
        frmCrearCuenta.setLocationRelativeTo(null);
//        Shape forma = new RoundRectangle2D.Double(0, 0, this.frmCrearCuenta.getBounds().width, this.frmCrearCuenta.getBounds().height, 25, 25);
//        AWTUtilities.setWindowShape(frmCrearCuenta, forma);
        //  Diseño botones
        frmCrearCuenta.lblFoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        frmCrearCuenta.lblFoto.setForeground(Color.white);
        frmCrearCuenta.lblFoto.setBorder(LineBorder.createGrayLineBorder());
        frmCrearCuenta.mFoto.setForeground(Color.white);
        frmCrearCuenta.mFoto.setText("Obligatorio (*)");
        frmCrearCuenta.lblTitulo.setForeground(Color.white);
        frmCrearCuenta.btnLogin.setBackground(new Color(25, 182, 247));
        frmCrearCuenta.btnLogin.setForeground(new Color(25, 182, 247));
        frmCrearCuenta.btnRegistrar.setBackground(new Color(25, 182, 247));
        frmCrearCuenta.btnRegistrar.setForeground(new Color(255, 255, 255));
    }

    //  Metodo para limpiar entradas
    private void limpiarInputs() {
        frmCrearCuenta.txtUsername.setText("");
        frmCrearCuenta.txtPassword.setText("");
        frmCrearCuenta.txtPasswordConfirm.setText("");
        frmCrearCuenta.txtNombre.setText("");
        frmCrearCuenta.txtEmail.setText("");
        frmCrearCuenta.txtUsername.requestFocus();
        frmCrearCuenta.cboRol.setSelectedIndex(0);
        frmCrearCuenta.lblFoto.setIcon(null);
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmCrearCuenta.mUsername.setText("");
        frmCrearCuenta.mPassword.setText("");
        frmCrearCuenta.mNombre.setText("");
        frmCrearCuenta.mEmail.setText("");
    }

    //  Metodo para llenar comboBox de roles
    private void llenarPrivilegios() {
        try {
            usDAO.llenarCombo(frmCrearCuenta.cboRol);
        } catch (SQLException ex) {
            System.out.println("Error grave: " + ex.getMessage());
        }
    }

//    //metodo para guardar usuario
//    private void GuardarImagen() {
//        String username = frmCrearCuenta.txtUsername.getText().trim();
//        String password = frmCrearCuenta.txtPassword.getText();
//        String nombre = frmCrearCuenta.txtNombre.getText();
//        String email = frmCrearCuenta.txtEmail.getText();
//        int idRol = frmCrearCuenta.cboRol.getItemAt(frmCrearCuenta.cboRol.getSelectedIndex()).getIdRol();
//        try {
//            usDAO.registrarUsuario(username, password, nombre, email, idRol, fis, longitudBytes);
//        } catch (SQLException ex) {
//            System.out.println("Error guardar imagen " + ex.getMessage());
//        }
//    }
    //  Metodo para registrar usuario
    private void GuardarImagen() {
        us.setUsername(frmCrearCuenta.txtUsername.getText().trim());
        us.setPassword(frmCrearCuenta.txtPassword.getText().trim());
        us.setNombre(frmCrearCuenta.txtNombre.getText().trim());
        us.setEmail(frmCrearCuenta.txtEmail.getText().trim());
        us.setIdRol(frmCrearCuenta.cboRol.getItemAt(frmCrearCuenta.cboRol.getSelectedIndex()).getIdRol());
        usDAO.registrarUsuario(us, fis, longitudBytes);
    }

    //   Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmCrearCuenta.txtUsername.getText().trim().equals("")) {
            frmCrearCuenta.mUsername.setText("Por favor, ingrese su username");
            frmCrearCuenta.mUsername.setForeground(Color.red);
            frmCrearCuenta.txtUsername.requestFocus();
            action = false;
        } else if (String.valueOf(frmCrearCuenta.txtPassword.getPassword()).trim().isEmpty() || String.valueOf(frmCrearCuenta.txtPasswordConfirm.getPassword()).trim().isEmpty()) {
            frmCrearCuenta.mPassword.setText("Por favor, ingrese su contraseña");
            frmCrearCuenta.mPassword.setForeground(Color.red);
            frmCrearCuenta.txtPassword.requestFocus();
            action = false;
        } else if (frmCrearCuenta.txtNombre.getText().isEmpty()) {
            frmCrearCuenta.mNombre.setText("Por favor, ingrese su nombre");
            frmCrearCuenta.mNombre.setForeground(Color.red);
            frmCrearCuenta.txtNombre.requestFocus();
            action = false;
        } else if (frmCrearCuenta.txtEmail.getText().isEmpty()) {
            frmCrearCuenta.mEmail.setText("Por favor, ingrese su Email");
            frmCrearCuenta.mEmail.setForeground(Color.red);
            frmCrearCuenta.txtEmail.requestFocus();
            action = false;
        } else if (frmCrearCuenta.lblFoto.getText().equals("FOTO")) {
            frmCrearCuenta.mFoto.setText("Por favor, escoja su foto de perfil");
            frmCrearCuenta.mFoto.setForeground(Color.red);
            action = false;
        } else if (frmCrearCuenta.txtUsername.getText().trim().isEmpty() && String.valueOf(frmCrearCuenta.txtPassword.getPassword()).trim().isEmpty() && frmCrearCuenta.txtNombre.getText().isEmpty() && frmCrearCuenta.txtEmail.getText().isEmpty() && frmCrearCuenta.lblFoto.getText().equals("FOTO")) {
            frmCrearCuenta.txtUsername.requestFocus();
            action = false;
        }
        return action;
    }

    private boolean validarContraseña() {
        boolean action = true;
        String pass = frmCrearCuenta.txtPassword.getText();
        String passCon = frmCrearCuenta.txtPasswordConfirm.getText();
        if (!pass.equals(passCon)) {
            frmCrearCuenta.mPassword.setText("Las contraseñas no coinciden");
            frmCrearCuenta.mPassword.setForeground(Color.red);
            frmCrearCuenta.txtPasswordConfirm.requestFocus();
            action = false;
        }
        return action;
    }

    //  Metodo para validar email
    private boolean validarEmail() {
        boolean action = true;
        if (!usDAO.esEmail(frmCrearCuenta.txtEmail.getText())) {
            frmCrearCuenta.mEmail.setText("Email no válido");
            frmCrearCuenta.mEmail.setForeground(Color.red);
            frmCrearCuenta.txtEmail.requestFocus();
            action = false;
        }
        return action;
    }

    //  Metodo para validad si usuario existe
    private boolean validarExistenciaUsuario() {
        boolean valor = true;   //  Valor inicial verdadero
        if (usDAO.existeUsuario(frmCrearCuenta.txtUsername.getText()) != 0) {
            frmCrearCuenta.mUsername.setText("Username " + frmCrearCuenta.txtUsername.getText() + " ya existe");    // Mensaje de error
            frmCrearCuenta.mUsername.setForeground(Color.red);
            frmCrearCuenta.txtUsername.requestFocus();
            valor = false;
        }
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmCrearCuenta.btnLogin)) {
            FrmLogin abrir = new FrmLogin();
            abrir.setVisible(true);
            frmCrearCuenta.dispose();
        }
        if (e.getSource().equals(frmCrearCuenta.btnRegistrar)) {
            boolean validarVacios = validarCamposVacios(); // boolean: TRUE
            boolean validarContraseña = validarContraseña();    //  boolean: TRUE
            boolean validarUsuario = validarExistenciaUsuario();
            boolean validarEmail = validarEmail();

            if (validarVacios == false) {   //  Si validar campos vacios es falso
                validarCamposVacios();  //  mostrar el mensaje del metodo
            } else {    //  no mostrar mensaje del metodo validar mensajes vacios
                if (validarContraseña == false) {
                    validarContraseña();
                } else {
                    if (validarUsuario == false) {
                        validarExistenciaUsuario();
                        frmCrearCuenta.txtUsername.setText("");
                    } else {
                        if (validarEmail == false) {
                            validarEmail();
                        } else {
                            GuardarImagen();
                            limpiarInputs();
                            JOptionPane.showMessageDialog(null, "Usuario registrado.");
                            FrmLogin abrir = new FrmLogin();
                            abrir.setVisible(true);
                            frmCrearCuenta.dispose();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(frmCrearCuenta.txtUsername)) {
            frmCrearCuenta.mUsername.setText("");
        }
        if (e.getSource().equals(frmCrearCuenta.txtNombre)) {
            frmCrearCuenta.mNombre.setText("");
        }
        if (e.getSource().equals(frmCrearCuenta.txtEmail)) {
            frmCrearCuenta.mEmail.setText("");
        }
        if (e.getSource().equals(frmCrearCuenta.txtPassword) || e.getSource().equals(frmCrearCuenta.txtPasswordConfirm)) {
            frmCrearCuenta.mPassword.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  Evento MouseClicked para seleccionar foto de usuario
        if (e.getSource().equals(frmCrearCuenta.lblFoto)) {
            //  Cambio de diseño de dialog
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.out.println("Error de lookAndFeel: " + ex.getMessage());
            }
            JFileChooser se = new JFileChooser();
            se.setFileSelectionMode(JFileChooser.FILES_ONLY); //  Permiso solo de archivos
            File nuevaRuta = new File("C:\\Users\\Acer\\Pictures\\Mis escaneos");  // ruta del directorio
            se.setCurrentDirectory(nuevaRuta);
            se.setDialogTitle("Seleccionar foto"); // titulo de dialog
            se.setMultiSelectionEnabled(false); //solo puedo seleccionar un archivo a la vez 
            se.setApproveButtonText("Seleccionar"); //  Boton seleccionar
            se.setFileFilter(new FileNameExtensionFilter("Imágenes", "png", "jpg"));
            int estado = se.showOpenDialog(null);
            if (estado == JFileChooser.APPROVE_OPTION) { // comprobar si se ha puslsado aceptar
                try {
                    fis = new FileInputStream(se.getSelectedFile());
                    this.longitudBytes = (int) se.getSelectedFile().length();
                    Image icono = ImageIO.read(se.getSelectedFile()).getScaledInstance(frmCrearCuenta.lblFoto.getWidth(), frmCrearCuenta.lblFoto.getHeight(), Image.SCALE_DEFAULT);
                    frmCrearCuenta.lblFoto.setIcon(new ImageIcon(icono));
                    frmCrearCuenta.lblFoto.updateUI();
                    frmCrearCuenta.lblFoto.setText("");
                    frmCrearCuenta.mFoto.setText("");
                } catch (FileNotFoundException ex) {
                    System.out.println("Error en el primer catch" + ex.getMessage());
                } catch (IOException ex) {
                    System.out.println("Error en el segundo catch");
                }
            } else if (estado == JFileChooser.CANCEL_OPTION) {
                frmCrearCuenta.mFoto.setText("No se seleccionó foto");
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
