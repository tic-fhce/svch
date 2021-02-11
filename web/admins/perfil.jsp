<%-- 
    Document   : perfil
    Created on : 01-may-2020, 23:59:22
    Author     : ANI
--%>

<%@page import="modeloTDO.certificadoTDO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="modeloTDO.personaTDO"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    personaTDO persona=(personaTDO)request.getAttribute("persona");
    LinkedList<certificadoTDO> listaC=(LinkedList<certificadoTDO>) request.getAttribute("certificados");
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
                        <h2>Certificados del Usuario</h2>
                    </header>
                	<!-- Elements -->
                    <div class="row">
                        <div class="col-4 col-12-medium" >
                            <h2>Usuario</h2>
                            <ul>
                                <li><b>C.I. :</b> <%= persona.getCi()%></li>
                                <li><b>Nombre :</b> <%= persona.getNombre()%></li>
                                <li><b>Ap. Paterno :</b> <%= persona.getPaterno()%></li>
                                <li><b>Ap. Materno :</b> <%= persona.getMaterno()%></li>
                                <li><b>Correo :</b> <%= persona.getCorreo()%></li>
                                <li><b>Celular :</b> <%= persona.getCelular()%></li>
                            </ul>
                            <div class="row">
                                <div class="col-12">
                                    <a href="${pageContext.request.contextPath}/admins/controllerUser?op=formcertificado&id=<%= persona.getId_persona() %>" class="button primary fit">Agregar Certificado</a>
                                </div>
                            </div>
                            <br>
                            <% if(usuario.getPernicion().equals("0")){ %>
                            <div class="row">
                                <div class="col-12">
                                    <a href="${pageContext.request.contextPath}/admins/controllerUser?op=updateperfil&id=<%= persona.getId_persona() %>" class="button primary fit">Editar Perfil</a>
                                </div>
                            </div>
                            <br>
                            <%}%>
                            <div class="row">
                                <div class="col-12">
                                    <a href="${pageContext.request.contextPath}/admins/admin.jsp" class="button fit">Salir Perfil</a>
                                </div>
                            </div>
                        </div>

                        <div class="col-8 col-12-medium">
                            
                            <div class="table-wrapper">
				<table>
                                    <thead>
					<tr>
                                            <th>Codigo</th>
                                            <th>Fecha</th>
                                            <th>Organizado</th>
                                            <th>Detalle</th>                                          
                                            <th>PDF</th>                                            
					</tr>
                                    </thead>
                                    <tbody>
                                        <%for (int i=0;i<listaC.size();i++){%>
                                        <tr>
                                            <td><%=listaC.get(i).getCodex() %></td>
                                            <td><%= listaC.get(i).getFecha() %></td>
                                            <td><%= listaC.get(i).getOrganiza() %></td>
                                            <td><%= listaC.get(i).getId_tipocertificado() %></td>                                                                                      
                                            <td><a href="${pageContext.request.contextPath}/admins/controllerUser?op=perfilcertificado&id=<%= listaC.get(i).getCodex() %>" class="button primary small">Ver Certificado</a></td>                                            
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



	<!-- Footer -->
	<jsp:include page="/admins/pie.jsp"/>

	<!-- Scripts -->
        <jsp:include page="/admins/javas.jsp"/>
    </body>
</html>
