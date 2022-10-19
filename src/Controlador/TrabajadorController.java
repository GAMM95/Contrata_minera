package Controlador;

import Modelo.Trabajador;
import Modelo.TrabajadorDAO;
import Vista.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrabajadorController implements ActionListener{

    //  Instancias de clases
    private Trabajador tra;
    private TrabajadorDAO traDAO;
    private FrmMenu frmMenu;

    public TrabajadorController(Trabajador tra, TrabajadorDAO traDAO, FrmMenu frmMenu) {
        this.tra = tra;
        this.traDAO = traDAO;
        this.frmMenu = frmMenu;
        interfaces();
        diseñoPanel();
    }

    //  Metodo para incorporar las interfaces implementadas
    private void interfaces(){
        
    }
    //  Metodo de diseño del panel Trabajador
    private void diseñoPanel(){
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
