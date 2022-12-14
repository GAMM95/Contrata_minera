package Controllers;

import Models.*;
import Views.*;

import gamm_DateChooser.SelectedAction;
import gamm_DateChooser.SelectedDate;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class MenuController implements MouseListener, ActionListener {

    //  Instancias de clases
    Rol tu = new Rol();
    Usuario us = new Usuario();
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

    private FrmMenu frmMenu;

    public MenuController(FrmMenu frmMenu) {
        this.frmMenu = frmMenu;

//        frmMenu.setResizable(false);
        frmMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frmMenu.TitleBarMenu.init(frmMenu);
        diseñoFormulario();
        popupFechas();
        controllers();
        interfaces();
    }

    //  Superconstructor
    public MenuController(FrmMenu frmMenu, Usuario us, Rol tu) {
        this.frmMenu = frmMenu;
        controllers();
    }

    //  Metodo para llamar a los controladores
    private void controllers() {
        CargoController cargoControl = new CargoController(ca, caDAO, frmMenu);
        TrabajadorController trabajadorControl = new TrabajadorController(tra, traDAO, frmMenu);
        PerfilLaboralController perfilLaboralControl = new PerfilLaboralController(plab, plabDAO, frmMenu);
        LicenciaController licenciaControl = new LicenciaController(lic, licDAO, frmMenu);
        TipoVehiculoController tvControl = new TipoVehiculoController(tv, tvDAO, frmMenu);
        VehiculoController veControl = new VehiculoController(ve, veDAO, frmMenu);
        GuardiaController guaControl = new GuardiaController(tur, turDAO, gua, guaDAO, frmMenu);
        ValeController valeContrl = new ValeController(vale, valeDAO, frmMenu);
        EmpresaController empresaControl = new EmpresaController(em, emDAO, frmMenu);
    }

    // Efecto popup de fechas
    private void popupFechas() {
//        frmMenu.fechaNacimiento.addEventDateChooser(new EventDateChooser() {
        frmMenu.fechaNacimiento.addEventDateChooser((SelectedAction action, SelectedDate date) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaNacimiento.hidePopup();
            }
        });
        //  Efecto popup para las fechas de ingreso laboral
        frmMenu.fechaIngreso.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaIngreso.hidePopup();
            }
        });
        //  Efecto popup para las fechas de cese laboral
        frmMenu.fechaCese.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaCese.hidePopup();
            }
        });
        //  Efecto popup para fecha de emision de licencias
        frmMenu.fechaEmision.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaEmision.hidePopup();
            }
        });
        //  Efecto popup para la fecha de caducidad de licencias
        frmMenu.fechaCaducidad.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaCaducidad.hidePopup();
            }
        });
        //  Efecto popup para la fecha de abastecimiento
        frmMenu.fechaAbastecimientoVale.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaAbastecimientoVale.hidePopup();
            }
        });
    }

    //  metodo de implementacion de interfaces
    private void interfaces() {
        //  MouseListener events
        frmMenu.itemInicio.addMouseListener(this);
        frmMenu.itemTrabajadores.addMouseListener(this);
        frmMenu.itemMaquinaria.addMouseListener(this);
        frmMenu.itemEquipos.addMouseListener(this);
        frmMenu.itemGuardias.addMouseListener(this);

        //  ActionListener  events
        frmMenu.ckbDarkMode.addActionListener(this);
        frmMenu.btnSeleccionarCargo.addActionListener(this);
        frmMenu.btnSeleccionarTrabajadorPerfil.addActionListener(this);
        frmMenu.btnSeleccionarTrabajadorLicencia.addActionListener(this);
        frmMenu.btnSeleccionarTrabajadorVale.addActionListener(this);
        frmMenu.btnSeleccionarGuardiaVale.addActionListener(this);
        frmMenu.btnSeleccionarVehiculoVale.addActionListener(this);
    }

    private void diseñoFormulario() {
        frmMenu.setLocationRelativeTo(null);
        frmMenu.setTitle("Contrata Minera S.A.C.");

        frmMenu.lblInicio.setForeground(Color.white);
        frmMenu.lblCargo.setForeground(Color.white);
        frmMenu.lblTrabajadores.setForeground(Color.white);
        frmMenu.lblEquipos.setForeground(Color.white);
        frmMenu.lblGuardias.setForeground(Color.white);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  Evento MouseClicked para los items del panel menu
        if (e.getSource().equals(frmMenu.itemInicio)) { //  
            frmMenu.pnlOpciones.setSelectedIndex(0);
        } else if (e.getSource().equals(frmMenu.itemTrabajadores)) {
            frmMenu.pnlOpciones.setSelectedIndex(1);
        } else if (e.getSource().equals(frmMenu.itemMaquinaria)) {
            frmMenu.pnlOpciones.setSelectedIndex(2);
        } else if (e.getSource().equals(frmMenu.itemEquipos)) {
            frmMenu.pnlOpciones.setSelectedIndex(3);
        } else if (e.getSource().equals(frmMenu.itemGuardias)) {
            frmMenu.pnlOpciones.setSelectedIndex(4);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento ActionPerformed para activar el modo oscuro
        if (e.getSource().equals(frmMenu.ckbDarkMode)) {
            DarkMode dm = new DarkMode(frmMenu);
            if (frmMenu.ckbDarkMode.isSelected()) {
                dm.activateDarkMode();
            } else {
                dm.deactivateDarkMode();
            }
        }
        //  Evento ActionListener para seleccionar cargo
        if (e.getSource().equals(frmMenu.btnSeleccionarCargo)) {
            DSelectorCargo dsc = new DSelectorCargo(); // instancia del dialog
            dsc.setVisible(true); // mostrar dialog
            Cargo c = dsc.cargoSelected;
            try {
                // Seteo de datos
                frmMenu.txtCodCargoAsignado.setText(String.valueOf(c.getCodigo()));
                frmMenu.txtCargoAsignado.setText(c.getNombreCargo());
            } catch (Exception ex) {
                //  Mostrar mensajes de error
                frmMenu.mCargoAsignado.setText("No se realizó selección");
                frmMenu.mCargoAsignado.setForeground(Color.red);
                dsc.dispose(); // cerrar dialog
            }
        }
        // Evento ActionListener para seleccionar Trabajador
        if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorPerfil)) {
            DSelectorTrabajador dst = new DSelectorTrabajador(); // instancia del dialog
            dst.setVisible(true); // abrir dialog selector
            tra = dst.trabajadorSelected;
            try {
                //  Seteo de datos
                frmMenu.txtIdTrabajadorPerfil.setText(String.valueOf(tra.getIdTrabajador()));
                frmMenu.txtTrabajadorAsignadoPerfil.setText(tra.getApePaterno());
            } catch (Exception ex) {
                //  Mostrar mensajes de error
                frmMenu.mTrabajadorAsignadoPerfil.setText("No se realizó selección");
                frmMenu.mTrabajadorAsignadoPerfil.setForeground(Color.red);
                dst.dispose(); // Cerrar dialog
            }
        } else if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorLicencia)) {
            DSelectorTrabajador dst = new DSelectorTrabajador(); // instancia del dialog
            dst.setVisible(true); // abrir dialog selector
            tra = dst.trabajadorSelected;
            try {
                //  Seteo de datos
                frmMenu.txtIdTrabajadorLicencia.setText(String.valueOf(tra.getIdTrabajador()));
                frmMenu.txtTrabajadorAsignadoLicencia.setText(tra.getApePaterno());
            } catch (Exception ex) {
                //  Mostrar mensajes de error
                frmMenu.mTrabajadorAsignadoLicencia.setText("No se realizó selección");
                frmMenu.mTrabajadorAsignadoLicencia.setForeground(Color.red);
                dst.dispose(); // cerrar dialog
            }
        } else if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorVale)) {
            DSelectorTrabajador dst = new DSelectorTrabajador(); // instancia del dialog
            dst.setVisible(true);  // abrir dialog selector
            tra = dst.trabajadorSelected;
            try {
                //  Seteo de datos
                frmMenu.txtIdTrabajadorVale.setText(String.valueOf(tra.getIdTrabajador()));
                frmMenu.txtTrabajadorAsignadoVale.setText(tra.getApePaterno());
            } catch (Exception ex) {
                //  Mostrar mensajes de error
                frmMenu.mTrabajadorAsignadoVale.setText("No se realizó selección");
                frmMenu.mTrabajadorAsignadoVale.setForeground(Color.red);
                dst.dispose(); // cerrar dialog
            }
        }
        //  Evento ActionListener para abrir el selector de guardias
        if (e.getSource().equals(frmMenu.btnSeleccionarGuardiaVale)) {
            DSelectorGuardia dsg = new DSelectorGuardia(); // instancia del dialog
            dsg.setVisible(true); // abrir dialog selector
            gua = dsg.guardiaSelected;
            tur = dsg.turnoSelected;
            try {
                //  Seteo de datos
                frmMenu.txtCodGuardiaAsignadaVale.setText(String.valueOf(gua.getCodGuardia()));
                frmMenu.txtGuardiaSeleccionadaVale.setText(gua.getNombreGuardia());
                frmMenu.txtTurnoSeleccionado.setText(tur.getNombreTurno());
            } catch (Exception ex) {
                //  Mostrar mensajes de error 
                frmMenu.mGuardiaSeleccionadaVale.setText("No se realizó selección");
                frmMenu.mGuardiaSeleccionadaVale.setForeground(Color.red);
                dsg.dispose(); // cerrar dialog
            }
        }
        //  Evento ActionListener para abrir el selector de vehiculos
        if (e.getSource().equals(frmMenu.btnSeleccionarVehiculoVale)) {
            DSelectorVehiculo dsv = new DSelectorVehiculo();
            dsv.setVisible(true); // abrir dialog selector
            ve = dsv.vehiculoSelected;
            try {
                //  Seteo de datos
                frmMenu.txtCodVehiculoAsignadoVale.setText(String.valueOf(ve.getCodVehiculo()));
                frmMenu.txtVehiculoSeleccionadoVale.setText(ve.getIdVehiculo());
            } catch (Exception ex) {
                //  Mostrar mensajes de error 
                frmMenu.mVehiculoAsignadoVale.setText("No se realizó selección");
                frmMenu.mVehiculoAsignadoVale.setForeground(Color.red);
                dsv.dispose(); // cerrar dialog
            }
        }
    }
}
