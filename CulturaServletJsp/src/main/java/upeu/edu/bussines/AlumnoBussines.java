/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.bussines;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import upeu.edu.dao.AlumnoDao;
import upeu.edu.to.AlumnoTo;

/**
 *
 * @author Pacifi Software 
 */
public class AlumnoBussines {
    public AlumnoDao dao;
 public void InsertarAlumno(HttpServletRequest datos){
     
     dao= new AlumnoDao();
     AlumnoTo to= new AlumnoTo();
     to.setCodigo(datos.getParameter("codigo")==null?"":datos.getParameter("codigo"));
     to.setNombre(datos.getParameter("nombre")==null?"":datos.getParameter("nombre"));
     to.setApellidos(datos.getParameter("apellidos")==null?"":datos.getParameter("apellidos"));
     to.setEmail(datos.getParameter("email")==null?"":datos.getParameter("email"));
     to.setTelefono(datos.getParameter("telefono")==null?"":datos.getParameter("telefono"));
     to.setEstado(datos.getParameter("estado")==null?"":datos.getParameter("estado"));
     to.setEap(datos.getParameter("eap")==null?"":datos.getParameter("eap"));
     to.setSexo(datos.getParameter("sexo")==null?"":datos.getParameter("sexo"));
     dao.insertarAlumno(to);
   
    
    }
 public void ActualizaAlumno(HttpServletRequest datos, int idAlumno){
     
     dao= new AlumnoDao();
     AlumnoTo to= new AlumnoTo();
     
     to.setCodigo(datos.getParameter("codigo")==null?"":datos.getParameter("codigo"));
     to.setNombre(datos.getParameter("nombre")==null?"":datos.getParameter("nombre"));
     to.setApellidos(datos.getParameter("apellidos")==null?"":datos.getParameter("apellidos"));
     to.setEmail(datos.getParameter("email")==null?"":datos.getParameter("email"));
     to.setTelefono(datos.getParameter("telefono")==null?"":datos.getParameter("telefono"));
     to.setEstado(datos.getParameter("estado")==null?"":datos.getParameter("estado"));
     to.setEap(datos.getParameter("eap")==null?"":datos.getParameter("eap"));
     to.setSexo(datos.getParameter("sexo")==null?"":datos.getParameter("sexo"));
     dao.actualizarDatosAlumno(to, idAlumno);
   
    
    }
     public AlumnoTo buscarAlumnoId(String id) {
        dao = new AlumnoDao();
        return dao.buscarAlumnoId(id);
    }
     
 public List reportarAlumno (){
     
     dao=new AlumnoDao();
     return dao.reporteAlumno();
 
 }
 public List BuscarAlumnoDato(String Dato){
     dao= new AlumnoDao();
     return dao.buscarDatos(Dato); 
 
 
 }
 
 public void eliminarAlumno(int idAlumno){
     dao=new AlumnoDao();
     dao.eliminarRegistroAlumno(idAlumno);
 
 }
 
}