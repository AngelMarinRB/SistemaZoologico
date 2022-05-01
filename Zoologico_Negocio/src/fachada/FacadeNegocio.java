package fachada;

import controles.ControlClimas;
import controles.ControlContinentes;
import controles.ControlHabitats;
import controles.ControlVegetaciones;
import controles.FabricaControles;
import entidades.Clima;
import entidades.Continente;
import entidades.Habitat;
import entidades.Vegetacion;
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
    
    public FacadeNegocio(){
        FabricaControles controles = new FabricaControles();
        
        this.habitats = controles.crearControlHabitats();
        this.climas = controles.crearControlClimas();
        this.continentes = controles.crearControlContinentes();
        this.vegetaciones = controles.crearControlVegetaciones();
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
    
}
