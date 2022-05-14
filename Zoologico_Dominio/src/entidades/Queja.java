/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;


public class Queja {
    
    ObjectId id;
    String itinerario;
    String queja;
    String email;
    String numeroTelefonico;
    String nombre;
    
    public Queja(){}

    public Queja(String itinerario, String queja, String email, String numeroTelefonico, String nombre) {
        this.itinerario = itinerario;
        this.queja = queja;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
        this.nombre = nombre;
    }
    
    public Queja(String itinerario, String queja, String email, String numeroTelefonico) {
        this.itinerario = itinerario;
        this.queja = queja;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
    }

    public Queja(ObjectId id, String itinerario, String queja, String email, String numeroTelefonico, String nombre) {
        this.id = id;
        this.itinerario = itinerario;
        this.queja = queja;
        this.email = email;
        this.numeroTelefonico = numeroTelefonico;
        this.nombre = nombre;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public String getQueja() {
        return queja;
    }

    public void setQueja(String queja) {
        this.queja = queja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Queja other = (Queja) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Queja{" + "id=" + id + ", itinerario=" + itinerario + ", queja=" + queja + ", email=" + email + ", numeroTelefonico=" + numeroTelefonico + ", nombre=" + nombre + '}';
    }
    
    
    
}
