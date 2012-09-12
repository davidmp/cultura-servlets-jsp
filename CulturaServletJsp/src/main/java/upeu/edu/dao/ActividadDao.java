/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import upeu.edu.to.ActividadTo;
import upeu.edu.util.DBConn;

/**
 *
 * @author PC
 */
public class ActividadDao extends DBConn {

    public int insertarActividad(ActividadTo to) {
        int r = 0;
        try {
            getConexionDB();
            ps = con.prepareStatement("insert into "
                    + "cultura.cp_actividad(activ_tipo, descripcion, fecha, hora, id_periodo) "
                    + "values (?, ?, to_date(?,'yyyy-mm-dd') , ?, ?)");
            ps.setString(1, to.getActiv_tipo());
            ps.setString(2, to.getDescripcion());
            ps.setString(3, to.getFecha());
            ps.setString(4, to.getHora());
            ps.setInt(5, to.getId_periodo());


            if (ps.executeUpdate() == 1) {
                r = 1;
                System.out.println("Insertado!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return r;
    }
 
    public ActividadTo buscarActividadId(String idActividad) {

        ActividadTo actividad = new ActividadTo();
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cp_actividad "
                    + "where id_actividad=? ");
            ps.setInt(1, Integer.parseInt(idActividad));
            rs = ps.executeQuery();
            if (rs.next()) {
                actividad.setId_actividad(rs.getInt("id_actividad"));
                actividad.setActiv_tipo(rs.getString("activ_tipo"));
                actividad.setDescripcion(rs.getString("descripcion"));
                actividad.setFecha(rs.getString("fecha"));
                actividad.setHora(rs.getString("hora"));
                actividad.setId_periodo(rs.getInt("id_periodo"));
            }
        } catch (Exception e) {
        }
        return actividad;
    }

    public List reporteActividad() {   //list:return del mismo tipo
        List reporte = new ArrayList();
        ActividadTo to;
        try {
            getConexionDB();


            ps = con.prepareStatement("select * from cultura.cp_actividad ");
            rs = ps.executeQuery();
            while (rs.next()) {
                to = new ActividadTo();
                to.setId_actividad(rs.getInt("id_actividad"));
                to.setActiv_tipo(rs.getString("activ_tipo"));
                to.setDescripcion(rs.getString("descripcion"));
                to.setFecha(rs.getString("fecha"));
                to.setHora(rs.getString("hora"));
                to.setId_periodo(rs.getInt("id_periodo"));
               


                reporte.add(to);


                System.out.println("Reportado..!");

            }
        } catch (Exception e) {
            System.out.println("Error en Reporte alumno..." + e.getMessage());
        } finally {
            getCerrarConexion();
        }
        return reporte;

    }

    public void eliminarRegistroActividad(int id_actividad) {
        try {
            getConexionDB();
            ps = con.prepareStatement("Delete FROM cultura.cp_actividad WHERE id_actividad=? ");
            ps.setInt(1, id_actividad);

            if (ps.executeUpdate() == 1) {

                System.out.println(" Eliminado");
            }
        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }

    public void actualizarDatosActividad(ActividadTo to, int id_actividad) {
        try {

            getConexionDB();
            ps = con.prepareStatement("update cultura.cp_actividad set activ_tipo=?, descripcion=?, fecha= to_date(?,'yyyy-mm-dd') ,hora=?, id_periodo=? WHERE id_actividad=?");
            ps.setString(1, to.getActiv_tipo());
            ps.setString(2, to.getDescripcion());
            ps.setString(3, to.getFecha());
            ps.setString(4, to.getHora());
            ps.setInt(5, to.getId_periodo());
            ps.setInt(6, id_actividad);

            ps.executeUpdate();

            System.out.println("Actualizado");

        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }
}
