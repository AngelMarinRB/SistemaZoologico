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
    
    protected ControlAnimales(IDatos datos){
        this.datos = datos;
    }
    
    public boolean guardarAnimal(Animal animal){
        return datos.guardarAnimal(animal);
    }
    
    public boolean eliminarAnimal(Animal animal) {
        return datos.eliminarAnimal(animal);
    }
    
    public List<Animal> consultarAnimalesEspecie(Especie especie){
        return datos.consultarAnimalesEspecie(especie);
    }
}
