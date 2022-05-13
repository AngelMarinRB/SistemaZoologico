/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto que representa un dia con sus respectivas horas 
 * @author ricardosn saavedra
 */
public class DiasHorario {
    /**
     * String que contiene el nombre del dia
     */
    private String dia;
    /**
     * Lista de strings que representa las horas de salida
     */
    private List<String> horas;

    /**
     * Constructor vacio que inicializa el dia a nulo y 
     * las listas
     */
    public DiasHorario() {
        dia = null;
        horas= new ArrayList<>(); 
    }

    /**
     * constructor que inicializa el dia a su respectivo
     * parametro a la vez que inicializa la lista
     * @param dia 
     */
    public DiasHorario(String dia) {
        this.dia = dia;
        horas= new ArrayList<>(); 
    }

    /**
     * Constructor que inicializa todo a sus respectivos parametros
     * @param dia dia a setear
     * @param horas lista de horas a setear
     */
    public DiasHorario(String dia, List<String> horas) {
        this.dia = dia;
        this.horas = horas;
        
    }

    /**
     * metodo que regresa el dia que se tiene
     * @return String
     */
    public String getDia() {
        return dia;
    }

    /**
     * metodo que setea el dia
     * @param dia String
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * metodo que regresa una lista con las horas
     * @return List
     */
    public List<String> getHoras() {
        return horas;
    }

    /**
     * metodo que setea la lista de horas con su parametro
     * @param horas lista de horas
     */
    public void setHoras(List<String> horas) {
        this.horas = horas;
    }
    
    /**
     * metodo que agrega una hora a la lista de horas
     * @param hora String de la hora
     */
    public void agregarHora(String hora){
        this.horas.add(hora);
    }

    /**
     * metodo que regresa un string con los datos del objeto
     * @return String
     */
    @Override
    public String toString() {
        return  "Dia=" + dia + ", horas=" + horas ;
    }
    
    
}
