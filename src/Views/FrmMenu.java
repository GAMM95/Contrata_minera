package Views;

import Models.*;
import Controllers.MenuController;

public class FrmMenu extends javax.swing.JFrame {

    //  Instacia del formularioMenu
    private static FrmMenu instancia;

    public static FrmMenu getInstancia() {
        if (instancia == null) {
            instancia = new FrmMenu();
        }
        return instancia;
    }

    //  Instancias de las clases del modelo
    Rol tu = new Rol();
    Usuario us = new Usuario();
    UsuarioDAO usDAO = new UsuarioDAO();
    Cargo ca = new Cargo();
    CargoDAO caDAO = new CargoDAO();
    Trabajador tra = new Trabajador();
    TrabajadorDAO traDAO = new TrabajadorDAO();
    Vehiculo ve = new Vehiculo();
    Turno tur = new Turno();
    Guardia gua = new Guardia();

    public FrmMenu() {
        initComponents();
        MenuController menuControl = new MenuController(this);
    }

    public FrmMenu(Usuario us, Rol tu) {
        initComponents();
        this.tu = tu;
        this.us = us;
        //  Restriccion de privilegios
        if (tu.getIdRol() == 1) {
            pnlInicio.remove(pnlDatosEmpresa);
            pnlTrabajador.remove(pnlRegistrarCargo);
            pnlTrabajador.remove(pnlRegistrarTrabajador);
            pnlTrabajador.remove(pnlRegistrarPerfilLaboral);
        } else if (tu.getIdRol() == 2) {
            pnlInicio.remove(pnlInformacionEmpresa);
            pnlTrabajador.remove(pnlListarTrabajadores);
        }
        MenuController menuControl = new MenuController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Genero = new javax.swing.ButtonGroup();
        EstadoCivil = new javax.swing.ButtonGroup();
        GradoIntruccion = new javax.swing.ButtonGroup();
        CategoriaCargo = new javax.swing.ButtonGroup();
        AreaPerfil = new javax.swing.ButtonGroup();
        Asistencia = new javax.swing.ButtonGroup();
        fechaNacimiento = new gamm_DateChooser.DateChooser();
        fechaIngreso = new gamm_DateChooser.DateChooser();
        fechaCese = new gamm_DateChooser.DateChooser();
        fechaEmision = new gamm_DateChooser.DateChooser();
        fechaCaducidad = new gamm_DateChooser.DateChooser();
        fechaCompra = new gamm_DateChooser.DateChooser();
        fechaFiltroReparto = new gamm_DateChooser.DateChooser();
        popupTrabajador = new javax.swing.JPopupMenu();
        JCesarTrabajador = new javax.swing.JMenuItem();
        JReingresarTrabajador = new javax.swing.JMenuItem();
        fechaAsistencia = new gamm_DateChooser.DateChooser();
        pnlBackground = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        lblRol = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        pnlItems = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        itemInicio = new gamm_Panel.MenuItem();
        lblInicio = new javax.swing.JLabel();
        itemTrabajadores = new gamm_Panel.MenuItem();
        lblCargo = new javax.swing.JLabel();
        itemMaquinaria = new gamm_Panel.MenuItem();
        lblTrabajadores = new javax.swing.JLabel();
        itemGuardias = new gamm_Panel.MenuItem();
        lblGuardias = new javax.swing.JLabel();
        itemEquipos = new gamm_Panel.MenuItem();
        lblEquipos = new javax.swing.JLabel();
        itemCargos4 = new gamm_Panel.MenuItem();
        lblFoto = new gamm_LavelAvatar.LabelAvatar();
        pnlCabecera = new javax.swing.JPanel();
        pnlOpciones = new gamm_Panel.TabbedPane();
        INICIO = new javax.swing.JPanel();
        pnlInicio = new gamm_Panel.TabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        pnlInformacionEmpresa = new javax.swing.JPanel();
        pnlInfoEmpresa = new gamm_Panel.RoundedPanel();
        txtRucUpdate = new gamm_TextField.TextField();
        txtRazonSocialUpdate = new gamm_TextField.TextField();
        txtCiiuUpdate = new gamm_TextField.TextField();
        txtTelefonoUpdate = new gamm_TextField.TextField();
        txtCelularUpdate = new gamm_TextField.TextField();
        ckbAgregarCelular = new gamm_CheckBox.CheckBox();
        txtDireccionUpdate = new gamm_TextField.TextField();
        txtEmailUpdate = new gamm_TextField.TextField();
        txtPagWebUpdate = new gamm_TextField.TextField();
        txtIdEmpresaUpdate = new javax.swing.JLabel();
        roundedPanel3 = new gamm_Panel.RoundedPanel();
        lblLogoUpdate = new javax.swing.JLabel();
        btnSeleccionarLogo = new gamm_Button.ButtonLine();
        txtRutaUpdate = new javax.swing.JTextField();
        btnHabilitar = new gamm_Button.Button();
        btnModificarEmpresa = new gamm_Button.Button();
        btnCancelarEmpresa = new gamm_Button.Button();
        mLogoUpdate = new javax.swing.JLabel();
        pnlDatosEmpresa = new javax.swing.JPanel();
        roundedPanel4 = new gamm_Panel.RoundedPanel();
        txtRucDatos = new gamm_TextField.TextField();
        txtRazonSocialDatos = new gamm_TextField.TextField();
        txtCiiuDatos = new gamm_TextField.TextField();
        txtTelefonoEmpresaDatos = new gamm_TextField.TextField();
        txtCelularEmpresaDatos = new gamm_TextField.TextField();
        txtEmailEmpresaDatos = new gamm_TextField.TextField();
        txtDireccionEmpresaDatos = new gamm_TextField.TextField();
        txtPaginaWebEmpresaDatos = new gamm_TextField.TextField();
        txtIdEmpresaDatos = new javax.swing.JLabel();
        roundedPanel6 = new gamm_Panel.RoundedPanel();
        lblLogoEmpresaDatos = new javax.swing.JLabel();
        mLogoDatos = new javax.swing.JLabel();
        txtRutaEmpresaDatos = new javax.swing.JTextField();
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
        txtIdTrabajador = new javax.swing.JTextField();
        pnlFotoTrabajador = new gamm_Panel.RoundedPanel();
        lblFotoTrabajador = new javax.swing.JLabel();
        mFotoTrabajador = new javax.swing.JLabel();
        txtRutaFotoTrabajador = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pnlAsignacionCargo = new gamm_Panel.RoundedPanel();
        txtCodCargoAsignado = new javax.swing.JLabel();
        btnSeleccionarCargo = new gamm_Button.ButtonLine();
        txtCargoAsignado = new gamm_TextField.TextField();
        mCargoAsignado = new javax.swing.JLabel();
        pnlInformacionAcademica = new gamm_Panel.RoundedPanel();
        jLabel4 = new javax.swing.JLabel();
        txtProfesion = new gamm_TextField.TextField();
        opPrimaria = new gamm_RadioButton.RadioButton();
        opSecundaria = new gamm_RadioButton.RadioButton();
        opTecnico = new gamm_RadioButton.RadioButton();
        opUniversitaria = new gamm_RadioButton.RadioButton();
        mGradoInstruccion = new javax.swing.JLabel();
        mProfesion = new javax.swing.JLabel();
        roundedPanel12 = new gamm_Panel.RoundedPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTrabajadores = new javax.swing.JTable();
        txtBusquedaTrabajador = new gamm_TextField.TextField();
        btnActualizarTrabajador = new gamm_Button.Button();
        btnRegistrarTrabajador = new gamm_Button.Button();
        pnlListarTrabajadores = new javax.swing.JPanel();
        roundedPanel13 = new gamm_Panel.RoundedPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblListaTrabajadores = new javax.swing.JTable();
        txtFiltroTrabajadorLista = new gamm_TextField.TextField();
        cboFiltrarTrabajadorPor = new gamm_ComboBox.Combobox();
        pnlRegistrarCargo = new javax.swing.JPanel();
        pnlInformacionCargo = new gamm_Panel.RoundedPanel();
        txtNombreCargo = new gamm_TextField.TextField();
        mNombreCargo = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        opEmpleado = new gamm_RadioButton.RadioButton();
        opObrero = new gamm_RadioButton.RadioButton();
        mCategoriaCargo = new javax.swing.JLabel();
        txtCodCargo = new javax.swing.JTextField();
        roundedPanel9 = new gamm_Panel.RoundedPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();
        btnActualizarCargo = new gamm_Button.Button();
        btnRegistrarCargo = new gamm_Button.Button();
        btnCancelarCargo = new gamm_Button.Button();
        pnlListarCargos = new javax.swing.JPanel();
        roundedPanel1 = new gamm_Panel.RoundedPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblListaCargos = new javax.swing.JTable();
        pnlRegistrarPerfilLaboral = new javax.swing.JPanel();
        roundedPanel5 = new gamm_Panel.RoundedPanel();
        txtFechaIngreso = new gamm_TextField.TextField();
        txtSueldo = new gamm_TextField.TextField();
        mFechaIngreso = new javax.swing.JLabel();
        mSueldo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCodPerfilLaboral = new javax.swing.JLabel();
        cboArea = new gamm_ComboBox.Combobox();
        mArea = new javax.swing.JLabel();
        pnlCesamientoTrabajador = new gamm_Panel.RoundedPanel();
        txtFechaCese = new gamm_TextField.TextField();
        txtMotivo = new gamm_TextField.TextField();
        mFechaCese = new javax.swing.JLabel();
        mMotivoCese = new javax.swing.JLabel();
        roundedPanel7 = new gamm_Panel.RoundedPanel();
        btnSeleccionarTrabajadorPerfil = new gamm_Button.ButtonLine();
        txtTrabajadorAsignadoPerfil = new gamm_TextField.TextField();
        txtIdTrabajadorPerfil = new javax.swing.JLabel();
        txtCargoAsignadoPerfil = new gamm_TextField.TextField();
        mTrabajadorAsignadoPerfil = new javax.swing.JLabel();
        pnlListaContratosUsuario = new gamm_Panel.RoundedPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPerfilLaboral = new javax.swing.JTable();
        txtFiltrarTrabajadorPerfil = new gamm_TextField.TextField();
        btnEstadoPerfil = new gamm_Button.Button();
        btnRegistrarPerfilLaboral = new gamm_Button.Button();
        btnActualizarPerfil = new gamm_Button.Button();
        pnlListarPerfilLaboral = new javax.swing.JPanel();
        roundedPanel16 = new gamm_Panel.RoundedPanel();
        cboFiltrarContratoPor = new gamm_ComboBox.Combobox();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblListaContratos = new javax.swing.JTable();
        txtFiltroContratoLista = new gamm_TextField.TextField();
        pnlRegistrarLicencia = new javax.swing.JPanel();
        roundedPanel10 = new gamm_Panel.RoundedPanel();
        txtFechaEmsion = new gamm_TextField.TextField();
        mFechaEmision = new javax.swing.JLabel();
        mFechaCaducidad = new javax.swing.JLabel();
        txtNumLicencia = new gamm_TextField.TextField();
        mNumLicencia = new javax.swing.JLabel();
        cboCategoriaLicencia = new gamm_ComboBox.Combobox();
        mCategoriaLicencia = new javax.swing.JLabel();
        txtFechaCaducidad = new gamm_TextField.TextField();
        txtCodLicencia = new javax.swing.JLabel();
        roundedPanel8 = new gamm_Panel.RoundedPanel();
        btnSeleccionarTrabajadorLicencia = new gamm_Button.ButtonLine();
        txtTrabajadorAsignadoLicencia = new gamm_TextField.TextField();
        mTrabajadorAsignadoLicencia = new javax.swing.JLabel();
        txtIdTrabajadorLicencia = new javax.swing.JLabel();
        txtCargoAsignadoLicencia = new gamm_TextField.TextField();
        roundedPanel14 = new gamm_Panel.RoundedPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblLicencias = new javax.swing.JTable();
        txtFiltrarTrabajadorLicencia = new gamm_TextField.TextField();
        btnRegistrarLicencia = new gamm_Button.Button();
        btnActualizarLicencia = new gamm_Button.Button();
        pnlListarLicencia = new javax.swing.JPanel();
        roundedPanel19 = new gamm_Panel.RoundedPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblListaLicencias = new javax.swing.JTable();
        cboFiltrarLicenciaPor = new gamm_ComboBox.Combobox();
        txtFiltroLicenciaLista = new gamm_TextField.TextField();
        GUARDIAS = new javax.swing.JPanel();
        pnlGuardia = new gamm_Panel.TabbedPane();
        pnlRegistrarGuardia = new javax.swing.JPanel();
        roundedPanel17 = new gamm_Panel.RoundedPanel();
        txtNombreGuardia = new gamm_TextField.TextField();
        txtTurno = new gamm_TextField.TextField();
        mNombreGuardia = new javax.swing.JLabel();
        txtCodGuardia = new javax.swing.JLabel();
        txtCodTurno = new javax.swing.JLabel();
        txtHoraEntrada = new gamm_TextField.TextField();
        mTurno = new javax.swing.JLabel();
        txtHoraSalida = new gamm_TextField.TextField();
        roundedPanel11 = new gamm_Panel.RoundedPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblGuardias = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnRegistrarGuardia = new gamm_Button.Button();
        roundedPanel18 = new gamm_Panel.RoundedPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblTurnos = new javax.swing.JTable();
        btnSeleccionarTurno = new gamm_Button.Button();
        jSeparator1 = new javax.swing.JSeparator();
        pnlRegistrarAsistencia = new javax.swing.JPanel();
        roundedPanel22 = new gamm_Panel.RoundedPanel();
        txtFechaReparto = new gamm_TextField.TextField();
        mFechaAsistencia = new javax.swing.JLabel();
        roundedPanel27 = new gamm_Panel.RoundedPanel();
        btnSeleccionarTrabajadorReparto = new gamm_Button.ButtonLine();
        txtTrabajadorAsignadoReparto = new gamm_TextField.TextField();
        mTrabajadorAsignadoReparto = new javax.swing.JLabel();
        txtCargoSeleccionadoReparto = new gamm_TextField.TextField();
        txtIdTrabajadorReparto = new javax.swing.JLabel();
        roundedPanel29 = new gamm_Panel.RoundedPanel();
        btnSeleccionarGuardiaReparto = new gamm_Button.ButtonLine();
        txtGuardiaSeleccionadaReparto = new gamm_TextField.TextField();
        txtTurnoSeleccionadoReparto = new gamm_TextField.TextField();
        mGuardiaSeleccionadaReparto = new javax.swing.JLabel();
        txtCodGuardiaReparto = new javax.swing.JLabel();
        roundedPanel30 = new gamm_Panel.RoundedPanel();
        btnSeleccionarVehiculoReparto = new gamm_Button.ButtonLine();
        txtVehiculoSeleccionadoReparto = new gamm_TextField.TextField();
        txtTipoSeleccionadoReparto = new gamm_TextField.TextField();
        mVehiculoSeleccionadoReparto = new javax.swing.JLabel();
        txtCodVehiculoReparto = new javax.swing.JLabel();
        lblEstadoCivil1 = new javax.swing.JLabel();
        opSi = new gamm_RadioButton.RadioButton();
        opNo = new gamm_RadioButton.RadioButton();
        txtCodReparto = new javax.swing.JLabel();
        roundedPanel28 = new gamm_Panel.RoundedPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblRepartoA = new javax.swing.JTable();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblRepartoB = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblRepartoC = new javax.swing.JTable();
        txtFiltrarTrabajadorReparto = new gamm_TextField.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRegistrarReparto = new gamm_Button.Button();
        button2 = new gamm_Button.Button();
        pnlListarAsistencias = new javax.swing.JPanel();
        roundedPanel31 = new gamm_Panel.RoundedPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblListaRepartoA = new javax.swing.JTable();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblListaRepartoB = new javax.swing.JTable();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblListaRepartoC = new javax.swing.JTable();
        txtBusquedaNombreAsistencia = new gamm_TextField.TextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFechaFiltroReparto = new gamm_TextField.TextField();
        btnBuscarAsistencia = new gamm_Button.Button();
        btnCancelarBusqueda = new gamm_Button.Button();
        EQUIPOS = new javax.swing.JPanel();
        tabbedPane1 = new gamm_Panel.TabbedPane();
        jPanel2 = new javax.swing.JPanel();
        pnlInformacionVehiculo = new gamm_Panel.RoundedPanel();
        txtIdVehiculo = new gamm_TextField.TextField();
        txtPlaca = new gamm_TextField.TextField();
        txtModelo = new gamm_TextField.TextField();
        mIdVehiculo = new javax.swing.JLabel();
        mPlaca = new javax.swing.JLabel();
        cboMarcaVehiculo = new gamm_ComboBox.Combobox();
        txtFechaCompra = new gamm_TextField.TextField();
        txtAño = new gamm_TextField.TextField();
        mFechaCompra = new javax.swing.JLabel();
        txtTipoVehiculoAsignado = new gamm_TextField.TextField();
        mMarca = new javax.swing.JLabel();
        mModelo = new javax.swing.JLabel();
        mAño = new javax.swing.JLabel();
        mTipoVehiculoAsignado = new javax.swing.JLabel();
        txtCodTipoVehiculoAsignado = new javax.swing.JLabel();
        pnlTipoVehiculo1 = new gamm_Panel.RoundedPanel();
        txtTipoVehiculo = new gamm_TextField.TextField();
        mTipoVehiculo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoVehiculo = new javax.swing.JTable();
        btnRegistrarTipoVehiculo = new gamm_Button.Button();
        txtFiltroTipoVehiculo = new gamm_TextField.TextField();
        txtCodTipoVehiculo = new javax.swing.JLabel();
        btnSeleccionarTipoVehiculo = new gamm_Button.Button();
        roundedPanel15 = new gamm_Panel.RoundedPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();
        btnRegistrarVehiculo = new gamm_Button.Button();
        jPanel4 = new javax.swing.JPanel();
        roundedPanel2 = new gamm_Panel.RoundedPanel();
        txtCodVale = new gamm_TextField.TextField();
        mCodVale = new javax.swing.JLabel();
        txtHoraAbastecimiento = new gamm_TextField.TextField();
        txtLugar = new gamm_TextField.TextField();
        txtIdVale = new javax.swing.JLabel();
        txtHorometroVale = new gamm_TextField.TextField();
        txtGalonesVale = new gamm_TextField.TextField();
        mHoraAbastecimiento = new javax.swing.JLabel();
        mLugar = new javax.swing.JLabel();
        mHorometroVale = new javax.swing.JLabel();
        mGalones = new javax.swing.JLabel();
        btnSeleccionarRepartoVale = new gamm_Button.ButtonLine();
        txtCodRepartoVale = new javax.swing.JLabel();
        roundedPanel20 = new gamm_Panel.RoundedPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblVale = new javax.swing.JTable();
        roundedPanel21 = new gamm_Panel.RoundedPanel();
        txtTrabajadorAsignadoVale = new gamm_TextField.TextField();
        textField2 = new gamm_TextField.TextField();
        txtTurnoVale = new gamm_TextField.TextField();
        textField4 = new gamm_TextField.TextField();
        textField5 = new gamm_TextField.TextField();
        btnActualizarVale = new gamm_Button.Button();
        btnRegistrarVale = new gamm_Button.Button();
        jPanel9 = new javax.swing.JPanel();
        panelNuevo = new javax.swing.JPanel();

        fechaNacimiento.setDateFormat("yyyy-MM-dd");
        fechaNacimiento.setTextRefernce(txtFechaNacimiento);

        fechaIngreso.setDateFormat("yyyy-MM-dd");
        fechaIngreso.setTextRefernce(txtFechaIngreso);

        fechaCese.setDateFormat("yyyy-MM-dd");
        fechaCese.setTextRefernce(txtFechaCese);

        fechaEmision.setDateFormat("yyyy-MM-dd");
        fechaEmision.setTextRefernce(txtFechaEmsion);

        fechaCaducidad.setDateFormat("yyyy-MM-dd");
        fechaCaducidad.setTextRefernce(txtFechaCaducidad);

        fechaCompra.setDateFormat("yyyy-MM-dd");
        fechaCompra.setTextRefernce(txtFechaCompra);

        fechaFiltroReparto.setDateFormat("yyyy-MM-dd");
        fechaFiltroReparto.setTextRefernce(txtFechaFiltroReparto);

        popupTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        popupTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCesarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JCesarTrabajador.setText("Eliminar trabajador");
        popupTrabajador.add(JCesarTrabajador);

        JReingresarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JReingresarTrabajador.setText("Reingresar Trabajador");
        popupTrabajador.add(JReingresarTrabajador);

        fechaAsistencia.setDateFormat("yyyy-MM-dd");
        fechaAsistencia.setTextRefernce(txtFechaReparto);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(26, 26, 46));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(26, 26, 46));

        lblRol.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setText("Rol");

        lblNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");

        pnlItems.setBackground(new java.awt.Color(26, 26, 46));

        jLabel6.setText("TRABAJADORES");

        itemInicio.setBackground(new java.awt.Color(34, 40, 49));

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

        itemTrabajadores.setBackground(new java.awt.Color(34, 40, 49));

        lblCargo.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblCargo.setText("TRABAJADORES");

        javax.swing.GroupLayout itemTrabajadoresLayout = new javax.swing.GroupLayout(itemTrabajadores);
        itemTrabajadores.setLayout(itemTrabajadoresLayout);
        itemTrabajadoresLayout.setHorizontalGroup(
            itemTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemTrabajadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        itemTrabajadoresLayout.setVerticalGroup(
            itemTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        itemMaquinaria.setBackground(new java.awt.Color(34, 40, 49));

        lblTrabajadores.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblTrabajadores.setText("GUARDIAS");

        javax.swing.GroupLayout itemMaquinariaLayout = new javax.swing.GroupLayout(itemMaquinaria);
        itemMaquinaria.setLayout(itemMaquinariaLayout);
        itemMaquinariaLayout.setHorizontalGroup(
            itemMaquinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemMaquinariaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        itemMaquinariaLayout.setVerticalGroup(
            itemMaquinariaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        lblGuardias.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblGuardias.setText("REPORTES");

        javax.swing.GroupLayout itemGuardiasLayout = new javax.swing.GroupLayout(itemGuardias);
        itemGuardias.setLayout(itemGuardiasLayout);
        itemGuardiasLayout.setHorizontalGroup(
            itemGuardiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemGuardiasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGuardias, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        itemGuardiasLayout.setVerticalGroup(
            itemGuardiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGuardias, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        lblEquipos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblEquipos.setText("MAQUINARIAS");

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
            .addComponent(itemTrabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemMaquinaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(itemEquipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlItemsLayout.createSequentialGroup()
                .addComponent(itemCargos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(itemGuardias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlItemsLayout.setVerticalGroup(
            pnlItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(itemInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(itemTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(itemMaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(itemEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemGuardias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(itemCargos4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
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
                .addComponent(pnlItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 970));

        pnlCabecera.setBackground(new java.awt.Color(1, 0, 56));

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1620, Short.MAX_VALUE)
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1620, 30));

        pnlOpciones.setBackground(new java.awt.Color(26, 26, 46));
        pnlOpciones.setForeground(new java.awt.Color(255, 255, 255));
        pnlOpciones.setFocusable(false);

        INICIO.setBackground(new java.awt.Color(18, 18, 18));

        pnlInicio.setForeground(new java.awt.Color(255, 255, 255));
        pnlInicio.setFocusable(false);

        jPanel5.setBackground(new java.awt.Color(26, 26, 46));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 989, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(576, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        pnlInicio.addTab("Dashboard", jPanel5);

        pnlInformacionEmpresa.setBackground(new java.awt.Color(26, 26, 46));
        pnlInformacionEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlInfoEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Datos de empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        pnlInfoEmpresa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtRucUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtRucUpdate.setLabelText("RUC");

        txtRazonSocialUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtRazonSocialUpdate.setLabelText("Razón Social");

        txtCiiuUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCiiuUpdate.setLabelText("CIIU");

        txtTelefonoUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefonoUpdate.setLabelText("Teléfono");

        txtCelularUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCelularUpdate.setLabelText("Celular");

        ckbAgregarCelular.setText("Agregar número");
        ckbAgregarCelular.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtDireccionUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDireccionUpdate.setLabelText("Dirección Legal");

        txtEmailUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEmailUpdate.setLabelText("Email");

        txtPagWebUpdate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPagWebUpdate.setLabelText("Página Web");

        txtIdEmpresaUpdate.setText("1");

        javax.swing.GroupLayout pnlInfoEmpresaLayout = new javax.swing.GroupLayout(pnlInfoEmpresa);
        pnlInfoEmpresa.setLayout(pnlInfoEmpresaLayout);
        pnlInfoEmpresaLayout.setHorizontalGroup(
            pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoEmpresaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoEmpresaLayout.createSequentialGroup()
                        .addComponent(txtTelefonoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ckbAgregarCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCelularUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(pnlInfoEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInfoEmpresaLayout.createSequentialGroup()
                                .addComponent(txtRazonSocialUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(txtCiiuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInfoEmpresaLayout.createSequentialGroup()
                                .addComponent(txtRucUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(208, 208, 208)
                                .addComponent(txtIdEmpresaUpdate))
                            .addComponent(txtDireccionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(152, Short.MAX_VALUE))
                    .addGroup(pnlInfoEmpresaLayout.createSequentialGroup()
                        .addGroup(pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmailUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(txtPagWebUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlInfoEmpresaLayout.setVerticalGroup(
            pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoEmpresaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRucUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdEmpresaUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCiiuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocialUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(pnlInfoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbAgregarCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(txtDireccionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtEmailUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtPagWebUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        lblLogoUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnSeleccionarLogo.setText("Seleccionar Foto");

        txtRutaUpdate.setEditable(false);

        btnHabilitar.setText("HABILITAR");

        btnModificarEmpresa.setText("MODIFICAR");

        btnCancelarEmpresa.setText("CANCELAR");

        mLogoUpdate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mLogoUpdate.setForeground(new java.awt.Color(63, 63, 63));
        mLogoUpdate.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnModificarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnCancelarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogoUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeleccionarLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(txtRutaUpdate)
                    .addComponent(mLogoUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblLogoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionarLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mLogoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtRutaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnCancelarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInformacionEmpresaLayout = new javax.swing.GroupLayout(pnlInformacionEmpresa);
        pnlInformacionEmpresa.setLayout(pnlInformacionEmpresaLayout);
        pnlInformacionEmpresaLayout.setHorizontalGroup(
            pnlInformacionEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionEmpresaLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(pnlInfoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        pnlInformacionEmpresaLayout.setVerticalGroup(
            pnlInformacionEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionEmpresaLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(pnlInformacionEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlInfoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pnlInicio.addTab("Configuración empresa", pnlInformacionEmpresa);

        pnlDatosEmpresa.setBackground(new java.awt.Color(26, 26, 46));
        pnlDatosEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel4.setBackground(new java.awt.Color(26, 26, 46));
        roundedPanel4.setForeground(new java.awt.Color(26, 26, 46));
        roundedPanel4.setToolTipText("");
        roundedPanel4.setOpaque(true);

        txtRucDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtRucDatos.setLabelText("RUC");

        txtRazonSocialDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtRazonSocialDatos.setLabelText("Razón Social");

        txtCiiuDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtCiiuDatos.setLabelText("CIIU");

        txtTelefonoEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtTelefonoEmpresaDatos.setLabelText("Teléfono");

        txtCelularEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtCelularEmpresaDatos.setLabelText("Celular");

        txtEmailEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtEmailEmpresaDatos.setLabelText("Email");

        txtDireccionEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtDireccionEmpresaDatos.setLabelText("Dirección Legal");

        txtPaginaWebEmpresaDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtPaginaWebEmpresaDatos.setLabelText("Página Web");

        txtIdEmpresaDatos.setText("1");

        javax.swing.GroupLayout roundedPanel4Layout = new javax.swing.GroupLayout(roundedPanel4);
        roundedPanel4.setLayout(roundedPanel4Layout);
        roundedPanel4Layout.setHorizontalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel4Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel4Layout.createSequentialGroup()
                                .addComponent(txtTelefonoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCelularEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127))
                            .addGroup(roundedPanel4Layout.createSequentialGroup()
                                .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmailEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPaginaWebEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccionEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(149, 199, Short.MAX_VALUE))))
                    .addGroup(roundedPanel4Layout.createSequentialGroup()
                        .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundedPanel4Layout.createSequentialGroup()
                                .addComponent(txtRucDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(txtIdEmpresaDatos))
                            .addComponent(txtRazonSocialDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(txtCiiuDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        roundedPanel4Layout.setVerticalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRucDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdEmpresaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRazonSocialDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCiiuDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefonoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelularEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(txtDireccionEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtEmailEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txtPaginaWebEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        roundedPanel6.setBackground(new java.awt.Color(255, 251, 235));
        roundedPanel6.setForeground(new java.awt.Color(255, 251, 235));

        mLogoDatos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mLogoDatos.setForeground(new java.awt.Color(63, 63, 63));
        mLogoDatos.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel6Layout = new javax.swing.GroupLayout(roundedPanel6);
        roundedPanel6.setLayout(roundedPanel6Layout);
        roundedPanel6Layout.setHorizontalGroup(
            roundedPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel6Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(roundedPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogoEmpresaDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(mLogoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        roundedPanel6Layout.setVerticalGroup(
            roundedPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel6Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblLogoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mLogoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        txtRutaEmpresaDatos.setEditable(false);
        txtRutaEmpresaDatos.setBorder(null);

        javax.swing.GroupLayout pnlDatosEmpresaLayout = new javax.swing.GroupLayout(pnlDatosEmpresa);
        pnlDatosEmpresa.setLayout(pnlDatosEmpresaLayout);
        pnlDatosEmpresaLayout.setHorizontalGroup(
            pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(roundedPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosEmpresaLayout.createSequentialGroup()
                        .addComponent(roundedPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosEmpresaLayout.createSequentialGroup()
                        .addComponent(txtRutaEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))))
        );
        pnlDatosEmpresaLayout.setVerticalGroup(
            pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlDatosEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDatosEmpresaLayout.createSequentialGroup()
                        .addComponent(roundedPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(txtRutaEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pnlInicio.addTab("¿Quiénes somos?", pnlDatosEmpresa);

        javax.swing.GroupLayout INICIOLayout = new javax.swing.GroupLayout(INICIO);
        INICIO.setLayout(INICIOLayout);
        INICIOLayout.setHorizontalGroup(
            INICIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INICIOLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        INICIOLayout.setVerticalGroup(
            INICIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(INICIOLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab1", INICIO);

        TRABAJADORES.setBackground(new java.awt.Color(18, 18, 18));

        pnlTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        pnlTrabajador.setFocusable(false);

        pnlRegistrarTrabajador.setBackground(new java.awt.Color(26, 26, 46));
        pnlRegistrarTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlDatosPersonales.setBackground(new java.awt.Color(34, 40, 49));
        pnlDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Datos personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N
        pnlDatosPersonales.setForeground(new java.awt.Color(34, 40, 49));
        pnlDatosPersonales.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtDni.setBackground(new java.awt.Color(255, 255, 255));
        txtDni.setForeground(new java.awt.Color(26, 26, 46));
        txtDni.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDni.setLabelText("DNI");

        mDni.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mDni.setText("Mensaje de error");

        txtApePaterno.setBackground(new java.awt.Color(255, 255, 255));
        txtApePaterno.setForeground(new java.awt.Color(26, 26, 46));
        txtApePaterno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtApePaterno.setLabelText("Apellido Paterno");

        lblGenero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(153, 153, 153));
        lblGenero.setText("Género");

        lblEstadoCivil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblEstadoCivil.setForeground(new java.awt.Color(153, 153, 153));
        lblEstadoCivil.setText("Estado Civil");

        mApePaterno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mApePaterno.setText("Mensaje de error");

        mApeMaterno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mApeMaterno.setText("Mensaje de error");

        mNombresTrabajador.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombresTrabajador.setText("Mensaje de error");

        txtApeMaterno.setBackground(new java.awt.Color(255, 255, 255));
        txtApeMaterno.setForeground(new java.awt.Color(26, 26, 46));
        txtApeMaterno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtApeMaterno.setLabelText("Apellido Materno");

        txtNombreTrabajador.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreTrabajador.setForeground(new java.awt.Color(26, 26, 46));
        txtNombreTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreTrabajador.setLabelText("Nombres");

        Genero.add(opFemenino);
        opFemenino.setForeground(new java.awt.Color(26, 26, 46));
        opFemenino.setText("Femenino");
        opFemenino.setFocusable(false);
        opFemenino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        Genero.add(opMasculino);
        opMasculino.setForeground(new java.awt.Color(26, 26, 46));
        opMasculino.setText("Masculino");
        opMasculino.setFocusable(false);
        opMasculino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opSoltero);
        opSoltero.setForeground(new java.awt.Color(26, 26, 46));
        opSoltero.setText("Soltero");
        opSoltero.setFocusable(false);
        opSoltero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opCasado);
        opCasado.setForeground(new java.awt.Color(26, 26, 46));
        opCasado.setText("Casado");
        opCasado.setFocusable(false);
        opCasado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opConviviente);
        opConviviente.setForeground(new java.awt.Color(26, 26, 46));
        opConviviente.setText("Conviviente");
        opConviviente.setFocusable(false);
        opConviviente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        mEstadoCivil.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mEstadoCivil.setText("Mensaje de error");

        txtDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtDireccion.setForeground(new java.awt.Color(26, 26, 46));
        txtDireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDireccion.setLabelText("Dirección");

        mDireccion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mDireccion.setText("Mensaje de error");

        txtTelefono.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefono.setForeground(new java.awt.Color(26, 26, 46));
        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefono.setLabelText("Teléfono");

        mTelefono.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTelefono.setText("Mensaje de error");

        mGenero.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mGenero.setText("Mensaje de error");

        txtFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaNacimiento.setForeground(new java.awt.Color(26, 26, 46));
        txtFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaNacimiento.setLabelText("F. Nacimiento (aaaa-mm-dd)");

        mFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaNacimiento.setText("Mensaje de error");

        txtIdTrabajador.setEditable(false);
        txtIdTrabajador.setBackground(new java.awt.Color(255, 255, 255));
        txtIdTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        txtIdTrabajador.setBorder(null);

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
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mDni, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                                                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(80, 80, 80)
                                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(mFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDatosPersonalesLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        pnlFotoTrabajador.setBackground(new java.awt.Color(255, 251, 235));
        pnlFotoTrabajador.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selección de foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N
        pnlFotoTrabajador.setForeground(new java.awt.Color(255, 251, 235));

        lblFotoTrabajador.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFotoTrabajador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFotoTrabajador.setText("FOTO");
        lblFotoTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        mFotoTrabajador.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFotoTrabajador.setForeground(new java.awt.Color(63, 63, 63));
        mFotoTrabajador.setText("Mensaje de error");

        txtRutaFotoTrabajador.setEditable(false);
        txtRutaFotoTrabajador.setBackground(new java.awt.Color(255, 255, 255));
        txtRutaFotoTrabajador.setFont(new java.awt.Font("Dialog", 0, 5)); // NOI18N
        txtRutaFotoTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        txtRutaFotoTrabajador.setBorder(null);

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
                            .addComponent(txtRutaFotoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(txtRutaFotoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(26, 26, 46));

        pnlAsignacionCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Asignación de cargo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtCodCargoAsignado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCodCargoAsignado.setForeground(new java.awt.Color(0, 0, 0));

        btnSeleccionarCargo.setBackground(new java.awt.Color(26, 55, 77));
        btnSeleccionarCargo.setForeground(new java.awt.Color(26, 55, 77));
        btnSeleccionarCargo.setText("...");

        txtCargoAsignado.setEditable(false);
        txtCargoAsignado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCargoAsignado.setLabelText("Cargo asignado");

        mCargoAsignado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mCargoAsignado.setForeground(new java.awt.Color(63, 63, 63));
        mCargoAsignado.setText("Mensaje de error");

        javax.swing.GroupLayout pnlAsignacionCargoLayout = new javax.swing.GroupLayout(pnlAsignacionCargo);
        pnlAsignacionCargo.setLayout(pnlAsignacionCargoLayout);
        pnlAsignacionCargoLayout.setHorizontalGroup(
            pnlAsignacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionCargoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnSeleccionarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlAsignacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mCargoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAsignacionCargoLayout.createSequentialGroup()
                        .addComponent(txtCargoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtCodCargoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        pnlAsignacionCargoLayout.setVerticalGroup(
            pnlAsignacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAsignacionCargoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlAsignacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCargoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodCargoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mCargoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlInformacionAcademica.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información Académica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Grado de instrucción");

        txtProfesion.setBackground(new java.awt.Color(255, 255, 255));
        txtProfesion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtProfesion.setLabelText("Profesión");

        GradoIntruccion.add(opPrimaria);
        opPrimaria.setText("Primaria completa");
        opPrimaria.setFocusable(false);
        opPrimaria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GradoIntruccion.add(opSecundaria);
        opSecundaria.setText("Secundaria completa");
        opSecundaria.setFocusable(false);
        opSecundaria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GradoIntruccion.add(opTecnico);
        opTecnico.setText("Técnico");
        opTecnico.setFocusable(false);
        opTecnico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        GradoIntruccion.add(opUniversitaria);
        opUniversitaria.setText("Universitaria");
        opUniversitaria.setFocusable(false);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInformacionAcademica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlAsignacionCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pnlInformacionAcademica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlAsignacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        roundedPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Lista de trabajadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N

        tblTrabajadores.setBackground(new java.awt.Color(255, 251, 235));
        tblTrabajadores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "DNI", "TRABAJADOR", "DIRECCIÓN", "TELÉFONO", "CARGO", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTrabajadores.setComponentPopupMenu(popupTrabajador);
        tblTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTrabajadores.setRowHeight(25);
        tblTrabajadores.setShowVerticalLines(false);
        tblTrabajadores.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTrabajadores);
        if (tblTrabajadores.getColumnModel().getColumnCount() > 0) {
            tblTrabajadores.getColumnModel().getColumn(0).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(1).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(2).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(3).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(4).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(5).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(6).setResizable(false);
        }

        txtBusquedaTrabajador.setBackground(new java.awt.Color(255, 255, 255));
        txtBusquedaTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBusquedaTrabajador.setLabelText("Búsqueda por nombre ");

        javax.swing.GroupLayout roundedPanel12Layout = new javax.swing.GroupLayout(roundedPanel12);
        roundedPanel12.setLayout(roundedPanel12Layout);
        roundedPanel12Layout.setHorizontalGroup(
            roundedPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(roundedPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel12Layout.setVerticalGroup(
            roundedPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        btnActualizarTrabajador.setBackground(new java.awt.Color(255, 215, 23));
        btnActualizarTrabajador.setText("ACTUALIZAR");

        btnRegistrarTrabajador.setBackground(new java.awt.Color(255, 215, 23));
        btnRegistrarTrabajador.setText("REGISTRAR");

        javax.swing.GroupLayout pnlRegistrarTrabajadorLayout = new javax.swing.GroupLayout(pnlRegistrarTrabajador);
        pnlRegistrarTrabajador.setLayout(pnlRegistrarTrabajadorLayout);
        pnlRegistrarTrabajadorLayout.setHorizontalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                        .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                                .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnActualizarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
        );
        pnlRegistrarTrabajadorLayout.setVerticalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(roundedPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2217, 2217, 2217))
        );

        pnlTrabajador.addTab("Nuevo Trabajador", pnlRegistrarTrabajador);

        pnlListarTrabajadores.setBackground(new java.awt.Color(26, 26, 46));
        pnlListarTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Relación de trabajadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N

        tblListaTrabajadores.setBackground(new java.awt.Color(255, 251, 235));
        tblListaTrabajadores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblListaTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "TRABAJADOR", "DOMICILIO", "CELULAR", "CARGO", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaTrabajadores.setRowHeight(25);
        tblListaTrabajadores.setShowVerticalLines(false);
        tblListaTrabajadores.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblListaTrabajadores);
        if (tblListaTrabajadores.getColumnModel().getColumnCount() > 0) {
            tblListaTrabajadores.getColumnModel().getColumn(0).setResizable(false);
            tblListaTrabajadores.getColumnModel().getColumn(1).setResizable(false);
            tblListaTrabajadores.getColumnModel().getColumn(2).setResizable(false);
            tblListaTrabajadores.getColumnModel().getColumn(3).setResizable(false);
            tblListaTrabajadores.getColumnModel().getColumn(4).setResizable(false);
            tblListaTrabajadores.getColumnModel().getColumn(5).setResizable(false);
        }

        txtFiltroTrabajadorLista.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltroTrabajadorLista.setToolTipText("");
        txtFiltroTrabajadorLista.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cboFiltrarTrabajadorPor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboFiltrarTrabajadorPor.setLabeText("Filtrar por");

        javax.swing.GroupLayout roundedPanel13Layout = new javax.swing.GroupLayout(roundedPanel13);
        roundedPanel13.setLayout(roundedPanel13Layout);
        roundedPanel13Layout.setHorizontalGroup(
            roundedPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel13Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundedPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1389, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel13Layout.createSequentialGroup()
                        .addComponent(cboFiltrarTrabajadorPor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtFiltroTrabajadorLista, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        roundedPanel13Layout.setVerticalGroup(
            roundedPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundedPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroTrabajadorLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFiltrarTrabajadorPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlListarTrabajadoresLayout = new javax.swing.GroupLayout(pnlListarTrabajadores);
        pnlListarTrabajadores.setLayout(pnlListarTrabajadoresLayout);
        pnlListarTrabajadoresLayout.setHorizontalGroup(
            pnlListarTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarTrabajadoresLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlListarTrabajadoresLayout.setVerticalGroup(
            pnlListarTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarTrabajadoresLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Lista de Trabajadores", pnlListarTrabajadores);

        pnlRegistrarCargo.setBackground(new java.awt.Color(26, 26, 46));

        pnlInformacionCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de cargo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtNombreCargo.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreCargo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreCargo.setLabelText("Cargo");

        mNombreCargo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombreCargo.setText("Mensaje de error");

        lblCategoria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(153, 153, 153));
        lblCategoria.setText("Categoría");

        CategoriaCargo.add(opEmpleado);
        opEmpleado.setText("Empleado");
        opEmpleado.setFocusPainted(false);
        opEmpleado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        CategoriaCargo.add(opObrero);
        opObrero.setText("Obrero");
        opObrero.setFocusPainted(false);
        opObrero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        mCategoriaCargo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mCategoriaCargo.setText("Mensaje de error");

        txtCodCargo.setEditable(false);
        txtCodCargo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodCargo.setBorder(null);

        javax.swing.GroupLayout pnlInformacionCargoLayout = new javax.swing.GroupLayout(pnlInformacionCargo);
        pnlInformacionCargo.setLayout(pnlInformacionCargoLayout);
        pnlInformacionCargoLayout.setHorizontalGroup(
            pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(opEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(opObrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addComponent(mCategoriaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addComponent(mNombreCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addGroup(pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                                .addComponent(txtNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        pnlInformacionCargoLayout.setVerticalGroup(
            pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                .addGroup(pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacionCargoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtCodCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(mNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInformacionCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opObrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mCategoriaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        tblCargos.setAutoCreateRowSorter(true);
        tblCargos.setBackground(new java.awt.Color(255, 255, 255));
        tblCargos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "CARGO", "CATEGORÍA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCargos.setRowHeight(25);
        tblCargos.setShowVerticalLines(false);
        tblCargos.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblCargos);
        if (tblCargos.getColumnModel().getColumnCount() > 0) {
            tblCargos.getColumnModel().getColumn(0).setResizable(false);
            tblCargos.getColumnModel().getColumn(1).setResizable(false);
            tblCargos.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout roundedPanel9Layout = new javax.swing.GroupLayout(roundedPanel9);
        roundedPanel9.setLayout(roundedPanel9Layout);
        roundedPanel9Layout.setHorizontalGroup(
            roundedPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        roundedPanel9Layout.setVerticalGroup(
            roundedPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel9Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        btnActualizarCargo.setBackground(new java.awt.Color(255, 215, 23));
        btnActualizarCargo.setText("ACTUALIZAR");

        btnRegistrarCargo.setBackground(new java.awt.Color(255, 215, 23));
        btnRegistrarCargo.setText("REGISTRAR");

        btnCancelarCargo.setText("CANCELAR");

        javax.swing.GroupLayout pnlRegistrarCargoLayout = new javax.swing.GroupLayout(pnlRegistrarCargo);
        pnlRegistrarCargo.setLayout(pnlRegistrarCargoLayout);
        pnlRegistrarCargoLayout.setHorizontalGroup(
            pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlInformacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                        .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnActualizarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnCancelarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addComponent(roundedPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        pnlRegistrarCargoLayout.setVerticalGroup(
            pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                        .addComponent(pnlInformacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(btnCancelarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Nuevo Cargo", pnlRegistrarCargo);

        pnlListarCargos.setBackground(new java.awt.Color(26, 26, 46));

        tblListaCargos.setBackground(new java.awt.Color(255, 255, 255));
        tblListaCargos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblListaCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "CARGO", "CATEGORÍA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaCargos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblListaCargos.setRowHeight(25);
        tblListaCargos.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tblListaCargos);
        if (tblListaCargos.getColumnModel().getColumnCount() > 0) {
            tblListaCargos.getColumnModel().getColumn(0).setResizable(false);
            tblListaCargos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblListaCargos.getColumnModel().getColumn(1).setResizable(false);
            tblListaCargos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblListaCargos.getColumnModel().getColumn(2).setResizable(false);
            tblListaCargos.getColumnModel().getColumn(2).setPreferredWidth(80);
        }

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlListarCargosLayout = new javax.swing.GroupLayout(pnlListarCargos);
        pnlListarCargos.setLayout(pnlListarCargosLayout);
        pnlListarCargosLayout.setHorizontalGroup(
            pnlListarCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarCargosLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(804, Short.MAX_VALUE))
        );
        pnlListarCargosLayout.setVerticalGroup(
            pnlListarCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarCargosLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Lista de Cargos", pnlListarCargos);

        pnlRegistrarPerfilLaboral.setBackground(new java.awt.Color(26, 26, 46));
        pnlRegistrarPerfilLaboral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de ingreso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtFechaIngreso.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaIngreso.setLabelText("Fecha de ingreso");

        txtSueldo.setBackground(new java.awt.Color(255, 255, 255));
        txtSueldo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSueldo.setLabelText("Sueldo");

        mFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaIngreso.setForeground(new java.awt.Color(63, 63, 63));
        mFechaIngreso.setText("Mensaje de error");

        mSueldo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mSueldo.setForeground(new java.awt.Color(63, 63, 63));
        mSueldo.setText("Mensaje de error");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("soles");

        txtCodPerfilLaboral.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCodPerfilLaboral.setForeground(new java.awt.Color(255, 255, 255));
        txtCodPerfilLaboral.setToolTipText("");

        cboArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboArea.setLabeText("Área");

        mArea.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mArea.setForeground(new java.awt.Color(63, 63, 63));
        mArea.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel5Layout = new javax.swing.GroupLayout(roundedPanel5);
        roundedPanel5.setLayout(roundedPanel5Layout);
        roundedPanel5Layout.setHorizontalGroup(
            roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodPerfilLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mArea, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundedPanel5Layout.createSequentialGroup()
                                .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 56, Short.MAX_VALUE))))
        );
        roundedPanel5Layout.setVerticalGroup(
            roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel5Layout.createSequentialGroup()
                .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtCodPerfilLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mArea, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(mSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCesamientoTrabajador.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de cese laboral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtFechaCese.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaCese.setForeground(new java.awt.Color(255, 0, 0));
        txtFechaCese.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaCese.setLabelText("Fecha de cese");

        txtMotivo.setBackground(new java.awt.Color(255, 255, 255));
        txtMotivo.setForeground(new java.awt.Color(255, 0, 0));
        txtMotivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMotivo.setLabelText("Motivo");

        mFechaCese.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaCese.setForeground(new java.awt.Color(63, 63, 63));
        mFechaCese.setText("Mensaje de error");

        mMotivoCese.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mMotivoCese.setForeground(new java.awt.Color(63, 63, 63));
        mMotivoCese.setText("Mensaje de error");

        javax.swing.GroupLayout pnlCesamientoTrabajadorLayout = new javax.swing.GroupLayout(pnlCesamientoTrabajador);
        pnlCesamientoTrabajador.setLayout(pnlCesamientoTrabajadorLayout);
        pnlCesamientoTrabajadorLayout.setHorizontalGroup(
            pnlCesamientoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCesamientoTrabajadorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlCesamientoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mMotivoCese, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCesamientoTrabajadorLayout.setVerticalGroup(
            pnlCesamientoTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCesamientoTrabajadorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(txtFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaCese, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mMotivoCese, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundedPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Asignación de trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N

        btnSeleccionarTrabajadorPerfil.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorPerfil.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorPerfil.setText("...");

        txtTrabajadorAsignadoPerfil.setEditable(false);
        txtTrabajadorAsignadoPerfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTrabajadorAsignadoPerfil.setLabelText("Trabajador asignado");

        txtIdTrabajadorPerfil.setForeground(new java.awt.Color(255, 255, 255));

        txtCargoAsignadoPerfil.setEditable(false);
        txtCargoAsignadoPerfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCargoAsignadoPerfil.setLabelText("Cargo ");

        mTrabajadorAsignadoPerfil.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTrabajadorAsignadoPerfil.setForeground(new java.awt.Color(63, 63, 63));
        mTrabajadorAsignadoPerfil.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel7Layout = new javax.swing.GroupLayout(roundedPanel7);
        roundedPanel7.setLayout(roundedPanel7Layout);
        roundedPanel7Layout.setHorizontalGroup(
            roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel7Layout.createSequentialGroup()
                        .addComponent(txtTrabajadorAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(roundedPanel7Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(roundedPanel7Layout.createSequentialGroup()
                        .addGroup(roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mTrabajadorAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCargoAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundedPanel7Layout.setVerticalGroup(
            roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel7Layout.createSequentialGroup()
                .addGroup(roundedPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSeleccionarTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTrabajadorAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargoAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mTrabajadorAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlListaContratosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Lista de perfiles laborales de trabajadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        tblPerfilLaboral.setBackground(new java.awt.Color(255, 251, 235));
        tblPerfilLaboral.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblPerfilLaboral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "TRABAJADOR", "F. INGRESO", "AREA", "F. CESE", "MOTIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPerfilLaboral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblPerfilLaboral.setRowHeight(25);
        tblPerfilLaboral.setShowVerticalLines(false);
        tblPerfilLaboral.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblPerfilLaboral);
        if (tblPerfilLaboral.getColumnModel().getColumnCount() > 0) {
            tblPerfilLaboral.getColumnModel().getColumn(0).setResizable(false);
            tblPerfilLaboral.getColumnModel().getColumn(1).setResizable(false);
            tblPerfilLaboral.getColumnModel().getColumn(2).setResizable(false);
            tblPerfilLaboral.getColumnModel().getColumn(3).setResizable(false);
            tblPerfilLaboral.getColumnModel().getColumn(4).setResizable(false);
            tblPerfilLaboral.getColumnModel().getColumn(5).setResizable(false);
        }

        txtFiltrarTrabajadorPerfil.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltrarTrabajadorPerfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFiltrarTrabajadorPerfil.setLabelText("Filtrar trabajador");

        btnEstadoPerfil.setText("Estado");

        javax.swing.GroupLayout pnlListaContratosUsuarioLayout = new javax.swing.GroupLayout(pnlListaContratosUsuario);
        pnlListaContratosUsuario.setLayout(pnlListaContratosUsuarioLayout);
        pnlListaContratosUsuarioLayout.setHorizontalGroup(
            pnlListaContratosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaContratosUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlListaContratosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlListaContratosUsuarioLayout.createSequentialGroup()
                        .addComponent(txtFiltrarTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnEstadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlListaContratosUsuarioLayout.setVerticalGroup(
            pnlListaContratosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaContratosUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlListaContratosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltrarTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnRegistrarPerfilLaboral.setText("REGISTRAR");

        btnActualizarPerfil.setText("ACTUALIZAR");

        javax.swing.GroupLayout pnlRegistrarPerfilLaboralLayout = new javax.swing.GroupLayout(pnlRegistrarPerfilLaboral);
        pnlRegistrarPerfilLaboral.setLayout(pnlRegistrarPerfilLaboralLayout);
        pnlRegistrarPerfilLaboralLayout.setHorizontalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                        .addComponent(btnRegistrarPerfilLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundedPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCesamientoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(pnlListaContratosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRegistrarPerfilLaboralLayout.setVerticalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlListaContratosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                        .addComponent(roundedPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundedPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCesamientoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarPerfilLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Nuevo Perfil Laboral", pnlRegistrarPerfilLaboral);

        pnlListarPerfilLaboral.setBackground(new java.awt.Color(26, 26, 46));
        pnlListarPerfilLaboral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Relación de contratos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N

        cboFiltrarContratoPor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboFiltrarContratoPor.setLabeText("Filtrar por");

        tblListaContratos.setBackground(new java.awt.Color(255, 255, 255));
        tblListaContratos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblListaContratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "TRABAJADOR", "F. INGRESO", "AREA", "CARGO", "F. CESE", "MOTIVO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaContratos.setRowHeight(25);
        tblListaContratos.setShowVerticalLines(false);
        tblListaContratos.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(tblListaContratos);
        if (tblListaContratos.getColumnModel().getColumnCount() > 0) {
            tblListaContratos.getColumnModel().getColumn(0).setResizable(false);
            tblListaContratos.getColumnModel().getColumn(1).setResizable(false);
            tblListaContratos.getColumnModel().getColumn(2).setResizable(false);
            tblListaContratos.getColumnModel().getColumn(3).setResizable(false);
            tblListaContratos.getColumnModel().getColumn(4).setResizable(false);
            tblListaContratos.getColumnModel().getColumn(5).setResizable(false);
            tblListaContratos.getColumnModel().getColumn(6).setResizable(false);
        }

        txtFiltroContratoLista.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltroContratoLista.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundedPanel16Layout = new javax.swing.GroupLayout(roundedPanel16);
        roundedPanel16.setLayout(roundedPanel16Layout);
        roundedPanel16Layout.setHorizontalGroup(
            roundedPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel16Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundedPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel16Layout.createSequentialGroup()
                        .addComponent(cboFiltrarContratoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtFiltroContratoLista, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        roundedPanel16Layout.setVerticalGroup(
            roundedPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundedPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFiltrarContratoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroContratoLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlListarPerfilLaboralLayout = new javax.swing.GroupLayout(pnlListarPerfilLaboral);
        pnlListarPerfilLaboral.setLayout(pnlListarPerfilLaboralLayout);
        pnlListarPerfilLaboralLayout.setHorizontalGroup(
            pnlListarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarPerfilLaboralLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        pnlListarPerfilLaboralLayout.setVerticalGroup(
            pnlListarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarPerfilLaboralLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Relación de Contratos", pnlListarPerfilLaboral);

        pnlRegistrarLicencia.setBackground(new java.awt.Color(26, 26, 46));
        pnlRegistrarLicencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Detalle de licencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtFechaEmsion.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaEmsion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaEmsion.setLabelText("Fecha de emisión");

        mFechaEmision.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaEmision.setForeground(new java.awt.Color(63, 63, 63));
        mFechaEmision.setText("Mensaje de error");

        mFechaCaducidad.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaCaducidad.setForeground(new java.awt.Color(63, 63, 63));
        mFechaCaducidad.setText("Mensaje de error");

        txtNumLicencia.setBackground(new java.awt.Color(255, 255, 255));
        txtNumLicencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNumLicencia.setLabelText("Número de licencia");

        mNumLicencia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNumLicencia.setForeground(new java.awt.Color(63, 63, 63));
        mNumLicencia.setText("Mensaje de error");

        cboCategoriaLicencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboCategoriaLicencia.setLabeText("Categoría");

        mCategoriaLicencia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mCategoriaLicencia.setForeground(new java.awt.Color(63, 63, 63));
        mCategoriaLicencia.setText("Mensaje de error");

        txtFechaCaducidad.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaCaducidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaCaducidad.setLabelText("Fecha de caducidad");

        txtCodLicencia.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout roundedPanel10Layout = new javax.swing.GroupLayout(roundedPanel10);
        roundedPanel10.setLayout(roundedPanel10Layout);
        roundedPanel10Layout.setHorizontalGroup(
            roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel10Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel10Layout.createSequentialGroup()
                        .addComponent(txtNumLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mNumLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategoriaLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mCategoriaLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaEmsion, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        roundedPanel10Layout.setVerticalGroup(
            roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(roundedPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mNumLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboCategoriaLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mCategoriaLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtFechaEmsion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mFechaCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        roundedPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Asignación de trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N
        roundedPanel8.setPreferredSize(new java.awt.Dimension(385, 155));

        btnSeleccionarTrabajadorLicencia.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorLicencia.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorLicencia.setText("...");

        txtTrabajadorAsignadoLicencia.setEditable(false);
        txtTrabajadorAsignadoLicencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTrabajadorAsignadoLicencia.setLabelText("Trabajador asignado");

        mTrabajadorAsignadoLicencia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTrabajadorAsignadoLicencia.setForeground(new java.awt.Color(63, 63, 63));
        mTrabajadorAsignadoLicencia.setText("Mensaje de error");

        txtIdTrabajadorLicencia.setForeground(new java.awt.Color(255, 255, 255));

        txtCargoAsignadoLicencia.setEditable(false);
        txtCargoAsignadoLicencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCargoAsignadoLicencia.setLabelText("Cargo ");

        javax.swing.GroupLayout roundedPanel8Layout = new javax.swing.GroupLayout(roundedPanel8);
        roundedPanel8.setLayout(roundedPanel8Layout);
        roundedPanel8Layout.setHorizontalGroup(
            roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel8Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196)
                        .addComponent(txtIdTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(roundedPanel8Layout.createSequentialGroup()
                        .addGroup(roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTrabajadorAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCargoAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mTrabajadorAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundedPanel8Layout.setVerticalGroup(
            roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionarTrabajadorLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtIdTrabajadorLicencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTrabajadorAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargoAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mTrabajadorAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundedPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Lista de licencias de conducir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        tblLicencias.setBackground(new java.awt.Color(255, 255, 255));
        tblLicencias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblLicencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "TRABAJADOR", "N° LICENCIA", "CATEGORÍA", "F. EMISIÓN", "F. CADUCIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLicencias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblLicencias.setRowHeight(25);
        tblLicencias.setShowVerticalLines(false);
        jScrollPane7.setViewportView(tblLicencias);
        if (tblLicencias.getColumnModel().getColumnCount() > 0) {
            tblLicencias.getColumnModel().getColumn(0).setResizable(false);
            tblLicencias.getColumnModel().getColumn(1).setResizable(false);
            tblLicencias.getColumnModel().getColumn(2).setResizable(false);
            tblLicencias.getColumnModel().getColumn(3).setResizable(false);
            tblLicencias.getColumnModel().getColumn(4).setResizable(false);
            tblLicencias.getColumnModel().getColumn(5).setResizable(false);
        }

        txtFiltrarTrabajadorLicencia.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltrarTrabajadorLicencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFiltrarTrabajadorLicencia.setLabelText("Filtrar trabajador");

        javax.swing.GroupLayout roundedPanel14Layout = new javax.swing.GroupLayout(roundedPanel14);
        roundedPanel14.setLayout(roundedPanel14Layout);
        roundedPanel14Layout.setHorizontalGroup(
            roundedPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFiltrarTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundedPanel14Layout.setVerticalGroup(
            roundedPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtFiltrarTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnRegistrarLicencia.setBackground(new java.awt.Color(255, 215, 23));
        btnRegistrarLicencia.setText("REGISTRAR");

        btnActualizarLicencia.setText("button1");

        javax.swing.GroupLayout pnlRegistrarLicenciaLayout = new javax.swing.GroupLayout(pnlRegistrarLicencia);
        pnlRegistrarLicencia.setLayout(pnlRegistrarLicenciaLayout);
        pnlRegistrarLicenciaLayout.setHorizontalGroup(
            pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(roundedPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundedPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                        .addComponent(btnRegistrarLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(roundedPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnlRegistrarLicenciaLayout.setVerticalGroup(
            pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                        .addComponent(roundedPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                        .addComponent(roundedPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(roundedPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81))))
        );

        pnlTrabajador.addTab("Nueva Licencia de conducir", pnlRegistrarLicencia);

        pnlListarLicencia.setBackground(new java.awt.Color(26, 26, 46));
        pnlListarLicencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Lista de licencias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N

        tblListaLicencias.setBackground(new java.awt.Color(255, 255, 255));
        tblListaLicencias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblListaLicencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CARGO", "TRABAJADOR", "DNI", "N° LICENCIA", "CATEGORÍA", "F. EMISIÓN", "F. CADUCIDAD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaLicencias.setRowHeight(25);
        tblListaLicencias.setShowVerticalLines(false);
        tblListaLicencias.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(tblListaLicencias);
        if (tblListaLicencias.getColumnModel().getColumnCount() > 0) {
            tblListaLicencias.getColumnModel().getColumn(0).setResizable(false);
            tblListaLicencias.getColumnModel().getColumn(1).setResizable(false);
            tblListaLicencias.getColumnModel().getColumn(2).setResizable(false);
            tblListaLicencias.getColumnModel().getColumn(3).setResizable(false);
            tblListaLicencias.getColumnModel().getColumn(4).setResizable(false);
            tblListaLicencias.getColumnModel().getColumn(5).setResizable(false);
            tblListaLicencias.getColumnModel().getColumn(6).setResizable(false);
        }

        cboFiltrarLicenciaPor.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboFiltrarLicenciaPor.setLabeText("Filtrar por");

        txtFiltroLicenciaLista.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltroLicenciaLista.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundedPanel19Layout = new javax.swing.GroupLayout(roundedPanel19);
        roundedPanel19.setLayout(roundedPanel19Layout);
        roundedPanel19Layout.setHorizontalGroup(
            roundedPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel19Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundedPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel19Layout.createSequentialGroup()
                        .addComponent(cboFiltrarLicenciaPor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtFiltroLicenciaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        roundedPanel19Layout.setVerticalGroup(
            roundedPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel19Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundedPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFiltrarLicenciaPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltroLicenciaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlListarLicenciaLayout = new javax.swing.GroupLayout(pnlListarLicencia);
        pnlListarLicencia.setLayout(pnlListarLicenciaLayout);
        pnlListarLicenciaLayout.setHorizontalGroup(
            pnlListarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarLicenciaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        pnlListarLicenciaLayout.setVerticalGroup(
            pnlListarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarLicenciaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Lista de Licencias ", pnlListarLicencia);

        javax.swing.GroupLayout TRABAJADORESLayout = new javax.swing.GroupLayout(TRABAJADORES);
        TRABAJADORES.setLayout(TRABAJADORESLayout);
        TRABAJADORESLayout.setHorizontalGroup(
            TRABAJADORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRABAJADORESLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 1572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        TRABAJADORESLayout.setVerticalGroup(
            TRABAJADORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TRABAJADORESLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlOpciones.addTab("tab2", TRABAJADORES);

        GUARDIAS.setBackground(new java.awt.Color(18, 18, 18));
        GUARDIAS.setForeground(new java.awt.Color(255, 255, 255));

        pnlGuardia.setForeground(new java.awt.Color(255, 255, 255));

        pnlRegistrarGuardia.setBackground(new java.awt.Color(26, 26, 46));
        pnlRegistrarGuardia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de guardia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtNombreGuardia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreGuardia.setLabelText("Nombre de Guardia");

        txtTurno.setEditable(false);
        txtTurno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTurno.setLabelText("Turno");

        mNombreGuardia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombreGuardia.setForeground(new java.awt.Color(63, 63, 63));
        mNombreGuardia.setText("Mensaje de error");

        txtCodGuardia.setForeground(new java.awt.Color(255, 255, 255));

        txtCodTurno.setForeground(new java.awt.Color(255, 255, 255));

        txtHoraEntrada.setEditable(false);
        txtHoraEntrada.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtHoraEntrada.setLabelText("Hora de entrada");

        mTurno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTurno.setForeground(new java.awt.Color(63, 63, 63));
        mTurno.setText("Mensaje de error");

        txtHoraSalida.setEditable(false);
        txtHoraSalida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtHoraSalida.setLabelText("Hora de salida");

        javax.swing.GroupLayout roundedPanel17Layout = new javax.swing.GroupLayout(roundedPanel17);
        roundedPanel17.setLayout(roundedPanel17Layout);
        roundedPanel17Layout.setHorizontalGroup(
            roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel17Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel17Layout.createSequentialGroup()
                        .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mNombreGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel17Layout.createSequentialGroup()
                        .addComponent(txtNombreGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        roundedPanel17Layout.setVerticalGroup(
            roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel17Layout.createSequentialGroup()
                .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel17Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtNombreGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel17Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtCodGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(mNombreGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tblGuardias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblGuardias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "COD", "GUARDIA", "TURNO", "H. ENTRADA", "H. SALIDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGuardias.setRowHeight(25);
        tblGuardias.setShowVerticalLines(false);
        tblGuardias.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(tblGuardias);
        if (tblGuardias.getColumnModel().getColumnCount() > 0) {
            tblGuardias.getColumnModel().getColumn(0).setResizable(false);
            tblGuardias.getColumnModel().getColumn(1).setResizable(false);
            tblGuardias.getColumnModel().getColumn(2).setResizable(false);
            tblGuardias.getColumnModel().getColumn(3).setResizable(false);
            tblGuardias.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout roundedPanel11Layout = new javax.swing.GroupLayout(roundedPanel11);
        roundedPanel11.setLayout(roundedPanel11Layout);
        roundedPanel11Layout.setHorizontalGroup(
            roundedPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel11Layout.setVerticalGroup(
            roundedPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel11Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel6.setBackground(new java.awt.Color(26, 26, 46));

        btnRegistrarGuardia.setBackground(new java.awt.Color(255, 215, 23));
        btnRegistrarGuardia.setText("REGISTRAR");

        roundedPanel18.setBackground(new java.awt.Color(204, 204, 204));
        roundedPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selector de turno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        tblTurnos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "COD", "TURNO", "ENTRADA", "SALIDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTurnos.setRowHeight(25);
        tblTurnos.setShowVerticalLines(false);
        tblTurnos.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(tblTurnos);
        if (tblTurnos.getColumnModel().getColumnCount() > 0) {
            tblTurnos.getColumnModel().getColumn(0).setResizable(false);
            tblTurnos.getColumnModel().getColumn(1).setResizable(false);
            tblTurnos.getColumnModel().getColumn(2).setResizable(false);
            tblTurnos.getColumnModel().getColumn(3).setResizable(false);
        }

        btnSeleccionarTurno.setText("SELECCIONAR");

        javax.swing.GroupLayout roundedPanel18Layout = new javax.swing.GroupLayout(roundedPanel18);
        roundedPanel18.setLayout(roundedPanel18Layout);
        roundedPanel18Layout.setHorizontalGroup(
            roundedPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel18Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(roundedPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel18Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnSeleccionarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        roundedPanel18Layout.setVerticalGroup(
            roundedPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel18Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(roundedPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnRegistrarGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(roundedPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnRegistrarGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(0, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout pnlRegistrarGuardiaLayout = new javax.swing.GroupLayout(pnlRegistrarGuardia);
        pnlRegistrarGuardia.setLayout(pnlRegistrarGuardiaLayout);
        pnlRegistrarGuardiaLayout.setHorizontalGroup(
            pnlRegistrarGuardiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarGuardiaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlRegistrarGuardiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundedPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegistrarGuardiaLayout.createSequentialGroup()
                        .addComponent(roundedPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegistrarGuardiaLayout.setVerticalGroup(
            pnlRegistrarGuardiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarGuardiaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlRegistrarGuardiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(pnlRegistrarGuardiaLayout.createSequentialGroup()
                        .addGroup(pnlRegistrarGuardiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundedPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(74, 74, 74)
                        .addComponent(roundedPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGuardia.addTab("Nueva Guardia", pnlRegistrarGuardia);

        pnlRegistrarAsistencia.setBackground(new java.awt.Color(26, 26, 46));

        roundedPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Control de asistencia del personal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtFechaReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaReparto.setLabelText("Fecha de asistencia");

        mFechaAsistencia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaAsistencia.setForeground(new java.awt.Color(63, 63, 63));
        mFechaAsistencia.setText("Mensaje de error");

        roundedPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Selector de trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        btnSeleccionarTrabajadorReparto.setBackground(new java.awt.Color(102, 102, 102));
        btnSeleccionarTrabajadorReparto.setText("...");
        btnSeleccionarTrabajadorReparto.setToolTipText("");

        txtTrabajadorAsignadoReparto.setEditable(false);
        txtTrabajadorAsignadoReparto.setForeground(new java.awt.Color(0, 0, 0));
        txtTrabajadorAsignadoReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTrabajadorAsignadoReparto.setLabelText("Trabajador");

        mTrabajadorAsignadoReparto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTrabajadorAsignadoReparto.setForeground(new java.awt.Color(63, 63, 63));
        mTrabajadorAsignadoReparto.setText("Mensaje de error");

        txtCargoSeleccionadoReparto.setEditable(false);
        txtCargoSeleccionadoReparto.setForeground(new java.awt.Color(0, 0, 0));
        txtCargoSeleccionadoReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCargoSeleccionadoReparto.setLabelText("Cargo");

        javax.swing.GroupLayout roundedPanel27Layout = new javax.swing.GroupLayout(roundedPanel27);
        roundedPanel27.setLayout(roundedPanel27Layout);
        roundedPanel27Layout.setHorizontalGroup(
            roundedPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel27Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundedPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel27Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarTrabajadorReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(txtIdTrabajadorReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mTrabajadorAsignadoReparto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addComponent(txtCargoSeleccionadoReparto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTrabajadorAsignadoReparto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        roundedPanel27Layout.setVerticalGroup(
            roundedPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleccionarTrabajadorReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdTrabajadorReparto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTrabajadorAsignadoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargoSeleccionadoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mTrabajadorAsignadoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundedPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Selector de guardia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        btnSeleccionarGuardiaReparto.setBackground(new java.awt.Color(102, 102, 102));
        btnSeleccionarGuardiaReparto.setText("...");

        txtGuardiaSeleccionadaReparto.setEditable(false);
        txtGuardiaSeleccionadaReparto.setForeground(new java.awt.Color(0, 0, 0));
        txtGuardiaSeleccionadaReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtGuardiaSeleccionadaReparto.setLabelText("Guardia");

        txtTurnoSeleccionadoReparto.setEditable(false);
        txtTurnoSeleccionadoReparto.setForeground(new java.awt.Color(0, 0, 0));
        txtTurnoSeleccionadoReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTurnoSeleccionadoReparto.setLabelText("Turno");

        mGuardiaSeleccionadaReparto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mGuardiaSeleccionadaReparto.setForeground(new java.awt.Color(63, 63, 63));
        mGuardiaSeleccionadaReparto.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel29Layout = new javax.swing.GroupLayout(roundedPanel29);
        roundedPanel29.setLayout(roundedPanel29Layout);
        roundedPanel29Layout.setHorizontalGroup(
            roundedPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel29Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundedPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel29Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarGuardiaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodGuardiaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundedPanel29Layout.createSequentialGroup()
                        .addGroup(roundedPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTurnoSeleccionadoReparto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGuardiaSeleccionadaReparto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mGuardiaSeleccionadaReparto, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        roundedPanel29Layout.setVerticalGroup(
            roundedPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionarGuardiaReparto, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtCodGuardiaReparto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtGuardiaSeleccionadaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTurnoSeleccionadoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mGuardiaSeleccionadaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        roundedPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Selector de vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        btnSeleccionarVehiculoReparto.setBackground(new java.awt.Color(102, 102, 102));
        btnSeleccionarVehiculoReparto.setText("...");

        txtVehiculoSeleccionadoReparto.setEditable(false);
        txtVehiculoSeleccionadoReparto.setForeground(new java.awt.Color(0, 0, 0));
        txtVehiculoSeleccionadoReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtVehiculoSeleccionadoReparto.setLabelText("Vehículo");

        txtTipoSeleccionadoReparto.setEditable(false);
        txtTipoSeleccionadoReparto.setForeground(new java.awt.Color(0, 0, 0));
        txtTipoSeleccionadoReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTipoSeleccionadoReparto.setLabelText("Tipo");

        mVehiculoSeleccionadoReparto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mVehiculoSeleccionadoReparto.setForeground(new java.awt.Color(63, 63, 63));
        mVehiculoSeleccionadoReparto.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel30Layout = new javax.swing.GroupLayout(roundedPanel30);
        roundedPanel30.setLayout(roundedPanel30Layout);
        roundedPanel30Layout.setHorizontalGroup(
            roundedPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel30Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundedPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundedPanel30Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarVehiculoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodVehiculoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mVehiculoSeleccionadoReparto, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(txtVehiculoSeleccionadoReparto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTipoSeleccionadoReparto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        roundedPanel30Layout.setVerticalGroup(
            roundedPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleccionarVehiculoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodVehiculoReparto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtVehiculoSeleccionadoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipoSeleccionadoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mVehiculoSeleccionadoReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblEstadoCivil1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblEstadoCivil1.setForeground(new java.awt.Color(153, 153, 153));
        lblEstadoCivil1.setText("Asistencia");

        Asistencia.add(opSi);
        opSi.setText("Si");
        opSi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        opNo.setBackground(new java.awt.Color(255, 0, 0));
        Asistencia.add(opNo);
        opNo.setForeground(new java.awt.Color(255, 0, 0));
        opNo.setText("No");
        opNo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundedPanel22Layout = new javax.swing.GroupLayout(roundedPanel22);
        roundedPanel22.setLayout(roundedPanel22Layout);
        roundedPanel22Layout.setHorizontalGroup(
            roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel22Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(roundedPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel22Layout.createSequentialGroup()
                        .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mFechaAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(roundedPanel22Layout.createSequentialGroup()
                        .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundedPanel22Layout.createSequentialGroup()
                                .addComponent(opSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(opNo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundedPanel22Layout.createSequentialGroup()
                                .addComponent(lblEstadoCivil1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        roundedPanel22Layout.setVerticalGroup(
            roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel22Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txtFechaReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mFechaAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoCivil1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(roundedPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roundedPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundedPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblRepartoA.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblRepartoA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TRABAJADOR", "VEHICULO", "ASISTENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRepartoA.setRowHeight(25);
        tblRepartoA.setShowVerticalLines(false);
        tblRepartoA.getTableHeader().setReorderingAllowed(false);
        jScrollPane16.setViewportView(tblRepartoA);
        if (tblRepartoA.getColumnModel().getColumnCount() > 0) {
            tblRepartoA.getColumnModel().getColumn(0).setResizable(false);
            tblRepartoA.getColumnModel().getColumn(1).setResizable(false);
            tblRepartoA.getColumnModel().getColumn(2).setResizable(false);
            tblRepartoA.getColumnModel().getColumn(3).setResizable(false);
            tblRepartoA.getColumnModel().getColumn(4).setResizable(false);
        }

        tblRepartoB.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblRepartoB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TRABAJADOR", "VEHICULO", "ASISTENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRepartoB.setRowHeight(25);
        tblRepartoB.setShowVerticalLines(false);
        tblRepartoB.getTableHeader().setReorderingAllowed(false);
        jScrollPane19.setViewportView(tblRepartoB);
        if (tblRepartoB.getColumnModel().getColumnCount() > 0) {
            tblRepartoB.getColumnModel().getColumn(0).setResizable(false);
            tblRepartoB.getColumnModel().getColumn(1).setResizable(false);
            tblRepartoB.getColumnModel().getColumn(2).setResizable(false);
            tblRepartoB.getColumnModel().getColumn(3).setResizable(false);
            tblRepartoB.getColumnModel().getColumn(4).setResizable(false);
        }

        tblRepartoC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblRepartoC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "TRABAJADOR", "VEHICULO", "ASISTENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRepartoC.setRowHeight(25);
        tblRepartoC.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tblRepartoC.setShowVerticalLines(false);
        tblRepartoC.getTableHeader().setReorderingAllowed(false);
        jScrollPane20.setViewportView(tblRepartoC);
        if (tblRepartoC.getColumnModel().getColumnCount() > 0) {
            tblRepartoC.getColumnModel().getColumn(0).setResizable(false);
            tblRepartoC.getColumnModel().getColumn(1).setResizable(false);
            tblRepartoC.getColumnModel().getColumn(2).setResizable(false);
            tblRepartoC.getColumnModel().getColumn(3).setResizable(false);
            tblRepartoC.getColumnModel().getColumn(4).setResizable(false);
        }

        txtFiltrarTrabajadorReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFiltrarTrabajadorReparto.setLabelText("Filtrar trabajador");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GUARDIA A");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("GUARDIA B");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GUARDIA C");

        javax.swing.GroupLayout roundedPanel28Layout = new javax.swing.GroupLayout(roundedPanel28);
        roundedPanel28.setLayout(roundedPanel28Layout);
        roundedPanel28Layout.setHorizontalGroup(
            roundedPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel28Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(roundedPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel28Layout.createSequentialGroup()
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(roundedPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(roundedPanel28Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtFiltrarTrabajadorReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel28Layout.setVerticalGroup(
            roundedPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel28Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtFiltrarTrabajadorReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundedPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        btnRegistrarReparto.setText("REGISTRAR");

        button2.setText("button2");

        javax.swing.GroupLayout pnlRegistrarAsistenciaLayout = new javax.swing.GroupLayout(pnlRegistrarAsistencia);
        pnlRegistrarAsistencia.setLayout(pnlRegistrarAsistenciaLayout);
        pnlRegistrarAsistenciaLayout.setHorizontalGroup(
            pnlRegistrarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarAsistenciaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlRegistrarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistrarAsistenciaLayout.createSequentialGroup()
                        .addComponent(roundedPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(pnlRegistrarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrarReparto, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlRegistrarAsistenciaLayout.setVerticalGroup(
            pnlRegistrarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarAsistenciaLayout.createSequentialGroup()
                .addGroup(pnlRegistrarAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarAsistenciaLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnRegistrarReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegistrarAsistenciaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(roundedPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(roundedPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGuardia.addTab("Asistencia guardias", pnlRegistrarAsistencia);

        pnlListarAsistencias.setBackground(new java.awt.Color(26, 26, 46));

        tblListaRepartoA.setBackground(new java.awt.Color(255, 255, 255));
        tblListaRepartoA.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblListaRepartoA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FECHA", "TRABAJADOR", "VEHICULO", "ASISTENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaRepartoA.setRowHeight(25);
        tblListaRepartoA.setShowVerticalLines(false);
        tblListaRepartoA.getTableHeader().setReorderingAllowed(false);
        jScrollPane17.setViewportView(tblListaRepartoA);
        if (tblListaRepartoA.getColumnModel().getColumnCount() > 0) {
            tblListaRepartoA.getColumnModel().getColumn(0).setResizable(false);
            tblListaRepartoA.getColumnModel().getColumn(1).setResizable(false);
            tblListaRepartoA.getColumnModel().getColumn(2).setResizable(false);
            tblListaRepartoA.getColumnModel().getColumn(3).setResizable(false);
        }

        tblListaRepartoB.setBackground(new java.awt.Color(255, 255, 255));
        tblListaRepartoB.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblListaRepartoB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FECHA", "TRABAJADOR", "VEHICULO", "ASISTENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaRepartoB.setRowHeight(25);
        tblListaRepartoB.setShowVerticalLines(false);
        tblListaRepartoB.getTableHeader().setReorderingAllowed(false);
        jScrollPane21.setViewportView(tblListaRepartoB);
        if (tblListaRepartoB.getColumnModel().getColumnCount() > 0) {
            tblListaRepartoB.getColumnModel().getColumn(0).setResizable(false);
            tblListaRepartoB.getColumnModel().getColumn(1).setResizable(false);
            tblListaRepartoB.getColumnModel().getColumn(2).setResizable(false);
            tblListaRepartoB.getColumnModel().getColumn(3).setResizable(false);
        }

        tblListaRepartoC.setBackground(new java.awt.Color(255, 255, 255));
        tblListaRepartoC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblListaRepartoC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "FECHA", "TRABAJADOR", "VEHICULO", "ASISTENCIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListaRepartoC.setRowHeight(25);
        tblListaRepartoC.setSelectionBackground(new java.awt.Color(255, 255, 0));
        tblListaRepartoC.setShowVerticalLines(false);
        tblListaRepartoC.getTableHeader().setReorderingAllowed(false);
        jScrollPane22.setViewportView(tblListaRepartoC);
        if (tblListaRepartoC.getColumnModel().getColumnCount() > 0) {
            tblListaRepartoC.getColumnModel().getColumn(0).setResizable(false);
            tblListaRepartoC.getColumnModel().getColumn(1).setResizable(false);
            tblListaRepartoC.getColumnModel().getColumn(2).setResizable(false);
            tblListaRepartoC.getColumnModel().getColumn(3).setResizable(false);
        }

        txtBusquedaNombreAsistencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBusquedaNombreAsistencia.setLabelText("Filtrar por trabajador");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GUARDIA A");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GUARDIA B");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("GUARDIA C");

        txtFechaFiltroReparto.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaFiltroReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaFiltroReparto.setLabelText("Filtrar por fecha");

        btnBuscarAsistencia.setBackground(new java.awt.Color(0, 51, 204));
        btnBuscarAsistencia.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarAsistencia.setText("BUSCAR");

        btnCancelarBusqueda.setText("CANCELAR");

        javax.swing.GroupLayout roundedPanel31Layout = new javax.swing.GroupLayout(roundedPanel31);
        roundedPanel31.setLayout(roundedPanel31Layout);
        roundedPanel31Layout.setHorizontalGroup(
            roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel31Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel31Layout.createSequentialGroup()
                        .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane22))
                        .addGap(25, 25, 25))
                    .addGroup(roundedPanel31Layout.createSequentialGroup()
                        .addComponent(txtFechaFiltroReparto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusquedaNombreAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnBuscarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(818, 818, 818))))
        );
        roundedPanel31Layout.setVerticalGroup(
            roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel31Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelarBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBusquedaNombreAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFechaFiltroReparto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane17)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addComponent(jScrollPane22))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlListarAsistenciasLayout = new javax.swing.GroupLayout(pnlListarAsistencias);
        pnlListarAsistencias.setLayout(pnlListarAsistenciasLayout);
        pnlListarAsistenciasLayout.setHorizontalGroup(
            pnlListarAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarAsistenciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlListarAsistenciasLayout.setVerticalGroup(
            pnlListarAsistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarAsistenciasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlGuardia.addTab("Control de asistencias", pnlListarAsistencias);

        javax.swing.GroupLayout GUARDIASLayout = new javax.swing.GroupLayout(GUARDIAS);
        GUARDIAS.setLayout(GUARDIASLayout);
        GUARDIASLayout.setHorizontalGroup(
            GUARDIASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUARDIASLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 1571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        GUARDIASLayout.setVerticalGroup(
            GUARDIASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUARDIASLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab3", GUARDIAS);

        EQUIPOS.setBackground(new java.awt.Color(18, 18, 18));

        tabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        tabbedPane1.setFocusable(false);

        jPanel2.setBackground(new java.awt.Color(26, 26, 46));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlInformacionVehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de nuevo vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        txtIdVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        txtIdVehiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtIdVehiculo.setLabelText("ID");

        txtPlaca.setBackground(new java.awt.Color(255, 255, 255));
        txtPlaca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPlaca.setLabelText("Placa");

        txtModelo.setBackground(new java.awt.Color(255, 255, 255));
        txtModelo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtModelo.setLabelText("Modelo");

        mIdVehiculo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mIdVehiculo.setForeground(new java.awt.Color(63, 63, 63));
        mIdVehiculo.setText("Mensaje de error");

        mPlaca.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mPlaca.setForeground(new java.awt.Color(63, 63, 63));
        mPlaca.setText("Mensaje de error");

        cboMarcaVehiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cboMarcaVehiculo.setLabeText("Marca de vehículo");

        txtFechaCompra.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaCompra.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaCompra.setLabelText("Fecha Compra");

        txtAño.setBackground(new java.awt.Color(255, 255, 255));
        txtAño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAño.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAño.setLabelText("Año de fabricación");

        mFechaCompra.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaCompra.setForeground(new java.awt.Color(63, 63, 63));
        mFechaCompra.setText("Mensaje de error");

        txtTipoVehiculoAsignado.setEditable(false);
        txtTipoVehiculoAsignado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTipoVehiculoAsignado.setLabelText("Tipo de vehículo");

        mMarca.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mMarca.setForeground(new java.awt.Color(63, 63, 63));
        mMarca.setText("Mensaje de error");

        mModelo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mModelo.setForeground(new java.awt.Color(63, 63, 63));
        mModelo.setText("Mensaje de error");

        mAño.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mAño.setForeground(new java.awt.Color(63, 63, 63));
        mAño.setText("Mensaje de error");

        mTipoVehiculoAsignado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTipoVehiculoAsignado.setForeground(new java.awt.Color(63, 63, 63));
        mTipoVehiculoAsignado.setText("Mensaje de error");

        javax.swing.GroupLayout pnlInformacionVehiculoLayout = new javax.swing.GroupLayout(pnlInformacionVehiculo);
        pnlInformacionVehiculo.setLayout(pnlInformacionVehiculoLayout);
        pnlInformacionVehiculoLayout.setHorizontalGroup(
            pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionVehiculoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mTipoVehiculoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInformacionVehiculoLayout.createSequentialGroup()
                        .addComponent(txtTipoVehiculoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(txtCodTipoVehiculoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInformacionVehiculoLayout.createSequentialGroup()
                        .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboMarcaVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mIdVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))))
                        .addGap(38, 38, 38)
                        .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(mPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(mFechaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlInformacionVehiculoLayout.setVerticalGroup(
            pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionVehiculoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mIdVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMarcaVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mAño, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlInformacionVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoVehiculoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodTipoVehiculoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mTipoVehiculoAsignado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlTipoVehiculo1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tipo de vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N

        txtTipoVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        txtTipoVehiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTipoVehiculo.setLabelText("Tipo de vehículo");

        mTipoVehiculo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTipoVehiculo.setForeground(new java.awt.Color(63, 63, 63));
        mTipoVehiculo.setText("Mensaje de error");

        tblTipoVehiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblTipoVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "COD", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTipoVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTipoVehiculo.setRowHeight(25);
        tblTipoVehiculo.setShowVerticalLines(false);
        tblTipoVehiculo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTipoVehiculo);
        if (tblTipoVehiculo.getColumnModel().getColumnCount() > 0) {
            tblTipoVehiculo.getColumnModel().getColumn(0).setResizable(false);
            tblTipoVehiculo.getColumnModel().getColumn(1).setResizable(false);
        }

        btnRegistrarTipoVehiculo.setText("REGISTRAR");

        txtFiltroTipoVehiculo.setBackground(new java.awt.Color(255, 255, 255));
        txtFiltroTipoVehiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFiltroTipoVehiculo.setLabelText("Filtrar por tipo");

        txtCodTipoVehiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodTipoVehiculo.setToolTipText("");

        btnSeleccionarTipoVehiculo.setText("SELECCIONAR");

        javax.swing.GroupLayout pnlTipoVehiculo1Layout = new javax.swing.GroupLayout(pnlTipoVehiculo1);
        pnlTipoVehiculo1.setLayout(pnlTipoVehiculo1Layout);
        pnlTipoVehiculo1Layout.setHorizontalGroup(
            pnlTipoVehiculo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoVehiculo1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlTipoVehiculo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTipoVehiculo1Layout.createSequentialGroup()
                        .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrarTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTipoVehiculo1Layout.createSequentialGroup()
                        .addComponent(txtFiltroTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnSeleccionarTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        pnlTipoVehiculo1Layout.setVerticalGroup(
            pnlTipoVehiculo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoVehiculo1Layout.createSequentialGroup()
                .addGroup(pnlTipoVehiculo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTipoVehiculo1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTipoVehiculo1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlTipoVehiculo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(mTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTipoVehiculo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        tblVehiculos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "ID", "TIPO", "PLACA", "MARCA", "MODELO", "F. COMPRA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblVehiculos.setRowHeight(25);
        tblVehiculos.setShowVerticalLines(false);
        tblVehiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tblVehiculos);
        if (tblVehiculos.getColumnModel().getColumnCount() > 0) {
            tblVehiculos.getColumnModel().getColumn(0).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(1).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(2).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(3).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(4).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(5).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout roundedPanel15Layout = new javax.swing.GroupLayout(roundedPanel15);
        roundedPanel15.setLayout(roundedPanel15Layout);
        roundedPanel15Layout.setHorizontalGroup(
            roundedPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel15Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        roundedPanel15Layout.setVerticalGroup(
            roundedPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel15Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnRegistrarVehiculo.setBackground(new java.awt.Color(255, 215, 23));
        btnRegistrarVehiculo.setText("REGISTRAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pnlTipoVehiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(pnlInformacionVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pnlInformacionVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTipoVehiculo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnRegistrarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(roundedPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("Nuevo Vehículo", jPanel2);

        jPanel4.setBackground(new java.awt.Color(26, 26, 46));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de vale de combustible", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(70, 88, 129))); // NOI18N
        roundedPanel2.setForeground(new java.awt.Color(51, 51, 51));

        txtCodVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodVale.setLabelText("Código de vale");

        mCodVale.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mCodVale.setForeground(new java.awt.Color(63, 63, 63));
        mCodVale.setText("Mensaje de error");

        txtHoraAbastecimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHoraAbastecimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtHoraAbastecimiento.setLabelText("Hora abastecimiento");

        txtLugar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtLugar.setLabelText("Lugar de abastecimiento");

        txtIdVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtHorometroVale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHorometroVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtHorometroVale.setLabelText("Horómetro");

        txtGalonesVale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGalonesVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtGalonesVale.setLabelText("Cant. Galones");

        mHoraAbastecimiento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mHoraAbastecimiento.setForeground(new java.awt.Color(63, 63, 63));
        mHoraAbastecimiento.setText("Mensaje de error");

        mLugar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mLugar.setForeground(new java.awt.Color(63, 63, 63));
        mLugar.setText("Mensaje de error");

        mHorometroVale.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mHorometroVale.setForeground(new java.awt.Color(63, 63, 63));
        mHorometroVale.setText("Mensaje de error");

        mGalones.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mGalones.setForeground(new java.awt.Color(63, 63, 63));
        mGalones.setText("Mensaje de error");

        btnSeleccionarRepartoVale.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarRepartoVale.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarRepartoVale.setText("...");

        txtCodRepartoVale.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mHorometroVale, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHorometroVale, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addComponent(txtGalonesVale, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnSeleccionarRepartoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtCodRepartoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mGalones, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addComponent(txtCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdVale, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdVale, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(mCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addComponent(txtHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(mHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(mLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHorometroVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGalonesVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeleccionarRepartoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtCodRepartoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mHorometroVale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mGalones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblVale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "FECHA", "GUARDIA", "TURNO", "VALE", "TRABAJADOR", "EQUIPO", "HORÓMETRO", "GALONES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVale.setRowHeight(25);
        tblVale.setShowVerticalLines(false);
        tblVale.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(tblVale);
        if (tblVale.getColumnModel().getColumnCount() > 0) {
            tblVale.getColumnModel().getColumn(0).setResizable(false);
            tblVale.getColumnModel().getColumn(1).setResizable(false);
            tblVale.getColumnModel().getColumn(3).setResizable(false);
            tblVale.getColumnModel().getColumn(4).setResizable(false);
            tblVale.getColumnModel().getColumn(5).setResizable(false);
            tblVale.getColumnModel().getColumn(6).setResizable(false);
            tblVale.getColumnModel().getColumn(7).setResizable(false);
            tblVale.getColumnModel().getColumn(8).setResizable(false);
        }

        javax.swing.GroupLayout roundedPanel20Layout = new javax.swing.GroupLayout(roundedPanel20);
        roundedPanel20.setLayout(roundedPanel20Layout);
        roundedPanel20Layout.setHorizontalGroup(
            roundedPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel20Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        roundedPanel20Layout.setVerticalGroup(
            roundedPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel20Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        roundedPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selector de trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtTrabajadorAsignadoVale.setEditable(false);
        txtTrabajadorAsignadoVale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTrabajadorAsignadoVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTrabajadorAsignadoVale.setLabelText("Trabajador seleccionado");

        textField2.setEditable(false);
        textField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textField2.setLabelText("Guardia");

        txtTurnoVale.setEditable(false);
        txtTurnoVale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTurnoVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        textField4.setEditable(false);
        textField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        textField5.setEditable(false);
        textField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout roundedPanel21Layout = new javax.swing.GroupLayout(roundedPanel21);
        roundedPanel21.setLayout(roundedPanel21Layout);
        roundedPanel21Layout.setHorizontalGroup(
            roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel21Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTrabajadorAsignadoVale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundedPanel21Layout.createSequentialGroup()
                        .addGroup(roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(textField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTurnoVale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField5, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        roundedPanel21Layout.setVerticalGroup(
            roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel21Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtTrabajadorAsignadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTurnoVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnActualizarVale.setBackground(new java.awt.Color(255, 215, 23));
        btnActualizarVale.setText("ACTUALIZAR");

        btnRegistrarVale.setBackground(new java.awt.Color(255, 215, 23));
        btnRegistrarVale.setText("REGISTRAR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundedPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnRegistrarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnActualizarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundedPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addComponent(roundedPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("Consumo de combustible", jPanel4);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tabbedPane1.addTab("tab3", jPanel9);

        javax.swing.GroupLayout EQUIPOSLayout = new javax.swing.GroupLayout(EQUIPOS);
        EQUIPOS.setLayout(EQUIPOSLayout);
        EQUIPOSLayout.setHorizontalGroup(
            EQUIPOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EQUIPOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        EQUIPOSLayout.setVerticalGroup(
            EQUIPOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EQUIPOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpciones.addTab("tab4", EQUIPOS);

        javax.swing.GroupLayout panelNuevoLayout = new javax.swing.GroupLayout(panelNuevo);
        panelNuevo.setLayout(panelNuevoLayout);
        panelNuevoLayout.setHorizontalGroup(
            panelNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1608, Short.MAX_VALUE)
        );
        panelNuevoLayout.setVerticalGroup(
            panelNuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 894, Short.MAX_VALUE)
        );

        pnlOpciones.addTab("tab5", panelNuevo);

        pnlBackground.add(pnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 1610, 940));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String args[]) {
//
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        java.awt.EventQueue.invokeLater(() -> {
//            new FrmMenu().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup AreaPerfil;
    public javax.swing.ButtonGroup Asistencia;
    public javax.swing.ButtonGroup CategoriaCargo;
    public javax.swing.JPanel EQUIPOS;
    public javax.swing.ButtonGroup EstadoCivil;
    public javax.swing.JPanel GUARDIAS;
    public javax.swing.ButtonGroup Genero;
    public javax.swing.ButtonGroup GradoIntruccion;
    public javax.swing.JPanel INICIO;
    public javax.swing.JMenuItem JCesarTrabajador;
    public javax.swing.JMenuItem JReingresarTrabajador;
    public javax.swing.JPanel TRABAJADORES;
    public gamm_Button.Button btnActualizarCargo;
    public gamm_Button.Button btnActualizarLicencia;
    public gamm_Button.Button btnActualizarPerfil;
    public gamm_Button.Button btnActualizarTrabajador;
    public gamm_Button.Button btnActualizarVale;
    public gamm_Button.Button btnBuscarAsistencia;
    public gamm_Button.Button btnCancelarBusqueda;
    public gamm_Button.Button btnCancelarCargo;
    public gamm_Button.Button btnCancelarEmpresa;
    public gamm_Button.Button btnEstadoPerfil;
    public gamm_Button.Button btnHabilitar;
    public gamm_Button.Button btnModificarEmpresa;
    public gamm_Button.Button btnRegistrarCargo;
    public gamm_Button.Button btnRegistrarGuardia;
    public gamm_Button.Button btnRegistrarLicencia;
    public gamm_Button.Button btnRegistrarPerfilLaboral;
    public gamm_Button.Button btnRegistrarReparto;
    public gamm_Button.Button btnRegistrarTipoVehiculo;
    public gamm_Button.Button btnRegistrarTrabajador;
    public gamm_Button.Button btnRegistrarVale;
    public gamm_Button.Button btnRegistrarVehiculo;
    public gamm_Button.ButtonLine btnSeleccionarCargo;
    public gamm_Button.ButtonLine btnSeleccionarGuardiaReparto;
    public gamm_Button.ButtonLine btnSeleccionarLogo;
    public gamm_Button.ButtonLine btnSeleccionarRepartoVale;
    public gamm_Button.Button btnSeleccionarTipoVehiculo;
    public gamm_Button.ButtonLine btnSeleccionarTrabajadorLicencia;
    public gamm_Button.ButtonLine btnSeleccionarTrabajadorPerfil;
    public gamm_Button.ButtonLine btnSeleccionarTrabajadorReparto;
    public gamm_Button.Button btnSeleccionarTurno;
    public gamm_Button.ButtonLine btnSeleccionarVehiculoReparto;
    private gamm_Button.Button button2;
    public gamm_ComboBox.Combobox cboArea;
    public gamm_ComboBox.Combobox cboCategoriaLicencia;
    public gamm_ComboBox.Combobox cboFiltrarContratoPor;
    public gamm_ComboBox.Combobox cboFiltrarLicenciaPor;
    public gamm_ComboBox.Combobox cboFiltrarTrabajadorPor;
    public gamm_ComboBox.Combobox cboMarcaVehiculo;
    public gamm_CheckBox.CheckBox ckbAgregarCelular;
    public gamm_DateChooser.DateChooser fechaAsistencia;
    public gamm_DateChooser.DateChooser fechaCaducidad;
    public gamm_DateChooser.DateChooser fechaCese;
    public gamm_DateChooser.DateChooser fechaCompra;
    public gamm_DateChooser.DateChooser fechaEmision;
    public gamm_DateChooser.DateChooser fechaFiltroReparto;
    public gamm_DateChooser.DateChooser fechaIngreso;
    public gamm_DateChooser.DateChooser fechaNacimiento;
    public gamm_Panel.MenuItem itemCargos4;
    public gamm_Panel.MenuItem itemEquipos;
    public gamm_Panel.MenuItem itemGuardias;
    public gamm_Panel.MenuItem itemInicio;
    public gamm_Panel.MenuItem itemMaquinaria;
    public gamm_Panel.MenuItem itemTrabajadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCategoria;
    public javax.swing.JLabel lblEquipos;
    public javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblEstadoCivil1;
    public gamm_LavelAvatar.LabelAvatar lblFoto;
    public javax.swing.JLabel lblFotoTrabajador;
    private javax.swing.JLabel lblGenero;
    public javax.swing.JLabel lblGuardias;
    public javax.swing.JLabel lblInicio;
    public javax.swing.JLabel lblLogoEmpresaDatos;
    public javax.swing.JLabel lblLogoUpdate;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblRol;
    public javax.swing.JLabel lblTrabajadores;
    public javax.swing.JLabel mApeMaterno;
    public javax.swing.JLabel mApePaterno;
    public javax.swing.JLabel mArea;
    public javax.swing.JLabel mAño;
    public javax.swing.JLabel mCargoAsignado;
    public javax.swing.JLabel mCategoriaCargo;
    public javax.swing.JLabel mCategoriaLicencia;
    public javax.swing.JLabel mCodVale;
    public javax.swing.JLabel mDireccion;
    public javax.swing.JLabel mDni;
    public javax.swing.JLabel mEstadoCivil;
    public javax.swing.JLabel mFechaAsistencia;
    public javax.swing.JLabel mFechaCaducidad;
    public javax.swing.JLabel mFechaCese;
    public javax.swing.JLabel mFechaCompra;
    public javax.swing.JLabel mFechaEmision;
    public javax.swing.JLabel mFechaIngreso;
    public javax.swing.JLabel mFechaNacimiento;
    public javax.swing.JLabel mFotoTrabajador;
    public javax.swing.JLabel mGalones;
    public javax.swing.JLabel mGenero;
    public javax.swing.JLabel mGradoInstruccion;
    public javax.swing.JLabel mGuardiaSeleccionadaReparto;
    public javax.swing.JLabel mHoraAbastecimiento;
    public javax.swing.JLabel mHorometroVale;
    public javax.swing.JLabel mIdVehiculo;
    public javax.swing.JLabel mLogoDatos;
    public javax.swing.JLabel mLogoUpdate;
    public javax.swing.JLabel mLugar;
    public javax.swing.JLabel mMarca;
    public javax.swing.JLabel mModelo;
    public javax.swing.JLabel mMotivoCese;
    public javax.swing.JLabel mNombreCargo;
    public javax.swing.JLabel mNombreGuardia;
    public javax.swing.JLabel mNombresTrabajador;
    public javax.swing.JLabel mNumLicencia;
    public javax.swing.JLabel mPlaca;
    public javax.swing.JLabel mProfesion;
    public javax.swing.JLabel mSueldo;
    public javax.swing.JLabel mTelefono;
    public javax.swing.JLabel mTipoVehiculo;
    public javax.swing.JLabel mTipoVehiculoAsignado;
    public javax.swing.JLabel mTrabajadorAsignadoLicencia;
    public javax.swing.JLabel mTrabajadorAsignadoPerfil;
    public javax.swing.JLabel mTrabajadorAsignadoReparto;
    public javax.swing.JLabel mTurno;
    public javax.swing.JLabel mVehiculoSeleccionadoReparto;
    public gamm_RadioButton.RadioButton opCasado;
    public gamm_RadioButton.RadioButton opConviviente;
    public gamm_RadioButton.RadioButton opEmpleado;
    public gamm_RadioButton.RadioButton opFemenino;
    public gamm_RadioButton.RadioButton opMasculino;
    public gamm_RadioButton.RadioButton opNo;
    public gamm_RadioButton.RadioButton opObrero;
    public gamm_RadioButton.RadioButton opPrimaria;
    public gamm_RadioButton.RadioButton opSecundaria;
    public gamm_RadioButton.RadioButton opSi;
    public gamm_RadioButton.RadioButton opSoltero;
    public gamm_RadioButton.RadioButton opTecnico;
    public gamm_RadioButton.RadioButton opUniversitaria;
    public javax.swing.JPanel panelNuevo;
    private gamm_Panel.RoundedPanel pnlAsignacionCargo;
    public javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCabecera;
    public gamm_Panel.RoundedPanel pnlCesamientoTrabajador;
    public javax.swing.JPanel pnlDatosEmpresa;
    private gamm_Panel.RoundedPanel pnlDatosPersonales;
    private gamm_Panel.RoundedPanel pnlFotoTrabajador;
    private gamm_Panel.TabbedPane pnlGuardia;
    public gamm_Panel.RoundedPanel pnlInfoEmpresa;
    private gamm_Panel.RoundedPanel pnlInformacionAcademica;
    private gamm_Panel.RoundedPanel pnlInformacionCargo;
    public javax.swing.JPanel pnlInformacionEmpresa;
    private gamm_Panel.RoundedPanel pnlInformacionVehiculo;
    public gamm_Panel.TabbedPane pnlInicio;
    private javax.swing.JPanel pnlItems;
    public gamm_Panel.RoundedPanel pnlListaContratosUsuario;
    private javax.swing.JPanel pnlListarAsistencias;
    private javax.swing.JPanel pnlListarCargos;
    private javax.swing.JPanel pnlListarLicencia;
    private javax.swing.JPanel pnlListarPerfilLaboral;
    public javax.swing.JPanel pnlListarTrabajadores;
    public javax.swing.JPanel pnlMenu;
    public gamm_Panel.TabbedPane pnlOpciones;
    private javax.swing.JPanel pnlRegistrarAsistencia;
    private javax.swing.JPanel pnlRegistrarCargo;
    private javax.swing.JPanel pnlRegistrarGuardia;
    public javax.swing.JPanel pnlRegistrarLicencia;
    public javax.swing.JPanel pnlRegistrarPerfilLaboral;
    public javax.swing.JPanel pnlRegistrarTrabajador;
    private gamm_Panel.RoundedPanel pnlTipoVehiculo1;
    public gamm_Panel.TabbedPane pnlTrabajador;
    public javax.swing.JPopupMenu popupTrabajador;
    private gamm_Panel.RoundedPanel roundedPanel1;
    private gamm_Panel.RoundedPanel roundedPanel10;
    private gamm_Panel.RoundedPanel roundedPanel11;
    private gamm_Panel.RoundedPanel roundedPanel12;
    private gamm_Panel.RoundedPanel roundedPanel13;
    private gamm_Panel.RoundedPanel roundedPanel14;
    private gamm_Panel.RoundedPanel roundedPanel15;
    private gamm_Panel.RoundedPanel roundedPanel16;
    private gamm_Panel.RoundedPanel roundedPanel17;
    private gamm_Panel.RoundedPanel roundedPanel18;
    private gamm_Panel.RoundedPanel roundedPanel19;
    private gamm_Panel.RoundedPanel roundedPanel2;
    private gamm_Panel.RoundedPanel roundedPanel20;
    private gamm_Panel.RoundedPanel roundedPanel21;
    private gamm_Panel.RoundedPanel roundedPanel22;
    private gamm_Panel.RoundedPanel roundedPanel27;
    private gamm_Panel.RoundedPanel roundedPanel28;
    private gamm_Panel.RoundedPanel roundedPanel29;
    private gamm_Panel.RoundedPanel roundedPanel3;
    private gamm_Panel.RoundedPanel roundedPanel30;
    private gamm_Panel.RoundedPanel roundedPanel31;
    private gamm_Panel.RoundedPanel roundedPanel4;
    private gamm_Panel.RoundedPanel roundedPanel5;
    private gamm_Panel.RoundedPanel roundedPanel6;
    private gamm_Panel.RoundedPanel roundedPanel7;
    public gamm_Panel.RoundedPanel roundedPanel8;
    private gamm_Panel.RoundedPanel roundedPanel9;
    private gamm_Panel.TabbedPane tabbedPane1;
    public javax.swing.JTable tblCargos;
    public javax.swing.JTable tblGuardias;
    public javax.swing.JTable tblLicencias;
    public javax.swing.JTable tblListaCargos;
    public javax.swing.JTable tblListaContratos;
    public javax.swing.JTable tblListaLicencias;
    public javax.swing.JTable tblListaRepartoA;
    public javax.swing.JTable tblListaRepartoB;
    public javax.swing.JTable tblListaRepartoC;
    public javax.swing.JTable tblListaTrabajadores;
    public javax.swing.JTable tblPerfilLaboral;
    public javax.swing.JTable tblRepartoA;
    public javax.swing.JTable tblRepartoB;
    public javax.swing.JTable tblRepartoC;
    public javax.swing.JTable tblTipoVehiculo;
    public javax.swing.JTable tblTrabajadores;
    public javax.swing.JTable tblTurnos;
    public javax.swing.JTable tblVale;
    public javax.swing.JTable tblVehiculos;
    public gamm_TextField.TextField textField2;
    public gamm_TextField.TextField textField4;
    public gamm_TextField.TextField textField5;
    public gamm_TextField.TextField txtApeMaterno;
    public gamm_TextField.TextField txtApePaterno;
    public gamm_TextField.TextField txtAño;
    public gamm_TextField.TextField txtBusquedaNombreAsistencia;
    public gamm_TextField.TextField txtBusquedaTrabajador;
    public gamm_TextField.TextField txtCargoAsignado;
    public gamm_TextField.TextField txtCargoAsignadoLicencia;
    public gamm_TextField.TextField txtCargoAsignadoPerfil;
    public gamm_TextField.TextField txtCargoSeleccionadoReparto;
    public gamm_TextField.TextField txtCelularEmpresaDatos;
    public gamm_TextField.TextField txtCelularUpdate;
    public gamm_TextField.TextField txtCiiuDatos;
    public gamm_TextField.TextField txtCiiuUpdate;
    public javax.swing.JTextField txtCodCargo;
    public javax.swing.JLabel txtCodCargoAsignado;
    public javax.swing.JLabel txtCodGuardia;
    public javax.swing.JLabel txtCodGuardiaReparto;
    public javax.swing.JLabel txtCodLicencia;
    public javax.swing.JLabel txtCodPerfilLaboral;
    public javax.swing.JLabel txtCodReparto;
    public javax.swing.JLabel txtCodRepartoVale;
    public javax.swing.JLabel txtCodTipoVehiculo;
    public javax.swing.JLabel txtCodTipoVehiculoAsignado;
    public javax.swing.JLabel txtCodTurno;
    public gamm_TextField.TextField txtCodVale;
    public javax.swing.JLabel txtCodVehiculoReparto;
    public gamm_TextField.TextField txtDireccion;
    public gamm_TextField.TextField txtDireccionEmpresaDatos;
    public gamm_TextField.TextField txtDireccionUpdate;
    public gamm_TextField.TextField txtDni;
    public gamm_TextField.TextField txtEmailEmpresaDatos;
    public gamm_TextField.TextField txtEmailUpdate;
    public gamm_TextField.TextField txtFechaCaducidad;
    public gamm_TextField.TextField txtFechaCese;
    public gamm_TextField.TextField txtFechaCompra;
    public gamm_TextField.TextField txtFechaEmsion;
    public gamm_TextField.TextField txtFechaFiltroReparto;
    public gamm_TextField.TextField txtFechaIngreso;
    public gamm_TextField.TextField txtFechaNacimiento;
    public gamm_TextField.TextField txtFechaReparto;
    public gamm_TextField.TextField txtFiltrarTrabajadorLicencia;
    public gamm_TextField.TextField txtFiltrarTrabajadorPerfil;
    public gamm_TextField.TextField txtFiltrarTrabajadorReparto;
    public gamm_TextField.TextField txtFiltroContratoLista;
    public gamm_TextField.TextField txtFiltroLicenciaLista;
    public gamm_TextField.TextField txtFiltroTipoVehiculo;
    public gamm_TextField.TextField txtFiltroTrabajadorLista;
    public gamm_TextField.TextField txtGalonesVale;
    public gamm_TextField.TextField txtGuardiaSeleccionadaReparto;
    public gamm_TextField.TextField txtHoraAbastecimiento;
    public gamm_TextField.TextField txtHoraEntrada;
    public gamm_TextField.TextField txtHoraSalida;
    public gamm_TextField.TextField txtHorometroVale;
    public javax.swing.JLabel txtIdEmpresaDatos;
    public javax.swing.JLabel txtIdEmpresaUpdate;
    public javax.swing.JTextField txtIdTrabajador;
    public javax.swing.JLabel txtIdTrabajadorLicencia;
    public javax.swing.JLabel txtIdTrabajadorPerfil;
    public javax.swing.JLabel txtIdTrabajadorReparto;
    public javax.swing.JLabel txtIdVale;
    public gamm_TextField.TextField txtIdVehiculo;
    public gamm_TextField.TextField txtLugar;
    public gamm_TextField.TextField txtModelo;
    public gamm_TextField.TextField txtMotivo;
    public gamm_TextField.TextField txtNombreCargo;
    public gamm_TextField.TextField txtNombreGuardia;
    public gamm_TextField.TextField txtNombreTrabajador;
    public gamm_TextField.TextField txtNumLicencia;
    public gamm_TextField.TextField txtPagWebUpdate;
    public gamm_TextField.TextField txtPaginaWebEmpresaDatos;
    public gamm_TextField.TextField txtPlaca;
    public gamm_TextField.TextField txtProfesion;
    public gamm_TextField.TextField txtRazonSocialDatos;
    public gamm_TextField.TextField txtRazonSocialUpdate;
    public gamm_TextField.TextField txtRucDatos;
    public gamm_TextField.TextField txtRucUpdate;
    public javax.swing.JTextField txtRutaEmpresaDatos;
    public javax.swing.JTextField txtRutaFotoTrabajador;
    public javax.swing.JTextField txtRutaUpdate;
    public gamm_TextField.TextField txtSueldo;
    public gamm_TextField.TextField txtTelefono;
    public gamm_TextField.TextField txtTelefonoEmpresaDatos;
    public gamm_TextField.TextField txtTelefonoUpdate;
    public gamm_TextField.TextField txtTipoSeleccionadoReparto;
    public gamm_TextField.TextField txtTipoVehiculo;
    public gamm_TextField.TextField txtTipoVehiculoAsignado;
    public gamm_TextField.TextField txtTrabajadorAsignadoLicencia;
    public gamm_TextField.TextField txtTrabajadorAsignadoPerfil;
    public gamm_TextField.TextField txtTrabajadorAsignadoReparto;
    public gamm_TextField.TextField txtTrabajadorAsignadoVale;
    public gamm_TextField.TextField txtTurno;
    public gamm_TextField.TextField txtTurnoSeleccionadoReparto;
    public gamm_TextField.TextField txtTurnoVale;
    public gamm_TextField.TextField txtVehiculoSeleccionadoReparto;
    // End of variables declaration//GEN-END:variables
}
