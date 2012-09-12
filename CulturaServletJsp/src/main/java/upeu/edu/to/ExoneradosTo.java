/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.to;

/**
 *
 * @author PC
 */
public class ExoneradosTo {
    
    String id_exonerados;
    String motivo;
    int id_alumno_periodo;
    int id_usuario;

    public int getId_alumno_periodo() {
        return id_alumno_periodo;
    }

    public void setId_alumno_periodo(int id_alumno_periodo) {
        this.id_alumno_periodo = id_alumno_periodo;
    }

    public String getId_exonerados() {
        return id_exonerados;
    }

    public void setId_exonerados(String id_exonerados) {
        this.id_exonerados = id_exonerados;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}
