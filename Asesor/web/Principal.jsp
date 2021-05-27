<%-- 
    Document   : Principal
    Created on : 26/05/2021, 04:29:48 PM
    Author     : rfranco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <input type="button" onclick=" location.href = '/Asesor/page/CrearAlquiler.jsp'" value="crear compra" name="boton">
        <input type="button" onclick=" location.href = '/Asesor/page/CrearJuego.jsp'" value="crear juego" name="boton">
        <input type="button" onclick=" location.href = '/Asesor/page/CrearPersona.jsp'" value="crear Persona" name="boton">
        <input type="button" onclick=" location.href = '/Asesor/page/ModificarPrecio.jsp'" value="modificar juego" name="boton">
        <form id="formsignup" method="post" action="/Asesor/InformeVenta">
            <button class="btn btn-lg btn-dark btn-block" type="submit"
                    id="signUpUser">Informe venta</button>
        </form>
    </body>
</html>
