package controles;

import fachada.FacadeDatos;
import interfaces.IDatos;

/**
 * Clase de fábrica para controlar la creación de controles
 * 
 * @author Marin
 */
public class FabricaControles {
    
    private IDatos datos;
    
    public FabricaControles(){
        this.datos = new FacadeDatos();
    }
    
    public ControlHabitats crearControlHabitats(){
        return new ControlHabitats(datos);
    }
    
    public ControlClimas crearControlClimas(){
        return new ControlClimas(datos);
    }
    
    public ControlContinentes crearControlContinentes(){
        return new ControlContinentes(datos);
    }
    
    public ControlVegetaciones crearControlVegetaciones(){
        return new ControlVegetaciones(datos);
    }
    
    public ControlItinerarios crearControlItinerarios(){
        return new ControlItinerarios(datos);
    }
    
    public ControlZonas crearControlZonas(){
        return new ControlZonas(datos);
    }
    
    public ControlCuidadores crearControlAnimales(){
        return new ControlCuidadores(datos);
    }
}
