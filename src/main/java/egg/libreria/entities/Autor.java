/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.libreria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Vanesa
 */
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column(unique = true)
    private String nombre;
    @Column(nullable = false)
    private Boolean alta;
    @Column(nullable = false)
    private Boolean visible; //Esto simulara una eliminación, solo lo ocultara para que no sea visible en el front y no borrar de la bd

    public Autor() {
    }

    public Autor(String nombre, Boolean alta) {
        this.nombre = nombre;
        this.alta = alta;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

}
