package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representación de un tipo de vegetación.
 * 
 * @author Marin
 */
public class Vegetacion {
    
    private ObjectId id;
    private String tipo;
    private String descripcion;

    /**
     * Construye un objeto de tipo vegetación.
     */
    public Vegetacion() {
    }
    
    /**
     * Construye un objeto de tipo vegetacion asignando al objeto el tipo y descripción
     * dado como parámetro.
     * 
     * @param tipo Tipo de vegetacion.
     * @param descripcion Descripción de la vegetación.
     */
    public Vegetacion(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    /**
     * Construye un objeto de tipo vegetacion asignando al objeto el tipo y descripción
     * dado como parámetro.
     * 
     * Constructor para la base de datos, no agregar ID manualmente.
     * 
     * @param tipo Tipo de vegetacion.
     * @param descripcion Descripción de la vegetación.
     */
    public Vegetacion(ObjectId id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
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
     * @param id ObjectId.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el tipo de vegetación de este objeto.
     * @return Tipo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo dado como parámetro a este objeto.
     * @param tipo Tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve al descripción de este objeto.
     * @return Descripción.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción dada como parámetro a este objeto.
     * @param descripcion Descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        final Vegetacion other = (Vegetacion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return tipo;
    }
    
}
