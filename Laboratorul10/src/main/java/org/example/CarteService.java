package org.example;

import com.example.lab10.model.Carte;
import com.example.lab10.repository.CarteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteService {
    private final CarteRepository repository;

    public CarteService(CarteRepository repository) {
        this.repository = repository;
    }

    public List<Carte> getAllCarti() {
        return repository.findAll();
    }

    public Optional<Carte> getCarteByIsbn(String isbn) {
        return repository.findById(isbn);
    }

    public void addCarte(Carte carte) {
        repository.save(carte);
    }

    public void updateCarte(Carte carte) {
        if (repository.existsById(carte.getIsbn())) {
            repository.save(carte);
        }
    }

    public void deleteCarte(String isbn) {
        repository.deleteById(isbn);
    }

    public List<Carte> getCartiByAutor(String autor) {
        return repository.findByAutor(autor);
    }
}