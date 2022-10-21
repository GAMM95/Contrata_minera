package Models;

public class Cargo {

    //  Atributos de clase
    private int codigo;
    private String nombreCargo;
    private String categoria;

    //  Constructor vacio
    public Cargo() {
    }

    //  Sobrecarga de constructores
    public Cargo(int codigo) {
        this.codigo = codigo;
    }

    public Cargo(int codigo, String nombreCargo) {
        this.codigo = codigo;
        this.nombreCargo = nombreCargo;
    }

    public Cargo(String nombreCargo, String categoria) {
        this.nombreCargo = nombreCargo;
        this.categoria = categoria;
    }

    public Cargo(int codigo, String nombreCargo, String categoria) {
        this.codigo = codigo;
        this.nombreCargo = nombreCargo;
        this.categoria = categoria;
    }

    //  Metodos Getter and Setter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //  Metodo toString para el nombre del cargo
    @Override
    public String toString() {
        return this.getNombreCargo();
    }

}
