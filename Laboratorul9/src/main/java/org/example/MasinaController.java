package org.example;

package com.example.masini.controller;

import com.example.masini.model.Masina;
import com.example.masini.service.MasinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/masini")
public class MasinaController {
    private final MasinaService masinaService;

    public MasinaController(MasinaService masinaService) {
        this.masinaService = masinaService;
    }

    @PostMapping
    public void adaugaMasina(@RequestBody Masina masina) {
        masinaService.adaugaMasina(masina);
    }

    @DeleteMapping("/{nrInmatriculare}")
    public void stergeMasina(@PathVariable String nrInmatriculare) {
        masinaService.stergeMasina(nrInmatriculare);
    }

    @GetMapping("/{nrInmatriculare}")
    public Masina cautaMasina(@PathVariable String nrInmatriculare) {
        return masinaService.cautaMasina(nrInmatriculare);
    }

    @GetMapping
    public List<Masina> extrageToateMasinile() {
        return masinaService.extrageToateMasinile();
    }

    @GetMapping("/marca/{marca}")
    public int numarMasiniMarca(@PathVariable String marca) {
        return masinaService.numarMasiniMarca(marca);
    }

    @GetMapping("/sub100k")
    public List<Masina> masiniSub100kKm() {
        return masinaService.masiniSub100kKm();
    }

    @GetMapping("/maiNoiDe5Ani")
    public List<Masina> masiniMaiNoiDe5Ani() {
        return masinaService.masiniMaiNoiDe5Ani();
    }
}
