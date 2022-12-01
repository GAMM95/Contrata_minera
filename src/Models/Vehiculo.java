package Models;

import java.util.Date;

public class Vehiculo {

    //  Atributos de clase
    private int codVehiculo;
    private String idVehiculo;
    private String placa;
    private String modelo;
    private String marca;
    private Date fechaIngreso;
    private String año;
    private TipoVehiculo tipoVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(int codVehiculo, String idVehiculo, String placa, String modelo, String marca, Date fechaIngreso, String año, TipoVehiculo tipoVehiculo) {
        this.codVehiculo = codVehiculo;
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.fechaIngreso = fechaIngreso;
        this.año = año;
        this.tipoVehiculo = tipoVehiculo;
    }

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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}
