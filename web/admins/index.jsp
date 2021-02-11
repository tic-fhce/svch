<%-- 
    Document   : index
    Created on : 29-abr-2020, 18:49:22
    Author     : ANI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <head>
	<title>SVCH-ADMIN</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" href="../assets/css/main.css" />
    </head>
    <body>
        <header id="header">
            <a class="logo" href="index.html">S.V.C.H.</a>
            <nav>
		<a href="#menu">Menu</a>
            </nav>
	</header>

	<!-- Nav -->
	<jsp:include page="../menu.jsp"/>
        <div class="highlights">
            <section></section>
            <section>
                <div class="content">
                    <header>
                        <a href="#" class="icon fa-vcard-o"><span class="label">Icon</span></a>
                        <h3>Iniciar Sesion</h3>
                    </header>
                    <form id="contact" action="controllerUser" method="POST">
                        <div class="row">
                            <div class="col-12 col-12-medium">
                                <input id="usuario" name="usuario" type="text" class="form-control"  placeholder="Usuario" required>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-12 col-12-medium">                                                  
                                <input id="pass" name="pass" type="password" class="form-control"  required>
                            </div>
                        </div>
                        <br>
                        <div class="row"> 
                            <div class="col-12 col-12-medium">
                                <button type="submit" id="form-submit" class="button">Ingresar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
            <section></section>
        </div>
        <!-- Footer -->
	<jsp:include page="../pie.jsp"/>

	<!-- Scripts -->
        <jsp:include page="../javas.jsp"/>
    </body>
</html>
