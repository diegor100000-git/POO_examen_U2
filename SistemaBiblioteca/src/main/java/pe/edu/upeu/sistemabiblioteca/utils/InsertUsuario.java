package pe.edu.upeu.sistemabiblioteca.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertUsuario {
    public static void main(String[] args) {

        String url = "jdbc:sqlite:data/sistemabiblioteca.db";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        String claveOriginal = "admin123";
        String claveEncriptada = encoder.encode(claveOriginal);

        System.out.println("Clave encriptada: " + claveEncriptada);

        try (Connection con = DriverManager.getConnection(url)) {
            String sql = "INSERT INTO usuario (nombre_usuario, clave, estado) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "admin2");

            ps.setString(2, claveEncriptada);

            ps.setString(3, "activo");

            ps.executeUpdate();
            System.out.println("Usuario insertado correctamente con contraseña encriptada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
