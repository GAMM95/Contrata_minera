package Controllers;

import Models.Rol;
import Models.Usuario;
import Models.UsuarioDAO;
import Views.FrmCrearCuenta;
import Views.FrmLogin;
import Views.FrmMenu;
import Views.FrmRecuperar;
//import com.sun.awt.AWTUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class LoginController implements ActionListener, KeyListener {

    // Llamada de las clases
    private final Usuario us;
    private final UsuarioDAO usDAO;
    private final FrmLogin frmLogin;

    Rol tu = new Rol();

    //  Constructor
    public LoginController(Usuario us, UsuarioDAO usDAO, FrmLogin frmLogin) {
        this.us = us;
        this.usDAO = usDAO;
        this.frmLogin = frmLogin;
        interfaces();
        diseñoInterfaz();
        limpiarMensajesError();
    }

    private void interfaces() {
        frmLogin.btnLogin.addActionListener(this);
        frmLogin.btnRecuperarContraseña.addActionListener(this);
        frmLogin.btnCrearCuenta.addActionListener(this);
        frmLogin.btnSalir.addActionListener(this);
        frmLogin.txtUsername.addKeyListener(this);
        frmLogin.txtPassword.addKeyListener(this);
    }

    private void diseñoInterfaz() {
//        Shape forma = new RoundRectangle2D.Double(0, 0, this.frmLogin.getBounds().width, this.frmLogin.getBounds().height, 25, 25); // Redondeado de formulario con radio 25
//        AWTUtilities.setWindowShape(this.frmLogin, forma);
        limpiarInputs(); // invocado del metodo limpiar para establecer el cursor en el campo usuario
        frmLogin.setLocationRelativeTo(null);
        //  Diseño de paneles
        frmLogin.pnlLogin.setBackground(new Color(255, 255, 255));
        frmLogin.pnlDatos.setBackground(new Color(255, 255, 255));
        //  Diseño cuadros de texto
        frmLogin.txtUsername.setFont(new Font("", Font.PLAIN, 14));
        frmLogin.txtPassword.setFont(new Font("", Font.PLAIN, 14));
        //  Diseño de botones
        frmLogin.btnLogin.setBackground(new Color(25, 182, 247));
        this.frmLogin.btnLogin.setText("INGRESAR");
        frmLogin.btnLogin.setForeground(new Color(255, 255, 255));
        frmLogin.btnSalir.setBackground(Color.red);
        frmLogin.btnSalir.setText("SALIR");
        frmLogin.btnSalir.setForeground(new Color(255, 255, 255));
        frmLogin.btnRecuperarContraseña.setBorder(new EmptyBorder(5, 0, 0, 5));
        frmLogin.btnRecuperarContraseña.setBackground(new Color(255, 255, 255));
        frmLogin.btnRecuperarContraseña.setForeground(new Color(25, 182, 247));
        frmLogin.btnRecuperarContraseña.setCursor(new Cursor(Cursor.HAND_CURSOR));
        frmLogin.btnRecuperarContraseña.setFocusPainted(false);
        frmLogin.btnRecuperarContraseña.setBorderPainted(false);
        frmLogin.btnRecuperarContraseña.setContentAreaFilled(false);
        frmLogin.btnCrearCuenta.setBackground(new Color(25, 182, 247));
        frmLogin.btnCrearCuenta.setForeground(new Color(25, 182, 247));
    }

    private void limpiarInputs() {
        frmLogin.txtUsername.setText("");
        frmLogin.txtPassword.setText("");
        frmLogin.txtUsername.requestFocus();
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmLogin.mUsername.setText("");
        frmLogin.mPassword.setText("");
    }

    //  Metodo para setear cajas de texto
    private void setearDatos() {
        //  Datos de entrada para el logeo
        String pass = String.valueOf(frmLogin.txtPassword.getPassword());
        us.setPassword(pass);
        String user = frmLogin.txtUsername.getText().trim();
        //  Llamada al formulario Menu
        FrmMenu abrir = new FrmMenu(us, tu);
        abrir.setVisible(true);
        //  Panel Menu
        abrir.lblRol.setText(tu.getNombreRol());
        abrir.lblNombre.setText(us.getNombre());
        //  Panel Mi Perfil
//        abrir.txtIdUsuario.setText(String.valueOf(us.getIdUsuario()));
//        abrir.txtUsernamePerfil.setText(us.getUsername());
//        abrir.txtNombrePerfil.setText(us.getNombre());
        // Setear foto de usuario
        Image dtcat = usDAO.cargarFoto(user, pass);
        ImageIcon icon = new ImageIcon(dtcat);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(abrir.lblFoto.getWidth(), abrir.lblFoto.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon newIcon = new ImageIcon(newImg);
        abrir.lblFoto.setIcon(newIcon);
    }

    //  Metodo para validar si hay campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmLogin.txtUsername.getText().trim().equals("")) {
            frmLogin.mUsername.setText("Por favor, ingrese su username");
            frmLogin.mUsername.setForeground(Color.red);
            frmLogin.txtUsername.requestFocus();
            action = false;
        } else if (String.valueOf(frmLogin.txtPassword.getPassword()).trim().equals("")) {
            frmLogin.mPassword.setText("Por favor, ingrese su contraseña");
            frmLogin.mPassword.setForeground(Color.red);
            frmLogin.txtPassword.requestFocus();
            action = false;
        }
        return action;
    }

    private boolean validarExistenciaUsuario() {
        boolean valor = false;
        if (usDAO.existeUsuario(frmLogin.txtUsername.getText()) == 0) {
            frmLogin.mUsername.setText("Usted no se encuentra registrado");
            frmLogin.mUsername.setForeground(Color.red);
            frmLogin.mPassword.setText("");
            frmLogin.txtPassword.setText("");
            frmLogin.txtUsername.requestFocus();
            valor = true;
        }
        return valor;
    }

    private void logear() {
        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pass = String.valueOf(frmLogin.txtPassword.getPassword());
        us.setUsername(frmLogin.txtUsername.getText());
        us.setPassword(pass);
        us.setLastSesion(fechaHora.format(date));

        try {
            if (usDAO.login(us, tu)) {
                if (tu.getIdRol() == 1) {
                    setearDatos();
                    this.frmLogin.dispose();
                } else if (tu.getIdRol() == 2) {
                    setearDatos();
                    this.frmLogin.dispose();
                }
            } else {
                frmLogin.mPassword.setText("Contraseña incorrecta");
                frmLogin.mPassword.setForeground(Color.red);
                frmLogin.txtPassword.setText("");
                frmLogin.txtPassword.requestFocus();
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmLogin.btnLogin)) {  // Accion del boton Login
            boolean validarVacios = validarCamposVacios();
            boolean validarUsuario = validarExistenciaUsuario();
            if (validarVacios == false) {
                validarCamposVacios();
            } else {
                if (validarUsuario == true) {
                    validarExistenciaUsuario();
                } else {
                    logear();
                }
            }
        }

        if (e.getSource().equals(frmLogin.btnRecuperarContraseña)) { // Accion del boton recuperar contraseña
            FrmRecuperar abrir = new FrmRecuperar();
            abrir.setVisible(true);
            this.frmLogin.dispose();
        }

        if (e.getSource().equals(frmLogin.btnCrearCuenta)) {
            FrmCrearCuenta abrir = new FrmCrearCuenta();
            abrir.setVisible(true);
            this.frmLogin.dispose();
        }

        if (e.getSource().equals(frmLogin.btnSalir)) {
            this.frmLogin.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(frmLogin.txtUsername)) {
            frmLogin.mUsername.setText("");
        }

        if (e.getSource().equals(frmLogin.txtPassword)) {
            frmLogin.mPassword.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }
}
