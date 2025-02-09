package modelo;

import java.util.Objects;

public class Participante {
    private int id_participante;
    private String nombre;
    private String apellido;
    private String categoria;
    private String talla;
    private String disciplina;

    public Participante() {}

    public Participante(int id_participante) {
        this.id_participante = id_participante;
    }
   
    
    
    
    public Participante(String nombre, String apellido, String categoria, String talla, String disciplina) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.categoria = categoria;
        this.talla = talla;
        this.disciplina = disciplina;
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Participante{" + "id_participante=" + id_participante + ", nombre=" + nombre + ", apellido=" + apellido + ", categoria=" + categoria + ", talla=" + talla + ", disciplina=" + disciplina + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_participante;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.apellido);
        hash = 89 * hash + Objects.hashCode(this.categoria);
        hash = 89 * hash + Objects.hashCode(this.talla);
        hash = 89 * hash + Objects.hashCode(this.disciplina);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (this.id_participante != other.id_participante) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.talla, other.talla)) {
            return false;
        }
        return Objects.equals(this.disciplina, other.disciplina);
    }
    
    

   
}
