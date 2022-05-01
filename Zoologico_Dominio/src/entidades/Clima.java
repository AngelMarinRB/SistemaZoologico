package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Representación de un tipo de clima.
 * 
 * @author Marin
 */
public class Clima {
    
    private ObjectId id;
    private String tipo;
    private String descripcion;

    
    /**
     * Construye un objeto de tipo Clima.
     */
    public Clima() {
    }

    /**
     * Construye un objeto de tipo clima asignando al objeto el tipo y descripción
     * dado como parámetro.
     * 
     * @param tipo Tipo de clima.
     * @param descripcion Descripción del clima.
     */
    public Clima(String tipo, String descripcion) {
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    /**
     * Construye un objeto de tipo clima asignando al objeto el id, tipo y descripción
     * dado como parámetro.
     * 
     * Constructor para la base de datos, no agregar ID manualmente.
     * 
     * @param id ObjectId de mongo.
     * @param tipo Tipo de clima.
     * @param descripcion Descripción del clima.
     */
    public Clima(ObjectId id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el ObjectId correspondiente a este objeto.
     * @return ObjectId
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ObjectId dado como parámetro al objeto.
     * @param id ObjectId
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el tipo de clima de este objeto.
     * @return Tipo de clima
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo dado como parámetro al objeto.
     * @param tipo Tipo de clima
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve la descripción del clima en este objeto.
     * @return Descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción dada como parámetro al objeto.
     * @param descripcion Descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Clima other = (Clima) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return tipo;
    }
    
}
