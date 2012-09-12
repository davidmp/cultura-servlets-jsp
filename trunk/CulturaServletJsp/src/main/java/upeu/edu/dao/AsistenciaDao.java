/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import upeu.edu.to.AsistenciaTo;
import upeu.edu.util.DBConn;

/**
 *
 * @author PC
 */
public class AsistenciaDao extends DBConn {

    public int inserAsistencia(AsistenciaTo to) {
        int r = 0;
        try {//insert into cultura.cp_asistencia(fecha, id_actividad, id_alumno, id_usuario) values (to_date(?,'yyyy-mm-dd'), ?, ?, ?)
            getConexionDB();
            ps = con.prepareStatement("insert into cultura.cp_asistencia(fecha, id_actividad, id_alumno, id_usuario) "
                    + "values (to_date(?,'yyyy-mm-dd'), ?, ?, ?)");
            ps.setString(1, to.getFecha());
            ps.setInt(2, to.getId_actividad());
            ps.setInt(3, to.getId_alumno());
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

    public AsistenciaTo buscarAsistencia(String idAsistencia) {
        AsistenciaTo asistencia = new AsistenciaTo();
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cultura.cp_asistencia "
                    + "where id_asistencia=? ");
            ps.setInt(1, Integer.parseInt(idAsistencia));
            rs = ps.executeQuery();
            if (rs.next()) {
                asistencia.setId_asistencia(rs.getInt("id_asistencia"));
                asistencia.setFecha(rs.getString("fecha"));
                asistencia.setId_actividad(rs.getInt("id_actividad"));
                asistencia.setId_alumno(rs.getInt("id_alumno"));
                asistencia.setId_usuario(rs.getInt("id_usuario"));

            }
        } catch (Exception e) {
        }
        return asistencia;
    }

    public List reporteAsistencia() {   //list:return del mismo tipo
        List reporte = new ArrayList();
        AsistenciaTo to;
        try {
            getConexionDB();


            ps = con.prepareStatement("select * from cultura.cp_asistencia ");
            rs = ps.executeQuery();
            while (rs.next()) {
                to = new AsistenciaTo();
                to.setId_asistencia(rs.getInt("id_asistencia"));
                to.setFecha(rs.getString("fecha"));
                to.setId_actividad(rs.getInt("id_actividad"));
                to.setId_alumno(rs.getInt("id_alumno"));
                to.setId_usuario(rs.getInt("id_usuario"));


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

    public void eliminarRegistroAsistencia(int id_asistencia) {
        try {
            getConexionDB();
            ps = con.prepareStatement("Delete FROM cultura.cp_asistencia WHERE id_asistencia=? ");
            ps.setInt(1, id_asistencia);

            if (ps.executeUpdate() == 1) {

                System.out.println(" Eliminado");
            }
        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }

    public void actualizarAsistencia(AsistenciaTo to, int id_asistencia) {
        try {

            getConexionDB();
            ps = con.prepareStatement("update cultura.cp_asistencia set fecha=to_date(?,'yyyy-mm-dd'), id_actividad=?, id_alumno=?,id_usuario=? WHERE id_asistencia=?");
            ps.setString(1, to.getFecha());
            ps.setInt(2, to.getId_actividad());
            ps.setInt(3, to.getId_alumno());
            ps.setInt(4, to.getId_usuario());
            
            ps.setInt(5, id_asistencia);

            ps.executeUpdate();

            System.out.println("Actualizado");

        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }
}
