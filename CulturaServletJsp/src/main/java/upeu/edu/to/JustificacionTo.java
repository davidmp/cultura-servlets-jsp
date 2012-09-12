/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.to;

/**
 *
 * @author PC
 */
public class JustificacionTo {
    
    int id_justificacion;
    String fecha;
    String justificacion;
    int id_actividad;
    int id_usuario;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_justificacion() {
        return id_justificacion;
    }

    public void setId_justificacion(int id_justificacion) {
        this.id_justificacion = id_justificacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }
    
    
    
    
    
}
