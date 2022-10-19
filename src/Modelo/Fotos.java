package Modelo;

import java.sql.Blob;

public class Fotos {
    private int id;
    private String nombre;
    private Blob foto;
    private String estado;

    public Fotos() {
    }

    public Fotos(int id, String nombre, Blob foto, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.estado = estado;
    }

    public Fotos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 

}
