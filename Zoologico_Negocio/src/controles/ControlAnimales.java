package controles;

import entidades.Animal;
import entidades.Especie;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase de control para los Animales del zoológico.
 * 
 * @author Marin
 */
public class ControlAnimales {
    
    private IDatos datos;
    
    /**
     * Crea un control de animales
     * @param datos Datos a utilizar.
     */
    protected ControlAnimales(IDatos datos){
        this.datos = datos;
    }
    
    /**
     * Guarda en la base de datos el animal dado como parámetro.
     * 
     * @param animal Animal a guardar.
     * @return True si se guardó, False en caso contrario.
     */
    public boolean guardarAnimal(Animal animal){
        return datos.guardarAnimal(animal);
    }
    
    /**
     * Elimina de la base de datos el animal dado como parámetro.
     * 
     * @param animal Animal a eliminar.
     * @return True si se eliminó, False en caso contrario.
     */
    public boolean eliminarAnimal(Animal animal) {
        return datos.eliminarAnimal(animal);
    }
    
    /**
     * Devuelve una lista de todos los animales registrados que pertenezcan a la
     * especie dada como parámetro.
     * 
     * @param especie Especie a buscar.
     * @return Lista de Animales de la misma Especie.
     */
    public List<Animal> consultarAnimalesEspecie(Especie especie){
        return datos.consultarAnimalesEspecie(especie);
    }
}
