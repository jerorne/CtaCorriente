<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Cuenta Corriente</title>
</head>
<body>
    <h2>Crear Cuenta Corriente</h2>
    <form action="CrearCuentaServlet" method="post">
        <label for="rut_cliente">RUT Cliente:</label>
        <input type="text" id="rut_cliente" name="rut_cliente" required><br><br>
        <label for="monto">Monto Inicial:</label>
        <input type="number" id="monto" name="monto" required><br><br>
        <input type="submit" value="Crear Cuenta">
    </form>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Error al crear la cuenta.</p>
    <% } %>
</body>
</html>