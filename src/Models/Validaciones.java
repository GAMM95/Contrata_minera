package Models;

import static com.sun.javafx.tk.Toolkit.getToolkit;

public class Validaciones {

    //  Metodo para validar el ingreso de solo digitos
    public static void soloDigitos(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit();
            evt.consume();
        }
    }

    //  Metodo para validar el ingreso de solo letras
    public static void soloLetras(java.awt.event.KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit();
            evt.consume();
        }
    }
}
