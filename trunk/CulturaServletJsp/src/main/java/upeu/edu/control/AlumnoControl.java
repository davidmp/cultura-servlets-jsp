/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import upeu.edu.bussines.AlumnoBussines;
import upeu.edu.to.AlumnoTo;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "AlumnoControl", urlPatterns = {"/AlumnoControl"})
public class AlumnoControl extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        char opt=request.getParameter("opt").charAt(0);
        AlumnoBussines ab;
        try {
            switch(opt){
                case 'I': {
                    ab=new AlumnoBussines();
                    ab.InsertarAlumno(request);
                    ab=new AlumnoBussines();
                    List listaAlumno=ab.reportarAlumno();//trabajamos con seciones 
                    request.getSession().setAttribute("listaAlumno", listaAlumno);//"listaAlumno" es el nombre de la sesion 
                    response.sendRedirect("Cultura/Modulos/Alumnos/MainPrueba.jsp");}
                    break;
                case 'R': {
                    ab=new AlumnoBussines();
                    List listaAlumno=ab.reportarAlumno();//trabajamos con seciones 
                    request.getSession().setAttribute("listaAlumno", listaAlumno);//"listaAlumno" es el nombre de la sesion 
                    response.sendRedirect("Cultura/Modulos/Alumnos/MainPrueba.jsp");
                }break;


                case 'A':{
                    ab= new AlumnoBussines();
                    int idAlumno=Integer.parseInt(request.getParameter("idAlumno"));
                    ab.ActualizaAlumno(request, idAlumno);
                    ab= new AlumnoBussines();
                    List listaAlumno=ab.reportarAlumno();//trabajamos con seciones 
                    request.getSession().setAttribute("listaAlumno", listaAlumno);//"listaAlumno" es el nombre de la sesion 
                    response.sendRedirect("Cultura/Modulos/Alumnos/MainPrueba.jsp");

                }break;

                case 'E': {
                    //Reportar por Id
                    ab = new AlumnoBussines();
                    AlumnoTo to = (AlumnoTo) ab.buscarAlumnoId(request.getParameter("idAlumno"));
                    request.getSession().setAttribute("listaAlumnoById", to);
                    response.sendRedirect("Cultura/Modulos/Alumnos/MainPruebaEdit.jsp");
                    break;
                }                    

                case 'D':{
                    ab=new AlumnoBussines();
                    int idAlumno= Integer.parseInt(request.getParameter("idAlumno"));
                    ab.eliminarAlumno(idAlumno);
                    ab=new AlumnoBussines();
                    List listaAlumno=ab.reportarAlumno();//trabajamos con seciones 
                    request.getSession().setAttribute("listaAlumno", listaAlumno);//"listaAlumno" es el nombre de la sesion 
                    response.sendRedirect("Cultura/Modulos/Alumnos/MainPrueba.jsp");

                } break;

                case 'B':{
                    String dato= request.getParameter("dato");
                    ab=new AlumnoBussines();
                    List lista = ab.BuscarAlumnoDato(dato);
                    request.getSession().setAttribute("listaAlumno",lista);
                        response.sendRedirect("Cultura/Modulos/Alumnos/MainPrueba.jsp");
                }break;                    
                default: System.out.println("no hay valores");break;
            }

            } finally {            
                out.close();
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("gettt-....--"+request.getParameter("nombre"));
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             System.out.println("post--.--.--....--"+request.getParameter("nombre"));
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
