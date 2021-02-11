<%-- 
    Document   : index.jsp
    Created on : 29-abr-2020, 18:39:46
    Author     : ANI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>SVCH</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" href="assets/css/main.css" />
    </head>
    <body class="is-preload">

		<!-- Header -->
	<header id="header">
            <a class="logo" href="index.html">S.V.C.H.</a>
            <nav>
		<a href="#menu">Menu</a>
            </nav>
	</header>

	<!-- Nav -->
	<jsp:include page="/menu.jsp"/>

	<!-- Banner -->
	<section id="banner">
            <div class="inner">
                <div class="row">
                    <div class="col-12 col-12-medium">
                        <img src="images/logosvch.png" width="150px" height="90px"/>
                    </div>                  
                    <div class="col-12 col-12-medium">
                        <h2>S.V.C.H.</h2>
                        <p>Sistema de Validación de Certificados - Facultad de Humanidades y Ciencias de la Educación </p>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-2 col-12-medium"></div>
                    <div class="col-8 col-12-medium">
                        <h3>Buscar Certificado :</h3>
                        <form id="contact" action="controllerFind?find=codex" method="post">
                            <div class="row">
                                <div class="col-8 col-12-medium">
                                    <input name="codex" type="text" class="form-control" id="codex" placeholder="Numero de Certificado" required>
                                </div>
                                <div class="col-4 col-12-medium">
                                    <button type="submit" id="form-submit" class="btn primary">Buscar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-2 col-12-medium"></div>
                </div>
            </div>
	</section>

        <jsp:include page="/info.jsp"/>

	<!-- Footer -->
	<jsp:include page="/pie.jsp"/>
	<!-- Scripts -->
        <jsp:include page="/javas.jsp"/>

    </body>
</html>