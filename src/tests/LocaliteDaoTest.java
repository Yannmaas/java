package gsb.tests;

import gsb.modele.Localite;
import gsb.modele.dao.LocaliteDao;

public class LocaliteDaoTest {

    public static void main(String[] args) {
        // Test de la méthode rechercher avec un code postal existant
        System.out.println("Recherche d'une localité avec un code postal existant :");
        Localite localiteExistante = LocaliteDao.rechercher("75000"); // Exemple d'un code postal existant
        if (localiteExistante != null) {
            System.out.println("Localité trouvée :");
            System.out.println("Code Postal : " + localiteExistante.getCodePostal());
            System.out.println("Ville : " + localiteExistante.getVille());
        } else {
            System.out.println("Aucune localité trouvée pour ce code postal.");
        }

        // Test de la méthode rechercher avec un code postal inexistant
        System.out.println("\nRecherche d'une localité avec un code postal inexistant :");
        Localite localiteInexistante = LocaliteDao.rechercher("99999"); // Exemple d'un code postal inexistant
        if (localiteInexistante != null) {
            System.out.println("Localité trouvée :");
            System.out.println("Code Postal : " + localiteInexistante.getCodePostal());
            System.out.println("Ville : " + localiteInexistante.getVille());
        } else {
            System.out.println("Aucune localité trouvée pour ce code postal.");
        }
    }
}
