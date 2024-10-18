package tn.examen.templateexamen2324.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designation;
    private String description;
    private String imageURL;
    private String image;
    private Double prix;
    private Long quantite;
    private String nomPrenomPeintre;
    private String nomPrenomAuteur;
    private Boolean gratuit;
    private String langue;

    @Enumerated(EnumType.STRING)
    private CategorieProduit categorie;

    @Enumerated(EnumType.STRING)
    private EtatProduit etatProduit;

    // Relation Many-to-One avec Commande
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Commande commande;
}
