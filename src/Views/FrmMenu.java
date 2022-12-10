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
import Controllers.EmpresaController;
import Controllers.DatosEmpresaController;
import Controllers.GuardiaController;
import Controllers.LicenciaController;
import Controllers.MenuController;
import Models.PerfilLaboral;
import Controllers.PerfilLaboralController;
import Controllers.TipoVehiculoController;
import Models.PerfilLaboralDAO;
import Controllers.TrabajadorController;
import Controllers.ValeController;
import Controllers.VehiculoController;
import Models.Guardia;
import Models.GuardiaDAO;
import Models.Licencia;
import Models.LicenciaDAO;
import Models.TipoVehiculo;
import Models.TipoVehiculoDAO;
import Models.Turno;
import Models.TurnoDAO;
import Models.Vale;
import Models.ValeDAO;
import Models.Vehiculo;
import Models.VehiculoDAO;
import java.awt.Color;

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
    PerfilLaboral plab = new PerfilLaboral();
    PerfilLaboralDAO plabDAO = new PerfilLaboralDAO();
    Licencia lic = new Licencia();
    LicenciaDAO licDAO = new LicenciaDAO();
    Empresa em = new Empresa();
    EmpresaDAO emDAO = new EmpresaDAO();
    TipoVehiculo tv = new TipoVehiculo();
    TipoVehiculoDAO tvDAO = new TipoVehiculoDAO();
    Vehiculo ve = new Vehiculo();
    VehiculoDAO veDAO = new VehiculoDAO();
    Turno tur = new Turno();
    TurnoDAO turDAO = new TurnoDAO();
    Guardia gua = new Guardia();
    GuardiaDAO guaDAO = new GuardiaDAO();
    Vale vale = new Vale();
    ValeDAO valeDAO = new ValeDAO();

    public FrmMenu() {
        initComponents();
        MenuController menuControl = new MenuController(this);
        CargoController cargoControl = new CargoController(ca, caDAO, this);
        TrabajadorController trabajadorControl = new TrabajadorController(tra, traDAO, this);
        PerfilLaboralController perfilLaboralControl = new PerfilLaboralController(plab, plabDAO, this);
        LicenciaController licenciaControl = new LicenciaController(lic, licDAO, this);
        TipoVehiculoController tvControl = new TipoVehiculoController(tv, tvDAO, this);
        VehiculoController veControl = new VehiculoController(ve, veDAO, this);
        GuardiaController guaControl = new GuardiaController(tur, turDAO, gua, guaDAO, this);
        ValeController valeContrl = new ValeController(vale, valeDAO, this);

        EmpresaController empresaControl = new EmpresaController(em, emDAO, this);
        DatosEmpresaController datosEmpresaControl = new DatosEmpresaController(emDAO, this);
    }

    public FrmMenu(Usuario us, Rol tu) {
        initComponents();
        this.tu = tu;
        this.us = us;
        //  Restriccion de privilegios
        if (tu.getIdRol() == 1) {
//            pnlInicio.remove(pnlDatosEmpresa);
//            pnlCargo.remove(pnlRegistrarCargo);
//            pnlTrabajador.remove(pnlRegistrarTrabajador);
//            pnlTrabajador  .remove(pnlRegistrarPerfilLaboral);
        } else if (tu.getIdRol() == 2) {
//            pnlInicio.remove(pnlInformacionEmpresa);
        }

        //  Llamada de los controladores
        MenuController menuControl = new MenuController(this);
        CargoController cargoControl = new CargoController(ca, caDAO, this);
        TrabajadorController trabajadorControl = new TrabajadorController(tra, traDAO, this);
        PerfilLaboralController perfilLaboralControl = new PerfilLaboralController(plab, plabDAO, this);
        LicenciaController licenciaControl = new LicenciaController(lic, licDAO, this);
        TipoVehiculoController tvControl = new TipoVehiculoController(tv, tvDAO, this);
        VehiculoController veControl = new VehiculoController(ve, veDAO, this);
        GuardiaController guaControl = new GuardiaController(tur, turDAO, gua, guaDAO, this);
        ValeController valeContrl = new ValeController(vale, valeDAO, this);

        EmpresaController empresaControl = new EmpresaController(em, emDAO, this);
        DatosEmpresaController datosEmpresaControl = new DatosEmpresaController(emDAO, this);
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
        fechaNacimiento = new gamm_DateChooser.DateChooser();
        fechaIngreso = new gamm_DateChooser.DateChooser();
        fechaCese = new gamm_DateChooser.DateChooser();
        fechaEmision = new gamm_DateChooser.DateChooser();
        fechaCaducidad = new gamm_DateChooser.DateChooser();
        fechaCompra = new gamm_DateChooser.DateChooser();
        fechaAbastecimientoVale = new gamm_DateChooser.DateChooser();
        popupTrabajador = new javax.swing.JPopupMenu();
        JCesarTrabajador = new javax.swing.JMenuItem();
        JReingresarTrabajador = new javax.swing.JMenuItem();
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
        itemGuardias = new gamm_Panel.MenuItem();
        lblGuardias = new javax.swing.JLabel();
        itemEquipos = new gamm_Panel.MenuItem();
        lblEquipos = new javax.swing.JLabel();
        itemCargos4 = new gamm_Panel.MenuItem();
        lblFoto = new gamm_LavelAvatar.LabelAvatar();
        pnlCabecera = new javax.swing.JPanel();
        ckbDarkMode = new gamm_CheckBox.CheckBox();
        pnlOpciones = new gamm_Panel.TabbedPane();
        INICIO = new javax.swing.JPanel();
        pnlInicio = new gamm_Panel.TabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        pnlInformacionEmpresa = new javax.swing.JPanel();
        pnlInfoEmpresa = new gamm_Panel.RoundedPanel();
        txtIdEmpresaUpdate = new javax.swing.JTextField();
        txtRucUpdate = new gamm_TextField.TextField();
        txtRazonSocialUpdate = new gamm_TextField.TextField();
        txtCiiuUpdate = new gamm_TextField.TextField();
        txtTelefonoUpdate = new gamm_TextField.TextField();
        txtCelularUpdate = new gamm_TextField.TextField();
        ckbAgregarCelular = new gamm_CheckBox.CheckBox();
        txtDireccionUpdate = new gamm_TextField.TextField();
        txtEmailUpdate = new gamm_TextField.TextField();
        txtPagWebUpdate = new gamm_TextField.TextField();
        roundedPanel3 = new gamm_Panel.RoundedPanel();
        lblLogoUpdate = new javax.swing.JLabel();
        btnSeleccionarLogo = new gamm_Button.ButtonLine();
        txtRutaUpdate = new javax.swing.JTextField();
        btnHabilitar = new gamm_Button.Button();
        btnModificarEmpresa = new gamm_Button.Button();
        btnCancelarEmpresa = new gamm_Button.Button();
        pnlDatosEmpresa = new javax.swing.JPanel();
        roundedPanel4 = new gamm_Panel.RoundedPanel();
        txtRucDatos = new gamm_TextField.TextField();
        txtIdEmpresaDatos = new javax.swing.JTextField();
        txtRazonSocialDatos = new gamm_TextField.TextField();
        txtCiiuDatos = new gamm_TextField.TextField();
        txtTelefonoEmpresaDatos = new gamm_TextField.TextField();
        txtCelularEmpresaDatos = new gamm_TextField.TextField();
        txtEmailEmpresaDatos = new gamm_TextField.TextField();
        txtDireccionEmpresaDatos = new gamm_TextField.TextField();
        txtPaginaWebEmpresaDatos = new gamm_TextField.TextField();
        roundedPanel6 = new gamm_Panel.RoundedPanel();
        lblLogoEmpresaDatos = new javax.swing.JLabel();
        txtRutaEmpresaDatos = new javax.swing.JTextField();
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
        txtCodCargo = new javax.swing.JTextField();
        btnRegistrarCargo = new gamm_Button.Button();
        roundedPanel9 = new gamm_Panel.RoundedPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();
        btnActualizarCargo = new gamm_Button.Button();
        btnCancelarCargo = new gamm_Button.Button();
        pnlListaCargos = new javax.swing.JPanel();
        roundedPanel1 = new gamm_Panel.RoundedPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblListaCargos = new javax.swing.JTable();
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
        btnRegistrarTrabajador = new gamm_Button.Button();
        btnActualizarTrabajador = new gamm_Button.Button();
        roundedPanel12 = new gamm_Panel.RoundedPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTrabajadores = new javax.swing.JTable();
        txtBusquedaTrabajador = new gamm_TextField.TextField();
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
        mTrabajadorAsignadoPerfil = new javax.swing.JLabel();
        txtIdTrabajadorPerfil = new javax.swing.JLabel();
        roundedPanel11 = new gamm_Panel.RoundedPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPerfilLaboral = new javax.swing.JTable();
        txtFiltrarTrabajadorPerfil = new gamm_TextField.TextField();
        btnEstadoPerfil = new gamm_Button.Button();
        btnRegistrarPerfilLaboral = new gamm_Button.Button();
        btnActualizarPerfil = new gamm_Button.Button();
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
        roundedPanel14 = new gamm_Panel.RoundedPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblLicencias = new javax.swing.JTable();
        txtFiltrarTrabajadorLicencia = new gamm_TextField.TextField();
        btnRegistrarLicencia = new gamm_Button.Button();
        jPanel6 = new javax.swing.JPanel();
        roundedPanel13 = new gamm_Panel.RoundedPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblListaTrabajadores = new javax.swing.JTable();
        txtFiltroTrabajadorLista = new gamm_TextField.TextField();
        cboFiltrarTrabajadorPor = new gamm_ComboBox.Combobox();
        jPanel7 = new javax.swing.JPanel();
        roundedPanel16 = new gamm_Panel.RoundedPanel();
        cboFiltrarContratoPor = new gamm_ComboBox.Combobox();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblListaContratos = new javax.swing.JTable();
        txtFiltroContratoLista = new gamm_TextField.TextField();
        jPanel8 = new javax.swing.JPanel();
        roundedPanel19 = new gamm_Panel.RoundedPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        txtFechaAbastecimiento = new gamm_TextField.TextField();
        mCodVale = new javax.swing.JLabel();
        txtHoraAbastecimiento = new gamm_TextField.TextField();
        txtLugar = new gamm_TextField.TextField();
        txtIdVale = new javax.swing.JLabel();
        txtHorometroVale = new gamm_TextField.TextField();
        txtGalonesVale = new gamm_TextField.TextField();
        mFechaAbastecimiento = new javax.swing.JLabel();
        mHoraAbastecimiento = new javax.swing.JLabel();
        mLugar = new javax.swing.JLabel();
        mHorometroVale = new javax.swing.JLabel();
        mGalones = new javax.swing.JLabel();
        roundedPanel20 = new gamm_Panel.RoundedPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblVale = new javax.swing.JTable();
        roundedPanel21 = new gamm_Panel.RoundedPanel();
        btnSeleccionarTrabajadorVale = new gamm_Button.ButtonLine();
        txtTrabajadorAsignadoVale = new gamm_TextField.TextField();
        mTrabajadorAsignadoVale = new javax.swing.JLabel();
        txtIdTrabajadorVale = new javax.swing.JLabel();
        roundedPanel22 = new gamm_Panel.RoundedPanel();
        btnSeleccionarGuardiaVale = new gamm_Button.ButtonLine();
        txtGuardiaSeleccionadaVale = new gamm_TextField.TextField();
        txtTurnoSeleccionado = new gamm_TextField.TextField();
        mGuardiaSeleccionadaVale = new javax.swing.JLabel();
        txtCodGuardiaAsignadaVale = new javax.swing.JLabel();
        roundedPanel23 = new gamm_Panel.RoundedPanel();
        btnSeleccionarVehiculoVale = new gamm_Button.ButtonLine();
        txtVehiculoSeleccionadoVale = new gamm_TextField.TextField();
        mVehiculoAsignadoVale = new javax.swing.JLabel();
        txtCodVehiculoAsignadoVale = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btnActualizarVale = new gamm_Button.Button();
        btnRegistrarVale = new gamm_Button.Button();
        jPanel9 = new javax.swing.JPanel();
        GUARDIAS = new javax.swing.JPanel();
        tabbedPane2 = new gamm_Panel.TabbedPane();
        jPanel3 = new javax.swing.JPanel();
        roundedPanel17 = new gamm_Panel.RoundedPanel();
        txtNombreGuardia = new gamm_TextField.TextField();
        txtTurno = new gamm_TextField.TextField();
        mNombreGuardia = new javax.swing.JLabel();
        txtCodGuardia = new javax.swing.JLabel();
        txtCodTurno = new javax.swing.JLabel();
        txtHoraEntrada = new gamm_TextField.TextField();
        mTurno = new javax.swing.JLabel();
        txtHoraSalida = new gamm_TextField.TextField();
        roundedPanel18 = new gamm_Panel.RoundedPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblTurnos = new javax.swing.JTable();
        btnSeleccionarTurno = new gamm_Button.Button();
        btnRegistrarGuardia = new gamm_Button.Button();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblGuardias = new javax.swing.JTable();

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

        fechaAbastecimientoVale.setDateFormat("yyyy-MM-dd");
        fechaAbastecimientoVale.setTextRefernce(txtFechaAbastecimiento);

        popupTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        popupTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JCesarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JCesarTrabajador.setText("Eliminar trabajador");
        popupTrabajador.add(JCesarTrabajador);

        JReingresarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        JReingresarTrabajador.setText("Reingresar Trabajador");
        popupTrabajador.add(JReingresarTrabajador);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(102, 102, 102));

        lblRol.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setText("Rol");

        lblNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        lblGuardias.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        lblGuardias.setText("GUARDIAS");

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
                .addComponent(itemCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(itemTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(itemEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(itemGuardias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
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

        ckbDarkMode.setBackground(new java.awt.Color(204, 204, 204));
        ckbDarkMode.setForeground(new java.awt.Color(255, 255, 255));
        ckbDarkMode.setText("Dark Mode");
        ckbDarkMode.setFocusable(false);
        ckbDarkMode.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlCabeceraLayout = new javax.swing.GroupLayout(pnlCabecera);
        pnlCabecera.setLayout(pnlCabeceraLayout);
        pnlCabeceraLayout.setHorizontalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap(1517, Short.MAX_VALUE)
                .addComponent(ckbDarkMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlCabeceraLayout.setVerticalGroup(
            pnlCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckbDarkMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBackground.add(pnlCabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1620, 20));

        pnlOpciones.setForeground(new java.awt.Color(255, 255, 255));
        pnlOpciones.setFocusable(false);

        pnlInicio.setFocusable(false);

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

        pnlInformacionEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlInfoEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Datos de empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        pnlInfoEmpresa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtIdEmpresaUpdate.setEditable(false);
        txtIdEmpresaUpdate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdEmpresaUpdate.setText("1");
        txtIdEmpresaUpdate.setBorder(null);

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
                                .addGap(43, 43, 43)
                                .addComponent(txtIdEmpresaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(txtIdEmpresaUpdate))
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

        lblLogoUpdate.setText("jLabel1");
        lblLogoUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnSeleccionarLogo.setText("Seleccionar Foto");

        btnHabilitar.setText("HABILITAR");

        btnModificarEmpresa.setText("MODIFICAR");

        btnCancelarEmpresa.setText("CANCELAR");

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel3Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogoUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeleccionarLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(txtRutaUpdate))
                .addGap(69, 69, 69))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblLogoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionarLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
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

        pnlDatosEmpresa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N

        txtRucDatos.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        txtRucDatos.setLabelText("RUC");

        txtIdEmpresaDatos.setText("1");
        txtIdEmpresaDatos.setBorder(null);

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
                            .addComponent(txtRucDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonSocialDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel4Layout.createSequentialGroup()
                                .addComponent(txtCiiuDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel4Layout.createSequentialGroup()
                                .addComponent(txtIdEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178))))))
        );
        roundedPanel4Layout.setVerticalGroup(
            roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(roundedPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRucDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        lblLogoEmpresaDatos.setText("jLabel1");

        javax.swing.GroupLayout roundedPanel6Layout = new javax.swing.GroupLayout(roundedPanel6);
        roundedPanel6.setLayout(roundedPanel6Layout);
        roundedPanel6Layout.setHorizontalGroup(
            roundedPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel6Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(lblLogoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        roundedPanel6Layout.setVerticalGroup(
            roundedPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel6Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblLogoEmpresaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
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
                .addContainerGap(29, Short.MAX_VALUE))
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

        pnlCargo.setFocusable(false);

        pnlRegistrarCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        btnRegistrarCargo.setText("REGISTRAR");

        tblCargos.setAutoCreateRowSorter(true);
        tblCargos.setBackground(new java.awt.Color(255, 255, 255));
        tblCargos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "CARGO", "CATEGORÍA"
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

        btnActualizarCargo.setText("ACTUALIZAR");

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
                        .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCancelarCargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addComponent(roundedPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        pnlRegistrarCargoLayout.setVerticalGroup(
            pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                        .addComponent(roundedPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegistrarCargoLayout.createSequentialGroup()
                        .addComponent(pnlInformacionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlRegistrarCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrarCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(btnActualizarCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );

        pnlCargo.addTab("Nuevo Cargo", pnlRegistrarCargo);

        pnlListaCargos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tblListaCargos.setAutoCreateRowSorter(true);
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

        javax.swing.GroupLayout pnlListaCargosLayout = new javax.swing.GroupLayout(pnlListaCargos);
        pnlListaCargos.setLayout(pnlListaCargosLayout);
        pnlListaCargosLayout.setHorizontalGroup(
            pnlListaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaCargosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(780, Short.MAX_VALUE))
        );
        pnlListaCargosLayout.setVerticalGroup(
            pnlListaCargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaCargosLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pnlCargo.addTab("Lista de cargos", pnlListaCargos);

        javax.swing.GroupLayout CARGOSLayout = new javax.swing.GroupLayout(CARGOS);
        CARGOS.setLayout(CARGOSLayout);
        CARGOSLayout.setHorizontalGroup(
            CARGOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARGOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 1514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        CARGOSLayout.setVerticalGroup(
            CARGOSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARGOSLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab2", CARGOS);

        pnlTrabajador.setFocusable(false);

        pnlRegistrarTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        pnlDatosPersonales.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtDni.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDni.setLabelText("DNI");

        mDni.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        mApePaterno.setText("Mensaje de error");

        mApeMaterno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mApeMaterno.setText("Mensaje de error");

        mNombresTrabajador.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombresTrabajador.setText("Mensaje de error");

        txtApeMaterno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtApeMaterno.setLabelText("Apellido Materno");

        txtNombreTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreTrabajador.setLabelText("Nombres");

        Genero.add(opFemenino);
        opFemenino.setText("Femenino");
        opFemenino.setFocusable(false);
        opFemenino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        Genero.add(opMasculino);
        opMasculino.setText("Masculino");
        opMasculino.setFocusable(false);
        opMasculino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opSoltero);
        opSoltero.setText("Soltero");
        opSoltero.setFocusable(false);
        opSoltero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opCasado);
        opCasado.setText("Casado");
        opCasado.setFocusable(false);
        opCasado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        EstadoCivil.add(opConviviente);
        opConviviente.setText("Conviviente");
        opConviviente.setFocusable(false);
        opConviviente.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        mEstadoCivil.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mEstadoCivil.setText("Mensaje de error");

        txtDireccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDireccion.setLabelText("Dirección");

        mDireccion.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mDireccion.setText("Mensaje de error");

        txtTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTelefono.setLabelText("Teléfono");

        mTelefono.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTelefono.setText("Mensaje de error");

        mGenero.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mGenero.setText("Mensaje de error");

        txtFechaNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaNacimiento.setLabelText("F. Nacimiento (aaaa-mm-dd)");

        mFechaNacimiento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaNacimiento.setText("Mensaje de error");

        txtIdTrabajador.setEditable(false);
        txtIdTrabajador.setBackground(new java.awt.Color(255, 255, 255));
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

        pnlFotoTrabajador.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selección de foto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

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

        pnlAsignacionCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Asignación de cargo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtCodCargoAsignado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtCodCargoAsignado.setForeground(new java.awt.Color(0, 0, 0));

        btnSeleccionarCargo.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarCargo.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarCargo.setText("...");
        btnSeleccionarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarCargoActionPerformed(evt);
            }
        });

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

        pnlInformacionAcademica.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información Académica", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Grado de instrucción");

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

        btnRegistrarTrabajador.setText("REGISTRAR");

        btnActualizarTrabajador.setText("ACTUALIZAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActualizarTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnActualizarTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundedPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Lista de trabajadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        tblTrabajadores.setAutoCreateRowSorter(true);
        tblTrabajadores.setBackground(new java.awt.Color(255, 255, 255));
        tblTrabajadores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "TRABAJADOR", "DIRECCIÓN", "TELÉFONO", "CARGO", "ESTADO"
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

        txtBusquedaTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBusquedaTrabajador.setLabelText("Búsqueda por nombre ");

        javax.swing.GroupLayout roundedPanel12Layout = new javax.swing.GroupLayout(roundedPanel12);
        roundedPanel12.setLayout(roundedPanel12Layout);
        roundedPanel12Layout.setHorizontalGroup(
            roundedPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(roundedPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel12Layout.setVerticalGroup(
            roundedPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusquedaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout pnlRegistrarTrabajadorLayout = new javax.swing.GroupLayout(pnlRegistrarTrabajador);
        pnlRegistrarTrabajador.setLayout(pnlRegistrarTrabajadorLayout);
        pnlRegistrarTrabajadorLayout.setHorizontalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundedPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegistrarTrabajadorLayout.createSequentialGroup()
                        .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegistrarTrabajadorLayout.setVerticalGroup(
            pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegistrarTrabajadorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRegistrarTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pnlDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlFotoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(roundedPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2233, 2233, 2233))
        );

        pnlTrabajador.addTab("Nuevo Trabajador", pnlRegistrarTrabajador);

        pnlRegistrarPerfilLaboral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de ingreso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtFechaIngreso.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaIngreso.setLabelText("Fecha de ingreso");

        txtSueldo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSueldo.setLabelText("Sueldo");

        mFechaIngreso.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaIngreso.setForeground(new java.awt.Color(63, 63, 63));
        mFechaIngreso.setText("Mensaje de error");

        mSueldo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mSueldo.setForeground(new java.awt.Color(63, 63, 63));
        mSueldo.setText("Mensaje de error");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Soles");

        txtCodPerfilLaboral.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundedPanel5Layout.setVerticalGroup(
            roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel5Layout.createSequentialGroup()
                .addGroup(roundedPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtCodPerfilLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(mFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mArea, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
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
        txtFechaCese.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaCese.setLabelText("Fecha de cese");

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

        roundedPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Asignación de trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        btnSeleccionarTrabajadorPerfil.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorPerfil.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorPerfil.setText("...");
        btnSeleccionarTrabajadorPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarTrabajadorPerfilActionPerformed(evt);
            }
        });

        txtTrabajadorAsignadoPerfil.setEditable(false);
        txtTrabajadorAsignadoPerfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTrabajadorAsignadoPerfil.setLabelText("Trabajador asignado");

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
                        .addComponent(mTrabajadorAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundedPanel7Layout.createSequentialGroup()
                        .addComponent(txtTrabajadorAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(roundedPanel7Layout.createSequentialGroup()
                        .addComponent(btnSeleccionarTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
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
                .addGap(0, 0, 0)
                .addComponent(mTrabajadorAsignadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        roundedPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Lista de perfiles laborales de trabajadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        tblPerfilLaboral.setAutoCreateRowSorter(true);
        tblPerfilLaboral.setBackground(new java.awt.Color(255, 255, 255));
        tblPerfilLaboral.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblPerfilLaboral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "COD", "TRABAJADOR", "F. INGRESO", "AREA", "F. CESE", "MOTIVO"
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

        txtFiltrarTrabajadorPerfil.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFiltrarTrabajadorPerfil.setLabelText("Filtrar trabajador");

        btnEstadoPerfil.setText("Estado");

        javax.swing.GroupLayout roundedPanel11Layout = new javax.swing.GroupLayout(roundedPanel11);
        roundedPanel11.setLayout(roundedPanel11Layout);
        roundedPanel11Layout.setHorizontalGroup(
            roundedPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel11Layout.createSequentialGroup()
                        .addComponent(txtFiltrarTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnEstadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        roundedPanel11Layout.setVerticalGroup(
            roundedPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltrarTrabajadorPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstadoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        btnRegistrarPerfilLaboral.setText("REGISTRAR");

        btnActualizarPerfil.setText("ACTUALIZAR");

        javax.swing.GroupLayout pnlRegistrarPerfilLaboralLayout = new javax.swing.GroupLayout(pnlRegistrarPerfilLaboral);
        pnlRegistrarPerfilLaboral.setLayout(pnlRegistrarPerfilLaboralLayout);
        pnlRegistrarPerfilLaboralLayout.setHorizontalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(roundedPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundedPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlCesamientoTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                        .addComponent(btnRegistrarPerfilLaboral, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(btnActualizarPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(roundedPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        pnlRegistrarPerfilLaboralLayout.setVerticalGroup(
            pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarPerfilLaboralLayout.createSequentialGroup()
                        .addComponent(roundedPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundedPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlCesamientoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(pnlRegistrarPerfilLaboralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrarPerfilLaboral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(roundedPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Nuevo Perfil Laboral", pnlRegistrarPerfilLaboral);

        pnlRegistrarLicencia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Detalle de licencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtFechaEmsion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaEmsion.setLabelText("Fecha de emisión");

        mFechaEmision.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaEmision.setForeground(new java.awt.Color(63, 63, 63));
        mFechaEmision.setText("Mensaje de error");

        mFechaCaducidad.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaCaducidad.setForeground(new java.awt.Color(63, 63, 63));
        mFechaCaducidad.setText("Mensaje de error");

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

        txtFechaCaducidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaCaducidad.setLabelText("Fecha de caducidad");

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
                        .addGap(38, 38, 38)
                        .addComponent(txtCodLicencia))
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
                .addGap(28, 28, 28)
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

        roundedPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Asignación de trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        roundedPanel8.setPreferredSize(new java.awt.Dimension(385, 155));

        btnSeleccionarTrabajadorLicencia.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorLicencia.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorLicencia.setText("...");
        btnSeleccionarTrabajadorLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarTrabajadorLicenciaActionPerformed(evt);
            }
        });

        txtTrabajadorAsignadoLicencia.setEditable(false);
        txtTrabajadorAsignadoLicencia.setBackground(new java.awt.Color(255, 255, 255));
        txtTrabajadorAsignadoLicencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTrabajadorAsignadoLicencia.setLabelText("Trabajador asignado");

        mTrabajadorAsignadoLicencia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTrabajadorAsignadoLicencia.setForeground(new java.awt.Color(63, 63, 63));
        mTrabajadorAsignadoLicencia.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel8Layout = new javax.swing.GroupLayout(roundedPanel8);
        roundedPanel8.setLayout(roundedPanel8Layout);
        roundedPanel8Layout.setHorizontalGroup(
            roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel8Layout.createSequentialGroup()
                        .addComponent(mTrabajadorAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundedPanel8Layout.createSequentialGroup()
                        .addGroup(roundedPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundedPanel8Layout.createSequentialGroup()
                                .addComponent(btnSeleccionarTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addComponent(txtTrabajadorAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))))
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
                .addGap(0, 0, 0)
                .addComponent(mTrabajadorAsignadoLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                "COD", "TRABAJADOR", "N° LICENCIA", "CATEGORÍA", "F. EMISIÓN", "F. CADUCIDAD"
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

        txtFiltrarTrabajadorLicencia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFiltrarTrabajadorLicencia.setLabelText("Filtrar trabajador");

        javax.swing.GroupLayout roundedPanel14Layout = new javax.swing.GroupLayout(roundedPanel14);
        roundedPanel14.setLayout(roundedPanel14Layout);
        roundedPanel14Layout.setHorizontalGroup(
            roundedPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltrarTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        roundedPanel14Layout.setVerticalGroup(
            roundedPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel14Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtFiltrarTrabajadorLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        btnRegistrarLicencia.setText("REGISTRAR");

        javax.swing.GroupLayout pnlRegistrarLicenciaLayout = new javax.swing.GroupLayout(pnlRegistrarLicencia);
        pnlRegistrarLicencia.setLayout(pnlRegistrarLicenciaLayout);
        pnlRegistrarLicenciaLayout.setHorizontalGroup(
            pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                .addGroup(pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundedPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundedPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnRegistrarLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(roundedPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegistrarLicenciaLayout.setVerticalGroup(
            pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRegistrarLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegistrarLicenciaLayout.createSequentialGroup()
                        .addComponent(roundedPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundedPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnRegistrarLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Nueva Licencia de conducir", pnlRegistrarLicencia);

        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Relación de trabajadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        tblListaTrabajadores.setAutoCreateRowSorter(true);
        tblListaTrabajadores.setBackground(new java.awt.Color(255, 255, 255));
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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel13Layout.createSequentialGroup()
                        .addComponent(cboFiltrarTrabajadorPor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtFiltroTrabajadorLista, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        roundedPanel13Layout.setVerticalGroup(
            roundedPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(roundedPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroTrabajadorLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFiltrarTrabajadorPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Lista de Trabajadores", jPanel6);

        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Relación de contratos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

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
                true, false, false, false, true, false, false
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
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Relación de Contratos", jPanel7);

        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
        jScrollPane12.setViewportView(jTable1);

        javax.swing.GroupLayout roundedPanel19Layout = new javax.swing.GroupLayout(roundedPanel19);
        roundedPanel19.setLayout(roundedPanel19Layout);
        roundedPanel19Layout.setHorizontalGroup(
            roundedPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel19Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        roundedPanel19Layout.setVerticalGroup(
            roundedPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel19Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(roundedPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pnlTrabajador.addTab("Lista de Licencias ", jPanel8);

        javax.swing.GroupLayout TRABAJADORESLayout = new javax.swing.GroupLayout(TRABAJADORES);
        TRABAJADORES.setLayout(TRABAJADORESLayout);
        TRABAJADORESLayout.setHorizontalGroup(
            TRABAJADORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TRABAJADORESLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 1540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        TRABAJADORESLayout.setVerticalGroup(
            TRABAJADORESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TRABAJADORESLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlOpciones.addTab("tab3", TRABAJADORES);

        tabbedPane1.setFocusable(false);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlInformacionVehiculo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de nuevo vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

        txtIdVehiculo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtIdVehiculo.setLabelText("ID");

        txtPlaca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPlaca.setLabelText("Placa");

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

        txtFechaCompra.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaCompra.setLabelText("Fecha Compra");

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

        pnlTipoVehiculo1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Tipo de vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(102, 102, 102))); // NOI18N

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
                "COD", "ID", "TIPO", "PLACA", "MODELO", "MARCA", "F. COMPRA"
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
                .addContainerGap(160, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("Nuevo Vehículo", jPanel2);

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        roundedPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de vale de combustible", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        roundedPanel2.setForeground(new java.awt.Color(51, 51, 51));

        txtCodVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodVale.setLabelText("Código de vale");

        txtFechaAbastecimiento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFechaAbastecimiento.setLabelText("Fecha abastecimiento");

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

        mFechaAbastecimiento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mFechaAbastecimiento.setForeground(new java.awt.Color(63, 63, 63));
        mFechaAbastecimiento.setText("Mensaje de error");

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

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addComponent(txtCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdVale, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addComponent(mCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mFechaAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mHorometroVale, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHorometroVale, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGalonesVale, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mGalones, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFechaAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdVale, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mCodVale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mFechaAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mHoraAbastecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHorometroVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGalonesVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(roundedPanel20Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        roundedPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selector de trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        btnSeleccionarTrabajadorVale.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorVale.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarTrabajadorVale.setText("...");
        btnSeleccionarTrabajadorVale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarTrabajadorValeActionPerformed(evt);
            }
        });

        txtTrabajadorAsignadoVale.setEditable(false);
        txtTrabajadorAsignadoVale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTrabajadorAsignadoVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTrabajadorAsignadoVale.setLabelText("Trabajador seleccionado");

        mTrabajadorAsignadoVale.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTrabajadorAsignadoVale.setForeground(new java.awt.Color(63, 63, 63));
        mTrabajadorAsignadoVale.setText("Mensaje de error");

        txtIdTrabajadorVale.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        javax.swing.GroupLayout roundedPanel21Layout = new javax.swing.GroupLayout(roundedPanel21);
        roundedPanel21.setLayout(roundedPanel21Layout);
        roundedPanel21Layout.setHorizontalGroup(
            roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel21Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnSeleccionarTrabajadorVale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mTrabajadorAsignadoVale, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addComponent(txtTrabajadorAsignadoVale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdTrabajadorVale, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel21Layout.setVerticalGroup(
            roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel21Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(roundedPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTrabajadorAsignadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarTrabajadorVale, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdTrabajadorVale, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(mTrabajadorAsignadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        roundedPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selector de guardia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        btnSeleccionarGuardiaVale.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarGuardiaVale.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarGuardiaVale.setText("...");
        btnSeleccionarGuardiaVale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarGuardiaValeActionPerformed(evt);
            }
        });

        txtGuardiaSeleccionadaVale.setEditable(false);
        txtGuardiaSeleccionadaVale.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGuardiaSeleccionadaVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtGuardiaSeleccionadaVale.setLabelText("Guardia seleccionada");

        txtTurnoSeleccionado.setEditable(false);
        txtTurnoSeleccionado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTurnoSeleccionado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTurnoSeleccionado.setLabelText("Turno");

        mGuardiaSeleccionadaVale.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mGuardiaSeleccionadaVale.setForeground(new java.awt.Color(63, 63, 63));
        mGuardiaSeleccionadaVale.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel22Layout = new javax.swing.GroupLayout(roundedPanel22);
        roundedPanel22.setLayout(roundedPanel22Layout);
        roundedPanel22Layout.setHorizontalGroup(
            roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel22Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnSeleccionarGuardiaVale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel22Layout.createSequentialGroup()
                        .addComponent(txtGuardiaSeleccionadaVale, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTurnoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodGuardiaAsignadaVale, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mGuardiaSeleccionadaVale, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        roundedPanel22Layout.setVerticalGroup(
            roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGuardiaSeleccionadaVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTurnoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionarGuardiaVale, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel22Layout.createSequentialGroup()
                        .addComponent(txtCodGuardiaAsignadaVale, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(mGuardiaSeleccionadaVale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        roundedPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Selector de vehículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        btnSeleccionarVehiculoVale.setBackground(new java.awt.Color(51, 51, 51));
        btnSeleccionarVehiculoVale.setForeground(new java.awt.Color(51, 51, 51));
        btnSeleccionarVehiculoVale.setText("...");
        btnSeleccionarVehiculoVale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarVehiculoValeActionPerformed(evt);
            }
        });

        txtVehiculoSeleccionadoVale.setEditable(false);
        txtVehiculoSeleccionadoVale.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtVehiculoSeleccionadoVale.setLabelText("Vehículo seleccionado");

        mVehiculoAsignadoVale.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mVehiculoAsignadoVale.setForeground(new java.awt.Color(63, 63, 63));
        mVehiculoAsignadoVale.setText("Mensaje de error");

        javax.swing.GroupLayout roundedPanel23Layout = new javax.swing.GroupLayout(roundedPanel23);
        roundedPanel23.setLayout(roundedPanel23Layout);
        roundedPanel23Layout.setHorizontalGroup(
            roundedPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel23Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnSeleccionarVehiculoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(roundedPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mVehiculoAsignadoVale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundedPanel23Layout.createSequentialGroup()
                        .addComponent(txtVehiculoSeleccionadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodVehiculoAsignadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        roundedPanel23Layout.setVerticalGroup(
            roundedPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVehiculoSeleccionadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSeleccionarVehiculoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel23Layout.createSequentialGroup()
                        .addComponent(txtCodVehiculoAsignadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(mVehiculoAsignadoVale, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnActualizarVale.setText("ACTUALIZAR");

        btnRegistrarVale.setText("REGISTRAR");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarVale, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

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
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundedPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundedPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roundedPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(roundedPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(roundedPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(roundedPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roundedPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(41, 41, 41)))
                .addComponent(roundedPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
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
                .addComponent(tabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlOpciones.addTab("tab4", EQUIPOS);

        roundedPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Información de guardia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        txtNombreGuardia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombreGuardia.setLabelText("Nombre de Guardia");

        txtTurno.setEditable(false);
        txtTurno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTurno.setLabelText("Turno");

        mNombreGuardia.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mNombreGuardia.setForeground(new java.awt.Color(63, 63, 63));
        mNombreGuardia.setText("Mensaje de error");

        txtHoraEntrada.setEditable(false);
        txtHoraEntrada.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtHoraEntrada.setLabelText("Hora de entrada");

        mTurno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        mTurno.setForeground(new java.awt.Color(63, 63, 63));
        mTurno.setText("Mensaje de error");

        txtHoraSalida.setEditable(false);
        txtHoraSalida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtHoraSalida.setLabelText("Hora de salida");

        roundedPanel18.setBackground(new java.awt.Color(204, 204, 204));
        roundedPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Selector de turno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N

        tblTurnos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "COD", "TURNO", "H. ENTRADA", "H. SALIDA"
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

        btnRegistrarGuardia.setText("REGISTRAR");

        javax.swing.GroupLayout roundedPanel17Layout = new javax.swing.GroupLayout(roundedPanel17);
        roundedPanel17.setLayout(roundedPanel17Layout);
        roundedPanel17Layout.setHorizontalGroup(
            roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel17Layout.createSequentialGroup()
                .addGap(30, 30, 30)
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
                        .addComponent(txtCodGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        roundedPanel17Layout.setVerticalGroup(
            roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel17Layout.createSequentialGroup()
                .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel17Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtNombreGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(mNombreGuardia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel17Layout.createSequentialGroup()
                        .addGroup(roundedPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(mTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roundedPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundedPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap(799, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(roundedPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        tabbedPane2.addTab("Nueva Guardia", jPanel3);

        javax.swing.GroupLayout GUARDIASLayout = new javax.swing.GroupLayout(GUARDIAS);
        GUARDIAS.setLayout(GUARDIASLayout);
        GUARDIASLayout.setHorizontalGroup(
            GUARDIASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUARDIASLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        GUARDIASLayout.setVerticalGroup(
            GUARDIASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GUARDIASLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlOpciones.addTab("tab5", GUARDIAS);

        pnlBackground.add(pnlOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 1610, 930));

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

    private void btnSeleccionarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarCargoActionPerformed
        DSelectorCargo dsc = new DSelectorCargo();
        dsc.setVisible(true);
        Cargo c = dsc.cargoSelected;
        try {
            txtCodCargoAsignado.setText(String.valueOf(c.getCodigo()));
            txtCargoAsignado.setText(c.getNombreCargo());
        } catch (Exception exx) {
            mCargoAsignado.setText("No se realizó selección");
            mCargoAsignado.setForeground(Color.red);
            dsc.dispose();
        }
    }//GEN-LAST:event_btnSeleccionarCargoActionPerformed

    private void btnSeleccionarTrabajadorPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarTrabajadorPerfilActionPerformed
        DSelectorTrabajador dst = new DSelectorTrabajador();
        dst.setVisible(true);
        tra = dst.trabajadorSelected;
        try {
            txtIdTrabajadorPerfil.setText(String.valueOf(tra.getIdTrabajador()));
            txtTrabajadorAsignadoPerfil.setText(tra.getApePaterno());
        } catch (Exception ex) {
            mTrabajadorAsignadoPerfil.setText("No se realizó selección");
            mTrabajadorAsignadoPerfil.setForeground(Color.red);
            dst.dispose();
        }
    }//GEN-LAST:event_btnSeleccionarTrabajadorPerfilActionPerformed

    private void btnSeleccionarTrabajadorLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarTrabajadorLicenciaActionPerformed
        DSelectorTrabajador dst = new DSelectorTrabajador();
        dst.setVisible(true);
        tra = dst.trabajadorSelected;
        try {
            txtIdTrabajadorLicencia.setText(String.valueOf(tra.getIdTrabajador()));
            txtTrabajadorAsignadoLicencia.setText(tra.getApePaterno());
        } catch (Exception ex) {
            mTrabajadorAsignadoLicencia.setText("No se realizó selección");
            mTrabajadorAsignadoLicencia.setForeground(Color.red);
            dst.dispose();
        }
    }//GEN-LAST:event_btnSeleccionarTrabajadorLicenciaActionPerformed

    private void btnSeleccionarTrabajadorValeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarTrabajadorValeActionPerformed
        DSelectorTrabajador dst = new DSelectorTrabajador();
        dst.setVisible(true);
        tra = dst.trabajadorSelected;
        try {
            txtIdTrabajadorVale.setText(String.valueOf(tra.getIdTrabajador()));
            txtTrabajadorAsignadoVale.setText(tra.getApePaterno());
        } catch (Exception e) {
            mTrabajadorAsignadoVale.setText("No se realizó selección");
            mTrabajadorAsignadoVale.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnSeleccionarTrabajadorValeActionPerformed

    private void btnSeleccionarGuardiaValeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarGuardiaValeActionPerformed
        DSelectorGuardia dsg = new DSelectorGuardia();
        dsg.setVisible(true);
        gua = dsg.guardiaSelected;
        tur = dsg.turnoSelected;
        try {
            txtCodGuardiaAsignadaVale.setText(String.valueOf(gua.getCodGuardia()));
            txtGuardiaSeleccionadaVale.setText(gua.getNombreGuardia());
            txtTurnoSeleccionado.setText(tur.getNombreTurno());
        } catch (Exception e) {
            mGuardiaSeleccionadaVale.setText("No se realizó selección");
            mGuardiaSeleccionadaVale.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnSeleccionarGuardiaValeActionPerformed

    private void btnSeleccionarVehiculoValeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarVehiculoValeActionPerformed
        DSelectorVehiculo dsv = new DSelectorVehiculo();
        dsv.setVisible(true);
        ve = dsv.vehiculoSelected;
        try {
            txtCodVehiculoAsignadoVale.setText(String.valueOf(ve.getCodVehiculo()));
            txtVehiculoSeleccionadoVale.setText(ve.getIdVehiculo());
        } catch (Exception e) {
            mVehiculoAsignadoVale.setText("No se realizó selección");
            mVehiculoAsignadoVale.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnSeleccionarVehiculoValeActionPerformed

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

        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup AreaPerfil;
    public javax.swing.JPanel CARGOS;
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
    public gamm_Button.Button btnActualizarPerfil;
    public gamm_Button.Button btnActualizarTrabajador;
    public gamm_Button.Button btnActualizarVale;
    public gamm_Button.Button btnCancelarCargo;
    public gamm_Button.Button btnCancelarEmpresa;
    public gamm_Button.Button btnEstadoPerfil;
    public gamm_Button.Button btnHabilitar;
    public gamm_Button.Button btnModificarEmpresa;
    public gamm_Button.Button btnRegistrarCargo;
    public gamm_Button.Button btnRegistrarGuardia;
    public gamm_Button.Button btnRegistrarLicencia;
    public gamm_Button.Button btnRegistrarPerfilLaboral;
    public gamm_Button.Button btnRegistrarTipoVehiculo;
    public gamm_Button.Button btnRegistrarTrabajador;
    public gamm_Button.Button btnRegistrarVale;
    public gamm_Button.Button btnRegistrarVehiculo;
    public gamm_Button.ButtonLine btnSeleccionarCargo;
    public gamm_Button.ButtonLine btnSeleccionarGuardiaVale;
    public gamm_Button.ButtonLine btnSeleccionarLogo;
    public gamm_Button.Button btnSeleccionarTipoVehiculo;
    public gamm_Button.ButtonLine btnSeleccionarTrabajadorLicencia;
    public gamm_Button.ButtonLine btnSeleccionarTrabajadorPerfil;
    public gamm_Button.ButtonLine btnSeleccionarTrabajadorVale;
    public gamm_Button.Button btnSeleccionarTurno;
    public gamm_Button.ButtonLine btnSeleccionarVehiculoVale;
    public gamm_ComboBox.Combobox cboArea;
    public gamm_ComboBox.Combobox cboCategoriaLicencia;
    public gamm_ComboBox.Combobox cboFiltrarContratoPor;
    public gamm_ComboBox.Combobox cboFiltrarTrabajadorPor;
    public gamm_ComboBox.Combobox cboMarcaVehiculo;
    public gamm_CheckBox.CheckBox ckbAgregarCelular;
    public gamm_CheckBox.CheckBox ckbDarkMode;
    public gamm_DateChooser.DateChooser fechaAbastecimientoVale;
    public gamm_DateChooser.DateChooser fechaCaducidad;
    public gamm_DateChooser.DateChooser fechaCese;
    public gamm_DateChooser.DateChooser fechaCompra;
    public gamm_DateChooser.DateChooser fechaEmision;
    public gamm_DateChooser.DateChooser fechaIngreso;
    public gamm_DateChooser.DateChooser fechaNacimiento;
    public gamm_Panel.MenuItem itemCargos;
    public gamm_Panel.MenuItem itemCargos4;
    public gamm_Panel.MenuItem itemEquipos;
    public gamm_Panel.MenuItem itemGuardias;
    public gamm_Panel.MenuItem itemInicio;
    public gamm_Panel.MenuItem itemTrabajadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCategoria;
    public javax.swing.JLabel lblEquipos;
    private javax.swing.JLabel lblEstadoCivil;
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
    public javax.swing.JLabel mFechaAbastecimiento;
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
    public javax.swing.JLabel mGuardiaSeleccionadaVale;
    public javax.swing.JLabel mHoraAbastecimiento;
    public javax.swing.JLabel mHorometroVale;
    public javax.swing.JLabel mIdVehiculo;
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
    public javax.swing.JLabel mTrabajadorAsignadoVale;
    public javax.swing.JLabel mTurno;
    public javax.swing.JLabel mVehiculoAsignadoVale;
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
    public javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlCabecera;
    public gamm_Panel.TabbedPane pnlCargo;
    public gamm_Panel.RoundedPanel pnlCesamientoTrabajador;
    public javax.swing.JPanel pnlDatosEmpresa;
    private gamm_Panel.RoundedPanel pnlDatosPersonales;
    private gamm_Panel.RoundedPanel pnlFotoTrabajador;
    public gamm_Panel.RoundedPanel pnlInfoEmpresa;
    private gamm_Panel.RoundedPanel pnlInformacionAcademica;
    private gamm_Panel.RoundedPanel pnlInformacionCargo;
    public javax.swing.JPanel pnlInformacionEmpresa;
    private gamm_Panel.RoundedPanel pnlInformacionVehiculo;
    public gamm_Panel.TabbedPane pnlInicio;
    private javax.swing.JPanel pnlItems;
    private javax.swing.JPanel pnlListaCargos;
    public javax.swing.JPanel pnlMenu;
    public gamm_Panel.TabbedPane pnlOpciones;
    public javax.swing.JPanel pnlRegistrarCargo;
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
    private gamm_Panel.RoundedPanel roundedPanel23;
    private gamm_Panel.RoundedPanel roundedPanel3;
    private gamm_Panel.RoundedPanel roundedPanel4;
    private gamm_Panel.RoundedPanel roundedPanel5;
    private gamm_Panel.RoundedPanel roundedPanel6;
    private gamm_Panel.RoundedPanel roundedPanel7;
    public gamm_Panel.RoundedPanel roundedPanel8;
    private gamm_Panel.RoundedPanel roundedPanel9;
    private gamm_Panel.TabbedPane tabbedPane1;
    private gamm_Panel.TabbedPane tabbedPane2;
    public javax.swing.JTable tblCargos;
    public javax.swing.JTable tblGuardias;
    public javax.swing.JTable tblLicencias;
    public javax.swing.JTable tblListaCargos;
    public javax.swing.JTable tblListaContratos;
    public javax.swing.JTable tblListaTrabajadores;
    public javax.swing.JTable tblPerfilLaboral;
    public javax.swing.JTable tblTipoVehiculo;
    public javax.swing.JTable tblTrabajadores;
    public javax.swing.JTable tblTurnos;
    public javax.swing.JTable tblVale;
    public javax.swing.JTable tblVehiculos;
    public gamm_TextField.TextField txtApeMaterno;
    public gamm_TextField.TextField txtApePaterno;
    public gamm_TextField.TextField txtAño;
    public gamm_TextField.TextField txtBusquedaTrabajador;
    public gamm_TextField.TextField txtCargoAsignado;
    public gamm_TextField.TextField txtCelularEmpresaDatos;
    public gamm_TextField.TextField txtCelularUpdate;
    public gamm_TextField.TextField txtCiiuDatos;
    public gamm_TextField.TextField txtCiiuUpdate;
    public javax.swing.JTextField txtCodCargo;
    public javax.swing.JLabel txtCodCargoAsignado;
    public javax.swing.JLabel txtCodGuardia;
    public javax.swing.JLabel txtCodGuardiaAsignadaVale;
    public javax.swing.JLabel txtCodLicencia;
    public javax.swing.JLabel txtCodPerfilLaboral;
    public javax.swing.JLabel txtCodTipoVehiculo;
    public javax.swing.JLabel txtCodTipoVehiculoAsignado;
    public javax.swing.JLabel txtCodTurno;
    public gamm_TextField.TextField txtCodVale;
    public javax.swing.JLabel txtCodVehiculoAsignadoVale;
    public gamm_TextField.TextField txtDireccion;
    public gamm_TextField.TextField txtDireccionEmpresaDatos;
    public gamm_TextField.TextField txtDireccionUpdate;
    public gamm_TextField.TextField txtDni;
    public gamm_TextField.TextField txtEmailEmpresaDatos;
    public gamm_TextField.TextField txtEmailUpdate;
    public gamm_TextField.TextField txtFechaAbastecimiento;
    public gamm_TextField.TextField txtFechaCaducidad;
    public gamm_TextField.TextField txtFechaCese;
    public gamm_TextField.TextField txtFechaCompra;
    public gamm_TextField.TextField txtFechaEmsion;
    public gamm_TextField.TextField txtFechaIngreso;
    public gamm_TextField.TextField txtFechaNacimiento;
    public gamm_TextField.TextField txtFiltrarTrabajadorLicencia;
    public gamm_TextField.TextField txtFiltrarTrabajadorPerfil;
    public gamm_TextField.TextField txtFiltroContratoLista;
    public gamm_TextField.TextField txtFiltroTipoVehiculo;
    public gamm_TextField.TextField txtFiltroTrabajadorLista;
    public gamm_TextField.TextField txtGalonesVale;
    public gamm_TextField.TextField txtGuardiaSeleccionadaVale;
    public gamm_TextField.TextField txtHoraAbastecimiento;
    public gamm_TextField.TextField txtHoraEntrada;
    public gamm_TextField.TextField txtHoraSalida;
    public gamm_TextField.TextField txtHorometroVale;
    public javax.swing.JTextField txtIdEmpresaDatos;
    public javax.swing.JTextField txtIdEmpresaUpdate;
    public javax.swing.JTextField txtIdTrabajador;
    public javax.swing.JLabel txtIdTrabajadorLicencia;
    public javax.swing.JLabel txtIdTrabajadorPerfil;
    public javax.swing.JLabel txtIdTrabajadorVale;
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
    public gamm_TextField.TextField txtTipoVehiculo;
    public gamm_TextField.TextField txtTipoVehiculoAsignado;
    public gamm_TextField.TextField txtTrabajadorAsignadoLicencia;
    public gamm_TextField.TextField txtTrabajadorAsignadoPerfil;
    public gamm_TextField.TextField txtTrabajadorAsignadoVale;
    public gamm_TextField.TextField txtTurno;
    public gamm_TextField.TextField txtTurnoSeleccionado;
    public gamm_TextField.TextField txtVehiculoSeleccionadoVale;
    // End of variables declaration//GEN-END:variables
}
