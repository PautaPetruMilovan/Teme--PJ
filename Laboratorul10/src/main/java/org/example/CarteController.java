package org.example;

import com.example.lab10.model.Carte;
import com.example.lab10.service.CarteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarteController {
    private final CarteService service;

    public CarteController(CarteService service) {
        this.service = service;
    }

    @GetMapping("/lista-carti")
    public String getCarti(Model model) {
        List<Carte> carti = service.getAllCarti();
        model.addAttribute("carti", carti);
        return "lista-carti";
    }

    @PostMapping("/adauga")
    public String adaugaCarte(@ModelAttribute Carte carte) {
        service.addCarte(carte);
        return "redirect:/lista-carti";
    }

    @PostMapping("/sterge/{isbn}")
    public String stergeCarte(@PathVariable String isbn) {
        service.deleteCarte(isbn);
        return "redirect:/lista-carti";
    }

    @PostMapping("/modifica")
    public String modificaCarte(@ModelAttribute Carte carte) {
        service.updateCarte(carte);
        return "redirect:/lista-carti";
    }
}