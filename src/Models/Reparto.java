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

    public Reparto(int codReparto, Date fechaReparto, Guardia guardia, Trabajador trabajador, Vehiculo vehiculo, String asistencia) {
        this.codReparto = codReparto;
        this.fechaReparto = fechaReparto;
        this.guardia = guardia;
        this.trabajador = trabajador;
        this.vehiculo = vehiculo;
        this.asistencia = asistencia;
    }

    // Metodos Getter and Setter
    public int getCodReparto() {
        return codReparto;
    }

    public void setCodReparto(int codReparto) {
        this.codReparto = codReparto;
    }

    public Date getFechaReparto() {
        return fechaReparto;
    }

    public void setFechaReparto(Date fechaReparto) {
        this.fechaReparto = fechaReparto;
    }

    public Guardia getGuardia() {
        return guardia;
    }

    public void setGuardia(Guardia guardia) {
        this.guardia = guardia;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public int getCodGuardia() {
        return codGuardia;
    }

    public void setCodGuardia(int codGuardia) {
        this.codGuardia = codGuardia;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getCodVehiculo() {
        return codVehiculo;
    }

    public void setCodVehiculo(int codVehiculo) {
        this.codVehiculo = codVehiculo;
    }

}
