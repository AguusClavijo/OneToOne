package com.onetoOne1.onetoOne1.controller;

import com.onetoOne1.onetoOne1.model.Vehiculo;
import com.onetoOne1.onetoOne1.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculoService.getVehiculos();
    }

    @GetMapping(path = "/{id}")
    public Optional<Vehiculo> getEmpleadoById(@PathVariable Long id) {
        return this.vehiculoService.getById(id);
    }

    @PostMapping
    public Vehiculo create(@RequestBody Vehiculo vehiculo) {
        if (vehiculo.getRegistro() != null) {
            vehiculo.getRegistro().setVehiculo(vehiculo);
        }
        return vehiculoService.saveVehiculo(vehiculo);
    }

    @PutMapping(path = "/{id}")
    public Vehiculo updateEmpleadoById(@RequestBody Vehiculo request, @PathVariable Long id) {
        return this.vehiculoService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.vehiculoService.deleteVehiculo(id);

        if (ok) {
            return "Vehiculo con id " + id + " eliminado!";
        }
        return "Error, no se pudo eliminar el vehiculo con id"+id;
    }
}
