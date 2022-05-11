package entidades;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author ricardosn saavedra
 */
public class Zona {
    private ObjectId id;
    public String nombre;
    public float extension;

    public Zona() {
    }

    public Zona(String nombre, float extension) {
        this.nombre = nombre;
        this.extension = extension;
    }

    public Zona(ObjectId id, String nombre, float extension) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
    }

    public Object getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getExtension() {
        return extension;
    }

    public void setExtension(float extension) {
        this.extension = extension;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Zona other = (Zona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    
    @Override
    public String toString() {
        return nombre;
    }
    
            
}
