package gsb.tests;

import gsb.modele.Localite;

public class LocaliteTest {

    public static void main(String[] args) {
        // Création d'un objet Localite
        Localite localite = new Localite("75000", "Paris");

        // Affichage des informations initiales
        System.out.println("Détails de la localité :");
        System.out.println("Code postal : " + localite.getCodePostal());
        System.out.println("Ville : " + localite.getVille());

        // Modification des attributs de la localité
        localite.setCodePostal("69000");
        localite.setVille("Lyon");

        // Affichage des informations mises à jour
        System.out.println("\nMise à jour de la localité :");
        System.out.println("Code postal : " + localite.getCodePostal());
        System.out.println("Ville : " + localite.getVille());
    }
}
