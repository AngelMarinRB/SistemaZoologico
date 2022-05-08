package fachada;

import daos.AnimalesDAO;
import daos.ClimasDAO;
import daos.ContinentesDAO;
import daos.CuidadoresDAO;
import daos.EspeciesDAO;
import daos.FabricaDAO;
import daos.HabitatsDAO;
import daos.ItinerariosDAO;
import daos.VegetacionesDAO;
import daos.ZonasDAO;
import entidades.Animal;
import entidades.Clima;
import entidades.Continente;
import entidades.Cuidador;
import entidades.Especie;
import entidades.Habitat;
import entidades.Itinerario;
import entidades.Vegetacion;
import entidades.Zona;
import interfaces.IDatos;
import java.util.List;

/**
 * Clase Fachada para el subsistema de Datos
 * 
 * @author Marin
 */
public class FacadeDatos implements IDatos{
    
    private FabricaDAO fabrica;
    private ClimasDAO climas;
    private ContinentesDAO continentes;
    private VegetacionesDAO vegetaciones;
    private HabitatsDAO habitats;
    private ItinerariosDAO itinerarios;
    private ZonasDAO zonas;
    private CuidadoresDAO cuidadores;
    private AnimalesDAO animales;
    private EspeciesDAO especies;
    
    public FacadeDatos(){
        fabrica = new FabricaDAO();
        
        this.climas = fabrica.crearClimasDAO();
        this.continentes = fabrica.crearContinentesDAO();
        this.continentes = fabrica.crearContinentesDAO();
        this.vegetaciones = fabrica.crearVegetacionesDAO();
        this.habitats = fabrica.crearHabitatsDAO();
        this.itinerarios = fabrica.crearItinerariosDAO();
        this.zonas = fabrica.crearZonasDAO();
        this.cuidadores = fabrica.crearCuidadoresDAO();
        this.animales = fabrica.crearAnimalesDAO();
        this.especies = fabrica.crearEspeciesDAO();
    }

    @Override
    public boolean guardarHabitat(Habitat habitat) {
        
        try{
            habitats.guardar(habitat);
            return true;
        }catch(Exception e){
            System.err.print(e);
            return false;
        }
    }

    @Override
    public Habitat consultarHabitatNombre(String nombre) {
        
        try{
            return habitats.consultarNombre(nombre);
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public List<Clima> consultarClimas() {
        
        try{
            return climas.consultarTodos();
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public List<Vegetacion> consultarVegetaciones() {
        
        try{
            return vegetaciones.consultarTodos();
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public List<Continente> consultarContinentes() {
        
        try{
            return continentes.consultarTodos();
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }
    
    @Override
    public boolean guardarItinerario(Itinerario itinerario) {
        
        try{
            itinerarios.guardar(itinerario);
            return true;
        }catch(Exception e){
            System.err.print(e);
            return false;
        }
    }

    @Override
    public Itinerario consultarItinerarioNombre(String nombre) {
        
        try{
            return itinerarios.consultarNombre(nombre);
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }
    
     @Override
    public List<Zona> consultarZonas() {
        
        try{
            return zonas.consultarTodos();
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public List<Habitat> consultarHabitats() {
        
        try{
            return habitats.consultarTodos();
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public List<Cuidador> consultarCuidadores() {
        
        try{
            return cuidadores.consultarTodos();
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public List<Animal> consultarAnimalesEspecie(Especie especie) {
        
        try{
            return animales.consultarPorEspecie(especie);
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public boolean guardarAnimal(Animal animal) {
        
        try{
            return animales.guardar(animal);
        }catch(Exception e){
            System.err.print(e);
            return false;
        }
    }

    @Override
    public Especie consultarEspecieNombre(String nombre) {
        
        try{
            return especies.consultarNombre(nombre);
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public Especie consultarEspecieNombreCientifico(String nombre) {

        try{
            return especies.consultarNombreCientifico(nombre);
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }

    @Override
    public boolean guardarEspecie(Especie especie) {

        try{
            return especies.guardar(especie);
        }catch(Exception e){
            System.err.print(e);
            return false;
        }
    }

    @Override
    public List<Especie> consultarEspecies() {
        
        try{
            return especies.consultarTodos();
        }catch(Exception e){
            System.err.print(e);
            return null;
        }
    }
    
}
