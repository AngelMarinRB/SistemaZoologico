package entidades;

import java.util.GregorianCalendar;
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
    private GregorianCalendar fecha;
    private ObjectId idCuidador;

    public CargoEspecie() {
    }

    public CargoEspecie(Especie especie, GregorianCalendar fecha, ObjectId idCuidador) {
        this.especie = especie;
        this.fecha = fecha;
        this.idCuidador = idCuidador;
    }

    public CargoEspecie(ObjectId id, Especie especie, GregorianCalendar fecha, ObjectId idCuidador) {
        this.id = id;
        this.especie = especie;
        this.fecha = fecha;
        this.idCuidador = idCuidador;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public ObjectId getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(ObjectId idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CargoEspecie other = (CargoEspecie) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "CargoEspecie{" + "id=" + id + ", especie=" + especie + ", fecha=" + fecha + ", idCuidador=" + idCuidador + '}';
    }
}
