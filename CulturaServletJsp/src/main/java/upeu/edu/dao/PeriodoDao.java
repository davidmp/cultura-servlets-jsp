/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import upeu.edu.to.PeriodoTo;
import upeu.edu.util.DBConn;

/**
 *
 * @author PC
 */
public class PeriodoDao extends DBConn {

    public int insertarPeriodo(PeriodoTo to) {
        int r = 0;
        try {
            getConexionDB();
            ps = con.prepareStatement("insert into cultura.cp_periodo(periodo, estado, multa, num_falta) "
                    + "values (?, ?, ?, ?)");
            ps.setString(1, to.getPeriodo());
            ps.setString(2, to.getEstado());
            ps.setString(3, to.getMulta());
            ps.setInt(4, to.getNum_falta());

            if (ps.executeUpdate() == 1) {
                r = 1;
                System.out.println("Insertado!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return r;
    }

    public PeriodoTo buscarPeriodoId(String idPeriodo) {
        PeriodoTo periodo = new PeriodoTo();
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cultura.cp_periodo "
                    + "where id_periodo=? ");
            ps.setInt(1, Integer.parseInt(idPeriodo));
            rs = ps.executeQuery();
            if (rs.next()) {
                periodo.setId_periodo(rs.getInt("id_periodo"));
                periodo.setPeriodo(rs.getString("periodo"));
                periodo.setEstado(rs.getString("estado"));
                periodo.setMulta(rs.getString("multa"));
                periodo.setNum_falta(rs.getInt("num_falta"));
            }
        } catch (Exception e) {
        }
        return periodo;
    }

    public List reportePeriodo() {   //list:return del mismo tipo
        List reporte = new ArrayList();
        PeriodoTo to;
        try {
            getConexionDB();


            ps = con.prepareStatement("select * from cultura.cp_periodo ");
            rs = ps.executeQuery();
            while (rs.next()) {
                to = new PeriodoTo();
                to.setId_periodo(rs.getInt("id_periodo"));
                to.setPeriodo(rs.getString("periodo"));
                to.setEstado(rs.getString("estado"));
                to.setMulta(rs.getString("multa"));
                to.setNum_falta(rs.getInt("num_falta"));

                reporte.add(to);


                System.out.println("Reportado..!");

            }
        } catch (Exception e) {
            System.out.println("Error en Reporte Periodo..." + e.getMessage());
        } finally {
            getCerrarConexion();
        }
        return reporte;

    }

    public void eliminarRegistroPeriodo(int id_periodo) {
        try {
            getConexionDB();
            ps = con.prepareStatement("Delete FROM cultura.cp_periodo WHERE id_periodo=? ");
            ps.setInt(1, id_periodo);

            if (ps.executeUpdate() == 1) {

                System.out.println(" Eliminado");
            }
        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }

    public void actualizarDatosPeriodo(PeriodoTo to, int id_periodo) {
        try {

            getConexionDB();
            ps = con.prepareStatement("update cultura.cp_periodo set periodo=?, estado=?, multa=?,num_falta=? WHERE id_periodo=?");
            ps.setString(1, to.getPeriodo());
            ps.setString(2, to.getEstado());
            ps.setString(3, to.getMulta());
            ps.setInt(4, to.getNum_falta());

            ps.setInt(5, id_periodo);

            ps.executeUpdate();

            System.out.println("Actualizado");

        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }
}
