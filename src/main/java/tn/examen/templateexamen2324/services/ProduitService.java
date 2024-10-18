package tn.examen.templateexamen2324.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.examen.templateexamen2324.entity.Produit;
import tn.examen.templateexamen2324.repository.ProduitRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit ajouterProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public List<Produit> trouverTousProduits() {
        return produitRepository.findAll();
    }

    public Optional<Produit> trouverProduitParId(Long id) {
        return produitRepository.findById(id);
    }

    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }

    public Produit modifierProduit(Long id, Produit produitModifie) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        produit.setDescription(produitModifie.getDescription());
        produit.setPrix(produitModifie.getPrix());
        produit.setQuantite(produitModifie.getQuantite());
        // Mise à jour des autres champs si nécessaire
        return produitRepository.save(produit);
    }
}
