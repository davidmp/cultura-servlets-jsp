/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import upeu.edu.to.AlumnoPeriodoTo;
import upeu.edu.util.DBConn;

/**
 *
 * @author PC
 */
public class AlumnoPeriodoDao extends DBConn {

    public int insertarAlumnoPeriodo(AlumnoPeriodoTo to) {
        int r = 0;
        try {
            getConexionDB();
            ps = con.prepareStatement("insert into cultura.cp_alumno_periodo(id_alumno, id_periodo ) "
                    + "values (?, ?)");
            ps.setInt(1, to.getId_alumno());
            ps.setInt(2, to.getId_periodo());

            if (ps.executeUpdate() == 1) {
                r = 1;
                System.out.println("Insertado!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return r;
    }

    public AlumnoPeriodoTo buscarAlumnoPeriodoId(String idAlumnoPeriodo) {
        AlumnoPeriodoTo alumnoPeriodo = new AlumnoPeriodoTo();
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cp_alumno_periodo "
                    + "where id_alumno_periodo=? ");
            ps.setInt(1, Integer.parseInt(idAlumnoPeriodo));
            rs = ps.executeQuery();
            if (rs.next()) {
                alumnoPeriodo.setId_alumno_periodo(rs.getInt("id_alumno_periodo"));
                alumnoPeriodo.setId_alumno(rs.getInt("id_alumno"));
                alumnoPeriodo.setId_periodo(rs.getInt("id_periodo"));

            }
        } catch (Exception e) {
        }
        return alumnoPeriodo;
    }

    public List reporteAlumnoPeriodo() {   //list:return del mismo tipo
        List reporte = new ArrayList();
        AlumnoPeriodoTo to;
        try {
            getConexionDB();

            ps = con.prepareStatement("select * from cultura.cp_alumno_periodo ");
            rs = ps.executeQuery();
            while (rs.next()) {
                to = new AlumnoPeriodoTo();
                to.setId_alumno_periodo(rs.getInt("id_alumno_periodo"));
                to.setId_alumno(rs.getInt("id_alumno"));
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

    public void eliminarRegistroAlumnoPeriodo(int id_alumno_periodo) {
        try {
            getConexionDB();
            ps = con.prepareStatement("Delete FROM cultura.cp_alumno_periodo WHERE id_alumno_periodo=? ");
            ps.setInt(1, id_alumno_periodo);

            if (ps.executeUpdate() == 1) {

                System.out.println(" Eliminado");
            }
        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }

    public void actualizarDatosAlumnoPeriodo(AlumnoPeriodoTo to, int id_alumno_periodo) {
        try {

            getConexionDB();
            ps = con.prepareStatement("update cultura.cp_alumno_periodo set id_alumno=?, id_periodo=? WHERE id_alumno_periodo=?");
            ps.setInt(1, to.getId_alumno());
            ps.setInt(2, to.getId_periodo());
            ps.setInt(3, id_alumno_periodo);

            ps.executeUpdate();

            System.out.println("Actualizado");

        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }
}
