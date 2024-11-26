<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Realizar Transferencia</title>
</head>
<body>
    <h2>Realizar Transferencia</h2>
    <form action="TransferenciaServlet" method="post">
        <label for="rut_cliente">RUT Cliente:</label>
        <input type="text" id="rut_cliente" name="rut_cliente" required><br><br>
        <label for="rut_dueno">RUT Dueño Cuenta Destino:</label>
        <input type="text" id="rut_dueno" name="rut_dueno" required><br><br>
        <label for="id_cuenta">ID Cuenta Origen:</label>
        <input type="number" id="id_cuenta" name="id_cuenta" required><br><br>
        <label for="monto_transferencia">Monto Transferencia:</label>
        <input type="number" id="monto_transferencia" name="monto_transferencia" required><br><br>
        <label for="cuenta_transferencia">Cuenta Destino:</label>
        <input type="text" id="cuenta_transferencia" name="cuenta_transferencia" required><br><br>
        <label for="tipo_cuenta">Tipo de Cuenta:</label>
        <input type="text" id="tipo_cuenta" name="tipo_cuenta" required><br><br>
        <input type="submit" value="Transferir">
    </form>
    <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Error al realizar la transferencia.</p>
    <% } %>
</body>
</html>
