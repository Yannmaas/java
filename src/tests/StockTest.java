package gsb.tests;

import gsb.modele.Stock;
import gsb.modele.Visiteur;
import gsb.modele.Medicament;

public class StockTest {

    public static void main(String[] args) {
        // Création d'un objet Visiteur
        Visiteur visiteur = new Visiteur(
            "V001", // Matricule
            "Dupont", // Nom
            "Jean", // Prénom
            "12 Rue des Lilas, Paris", // Adresse
            "75000", // Code postal
            "Paris", // Ville
            "01-23-45-67-89" // Téléphone
, null, null, null, null, null
        );

        // Création d'un objet Medicament
        Medicament medicament = new Medicament(
            "DL001", // med_depotlegal
            "Doliprane", // med_nomcommercial
            "Paracétamol 500mg", // med_composition
            "Soulage la douleur et la fièvre", // med_effets
            "Insuffisance hépatique", // med_contreindic
            2.50f, // med_prixechantillon
            "ANALG", // fam_code
            "Antalgique" // fam_libelle
        );

        // Création d'un objet Stock
        Stock stock = new Stock(
            50, // Quantité en stock
            visiteur, // Visiteur associé
            medicament // Médicament associé
        );

        // Affichage des informations du stock
        System.out.println("Détails du stock :");
        System.out.println("Quantité en stock : " + stock.getQteStock());
        System.out.println("Visiteur associé : " + stock.getUnVisiteur().getNom() + " " + stock.getUnVisiteur().getPrenom());
        System.out.println("Médicament associé : " + stock.getUnMedicament().getMed_nomcommercial());

        // Modification des attributs du stock
        stock.setQteStock(30);
        Medicament nouveauMedicament = new Medicament(
            "DL002", // med_depotlegal
            "Efferalgan", // med_nomcommercial
            "Paracétamol 1000mg", // med_composition
            "Soulage la douleur et la fièvre", // med_effets
            "Insuffisance hépatique", // med_contreindic
            3.00f, // med_prixechantillon
            "ANALG", // fam_code
            "Antalgique" // fam_libelle
        );
        stock.setUnMedicament(nouveauMedicament);

        // Affichage des informations modifiées du stock
        System.out.println("\nMise à jour du stock :");
        System.out.println("Quantité en stock : " + stock.getQteStock());
        System.out.println("Médicament associé : " + stock.getUnMedicament().getMed_nomcommercial());
    }
}
