package com.onetoOne1.onetoOne1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Registro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String poliza;
    private String numeroPoliza;
    private String nombreAseguradora;

    @OneToOne
    @JoinColumn(name = "id_vehiculo")
    @JsonBackReference
    private Vehiculo vehiculo;

    public Registro() {
    }

    public Registro(String poliza, String numeroPoliza, String nombreAseguradora, Vehiculo vehiculo) {
        this.poliza = poliza;
        this.numeroPoliza = numeroPoliza;
        this.nombreAseguradora = nombreAseguradora;
        this.vehiculo = vehiculo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getNombreAseguradora() {
        return nombreAseguradora;
    }

    public void setNombreAseguradora(String nombreAseguradora) {
        this.nombreAseguradora = nombreAseguradora;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
