package entidades;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase Cuidador la cual es un tipo de Empleado dentro del sistema
 * 
 * @author Marin
 */
public class Cuidador extends Empleado{
    
    private List<Especie> especiesExperto;
    private List<Especie> especiesBasico;
    private List<CargoEspecie> especiesCargo;

    /**
     * Crea un cuidador
     */
    public Cuidador() {
        super();
    }

    /**
     * Crea un cuidador con los parámetros dados.
     * @param nombre Nombre.
     * @param direccion Dirección.
     * @param telefono Teléfono
     * @param fechaInicio Fecha Inicio.
     */
    public Cuidador(String nombre, String direccion, String telefono, Date fechaInicio){
        super(nombre, direccion, telefono, fechaInicio);
    }

    /**
     * Crea un cuidador con las especies en las que tiene conocimientos Básicos y Expertos, además de sus especies a cargo.
     * @param especiesExperto Lista de especies experto.
     * @param especiesBasico Lista de especies básico.
     * @param especiesCargo  Lista de especies a cargo.
     */
    public Cuidador(List<Especie> especiesExperto, List<Especie> especiesBasico, List<CargoEspecie> especiesCargo) {
        this.especiesExperto = especiesExperto;
        this.especiesBasico = especiesBasico;
        this.especiesCargo = especiesCargo;
    }

    /**
     * Crea un cuidador con los parámetros dados.
     * @param especiesExperto Lista de especies experto.
     * @param especiesBasico Lista de especies básico.
     * @param especiesCargo  Lista de especies a cargo.
     * @param nombre Nombre.
     * @param direccion Dirección.
     * @param telefono Teléfono
     * @param fechaInicio Fecha Inicio.
     */
    public Cuidador(List<Especie> especiesExperto, List<Especie> especiesBasico, List<CargoEspecie> especiesCargo, String nombre, String direccion, String telefono, Date fechaInicio) {
        super(nombre, direccion, telefono, fechaInicio);
        this.especiesExperto = especiesExperto;
        this.especiesBasico = especiesBasico;
        this.especiesCargo = especiesCargo;
    }

    /**
     * Crea un cuidador con los parámetros dados.
     * @param id Id
     * @param especiesExperto Lista de especies experto.
     * @param especiesBasico Lista de especies básico.
     * @param especiesCargo  Lista de especies a cargo.
     * @param nombre Nombre.
     * @param direccion Dirección.
     * @param telefono Teléfono
     * @param fechaInicio Fecha Inicio.
     */
    public Cuidador(List<Especie> especiesExperto, List<Especie> especiesBasico, List<CargoEspecie> especiesCargo, ObjectId id, String nombre, String direccion, String telefono, Date fechaInicio) {
        super(id, nombre, direccion, telefono, fechaInicio);
        this.especiesExperto = especiesExperto;
        this.especiesBasico = especiesBasico;
        this.especiesCargo = especiesCargo;
    }

    /**
     * Devuelve una lista de las especies en los que es experto
     * @return Lista de Especies experto
     */
    public List<Especie> getEspeciesExperto() {
        return especiesExperto;
    }

    /**
     * Establece la lista de especies en los que es experto.
     * @param especiesExperto Lista de especies
     */
    public void setEspeciesExperto(List<Especie> especiesExperto) {
        this.especiesExperto = especiesExperto;
    }

    /**
     * Devuelve la lista de las especies en los que tiene conocimientos básicos
     * @return Lista de especies básico
     */
    public List<Especie> getEspeciesBasico() {
        return especiesBasico;
    }

    /**
     * Establece la lista de especies en los que tiene conocimiento básico
     * @param especiesBasico Lista de especies básico
     */
    public void setEspeciesBasico(List<Especie> especiesBasico) {
        this.especiesBasico = especiesBasico;
    }

    /**
     * Devuelve una lista de las especies de las que se encarga.
     * @return Lista de especies.
     */
    public List<CargoEspecie> getEspeciesCargo() {
        return especiesCargo;
    }

    /**
     * Establece la lista de especies de las que se hace cargo.
     * @param especiesCargo Lista de especies.
     */
    public void setEspeciesCargo(List<CargoEspecie> especiesCargo) {
        this.especiesCargo = especiesCargo;
    }
    
    
}
