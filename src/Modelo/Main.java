package Modelo;

import Vista.FrmLogin;
import Vista.FrmMenu;

public class Main {

    public static void main(String[] args) {
        FrmLogin abrir = new FrmLogin();    //  Llamada al formulario inicial
//        FrmMenu abrir = new FrmMenu();
        abrir.setVisible(true);
    }
}
