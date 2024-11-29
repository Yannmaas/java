package gsb.tests;

import gsb.modele.Medicament;

public class MedicamentTest {

    public static void main(String[] args) {
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

        // Affichage des informations du médicament
        System.out.println("Détails du médicament :");
        System.out.println("Dépot légal : " + medicament.getMed_depotlegal());
        System.out.println("Nom commercial : " + medicament.getMed_nomcommercial());
        System.out.println("Composition : " + medicament.getMed_composition());
        System.out.println("Effets : " + medicament.getMed_effets());
        System.out.println("Contre-indications : " + medicament.getMed_contreindic());
        System.out.println("Prix échantillon : " + medicament.getMed_prixechantillon() + "€");
        System.out.println("Code de famille : " + medicament.getFam_code());
        System.out.println("Libellé de famille : " + medicament.getFam_libelle());

        // Modification des attributs du médicament
        medicament.setMed_nomcommercial("Efferalgan");
        medicament.setMed_composition("Paracétamol 1000mg");
        medicament.setMed_prixechantillon(3.00f);

        // Affichage des informations modifiées
        System.out.println("\nMise à jour du médicament :");
        System.out.println("Nom commercial : " + medicament.getMed_nomcommercial());
        System.out.println("Composition : " + medicament.getMed_composition());
        System.out.println("Prix échantillon : " + medicament.getMed_prixechantillon() + "€");
    }
}
