package Models;

import java.sql.Blob;

public class Usuario {

    //  Atributos de la clase
    private int idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String email;
    private String lastSesion;

    private Rol rol;

    private int idRol;
    private String nombreRol;

    private Blob foto;

    //  Constructor vacio de la clase
    public Usuario() {
    }

    //  Sobregarga del contructor - rol del usuario
    public Usuario(Rol rol) {
        this.rol = rol;
    }

    //  Sobrecarga de constructor
    public Usuario(int idUsuario, String username, String password, String nombre, String email, String lastSesion, Rol rol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.lastSesion = lastSesion;
        this.rol = rol;
    }

    public Usuario(String username, String password, String nombre, String email, int idRol) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.idRol = idRol;
    }

    //  Metodos Getter and Setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastSesion() {
        return lastSesion;
    }

    public void setLastSesion(String lastSesion) {
        this.lastSesion = lastSesion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

}
