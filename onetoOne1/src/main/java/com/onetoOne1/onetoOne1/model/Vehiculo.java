package com.onetoOne1.onetoOne1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Vehiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marca;
    private String modelo;
    private String anio;

    @OneToOne(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Registro registro;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String año) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}
