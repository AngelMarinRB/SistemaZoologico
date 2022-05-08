/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author ricardosn saavedra
 */
public class Itinerario {
    private ObjectId id;
    private String nombre;
    private List<Zona> recorrido;
    private int duracion;
    private float longitud;
    private int visitantesMaximos;
//    private String dias;
//    private String horas;
    private ArrayList<DiasHorario> DiasHorario;

    public Itinerario() {
    }

    public Itinerario(String nombre, List<Zona> recorrido, int duracion, float longitud, int visitantesMaximos,ArrayList<DiasHorario> DiasHorario) {
        this.nombre = nombre;
        this.recorrido = recorrido;
        this.duracion = duracion;
        this.longitud = longitud;
        this.visitantesMaximos = visitantesMaximos;
        this.DiasHorario = DiasHorario;
//        this.dias = dias;
//        this.horas = horas;
    }

    public Itinerario(ObjectId id, String nombre, List<Zona> recorrido, int duracion, float longitud, int visitantesMaximos, ArrayList<DiasHorario> DiasHorario) {
        this.id = id;
        this.nombre = nombre;
        this.recorrido = recorrido;
        this.duracion = duracion;
        this.longitud = longitud;
        this.visitantesMaximos = visitantesMaximos;
        this.DiasHorario = DiasHorario;
//        this.dias = dias;
//        this.horas = horas;
    }

    public ObjectId getId() {
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

    public List<Zona> getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(List<Zona> recorrido) {
        this.recorrido = recorrido;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getVisitantesMaximos() {
        return visitantesMaximos;
    }

    public void setVisitantesMaximos(int visitantesMaximos) {
        this.visitantesMaximos = visitantesMaximos;
    }

    public ArrayList<DiasHorario> getDiasHorario() {
        return DiasHorario;
    }

    public void setDiasHorario(ArrayList<DiasHorario> DiasHorario) {
        this.DiasHorario = DiasHorario;
    }

    

//    public String getDias() {
//        return dias;
//    }
//
//    public void setDias(String dias) {
//        this.dias = dias;
//    }
//
//    public String getHoras() {
//        return horas;
//    }
//
//    public void setHoras(String horas) {
//        this.horas = horas;
//    }

  
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Itinerario other = (Itinerario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Itinerario{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", recorrido=").append(recorrido);
        sb.append(", duracion=").append(duracion);
        sb.append(", longitud=").append(longitud);
        sb.append(", visitantes Maximos=").append(visitantesMaximos);
//        sb.append(", dias=").append(dias);
//        sb.append(", horas=").append(horas);
        sb.append('}');
        return sb.toString();
    }
}
