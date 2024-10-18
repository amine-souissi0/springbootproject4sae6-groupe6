package tn.examen.templateexamen2324.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.examen.templateexamen2324.entity.Commande;
import tn.examen.templateexamen2324.services.CommandeService;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Endpoint to add a new Commande
    @PostMapping("/ajouter")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande) {
        return ResponseEntity.ok(commandeService.ajouterCommande(commande));
    }

    // Endpoint to retrieve all Commandes
    @GetMapping("/toutes")
    public ResponseEntity<List<Commande>> obtenirToutesCommandes() {
        return ResponseEntity.ok(commandeService.trouverToutesCommandes());
    }

    // Endpoint to retrieve a Commande by ID
    @GetMapping("/{id}")
    public ResponseEntity<Commande> obtenirCommandeParId(@PathVariable Long id) {
        return commandeService.trouverCommandeParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to modify a Commande by ID
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Commande> modifierCommande(@PathVariable Long id, @RequestBody Commande commande) {
        return ResponseEntity.ok(commandeService.modifierCommande(id, commande));
    }

    // Endpoint to cancel a Commande by ID
    @DeleteMapping("/annuler/{id}")
    public ResponseEntity<Void> annulerCommande(@PathVariable Long id) {
        commandeService.annulerCommande(id);
        return ResponseEntity.noContent().build();
    }
}
