package interfaces;

import entidades.Animal;
import entidades.CargoEspecie;
import entidades.Clima;
import entidades.Continente;
import entidades.Cuidador;
import entidades.Especie;
import entidades.Habitat;
import entidades.Itinerario;
import entidades.Vegetacion;
import entidades.VisitaGuiada;
import entidades.Zona;
import java.util.List;

/**
 * Interfaz para la manipulación de las entidades de la aplicación.
 * 
 * @author Marin
 */
public interface IDatos {
    
    /**
     * Almacena el habitat dado como parámetro.
     * @param habitat Habitat a guardar.
     * @return True si se almacena, False en caso contrario.
     */
    boolean guardarHabitat(Habitat habitat);
    
    /**
     * Devuelve el habitat que coincida con el nombre dado como parámetro
     * (No toma en cuenta mayúsculas)
     * @param nombre Nombre a buscar.
     * @return Habitat si hay coincidencias, Null si no existe.
     */
    Habitat consultarHabitatNombre(String nombre);
    
    /**
     * Devuelve una lista de todos los climas que se encuentren almacenados.
     * @return Lista de Climas.
     */
    List<Clima> consultarClimas();
    
    /**
     * Devuelve una lista de todas las vegetaciones que se encuentren almacenadas.
     * @return Lista de Vegetaciones.
     */
    List<Vegetacion> consultarVegetaciones();
    
    /**
     * Devuelve una lista de todos los continentes que se encuentren almacenados.
     * @return Lista de continentes.
     */
    List<Continente> consultarContinentes();
    
     /**
     * Almacena el itinerario dado como parámetro.
     * @param itinerario itinerario a guardar.
     * @return True si se almacena, False en caso contrario.
     */
    boolean guardarItinerario(Itinerario itinerario);
    
    /**
     * Devuelve el itinerario que coincida con el nombre dado como parámetro
     * (No toma en cuenta mayúsculas)
     * @param nombre Nombre a buscar.
     * @return itinerario si hay coincidencias, Null si no existe.
     */
    Itinerario consultarItinerarioNombre(String nombre);
    
     /**
     * Devuelve una lista de todos las zonas que se encuentren almacenados.
     * @return Lista de Climas.
     */
    List<Zona> consultarZonas();
    
    /**
     * Devuelve una lista de todos los habitats registrados en el sistema.
     * @return Lista de habitats.
     */
    List<Habitat> consultarHabitats();
    
    /**
     * Devuelve una lista de todos los cuidadores registrados en el sistema.
     * @return Lista de cuidadores.
     */
    List<Cuidador> consultarCuidadores();
    
    /**
     * Almacena el Animal dado como parámetro.
     * @param animal Animal a guardar.
     * @return True en caso de guardarse correctamente, False en caso contrario.
     */
    boolean guardarAnimal(Animal animal);
    
    /**
     * Elimina el Animal dado como parámetro.
     * @param animal Animal a eliminar.
     * @return True en caso de eliminarse correctamente, False en caso contrario.
     */
    boolean eliminarAnimal(Animal animal);
    
    /**
     * Devuelve la lista de todos los Animales que pertenezcan a la especie dada
     * como parámetro.
     * @return Lista de Animales con la misma especie.
     */
    List<Animal> consultarAnimalesEspecie(Especie especie);
    
    /**
     * Devuelve la Especie que tenga el nombre vulgar igual al dado como parámetro
     * si existe.
     * @param nombre Nombre a buscar
     * @return Especie con nombre idéntico, Null en caso de no haber uno.
     */
    Especie consultarEspecieNombre(String nombre);
    
    /**
     * Devuelve la Especie que tenga el nombre científico igual al dado como parámetro
     * si existe.
     * @param nombre Nombre a buscar.
     * @return Especie con nombre científico idéntico, Null en caso de no haber uno.
     */
    Especie consultarEspecieNombreCientifico(String nombre);
    
    /**
     * Almacena la especie dada como parámetro.
     * 
     * @param especie Especie a almacenar.
     * @return True si se guarda correctamente, False en caso contrario.
     */
    boolean guardarEspecie(Especie especie);
    
    /**
     * Devuelve una lista de todas las Especies registradas en el sistema.
     * @return Lista de Especies registradas.
     */
    List<Especie> consultarEspecies();
    
      /**
     * Devuelve una lista de las visitas guiadas del ultimo mes.
     * @return Lista de Visitas guiadas del ultimo mes.
     */
    List<VisitaGuiada> consultarMes();
    
    /**
     * Agrega al cuidador dado como parámetro, la ficha de cargo dada como parámetro.
     * @param cuidador Cuidador a agregar ficha de cargo.
     * @param fichaCargo Ficha de cargo a agregar.
     * @return True si se agregó, False en caso contrario.
     */
    boolean agregarFichaCargoCuidador(Cuidador cuidador, CargoEspecie fichaCargo);
}
