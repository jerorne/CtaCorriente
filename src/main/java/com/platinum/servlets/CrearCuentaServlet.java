package com.platinum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.platinum.utils.DatabaseConnection;

@WebServlet("/CrearCuentaServlet")
public class CrearCuentaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rutCliente = request.getParameter("rut_cliente");
        double monto = Double.parseDouble(request.getParameter("monto"));
        HttpSession session = request.getSession(false);
        String rutEjecutivo = (String) session.getAttribute("rut_ejecutivo");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO cta_corriente (rut_cliente, monto, ejecutivo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rutCliente);
            stmt.setDouble(2, monto);
            stmt.setString(3, rutEjecutivo);
            stmt.executeUpdate();

            response.sendRedirect("cuenta_creada.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("crear_cuenta.jsp?error=1");
        }
    }
}
