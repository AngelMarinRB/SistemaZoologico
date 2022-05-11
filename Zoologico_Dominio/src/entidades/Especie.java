package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa una Especie Animal
 * @author Marin
 */
public class Especie {
    
    private ObjectId id;
    private String nombreVulgar;
    private String nombreCientifico;
    private String descripcion;
    private Habitat habitat;
    private Zona zona;

    public Especie() {
    }

    public Especie(String nombreVulgar, String nombreCientifico, String descripcion, Habitat habitats, Zona zona) {
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.habitat = habitats;
        this.zona = zona;
    }

    public Especie(ObjectId id, String nombreVulgar, String nombreCientifico, String descripcion, Habitat habitats, Zona zona) {
        this.id = id;
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.habitat = habitats;
        this.zona = zona;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitats) {
        this.habitat = habitats;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    public void generarId(){
        this.id = new ObjectId();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Especie other = (Especie) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nombreVulgar=" + nombreVulgar + ", nombreCientifico=" + nombreCientifico + ", descripcion=" + descripcion + ", habitat=" + habitat + ", zona=" + zona + '}';
    }
    
    
}
