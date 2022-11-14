package Models;

import Models.Rol;
import Models.Usuario;
import Views.FrmMenu;
import java.awt.Color;

public class DarkMode extends FrmMenu {

    //  Atributo
    private FrmMenu frmMenu;

    //  Constructor
    public DarkMode(FrmMenu frmMenu) {
        this.frmMenu = frmMenu;
        activateDarkMode();
        deactivateDarkMode();
    }

    //  Superconstructor
    public DarkMode(FrmMenu frmMenu, Usuario us, Rol tu) {
        super(us, tu);
        this.frmMenu = frmMenu;
        activateDarkMode();
        deactivateDarkMode();
    }

    //  Method to activate dark mode in panels
    public void activateDarkMode() {
        //  Menu Panels
        frmMenu.pnlMenu.setBackground(new Color(51, 51, 51));
        frmMenu.pnlBackground.setBackground(new Color(51,51,51));
        frmMenu.INICIO.setBackground(new Color(102, 102, 102));
        frmMenu.CARGOS.setBackground(new Color(102, 102, 102));
        frmMenu.TRABAJADORES.setBackground(new Color(102, 102, 102));
    }

    //  Method to deactivate dark mode in panels
    public void deactivateDarkMode() {
        
    }
    
}
