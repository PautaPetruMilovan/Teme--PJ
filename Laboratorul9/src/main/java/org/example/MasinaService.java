package org.example;

package com.example.masini.service;

import com.example.masini.model.Masina;
import com.example.masini.repository.MasinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasinaService {
    private final MasinaRepository masinaRepository;

    public MasinaService(MasinaRepository masinaRepository) {
        this.masinaRepository = masinaRepository;
    }

    public void adaugaMasina(Masina masina) {
        masinaRepository.save(masina);
    }

    public void stergeMasina(String nrInmatriculare) {
        masinaRepository.deleteById(nrInmatriculare);
    }

    public Masina cautaMasina(String nrInmatriculare) {
        return masinaRepository.findById(nrInmatriculare).orElse(null);
    }

    public List<Masina> extrageToateMasinile() {
        return (List<Masina>) masinaRepository.findAll();
    }

    public int numarMasiniMarca(String marca) {
        return masinaRepository.countByMarca(marca);
    }

    public List<Masina> masiniSub100kKm() {
        return masinaRepository.findAllUnder100kKm();
    }

    public List<Masina> masiniMaiNoiDe5Ani() {
        return masinaRepository.findAllUnder5Years();
    }
}
