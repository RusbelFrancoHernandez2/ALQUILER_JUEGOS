<%-- 
    Document   : crearPersona
    Created on : 25/05/2021, 10:27:03 PM
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
                                <form id="formsignup" method="post" action="/Asesor/CrearPersona">
                                    <div class="form-label-group">
                                        <input type="text" id="inputUserame" name="username" class="form-control"
                                               placeholder=" Nombre Usuario" required autofocus>
                                        <label for="inputUserame">Nombre de usuario</label>
                                    </div>

                                    <div class="d-flex form-label-group">
                                        <div class="col-6 pt-1 form-label-group">
                                            <select class=" form-control form-select" aria-label="Default select example" name="tipoDocumento">
                                                <option selected>Tipo de Documento</option>
                                                <option value="CC">CC</option>
                                                <option value="CE">CE</option>
                                                <option value="TI">TI</option>
                                                <option value="PAS">Pasaporte</option>
                                            </select>
                                        </div>
                                        <div class="form-label-group">
                                            <input type="number" id="inputid" name="id" class="form-control"
                                                   placeholder=" Numero Documento" required autofocus>
                                            <label for="inputid">Numero Documento</label>
                                        </div>
                                    </div>
                                    <div class="form-label-group">
                                        <input type="text" id="inputEmail" name="direccion" class="form-control" placeholder="direccion"
                                               required>
                                        <label for="inputDireccion">direccion</label>
                                    </div>

                                    <div class="form-label-group">
                                        <input type="number" id="inputtelefono" name="telefono" class="form-control" placeholder="Telefono"
                                               required autofocus>
                                        <label for="inputtelefono">Telefono</label>
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
