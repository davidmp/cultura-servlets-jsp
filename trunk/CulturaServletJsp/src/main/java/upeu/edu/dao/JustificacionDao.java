/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import upeu.edu.to.JustificacionTo;
import upeu.edu.util.DBConn;

/**
 *
 * @author PC
 */
public class JustificacionDao extends DBConn {

    public int insertarJustificacion(JustificacionTo to) {
        int r = 0;
        try {
            getConexionDB();
            ps = con.prepareStatement("insert into cultura.cp_justificacion(fecha, justificacion, id_actividad, id_usuario) "
                    + "values (to_date(?,'yyyy-mm-dd'), ?, ?, ?)");
            ps.setString(1, to.getFecha());
            ps.setString(2, to.getJustificacion());
            ps.setInt(3, to.getId_actividad());
            ps.setInt(4, to.getId_usuario());

            if (ps.executeUpdate() == 1) {
                r = 1;
                System.out.println("Insertado!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return r;
    }

    public JustificacionTo buscarJustificacionId(String idJustificacion) {
        JustificacionTo justificacion = new JustificacionTo();
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cultura.cp_justificacion "
                    + "where id_justificacion=? ");
            ps.setInt(1, Integer.parseInt(idJustificacion));
            rs = ps.executeQuery();
            if (rs.next()) {
                justificacion.setId_justificacion(rs.getInt("id_justificacion"));
                justificacion.setFecha(rs.getString("fecha"));
                justificacion.setJustificacion(rs.getString("justificacion"));
                justificacion.setId_actividad(rs.getInt("id_actividad"));
                justificacion.setId_usuario(rs.getInt("id_usuario"));

            }
        } catch (Exception e) {
        }
        return justificacion;
    }

    public List reporteJustificacion() {   //list:return del mismo tipo
        List reporte = new ArrayList();
        JustificacionTo to;
        try {
            getConexionDB();


            ps = con.prepareStatement("select * from cultura.cp_justificacion ");
            rs = ps.executeQuery();
            while (rs.next()) {
                to = new JustificacionTo();
                to.setId_justificacion(rs.getInt("id_justificacion"));
                to.setFecha(rs.getString("fecha"));
                to.setJustificacion(rs.getString("justificacion"));
                to.setId_actividad(rs.getInt("id_actividad"));
                to.setId_usuario(rs.getInt("id_usuario"));
                
                reporte.add(to);


                System.out.println("Reportado..!");

            }
        } catch (Exception e) {
            System.out.println("Error en Reporte Justificacion..." + e.getMessage());
        } finally {
            getCerrarConexion();
        }
        return reporte;

    }

    public void eliminarRegistroJustificacion(int id_justificacion) {
        try {
            getConexionDB();
            ps = con.prepareStatement("Delete FROM cultura.cp_justificacion WHERE id_justificacion=? ");
            ps.setInt(1, id_justificacion);

            if (ps.executeUpdate() == 1) {

                System.out.println(" Eliminado");
            }
        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }

    public void actualizarDatosJustificacion(JustificacionTo to, int id_justificacion) {
        try {

            getConexionDB();
            ps = con.prepareStatement("update cultura.cp_justificacion set fecha=to_date(?,'yyyy-mm-dd'), justificacion=?, id_actividad=?,id_usuario=? WHERE id_justificacion=?");
            ps.setString(1, to.getFecha());
            ps.setString(2, to.getJustificacion());
            ps.setInt(3, to.getId_actividad());
            ps.setInt(4, to.getId_usuario());
            
            ps.setInt(5, id_justificacion);

            ps.executeUpdate();

            System.out.println("Actualizado");

        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }
}
