package controles;

import entidades.Vegetacion;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control de vegetaciones
 * 
 * @author Marin
 */
public class ControlVegetaciones {
    
    private IDatos datos;
    
    public ControlVegetaciones(IDatos datos){
        this.datos = datos;
    }
    
    public List<Vegetacion> consultarVegetaciones(){
        return datos.consultarVegetaciones();
    }
}
