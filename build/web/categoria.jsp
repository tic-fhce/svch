<%-- 
    Document   : categoria
    Created on : 28-abr-2020, 22:38:06
    Author     : ANI
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="modeloDAO.tipoCertificadoDAO"%>
<%@page import="modeloTDO.tipoCertificadoTDO"%>
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
        <header id="header">
            <a class="logo" href="index.html">S.V.C.H.</a>
            <nav>
		<a href="#menu">Menu</a>
            </nav>
	</header>

	<!-- Nav -->
	<jsp:include page="/menu.jsp"/>
        <section id="main">
            <div class="inner">
		<div class="content">
		<!-- Elements -->
                    <div class="row">
                        <div class="col-2 col-12-medium"></div>
                        <div class="col-8 col-12-medium">
                            <h4>Buscar Por Categorias :</h4>
                                <form id="contact" action="controllerFind?find=cat" method="post">
                                    <div class="row">
                                        <div class="col-12 col-12-medium">
                                            <select name="categoria" required>
                                                <option value="">Seleccionar Categoria</option>
                                                <option value="ci">C.I.</option>
                                                <option value="name">Nombre de Participante</option>
                                                <option value="evento">Nombre del Evento</option>
                                                <option value="fecha">Fecha del Evento</option>
                                            </select>                                            
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-12 col-12-medium">
                                            <input name="valor" type="text" class="form-control" id="valor" required>                                            
                                        </div>        
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-12 col-12-medium">
                                            <button type="submit" id="form-submit" class="button primary">Buscar</button>
                                        </div>
                                    </div>
                                </form>
                        </div>
                        <div class="col-2 col-12-medium"></div>
                    </div>
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
