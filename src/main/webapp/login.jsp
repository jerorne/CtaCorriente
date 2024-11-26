
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio de Sesi�n - Ejecutivos</title>
</head>
<body>
    <h2>Inicio de Sesi�n para Ejecutivos</h2>
    <form action="LoginServlet" method="post">
        <label for="rut">RUT Ejecutivo:</label>
        <input type="text" id="rut" name="rut_ejecutivo" required><br><br>
        <label for="password">Contrase�a:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Iniciar Sesi�n">
    </form>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Credenciales incorrectas. Int�ntalo de nuevo.</p>
    <% } %>
</body>
</html>