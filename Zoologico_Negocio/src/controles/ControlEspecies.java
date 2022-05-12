package controles;

import entidades.Animal;
import entidades.Especie;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control para las Especies del zoológico
 *  
 * @author Marin
 */
public class ControlEspecies {
    
    private IDatos datos;
    
    protected ControlEspecies(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Guarda en la base de datos la especie dada como parámetro
     * @param especie Especie a gaurdar
     * @return True si se guardó, False en caso contrario.
     */
    public boolean guardarEspecie(Especie especie){
        return datos.guardarEspecie(especie);
    }
    
    /**
     * Devuelve la Especie que tenga el nombre igual al dado como parámetro.
     * 
     * @param nombre Nombre de Especie a buscar.
     * @return Especie si encuntra una, Null si no existe.
     */
    public Especie verificarExistencia(String nombre){
        return datos.consultarEspecieNombre(nombre);
    }
    
    /**
     * Devuelve la Especie que tenga el nombre científico igual al dado como parámetro.
     * 
     * @param nombre Nombre científico de la especie a buscar.
     * @return Especie si enceuntra una, Null si no existe.
     */
    public Especie verificarNombreCientifico(String nombreCientifico){
        return datos.consultarEspecieNombreCientifico(nombreCientifico);
    }
}
