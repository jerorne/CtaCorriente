<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Persona</title>
</head>
<body>
    <h2>Registro de Persona</h2>
    <form action="RegistroPersonaServlet" method="post">
        <label for="rut">RUT:</label>
        <input type="text" id="rut" name="rut" required><br><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" required><br><br>

        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br><br>

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" required><br><br>

        <label for="telefono">Teléfono:</label>
        <input type="text" id="telefono" name="telefono" required><br><br>

        <input type="submit" value="Registrar">
    </form>

    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Error al registrar la persona. Por favor, intenta nuevamente.</p>
    <% } %>
</body>
</html>
