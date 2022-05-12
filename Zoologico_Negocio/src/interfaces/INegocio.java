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
 * Interfáz para el control del subsistema de Negocio.
 * 
 * @author Marin
 */
public interface INegocio {
    
    /**
     * Almacena el hábitat dado como parámetro.
     * @param habitat Habitat a guardar.
     * @return True si se guardó, False en caso contrairo.
     */
    boolean guardarHabitat(Habitat habitat);
    
    /**
     * Verifica si ya se encuentra registrado un habitat con el mismo nombre.
     * @param nombre Nombre a buscar.
     * @return False si no existe, True en caso contrario
     */
    Habitat verificarExistenciaHabitat(String nombre);
    
    /**
     * Devuelve una lista de todos los continentes registrados.
     * @return Continentes.
     */
    List<Continente> consultarContinentes();
    
    /**
     * Devuelve una lista de todas las vegetaciones registradas en el sistema.
     * @return Lista de vegetaciones.
     */
    List<Vegetacion> consultarVegetaciones();
    
    /**
     * Devuelve una lista de todos los climas registrados en el sistema.
     * @return Lista de climas.
     */
    List<Clima> consultarClimas();
    
    boolean guardarItinerario(Itinerario itinerario);
    
    Itinerario verificarExistenciaItinerario(String nombre);
    
    List<Zona> consultarZonas();
    
    
     /**
     * Devuelve una lista de las visitas guiadas del ultmo mes registrados en el sistema.
     * @return Lista de visitasGuiadas.
     */
    List <VisitaGuiada> consultarMes();
    
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
     * @return True en caso de guardarse correctamente, Flase en caso contrario.
     */
    boolean guardarAnimal(Animal animal);
    
    /**
     * Devuelve la lista de todos los Animales que pertenezcan a la especie dada
     * como parámetro.
     * @param especie Especie a buscar.
     * @return Lista de Animales con la misma especie.
     */
    List<Animal> consultarAnimalesEspecie(Especie especie);
    
    /**
     * Devuelve la Especie que tenga el nombre vulgar igual al dado como parámetro
     * si existe.
     * @param nombre Nombre a buscar
     * @return Especie con nombre idéntico, Null en caso de no haber uno.
     */
    Especie verificarEspecieNombre(String nombre);
    
    /**
     * Devuelve la Especie que tenga el nombre científico igual al dado como parámetro
     * si existe.
     * @param nombre Nombre a buscar.
     * @return Especie con nombre científico idéntico, Null en caso de no haber uno.
     */
    Especie verificarEspecieNombreCientifico(String nombre);
    
    /**
     * Almacena la especie dada como parámetro.
     * 
     * @param especie Especie a almacenar.
     * @return True si se guarda correctamente, False en caso contrario.
     */
    boolean guardarEspecie(Especie especie);
    
    /**
     * Agrega al cuidador dado como parámetro, la ficha de cargo dada como parámetro.
     * @param cuidador Cuidador a agregar ficha de cargo.
     * @param fichaCargo Ficha de cargo a agregar.
     * @return True si se agregó, False en caso contrario.
     */
    boolean agregarFichaCargoCuidador(Cuidador cuidador, CargoEspecie fichaCargo);
    
    /**
     * Elimina el Animal dado como parámetro.
     * @param animal Animal a eliminar.
     * @return True en caso de eliminarse correctamente, False en caso contrario.
     */
    boolean eliminarAnimal(Animal animal);
}
