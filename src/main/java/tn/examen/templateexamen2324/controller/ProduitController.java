package tn.examen.templateexamen2324.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.examen.templateexamen2324.entity.Produit;
import tn.examen.templateexamen2324.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Add a new product
    @PostMapping("/ajouter")
    public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.ajouterProduit(produit));
    }

    // Get all products
    @GetMapping("/tous")
    public ResponseEntity<List<Produit>> obtenirTousProduits() {
        return ResponseEntity.ok(produitService.trouverTousProduits());
    }

    // Get a product by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Produit> obtenirProduitParId(@PathVariable Long id) {
        return produitService.trouverProduitParId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a product
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Produit> modifierProduit(@PathVariable Long id, @RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.modifierProduit(id, produit));
    }

    // Delete a product
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return ResponseEntity.noContent().build();
    }
}
