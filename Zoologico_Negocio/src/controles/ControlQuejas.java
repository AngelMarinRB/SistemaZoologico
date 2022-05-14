/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;

import entidades.Queja;
import interfaces.IDatos;

/**
 * Control de quejas
 * @author alanf
 */
public class ControlQuejas {
     /**
     * objeto que permite usar metodos de las dao
     */
    private IDatos datos;
    
    /**
     * metodo constructor que inicializa un objeto IDatos
     * @param datos parametro para la creacion del objeto
     */
    protected ControlQuejas(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Almacena el itinerario dado como parámetro.
     * @param queja queja a guardar
     * @return True si se guardó, False en caso contrairo.
     */
    public boolean guardarQueja(Queja queja){
        return (datos.guardarQueja(queja) == true);
    }
}
