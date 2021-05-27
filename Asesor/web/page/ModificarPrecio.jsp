<%-- 
    Document   : ModificarPrecio
    Created on : 26/05/2021, 03:18:09 PM
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
        <main>
            <section class="container">
                <div class="row">
                    <div class="col-lg-10 col-xl-9 mx-auto">
                        <div class="card card-signin flex-row my-5">
                            <div class="card-img-left d-none d-md-flex">
                                <!-- Background image for card set in CSS! -->
                            </div>
                            <div class="card-body">
                                <h5 class="card-title text-center">Modificar precio</h5>
                                <form id="formsignup" method="post" action="/Asesor/ModificarPrecio">

                                    <div class="form-label-group">
                                        <input type="number" id="inputid" name="id_juego" class="form-control"
                                               placeholder="id_juego" required autofocus>
                                        <label for="inputId_Juego">id juego</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="number" id="inputEmail" name="precio_alquiler" class="form-control" placeholder="precio_alquiler"
                                               required>
                                        <label for="inputPrecio_alquiler">precio alquiler</label>
                                    </div>

                                    <button class="btn btn-lg btn-dark btn-block" type="submit"
                                            id="signUpUser">Modificar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <input type="button" onclick=" location.href = '/Asesor/Principal.jsp'" value="regresar" name="boton">
    </body>
</html>
