package Controllers;

import Models.Usuario;
import Models.UsuarioDAO;
import Views.FrmLogin;
import Views.FrmRecuperar;
//import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class RecuperarPassController implements ActionListener, KeyListener {

    //  Instancia de clases
    private final Usuario us;
    private final UsuarioDAO usDAO;
    private final FrmRecuperar frmRecuperar;

    public RecuperarPassController(Usuario us, UsuarioDAO usDAO, FrmRecuperar frmRecuperar) {
        this.us = us;
        this.usDAO = usDAO;
        this.frmRecuperar = frmRecuperar;
        frmRecuperar.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //  Solo cerrar este formulario
        interfaces();
        diseñoInterfaz();
        limpiarMensajesError();
    }

    //  Metodo para implementar interfaces
    private void interfaces() {
        frmRecuperar.btnLogin.addActionListener(this);
        frmRecuperar.btnBuscar.addActionListener(this);
        frmRecuperar.txtUsername.addKeyListener(this);
    }

    //  Metodo de diseño del formulario de recuperacion de contraseña
    private void diseñoInterfaz() {
        frmRecuperar.setLocationRelativeTo(null);
//        Shape forma = new RoundRectangle2D.Double(0, 0, frmRecuperar.getBounds().width, frmRecuperar.getBounds().height, 25, 25);
//        AWTUtilities.setWindowShape(frmRecuperar, forma);
        //   Diseño botones
        frmRecuperar.btnLogin.setBackground(new Color(25, 182, 247));
        frmRecuperar.btnLogin.setForeground(new Color(25, 182, 247));
        frmRecuperar.btnBuscar.setBackground(new Color(25, 182, 247));
        frmRecuperar.btnBuscar.setForeground(new Color(255, 255, 255));
    }

    //  Metodo para limpiar entradas
    private void limpiarInputs() {
        frmRecuperar.txtUsername.setText("");
        frmRecuperar.txtUsername.requestFocus();
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmRecuperar.mUsername.setText("");
        frmRecuperar.mContraseña.setText("");
    }

    //  Metodo para validar campos vacios
    public boolean validarCamposVacios() {
        boolean action = true;
        if (frmRecuperar.txtUsername.getText().trim().equals("")) {
            frmRecuperar.mUsername.setText("Por favor, ingrese su username");
            frmRecuperar.mUsername.setForeground(Color.red);
            frmRecuperar.txtUsername.requestFocus();
            action = false;
        }
        return action;
    }

    //  Metodo para validar la existencia del username
    private boolean validarExistenciaUsername() {
        boolean valor = false;
        if (usDAO.existeUsuario(frmRecuperar.txtUsername.getText()) == 0) {
            frmRecuperar.mUsername.setText("Usted no se encuentra registrado");
            frmRecuperar.mUsername.setForeground(Color.red);
            frmRecuperar.txtUsername.requestFocus();
            valor = true;
        }
        return valor;
    }

    //  Metodo para que muestre la contraseña del username digitado
    private void recuperarContraseña() {
        us.setUsername(frmRecuperar.txtUsername.getText());
        try {
            if (usDAO.recuperarPassword(us)) {
                frmRecuperar.mContraseña.setText(us.getUsername() + ", tu contraseña es: " + us.getPassword());
                limpiarInputs();
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmRecuperar.btnLogin)) {  // Evento del boton Login
            FrmLogin abrir = new FrmLogin();
            abrir.setVisible(true);
            frmRecuperar.dispose();
        }
        if (e.getSource().equals(frmRecuperar.btnBuscar)) {
            boolean validarVacios = validarCamposVacios();
            boolean validarUsuario = validarExistenciaUsername();

            if (validarVacios == false) {
                validarCamposVacios();
            } else {
                if (validarUsuario == true) {
                    validarExistenciaUsername();
                    frmRecuperar.mContraseña.setText("");
                } else {
                    recuperarContraseña();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(frmRecuperar.txtUsername)) {
            frmRecuperar.mUsername.setText("");
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

}
