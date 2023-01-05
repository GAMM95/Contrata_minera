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
    Reparto re = new Reparto();
    RepartoDAO reDAO = new RepartoDAO();
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
        RepartoController repartoControl = new RepartoController(re, reDAO, frmMenu);
        ValeController valeControl = new ValeController(vale, valeDAO, frmMenu);
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
        //  Efecto popup para el filtro fecha de reparto
        frmMenu.fechaFiltroReparto.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaFiltroReparto.hidePopup();
            }
        });
        //  Efecto popup para la fecha de abastecimiento
        frmMenu.fechaAbastecimiento.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                frmMenu.fechaAbastecimiento.hidePopup();
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
        frmMenu.btnSeleccionarCargo.addActionListener(this);
        frmMenu.btnSeleccionarTrabajadorPerfil.addActionListener(this);
        frmMenu.btnSeleccionarTrabajadorLicencia.addActionListener(this);
        frmMenu.btnSeleccionarTrabajadorReparto.addActionListener(this);
        frmMenu.btnSeleccionarGuardiaReparto.addActionListener(this);
        frmMenu.btnSeleccionarVehiculoReparto.addActionListener(this);

        frmMenu.btnSeleccionarRepartoVale.addActionListener(this);
//        frmMenu.btnSeleccionarGuardiaVale.addActionListener(this);
//        frmMenu.btnSeleccionarVehiculoVale.addActionListener(this);
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

        //  Evento ActionListener para seleccionar cargo
        if (e.getSource().equals(frmMenu.btnSeleccionarCargo)) {
            DSelectorCargo dsc = new DSelectorCargo(); // instancia del dialog
            dsc.setVisible(true); // mostrar dialog
            ca = dsc.cargoSelected;
            try {
                // Seteo de datos
                frmMenu.txtCodCargoAsignado.setText(String.valueOf(ca.getCodigo()));
                frmMenu.txtCargoAsignado.setText(ca.getNombreCargo());
            } catch (Exception ex) {
                //  Mostrar mensajes de error
                frmMenu.mCargoAsignado.setText("No se realizó selección");
                frmMenu.mCargoAsignado.setForeground(Color.red);
                frmMenu.txtCodCargoAsignado.setText("");
                frmMenu.txtCargoAsignado.setText("");
                dsc.dispose(); // cerrar dialog
            }
        }
        // Evento ActionListener para seleccionar Trabajador
        if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorPerfil)) {
            DSelectorTrabajador dst = new DSelectorTrabajador(); // instancia del dialog
            dst.setVisible(true); // abrir dialog selector
            tra = dst.trabajadorSelected;
            ca = dst.cargoSelected;
            try {
                //  Seteo de datos
                frmMenu.txtIdTrabajadorPerfil.setText(String.valueOf(tra.getIdTrabajador()));
                frmMenu.txtTrabajadorAsignadoPerfil.setText(tra.getApePaterno());
                frmMenu.txtCargoAsignadoPerfil.setText(ca.getNombreCargo());
            } catch (Exception ex) {
                //  Mostrar mensajes de error
                frmMenu.mTrabajadorAsignadoPerfil.setText("No se realizó selección");
                frmMenu.mTrabajadorAsignadoPerfil.setForeground(Color.red);
                frmMenu.txtIdTrabajadorPerfil.setText("");
                frmMenu.txtTrabajadorAsignadoPerfil.setText("");
                frmMenu.txtCargoAsignadoPerfil.setText("");
                dst.dispose(); // Cerrar dialog
            }
        } else if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorLicencia)) {
            DSelectorTrabajador dst = new DSelectorTrabajador(); // instancia del dialog
            dst.setVisible(true); // abrir dialog selector
            tra = dst.trabajadorSelected;
            ca = dst.cargoSelected;
            try {
                //  Seteo de datos
                frmMenu.txtIdTrabajadorLicencia.setText(String.valueOf(tra.getIdTrabajador()));
                frmMenu.txtTrabajadorAsignadoLicencia.setText(tra.getApePaterno());
                frmMenu.txtCargoAsignadoLicencia.setText(ca.getNombreCargo());
            } catch (Exception ex) {
                //  Mostrar mensajes de error
                frmMenu.mTrabajadorAsignadoLicencia.setText("No se realizó selección");
                frmMenu.mTrabajadorAsignadoLicencia.setForeground(Color.red);
                frmMenu.txtIdTrabajadorLicencia.setText("");
                frmMenu.txtTrabajadorAsignadoLicencia.setText("");
                frmMenu.txtCargoAsignadoLicencia.setText("");
                dst.dispose(); // cerrar dialog
            }
        } else if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorReparto)) {
            DSelectorTrabajador dst = new DSelectorTrabajador(); // instancia del dialog
            dst.setVisible(true); // abrir dialog selector
            tra = dst.trabajadorSelected;
            ca = dst.cargoSelected;
            try {
                //  Seteo de datos
                frmMenu.txtIdTrabajadorReparto.setText(String.valueOf(tra.getIdTrabajador()));
                frmMenu.txtTrabajadorAsignadoReparto.setText(tra.getNombres());
                frmMenu.txtCargoSeleccionadoReparto.setText(ca.getNombreCargo());
            } catch (Exception ex) {
                //  Mostrar mensajes de error 
                frmMenu.mTrabajadorAsignadoReparto.setText("No se realizó selección");
                frmMenu.mTrabajadorAsignadoReparto.setForeground(Color.red);
                frmMenu.txtIdTrabajadorReparto.setText("");
                frmMenu.txtTrabajadorAsignadoReparto.setText("");
                frmMenu.txtCargoSeleccionadoReparto.setText("");
                dst.dispose(); // cerrar dialog
            }
        }
        //  Evento ActionListener para abrir el selector de guardias
        if (e.getSource().equals(frmMenu.btnSeleccionarGuardiaReparto)) {
            DSelectorGuardia dsg = new DSelectorGuardia(); // instancia del dialog
            dsg.setVisible(true); // abrir dialog selector
            gua = dsg.guardiaSelected;
            tur = dsg.turnoSelected;
            try {
                //  Seteo de datos
                frmMenu.txtCodGuardiaReparto.setText(String.valueOf(gua.getCodGuardia()));
                frmMenu.txtGuardiaSeleccionadaReparto.setText(gua.getNombreGuardia());
                frmMenu.txtTurnoSeleccionadoReparto.setText(tur.getNombreTurno());
            } catch (Exception ex) {
                //  Mostrar mensajes de error 
                frmMenu.mGuardiaSeleccionadaReparto.setText("No se realizó selección");
                frmMenu.mGuardiaSeleccionadaReparto.setForeground(Color.red);
                frmMenu.txtCodGuardiaReparto.setText("");
                frmMenu.txtGuardiaSeleccionadaReparto.setText("");
                frmMenu.txtTurnoSeleccionadoReparto.setText("");
                dsg.dispose(); // cerrar dialog
            }
        }
        //  Evento ActionListener para abrir el selector de vehiculos
        if (e.getSource().equals(frmMenu.btnSeleccionarVehiculoReparto)) {
            DSelectorVehiculo dsv = new DSelectorVehiculo();
            dsv.setVisible(true); // abrir dialog selector
            ve = dsv.vehiculoSelected;
            tv = dsv.tipoSelected;
            try {
                //  Seteo de datos
                frmMenu.txtCodVehiculoReparto.setText(String.valueOf(ve.getCodVehiculo()));
                frmMenu.txtVehiculoSeleccionadoReparto.setText(ve.getIdVehiculo());
                frmMenu.txtTipoSeleccionadoReparto.setText(tv.getNombreTipo());
            } catch (Exception ex) {
                //  Mostrar mensajes de error 
                frmMenu.mVehiculoSeleccionadoReparto.setText("No se realizó selección");
                frmMenu.mVehiculoSeleccionadoReparto.setForeground(Color.red);
                frmMenu.txtCodVehiculoReparto.setText("");
                frmMenu.txtVehiculoSeleccionadoReparto.setText("");
                frmMenu.txtTipoSeleccionadoReparto.setText("");
                dsv.dispose(); // cerrar dialog
            }
        }
        if (e.getSource().equals(frmMenu.btnSeleccionarRepartoVale)) {
            DSelectorReparto dsr = new DSelectorReparto();
            dsr.setVisible(true);
            re = dsr.repartoSelected;
            tra = dsr.trabajadorSelected;
            gua = dsr.guardiaSelected;
            tur = dsr.turnoSelected;
            ve = dsr.vehiculoSelected;
            try {
                frmMenu.txtCodRepartoVale.setText(String.valueOf(re.getCodReparto()));
                frmMenu.txtTrabajadorAsignadoVale.setText(tra.getNombres());
                frmMenu.txtGuardiaAsignadoVale.setText(gua.getNombreGuardia());
                frmMenu.txtTurnoAsignadoVale.setText(tur.getNombreTurno());
                frmMenu.txtVehiculoAsignadoVale.setText(ve.getIdVehiculo());
            } catch (Exception ex) {
                frmMenu.mRepartoAsignado.setText("No se realizó selección");
                frmMenu.mRepartoAsignado.setForeground(Color.red);
                frmMenu.txtCodRepartoVale.setText("");
                frmMenu.txtTrabajadorAsignadoVale.setText("");
                frmMenu.txtGuardiaAsignadoVale.setText("");
                frmMenu.txtTurnoAsignadoVale.setText("");
                frmMenu.txtVehiculoAsignadoVale.setText("");
                dsr.dispose(); // cerrar dialog
            }
        }
    }
}
