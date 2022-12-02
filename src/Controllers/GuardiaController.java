package Controllers;

import Models.CentrarColumnas;
import Models.Guardia;
import Models.GuardiaDAO;
import Models.Turno;
import Models.TurnoDAO;
import Views.FrmMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class GuardiaController implements ActionListener {

    //  instancias de clases
    private Turno tur;
    private TurnoDAO turDAO;
    private Guardia gua;
    private GuardiaDAO guaDAO;
    private FrmMenu frmMenu;

    //  Constructor
    public GuardiaController(Turno tur, TurnoDAO turDAO, Guardia gua, GuardiaDAO guaDAO, FrmMenu frmMenu) {
        this.tur = tur;
        this.turDAO = turDAO;
        this.gua = gua;
        this.guaDAO = guaDAO;
        this.frmMenu = frmMenu;
        interfaces();
        cargarTurnos();
    }

    //  Metodo para listar turnos
    private void cargarTurnos() {
        int[] anchos = {8, 30, 30, 30}; //anchos de columnas 
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblTurnos.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblTurnos.getColumnCount(); i++) {
            frmMenu.tblTurnos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            frmMenu.tblTurnos.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        }
        turDAO.listarTurnos(model);
    }
    
    //  Metodo para cargar guardias
    

    //  Interfaces implementadas 
    private void interfaces() {
        //  Eventos ActionListener
        frmMenu.btnSeleccionarTurno.addActionListener(this);
        frmMenu.btnRegistrarGuardia.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento para el boton de seleccion de turno
        if (e.getSource().equals(frmMenu.btnSeleccionarTurno)) {
            int fila = frmMenu.tblTurnos.getSelectedRow();  // Seleccion de fila de la tabla
            //  Obtencion de datos de la tabla
            int codTurno = Integer.parseInt(frmMenu.tblTurnos.getValueAt(fila, 0).toString());
            String nombreTurno = frmMenu.tblTurnos.getValueAt(fila, 1).toString();
            String horaEntrada = frmMenu.tblTurnos.getValueAt(fila, 2).toString();
            String horaSalida = frmMenu.tblTurnos.getValueAt(fila, 3).toString();
            //  Seteo de datos en las entradas
            frmMenu.txtCodTurno.setText(String.valueOf(codTurno));
            frmMenu.txtTurno.setText(nombreTurno);
            frmMenu.txtHoraEntrada.setText(horaEntrada);
            frmMenu.txtHoraSalida.setText(horaSalida);
        }
    }

}
