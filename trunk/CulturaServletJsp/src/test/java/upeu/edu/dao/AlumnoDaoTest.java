/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.dao;

import java.util.List;
import junit.framework.TestCase;
import upeu.edu.to.AlumnoTo;

/**
 *
 * @author Intel
 */
public class AlumnoDaoTest extends TestCase {
    
    public AlumnoDaoTest(String testName) {
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
     * Test of insertarAlumno method, of class AlumnoDao.
     */
    public void testInsertarAlumno() {
        System.out.println("insertarAlumno");
        AlumnoTo to = null;
        AlumnoDao instance = new AlumnoDao();
        int expResult = 0;
        int result = instance.insertarAlumno(to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of buscarAlumnoId method, of class AlumnoDao.
     */
   
}
