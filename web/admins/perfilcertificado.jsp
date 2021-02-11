<%-- 
    Document   : perfil
    Created on : 01-may-2020, 23:59:22
    Author     : ANI
--%>

<%@page import="modeloTDO.findTDO"%>
<%@page import="modeloTDO.certificadoTDO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modeloTDO.personaTDO"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    findTDO certificado=(findTDO)request.getAttribute("certificado");
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
                        <h2>Certificado: <%= certificado.getCodex()%></h2>
                    </header>
                	<!-- Elements -->
                    <div class="row">
                        <div class="col-4 col-12-medium" >
                            <h2>Usuario</h2>
                            <ul>
                                <li><b>Codigo :</b> <%= certificado.getCodex()%></li>
                                <li><b>Fecha :</b> <%= certificado.getFecha()%></li>
                                <li><b>Tipo certificado :</b> <%= certificado.getId_tipocertificado()%></li>
                                <li><b>Organizado por :</b> <%=  certificado.getOrganiza()%></li>
                                <li><b>Pertenece A :</b> <%= certificado.getNombre() %></li>                                
                            </ul>
                            <div class="row">
                                <div class="col-12">
                                    <a href="${pageContext.request.contextPath}/admins/controllerUser?op=updatecertificado&id=<%= certificado.getId_certificado() %>" class="button primary fit">Editar Certificado</a>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <label>Cambiar Pdf </label>
                                <form method="post" action="controllerCertupdate" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-12">
                                            <input type="hidden" name="id" value="<%= certificado.getId_persona() %>">
                                            <input type="hidden" name="id_certificado" value="<%= certificado.getId_certificado()%>">
                                            <input type="hidden" name="codex" value="<%= certificado.getCodex()%>">
                                            <input type="file" name="pdf" id="pdf">
                                        </div>
                                        
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-12">
                                           <input type="submit" value="Cambiar PDF"> 
                                        </div>                                       
                                    </div>                                    
                                </form>
                                
                            </div>
                            <hr>
                            
                            <div class="row">
                                <div class="col-12">
                                    <a href="${pageContext.request.contextPath}/admins/controllerUser?op=perfil&id=<%= certificado.getId_persona()%>" class="button fit">Salir Perfil</a>
                                </div>
                            </div>
                            <br>
                            <% if(usuario.getPernicion().equals("0")){ %>
                            <div class="row">
                                <div class="col-12">
                                    <a href="${pageContext.request.contextPath}/admins/controllerUser?op=updateperfil&id=<%= certificado.getId_certificado() %>" class="button primary fit">Eliminar Certificado</a>
                                </div>
                            </div>
                            <br>
                            <%}%>
                        </div>

                        <div class="col-8 col-12-medium">
                            <object data="${pageContext.request.contextPath}/pdf/<%= certificado.getPdf()%>" type="application/pdf" height="620" width="100%">
                                <iframe src="https://docs.google.com/viewer?url=${pageContext.request.contextPath}/pdf/<%= certificado.getPdf()%>&embedded=true" height="620" width="100%"></iframe>
                            </object>
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
