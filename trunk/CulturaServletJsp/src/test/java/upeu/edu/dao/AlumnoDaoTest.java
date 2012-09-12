/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;
import upeu.edu.to.AlumnoTo;

/**
 *
 * @author Intel
 */
public class AlumnoDaoTest {
    
    public AlumnoDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertarAlumno method, of class AlumnoDao.
     */
    @Test
    public void testInsertarAlumno() {
        System.out.println("insertarAlumno");
        AlumnoTo to = null;
        AlumnoDao instance = new AlumnoDao();
        int expResult = 0;
        int result = instance.insertarAlumno(to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAlumnoId method, of class AlumnoDao.
     */
  /*  @Test
    public void testBuscarAlumnoId() {
        System.out.println("buscarAlumnoId");
        String idAlumno = "";
        AlumnoDao instance = new AlumnoDao();
        AlumnoTo expResult = null;
        AlumnoTo result = instance.buscarAlumnoId(idAlumno);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of buscarDatos method, of class AlumnoDao.
     */
    /*
    @Test
    public void testBuscarDatos() {
        System.out.println("buscarDatos");
        String datos = "";
        AlumnoDao instance = new AlumnoDao();
        List expResult = null;
        List result = instance.buscarDatos(datos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of reporteAlumno method, of class AlumnoDao.
     */
    /*
    @Test
    public void testReporteAlumno() {
        System.out.println("reporteAlumno");
        AlumnoDao instance = new AlumnoDao();
        List expResult = null;
        List result = instance.reporteAlumno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of eliminarRegistroAlumno method, of class AlumnoDao.
     */
    /*
    @Test
    public void testEliminarRegistroAlumno() {
        System.out.println("eliminarRegistroAlumno");
        int id_alumno = 0;
        AlumnoDao instance = new AlumnoDao();
        instance.eliminarRegistroAlumno(id_alumno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of actualizarDatosAlumno method, of class AlumnoDao.
     */
    /*
    @Test
    public void testActualizarDatosAlumno() {
        System.out.println("actualizarDatosAlumno");
        AlumnoTo to = null;
        int id_alumno = 0;
        AlumnoDao instance = new AlumnoDao();
        instance.actualizarDatosAlumno(to, id_alumno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
}
