package entidades;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que funciona como registro para conocer que especie esta a cargo de que cuidador.
 * 
 * @author Marin
 */
public class CargoEspecie {
    
    private ObjectId id;
    private Especie especie;
    private Date fecha;
    private ObjectId idCuidador;

    /**
     * Crea un objeto CargoEspecie
     */
    public CargoEspecie() {
    }

    /**
     * Crea un objeto de Cargo especie con los parámetros dados.
     * 
     * @param especie Especie a cuidar.
     * @param fecha Fecha desde creación.
     * @param idCuidador ID del cuidador a cargo.
     */
    public CargoEspecie(Especie especie, Date fecha, ObjectId idCuidador) {
        this.especie = especie;
        this.fecha = fecha;
        this.idCuidador = idCuidador;
    }

    /**
     * Crea un objeto de Cargo especie con los parámetros dados.
     * 
     * @param id ObjectID especificando el ID.
     * @param especie Especie a cuidar.
     * @param fecha Fecha desde creación.
     * @param idCuidador ID del cuidador a cargo.
     */
    public CargoEspecie(ObjectId id, Especie especie, Date fecha, ObjectId idCuidador) {
        this.id = id;
        this.especie = especie;
        this.fecha = fecha;
        this.idCuidador = idCuidador;
    }

    /**
     * Devuelve el ID del objeto.
     * @return ObjectId.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID al dado como parámetro.
     * @param id ObjectId.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve la especie contenida en este cargo.
     * @return Especie.
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * Establece la especie a cargo a la dada como parámetro.
     * @param especie Especie.
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    /**
     * Devuelve la fecha en la que se creó la ficha.
     * @return Fecha.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de emisión a la dada como parámetro.
     * @param fecha Fecha.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el ObjectId del cuidador de esta ficha.
     * @return ObjectId.
     */
    public ObjectId getIdCuidador() {
        return idCuidador;
    }

    /**
     * Establece el cuidador al dado como parámetro.
     * @param idCuidador ObjectId.
     */
    public void setIdCuidador(ObjectId idCuidador) {
        this.idCuidador = idCuidador;
    }

    /**
     * Genera un HASH del objeto.
     * @return Hash.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    /**
     * Verifica si dos CargoEspecie son iguales.
     * Dos CargoEspecie son iguales si tienen el mismo Id.
     * @param obj CargoEspecie a comparar.
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
        final CargoEspecie other = (CargoEspecie) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve un string en representación del objeto.
     * @return String.
     */
    @Override
    public String toString() {
        return "CargoEspecie{" + "id=" + id + ", especie=" + especie + ", fecha=" + fecha + ", idCuidador=" + idCuidador + '}';
    }
}
