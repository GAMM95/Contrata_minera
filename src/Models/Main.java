package Models;

import Views.FrmLogin;
import Views.FrmMenu;
import Views.FrmMenu2;

public class Main {

    public static void main(String[] args) {
        FrmLogin abrir = new FrmLogin();    //  Llamada al formulario inicial
//        FrmMenu abrir = new FrmMenu();
//        FrmMenu2 abrir = new FrmMenu2();
        abrir.setVisible(true);
    }
}
