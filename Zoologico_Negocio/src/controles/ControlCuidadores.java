package controles;

import entidades.CargoEspecie;
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
    
    /**
     * Agrega al cuidador dado como parámetro, la ficha de cargo dada como parámetro.
     * @param cuidador Cuidador a agregar ficha de cargo.
     * @param fichaCargo Ficha de cargo a agregar.
     * @return True si se agregó, False en caso contrario.
     */
    public boolean agregarFichaCargoCuidador(Cuidador cuidador, CargoEspecie fichaCargo) {
        return datos.agregarFichaCargoCuidador(cuidador, fichaCargo);
    }
}
