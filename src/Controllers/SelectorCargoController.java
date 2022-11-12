package Controllers;

import Models.Cargo;
import Models.CargoDAO;
import Views.DSelectorCargo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.table.DefaultTableModel;

public class SelectorCargoController implements ActionListener, KeyListener {

    //  Atributos de clase
    private CargoDAO caDAO;
    private DSelectorCargo dsc;

    // Creacion de objeto de cargo
    public Cargo cargoSelected;
    DefaultTableModel model = new DefaultTableModel();

    //  Constructor
    public SelectorCargoController(CargoDAO caDAO, DSelectorCargo dsc) {
        this.caDAO = caDAO;
        this.dsc = dsc;
        diseñoDialog();
        interfaces();

    }

    //  Diseño Dialog
    private void diseñoDialog() {
        dsc.setLocationRelativeTo(null);
    }

    //  Incorporacion de interfaces
    private void interfaces() {
        //  Eventos ActionListener
        dsc.btnCerrar.addActionListener(this);
        //  Eventos KeyListener
        dsc.txtBusqueda.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento actionlistener para boton cerrar
        if (e.getSource().equals(dsc.btnCerrar)) {
            dsc.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(dsc.txtBusqueda)) {
            String cargo = dsc.txtBusqueda.getText();
            caDAO.buscarCargo(cargo, model);
        }
    }
}
