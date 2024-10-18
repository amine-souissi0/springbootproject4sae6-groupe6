package tn.examen.templateexamen2324.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.examen.templateexamen2324.entity.Commande;
import tn.examen.templateexamen2324.entity.EtatCommande;
import tn.examen.templateexamen2324.entity.Produit;
import tn.examen.templateexamen2324.repository.CommandeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ProduitService produitService; // Inject ProduitService

    // Method to add a Commande with references to existing Products
    public Commande ajouterCommande(Commande commande) {
        Set<Produit> produits = new HashSet<>();

        // Fetch existing products from the database using their IDs
        for (Produit produit : commande.getProduits()) {
            Optional<Produit> produitExistant = produitService.trouverProduitParId(produit.getId());
            produitExistant.ifPresent(produits::add);  // Attach the existing product to the set
        }

        commande.setProduits(produits);  // Set the fetched products to the Commande

        // Save only the Commande (the products are already persisted)
        return commandeRepository.save(commande);
    }


    // Other methods to manage Commandes
    public List<Commande> trouverToutesCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> trouverCommandeParId(Long id) {
        return commandeRepository.findById(id);
    }

    public Commande annulerCommande(Long id) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
        commande.setEtatCommande(EtatCommande.ANNULEE);
        return commandeRepository.save(commande);
    }

    public void supprimerCommande(Long id) {
        commandeRepository.deleteById(id);
    }

    public Commande modifierCommande(Long id, Commande nouvelleCommande) {
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
        commande.setEtatCommande(nouvelleCommande.getEtatCommande());
        commande.setNombreDeProduits(nouvelleCommande.getNombreDeProduits());
        // Update other fields if necessary
        return commandeRepository.save(commande);
    }
}
