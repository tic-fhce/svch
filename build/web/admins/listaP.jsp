<%-- 
    Document   : listaP
    Created on : 01-may-2020, 11:46:48
    Author     : ANI
--%>

<%@page import="modeloTDO.personaTDO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    LinkedList<personaTDO> listap = (LinkedList<personaTDO>) request.getAttribute("lista");
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
                        <h2>Certificados Registrados</h2>
                    </header>
                	<!-- Elements -->
                    <div class="row">
                        <div class="col-12 col-12-medium">
                            <div class="table-wrapper">
				<table>
                                    <thead>
					<tr>
                                            <th>C.I.</th>
                                            <th>Nombre</th>
                                            <th>Ap. Paterno</th>
                                            <th>Ap. Materno</th>
                                            <th>Correo</th>
                                            <th>Celular</th>
                                            <th></th>
					</tr>
                                    </thead>
                                    <tbody>
                                        <%for (int i=0;i<listap.size();i++){%>
                                        <tr>
                                            <td><%=listap.get(i).getCi() %></td>
                                            <td><%= listap.get(i).getNombre() %></td>
                                            <td><%= listap.get(i).getPaterno() %></td>
                                            <td><%= listap.get(i).getMaterno() %></td>
                                            <td><%= listap.get(i).getCorreo() %></td>
                                            <td><%= listap.get(i).getCelular()%></td>
                                            <td><a href="${pageContext.request.contextPath}/admins/controllerUser?op=perfil&id=<%= listap.get(i).getId_persona()%>" class="button primary small">Perfil de Usuario</a></td>
                                        </tr>                                        
                                        <%}%>
                                    </tbody>
                                    <tfoot>
					<tr>
                                            <td>C.I.</td>
                                            <td>Nombre</td>
                                            <td>Ap. Paterno</td>
                                            <td>Ap. Materno</td>
                                            <td>Correo</td>
                                            <td>Celular</td>
                                            <td></td>
					</tr>
                                    </tfoot>
				</table>
                            </div>
                            <% if(listap.size()==0){%>
                                <a href="form_new.jsp" class="button primary large">Registrar Nuevo </a>
                            <%}%>
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

