package org.example;

import org.example.model.Eveniment;
import org.example.service.EvenimentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/evenimente")
public class EvenimentController {
    private final EvenimentService service;

    public EvenimentController(EvenimentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Eveniment> getAllEvenimente() {
        return service.getAllEvenimente();
    }

    @PostMapping
    public Eveniment addEveniment(@RequestBody Eveniment eveniment) {
        return service.addEveniment(eveniment);
    }

    @GetMapping("/locatie/{locatie}")
    public List<Eveniment> getEvenimenteByLocatie(@PathVariable String locatie) {
        return service.getEvenimenteByLocatie(locatie);
    }

    @GetMapping("/data/{data}")
    public List<Eveniment> getEvenimenteByData(@PathVariable String data) {
        return service.getEvenimenteByData(LocalDate.parse(data));
    }

    @DeleteMapping("/{id}")
    public void deleteEveniment(@PathVariable Long id) {
        service.deleteEveniment(id);
    }
}