package Models;

import java.util.Date;

public class Vehiculo {

    //  Atributos de clase
    private int codVehiculo;
    private String idVehiculo;
    private String placa;
    private String modelo;
    private String marca;
    private Date fechaCompra;
    private String año;
    private int codTipoVehiculo;

    private TipoVehiculo tipoVehiculo;

    //  Constructor
    public Vehiculo() {
    }

    public Vehiculo(String idVehiculo, String placa, String modelo, String marca, Date fechaCompra, String año, TipoVehiculo tipoVehiculo) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.fechaCompra = fechaCompra;
        this.año = año;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Vehiculo(String idVehiculo, String placa, String modelo, String marca, Date fechaCompra, String año, int codTipoVehiculo) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.fechaCompra = fechaCompra;
        this.año = año;
        this.codTipoVehiculo = codTipoVehiculo;
    }

    //  Metodos Getter & Setter
    public int getCodVehiculo() {
        return codVehiculo;
    }

    public void setCodVehiculo(int codVehiculo) {
        this.codVehiculo = codVehiculo;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getCodTipoVehiculo() {
        return codTipoVehiculo;
    }

    public void setCodTipoVehiculo(int codTipoVehiculo) {
        this.codTipoVehiculo = codTipoVehiculo;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
