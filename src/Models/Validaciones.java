package Models;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Validaciones {

    // Método para validar el ingreso de solo dígitos
    public static void soloDigitos(KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (!Character.isDigit(validar)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    // Método para validar el ingreso de solo letras
    public static void soloLetras(KeyEvent evt) {
        char validar = evt.getKeyChar();
        if (!Character.isLetter(validar) && !Character.isWhitespace(validar)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
