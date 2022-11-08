package Models;

import Models.Trabajador;
import java.util.Date;

public class PerfilLaboral {

    //  Atributos de la clase
    private int codPerfil;
    private Date fechaIngreso;
    private String area;
    private double sueldo;
    private Date fechaCese;
    private String motivoCese;
    private int idTrabajador;
    private Trabajador trabajador;

    //  Constructor vacio
    public PerfilLaboral() {
    }

    public PerfilLaboral(int codPerfil, Date fechaIngreso, String area, double sueldo, Date fechaCese, int idTrabajador) {
        this.codPerfil = codPerfil;
        this.fechaIngreso = fechaIngreso;
        this.area = area;
        this.sueldo = sueldo;
        this.fechaCese = fechaCese;
        this.idTrabajador = idTrabajador;
    }

    public PerfilLaboral(Date fechaIngreso, String area, double sueldo, Date fechaCese, String motivoCese, Trabajador trabajador, int idTrabajador) {
        this.fechaIngreso = fechaIngreso;
        this.area = area;
        this.sueldo = sueldo;
        this.fechaCese = fechaCese;
        this.motivoCese = motivoCese;
        this.trabajador = trabajador;
        this.idTrabajador = idTrabajador;
    }

    //  Metodo Getter y Setter
    public int getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(int codPerfil) {
        this.codPerfil = codPerfil;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getMotivoCese() {
        return motivoCese;
    }

    public void setMotivoCese(String motivoCese) {
        this.motivoCese = motivoCese;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

}
