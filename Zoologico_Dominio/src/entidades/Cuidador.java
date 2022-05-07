package entidades;

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
    
    public Cuidador(String nombre, String direccion, String telefono, GregorianCalendar fechaInicio){
        super(nombre, direccion, telefono, fechaInicio);
    }

    public Cuidador(List<Especie> especiesExperto, List<Especie> especiesBasico, List<CargoEspecie> especiesCargo) {
        this.especiesExperto = especiesExperto;
        this.especiesBasico = especiesBasico;
        this.especiesCargo = especiesCargo;
    }

    public Cuidador(List<Especie> especiesExperto, List<Especie> especiesBasico, List<CargoEspecie> especiesCargo, String nombre, String direccion, String telefono, GregorianCalendar fechaInicio) {
        super(nombre, direccion, telefono, fechaInicio);
        this.especiesExperto = especiesExperto;
        this.especiesBasico = especiesBasico;
        this.especiesCargo = especiesCargo;
    }

    public Cuidador(List<Especie> especiesExperto, List<Especie> especiesBasico, List<CargoEspecie> especiesCargo, ObjectId id, String nombre, String direccion, String telefono, GregorianCalendar fechaInicio) {
        super(id, nombre, direccion, telefono, fechaInicio);
        this.especiesExperto = especiesExperto;
        this.especiesBasico = especiesBasico;
        this.especiesCargo = especiesCargo;
    }

    public List<Especie> getEspeciesExperto() {
        return especiesExperto;
    }

    public void setEspeciesExperto(List<Especie> especiesExperto) {
        this.especiesExperto = especiesExperto;
    }

    public List<Especie> getEspeciesBasico() {
        return especiesBasico;
    }

    public void setEspeciesBasico(List<Especie> especiesBasico) {
        this.especiesBasico = especiesBasico;
    }

    public List<CargoEspecie> getEspeciesCargo() {
        return especiesCargo;
    }

    public void setEspeciesCargo(List<CargoEspecie> especiesCargo) {
        this.especiesCargo = especiesCargo;
    }
    
}
