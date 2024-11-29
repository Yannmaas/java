package gsb.tests;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

import java.util.ArrayList;
import java.util.SortedMap;

public class VisiteurDaoTest {

    public static void main(String[] args) {
        // Test de la méthode rechercher()
        String matricule = "V001"; // Remplacer par un matricule existant dans votre base
        System.out.println("Test de la méthode rechercher() pour le matricule : " + matricule);
        Visiteur visiteur = VisiteurDao.rechercher(matricule);
        if (visiteur != null) {
            System.out.println("Visiteur trouvé :");
            System.out.println("Matricule : " + visiteur.getMatricule() +
                    ", Nom : " + visiteur.getNom() +
                    ", Prénom : " + visiteur.getPrenom() +
                    ", Adresse : " + visiteur.getAdresse());
        } else {
            System.out.println("Aucun visiteur trouvé pour le matricule : " + matricule);
        }

        // Test de la méthode getCodesPostaux()
        System.out.println("\nTest de la méthode getCodesPostaux()");
        ArrayList<String> codesPostaux = VisiteurDao.getCodesPostaux();
        System.out.println("Codes postaux récupérés :");
        for (String codePostal : codesPostaux) {
            System.out.println(codePostal);
        }

        // Test de la méthode retournerCollectionDesVisiteurs()
        System.out.println("\nTest de la méthode retournerCollectionDesVisiteurs()");
        ArrayList<Visiteur> collectionVisiteurs = VisiteurDao.retournerCollectionDesVisiteurs();
        System.out.println("Liste des visiteurs :");
        for (Visiteur v : collectionVisiteurs) {
            System.out.println("Matricule : " + v.getMatricule() +
                    ", Nom : " + v.getNom() +
                    ", Prénom : " + v.getPrenom());
        }

        // Test de la méthode retournerDictionnaireDesVisiteurs()
        System.out.println("\nTest de la méthode retournerDictionnaireDesVisiteurs()");
        SortedMap<String, Visiteur> dictionnaireVisiteurs = VisiteurDao.retournerDictionnaireDesVisiteurs();
        System.out.println("Dictionnaire des visiteurs :");
        for (String key : dictionnaireVisiteurs.keySet()) {
            Visiteur v = dictionnaireVisiteurs.get(key);
            System.out.println("Clé : " + key +
                    ", Matricule : " + v.getMatricule() +
                    ", Nom : " + v.getNom() +
                    ", Prénom : " + v.getPrenom());
        }

        // Test de la méthode creer()
        System.out.println("\nTest de la méthode creer()");
        Visiteur nouveauVisiteur = new Visiteur("V999", "Dupont", "Jean", "jdupont", "mdp123", 
                "0601234567", "10 Rue Exemple", "75000", "2024-01-01", 500.0f, "U001", "Unité Test");
        int resultat = VisiteurDao.creer(nouveauVisiteur);
        if (resultat > 0) {
            System.out.println("Nouveau visiteur ajouté avec succès !");
        } else {
            System.out.println("Échec de l'ajout du visiteur.");
        }
    }
}
