package com.platinum.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.platinum.utils.DatabaseConnection;

@WebServlet("/RegistroPersonaServlet")
public class RegistroPersonaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistroPersonaServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String nombreMascota = request.getParameter("nombre_mascota");

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO persona (rut, nombre, apellido, direccion, correo, telefono, nombre_mascota) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, rut);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, direccion);
            stmt.setString(5, correo);
            stmt.setString(6, telefono);
            stmt.setString(7, nombreMascota);
            stmt.executeUpdate();

            response.sendRedirect("registro_persona_exitoso.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("registro_persona.jsp?error=1");
        }
    }
}
