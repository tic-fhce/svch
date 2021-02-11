<%-- 
    Document   : index.jsp
    Created on : 29-abr-2020, 18:39:46
    Author     : ANI
--%>

<%@page import="modeloTDO.findTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    findTDO certificado=(findTDO)request.getAttribute("pdf");
%>
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
                        <div class="col-6 col-12-medium">
                            <h1>Resultados</h1>
                            <h3>Encontrados</h3>
                            <div class="row">
                                <div class="col-12 col-12-medium" >
                                    <h2>Usuario</h2>
                                    <div class="row">
                                        <div class="col-4 col-12-medium"><label>C.I. :</label></div>
                                        <div class="col-8 col-12-medium"><%= certificado.getCi()%></div>
                                    </div>

                                    <div class="row">
                                        <div class="col-4 col-12-medium"><label>Nombre :</label></div>
                                        <div class="col-8 col-12-medium"><%= certificado.getNombre()%></div>
                                    </div>
                                   
                                    <div class="row">
                                        <div class="col-4 col-12-medium"><label>Codigo de Certificado :</label></div>
                                        <div class="col-8 col-12-medium"><h2><%= certificado.getCodex()%></h2></div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-4 col-12-medium"><label>Fecha del Evento :</label></div>
                                        <div class="col-8 col-12-medium"><%= certificado.getFecha() %></div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-4 col-12-medium"><label>Organizado por :</label></div>
                                        <div class="col-8 col-12-medium"><%= certificado.getOrganiza() %></div>
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-4 col-12-medium"><label>Certificado de : </label></div>
                                        <div class="col-8 col-12-medium"><%= certificado.getId_tipocertificado() %></div>
                                    </div>
                                    
                                </div>
                            </div>
                                
                        </div>
                        <div class="col-6 col-12-medium">
                            <% if(certificado.getId_certificado()==0) { %>
                                <h1>El Item Buscado no se encuentra</h1>
                                <div class="col-8 col-12-medium">
                                    <h3>Buscar Certificado :</h3>
                                    <form id="contact" action="controllerFind?find=codex" method="post">
                                        <div class="row">
                                            <div class="col-8 col-12-medium">
                                                <input name="codex" type="text" class="form-control" id="codex" placeholder="Numero de Certificado" required>
                                            </div>
                                            <div class="col-4 col-12-medium">
                                                <button type="submit" id="form-submit" class="button primary">Buscar</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="col8 col-12-medium">
                                    <a href="categoria.jsp" class="button primary">Buscar por Categoria</a>
                                </div>
                            <% }else { %>
                                <object data="${pageContext.request.contextPath}/pdf/<%= certificado.getPdf()%>" type="application/pdf" height="620" width="100%">
                                    <iframe src="https://docs.google.com/viewer?url=${pageContext.request.contextPath}/pdf/<%= certificado.getPdf()%>&embedded=true" height="620" width="100%"></iframe>
                                </object>
                            <% } %>
                        </div>
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
