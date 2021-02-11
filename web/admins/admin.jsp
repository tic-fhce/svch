<%-- 
    Document   : admin
    Created on : 29-abr-2020, 22:13:56
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
	<section class="wrapper">
            <div class="inner">
		
                <div class="highlights">
                    <% if(usuario.getPernicion().equals("0")){%>
                    <section>
			<div class="content">
                            <header>
				<a href="#" class="icon fa-vcard-o"><span class="label">Icon</span></a>
                            	<h3>Usuario</h3>
                            </header>
                            <p>Crea un Usuario Administrador </p>
                            <a href="${pageContext.request.contextPath}/admins/controllerUser?op=new" class="button primary small">Crear Usuario</a>
			</div>
                    </section>
                    
                    <section>
			<div class="content">
                            <header>
				<a href="#" class="icon fa-address-book"><span class="label">Icon</span></a>
                                <h3>Tipo de Certificado</h3>
                            </header>
                            <p>Crea un Tipo de Certificado Nuevo </p>
                            <a href="${pageContext.request.contextPath}/admins/controllerUser?op=createtc" class="button primary small">Crear TC</a>
			</div>
                    </section>
                    
                    <section>
			<div class="content">
                            <header>
                                <a href="#" class="icon fa-paper-plane-o"><span class="label">Icon</span></a>
                                <h3>Faucibus consequat</h3>
                            </header>
                            <p>Nunc lacinia ante nunc ac lobortis ipsum. Interdum adipiscing gravida odio porttitor sem non mi integer non faucibus.</p>
			</div>
                    </section>
                    
                    <section>
			<div class="content">
                            <header>
				<a href="#" class="icon fa-qrcode"><span class="label">Icon</span></a>
				<h3>Accumsan viverra</h3>
                            </header>
                            <p>Nunc lacinia ante nunc ac lobortis ipsum. Interdum adipiscing gravida odio porttitor sem non mi integer non faucibus.</p>
			</div>
                    </section>
                        
                        
                    <%}%>
		
                    <section>
			<div class="content">
                            <header>
				<a href="#" class="icon fa-files-o"><span class="label">Icon</span></a>
				<h3>Registrar Certificado</h3>
                            </header>
                            <p>Permite Subir una copia Digital del certificado</p>
                            <a href="${pageContext.request.contextPath}/admins/controllerUser?op=certificado" class="button primary small">Registrar Certificado</a>
			</div>
                    </section>
                    
                    <section>
			<div class="content">
                            <header>
                                <a href="#" class="icon fa-floppy-o"><span class="label">Icon</span></a>
				<h3>Inventario </h3>
                            </header>
                            <p>Permite realizar una Busqueda de los Certificados Registrados</p>
                            <a href="${pageContext.request.contextPath}/admins/controllerUser?op=inventario" class="button primary small">Invemtario</a>
			</div>
                    </section>
                    
                    
		</div>
            </div>
	</section>

	<!-- Footer -->
	<jsp:include page="/pie.jsp"/>

	<!-- Scripts -->
        <jsp:include page="/admins/javas.jsp"/>
    </body>
</html>
