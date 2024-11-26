package com.platinum.tests;

import java.sql.Connection;

import org.junit.Test;

import static org.junit.Assert.*; 
import static org.junit.Assert.assertNotNull;

import com.platinum.utils.DatabaseConnection;

public class DatabaseConnectionTest {

    @Test
    public void testConnection() {	
        try {
            Connection conn = DatabaseConnection.getConnection();
            assertNotNull("La conexión debería ser exitosa", conn);
        } catch (Exception e) {
            e.printStackTrace();
            assertNotNull("Excepción al conectar a la base de datos", null);
        }
    }
}
