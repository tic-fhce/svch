<%-- 
    Document   : usuariofind
    Created on : 01-may-2020, 10:46:44
    Author     : ANI
--%>

<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");   
    if (usuario == null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
%>
<!DOCTYPE HTML>
<html>
    <head>
	<title>SVCH-ADMIN</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" href="../assets/css/main.css" />
    </head>
    <body class="is-preload">

	<!-- Header -->
	<header id="header">
            <a class="logo" href="#">SVCH-ADMIN : <%= usuario.getUsser()%></a>
            <nav>
		<a href="#menu">Menu</a>
            </nav>
	</header>

	<!-- Nav -->
        <jsp:include page="/admins/menuS.jsp"/>
        
        
        <!-- Highlights -->
        <section id="main">
            <div class="inner">
                <div class="content">
                    <!-- Heading -->
                    <header class="special">
                        <h2>Buscar Cedula de Identidad</h2>
                    </header>
                	<!-- Elements -->
                    <div class="row">
                        <div class="col-4 col-12-medium">
                        
			</div>
                        
                        <div class="col-8 col-12-medium">
                            <!-- Form -->
                            <h3>Busqueda de Cliente</h3>
                            <form method="post" action="controllerUser?op=buscarP">
                                <div class="row gtr-uniform">
                                    <div class="col-12 col-12-xsmall">
                                        <input type="text" name="ci" id="ci" value="" placeholder="Cedula de Identidad" required/>
                                    </div>
				
                                    <div class="col-6 col-12-medium">
                                        <input type="submit" value="Buscar" />
                                    </div>
                                    <div class="col-6 col-12-medium">
                                        <a href="${pageContext.request.contextPath}/admins/admin.jsp" class="button primary">Cancelar</a>
                                    </div>
				</div>
                            </form>
                        </div>

                        
                    </div>
                </div>
            </div>
        </section>

	<!-- Footer -->
	<jsp:include page="/admins/pie.jsp"/>

	<!-- Scripts -->
        <jsp:include page="/admins/javas.jsp"/>
    </body>
</html>

