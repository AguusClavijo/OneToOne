package com.onetoOne1.onetoOne1.repository;

import com.onetoOne1.onetoOne1.model.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {
}
