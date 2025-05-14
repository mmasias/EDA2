package v004;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class ActaCalificaciones {
    List<Persona> personas;
    private List<String> hashes;

    public ActaCalificaciones() {
        personas = new ArrayList<>();
        hashes = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) throws NoSuchAlgorithmException {
        personas.add(persona);
        hashes.add(persona.getHash());
    }

    public boolean verificarIntegridad() throws NoSuchAlgorithmException {
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            String hashActual = persona.getHash();
            String hashGuardado = hashes.get(i);
            if (!hashActual.equals(hashGuardado)) {
                System.out.println("Los datos de " + persona.getNombre() + " " + persona.getApellido() + " han sido modificados.");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            ActaCalificaciones acta = new ActaCalificaciones();
            acta.agregarPersona(new Persona("Juan", "Pérez", 85));
            acta.agregarPersona(new Persona("María", "González", 92));
            acta.agregarPersona(new Persona("Pedro", "Ramírez", 78));

            System.out.println("Verificación inicial: " + acta.verificarIntegridad());

            acta.personas.get(1).setCalificacion(95);

            System.out.println("Verificación después de modificar una calificación: " + acta.verificarIntegridad());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }    

}