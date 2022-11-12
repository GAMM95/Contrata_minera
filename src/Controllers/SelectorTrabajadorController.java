package Controllers;

import Models.Trabajador;
import Models.TrabajadorDAO;
import Views.DSelectorTrabajador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;

public class SelectorTrabajadorController implements KeyListener {

    public Trabajador trabajadorSelected;

    DefaultTableModel modelo = new DefaultTableModel();
    
    //  Atributos 
    private TrabajadorDAO traDAO;
    private DSelectorTrabajador dst;
    
    //  Constructor
    public SelectorTrabajadorController(Trabajador trabajadorSelected, TrabajadorDAO traDAO, DSelectorTrabajador dst) {
        this.trabajadorSelected = trabajadorSelected;
        this.traDAO = traDAO;
        this.dst = dst;
        diseñoDialog();
    }
    
    //  Metodo de diseño de Dialog
    private void diseñoDialog(){
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

}
