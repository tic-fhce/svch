<%-- 
    Document   : form_usuario
    Created on : 29-abr-2020, 23:06:10
    Author     : ANI
--%>

<%@page import="modeloTDO.personaTDO"%>
<%@page import="modeloTDO.mesageTDO"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    personaTDO persona=(personaTDO) request.getAttribute("persona");
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
                        <h2>Editar Usuario</h2>
                    </header>
                	<!-- Elements -->
                    <div class="row">
                        <div class="col-3 col-12-medium">
                        </div>
                        <div class="col-6 col-12-medium">
                            <form method="post" action="controllerUser?op=updateuser">
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>C.I. :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="hidden" name="id" id="id" value="<%= persona.getId_persona()%>"/>
                                        <input type="text" name="ci" id="ci" value="<%= persona.getCi()%>" disabled="false" />
                                        
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Nombre :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="nombre" id="nombre" value="<%= persona.getNombre() %>"  required />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Paterno :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="paterno" id="paterno" value="<%= persona.getPaterno() %>" />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Materno :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="materno" id="materno" value="<%= persona.getMaterno() %>" />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Correo :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="email" name="correo" id="email" value="<%= persona.getCorreo() %>"  required/>
                                    </div>
                                </div>                                
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Celular :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="celular" id="celular" value="<%= persona.getCelular() %>" required />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-3 col-12-medium"></div>
                                    <div class="col-6 col-12-medium">
                                        <input type="submit" class="button " value="Actualizar"/>
                                    </div>
                                    <div class="col-3 col-12-medium">
                                        <a href="${pageContext.request.contextPath}/admins/controllerUser?op=perfil&id=<%= persona.getId_persona()%>" class="button primary">Cancelar</a>
                                    </div>
                                </div>
                                
                            </form>
                        </div>

                        <div class="col-3 col-12-medium">
                        
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
