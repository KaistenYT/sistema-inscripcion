package servicio;

import modelo.Participante;

import java.util.List;

public class ParticipanteDaoTest {

    public static void main(String[] args) {
        ParticipanteDaoTest test = new ParticipanteDaoTest();
        test.testAgregarParticipante();
        test.testListarParticipantes();
    }

    public void testAgregarParticipante() {
        ParticipanteDao servicio = new ParticipanteDao();
        
        Participante participante = new Participante("Ana", "García", "Mayor de 40", "Mediana", "Natación");

        boolean agregado = servicio.agregarParticipante(participante);
        if (agregado) {
            System.out.println("Participante agregado exitosamente: " + participante);
        } else {
            System.out.println("Error al agregar participante.");
        }
    }

    public void testListarParticipantes() {
        ParticipanteDao servicio = new ParticipanteDao();
        
        List<Participante> participantes = servicio.listarParticipantes();
        System.out.println("Lista de participantes:");
        for (Participante p : participantes) {
            System.out.println(p);
        }
    }
}
