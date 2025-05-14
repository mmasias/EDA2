package v001;

import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", "Pérez", 85);

        try {
            String hash = persona.getHash();
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("Calificación: " + persona.getCalificacion());
            System.out.println("Hash: " + hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}