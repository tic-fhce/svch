<%-- 
    Document   : form_usuario
    Created on : 29-abr-2020, 23:06:10
    Author     : ANI
--%>

<%@page import="modeloTDO.mesageTDO"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    String mensage = (String) request.getAttribute("mensage");
    if (usuario == null) {
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    if(mensage == null)
        mensage="1";
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
                        <h2>Registrar Usuario</h2>
                    </header>
                	<!-- Elements -->
                    <div class="row">
                        <div class="col-3 col-12-medium">
                            <% if(!mensage.equals("1")) {%>
                            <h2>Error</h2>
                            <h3><%=mensage%></h3>
                            <%}%>
                        </div>
                        <div class="col-6 col-12-medium">
                            <form method="post" action="controllerUser?op=newcreateuser">
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>C.I. :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="ci" id="ci" value="" placeholder="Ejemplo: 65478542 lp" required/>
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Nombre :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="nombre" id="nombre" value="" placeholder="Nombres" required />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Paterno :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="paterno" id="paterno" value="" placeholder="Apellido Paterno" />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Materno :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="materno" id="materno" value="" placeholder="Apellido Materno" />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Correo :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="email" name="correo" id="email" value="" placeholder="Email" required/>
                                    </div>
                                </div>                                
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium"> <label>Celular :</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="celular" id="celular" value="" placeholder="Celular" required />
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-6 col-12-medium">
                                        <input type="submit" value="Registrar"/>
                                    </div>
                                    <div class="col-6 col-12-medium">
                                        <a href="admin.jsp" class="button primary">Cancelar</a>
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
