/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import upeu.edu.to.ExoneradosTo;
import upeu.edu.util.DBConn;

/**
 *
 * @author PC
 */
public class ExoneradosDao extends DBConn {

    public int insertarExonerado(ExoneradosTo to) {
        int r = 0;
        try {
            getConexionDB();
            ps = con.prepareStatement("insert into cultura.cp_exonerados(motivo, id_alumno_periodo, id_usuario) "
                    + "values (?, ?, ? )");
            ps.setString(1, to.getMotivo());
            ps.setInt(2, to.getId_alumno_periodo());
            ps.setInt(3, to.getId_usuario());

            if (ps.executeUpdate() == 1) {
                r = 1;
                System.out.println("Insertado!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return r;
    }

    public ExoneradosTo buscarExoneradoId(String idExonerado) {
        ExoneradosTo exonerado = new ExoneradosTo();
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cp_exonerados "
                    + "where id_exonerados=? ");
            ps.setInt(1, Integer.parseInt(idExonerado));
            rs = ps.executeQuery();
            if (rs.next()) {
                exonerado.setId_exonerados(rs.getString("id_exonerados"));
                exonerado.setMotivo(rs.getString("motivo"));
                exonerado.setId_alumno_periodo(rs.getInt("id_alumno_periodo"));
                exonerado.setId_usuario(rs.getInt("id_usuario"));
                
            }
        } catch (Exception e) {
        }
        return exonerado;
    }

    public List reporteExnerado() {   //list:return del mismo tipo
        List reporte = new ArrayList();
        ExoneradosTo to;
        try {
            getConexionDB();


            ps = con.prepareStatement("select * from cultura.cp_exonerados ");
            rs = ps.executeQuery();
            while (rs.next()) {
                to = new ExoneradosTo();
                to.setId_exonerados(rs.getString("id_exonerados"));
                to.setMotivo(rs.getString("motivo"));
                to.setId_alumno_periodo(rs.getInt("id_alumno_periodo"));
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

    public void eliminarRegistroExonerado(String id_exonerado) {
        try {
            getConexionDB();
            ps = con.prepareStatement("Delete FROM cultura.cp_exonerados WHERE id_exonerados=? ");
            ps.setString(1, id_exonerado);

            if (ps.executeUpdate() == 1) {

                System.out.println(" Eliminado");
            }
        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }

    public void actualizarDatosExonerado(ExoneradosTo to, String id_exonerado) {
        try {

            getConexionDB();
            ps = con.prepareStatement("update cultura.cp_exonerados set motivo=?, id_alumno_periodo=?, id_usuario=? WHERE id_exonerados=?");
            ps.setString(1, to.getMotivo());
            ps.setInt(2, to.getId_alumno_periodo());
            ps.setInt(3, to.getId_usuario());
            ps.setString(4, id_exonerado);

            ps.executeUpdate();

            System.out.println("Actualizado");

        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }
}
