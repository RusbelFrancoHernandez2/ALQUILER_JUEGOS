<%-- 
    Document   : crearAlquiler
    Created on : 26/05/2021, 11:42:22 AM
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
                                <h5 class="card-title text-center">Registrar persona</h5>
                                <form id="formsignup" method="post" action="/Asesor/CrearAlquiler">

                                    <div class="form-label-group">
                                        <input type="number" id="inputid" name="id" class="form-control"
                                               placeholder=" Numero Documento" required autofocus>
                                        <label for="inputid">Numero Documento</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="text" id="inputEmail" name="id_Juego" class="form-control" placeholder="id_Juego"
                                               required>
                                        <label for="inputId_Juego">id juego</label>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="date" id="inputYear" name="year" class="form-control" placeholder="año"
                                               required>
                                        <label for="inputYear">fecha de entrega</label>
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
