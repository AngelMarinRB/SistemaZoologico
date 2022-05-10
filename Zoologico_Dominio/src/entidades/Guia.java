
package entidades;

import java.util.GregorianCalendar;
import java.util.List;
import org.bson.types.ObjectId;


public class Guia extends Empleado{
    List<Itinerario> itinerarios;
    ObjectId idVisita;
    
    
 public Guia(){
 }
 
 
 public Guia(String nombre, String direccion, String telefono, GregorianCalendar fechaInicio){
     super(nombre, direccion, telefono, fechaInicio);
 }

    public Guia(List<Itinerario> itinerarios, ObjectId idVisita) {
        this.itinerarios = itinerarios;
        this.idVisita = idVisita;
    }

    public Guia(List<Itinerario> itinerarios, ObjectId idVisita, String nombre, String direccion, String telefono, GregorianCalendar fechaInicio) {
        super(nombre, direccion, telefono, fechaInicio);
        this.itinerarios = itinerarios;
        this.idVisita = idVisita;
    }

    public Guia(List<Itinerario> itinerarios, ObjectId idVisita, ObjectId id, String nombre, String direccion, String telefono, GregorianCalendar fechaInicio) {
        super(id, nombre, direccion, telefono, fechaInicio);
        this.itinerarios = itinerarios;
        this.idVisita = idVisita;
    }
 
 

    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }

    public ObjectId getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(ObjectId idVisita) {
        this.idVisita = idVisita;
    }

    
 
    
}


