<%-- 
    Document   : form_usuario
    Created on : 29-abr-2020, 23:06:10
    Author     : ANI
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="modeloTDO.tipoCertificadoTDO"%>
<%@page import="modeloTDO.mesageTDO"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    LinkedList<tipoCertificadoTDO>lista = (LinkedList<tipoCertificadoTDO>) request.getAttribute("tipocertificado");
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
                        <h2>Crear Nuevo tipo de Certificado</h2>
                    </header>
                	<!-- Elements -->
                    <div class="row">
                        <div class="col-3 col-12-medium">
                            <h3>Tipos de Certificados Actuales</h3>
                            <div class="table-wrapper">
				<table>
                                    <thead>
					<tr>
                                            <th>ID</th>
                                            <th>Detalle</th>                                            
					</tr>
                                    </thead>
                                    <tbody>
                                        <%for (int i=0;i<lista.size();i++){%>
                                        <tr>
                                            <td><%=lista.get(i).getIdtipocertificado() %></td>
                                            <td><%= lista.get(i).getDetalle() %></td>                                           
                                        </tr>                                        
                                        <%}%>
                                    </tbody>
				</table>
                            </div>
                            <div class="col-12 col-12-medium">
                                <a href="admin.jsp" class="button primary">Salir</a>                            
                            </div>
                            
                        </div>
                        <div class="col-1 col-12-medium">
                        
			</div>            
                        <div class="col-8 col-12-medium">
                            <form method="post" action="controllerUser?op=tccreate">
                                <div class="row">
                                    <div class="col-2 col-12-medium"> <label>Detalle :</label>
                                    </div>
                                    <div class="col-4 col-12-medium">
                                        <input type="text" name="nombre" id="nombre" value="" placeholder="Tipo de Certificado" required />
                                    </div>
                                    <div class="col-3 col-12-medium">
                                        <input type="submit" value="Crear Tipo de Certificado"/>
                                    </div>
                                    
                                </div>
                                <br>
                                                               
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
