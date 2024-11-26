
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesión - Ejecutivos</title>
</head>
<body>
    <h2>Inicio de Sesión para Ejecutivos</h2>
    <form action="LoginServlet" method="post">
        <label for="rut">RUT Ejecutivo:</label>
        <input type="text" id="rut" name="rut_ejecutivo" required><br><br>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Iniciar Sesión">
    </form>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Credenciales incorrectas. Inténtalo de nuevo.</p>
    <% } %>
</body>
</html>