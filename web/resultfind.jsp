<%-- 
    Document   : index.jsp
    Created on : 29-abr-2020, 18:39:46
    Author     : ANI
--%>

<%@page import="modeloTDO.findTDO"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    LinkedList<findTDO> resultado=(LinkedList<findTDO>)request.getAttribute("resultado");
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
                        </div>
                        <div class="col-12 col-12-medium">
                            <div class="table-wrapper">
				<table>
                                    <thead>
					<tr>
                                            <th>C.I.</th>
                                            <th>Participante</th>
                                            <th>Codigo</th>
                                            <th>Fecha</th>
                                            <th>Organizado</th>
                                            <th>Tipo de Certificado</th>                                          
                                            <th>PDF</th>
					</tr>
                                    </thead>
                                    <tbody>
                                        <%for (int i=0;i<resultado.size();i++){%>
                                        <tr>
                                            <td><%=resultado.get(i).getCi() %></td>
                                            <td><%=resultado.get(i).getNombre() %></td>
                                            <td><%=resultado.get(i).getCodex() %></td>
                                            <td><%= resultado.get(i).getFecha() %></td>
                                            <td><%= resultado.get(i).getOrganiza() %></td>
                                            <td><%= resultado.get(i).getId_tipocertificado() %></td>                                                                                      
                                            <td> <a href="controllerFind?find=codexfind&cout=<%= resultado.get(i).getCodex() %>" class="button primary small">Ver Certificado</a>
                                            
                                        </tr>                                        
                                        <%}%>
                                    </tbody>
				</table>
                            </div>
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
