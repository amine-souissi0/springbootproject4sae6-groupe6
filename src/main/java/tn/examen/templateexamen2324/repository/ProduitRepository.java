package tn.examen.templateexamen2324.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.examen.templateexamen2324.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Méthodes personnalisées si besoin
}
