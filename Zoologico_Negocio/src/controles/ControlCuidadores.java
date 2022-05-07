package controles;

import entidades.Cuidador;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control para los Animales del zoológico.
 * 
 * @author Marin
 */
public class ControlCuidadores {
    
    private IDatos datos;
    
    protected ControlCuidadores(IDatos datos){
        this.datos = datos;
    }
    
    public List<Cuidador> consultarCuidadores(){
        return datos.consultarCuidadores();
    }
}
