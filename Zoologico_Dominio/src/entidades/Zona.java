package entidades;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * clase POJO de objeto zona
 * @author ricardosn saavedra
 */
public class Zona {
    private ObjectId id;
    public String nombre;
    public float extension;

    /**
     * constructor vacio
     */
    public Zona() {
    }

    /**
     * constructor que inicializa el nombre y la extension de la zona con
     * los parametros dados
     * @param nombre nombre de la zona
     * @param extension extension de la zona
     */
    public Zona(String nombre, float extension) {
        this.nombre = nombre;
        this.extension = extension;
    }

    /**
     * constructor que inicializa el nombre,la extension y el id de la zona con
     * los parametros dados
     * @param id id de la zona
     * @param nombre nombre de la zona
     * @param extension extension de la zona
     */
    public Zona(ObjectId id, String nombre, float extension) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
    }
    
    /**
     * metodo que regresa el objectid de la zona
     * @return ObjectId
     */
    public Object getId() {
        return id;
    }

    /**
     * metodo que registra el valor del id con el objeto
     * dado en el parametro
     * @param id id a setear
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /**
     * metodo que regresa el nombre de la zona
     * @return String con el nombre de la zona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo que setea el nombre con el parametro dado
     * @param nombre nombre a setear
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo que regresa el valor de la extension de la zona
     * @return float extension de la zona
     */
    public float getExtension() {
        return extension;
    }
    
    /**
     * metodo que setea el valor de la extension
     * con el parametro dado
     * @param extension extension a setear
     */
    public void setExtension(float extension) {
        this.extension = extension;
    }

    /**
     * metodo hach que usa el object id
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * metodo que verifica si un objeto zona es igual a otro objeto zona
     * @param obj objeto a comparar
     * @return si es el mismo false si no
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
        final Zona other = (Zona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

     /**
     * metodo que regresa un string con todos los datos
     * @return String
     */
    @Override
    public String toString() {
        return "Zona{" + "id=" + id + ", nombre=" + nombre + ", extension=" + extension + '}';
    }

   
   
    
    
            
}
