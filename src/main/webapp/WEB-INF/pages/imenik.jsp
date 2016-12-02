<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
    rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
    rel="stylesheet" type="text/css">
  </head>
  
  <body>
    <div class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><span>Brand</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active">
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#">Contacts</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
      <br>
    <div>
          <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12"></div>
                </div>


                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Naziv</th>
                                    <th>Zanr</th>
                                    <th>Izmena</th>
                                    <th>Obriši</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${imenici}" var="imenik">
                                    <tr>
                                        <td>${imenik.idFilm}</td>
                                        <td>${imenik.naziv}</td>
                                        <td>${imenik.zanr}</td>


                                        <td>
                                            <a class="btn btn-block btn-info" data-toggle="modal"
                                               data-target="#modal-imenik-edit" 
                                               onclick="popuniEditFormu('${imenik.idFilm}', '${imenik.naziv}', '${imenik.zanr}');">
                                                Izmeni..</a>
                                        </td>


                                        <td>
                                            <a class="btn btn-block btn-danger" data-toggle="modal"
                                               data-target="#modal-imenik-delete" 
                                               onclick="popuniDeleteFormu('${imenik.idFilm}');">
                                                Obriši..</a>
                                        </td>
                                    </tr>  
                                </c:forEach>
                            </tbody>
                        </table>

                        <a class="btn btn-success pull-right" data-toggle="modal"
                           data-target="#modal-imenik-add">Novi Film..</a>
                        </br>
                        </br>
                        </br>
                        <div class="row">
                            <div class="col-md-12">
                                <a class="btn btn-primary pull-right" href="pocetna.jsp">Povratak na pocetnu</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modalni prozor za dodavanje novog clana. -->
        <div class="modal fade" id="modal-imenik-add">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Unesite podatke o imeniku</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" action="imenik" method="POST">
                            <input type="hidden" name="action" value="add" />

                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="naziv" class="control-label">Naziv</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="naziv" placeholder="naziv" name="naziv">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="zanr" class="control-label">Zanr</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="zanr" placeholder="zanr" name="zanr">
                                </div>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                        <button type="submit" class="btn btn-primary">Dodaj</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modalni prozor za azuriranje podataka o clanu. -->
        <div class="modal fade" id="modal-imenik-edit">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Izmenite podatke o imeniku</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" role="form" action="imenik" method="POST">

                            <input type="hidden" name="action" value="edit" />
                            <input type="hidden" id="idFilm-edit" name="idFilm" value="" />

                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="naziv" class="control-label">Naziv</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="naziv-edit" value="" name="naziv">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="zanr" class="control-label">Zanr</label>
                                </div>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="zanr-edit" value="" name="zanr">
                                </div>
                            </div>

                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                        <button type="submit" class="btn btn-primary">Izmeni</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Modalni prozor za brisanje clana -->
        <div class="modal fade" id="modal-imenik-delete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
                        <h4 class="modal-title">Izbrišite imenik</h4>

                        <form class="" role="form" action="imenik" method="POST">
                            <input type="hidden" name="action" value="delete" />

                            <input type="hidden" id="idFilm-delete" name="idFilm" value="" />

                            <div class="modal-footer">
                                <a class="btn btn-default" data-dismiss="modal">Zatvori</a>

                                <button type="submit" class="btn btn-primary">Obriši</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <script>
                //Funkcija uzima dobijene parametre i postavlja ih kao vrednosti input elemenata edit forme.
                function popuniEditFormu(idFilm, naziv, zanr) {
                    /*
                     * Postavljamo vrednosti forme u edit modalnom prozoru.
                     */
                    document.getElementById("idFilm-edit").value = idFilm;
                    document.getElementById("naziv-edit").value = naziv;
                    document.getElementById("zanr-edit").value = zanr;
                }

                //Funkcija uzima dobijeni parametar i postavlja ga kao vrednost skrivenog input elementa pkclan-delete u delete formi.
                function popuniDeleteFormu(idFilm) {
                    /*
                     * Postavljamo vrednosti forme u delete modalnom prozoru.
                     */
                    document.getElementById("idFilm-delete").value = idFilm;
                }
            </script>
          
    </div>
    <footer class="section section-primary">
      <div class="container">
        <div class="row">
          <div class="col-sm-6">
            <h1>Footer header</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipisici elit,
              <br>sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
              <br>Ut enim ad minim veniam, quis nostrud</p>
          </div>
          <div class="col-sm-6">
            <p class="text-info text-right">
              <br>
              <br>
            </p>
            <div class="row">
              <div class="col-md-12 hidden-lg hidden-md hidden-sm text-left">
                <a href="#"><i class="fa fa-3x fa-fw fa-instagram text-inverse"></i></a>
                <a href="#"><i class="fa fa-3x fa-fw fa-twitter text-inverse"></i></a>
                <a href="#"><i class="fa fa-3x fa-fw fa-facebook text-inverse"></i></a>
                <a href="#"><i class="fa fa-3x fa-fw fa-github text-inverse"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </footer>
  </body>

</html>
