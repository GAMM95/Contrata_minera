package Models;

import Models.Rol;
import Models.Usuario;
import Views.FrmMenu;

public class DarkMode extends FrmMenu {
    
    //  Atributo
    private FrmMenu frmMenu;
    
    //  Constructor
    public DarkMode(FrmMenu frmMenu) {
        this.frmMenu = frmMenu;
        setDarkMode();
    }

    //  Superconstructor
    public DarkMode(FrmMenu frmMenu, Usuario us, Rol tu) {
        super(us, tu);
        this.frmMenu = frmMenu;
        setDarkMode();
    }
    
    private void setDarkMode(){
        
    }
    
}
