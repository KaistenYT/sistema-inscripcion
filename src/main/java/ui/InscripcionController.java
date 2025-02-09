package ui;

import modelo.Participante;
import servicio.ParticipanteDao;


import javax.swing.*;
import java.awt.event.ActionEvent;

import java.util.List;
import javax.swing.table.DefaultTableModel;

public class InscripcionController {

    private final InscripcionUI vista;
    private final ParticipanteDao participanteDao;

    public InscripcionController(InscripcionUI vista, ParticipanteDao participanteDao) {
        this.vista = vista;
        this.participanteDao = participanteDao;

        // Asignar los listeners a los botones
        this.vista.getAgregarBtn().addActionListener((ActionEvent e) -> {
            agregarParticipante();
        });

        this.vista.getSalirBtn().addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        
        cargarParticipantes();
    }

    private void agregarParticipante() {
        String nombre = vista.getNombreTxt().getText();
        String apellido = vista.getApellidoTxt().getText();
        String categoria = obtenerCategoriaSeleccionada();
        String talla = obtenerTallaSeleccionada();
        String disciplina = obtenerDisciplinaSeleccionada();

        if (nombre.isEmpty() || apellido.isEmpty() || categoria == null || talla == null || disciplina == null) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Participante participante = new Participante();
        participante.setNombre(nombre);
        participante.setApellido(apellido);
        participante.setCategoria(categoria);
        participante.setTalla(talla);
        participante.setDisciplina(disciplina);

        if (participanteDao.agregarParticipante(participante)) {
            JOptionPane.showMessageDialog(vista, "Participante agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarParticipantes();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al agregar participante", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String obtenerCategoriaSeleccionada() {
        if (vista.getMenor18().isSelected()) {
            return "Menor de 18";
        } else if (vista.getEntre18y40().isSelected()) {
            return "18 a 40";
        } else if (vista.getMayor40().isSelected()) {
            return "Mayor de 40";
        }
        return null;
    }

    private String obtenerTallaSeleccionada() {
        if (vista.getJpequenia().isSelected()) {
            return "Pequeña";
        } else if (vista.getjMediana().isSelected()) {
            return "Mediana";
        } else if (vista.getjGrande().isSelected()) {
            return "Grande";
        } else if (vista.getjExtra().isSelected()) {
            return "Extra Grande";
        }
        return null;
    }

    private String obtenerDisciplinaSeleccionada() {
        StringBuilder disciplinas = new StringBuilder();
        if (vista.getAtletismoChck().isSelected()) {
            disciplinas.append("Atletismo ");
        }
        if (vista.getNatacionChck().isSelected()) {
            disciplinas.append("Natación ");
        }
        if (vista.getCiclismoChck().isSelected()) {
            disciplinas.append("Ciclismo ");
        }
        if (vista.getPesasChck().isSelected()) {
            disciplinas.append("Levantamiento de pesas ");
        }
        return disciplinas.toString().trim();
    }

    private void cargarParticipantes() {
        List<Participante> participantes = participanteDao.listarParticipantes();
        DefaultTableModel model = (DefaultTableModel) vista.getTableParticipantes().getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        for (Participante participante : participantes) {
            Object[] row = {
                    participante.getNombre(),
                    participante.getApellido(),
                    participante.getCategoria(),
                    participante.getTalla(),
                    participante.getDisciplina()
            };
            model.addRow(row);
        }
    }

    private void limpiarCampos() {
        vista.getNombreTxt().setText("");
        vista.getApellidoTxt().setText("");
        vista.getMenor18().setSelected(false);
        vista.getEntre18y40().setSelected(false);
        vista.getMayor40().setSelected(false);
        vista.getJpequenia().setSelected(false);
        vista.getjMediana().setSelected(false);
        vista.getjGrande().setSelected(false);
        vista.getjExtra().setSelected(false);
        vista.getAtletismoChck().setSelected(false);
        vista.getNatacionChck().setSelected(false);
        vista.getCiclismoChck().setSelected(false);
        vista.getPesasChck().setSelected(false);
    }
    
  
}