package tn.examen.templateexamen2324.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.examen.templateexamen2324.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Méthodes personnalisées si besoin
}

