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
    
    /**
     * Construye y devuelve un objeto de tipo ControlHabitats
     * @return ControlHabitats
     */
    public ControlHabitats crearControlHabitats(){
        return new ControlHabitats(datos);
    }
    
    /**
     * Construye y devuelve un objeto de tipo ControlClimas
     * @return ControlClimas
     */
    public ControlClimas crearControlClimas(){
        return new ControlClimas(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlContinentes
     * @return ControlContinentes
     */
    public ControlContinentes crearControlContinentes(){
        return new ControlContinentes(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlVegetaciones
     * @return ControlVegetaciones
     */
    public ControlVegetaciones crearControlVegetaciones(){
        return new ControlVegetaciones(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlItinerarios
     * @return ControlItinerarios
     */
    public ControlItinerarios crearControlItinerarios(){
        return new ControlItinerarios(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlZonas
     * @return ControlZonas
     */
    public ControlZonas crearControlZonas(){
        return new ControlZonas(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlCuidadores
     * @return ControlCuidadores
     */
    public ControlCuidadores crearControlCuidadores(){
        return new ControlCuidadores(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlAnimales
     * @return ControlAnimales
     */
    public ControlAnimales crearControlAnimales(){
        return new ControlAnimales(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlEspecies
     * @return ControlEspecies
     */
    public ControlEspecies crearControlEspecies(){
        return new ControlEspecies(datos);
    }
        
    /**
     * Construye y devuelve un objeto de tipo ControlVisitasGuiadas
     * @return ControlVisitasGuiadas
     */
    public ControlVisitasGuiadas crearVisitaGuiada(){
        return new ControlVisitasGuiadas(datos);
    }
}
