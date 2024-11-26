package com.platinum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.platinum.utils.DatabaseConnection;

@WebServlet("/TransferenciaServlet")
public class TransferenciaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rutCliente = request.getParameter("rut_cliente");
        String rutDueno = request.getParameter("rut_dueno");
        int idCuenta = Integer.parseInt(request.getParameter("id_cuenta"));
        double montoTransferencia = Double.parseDouble(request.getParameter("monto_transferencia"));
        String cuentaTransferencia = request.getParameter("cuenta_transferencia");
        String tipoCuenta = request.getParameter("tipo_cuenta");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO transaccion (rut_cliente, rut_dueno, id_cuenta, monto_transferencia, cuenta_transferencia, tipo_cuenta) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rutCliente);
            stmt.setString(2, rutDueno);
            stmt.setInt(3, idCuenta);
            stmt.setDouble(4, montoTransferencia);
            stmt.setString(5, cuentaTransferencia);
            stmt.setString(6, tipoCuenta);
            stmt.executeUpdate();

            String updateSql = "UPDATE cta_corriente SET monto = monto - ? WHERE id_cuenta = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setDouble(1, montoTransferencia);
            updateStmt.setInt(2, idCuenta);
            updateStmt.executeUpdate();

            response.sendRedirect("transferencia_exitosa.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("transferencia.jsp?error=1");
        }
    }
}
