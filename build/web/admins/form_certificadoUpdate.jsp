<%-- 
    Document   : form_usuario
    Created on : 29-abr-2020, 23:06:10
    Author     : ANI
--%>

<%@page import="modeloTDO.findTDO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modeloTDO.tipoCertificadoTDO"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    findTDO certificado=(findTDO) request.getAttribute("certificado");
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
                    <div class="row">
                        <div class="col-4 col-12-medium">
                            <!-- Heading -->
                            <header class="special">
                                <h2>Registrar Nuevo Certificado</h2>
                            </header>
                            <div class="row">
                                <div class="col-12">
                                    <h3>Editando</h3>
                                    <h4><%= certificado.getCodex()%></h4>
                                    <h4>Tipo de Certificado : <%= certificado.getId_tipocertificado()%></h4>
                                </div>
                            </div>
                            
                        </div>

                        <div class="col-8 col-12-medium">
                            <h3>Actualizar</h3>
                            <form method="post" action="controllerUser?op=updatecertific">
                                    
                                <div class="row">
                                    <div class="col-4 col-12-medium">
                                        <label>Fecha</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="hidden" name="id_persona" id="id_certificado" value="<%=certificado.getId_persona() %>">
                                        <input type="hidden" name="id_certificado" id="id_certificado" value="<%=certificado.getId_certificado()%>">
                                        <input type="hidden" name="codex" id="codex" value="<%=certificado.getCodex() %>">
                                        <input type="text" name="fecha" id="fecha" value="<%=certificado.getFecha()%> " required/>
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium">
                                        <label>Organizado</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="organiza" id="organiza" value="<%= certificado.getOrganiza()%>" required/>
                                    </div>
                                </div>
                                <br>
                                    
                                <div class="row">
                                    <div class="col-4 col-12-medium">
                                        <label>Tipo de Cetificado</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <select name="tipo" id="tipo" required>
                                            <option value="">Seleccionar .....</option>
                                            <%for (int i=0;i<lista.size();i++){%>
                                            <option value="<%= lista.get(i).getIdtipocertificado()%>"><%= lista.get(i).getDetalle()%></option>
                                            <%}%>
                                        </select>                                        
                                    </div>
                                </div>
                                <br>                              
                                    
                                <div class="row">
                                    <div class="col-6 col-12-medium">
                                        <input type="submit" value="Actualizar" />
                                    </div>
                                    <div class="col-6 col-12-medium">
                                        <a href="${pageContext.request.contextPath}/admins/controllerUser?op=perfil&id=<%= certificado.getId_persona() %>" class="button primary">Cancelar</a>
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
