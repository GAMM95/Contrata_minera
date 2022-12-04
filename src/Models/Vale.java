package Models;

import java.util.Date;

public class Vale {

    // Atributos de la clase
    private int idVale;
    private String codVale;
    private Date fecha;
    private String hora;
    private String lugar;
    private double horometro;
    private double galones;
    private Guardia guardia;
    private Trabajador trabajador;
    private Vehiculo vehiculo;

    private int codGuardia;
    private int idTrabajador;
    private int codVehiculo;

    //  Constructores
    public Vale() {

    }

    public Vale(String codVale, Date fecha, String hora, String lugar, double horometro, double galones, int codGuardia, int idTrabajador, int codVehiculo) {
        this.codVale = codVale;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.horometro = horometro;
        this.galones = galones;
        this.codGuardia = codGuardia;
        this.idTrabajador = idTrabajador;
        this.codVehiculo = codVehiculo;
    }

    public Vale(String codVale, Date fecha, String hora, String lugar, double horometro, double galones, Guardia guardia, Trabajador trabajador, Vehiculo vehiculo) {
        this.codVale = codVale;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.horometro = horometro;
        this.galones = galones;
        this.guardia = guardia;
        this.trabajador = trabajador;
        this.vehiculo = vehiculo;
    }

    //  Metodos Getter & Setter
    public int getIdVale() {
        return idVale;
    }

    public void setIdVale(int idVale) {
        this.idVale = idVale;
    }

    public String getCodVale() {
        return codVale;
    }

    public void setCodVale(String codVale) {
        this.codVale = codVale;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public double getHorometro() {
        return horometro;
    }

    public void setHorometro(double horometro) {
        this.horometro = horometro;
    }

    public double getGalones() {
        return galones;
    }

    public void setGalones(double galones) {
        this.galones = galones;
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
