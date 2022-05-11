package entidades;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa un Animal del Zoológico
 * 
 * @author Marin
 */
public class Animal {
    
    private ObjectId id;
    private Especie especie;
    private String nombre;
    private int edad;
    private String sexo;

    public Animal() {
    }

    public Animal(Especie especie, String nombre, int edad, String sexo) {
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    
    public Animal(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Animal(ObjectId id, Especie especie, String nombre, int edad, String sexo) {
        this.id = id;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public void generarId(){
        this.id = new ObjectId();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.especie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.especie, other.especie);
    }


    @Override
    public String toString() {
        return nombre;
    }
}
