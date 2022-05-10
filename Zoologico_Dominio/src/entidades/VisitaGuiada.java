
package entidades;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;


public class VisitaGuiada {
    
    private ObjectId id;
    GregorianCalendar inicio;
    GregorianCalendar fin;
    List<Itinerario> itinerario;
    Guia guia;
    
    public VisitaGuiada(){
    }
    
    public VisitaGuiada(GregorianCalendar inicio, GregorianCalendar fin, List<Itinerario> itinerario, Guia guia){
        this.inicio = inicio;
        this.fin = fin;
        this.itinerario= itinerario;
        this.guia = guia;
    }

    public VisitaGuiada(ObjectId id, GregorianCalendar inicio, GregorianCalendar fin, List<Itinerario> itinerario, Guia guia) {
        this.id = id;
        this.inicio = inicio;
        this.fin = fin;
        this.itinerario = itinerario;
        this.guia = guia;
    }
    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public GregorianCalendar getInicio() {
        return inicio;
    }

    public void setInicio(GregorianCalendar inicio) {
        this.inicio = inicio;
    }

    public GregorianCalendar getFin() {
        return fin;
    }

    public void setFin(GregorianCalendar fin) {
        this.fin = fin;
    }

    public List<Itinerario> getItinerario() {
        return itinerario;
    }

    public void setItinerario(List<Itinerario> itinerarios) {
        this.itinerario = itinerarios;
    }

   

   

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final VisitaGuiada other = (VisitaGuiada) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "VisitaGuiada{" + "id=" + id + ", inicio=" + inicio + ", fin=" + fin + ", itinerario=" + itinerario + ", guia=" +guia + '}';
    }
    
    
}
