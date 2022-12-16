package Models;

import java.util.Date;

public class Reparto {

    // Atributos de la clase
    private int codReparto;
    private Date fechaReparto;
    private Guardia guardia;
    private Trabajador trabajador;
    private Vehiculo vehiculo;
    private String asistencia;

    private int codGuardia;
    private int idTrabajador;
    private int codVehiculo;

    //  Constructores
    public Reparto() {
    }

    public Reparto(Date fechaReparto, String asistencia, int codGuardia, int idTrabajador, int codVehiculo) {
        this.fechaReparto = fechaReparto;
        this.asistencia = asistencia;
        this.codGuardia = codGuardia;
        this.idTrabajador = idTrabajador;
        this.codVehiculo = codVehiculo;
    }

}
