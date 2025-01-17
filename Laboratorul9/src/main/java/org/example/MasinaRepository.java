package org.example;

package com.example.masini.repository;

import com.example.masini.model.Masina;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MasinaRepository extends CrudRepository<Masina, String> {

    @Query("SELECT COUNT(*) FROM masina WHERE marca = :marca")
    int countByMarca(String marca);

    @Query("SELECT * FROM masina WHERE numar_kilometri < 100000")
    List<Masina> findAllUnder100kKm();

    @Query("SELECT * FROM masina WHERE an_fabricatie > YEAR(CURDATE()) - 5")
    List<Masina> findAllUnder5Years();
}
