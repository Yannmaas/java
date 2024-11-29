package gsb.tests;

import gsb.modele.Stock;
import gsb.modele.Visiteur;
import gsb.modele.Medicament;
import gsb.service.StockService;

import java.util.ArrayList;

public class StockServiceTest {

    public static void main(String[] args) {
        // Test de la méthode ajoutStock()
        System.out.println("Test de la méthode ajoutStock()");

        int quantite = 100;
        String matricule = "V001"; // Remplacer par un matricule existant
        String medDepotLegal = "DE123"; // Remplacer par un code médicament existant

        int resultatAjout = StockService.ajoutStock(quantite, matricule, medDepotLegal);
        if (resultatAjout == 1) {
            System.out.println("Stock ajouté avec succès !");
        } else if (resultatAjout == 2) {
            System.out.println("Le stock a déjà été ajouté pour ce visiteur et médicament.");
        } else {
            System.out.println("Échec de l'ajout du stock.");
        }

        // Test de la méthode rechercherStock()
        System.out.println("\nTest de la méthode rechercherStock()");
        Stock stock = StockService.rechercherStock(matricule, medDepotLegal);
        if (stock != null) {
            System.out.println("Stock trouvé :");
            System.out.println("Quantité : " + stock.getQteStock());
        } else {
            System.out.println("Aucun stock trouvé pour le visiteur " + matricule + " et le médicament " + medDepotLegal);
        }

        // Test de la méthode updateStock()
        System.out.println("\nTest de la méthode updateStock()");
        if (stock != null) {
            stock.setQteStock(200); // Met à jour la quantité du stock
            int resultatUpdate = StockService.updateStock(stock);
            if (resultatUpdate == 1) {
                System.out.println("Stock mis à jour avec succès !");
            } else if (resultatUpdate == 2) {
                System.out.println("Le stock a déjà été mis à jour pour ce visiteur et médicament.");
            } else {
                System.out.println("Échec de la mise à jour du stock.");
            }
        }

        // Test de la méthode listeStockVisiteur()
        System.out.println("\nTest de la méthode listeStockVisiteur()");
        ArrayList<Stock> listeStocks = StockService.listeStockVisiteur(matricule);
        if (listeStocks != null && !listeStocks.isEmpty()) {
            System.out.println("Liste des stocks pour le visiteur " + matricule + ":");
            for (Stock st : listeStocks) {
                System.out.println("Médicament : " + st.getUnMedicament().getMed_depotlegal() + ", Quantité : " + st.getQteStock());
            }
        } else {
            System.out.println("Aucun stock trouvé pour le visiteur " + matricule);
        }
    }
}
