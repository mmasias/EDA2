package v003;

import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) {
        try {
            Usuario usuario = new Usuario("juan", "miContraseña");
            System.out.println("Contraseña correcta: " + usuario.checkPassword("miContraseña"));
            System.out.println("Contraseña incorrecta: " + usuario.checkPassword("contraseñaIncorrecta"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}