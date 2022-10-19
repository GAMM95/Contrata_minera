package Modelo;

import java.util.Date;

public class Trabajador {

    //  Atributos de la clase
    private int idTrabajador;
    private String dni;
    private String apePaterno;
    private String apeMaterno;
    private String nombres;
    private String sexo;
    private String estadoCivil;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String gradoInstruccion;
    private String profesion;
    private Cargo cargo;
    private int codCargo;

    //  Constructor vacio
    public Trabajador() {
    }

    public Trabajador(int idTrabajador, String trabajador) {
        this.idTrabajador = idTrabajador;
        trabajador = apePaterno + " " + apeMaterno + " " + nombres;
    }

    public Trabajador(String dni, String apePaterno, String apeMaterno, String nombres, String sexo, String estadoCivil, Date fechaNacimiento, String direccion, String telefono, String gradoInstruccion, String profesion, int codCargo) {
        this.dni = dni;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombres = nombres;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gradoInstruccion = gradoInstruccion;
        this.profesion = profesion;
        this.codCargo = codCargo;
    }

    public Trabajador(String dni, String apePaterno, String apeMaterno, String nombres, String sexo, String estadoCivil, Date fechaNacimiento, String direccion, String telefono, String gradoInstruccion, String profesion, Cargo cargo) {
        this.dni = dni;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombres = nombres;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gradoInstruccion = gradoInstruccion;
        this.profesion = profesion;
        this.cargo = cargo;
    }
    
    //  Metodos Getter and Setter

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGradoInstruccion() {
        return gradoInstruccion;
    }

    public void setGradoInstruccion(String gradoInstruccion) {
        this.gradoInstruccion = gradoInstruccion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }
    
}
