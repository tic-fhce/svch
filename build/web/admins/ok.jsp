<%-- 
    Document   : ok
    Created on : 30-abr-2020, 19:11:52
    Author     : ANI
--%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    String respuesta= (String) session.getAttribute("exito");
    
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
	<section class="wrapper">
            <div class="inner">
		
                <div class="highlights">
                    <section>
			
                    </section>
		
                    <section>
			<div class="content">
                            <header>
				<a href="#" class="icon fa-files-o"><span class="label">Icon</span></a>
				<h3>OK</h3>
                            </header>
                            <p><%= respuesta%></p>
                            <a href="${pageContext.request.contextPath}/admins/controllerUser?op=index" class="button primary small">Escritorio</a>
			</div>
                    </section>
                    
                    <section>
			
                    </section>                   
                 
		</div>
            </div>
	</section>

	<!-- Footer -->
	<jsp:include page="/admins/pie.jsp"/>

	<!-- Scripts -->
        <jsp:include page="/admins/javas.jsp"/>
    </body>
</html>
