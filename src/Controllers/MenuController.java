package Controllers;

import Models.DarkMode;
import Views.FrmMenu;
import gamm_DateChooser.EventDateChooser;
import gamm_DateChooser.SelectedAction;
import gamm_DateChooser.SelectedDate;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuController implements MouseListener, ActionListener {
    
    private FrmMenu frmMenu;
    
    public MenuController(FrmMenu frmMenu) {
        this.frmMenu = frmMenu;
        interfaces();
//        frmMenu.TitleBarMenu.init(frmMenu);
        diseñoFormulario();
        //  Efecto Popup de los datechooser
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
        
    }

    //  metodo de implementacion de interfaces
    private void interfaces() {
        //  MouseListener events
        frmMenu.itemInicio.addMouseListener(this);
        frmMenu.itemCargos.addMouseListener(this);
        frmMenu.itemTrabajadores.addMouseListener(this);
        frmMenu.itemEquipos.addMouseListener(this);
        frmMenu.itemGuardias.addMouseListener(this);
        //  ActionListener  events
        frmMenu.ckbDarkMode.addActionListener(this);
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
        if (e.getSource().equals(frmMenu.itemInicio)) {
            frmMenu.pnlOpciones.setSelectedIndex(0);
        } else if (e.getSource().equals(frmMenu.itemCargos)) {
            frmMenu.pnlOpciones.setSelectedIndex(1);
        } else if (e.getSource().equals(frmMenu.itemTrabajadores)) {
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
        if (e.getSource().equals(frmMenu.ckbDarkMode)) {
            DarkMode dm = new DarkMode(frmMenu);
            if (frmMenu.ckbDarkMode.isSelected()) {
                dm.activateDarkMode();
            } else {
                dm.deactivateDarkMode();
            }
        }
        
    }
}
