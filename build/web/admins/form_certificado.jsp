<%-- 
    Document   : form_usuario
    Created on : 29-abr-2020, 23:06:10
    Author     : ANI
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="modeloTDO.tipoCertificadoTDO"%>
<%@page import="modeloTDO.usuarioTDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    usuarioTDO usuario = (usuarioTDO) session.getAttribute("SesionUsuario");
    String idpersona = (String) request.getAttribute("idpersona");
    LinkedList<tipoCertificadoTDO>lista = (LinkedList<tipoCertificadoTDO>) request.getAttribute("tipocertificado");
    String respuesta=(String) request.getAttribute("respuesta");
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
                                    <% if(!respuesta.equals("nada")){%>
                                        <h3><%= respuesta %></h3>
                                    <%}%>
                                </div>
                            </div>
                            
                        </div>

                        <div class="col-8 col-12-medium">
                            <h3>Registro</h3>
                            <form method="post" action="controllerCert" enctype="multipart/form-data">
                                <div class="row">                                        
                                    <div class="col-4 col-12-medium">
                                        <label>Codigo de Certificado</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="hidden" name="id" id="id" value="<%=idpersona%>"/>
                                        <input type="text" name="codex" id="codex" placeholder="Codigo de Certificado" required/>
                                    </div>                                 
                                </div>
                                <br>
                                    
                                <div class="row">
                                    <div class="col-4 col-12-medium">
                                        <label>Fecha</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="fecha" id="fecha" value="" placeholder="Fecha de Realizacion del Evento" required/>
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium">
                                        <label>Organizado</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="text" name="organiza" id="organiza" value="" placeholder="Institucion que Despliega el Evento" required/>
                                    </div>
                                </div>
                                <br>
                                    
                                <div class="row">
                                    <div class="col-4 col-12-medium">
                                        <label>Tipo de Cetificado</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <select name="tipo" id="tipo">
                                            <option>Seleccionar .....</option>
                                            <%for (int i=0;i<lista.size();i++){%>
                                            <option value="<%= lista.get(i).getIdtipocertificado()%>"><%= lista.get(i).getDetalle()%></option>
                                            <%}%>
                                        </select>                                        
                                    </div>
                                </div>
                                <br>
                                
                                <div class="row">
                                    <div class="col-4 col-12-medium">
                                        <label>Certificado PDF</label>
                                    </div>
                                    <div class="col-8 col-12-medium">
                                        <input type="file" name="pdf" id="pdf" required/>                           
                                    </div>
                                </div>
                                <br>
                                    
                                <div class="row">
                                    <div class="col-6 col-12-medium">
                                        <input type="submit" value="Registrar" />
                                    </div>
                                    <div class="col-6 col-12-medium">
                                        <a href="${pageContext.request.contextPath}/admins/controllerUser?op=perfil&id=<%=idpersona%>" class="button primary">Cancelar</a>
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
