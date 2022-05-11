package entidades;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que permite la creación y modificación de Habitats.
 * 
 * @author Marin
 */
public class Habitat {
    
    private ObjectId id;
    private String nombre;
    private Clima clima;
    private Vegetacion vegetacion;
    private List<Continente> continentes;

    /**
     * Construye un objeto de tipo Habitat.
     */
    public Habitat() {
    }

    /**
     * Crea un objeto de tipo habitat con sus atributos inicializados a los parámetros
     * dados en el método.
     * 
     * @param nombre Nombre del habitat.
     * @param clima Clima del habitat.
     * @param vegetacion Vegetación del habitat.
     * @param continentes Lista de continentes del habitat.
     */
    public Habitat(String nombre, Clima clima, Vegetacion vegetacion, List<Continente> continentes) {
        this.nombre = nombre;
        this.clima = clima;
        this.vegetacion = vegetacion;
        this.continentes = continentes;
    }

    /**
     * Crea un objeto de tipo habitat con sus atributos inicializados a los parámetros
     * dados en el método.
     * 
     * Constructor para la base de datos, no asignar ID manualmente.
     * 
     * @param id Id del habitat.
     * @param nombre Nombre del habitat.
     * @param clima Clima del habitat.
     * @param vegetacion Vegetación del habitat.
     * @param continentes Lista de continentes del habitat.
     */
    public Habitat(ObjectId id, String nombre, Clima clima, Vegetacion vegetacion, List<Continente> continentes) {
        this.id = id;
        this.nombre = nombre;
        this.clima = clima;
        this.vegetacion = vegetacion;
        this.continentes = continentes;
    }

    /**
     * Devuelve el ID del habitat.
     * @return ObjectId
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del habitat al dado como parámetro al habitat.
     * @param id ObjectId
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del habitat.
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del habitat al dado como parámetro.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el clima del habitat.
     * @return Clima
     */
    public Clima getClima() {
        return clima;
    }

    /**
     * Establece el clima del habitat al dado como parámetro.
     * @param clima Clima
     */
    public void setClima(Clima clima) {
        this.clima = clima;
    }

    /**
     * Devuelve el tipo de vegetación del habitat.
     * @return Vegetacion
     */
    public Vegetacion getVegetacion() {
        return vegetacion;
    }

    /**
     * Establece la vegetación del habitat al dado como parámetro.
     * @param vegetacion Vegetación.
     */
    public void setVegetacion(Vegetacion vegetacion) {
        this.vegetacion = vegetacion;
    }

    /**
     * Devuelve la lista de continentes donde se encuentra el habitat.
     * @return Continentes
     */
    public List<Continente> getContinentes() {
        return continentes;
    }

    /**
     * Establece la lista de continentes del habitat a la dada como parámetro.
     * @param continentes Continentes
     */
    public void setContinentes(List<Continente> continentes) {
        this.continentes = continentes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Habitat other = (Habitat) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nombre;
    }

}
