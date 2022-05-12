package entidades;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase empleado que generaliza a todos los empleados del zoologico
 * 
 * @author Marin
 */
public class Empleado {
    
    ObjectId id;
    String nombre;
    String direccion;
    String telefono;
    Date fechaInicio;

    /**
     * Crea un empleado.
     */
    public Empleado() {
        
    }

    /**
     * Crea un empleado con los parámetros dados.
     * @param nombre Nombre.
     * @param direccion Dirección.
     * @param telefono Teléfono.
     * @param fechaInicio Fecha de contratación.
     */
    public Empleado(String nombre, String direccion, String telefono, Date fechaInicio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
    }

    /**
     * Crea un empleado con los parámetros dados.
     * @param id Id.
     * @param nombre Nombre.
     * @param direccion Dirección.
     * @param telefono Teléfono.
     * @param fechaInicio Fecha de contratación.
     */
    public Empleado(ObjectId id, String nombre, String direccion, String telefono, Date fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
    }

    /**
     * Devuelve el ID del empleado.
     * @return ObjectId.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el Id dado como parámetro.
     * @param id ObjectId.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del Empleado.
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre dado como parámetro.
     * @param nombre Nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección del Empleado.
     * @return Dirección.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección dada como parámetro.
     * @param direccion Dirección. 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Devuelve el teléfono del empleado.
     * @return Teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono dado como parámetro.
     * @param telefono Teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la fecha de contratación del empleado.
     * @return Fecha de contratación.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de contratación del dempleado.
     * @param fechaInicio Fecha de contratación
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Genera un hash del objeto.
     * @return Hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compara si el empleado dado como parámetro es igual.
     * Dos empleados son iguales si tienen el mismo ID.
     * @param obj Empleado a comparar.
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
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Devuelve el nombre del Empleado en representación del objeto.
     * @return String.
     */
    @Override
    public String toString() {
        return nombre;
    }
    
}
