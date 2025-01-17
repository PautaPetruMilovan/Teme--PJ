package org.example;

import org.example.model.Eveniment;
import org.example.repository.EvenimentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EvenimentService {
    private final EvenimentRepository repository;

    public EvenimentService(EvenimentRepository repository) {
        this.repository = repository;
    }

    public List<Eveniment> getAllEvenimente() {
        return repository.findAll();
    }

    public Eveniment addEveniment(Eveniment eveniment) {
        return repository.save(eveniment);
    }

    public List<Eveniment> getEvenimenteByLocatie(String locatie) {
        return repository.findByLocatie(locatie);
    }

    public List<Eveniment> getEvenimenteByData(LocalDate data) {
        return repository.findByData(data);
    }

    public void deleteEveniment(Long id) {
        repository.deleteById(id);
    }
}