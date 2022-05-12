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
 * Clase itinerario
 * @author ricardosn saavedra
 */
public class Itinerario {
    /**
     * ObjectId identificador de la clase
     */
    private ObjectId id;
    /**
     * String que almacena el nombre del itinerario
     */
    private String nombre;
    /**
     * Lista de zonas que pasa el itinerario
     */
    private List<Zona> recorrido;
    /**
     * int con duracion del itinerario en min
     */
    private int duracion;
    /**
     * float que tiene la longitud en metros del itinerario
     */
    private float longitud;
    /**
     * int que tiene los visitantes maximos del itinerario
     */
    private int visitantesMaximos;
//    private String dias;
//    private String horas;
    /**
     * lista que contiene los dias con sus respectivos horarios 
     */
    private ArrayList<DiasHorario> DiasHorario;

    /**
     * metodo constructor vacio
     */
    public Itinerario() {
    }

    /**
     * metodo constructor que inicializa todo menos el id con los
     * parametros dados
     * @param nombre nombre del itinerario
     * @param recorrido lista con las zonas
     * @param duracion duracion del itinerario
     * @param longitud longitud del itinerario
     * @param visitantesMaximos visitantes maximos del itinerario
     * @param DiasHorario Lista de objetos DiasHorario con los horarios
     */
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

    /**
     * metodo constructor que inicializa todo con los
     * parametros dados
     * @param id id del itinerario
     * @param nombre nombre del itinerario
     * @param recorrido lista con las zonas
     * @param duracion duracion del itinerario
     * @param longitud longitud del itinerario
     * @param visitantesMaximos visitantes maximos del itinerario
     * @param DiasHorario Lista de objetos DiasHorario con los horarios
     */
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

    /**
     * metodo que regresa el id del itinerario
     * @return ObjectId
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * metodo que guarda el id del itinerario
     * @param id id a guardar
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /**
     * metodo que regresa el nombre del itinerario
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo que setea el nombre del itinerario
     * @param nombre nombre a setear
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo que regresa la lista de zonas
     * del itinerario
     * @return Lista de zonas
     */
    public List<Zona> getRecorrido() {
        return recorrido;
    }

    /**
     * metodo que setea las zonas del recorrido
     * @param recorrido lista de zonas
     */
    public void setRecorrido(List<Zona> recorrido) {
        this.recorrido = recorrido;
    }

    /**
     * metodo que regresa la duracion del recorrido
     * @return int 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * metodo que setea la duracion del recorrido
     * @param duracion duracion del recorrido
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * metodo que regresa la longitud del recorrido
     * @return longitud del recorrido
     */
    public float getLongitud() {
        return longitud;
    }

    /**
     * metodo que setea la longitud del recorrido
     * @param longitud longitud del recorrido
     */
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    /**
     * metodo que regresa los visitantes maximos del recorrido
     * @return int
     */
    public int getVisitantesMaximos() {
        return visitantesMaximos;
    }
    /**
     * metodo que setea los visitantes maximos del recorrido
     * @param visitantesMaximos 
     */
    public void setVisitantesMaximos(int visitantesMaximos) {
        this.visitantesMaximos = visitantesMaximos;
    }

    /**
     * metodo que regresa una lista de arreglos con
     * los dias, horarios del recorrido
     * @return ArrayList
     */
    public ArrayList<DiasHorario> getDiasHorario() {
        return DiasHorario;
    }

    /**
     * metodo que setea los diasHorario
     * @param DiasHorario lista de horario
     */
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

  
    
    /**
     * metodo hach que usa el object id
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * metodo que verifica si un objeto itinerario es igual a otro objeto itinerario
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
        final Itinerario other = (Itinerario) obj;
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
