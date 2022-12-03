package Models;

public class Guardia {

    //  Atributos de clase
    private int codGuardia;
    private String nombreGuardia;
    private int codTurno;

    private Turno turno;

    //  Constructor
    public Guardia() {
    }

    public Guardia(String nombreGuardia, int codTurno) {
        this.nombreGuardia = nombreGuardia;
        this.codTurno = codTurno;
    }

    public Guardia(String nombreGuardia, Turno turno) {
        this.nombreGuardia = nombreGuardia;
        this.turno = turno;
    }

    //  Metodos Getter & Setter
    public int getCodGuardia() {
        return codGuardia;
    }

    public void setCodGuardia(int codGuardia) {
        this.codGuardia = codGuardia;
    }

    public String getNombreGuardia() {
        return nombreGuardia;
    }

    public void setNombreGuardia(String nombreGuardia) {
        this.nombreGuardia = nombreGuardia;
    }

    public int getCodTurno() {
        return codTurno;
    }

    public void setCodTurno(int codTurno) {
        this.codTurno = codTurno;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

}
