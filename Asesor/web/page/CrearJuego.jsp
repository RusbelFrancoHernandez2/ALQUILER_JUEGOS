<%-- 
    Document   : crearJuego
    Created on : 26/05/2021, 02:18:10 AM
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
                                <h5 class="card-title text-center">Registar juego</h5>
                                <form id="formsignup" method="post" action="/Asesor/CrearJuego">
                                    <div class="form-label-group">
                                        <input type="text" id="inputTitulo" name="titulo" class="form-control"
                                               placeholder="titulo" required autofocus>
                                        <label for="inputTitulo">titulo</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="text" id="inputGenero" name="genero" class="form-control"
                                               placeholder="genero" required autofocus>
                                        <label for="inputGenero">genero</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="date" id="inputYear" name="year" class="form-control" placeholder="año"
                                               required>
                                        <label for="inputYear">año</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="text" id="inputProtagonistas" name="protagonistas" class="form-control"
                                               placeholder="protagonistas" required autofocus>
                                        <label for="inputProtagonistas">protagonistas</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="text" id="inputDirector" name="director" class="form-control"
                                               placeholder="director" required autofocus>
                                        <label for="inputDirector">director</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="text" id="inputProductor" name="productor" class="form-control"
                                               placeholder="productor" required autofocus>
                                        <label for="inputProductor">productor</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="text" id="inputTecnologia" name="tecnologia" class="form-control"
                                               placeholder="tecnologia" required autofocus>
                                        <label for="inputTecnologia">tecnologia</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="number" id="inputPrecioAlquiler" name="precioAlquiler" class="form-control" placeholder="precioAlquiler"
                                               required autofocus>
                                        <label for="inputPrecioAlquiler">precio alquiler</label>
                                    </div>

                                    <button class="btn btn-lg btn-dark btn-block" type="submit"
                                            id="signUpUser">Registrar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </main>
    </body>
</html>
