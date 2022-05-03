/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controles;


import entidades.Zona;
import interfaces.IDatos;
import java.util.List;

/**
 *
 * @author ricardosn saavedra
 */
public class ControlZonas {
    private IDatos datos;
    
    protected ControlZonas(IDatos datos){
        this.datos = datos;
    }
    
    public List<Zona> consultarZonas(){
        return datos.consultarZonas();
    }
}
