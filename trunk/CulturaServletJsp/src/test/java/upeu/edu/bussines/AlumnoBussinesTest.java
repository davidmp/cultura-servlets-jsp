/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.bussines;

import java.util.List;
import junit.framework.TestCase;
import upeu.edu.to.AlumnoTo;

/**
 *
 * @author Intel
 */
public class AlumnoBussinesTest extends TestCase {
    
    public AlumnoBussinesTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of InsertarAlumno method, of class AlumnoBussines.
     */
    public void testInsertarAlumno() {
        System.out.println("InsertarAlumno");
        AlumnoTo datos = new AlumnoTo();
     datos.setCodigo("200410557");
     datos.setNombre("David");
     datos.setApellidos("Mamani");
     datos.setEmail("dsario@gmail.com");
     datos.setTelefono("951782520");
     datos.setEstado("1");
     datos.setEap("Sistemas");
     datos.setSexo("M");        
        AlumnoBussines instance = new AlumnoBussines();
        assertEquals(true, instance.InsertarAlumno(datos));
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of ActualizaAlumno method, of class AlumnoBussines.
     */
    public void testActualizaAlumno() {
        System.out.println("ActualizaAlumno");
               AlumnoTo datos = new AlumnoTo();
                datos.setCodigo("200410577");
                datos.setNombre("David");
                datos.setApellidos("Mamani");
                datos.setEmail("dsario@gmail.com");
                datos.setTelefono("951782520");
                datos.setEstado("1");
                datos.setEap("Sistemas");
                datos.setSexo("M");      
        int idAlumno = 1;
        AlumnoBussines instance = new AlumnoBussines();
        assertEquals(true, instance.ActualizaAlumno(datos, idAlumno));
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAlumnoId method, of class AlumnoBussines.
     */
    public void testBuscarAlumnoId() {
        System.out.println("buscarAlumnoId");
        String id = "1";
        AlumnoBussines instance = new AlumnoBussines();
        String expResult = "1";
        AlumnoTo result = instance.buscarAlumnoId(id);
        assertEquals(expResult, String.valueOf(result.getIdAlumno()));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of reportarAlumno method, of class AlumnoBussines.
     */
    public void testReportarAlumno() {
        System.out.println("reportarAlumno");
        AlumnoBussines instance = new AlumnoBussines();
        
        List result = instance.reportarAlumno();
        assertEquals(true, result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarAlumnoDato method, of class AlumnoBussines.
     */
    public void testBuscarAlumnoDato() {
        System.out.println("BuscarAlumnoDato");
        String Dato = "";
        AlumnoBussines instance = new AlumnoBussines();
        
        List result = instance.BuscarAlumnoDato(Dato);
        assertEquals(true, result.size()>0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarAlumno method, of class AlumnoBussines.
     */
    public void testEliminarAlumno() {
        System.out.println("eliminarAlumno");
        int idAlumno = 0;
        AlumnoBussines instance = new AlumnoBussines();
        instance.eliminarAlumno(idAlumno);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
