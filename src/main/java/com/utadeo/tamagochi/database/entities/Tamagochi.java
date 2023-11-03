/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utadeo.tamagochi.database.entities;

/**
 *
 * @author USUARIO
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tamagochi {
    @Id
    @GeneratedValue
    private Integer id;

    private String nombre;
    private String tipo;
    private Integer baño;
    private Integer sueño;
    private Boolean muerte;
    private Integer hambre;
    private Integer energia;

    public Tamagochi() {
        // Constructor por defecto
    }

    // Getters
    public Integer getId() {
        return id;
    }


    public Integer getSueño() {
        return sueño;
    }

    public Integer getHambre() {
        return hambre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getBaño() {
        return baño;
    }

    public void setBaño(Integer baño) {
        this.baño = baño;
    }

    public Boolean getMuerte() {
        return muerte;
    }

    public void setMuerte(Boolean muerte) {
        this.muerte = muerte;
    }



    
    public Integer getEnergia() {
        return energia;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }



    public void setSueño(Integer sueño) {
        this.sueño = sueño;
    }

    public void setHambre(Integer hambre) {
        this.hambre = hambre;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}

