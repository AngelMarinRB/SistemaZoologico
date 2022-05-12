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

    /**
     * Crea una especie.
     */
    public Especie() {
    }

    /**
     * Crea una especie con los parámetros dados.
     * @param nombreVulgar Nombre en Español.
     * @param nombreCientifico Nombre científico.
     * @param descripcion Descripción.
     * @param habitats Hábitat donde vive.
     * @param zona Zona del zoológico donde se encuentra.
     */
    public Especie(String nombreVulgar, String nombreCientifico, String descripcion, Habitat habitats, Zona zona) {
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.habitat = habitats;
        this.zona = zona;
    }

    /**
     * Crea una especie con los parámetros dados.
     * @param id Id.
     * @param nombreVulgar Nombre en Español.
     * @param nombreCientifico Nombre científico.
     * @param descripcion Descripción.
     * @param habitats Hábitat donde vive.
     * @param zona Zona del zoológico donde se encuentra.
     */
    public Especie(ObjectId id, String nombreVulgar, String nombreCientifico, String descripcion, Habitat habitats, Zona zona) {
        this.id = id;
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.habitat = habitats;
        this.zona = zona;
    }

    /**
     * Devuelve el ID de la especie.
     * @return ObjectId
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el Id dado como parámetro.
     * @param id ObjectId
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre en español de la especie.
     * @return Nombre Vulgar
     */
    public String getNombreVulgar() {
        return nombreVulgar;
    }

    /**
     * Establece el nombre en español de la especie al dado como parámetro.
     * @param nombreVulgar Nombre en Español.
     */
    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    /**
     * Devuelve el nombre científico de la especie.
     * @return Nombre Científico.
     */
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    /**
     * Establece el nombre científico al dado como parámetro.
     * @param nombreCientifico Nombre Científico.
     */
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    /**
     * Devuelve al descripción.
     * @return Descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción dada como parámetro.
     * @param descripcion Descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el hábitat de la especie.
     * @return Hábitat.
     */
    public Habitat getHabitat() {
        return habitat;
    }

    /**
     * Establece el hábitat dado como parámetro.
     * @param habitats Hábitat.
     */
    public void setHabitat(Habitat habitats) {
        this.habitat = habitats;
    }

    /**
     * Devuelve la Zona donde se encuentra la especie.
     * @return Zona.
     */
    public Zona getZona() {
        return zona;
    }
    
    /**
     * Establece la zona dada como parámetro.
     * @param zona Zona.
     */
    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    /**
     * Genera el ID de la especie.
     */
    public void generarId(){
        this.id = new ObjectId();
    }

    /**
     * Genera un HASH del objeto.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara si la especie dada como parámetro es igual al objeto.
     * Dos especies son iguales si tienen el mismo ID.
     * @param obj Especie a comparar.
     * @return True si son iguales, False en caso contrario.
     */
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

    /**
     * Devuelve un string que representa el objeto.
     * @return String.
     */
    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nombreVulgar=" + nombreVulgar + ", nombreCientifico=" + nombreCientifico + ", descripcion=" + descripcion + ", habitat=" + habitat + ", zona=" + zona + '}';
    }
    
    
}
