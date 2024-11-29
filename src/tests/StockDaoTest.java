package gsb.tests;

import gsb.modele.Stock;
import gsb.modele.dao.StockDao;

import java.util.ArrayList;

public class StockDaoTest {

    public static void main(String[] args) {
        // Test de la méthode rechercher (matricule + med_depotlegal)
        String matricule = "V001"; // Assurez-vous d'utiliser un matricule existant
        String medDepotLegal = "A001"; // Assurez-vous d'utiliser un dépôt légal existant

        System.out.println("Recherche d'un stock spécifique :");
        Stock stock = StockDao.rechercher(matricule, medDepotLegal);

        if (stock != null) {
            System.out.println("Stock trouvé :");
            System.out.println("Quantité : " + stock.getQteStock());
            System.out.println("Visiteur : " + stock.getUnVisiteur().getNom() + " " + stock.getUnVisiteur().getPrenom());
            System.out.println("Médicament : " + stock.getUnMedicament().getMed_nomcommercial());
        } else {
            System.out.println("Aucun stock trouvé pour le matricule " + matricule + " et le dépôt légal " + medDepotLegal);
        }

        // Test de la méthode rechercher (par matricule uniquement)
        System.out.println("\nRecherche de tous les stocks pour le visiteur avec matricule : " + matricule);
        ArrayList<Stock> listeStock = StockDao.rechercher(matricule);

        if (!listeStock.isEmpty()) {
            System.out.println("Stocks trouvés :");
            for (Stock s : listeStock) {
                System.out.println("- Médicament : " + s.getUnMedicament().getMed_nomcommercial());
                System.out.println("  Quantité : " + s.getQteStock());
            }
        } else {
            System.out.println("Aucun stock trouvé pour le visiteur avec matricule : " + matricule);
        }
    }
}
