package tn.examen.templateexamen2324.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long nombreDeProduits;
    private Long telUtilisateur;
    private Long idUtilisateur;
    private Double prixTotal;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeModification;

    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    // Relation One-to-Many avec Produit
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Set<Produit> produits = new HashSet<>();
}

