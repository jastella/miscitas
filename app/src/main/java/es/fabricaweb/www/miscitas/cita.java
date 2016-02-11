package es.fabricaweb.www.miscitas;

import java.util.Date;
import java.util.Timer;

/**
 * Created by Jorge on 07/02/2016.
 */
public class cita {

    private String nombreGestor;
    private String nombreAgenda;
    private String fecha;
    private String hora;
    private String nota;

    public cita(String nota, String nombreGestor, String nombreAgenda, String hora, String fecha) {
        this.nota = nota;
        this.nombreGestor = nombreGestor;
        this.nombreAgenda = nombreAgenda;
        this.hora = hora;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombreAgenda() {
        return nombreAgenda;
    }

    public void setNombreAgenda(String nombreAgenda) {
        this.nombreAgenda = nombreAgenda;
    }

    public String getNombreGestor() {
        return nombreGestor;
    }

    public void setNombreGestor(String nombreGestor) {
        this.nombreGestor = nombreGestor;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
