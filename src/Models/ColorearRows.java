package Models;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorearRows extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearRows(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Font font = new Font("Dialog", Font.PLAIN, 14);
        JLabel lblResultado = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (table.getValueAt(row, 4).toString().equals("No")) {
            setBackground(Color.red);
            setForeground(Color.white);
            if (isSelected) {
//                setBackground(Color.decode("#FFFF99"));
                setBackground(Color.decode("#CCFFFF"));
                setForeground(Color.red);
            }
        } else if (table.getValueAt(row, 4).toString().equals("Si")) {
            setBackground(Color.white);
            setForeground(Color.black);
            if (isSelected) {
//                setBackground(Color.decode("#FFFF99"));
                setBackground(Color.decode("#CCFFFF"));
                setForeground(Color.black);
            }
        }

        setHorizontalAlignment(SwingConstants.CENTER);
        return this;
    }
}
