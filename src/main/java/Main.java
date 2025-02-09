
import servicio.ParticipanteDao;
import ui.InscripcionController;
import ui.InscripcionUI;

  public static void main(String args[]) {
    // Configuración del look and feel...

    // Crear la interfaz gráfica
    InscripcionUI vista = new InscripcionUI();
    // Crear el servicio
    ParticipanteDao participanteDao = new ParticipanteDao();
    // Crear el controlador y pasarle la vista y el servicio
    InscripcionController controlador = new InscripcionController(vista, participanteDao);

    // Mostrar la interfaz gráfica
    java.awt.EventQueue.invokeLater(() -> {
        vista.setVisible(true);
    });
}