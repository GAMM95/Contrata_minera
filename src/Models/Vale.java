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
    private Reparto reparto;

    private int codReparto;

    //  Constructores
    public Vale() {

    }

    public Vale(String codVale, Date fecha, String hora, String lugar, double horometro, double galones, Reparto reparto) {
        this.codVale = codVale;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.horometro = horometro;
        this.galones = galones;
        this.reparto = reparto;
    }

    public Vale(String codVale, Date fecha, String hora, String lugar, double horometro, double galones, int codReparto) {
        this.codVale = codVale;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.horometro = horometro;
        this.galones = galones;
        this.codReparto = codReparto;
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

    public Reparto getReparto() {
        return reparto;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public int getCodReparto() {
        return codReparto;
    }

    public void setCodReparto(int codReparto) {
        this.codReparto = codReparto;
    }

}
