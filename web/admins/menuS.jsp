<%-- 
    Document   : menuS
    Created on : 29-abr-2020, 23:09:00
    Author     : ANI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav id="menu">
    <ul class="links">
        <li><a href="${pageContext.request.contextPath}/admins/controllerUser?op=index">Inicio</a></li>
        <li><a href="${pageContext.request.contextPath}/admins/controllerUser?op=certificado">Registrar Certificado</a></li>
        <li><a href="${pageContext.request.contextPath}/admins/controllerUser?op=inventario">Inventario</a></li>
        <li><a href="${pageContext.request.contextPath}/admins/controllerUser?op=cerrarSesion">Salir</a></li>
    </ul>
</nav>
