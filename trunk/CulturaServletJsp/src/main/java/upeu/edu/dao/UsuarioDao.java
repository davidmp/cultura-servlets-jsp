/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import upeu.edu.to.UsuarioTo;
import upeu.edu.util.DBConn;

public class UsuarioDao extends DBConn {

    public int insertarUsuario(UsuarioTo to) {
        int r = 0;
        try {
            getConexionDB();
            ps = con.prepareStatement("insert into cultura.cp_usuario(nombre, apellidos, usuario, clave, estado,fecha_acceso, telefono,email, sexo ) "
                    + "values (?, ?, ?, ?, ?, to_date(?,'yyyy-mm-dd'), ?, ?, ?)");

            ps.setString(1, to.getNombre());
            ps.setString(2, to.getApellidos());
            ps.setString(3, to.getUsuario());
            ps.setString(4, to.getClave());
            ps.setString(5, to.getEstado());
            ps.setString(6, to.getFecha_acceso());
            ps.setString(7, to.getTelefono());
            ps.setString(8, to.getEmail());
            ps.setString(9, to.getSexo());

            if (ps.executeUpdate() == 1) {
                r = 1;
                System.out.println("Insertado!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return r;
    }
    public UsuarioTo buscarUsuario(String Usuario){
        UsuarioTo user = new UsuarioTo();
    
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cp_usuario "
                    + "where usuario=? ");
            ps.setString(1, Usuario);
            rs= ps.executeQuery();
                  if(rs.next()){
            user.setUsuario(rs.getString("usuario"));
            user.setClave(rs.getString("clave"));
                }
                    
        } catch (Exception e) {
        }
       return user;
    }
    public UsuarioTo buscarUsuarioId(String idUsuario) {
        UsuarioTo usuario = new UsuarioTo();
        try {
            getConexionDB();
            ps = con.prepareStatement("select * from cp_usuario "
                    + "where id_usuario=? ");
            ps.setInt(1, Integer.parseInt(idUsuario));
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setClave(rs.getString("clave"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setFecha_acceso(rs.getString("fecha_acceso"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSexo(rs.getString("sexo"));

            }
        } catch (Exception e) {System.out.printf(e.getMessage());
        }
        return usuario;
    }

    public List reporteUsuario() {   //list:return del mismo tipo
        List reporte = new ArrayList();
        UsuarioTo to;
        try {
            getConexionDB();


            ps = con.prepareStatement("select * from cultura.cp_usuario ");
            rs = ps.executeQuery();
            while (rs.next()) {
                to = new UsuarioTo();
                to.setId_usuario(rs.getInt("id_usuario"));
                to.setNombre(rs.getString("nombre"));
                to.setApellidos(rs.getString("apellidos"));
                to.setUsuario(rs.getString("usuario"));
                to.setClave(rs.getString("clave"));
                to.setEstado(rs.getString("estado"));
                to.setFecha_acceso(rs.getString("fecha_acceso"));
                to.setTelefono(rs.getString("telefono"));
                to.setEmail(rs.getString("email"));
                to.setSexo(rs.getString("sexo"));

                reporte.add(to);


                System.out.println("Reportado..!");

            }
        } catch (Exception e) {
            System.out.println("Error en Reporte usuario..." + e.getMessage());
        } finally {
            getCerrarConexion();
        }
        return reporte;

    }

    public void eliminarRegistrousuario(int id_usuario) {
        try {
            getConexionDB();
            ps = con.prepareStatement("Delete FROM cultura.cp_usuario WHERE id_usuario=? ");
            ps.setInt(1, id_usuario);

            if (ps.executeUpdate() == 1) {

                System.out.println(" Eliminado");
            }
        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }

    public void actualizarDatosusuario(UsuarioTo to, int id_usuario) {
        try {

            getConexionDB();
            ps = con.prepareStatement("update cultura.cp_usuario set nombre=?, apellidos=?,usuario=?, clave=?, estado=?,fecha_acceso=to_date(?,'yyyy-mm-dd'), telefono=?,  email=?,  sexo=? WHERE id_usuario=?");
           
           ps.setString(1, to.getNombre());
            ps.setString(2, to.getApellidos());
            ps.setString(3, to.getUsuario());
            ps.setString(4, to.getClave());
            ps.setString(5, to.getEstado());
            ps.setString(6, to.getFecha_acceso());
            ps.setString(7, to.getTelefono());
            ps.setString(8, to.getEmail());
            ps.setString(9, to.getSexo());
            ps.setInt(10, id_usuario);

            ps.executeUpdate();

            System.out.println("Actualizado");

        } catch (Exception e) {
        } finally {
            getCerrarConexion();
        }
    }
}
