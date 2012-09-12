<%--
Documento   :   MainPrueba
Created on  :   08-may-2012 11:32
Autor       :   Bonnier

--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="upeu.edu.to.AlumnoTo" %> <!-- esta linea sitve para importar clases java  -->
<%@page language="java" import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../../../Cultura/recursos/css/style.css" type="text/css"/>
        <script type="text/javascript" src="../../../Cultura/recursos/js/jquery.js" ></script>
        
        <script type="text/javascript">
            function displayFormInsertar(){
                $("#divInsertar").show();
            }
            
            function closeForm(){
                $("#divInsertar").hide();
            }
            
            function displayEditForm(){                
                $.ajax({
                type:"GET",
                url:"formPer.mdz",
                data:"",
                success: function(datos){
                $("#divPeriodInsert").html(datos);
                $("#divPeriodInsert").html($("#formViewPeriot").html());
                $("#divPeriodInsert").show();
                //alert($("#divPeriodInsert").html());
                }               
                });                 
            }
        </script>
    </head>

    <body style="background-image: url('../../recursos/img/ghost.jpg');background-size: 1024px 768px"> <!--en esta ventana estamos redimensionando la imagen-->
    <center>
           
        

<div id="divInsertar" style="display: none">
    <h1>Formulario </h1>  
<form name="formAlumno" method="post" action="../../../AlumnoControl">

    <table border="1">
        <thead>
            <tr>
                <th colspan="2">Formulario Para Insertar Alumnos</th>
                
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Código</td>
                <td><input type="text" name="codigo" value="" /> </td>
            </tr>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre" value="" /> </td>
  
            </tr>
            <tr>
                <td>Apellidos</td>
                <td><input type="text" name="apellidos" value="" /></td>
            </tr>
            <tr>
                <td>EAP</td>
                <td><select name="eap">
                        <option value="sistemas">E.A.P. Sistemas</option>
                        <option value="civil">E.A.P. Civil</option>
                        <option value="alimentos">E.A.P. Alimentos</option>
                    </select></td>
            </tr>
            <tr>
                <td>Sexo</td>
                <td> Masculino <input type="radio" name="sexo" value="M" checked="checked" />
                     Femenino <input type="radio" name="sexo" value="F" />
                </td>
                     
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="" /></td>
            </tr>
            <tr>
                <td>Telefono</td>
                <td> <input type="text" name="telefono" value="" /></td>
            </tr>
            <tr>
                <td>Estado</td>
                <td> 
                    Activo<input type="radio" name="estado" value="1"  checked="checked"/>
                    Desactivo<input type="radio" name="estado" value="0" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="opt" value="I"/>
                    <input type="submit" value="Guardar" name="guardar" />
                    <input type="button" value="Cancelar" name="cancelar" onclick="closeForm()" />
                </td>
            </tr>
        </tbody>
    </table>
</form>
</div>
<br />




        <div class="mamani">
        <form name="formBuscar" action="../../../AlumnoControl">
        
            c&oacute;digo
            <input type="text" name="dato" value="" />
            <input type="hidden" name="opt" value="B" />
          <input type="submit" value="Buscar" name="buscar" />
          <input type="button" value="Add" name="add" onclick="displayFormInsertar()" />
        </form>
        
    </div> 
        <table border="1" >      <%-- colspan es para unir columnas    --%>
            <thead>
                <tr>            <%-- tr esta es para representar filas    --%>
                    <th colspan="5" style="color:blue; background: coral">Reporte Alumnos</th>   <%--th esta es para representar columnas son las cabeceras   --%>
<!--                  --   <th></th>
                    <th></th>          esto es para combinar tablas con el colspan 
                    <th></th> --%>-->
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>#</td>
                    <td>Nombre</td>
                    <td>Apellidos</td>
                    <td>Telefono</td>
                    <td>Optios </td>
                    
                    
                    
                </tr>
               <% 
                 List<AlumnoTo> lista=null;
                 lista = (List<AlumnoTo> )request.getSession().getAttribute("listaAlumno");
                 int i=0;
                 if (lista!=null){
                 for(AlumnoTo to : lista){
                %>
                <tr>
                    <td><%=++i%> </td>
                    <td><%=to.getNombre() %></td>
                    <td><% out.print(to.getApellidos()); %> </td>
                    <td><%=to.getTelefono() %></td>
                    <td> 
                        <a href="../../../AlumnoControl?opt=D&idAlumno=<%=to.getIdAlumno() %>">Eliminar</a>
                        <a href="../../../AlumnoControl?opt=E&idAlumno=<%=to.getIdAlumno() %>">Editar</a>
                    </td>
                </tr>
                <% 
                }}
                %>
                
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
               
              
            </tbody>
        </table>

        <a href="../../../index.jsp">ir al main Principal</a>
    </center>
    </body>
</html>
