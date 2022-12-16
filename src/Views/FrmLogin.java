package Views;

import Controllers.LoginController;
import Models.Usuario;
import Models.UsuarioDAO;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class FrmLogin extends javax.swing.JFrame {
    
    Usuario us = new Usuario();
    UsuarioDAO usDAO = new UsuarioDAO();
    
    public FrmLogin() {
        initComponents();
        LoginController loginControl = new LoginController(us, usDAO, this);
    }

    //Color degradiente para el Background
    class BackgroundGradient extends JPanel {
        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int ancho = getWidth();
            int alto = getHeight();
            GradientPaint gp = new GradientPaint(0, 0, new Color(12, 38, 55), 25, alto, new Color(12, 38, 55));
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, ancho, alto);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JLayeredPane();
        lblTitulo = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JPanel();
        mUsername = new javax.swing.JLabel();
        mPassword = new javax.swing.JLabel();
        txtUsername = new gamm_TextField.TextField();
        txtPassword = new gamm_PasswordField.PasswordField();
        btnRecuperarContraseña = new javax.swing.JButton();
        btnLogin = new gamm_Button.Button();
        btnSalir = new gamm_Button.Button();
        pnlFondo = new BackgroundGradient();
        btnCrearCuenta = new gamm_Button.ButtonLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogin.setOpaque(true);
        pnlLogin.setPreferredSize(new java.awt.Dimension(350, 530));

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("LOGIN");

        mUsername.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mUsername.setText("Mensaje de error");

        mPassword.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mPassword.setText("Mensaje de error");

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUsername.setLabelText("Username");

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPassword.setLabelText("Contraseña");
        txtPassword.setShowAndHide(true);

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(mUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(mPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRecuperarContraseña.setText("Recuperar contraseña");

        btnLogin.setBackground(new java.awt.Color(60, 63, 65));
        btnLogin.setText("INGRESAR");

        btnSalir.setBackground(new java.awt.Color(60, 63, 65));
        btnSalir.setText("SALIR");

        pnlLogin.setLayer(lblTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlLogin.setLayer(pnlDatos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlLogin.setLayer(btnRecuperarContraseña, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlLogin.setLayer(btnLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlLogin.setLayer(btnSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnRecuperarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlLoginLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 48, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblTitulo)
                .addGap(33, 33, 33)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnRecuperarContraseña)
                .addContainerGap())
        );

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlFondo.setPreferredSize(new java.awt.Dimension(350, 530));
        pnlFondo.setLayout(null);

        btnCrearCuenta.setText("CREAR CUENTA");
        pnlFondo.add(btnCrearCuenta);
        btnCrearCuenta.setBounds(100, 440, 150, 40);

        getContentPane().add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        java.awt.EventQueue.invokeLater(() -> {
//            new FrmLogin().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public gamm_Button.ButtonLine btnCrearCuenta;
    public gamm_Button.Button btnLogin;
    public javax.swing.JButton btnRecuperarContraseña;
    public gamm_Button.Button btnSalir;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel mPassword;
    public javax.swing.JLabel mUsername;
    public javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlFondo;
    public javax.swing.JLayeredPane pnlLogin;
    public gamm_PasswordField.PasswordField txtPassword;
    public gamm_TextField.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
