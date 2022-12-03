/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author GAMM95
 */
public class Turno {

    //  Atributos de clase
    private int codTurno;
    private String nombreTurno;
    private String horaEntrada;
    private String horaSalida;

    //  Constructor vacio
    public Turno() {
    }

    public Turno(String nombreTurno, String horaEntrada, String horaSalida) {
        this.nombreTurno = nombreTurno;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    //  Metodos Getter % Setter
    public int getCodTurno() {
        return codTurno;
    }

    public void setCodTurno(int codTurno) {
        this.codTurno = codTurno;
    }

    public String getNombreTurno() {
        return nombreTurno;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

}
