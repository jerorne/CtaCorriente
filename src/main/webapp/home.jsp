<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" import="jakarta.servlet.http.HttpSession, jakarta.servlet.http.HttpServletRequest, jakarta.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio - Banco Platinum</title>
</head>
<body>
    <%
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("rut_ejecutivo") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String rutEjecutivo = (String) session.getAttribute("rut_ejecutivo");
    %>
    <h2>Bienvenido, <%= rutEjecutivo %></h2>
    <p>Has iniciado sesión como ejecutivo.</p>
    <ul>
        <li><a href="registro_usuario.jsp">Registrar Usuario</a></li>
        <li><a href="registro_persona.jsp">Registrar Persona</a></li>
        <li><a href="crear_cuenta.jsp">Crear Cuenta Corriente</a></li>
        <li><a href="transferencia.jsp">Realizar Transferencia</a></li>
        <li><a href="LogoutServlet">Cerrar Sesión</a></li>
    </ul>
</body>
</html>
