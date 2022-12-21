package Models;

import java.awt.*;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorearLabels extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearLabels(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Font font = new Font("Dialog", Font.BOLD, 14);
        JLabel lblResultado = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (value instanceof String) {
            String estado = (String) value;
            if (estado.equals("Activo")) {
                lblResultado.setForeground(Color.blue);
                lblResultado.setBackground(Color.decode("#FFFD95"));
                lblResultado.setFont(font);
            } else {
                if (estado.equals("Inactivo")) {
                    lblResultado.setForeground(Color.red);
                    lblResultado.setBackground(Color.white);
                    lblResultado.setFont(font);
                }
            }
        }
        if (value instanceof String) {
            String suspension = (String) value;
            if ((!suspension.equals("Inactivo")) && (!suspension.equals("Activo"))) {
                lblResultado.setForeground(Color.red);
                lblResultado.setFont(font);
            } else {
                if (suspension.equals("")) {
                    lblResultado.setForeground(Color.white);
                    lblResultado.setFont(font);
                }
            }
        }
        if (value instanceof Date) {
            Date suspension = (Date) value;
            if (!suspension.equals("")) {
                lblResultado.setForeground(Color.red);
                lblResultado.setFont(font);
            } else {
                if (suspension.equals("")) {
                    lblResultado.setForeground(Color.white);
                    lblResultado.setFont(font);
                } else if (suspension.equals("null")) {
                    lblResultado.setText("");
                }
            }
        }
        if (value instanceof Date) {
            Date fechaCaducidad = (Date) value;
            Date hoy = new Date(); // fecha actual
            if (fechaCaducidad.before(hoy) || fechaCaducidad.equals(hoy)) {
                lblResultado.setForeground(Color.red);
                lblResultado.setFont(font);
            } else {
                if (fechaCaducidad.after(hoy)) {
                    lblResultado.setForeground(Color.blue);
                    lblResultado.setFont(font);
                }
            }
        }
        setHorizontalAlignment(SwingConstants.CENTER);
        return this;
    }
}
