package servicio;

import modelo.Participante;
import repositorio.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteDao {

    
    public List<Participante> listarParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = ConexionBD.getConexion();
        String sql = "SELECT * FROM participantes ORDER BY id_participantes";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Participante participante = new Participante();
                participante.setId_participante(rs.getInt("id_participantes"));
                participante.setNombre(rs.getString("nombre"));
                participante.setApellido(rs.getString("apellido"));
                participante.setCategoria(rs.getString("categoria"));
                participante.setTalla(rs.getString("talla"));
                participante.setDisciplina(rs.getString("disciplina"));
                participantes.add(participante); 
            }
        } catch (Exception e) {
            System.out.println("Error al listar participantes: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return participantes;
    }

  
    public boolean agregarParticipante(Participante participante) {
        PreparedStatement ps = null;
        Connection con = ConexionBD.getConexion();
        String sql = "INSERT INTO participantes (nombre, apellido, categoria ,talla, disciplina) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, participante.getNombre());
            ps.setString(2, participante.getApellido());
            ps.setString(3, participante.getCategoria());
            ps.setString(4, participante.getTalla());
            ps.setString(5, participante.getDisciplina());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar participante: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }

        return false;
    }
}
