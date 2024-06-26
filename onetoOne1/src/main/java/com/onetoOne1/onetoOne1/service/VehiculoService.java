package com.onetoOne1.onetoOne1.service;

import com.onetoOne1.onetoOne1.model.Registro;
import com.onetoOne1.onetoOne1.model.Vehiculo;
import com.onetoOne1.onetoOne1.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public ArrayList<Vehiculo> getVehiculos() {
        return (ArrayList<Vehiculo>) vehiculoRepository.findAll();
    }

    public Optional<Vehiculo> getById(Long id) {
        return vehiculoRepository.findById(id);
    }

    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo updateById(Vehiculo request, Long id) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            vehiculo.setMarca(request.getMarca());
            vehiculo.setModelo(request.getModelo());
            vehiculo.setAnio(request.getAnio());

            Registro registro = vehiculo.getRegistro();
            if (registro != null) {
                registro.setPoliza(request.getRegistro().getPoliza());
                registro.setNumeroPoliza(request.getRegistro().getNumeroPoliza());
                registro.setNombreAseguradora(request.getRegistro().getNombreAseguradora());
            }
            return vehiculoRepository.save(vehiculo);
        }
        return null;
    }

    public boolean deleteVehiculo(Long id) {
        try {
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
