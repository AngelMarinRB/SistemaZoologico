package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representación de un continente.
 * 
 * @author Marin
 */
public class Continente {
    
    private ObjectId id;
    private String nombre;

    /**
     * Construye un objeto de tipo Continente.
     */
    public Continente() {
    }
    
    /**
     * Construye un continente con los atributos dados como parámetro.
     * 
     * @param nombre Nombre del continente
     */
    public Continente(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Construye un continente con los atributos dados como parámetro.
     * 
     * Constructor para la base de datos, no agregar ID manualmente.
     * 
     * @param id
     * @param nombre 
     */
    public Continente(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Devuelve el ObjectId de este objeto.
     * @return ObjectId.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ObjectId dado como parámetro a este objeto.
     * @param id ObjectId
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de este continente.
     * @return Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre dado como parámetro a este objeto.
     * @param nombre Nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Genera un Hash del objeto.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     * Verifica si el Continente dado como parámetro es igual.
     * Dos continentes son iguales si tienen el mismo nombre.
     * @param obj Continente a comparar.
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
        final Continente other = (Continente) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    /**
     * Devuelve el nombre en representación del objeto.
     * @return String.
     */
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
