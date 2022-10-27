package Views;

import Controllers.CargoController;
import Controllers.DatosEmpresaController;
import Controllers.EmpresaController;
import Controllers.MenuController;
import Controllers.MiPerfilController;
import Controllers.TrabajadorController;

import Models.Cargo;
import Models.CargoDAO;
import Models.Empresa;
import Models.EmpresaDAO;
import Models.Rol;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Models.Usuario;
import Models.UsuarioDAO;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrmMenu extends javax.swing.JFrame {

    //  Instancias de las clases del modelo
    Rol tu = new Rol();
    Usuario us = new Usuario();
    UsuarioDAO usDAO = new UsuarioDAO();
    Cargo ca = new Cargo();
    CargoDAO caDAO = new CargoDAO();
    Trabajador tra = new Trabajador();
    TrabajadorDAO traDAO = new TrabajadorDAO();

    Empresa em = new Empresa();
    EmpresaDAO emDAO = new EmpresaDAO();

    public FrmMenu() {
        initComponents();
        MenuController menuControl = new MenuController(this);
        CargoController cargoControl = new CargoController(ca, caDAO, this);
        TrabajadorController trabajadorControl = new TrabajadorController(caDAO, tra, traDAO, this);

        EmpresaController empresaControl = new EmpresaController(em, emDAO, this);
        DatosEmpresaController datosEmpresaControl = new DatosEmpresaController(emDAO, this);
    }

    public FrmMenu(Usuario us, Rol tu) {
        initComponents();

        this.tu = tu;
        this.us = us;
        //  Restriccion de privilegios
        if (tu.getIdRol() == 1) {
//            pnlCargo.setEnabledAt(0, false);
            pnlCargo.remove(pnlRegistrarCargo);
            pnlTrabajador.remove(pnlRegistrarTrabajador);
//            pnlConfiguracion.remove(pnlNosotros);
        } else if (tu.getIdRol() == 2) {
            //menuAdministrador.setVisible(false);
//            pnlConfiguracion.setEnabledAt(0, false);
//            pnlConfiguracion.remove(pnlRegistrarDatosEmpresa);
        }

        //  Llamada de los controladores
        MenuController menuControl = new MenuController(this);
        CargoController cargoControl = new CargoController(ca, caDAO, this);
        TrabajadorController trabajadorControl = new TrabajadorController(caDAO, tra, traDAO, this);

        EmpresaController empresaControl = new EmpresaController(em, emDAO, this);
        DatosEmpresaController datosEmpresaControl = new DatosEmpresaController(emDAO, this);
//        MiPerfilController miPerfilControl = new MiPerfilController(us, usDAO, this);
    }

    public void setColor(JPanel panel) {
        panel.setBackground(Color.yellow);
    }

    public void resetColor(JPanel panel) {
        panel.setBackground(Color.BLUE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Genero = new javax.swing.ButtonGroup();
        EstadoCivil = new javax.swing.ButtonGroup();
        GradoIntruccion = new javax.swing.ButtonGroup();
        CategoriaCargo = new javax.swing.ButtonGroup();
        AreaPerfil = new javax.swing.ButtonGroup();
        pnlPrincipal = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblRol = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        itemInicio = new gamm_Panel.MenuItem();
        lblInicio = new javax.swing.JLabel();
        itemCargos = new gamm_Panel.MenuItem();
        lblCargo = new javax.swing.JLabel();
        itemTrabajadores = new gamm_Panel.MenuItem();
        lblTrabajadores = new javax.swing.JLabel();
        itemCargos2 = new gamm_Panel.MenuItem();
        itemEquipos = new gamm_Panel.MenuItem();
        lblEquipos = new javax.swing.JLabel();
        itemCargos4 = new gamm_Panel.MenuItem();
        lblFoto = new gamm_LavelAvatar.LabelAvatar();
        pnlFondo = new javax.swing.JPanel();
        pnlOpciones = new gamm_Panel.TabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnlCargo = new gamm_Panel.TabbedPane();
        pnlRegistrarCargo = new javax.swing.JPanel();
        roundedPanel1 = new gamm_Panel.RoundedPanel();
        txtNombreCargo = new gamm_TextField.TextField();
        mNombreCargo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mCategoriaCargo = new javax.swing.JLabel();
        opEmpleado = new gamm_RadioButton.RadioButton();
        opObrero = new gamm_RadioButton.RadioButton();
        btnRegistrarCargo = new gamm_Button.Button();
        pnlListarCargos = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnlTrabajador = new gamm_Panel.TabbedPane();
        pnlRegistrarTrabajador = new javax.swing.JPanel();
        pnlDatosPersonales = new gamm_Panel.RoundedPanel();
        txtDni = new gamm_TextField.TextField();
        mDni = new javax.swing.JLabel();
        txtApePaterno = new gamm_TextField.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mApePaterno = new javax.swing.JLabel();
        mApeMaterno = new javax.swing.JLabel();
        mNombresTrabajador = new javax.swing.JLabel();
        txtApeMaterno = new gamm_TextField.TextField();
        txtNombreTrabajador = new gamm_TextField.TextField();
        opFemenino = new gamm_RadioButton.RadioButton();
        opMasculino = new gamm_RadioButton.RadioButton();
        opSoltero = new gamm_RadioButton.RadioButton();
        opCasado = new gamm_RadioButton.RadioButton();
        opConviviente = new gamm_RadioButton.RadioButton();
        mEstadoCivil = new javax.swing.JLabel();
        txtDireccion = new gamm_TextField.TextField();
        mDireccion = new javax.swing.JLabel();
        txtTelefono = new gamm_TextField.TextField();
        mTelefono = new javax.swing.JLabel();
        mGenero = new javax.swing.JLabel();
        txtRuta1 = new javax.swing.JLabel();
        txtFechaNacimiento = new gamm_TextField.TextField();
        mFechaNacimiento = new javax.swing.JLabel();
        pnlInformacionAcademica = new gamm_Panel.RoundedPanel();
        jLabel4 = new javax.swing.JLabel();
        txtProfesion = new gamm_TextField.TextField();
        opPrimaria = new gamm_RadioButton.RadioButton();
        opSecundaria = new gamm_RadioButton.RadioButton();
        opTecnico = new gamm_RadioButton.RadioButton();
        opUniversitaria = new gamm_RadioButton.RadioButton();
        mGradoInstruccion = new javax.swing.JLabel();
        mProfesion = new javax.swing.JLabel();
        pnlAsignacionCargo = new gamm_Panel.RoundedPanel();
        cboCargo = new gamm_ComboBox.Combobox();
        txtCodCargoAsignado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRegistrarTrabajador = new gamm_Button.Button();
        pnlFotoTrabajador = new gamm_Panel.RoundedPanel();
        lblFotoTrabajador = new javax.swing.JLabel();
        mFotoTrabajador = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        pnlListarTrabajadores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        pnlRegistrarPerfilLaboral = new javax.swing.JPanel();
        roundedPanel5 = new gamm_Panel.RoundedPanel();
        cboTrabajadorPerfil = new gamm_ComboBox.Combobox();
        txtFechaIngreso = new gamm_TextField.TextField();
        radioButton1 = new gamm_RadioButton.RadioButton();
        radioButton2 = new gamm_RadioButton.RadioButton();
        jLabel5 = new javax.swing.JLabel();
        radioButton3 = new gamm_RadioButton.RadioButton();
        radioButton4 = new gamm_RadioButton.RadioButton();
        txtSueldo = new gamm_TextField.TextField();
        mFechaIngreso = new javax.swing.JLabel();
        mArea = new javax.swing.JLabel();
        mArea1 = new javax.swing.JLabel();
        roundedPanel7 = new gamm_Panel.RoundedPanel();
        txtFechaIngreso1 = new gamm_TextField.TextField();
        txtSueldo1 = new gamm_TextField.TextField();
        mFechaIngreso1 = new javax.swing.JLabel();
        mFechaIngreso2 = new javax.swing.JLabel();
        checkBox1 = new gamm_CheckBox.CheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        pnlRegistrarLicencia = new javax.swing.JPanel();
        roundedPanel10 = new gamm_Panel.RoundedPanel();
        cboTrabajadorPerfil1 = new gamm_ComboBox.Combobox();
        txtFechaIngreso2 = new gamm_TextField.TextField();
        radioButton5 = new gamm_RadioButton.RadioButton();
        radioButton6 = new gamm_RadioButton.RadioButton();
        jLabel7 = new javax.swing.JLabel();
        radioButton7 = new gamm_RadioButton.RadioButton();
        radioButton8 = new gamm_RadioButton.RadioButton();
        txtSueldo2 = new gamm_TextField.TextField();
        mFechaIngreso3 = new javax.swing.JLabel();
        mArea2 = new javax.swing.JLabel();
        mArea3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        tabbedPane1 = new gamm_Panel.TabbedPane();
        pnlRegistrarDatosEmpresa = new javax.swing.JPanel();
        pnlDatosEmpresaInput = new gamm_Panel.RoundedPanel();
        txtIdEmpresaUpdate = new javax.swing.JTextField();
        txtRucUpdate = new gamm_TextField.TextField();
        txtCiiuUpdate = new gamm_TextField.TextField();
        txtRazonSocialUpdate = new gamm_TextField.TextField();
        txtTelefonoUpdate = new gamm_TextField.TextField();
        txtCelularUpdate = new gamm_TextField.TextField();
        txtEmailUpdate = new gamm_TextField.TextField();
        txtPagWebUpdate = new gamm_TextField.TextField();
        txtDireccionUpdate = new gamm_TextField.TextField();
        pnlLogoEmpresa = new gamm_Panel.RoundedPanel();
        lblLogoUpdate = new javax.swing.JLabel();
        btnSeleccionarLogo = new gamm_Button.ButtonLine();
        btnAgregar = new gamm_Button.Button();
        btnHabilitar = new gamm_Button.Button();
        txtRutaUpdate = new javax.swing.JTextField();
        btnModificarEmpresa = new gamm_Button.Button();
        btnCancelarEmpresa = new gamm_Button.Button();
        pnlMostrarDatosEmpresa = new javax.swing.JPanel();
        pnlDatosEmpresa = new gamm_Panel.RoundedPanel();
        txtIdEmpresaDatos = new javax.swing.JTextField();
        txtRucDatos = new gamm_TextField.TextField();
        txtCiiuDatos = new gamm_TextField.TextField();
        txtRazonSocialDatos = new gamm_TextField.TextField();
        txtTelefonoEmpresaDatos = new gamm_TextField.TextField();
        txtCelularEmpresaDatos = new gamm_TextField.TextField();
        lblLogoEmpresaDatos = new javax.swing.JLabel();
        txtEmailEmpresaDatos = new gamm_TextField.TextField();
        txtPaginaWebEmpresaDatos = new gamm_TextField.TextField();
        txtRutaEmpresaDatos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setBackground(new java.awt.Color(0, 0, 0));

        pnlMenu.setBackground(new java.awt.Color(102, 102, 102));

        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setText("Rol");

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setText("TRABAJADORES");

        lblInicio.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblInicio.setText("INICIO");

        javax.swing.GroupLayout itemInicioLayout = new javax.swing.GroupLayout(itemInicio);
        itemInicio.setLayout(itemInicioLayout);
        itemInicioLayout.setHorizontalGroup(
            itemInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        itemInicioLayout.setVerticalGroup(
            itemInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        lblCargo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblCargo.setText("CARGOS");

        javax.swing.GroupLayout itemCargosLayout = new javax.swing.GroupLayout(itemCargos);
        itemCargos.setLayout(itemCargosLayout);
        itemCargosLayout.setHorizontalGroup(
            itemCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemCargosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        itemCargosLayout.setVerticalGroup(
            itemCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        lblTrabajadores.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblTrabajadores.setText("TRABAJADORES");

        javax.swing.GroupLayout itemTrabajadoresLayout = new javax.swing.GroupLayout(itemTrabajadores);
        itemTrabajadores.setLayout(itemTrabajadoresLayout);
        itemTrabajadoresLayout.setHorizontalGroup(
            itemTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemTrabajadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        itemTrabajadoresLayout.setVerticalGroup(
            itemTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout itemCargos2Layout = new javax.swing.GroupLayout(itemCargos2);
        itemCargos2.setLayout(itemCargos2Layout);
        itemCargos2Layout.setHorizontalGroup(
            itemCargos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        itemCargos2Layout.setVerticalGroup(
            itemCargos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        lblEquipos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblEquipos.setText("EQUIPOS");

        javax.swing.GroupLayout itemEquiposLayout = new javax.swing.GroupLayout(itemEquipos);
        itemEquipos.setLayout(itemEquiposLayout);
        itemEquiposLayout.setHorizontalGroup(
            itemEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemEquiposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        itemEquiposLayout.setVerticalGroup(
            itemEquiposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout itemCargos4Layout = new javax.swing.GroupLayout(itemCargos4);
        itemCargos4.setLayout(itemCargos4Layout);
        itemCargos4Layout.setHorizontalGroup(
            itemCargos4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        itemCargos4Layout.setVerticalGroup(
            itemCargos4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemCargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemCargos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemCargos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(itemInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(itemCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(itemTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(itemEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(itemCargos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(itemCargos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1480, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
        );

        pnlOpciones.addTab("INICIO", jPanel3);

        txtNombreCargo.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreCargo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreCargo.setLabelText("Cargo");

        mNombreCargo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombreCargo.setText("Mensaje de error");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Categoría");

        mCategoriaCargo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mCategoriaCargo.setText("Mensaje de error");

        CategoriaCargo.add(opEmpleado);
        opEmpleado.setText("Empleado");
        opEmpleado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        CategoriaCargo.add(opObrero);
        opObrero.setText("Obrero");
        opObrero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(mNombreCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                .addComponent(txtNombreCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(mCategoriaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opObrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(txtNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(opObrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mCategoriaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        btnRegistrarCargo.setText("REGISTRAR");

        javax.swing.GroupLayout pnlRegistrarCargoLayout = new javax.swing.GroupLayout(pnlRegistrarCargo);
        pnlRegistrarCargo.setLayout(pnlRegistrarCargoLayout);
        pnlRegistrarCargoLayout.setHorizontalGroup(
            pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegistrarCargoLayout.setVerticalGroup(
            pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pnlCargo.addTab("Nuevo cargo", pnlRegistrarCargo);

        javax.swing.GroupLayout pnlListarCargosLayout = new javax.swing.GroupLayout(pnlListarCargos);
        pnlListarCargos.setLayout(pnlListarCargosLayout);
        pnlListarCargosLayout.setHorizontalGroup(
            pnlListarCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
        pnlListarCargosLayout.setVerticalGroup(
            pnlListarCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        pnlCargo.addTab("Lista de cargos", pnlListarCargos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(597, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("CARGOS", jPanel4);

        pnlDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        pnlDatosPersonales.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtDni.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDni.setLabelText("DNI");

        mDni.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mDni.setForeground(new java.awt.Color(63, 63, 63));
        mDni.setText("Mensaje de error");

        txtApePaterno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtApePaterno.setLabelText("Apellido Paterno");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Género");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Estado Civil");

        mApePaterno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mApePaterno.setForeground(new java.awt.Color(63, 63, 63));
        mApePaterno.setText("Mensaje de error");

        mApeMaterno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mApeMaterno.setForeground(new java.awt.Color(63, 63, 63));
        mApeMaterno.setText("Mensaje de error");

        mNombresTrabajador.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombresTrabajador.setForeground(new java.awt.Color(63, 63, 63));
        mNombresTrabajador.setText("Mensaje de error");

        txtApeMaterno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtApeMaterno.setLabelText("Apellido Materno");

        txtNombreTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreTrabajador.setLabelText("Nombres");

        Genero.add(opFemenino);
        opFemenino.setText("Femenino");
        opFemenino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        Genero.add(opMasculino);
        opMasculino.setText("Masculino");
        opMasculino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opSoltero);
        opSoltero.setText("Soltero");
        opSoltero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opCasado);
        opCasado.setText("Casado");
        opCasado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opConviviente);
        opConviviente.setText("Conviviente");
        opConviviente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        mEstadoCivil.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mEstadoCivil.setForeground(new java.awt.Color(63, 63, 63));
        mEstadoCivil.setText("Mensaje de error");

        txtDireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDireccion.setLabelText("Dirección");

        mDireccion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mDireccion.setForeground(new java.awt.Color(63, 63, 63));
        mDireccion.setText("Mensaje de error");

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefono.setLabelText("Teléfono");

        mTelefono.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTelefono.setForeground(new java.awt.Color(63, 63, 63));
        mTelefono.setText("Mensaje de error");

        mGenero.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mGenero.setForeground(new java.awt.Color(63, 63, 63));
        mGenero.setText("Mensaje de error");

        txtFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaNacimiento.setLabelText("F. Nacimiento");

        mFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaNacimiento.setForeground(new java.awt.Color(63, 63, 63));
        mFechaNacimiento.setText("Mensaje de error");

        javax.swing.GroupLayout pnlDatosPersonalesLayout = new javax.swing.GroupLayout(pnlDatosPersonales);
        pnlDatosPersonales.setLayout(pnlDatosPersonalesLayout);
        pnlDatosPersonalesLayout.setHorizontalGroup(
            pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                        .addComponent(opFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(opMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(mGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(mApePaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(txtApePaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtApeMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(mApeMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(mNombresTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                                .addComponent(opSoltero, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(opCasado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(opConviviente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(mEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mDni, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(80, 80, 80)
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(97, 97, 97)))
                .addComponent(txtRuta1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDatosPersonalesLayout.setVerticalGroup(
            pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mDni, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mApePaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mApeMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mNombresTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opSoltero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opCasado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opConviviente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta1))
                .addGap(0, 0, 0)
                .addComponent(mDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlInformacionAcademica.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información Académica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Grado de instrucción");

        txtProfesion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtProfesion.setLabelText("Profesión");

        GradoIntruccion.add(opPrimaria);
        opPrimaria.setText("Primaria completa");
        opPrimaria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GradoIntruccion.add(opSecundaria);
        opSecundaria.setText("Secundaria completa");
        opSecundaria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GradoIntruccion.add(opTecnico);
        opTecnico.setText("Técnico");
        opTecnico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GradoIntruccion.add(opUniversitaria);
        opUniversitaria.setText("Universitaria");
        opUniversitaria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        mGradoInstruccion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mGradoInstruccion.setForeground(new java.awt.Color(63, 63, 63));
        mGradoInstruccion.setText("Mensaje de error");

        mProfesion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mProfesion.setForeground(new java.awt.Color(63, 63, 63));
        mProfesion.setText("Mensaje de error");

        javax.swing.GroupLayout pnlInformacionAcademicaLayout = new javax.swing.GroupLayout(pnlInformacionAcademica);
        pnlInformacionAcademica.setLayout(pnlInformacionAcademicaLayout);
        pnlInformacionAcademicaLayout.setHorizontalGroup(
            pnlInformacionAcademicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionAcademicaLayout.createSequentialGroup()
                .addGroup(pnlInformacionAcademicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionAcademicaLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacionAcademicaLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(pnlInformacionAcademicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opUniversitaria, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opPrimaria, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mGradoInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInformacionAcademicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProfesion, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(mProfesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnlInformacionAcademicaLayout.setVerticalGroup(
            pnlInformacionAcademicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionAcademicaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacionAcademicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionAcademicaLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(opPrimaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(opSecundaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(opTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(opUniversitaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mGradoInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacionAcademicaLayout.createSequentialGroup()
                        .addComponent(txtProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pnlAsignacionCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Asignación de cargo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        cboCargo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboCargo.setLabeText("Cargo asignado");

        txtCodCargoAsignado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCodCargoAsignado.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pnlAsignacionCargoLayout = new javax.swing.GroupLayout(pnlAsignacionCargo);
        pnlAsignacionCargo.setLayout(pnlAsignacionCargoLayout);
        pnlAsignacionCargoLayout.setHorizontalGroup(
            pnlAsignacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionCargoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtCodCargoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAsignacionCargoLayout.setVerticalGroup(
            pnlAsignacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionCargoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlAsignacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodCargoAsignado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnRegistrarTrabajador.setText("REGISTRAR");

        pnlFotoTrabajador.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selección de foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        lblFotoTrabajador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFotoTrabajador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoTrabajador.setText("FOTO");
        lblFotoTrabajador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        mFotoTrabajador.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFotoTrabajador.setForeground(new java.awt.Color(63, 63, 63));
        mFotoTrabajador.setText("Mensaje de error");

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(255, 255, 255));
        txtRuta.setFont(new java.awt.Font("Dialog", 0, 5)); // NOI18N
        txtRuta.setForeground(new java.awt.Color(255, 255, 255));
        txtRuta.setBorder(null);

        javax.swing.GroupLayout pnlFotoTrabajadorLayout = new javax.swing.GroupLayout(pnlFotoTrabajador);
        pnlFotoTrabajador.setLayout(pnlFotoTrabajadorLayout);
        pnlFotoTrabajadorLayout.setHorizontalGroup(
            pnlFotoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFotoTrabajadorLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlFotoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFotoTrabajadorLayout.createSequentialGroup()
                        .addComponent(lblFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFotoTrabajadorLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(pnlFotoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mFotoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        pnlFotoTrabajadorLayout.setVerticalGroup(
            pnlFotoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFotoTrabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mFotoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlRegistrarTrabajadorLayout = new javax.swing.GroupLayout(pnlRegistrarTrabajador);
        pnlRegistrarTrabajador.setLayout(pnlRegistrarTrabajadorLayout);
        pnlRegistrarTrabajadorLayout.setHorizontalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                        .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlInformacionAcademica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlAsignacionCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );
        pnlRegistrarTrabajadorLayout.setVerticalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                        .addComponent(pnlInformacionAcademica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlAsignacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Nuevo trabajador", pnlRegistrarTrabajador);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout pnlListarTrabajadoresLayout = new javax.swing.GroupLayout(pnlListarTrabajadores);
        pnlListarTrabajadores.setLayout(pnlListarTrabajadoresLayout);
        pnlListarTrabajadoresLayout.setHorizontalGroup(
            pnlListarTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarTrabajadoresLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlListarTrabajadoresLayout.setVerticalGroup(
            pnlListarTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarTrabajadoresLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Lista de trabajadores", pnlListarTrabajadores);

        cboTrabajadorPerfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboTrabajadorPerfil.setLabeText("Trabajador");

        txtFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaIngreso.setLabelText("Fecha de ingreso");

        AreaPerfil.add(radioButton1);
        radioButton1.setText("Operaciones");
        radioButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        AreaPerfil.add(radioButton2);
        radioButton2.setText("Seguridad");
        radioButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Área");

        AreaPerfil.add(radioButton3);
        radioButton3.setText("Administración");
        radioButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        AreaPerfil.add(radioButton4);
        radioButton4.setText("Mantenimiento");
        radioButton4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtSueldo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSueldo.setLabelText("Sueldo");

        mFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaIngreso.setForeground(new java.awt.Color(63, 63, 63));
        mFechaIngreso.setText("Mensaje de error");

        mArea.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mArea.setForeground(new java.awt.Color(63, 63, 63));
        mArea.setText("Mensaje de error");

        mArea1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mArea1.setForeground(new java.awt.Color(63, 63, 63));
        mArea1.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel5Layout = new javax.swing.GroupLayout(roundedPanel5);
        roundedPanel5.setLayout(roundedPanel5Layout);
        roundedPanel5Layout.setHorizontalGroup(
            roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel5Layout.createSequentialGroup()
                .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mArea, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel5Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(cboTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        roundedPanel5Layout.setVerticalGroup(
            roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cboTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mArea, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        txtFechaIngreso1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaIngreso1.setLabelText("Fecha de cese");

        txtSueldo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSueldo1.setLabelText("Motivo");

        mFechaIngreso1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaIngreso1.setForeground(new java.awt.Color(63, 63, 63));
        mFechaIngreso1.setText("Mensaje de error");

        mFechaIngreso2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaIngreso2.setForeground(new java.awt.Color(63, 63, 63));
        mFechaIngreso2.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel7Layout = new javax.swing.GroupLayout(roundedPanel7);
        roundedPanel7.setLayout(roundedPanel7Layout);
        roundedPanel7Layout.setHorizontalGroup(
            roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSueldo1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(mFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mFechaIngreso2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel7Layout.setVerticalGroup(
            roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtSueldo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaIngreso2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        checkBox1.setText("Cesamiento de trabajador");
        checkBox1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout pnlRegistrarPerfilLaboralLayout = new javax.swing.GroupLayout(pnlRegistrarPerfilLaboral);
        pnlRegistrarPerfilLaboral.setLayout(pnlRegistrarPerfilLaboralLayout);
        pnlRegistrarPerfilLaboralLayout.setHorizontalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(roundedPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundedPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(checkBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        pnlRegistrarPerfilLaboralLayout.setVerticalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                        .addComponent(roundedPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Perfil laboral", pnlRegistrarPerfilLaboral);

        cboTrabajadorPerfil1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboTrabajadorPerfil1.setLabeText("Trabajador");

        txtFechaIngreso2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaIngreso2.setLabelText("Fecha de ingreso");

        AreaPerfil.add(radioButton5);
        radioButton5.setText("Operaciones");
        radioButton5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        AreaPerfil.add(radioButton6);
        radioButton6.setText("Seguridad");
        radioButton6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Área");

        AreaPerfil.add(radioButton7);
        radioButton7.setText("Administración");
        radioButton7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        AreaPerfil.add(radioButton8);
        radioButton8.setText("Mantenimiento");
        radioButton8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtSueldo2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSueldo2.setLabelText("Sueldo");

        mFechaIngreso3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaIngreso3.setForeground(new java.awt.Color(63, 63, 63));
        mFechaIngreso3.setText("Mensaje de error");

        mArea2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mArea2.setForeground(new java.awt.Color(63, 63, 63));
        mArea2.setText("Mensaje de error");

        mArea3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mArea3.setForeground(new java.awt.Color(63, 63, 63));
        mArea3.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel10Layout = new javax.swing.GroupLayout(roundedPanel10);
        roundedPanel10.setLayout(roundedPanel10Layout);
        roundedPanel10Layout.setHorizontalGroup(
            roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel10Layout.createSequentialGroup()
                .addGroup(roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel10Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaIngreso2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSueldo2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mFechaIngreso3, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTrabajadorPerfil1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)))
                    .addGroup(roundedPanel10Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        roundedPanel10Layout.setVerticalGroup(
            roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(cboTrabajadorPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtFechaIngreso2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaIngreso3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(radioButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSueldo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout pnlRegistrarLicenciaLayout = new javax.swing.GroupLayout(pnlRegistrarLicencia);
        pnlRegistrarLicencia.setLayout(pnlRegistrarLicenciaLayout);
        pnlRegistrarLicenciaLayout.setHorizontalGroup(
            pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(roundedPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(990, Short.MAX_VALUE))
        );
        pnlRegistrarLicenciaLayout.setVerticalGroup(
            pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(roundedPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Licencias de conducir", pnlRegistrarLicencia);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("TRABAJADORES", jPanel5);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1480, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
        );

        pnlOpciones.addTab("EQUIPOS", jPanel8);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1480, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
        );

        pnlOpciones.addTab("tab5", jPanel13);

        txtIdEmpresaUpdate.setEditable(false);
        txtIdEmpresaUpdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdEmpresaUpdate.setText("1");
        txtIdEmpresaUpdate.setBorder(null);

        txtRucUpdate.setEditable(false);
        txtRucUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtRucUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtRucUpdate.setLabelText("RUC");

        txtCiiuUpdate.setEditable(false);
        txtCiiuUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtCiiuUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtCiiuUpdate.setLabelText("CIIU");

        txtRazonSocialUpdate.setEditable(false);
        txtRazonSocialUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtRazonSocialUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtRazonSocialUpdate.setLabelText("Razón Social");

        txtTelefonoUpdate.setEditable(false);
        txtTelefonoUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefonoUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtTelefonoUpdate.setLabelText("Teléfono");

        txtCelularUpdate.setEditable(false);
        txtCelularUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtCelularUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtCelularUpdate.setLabelText("Celular");

        txtEmailUpdate.setEditable(false);
        txtEmailUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtEmailUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtEmailUpdate.setLabelText("Email");

        txtPagWebUpdate.setEditable(false);
        txtPagWebUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtPagWebUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtPagWebUpdate.setLabelText("Pagina Web");

        txtDireccionUpdate.setEditable(false);
        txtDireccionUpdate.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccionUpdate.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtDireccionUpdate.setLabelText("Dirección");

        javax.swing.GroupLayout pnlDatosEmpresaInputLayout = new javax.swing.GroupLayout(pnlDatosEmpresaInput);
        pnlDatosEmpresaInput.setLayout(pnlDatosEmpresaInputLayout);
        pnlDatosEmpresaInputLayout.setHorizontalGroup(
            pnlDatosEmpresaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpresaInputLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnlDatosEmpresaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosEmpresaInputLayout.createSequentialGroup()
                        .addComponent(txtEmailUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosEmpresaInputLayout.createSequentialGroup()
                        .addGroup(pnlDatosEmpresaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPagWebUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiiuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonSocialUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDatosEmpresaInputLayout.createSequentialGroup()
                                .addComponent(txtRucUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(txtIdEmpresaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosEmpresaInputLayout.createSequentialGroup()
                                .addComponent(txtTelefonoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(txtCelularUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 154, Short.MAX_VALUE))))
        );
        pnlDatosEmpresaInputLayout.setVerticalGroup(
            pnlDatosEmpresaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpresaInputLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlDatosEmpresaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRucUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdEmpresaUpdate))
                .addGap(50, 50, 50)
                .addComponent(txtRazonSocialUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtCiiuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(pnlDatosEmpresaInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(txtDireccionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtEmailUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtPagWebUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        lblLogoUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoUpdate.setText("FOTO");
        lblLogoUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnSeleccionarLogo.setText("SELECCIONAR LOGO");

        javax.swing.GroupLayout pnlLogoEmpresaLayout = new javax.swing.GroupLayout(pnlLogoEmpresa);
        pnlLogoEmpresa.setLayout(pnlLogoEmpresaLayout);
        pnlLogoEmpresaLayout.setHorizontalGroup(
            pnlLogoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoEmpresaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblLogoUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoEmpresaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionarLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        pnlLogoEmpresaLayout.setVerticalGroup(
            pnlLogoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoEmpresaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblLogoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionarLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        btnAgregar.setText("REGISTRAR");

        btnHabilitar.setText("HABILITAR");

        txtRutaUpdate.setEditable(false);
        txtRutaUpdate.setBorder(null);

        btnModificarEmpresa.setText("MODIFICAR");

        btnCancelarEmpresa.setText("CANCELAR");

        javax.swing.GroupLayout pnlRegistrarDatosEmpresaLayout = new javax.swing.GroupLayout(pnlRegistrarDatosEmpresa);
        pnlRegistrarDatosEmpresa.setLayout(pnlRegistrarDatosEmpresaLayout);
        pnlRegistrarDatosEmpresaLayout.setHorizontalGroup(
            pnlRegistrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarDatosEmpresaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnlDatosEmpresaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(pnlRegistrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlLogoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlRegistrarDatosEmpresaLayout.createSequentialGroup()
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnModificarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtRutaUpdate))
                    .addComponent(btnCancelarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        pnlRegistrarDatosEmpresaLayout.setVerticalGroup(
            pnlRegistrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarDatosEmpresaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlRegistrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDatosEmpresaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistrarDatosEmpresaLayout.createSequentialGroup()
                        .addComponent(pnlLogoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRutaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addGroup(pnlRegistrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(btnCancelarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("Registrar datos", pnlRegistrarDatosEmpresa);

        txtIdEmpresaDatos.setEditable(false);
        txtIdEmpresaDatos.setText("1");
        txtIdEmpresaDatos.setBorder(null);

        txtRucDatos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtRucDatos.setLabelText("RUC");

        txtCiiuDatos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCiiuDatos.setLabelText("CIIU");

        txtRazonSocialDatos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtRazonSocialDatos.setLabelText("Razón Social");

        txtTelefonoEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefonoEmpresaDatos.setLabelText("Teléfono");

        txtCelularEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCelularEmpresaDatos.setLabelText("Celular");

        lblLogoEmpresaDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoEmpresaDatos.setText("FOTO");
        lblLogoEmpresaDatos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        txtEmailEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEmailEmpresaDatos.setLabelText("Email");

        txtPaginaWebEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPaginaWebEmpresaDatos.setLabelText("Pagina Web");

        txtRutaEmpresaDatos.setEditable(false);
        txtRutaEmpresaDatos.setBorder(null);

        javax.swing.GroupLayout pnlDatosEmpresaLayout = new javax.swing.GroupLayout(pnlDatosEmpresa);
        pnlDatosEmpresa.setLayout(pnlDatosEmpresaLayout);
        pnlDatosEmpresaLayout.setHorizontalGroup(
            pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                        .addComponent(txtPaginaWebEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                                .addComponent(txtRucDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(txtIdEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCiiuDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonSocialDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(396, 396, 396)
                        .addComponent(lblLogoEmpresaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                        .addGap(177, 177, 177))
                    .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                                .addComponent(txtTelefonoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(txtCelularEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                                .addComponent(txtEmailEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(297, 297, 297)
                                .addComponent(txtRutaEmpresaDatos)
                                .addGap(103, 103, 103)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlDatosEmpresaLayout.setVerticalGroup(
            pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRucDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdEmpresaDatos))
                        .addGap(47, 47, 47)
                        .addComponent(txtRazonSocialDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(txtCiiuDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(70, 70, 70)
                .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRutaEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(txtPaginaWebEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMostrarDatosEmpresaLayout = new javax.swing.GroupLayout(pnlMostrarDatosEmpresa);
        pnlMostrarDatosEmpresa.setLayout(pnlMostrarDatosEmpresaLayout);
        pnlMostrarDatosEmpresaLayout.setHorizontalGroup(
            pnlMostrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarDatosEmpresaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(pnlDatosEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlMostrarDatosEmpresaLayout.setVerticalGroup(
            pnlMostrarDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarDatosEmpresaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnlDatosEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("Datos empresa", pnlMostrarDatosEmpresa);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(tabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(tabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab6", jPanel14);

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonCustom9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Rol tu = new Rol();
                Usuario us = new Usuario();
                new FrmMenu(us, tu).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup AreaPerfil;
    public javax.swing.ButtonGroup CategoriaCargo;
    public javax.swing.ButtonGroup EstadoCivil;
    public javax.swing.ButtonGroup Genero;
    public javax.swing.ButtonGroup GradoIntruccion;
    public gamm_Button.Button btnAgregar;
    public gamm_Button.Button btnCancelarEmpresa;
    public gamm_Button.Button btnHabilitar;
    public gamm_Button.Button btnModificarEmpresa;
    public gamm_Button.Button btnRegistrarCargo;
    public gamm_Button.Button btnRegistrarTrabajador;
    public gamm_Button.ButtonLine btnSeleccionarLogo;
    public gamm_ComboBox.Combobox cboCargo;
    public gamm_ComboBox.Combobox cboTrabajadorPerfil;
    public gamm_ComboBox.Combobox cboTrabajadorPerfil1;
    public gamm_CheckBox.CheckBox checkBox1;
    public gamm_Panel.MenuItem itemCargos;
    public gamm_Panel.MenuItem itemCargos2;
    public gamm_Panel.MenuItem itemCargos4;
    public gamm_Panel.MenuItem itemEquipos;
    public gamm_Panel.MenuItem itemInicio;
    public gamm_Panel.MenuItem itemTrabajadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    public javax.swing.JLabel lblCargo;
    public javax.swing.JLabel lblEquipos;
    public gamm_LavelAvatar.LabelAvatar lblFoto;
    public javax.swing.JLabel lblFotoTrabajador;
    public javax.swing.JLabel lblInicio;
    public javax.swing.JLabel lblLogoEmpresaDatos;
    public javax.swing.JLabel lblLogoUpdate;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblRol;
    public javax.swing.JLabel lblTrabajadores;
    public javax.swing.JLabel mApeMaterno;
    public javax.swing.JLabel mApePaterno;
    public javax.swing.JLabel mArea;
    public javax.swing.JLabel mArea1;
    public javax.swing.JLabel mArea2;
    public javax.swing.JLabel mArea3;
    public javax.swing.JLabel mCategoriaCargo;
    public javax.swing.JLabel mDireccion;
    public javax.swing.JLabel mDni;
    public javax.swing.JLabel mEstadoCivil;
    public javax.swing.JLabel mFechaIngreso;
    public javax.swing.JLabel mFechaIngreso1;
    public javax.swing.JLabel mFechaIngreso2;
    public javax.swing.JLabel mFechaIngreso3;
    public javax.swing.JLabel mFechaNacimiento;
    public javax.swing.JLabel mFotoTrabajador;
    public javax.swing.JLabel mGenero;
    public javax.swing.JLabel mGradoInstruccion;
    public javax.swing.JLabel mNombreCargo;
    public javax.swing.JLabel mNombresTrabajador;
    public javax.swing.JLabel mProfesion;
    public javax.swing.JLabel mTelefono;
    public gamm_RadioButton.RadioButton opCasado;
    public gamm_RadioButton.RadioButton opConviviente;
    public gamm_RadioButton.RadioButton opEmpleado;
    public gamm_RadioButton.RadioButton opFemenino;
    public gamm_RadioButton.RadioButton opMasculino;
    public gamm_RadioButton.RadioButton opObrero;
    public gamm_RadioButton.RadioButton opPrimaria;
    public gamm_RadioButton.RadioButton opSecundaria;
    public gamm_RadioButton.RadioButton opSoltero;
    public gamm_RadioButton.RadioButton opTecnico;
    public gamm_RadioButton.RadioButton opUniversitaria;
    private gamm_Panel.RoundedPanel pnlAsignacionCargo;
    public gamm_Panel.TabbedPane pnlCargo;
    private gamm_Panel.RoundedPanel pnlDatosEmpresa;
    private gamm_Panel.RoundedPanel pnlDatosEmpresaInput;
    private gamm_Panel.RoundedPanel pnlDatosPersonales;
    private javax.swing.JPanel pnlFondo;
    private gamm_Panel.RoundedPanel pnlFotoTrabajador;
    private gamm_Panel.RoundedPanel pnlInformacionAcademica;
    private javax.swing.JPanel pnlListarCargos;
    private javax.swing.JPanel pnlListarTrabajadores;
    private gamm_Panel.RoundedPanel pnlLogoEmpresa;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMostrarDatosEmpresa;
    public gamm_Panel.TabbedPane pnlOpciones;
    private javax.swing.JPanel pnlPrincipal;
    public javax.swing.JPanel pnlRegistrarCargo;
    private javax.swing.JPanel pnlRegistrarDatosEmpresa;
    private javax.swing.JPanel pnlRegistrarLicencia;
    private javax.swing.JPanel pnlRegistrarPerfilLaboral;
    public javax.swing.JPanel pnlRegistrarTrabajador;
    public gamm_Panel.TabbedPane pnlTrabajador;
    public gamm_RadioButton.RadioButton radioButton1;
    public gamm_RadioButton.RadioButton radioButton2;
    public gamm_RadioButton.RadioButton radioButton3;
    public gamm_RadioButton.RadioButton radioButton4;
    public gamm_RadioButton.RadioButton radioButton5;
    public gamm_RadioButton.RadioButton radioButton6;
    public gamm_RadioButton.RadioButton radioButton7;
    public gamm_RadioButton.RadioButton radioButton8;
    private gamm_Panel.RoundedPanel roundedPanel1;
    private gamm_Panel.RoundedPanel roundedPanel10;
    private gamm_Panel.RoundedPanel roundedPanel5;
    private gamm_Panel.RoundedPanel roundedPanel7;
    private gamm_Panel.TabbedPane tabbedPane1;
    public gamm_TextField.TextField txtApeMaterno;
    public gamm_TextField.TextField txtApePaterno;
    public gamm_TextField.TextField txtCelularEmpresaDatos;
    public gamm_TextField.TextField txtCelularUpdate;
    public gamm_TextField.TextField txtCiiuDatos;
    public gamm_TextField.TextField txtCiiuUpdate;
    public javax.swing.JLabel txtCodCargoAsignado;
    public gamm_TextField.TextField txtDireccion;
    public gamm_TextField.TextField txtDireccionUpdate;
    public gamm_TextField.TextField txtDni;
    public gamm_TextField.TextField txtEmailEmpresaDatos;
    public gamm_TextField.TextField txtEmailUpdate;
    public gamm_TextField.TextField txtFechaIngreso;
    public gamm_TextField.TextField txtFechaIngreso1;
    public gamm_TextField.TextField txtFechaIngreso2;
    public gamm_TextField.TextField txtFechaNacimiento;
    public javax.swing.JTextField txtIdEmpresaDatos;
    public javax.swing.JTextField txtIdEmpresaUpdate;
    public gamm_TextField.TextField txtNombreCargo;
    public gamm_TextField.TextField txtNombreTrabajador;
    public gamm_TextField.TextField txtPagWebUpdate;
    public gamm_TextField.TextField txtPaginaWebEmpresaDatos;
    public gamm_TextField.TextField txtProfesion;
    public gamm_TextField.TextField txtRazonSocialDatos;
    public gamm_TextField.TextField txtRazonSocialUpdate;
    public gamm_TextField.TextField txtRucDatos;
    public gamm_TextField.TextField txtRucUpdate;
    public javax.swing.JTextField txtRuta;
    public javax.swing.JLabel txtRuta1;
    public javax.swing.JTextField txtRutaEmpresaDatos;
    public javax.swing.JTextField txtRutaUpdate;
    public gamm_TextField.TextField txtSueldo;
    public gamm_TextField.TextField txtSueldo1;
    public gamm_TextField.TextField txtSueldo2;
    public gamm_TextField.TextField txtTelefono;
    public gamm_TextField.TextField txtTelefonoEmpresaDatos;
    public gamm_TextField.TextField txtTelefonoUpdate;
    // End of variables declaration//GEN-END:variables
}
