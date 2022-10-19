package Controlador;

import Vista.FrmMenu;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuController implements MouseListener{

    private FrmMenu frmMenu;

    public MenuController(FrmMenu frmMenu) {
        this.frmMenu = frmMenu;
        interfaces();
        diseñoFormulario();
    }

    //  metodo de implementacion de interfaces
    private void interfaces() {
        frmMenu.itemInicio.addMouseListener(this);
        frmMenu.itemCargos.addMouseListener(this);
        frmMenu.itemTrabajadores.addMouseListener(this);
        frmMenu.itemEquipos.addMouseListener(this);
    }

    private void diseñoFormulario() {
        frmMenu.setLocationRelativeTo(null);
        frmMenu.setTitle("Contrata Minera S.A.C.");

        frmMenu.lblInicio.setForeground(Color.white);
        frmMenu.lblCargo.setForeground(Color.white);
        frmMenu.lblTrabajadores.setForeground(Color.white);
        frmMenu.lblEquipos.setForeground(Color.white);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(frmMenu.itemInicio)) {
            frmMenu.pnlOpciones.setSelectedIndex(0);
        } else if (e.getSource().equals(frmMenu.itemCargos)){
            frmMenu.pnlOpciones.setSelectedIndex(1);
        }else if (e.getSource().equals(frmMenu.itemTrabajadores)){
            frmMenu.pnlOpciones.setSelectedIndex(2);
        }else if (e.getSource().equals(frmMenu.itemEquipos)) {
            frmMenu.pnlOpciones.setSelectedIndex(3);
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

}
