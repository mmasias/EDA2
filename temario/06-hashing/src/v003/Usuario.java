package v003;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
    private String nombre;
    private String passwordHash;

    public Usuario(String nombre, String password) throws NoSuchAlgorithmException {
        this.nombre = nombre;
        this.passwordHash = hashPassword(password);
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public boolean checkPassword(String password) throws NoSuchAlgorithmException {
        String passwordHash = hashPassword(password);
        return this.passwordHash.equals(passwordHash);
    }
}
