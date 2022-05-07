package fachada;

import controles.ControlCuidadores;
import controles.ControlClimas;
import controles.ControlContinentes;
import controles.ControlHabitats;
import controles.ControlItinerarios;
import controles.ControlVegetaciones;
import controles.ControlZonas;
import controles.FabricaControles;
import entidades.Clima;
import entidades.Continente;
import entidades.Cuidador;
import entidades.Habitat;
import entidades.Itinerario;
import entidades.Vegetacion;
import entidades.Zona;
import interfaces.INegocio;
import java.util.List;

/**
 * Clase de Fachada para el subsistema de Negocio
 * 
 * @author Marin
 */
public class FacadeNegocio implements INegocio{

    private ControlHabitats habitats;
    private ControlClimas climas;
    private ControlContinentes continentes;
    private ControlVegetaciones vegetaciones;
    private ControlItinerarios itinerarios;
    private ControlZonas zonas;
    private ControlCuidadores cuidadores;
    
    public FacadeNegocio(){
        FabricaControles controles = new FabricaControles();
        
        this.habitats = controles.crearControlHabitats();
        this.climas = controles.crearControlClimas();
        this.continentes = controles.crearControlContinentes();
        this.vegetaciones = controles.crearControlVegetaciones();
        this.itinerarios = controles.crearControlItinerarios();
        this.zonas = controles.crearControlZonas();
        this.cuidadores = controles.crearControlAnimales();
    }
    
    @Override
    public boolean guardarHabitat(Habitat habitat) {
        return habitats.guardarHabitat(habitat);
    }

    @Override
    public Habitat verificarExistenciaHabitat(String nombre) {
        return habitats.verificarExistencia(nombre);
    }

    @Override
    public List<Continente> consultarContinentes() {
        return continentes.consultarContinentes();
    }

    @Override
    public List<Vegetacion> consultarVegetaciones() {
        return vegetaciones.consultarVegetaciones();
    }

    @Override
    public List<Clima> consultarClimas() {
        return climas.consultarClimas();
    }

    @Override
    public boolean guardarItinerario(Itinerario itinerario) {
        return itinerarios.guardarItinerario(itinerario);
    }

    @Override
    public Itinerario verificarExistenciaItinerario(String nombre) {
        return itinerarios.verificarExistenciaItinerario(nombre);
    }

    @Override
    public List<Zona> consultarZonas() {
        return zonas.consultarZonas();
    }

    @Override
    public List<Habitat> consultarHabitats() {
        return habitats.consultarHabitats();
    }

    @Override
    public List<Cuidador> consultarCuidadores() {
        return cuidadores.consultarCuidadores();
    }
    
}
