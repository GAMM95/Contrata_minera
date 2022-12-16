package Views;

import Controllers.CrearCuentaController;
import Models.Usuario;
import Models.UsuarioDAO;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class FrmCrearCuenta extends javax.swing.JFrame {

    //  Intancias de las clases involucradas
    Usuario us = new Usuario();
    UsuarioDAO usDAO = new UsuarioDAO();

    public FrmCrearCuenta() {
        initComponents();
        CrearCuentaController cuentaController = new CrearCuentaController(us, usDAO, this);    //  Instancia del controlador cargo
    }

    //Color degradiente para el Background
    class BackgroundGradient extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int ancho = getWidth();
            int alto = getHeight();
            GradientPaint gp = new GradientPaint(0, 0, new Color(12, 38, 55), 25, alto, new Color(12, 38, 55)); //  Colores en RGB
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, ancho, alto);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDatos = new javax.swing.JPanel();
        mUsername = new javax.swing.JLabel();
        mPassword = new javax.swing.JLabel();
        mNombre = new javax.swing.JLabel();
        mEmail = new javax.swing.JLabel();
        txtUsername = new gamm_TextField.TextField();
        txtPassword = new gamm_PasswordField.PasswordField();
        txtPasswordConfirm = new gamm_PasswordField.PasswordField();
        txtNombre = new gamm_TextField.TextField();
        txtEmail = new gamm_TextField.TextField();
        cboRol = new gamm_ComboBox.Combobox<>();
        btnRegistrar = new gamm_Button.Button();
        pnlFondo1 = new BackgroundGradient();
        lblFoto = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        mFoto = new javax.swing.JLabel();
        btnLogin = new gamm_Button.ButtonLine();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDatos.setBackground(new java.awt.Color(255, 255, 255));
        pnlDatos.setPreferredSize(new java.awt.Dimension(350, 530));

        mUsername.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mUsername.setText("Mensaje de error");

        mPassword.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mPassword.setText("Mensaje de error");

        mNombre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombre.setText("Mensaje de error");

        mEmail.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mEmail.setText("Mensaje de error");

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUsername.setLabelText("Username");

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPassword.setLabelText("Contraseña");
        txtPassword.setShowAndHide(true);

        txtPasswordConfirm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPasswordConfirm.setLabelText("Confirmar contraseña");
        txtPasswordConfirm.setShowAndHide(true);

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombre.setLabelText("Nombre");

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEmail.setLabelText("Email");

        cboRol.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboRol.setLabeText("Rol");

        btnRegistrar.setBackground(new java.awt.Color(0, 51, 204));
        btnRegistrar.setText("REGISTRAR");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                    .addComponent(mNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(pnlDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        pnlFondo1.setPreferredSize(new java.awt.Dimension(350, 530));
        pnlFondo1.setLayout(null);

        lblFoto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("FOTO");
        pnlFondo1.add(lblFoto);
        lblFoto.setBounds(80, 140, 200, 210);

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CREAR CUENTA");
        pnlFondo1.add(lblTitulo);
        lblTitulo.setBounds(0, 70, 350, 32);

        mFoto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFoto.setText("Mensaje de error");
        pnlFondo1.add(mFoto);
        mFoto.setBounds(80, 350, 200, 30);

        btnLogin.setText("LOGIN");
        pnlFondo1.add(btnLogin);
        btnLogin.setBounds(100, 440, 146, 40);

        getContentPane().add(pnlFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
//            java.util.logging.Logger.getLogger(FrmCrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        java.awt.EventQueue.invokeLater(() -> {
//            new FrmCrearCuenta().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public gamm_Button.ButtonLine btnLogin;
    public gamm_Button.Button btnRegistrar;
    public gamm_ComboBox.Combobox<Models.Rol> cboRol;
    public javax.swing.JLabel lblFoto;
    public javax.swing.JLabel lblTitulo;
    public javax.swing.JLabel mEmail;
    public javax.swing.JLabel mFoto;
    public javax.swing.JLabel mNombre;
    public javax.swing.JLabel mPassword;
    public javax.swing.JLabel mUsername;
    public javax.swing.JPanel pnlDatos;
    public javax.swing.JPanel pnlFondo1;
    public gamm_TextField.TextField txtEmail;
    public gamm_TextField.TextField txtNombre;
    public gamm_PasswordField.PasswordField txtPassword;
    public gamm_PasswordField.PasswordField txtPasswordConfirm;
    public gamm_TextField.TextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
