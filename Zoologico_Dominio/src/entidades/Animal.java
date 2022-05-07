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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Animal{");
        sb.append("id=").append(id);
        sb.append(", especie=").append(especie);
        sb.append(", nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", sexo=").append(sexo);
        sb.append('}');
        return sb.toString();
    }
}
