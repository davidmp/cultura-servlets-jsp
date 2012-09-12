
<%@page import="upeu.edu.to.AlumnoTo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link  href="../../../Cultura/Recursos/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <%

        AlumnoTo to = null;
        to = (AlumnoTo) request.getSession().getAttribute("listaAlumnoById");

    %> 
    <body>
        <form method="post" action="../../../AlumnoControl">

            <table align="center" border="0">
                <tr>
                    <th colspan="2">Formulario de Edicion de Alumnos</th>
                </tr>
                <tr>
                    <td>Codigo</td>
                    <td><input type="text" name="codigo" value="<%=to.getCodigo()%>"/></td>
                </tr>
                <tr>
                    <td>Nombres</td>
                    <td><input type="text" name="nombre" value="<%=to.getNombre()%>"/></td>
                </tr>
                <tr>
                    <td>Apellidos</td>
                    <td><input type="text" name="apellidos" value="<%=to.getApellidos()%>"/></td>
                </tr>
                <tr>
                    <td>EAP</td>
                    <td><input type="text" name="eap" value="<%=to.getEap()%>"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="<%=to.getEmail()%>"/></td>
                </tr>
                <tr>
                    <td>Sexo</td>
                    <td><input type="text" name="sexo" value="<%=to.getSexo()%>"/></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="<%=to.getTelefono()%>"/></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td><input type="text" name="estado" value="<%=to.getEstado()%>"/></td>
                </tr>
                <tr>

                    <td colspan="2"><input type="submit" name="Actualizar" value="Actualizar"/></td>
                </tr>

            </table>
            <input type="hidden" name="idAlumno" value="<%=to.getIdAlumno() %>"/>
            <input type="hidden" name="opt" value="A"/>
        </form>

    </body>
</html>
