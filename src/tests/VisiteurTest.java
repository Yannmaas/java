package gsb.tests;

import gsb.modele.Visiteur;

public class VisiteurTest {

    public static void main(String[] args) {
        // Création d'un objet Visiteur
        Visiteur visiteur = new Visiteur(
            "V001",             // matricule
            "Dupont",           // nom
            "Jean",             // prenom
            "jdupont",          // login
            "mdp123",           // mdp
            "01-23-45-67-89",   // telephone
            "12 Rue des Lilas", // adresse
            "75000",            // codepostal
            "2020-01-15",       // dateentree
            500.75f,            // prime
            "U001",             // codeunit
            "Unité Paris"       // nomunit
        );

        // Affichage des informations du visiteur
        System.out.println("Détails du visiteur :");
        System.out.println("Matricule : " + visiteur.getMatricule());
        System.out.println("Nom : " + visiteur.getNom());
        System.out.println("Prénom : " + visiteur.getPrenom());
        System.out.println("Login : " + visiteur.getLogin());
        System.out.println("Mot de passe : " + visiteur.getMdp());
        System.out.println("Téléphone : " + visiteur.getTelephone());
        System.out.println("Adresse : " + visiteur.getAdresse());
        System.out.println("Code postal : " + visiteur.getCodepostal());
        System.out.println("Date d'entrée : " + visiteur.getDateentree());
        System.out.println("Prime : " + visiteur.getPrime());
        System.out.println("Code unité : " + visiteur.getCodeunit());
        System.out.println("Nom unité : " + visiteur.getNomunit());

        // Modification des attributs du visiteur
        visiteur.setNom("Durand");
        visiteur.setPrenom("Marie");
        visiteur.setTelephone("06-54-32-10-98");
        visiteur.setPrime(650.00f);

        // Affichage des informations mises à jour
        System.out.println("\nMise à jour du visiteur :");
        System.out.println("Nom : " + visiteur.getNom());
        System.out.println("Prénom : " + visiteur.getPrenom());
        System.out.println("Téléphone : " + visiteur.getTelephone());
        System.out.println("Prime : " + visiteur.getPrime());
    }
}
