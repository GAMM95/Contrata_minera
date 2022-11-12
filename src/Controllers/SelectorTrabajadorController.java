package Controllers;

import Models.Trabajador;
import Models.TrabajadorDAO;
import Views.DSelectorTrabajador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;

public class SelectorTrabajadorController implements ActionListener, KeyListener {

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
        interfaces();
        mostrarTrabajadores();
    }

    //  Metodo de diseño de Dialog
    private void diseñoDialog() {
        dst.setLocationRelativeTo(null);
    }

    //  Metodo para incorporar interfaces
    private void interfaces() {
        //  Eventos ActionListener
        dst.btnCerrar.addActionListener(this);
        //  Eventos KeyListener
        dst.txtBusqueda.addKeyListener(this);
    }

    private void mostrarTrabajadores(){
        traDAO.listarTrabajadoresDialog(modelo);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(dst.btnCerrar)) {
            dst.dispose();
        }
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
