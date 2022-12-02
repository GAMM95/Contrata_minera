package Models;

public class TipoVehiculo {

    //  Atributos de clase
    private int codTipo;
    private String nombreTipo;

    //  Constructor
    public TipoVehiculo() {
    }

    public TipoVehiculo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    //  Metodos Getter & Setter
    public TipoVehiculo(int codTipo, String nombreTipo) {
        this.codTipo = codTipo;
        this.nombreTipo = nombreTipo;
    }

    public int getCodTipo() {
        return codTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setCodTipo(int codTipo) {
        this.codTipo = codTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

}
