package Views;

import Models.Cargo;
import Models.CargoDAO;
import Models.Rol;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Models.Usuario;
import Models.UsuarioDAO;
import Models.Empresa;
import Models.EmpresaDAO;

import Controllers.CargoController;
import Controllers.DatosEmpresaController;
import Controllers.EmpresaController;
import Controllers.MenuController;
import Controllers.MiPerfilController;
import Controllers.TrabajadorController;

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

//        EmpresaController empresaControl = new EmpresaController(em, emDAO, this);
//        DatosEmpresaController datosEmpresaControl = new DatosEmpresaController(emDAO, this);
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

//        EmpresaController empresaControl = new EmpresaController(em, emDAO, this);
//        DatosEmpresaController datosEmpresaControl = new DatosEmpresaController(emDAO, this);
//        MiPerfilController miPerfilControl = new MiPerfilController(us, usDAO, this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Genero = new javax.swing.ButtonGroup();
        EstadoCivil = new javax.swing.ButtonGroup();
        GradoIntruccion = new javax.swing.ButtonGroup();
        CategoriaCargo = new javax.swing.ButtonGroup();
        AreaPerfil = new javax.swing.ButtonGroup();
        pnlBackground = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblRol = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        pnlItems = new javax.swing.JPanel();
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
        pnlCabecera = new javax.swing.JPanel();
        pnlOpciones = new gamm_Panel.TabbedPane();
        INICIO = new javax.swing.JPanel();
        CARGOS = new javax.swing.JPanel();
        pnlCargo = new gamm_Panel.TabbedPane();
        pnlRegistrarCargo = new javax.swing.JPanel();
        pnlInformacionCargo = new gamm_Panel.RoundedPanel();
        txtNombreCargo = new gamm_TextField.TextField();
        mNombreCargo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        opEmpleado = new gamm_RadioButton.RadioButton();
        opObrero = new gamm_RadioButton.RadioButton();
        mCategoriaCargo = new javax.swing.JLabel();
        btnRegistrarCargo = new gamm_Button.Button();
        pnlListaCargos = new javax.swing.JPanel();
        roundedPanel1 = new gamm_Panel.RoundedPanel();
        TRABAJADORES = new javax.swing.JPanel();
        pnlTrabajador = new gamm_Panel.TabbedPane();
        pnlRegistrarTrabajador = new javax.swing.JPanel();
        pnlDatosPersonales = new gamm_Panel.RoundedPanel();
        txtDni = new gamm_TextField.TextField();
        mDni = new javax.swing.JLabel();
        txtApePaterno = new gamm_TextField.TextField();
        lblGenero = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
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
        txtFechaNacimiento = new gamm_TextField.TextField();
        mFechaNacimiento = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        pnlFotoTrabajador = new gamm_Panel.RoundedPanel();
        lblFotoTrabajador = new javax.swing.JLabel();
        mFotoTrabajador = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pnlAsignacionCargo = new gamm_Panel.RoundedPanel();
        cboCargo = new gamm_ComboBox.Combobox();
        txtCodCargoAsignado = new javax.swing.JLabel();
        pnlInformacionAcademica = new gamm_Panel.RoundedPanel();
        jLabel4 = new javax.swing.JLabel();
        txtProfesion = new gamm_TextField.TextField();
        opPrimaria = new gamm_RadioButton.RadioButton();
        opSecundaria = new gamm_RadioButton.RadioButton();
        opTecnico = new gamm_RadioButton.RadioButton();
        opUniversitaria = new gamm_RadioButton.RadioButton();
        mGradoInstruccion = new javax.swing.JLabel();
        mProfesion = new javax.swing.JLabel();
        btnRegistrarTrabajador = new gamm_Button.Button();
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
        checkBox1 = new gamm_CheckBox.CheckBox();
        roundedPanel7 = new gamm_Panel.RoundedPanel();
        txtFechaCese = new gamm_TextField.TextField();
        txtMotivo = new gamm_TextField.TextField();
        mFechaIngreso1 = new javax.swing.JLabel();
        mFechaIngreso2 = new javax.swing.JLabel();
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
        EQUIPOS = new javax.swing.JPanel();
        tabbedPane1 = new gamm_Panel.TabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(102, 102, 102));

        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setText("Rol");

        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");

        pnlItems.setBackground(new java.awt.Color(153, 153, 153));

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

        javax.swing.GroupLayout pnlItemsLayout = new javax.swing.GroupLayout(pnlItems);
        pnlItems.setLayout(pnlItemsLayout);
        pnlItemsLayout.setHorizontalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemCargos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlItemsLayout.createSequentialGroup()
                .addGroup(pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemCargos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemCargos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlItemsLayout.setVerticalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemsLayout.createSequentialGroup()
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
                        .addComponent(pnlItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(pnlItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 970));

        pnlCabecera.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1570, Short.MAX_VALUE)
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1570, 40));

        javax.swing.GroupLayout INICIOLayout = new javax.swing.GroupLayout(INICIO);
        INICIO.setLayout(INICIOLayout);
        INICIOLayout.setHorizontalGroup(
            INICIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1558, Short.MAX_VALUE)
        );
        INICIOLayout.setVerticalGroup(
            INICIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );

        pnlOpciones.addTab("tab1", INICIO);

        txtNombreCargo.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreCargo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreCargo.setLabelText("Cargo");

        mNombreCargo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombreCargo.setText("Mensaje de error");

        lblCategoria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(153, 153, 153));
        lblCategoria.setText("Categoría");

        opEmpleado.setText("Empleado");
        opEmpleado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        opObrero.setText("Obrero");
        opObrero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        mCategoriaCargo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mCategoriaCargo.setText("Mensaje de error");

        javax.swing.GroupLayout pnlInformacionCargoLayout = new javax.swing.GroupLayout(pnlInformacionCargo);
        pnlInformacionCargo.setLayout(pnlInformacionCargoLayout);
        pnlInformacionCargoLayout.setHorizontalGroup(
            pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opObrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addComponent(mCategoriaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addGroup(pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mNombreCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
                        .addGap(44, 44, 44))))
        );
        pnlInformacionCargoLayout.setVerticalGroup(
            pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(txtNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(opObrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mCategoriaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btnRegistrarCargo.setText("REGISTRAR");

        javax.swing.GroupLayout pnlRegistrarCargoLayout = new javax.swing.GroupLayout(pnlRegistrarCargo);
        pnlRegistrarCargo.setLayout(pnlRegistrarCargoLayout);
        pnlRegistrarCargoLayout.setHorizontalGroup(
            pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlInformacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        pnlRegistrarCargoLayout.setVerticalGroup(
            pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(pnlInformacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        pnlCargo.addTab("tab1", pnlRegistrarCargo);

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlListaCargosLayout = new javax.swing.GroupLayout(pnlListaCargos);
        pnlListaCargos.setLayout(pnlListaCargosLayout);
        pnlListaCargosLayout.setHorizontalGroup(
            pnlListaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaCargosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        pnlListaCargosLayout.setVerticalGroup(
            pnlListaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaCargosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        pnlCargo.addTab("tab2", pnlListaCargos);

        javax.swing.GroupLayout CARGOSLayout = new javax.swing.GroupLayout(CARGOS);
        CARGOS.setLayout(CARGOSLayout);
        CARGOSLayout.setHorizontalGroup(
            CARGOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARGOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1030, Short.MAX_VALUE))
        );
        CARGOSLayout.setVerticalGroup(
            CARGOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARGOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab2", CARGOS);

        pnlDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        pnlDatosPersonales.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtDni.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDni.setLabelText("DNI");

        mDni.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mDni.setForeground(new java.awt.Color(63, 63, 63));
        mDni.setText("Mensaje de error");

        txtApePaterno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtApePaterno.setLabelText("Apellido Paterno");

        lblGenero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(153, 153, 153));
        lblGenero.setText("Género");

        lblEstadoCivil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblEstadoCivil.setForeground(new java.awt.Color(153, 153, 153));
        lblEstadoCivil.setText("Estado Civil");

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

        opFemenino.setText("Femenino");
        opFemenino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        opMasculino.setText("Masculino");
        opMasculino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        opSoltero.setText("Soltero");
        opSoltero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        opCasado.setText("Casado");
        opCasado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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

        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

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
                                .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(lblEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(mDni, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(mFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(245, 245, 245))
                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(324, 324, 324))))
        );
        pnlDatosPersonalesLayout.setVerticalGroup(
            pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opFemenino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opMasculino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opSoltero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opCasado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opConviviente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFotoTrabajador.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selección de foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        lblFotoTrabajador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFotoTrabajador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoTrabajador.setText("FOTO");

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
                        .addComponent(lblFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(81, Short.MAX_VALUE))
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

        pnlInformacionAcademica.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información Académica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Grado de instrucción");

        txtProfesion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtProfesion.setLabelText("Profesión");

        opPrimaria.setText("Primaria completa");
        opPrimaria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        opSecundaria.setText("Secundaria completa");
        opSecundaria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        opTecnico.setText("Técnico");
        opTecnico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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
                    .addComponent(txtProfesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mProfesion, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegistrarTrabajador.setText("REGISTRAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnlInformacionAcademica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlAsignacionCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnlInformacionAcademica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAsignacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRegistrarTrabajadorLayout = new javax.swing.GroupLayout(pnlRegistrarTrabajador);
        pnlRegistrarTrabajador.setLayout(pnlRegistrarTrabajadorLayout);
        pnlRegistrarTrabajadorLayout.setHorizontalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        pnlRegistrarTrabajadorLayout.setVerticalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 397, Short.MAX_VALUE)
                        .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2570, 2570, 2570))
        );

        pnlTrabajador.addTab("Nuevo Trabajador", pnlRegistrarTrabajador);

        cboTrabajadorPerfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboTrabajadorPerfil.setLabeText("Trabajador");

        txtFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaIngreso.setLabelText("Fecha de ingreso");

        radioButton1.setText("Operaciones");
        radioButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        radioButton2.setText("Seguridad");
        radioButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Área");

        radioButton3.setText("Administración");
        radioButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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

        checkBox1.setText("Cesamiento de trabajador");
        checkBox1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtFechaCese.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaCese.setLabelText("Fecha de cese");

        txtMotivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMotivo.setLabelText("Motivo");

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
                    .addComponent(txtMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mFechaIngreso2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel7Layout.setVerticalGroup(
            roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaIngreso2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnlRegistrarPerfilLaboralLayout = new javax.swing.GroupLayout(pnlRegistrarPerfilLaboral);
        pnlRegistrarPerfilLaboral.setLayout(pnlRegistrarPerfilLaboralLayout);
        pnlRegistrarPerfilLaboralLayout.setHorizontalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                        .addComponent(checkBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                        .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roundedPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundedPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1057, 1057, 1057))))
        );
        pnlRegistrarPerfilLaboralLayout.setVerticalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(roundedPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Perfil Laboral", pnlRegistrarPerfilLaboral);

        cboTrabajadorPerfil1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboTrabajadorPerfil1.setLabeText("Trabajador");

        txtFechaIngreso2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaIngreso2.setLabelText("Fecha de ingreso");

        radioButton5.setText("Operaciones");
        radioButton5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        radioButton6.setText("Seguridad");
        radioButton6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Área");

        radioButton7.setText("Administración");
        radioButton7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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
                .addContainerGap(1030, Short.MAX_VALUE))
        );
        pnlRegistrarLicenciaLayout.setVerticalGroup(
            pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(roundedPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("tab3", pnlRegistrarLicencia);

        javax.swing.GroupLayout TRABAJADORESLayout = new javax.swing.GroupLayout(TRABAJADORES);
        TRABAJADORES.setLayout(TRABAJADORESLayout);
        TRABAJADORESLayout.setHorizontalGroup(
            TRABAJADORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRABAJADORESLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 1498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        TRABAJADORESLayout.setVerticalGroup(
            TRABAJADORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRABAJADORESLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab3", TRABAJADORES);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 636, Short.MAX_VALUE)
        );

        tabbedPane1.addTab("tab1", jPanel2);

        javax.swing.GroupLayout EQUIPOSLayout = new javax.swing.GroupLayout(EQUIPOS);
        EQUIPOS.setLayout(EQUIPOSLayout);
        EQUIPOSLayout.setHorizontalGroup(
            EQUIPOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EQUIPOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(789, Short.MAX_VALUE))
        );
        EQUIPOSLayout.setVerticalGroup(
            EQUIPOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EQUIPOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab4", EQUIPOS);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1558, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 854, Short.MAX_VALUE)
        );

        pnlOpciones.addTab("tab5", jPanel3);

        pnlBackground.add(pnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 1560, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 1845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup AreaPerfil;
    private javax.swing.JPanel CARGOS;
    public javax.swing.ButtonGroup CategoriaCargo;
    public javax.swing.JPanel EQUIPOS;
    public javax.swing.ButtonGroup EstadoCivil;
    public javax.swing.ButtonGroup Genero;
    public javax.swing.ButtonGroup GradoIntruccion;
    private javax.swing.JPanel INICIO;
    private javax.swing.JPanel TRABAJADORES;
    public gamm_Button.Button btnRegistrarCargo;
    public gamm_Button.Button btnRegistrarTrabajador;
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
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCategoria;
    public javax.swing.JLabel lblEquipos;
    private javax.swing.JLabel lblEstadoCivil;
    public gamm_LavelAvatar.LabelAvatar lblFoto;
    public javax.swing.JLabel lblFotoTrabajador;
    private javax.swing.JLabel lblGenero;
    public javax.swing.JLabel lblInicio;
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
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCabecera;
    public gamm_Panel.TabbedPane pnlCargo;
    private gamm_Panel.RoundedPanel pnlDatosPersonales;
    private gamm_Panel.RoundedPanel pnlFotoTrabajador;
    private gamm_Panel.RoundedPanel pnlInformacionAcademica;
    private gamm_Panel.RoundedPanel pnlInformacionCargo;
    private javax.swing.JPanel pnlItems;
    private javax.swing.JPanel pnlListaCargos;
    private javax.swing.JPanel pnlMenu;
    public gamm_Panel.TabbedPane pnlOpciones;
    public javax.swing.JPanel pnlRegistrarCargo;
    public javax.swing.JPanel pnlRegistrarLicencia;
    public javax.swing.JPanel pnlRegistrarPerfilLaboral;
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
    public javax.swing.JLabel txtCodCargoAsignado;
    public gamm_TextField.TextField txtDireccion;
    public gamm_TextField.TextField txtDni;
    public gamm_TextField.TextField txtFechaCese;
    public gamm_TextField.TextField txtFechaIngreso;
    public gamm_TextField.TextField txtFechaIngreso2;
    public gamm_TextField.TextField txtFechaNacimiento;
    public gamm_TextField.TextField txtMotivo;
    public gamm_TextField.TextField txtNombreCargo;
    public gamm_TextField.TextField txtNombreTrabajador;
    public gamm_TextField.TextField txtProfesion;
    public javax.swing.JTextField txtRuta;
    public gamm_TextField.TextField txtSueldo;
    public gamm_TextField.TextField txtSueldo2;
    public gamm_TextField.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
