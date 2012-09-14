/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.bussines;

import java.util.List;
import upeu.edu.dao.AlumnoDao;
import upeu.edu.to.AlumnoTo;

/**
 *
 * @author Pacifi Software 
 */
public class AlumnoBussines {
    public AlumnoDao dao;
 public boolean  InsertarAlumno(AlumnoTo datos){
     
     dao= new AlumnoDao();
     return dao.insertarAlumno(datos);
   
    
    }
 public boolean ActualizaAlumno(AlumnoTo datos, int idAlumno){
     
     dao= new AlumnoDao();

    return dao.actualizarDatosAlumno(datos, idAlumno);
      
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