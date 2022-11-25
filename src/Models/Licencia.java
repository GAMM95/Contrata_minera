package Models;

import java.sql.Date;

public class Licencia {

    //   Atributoss
    private int codLicencia;
    private String numLicencia;
    private String categoria;
    private Date fechaEmision;
    private Date fechaCaducidad;

    //  Constructor de clase
    public Licencia() {
    }

    public Licencia(String numLicencia, String categoria, Date fechaEmision, Date fechaCaducidad) {
        this.numLicencia = numLicencia;
        this.categoria = categoria;
        this.fechaEmision = fechaEmision;
        this.fechaCaducidad = fechaCaducidad;
    }

    //  Metodos Getter and Setter
    public int getCodLicencia() {
        return codLicencia;
    }

    public void setCodLicencia(int codLicencia) {
        this.codLicencia = codLicencia;
    }

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        this.numLicencia = numLicencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

}
