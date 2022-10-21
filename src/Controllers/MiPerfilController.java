package Controllers;

import Models.Usuario;
import Models.UsuarioDAO;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiPerfilController implements ActionListener {
    
    private final Usuario us;
    private final UsuarioDAO usDAO;
    private final FrmMenu frmMenu;
    
    public MiPerfilController(Usuario us, UsuarioDAO usDAO, FrmMenu frmMenu) {
        this.us = us;
        this.usDAO = usDAO;
        this.frmMenu = frmMenu;
        interfaces();
        diseñoPanel();
    }

    //  Metodo para integrar las interfaces implementadas
    private void interfaces() {
        
    }

    //  Metodo para tunnear el panel MiPerfil
    private void diseñoPanel() {
//        frmMenu.txtIdUsuario.setBackground(Color.white);
//        frmMenu.txtIdUsuario.setForeground(Color.white);
//        frmMenu.txtIdUsuario.setBorder(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
