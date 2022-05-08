/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardosn saavedra
 */
public class DiasHorario {
    private String dia;
    private List<String> horas;

    public DiasHorario() {
        dia = null;
        horas= new ArrayList<>(); 
    }

    public DiasHorario(String dia) {
        this.dia = dia;
        horas= new ArrayList<>(); 
    }

    public DiasHorario(String dia, List<String> horas) {
        this.dia = dia;
        this.horas = horas;
        
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<String> getHoras() {
        return horas;
    }

    public void setHoras(List<String> horas) {
        this.horas = horas;
    }
    
    public void agregarHora(String hora){
        this.horas.add(hora);
    }

    @Override
    public String toString() {
        return "DiasHorario{" + "dia=" + dia + ", horas=" + horas + '}';
    }
    
    
}
