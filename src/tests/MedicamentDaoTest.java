package gsb.tests;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

import java.util.ArrayList;
import java.util.SortedMap;

public class MedicamentDaoTest {

    public static void main(String[] args) {
        // Test de la méthode rechercher
        String codeMedicament = "A001"; // Assurez-vous d'utiliser un code existant
        System.out.println("Recherche du médicament avec le code : " + codeMedicament);
        Medicament medicament = MedicamentDao.rechercher(codeMedicament);

        if (medicament != null) {
            System.out.println("Médicament trouvé :");
            System.out.println("Code : " + medicament.getMed_depotlegal());
            System.out.println("Nom commercial : " + medicament.getMed_nomcommercial());
            System.out.println("Composition : " + medicament.getMed_composition());
            System.out.println("Effets : " + medicament.getMed_effets());
            System.out.println("Contre-indications : " + medicament.getMed_contreindic());
            System.out.println("Prix échantillon : " + medicament.getMed_prixechantillon());
            System.out.println("Code famille : " + medicament.getFam_code());
            System.out.println("Libellé famille : " + medicament.getFam_libelle());
        } else {
            System.out.println("Aucun médicament trouvé pour le code : " + codeMedicament);
        }

        // Test de la méthode retournerCollectionDesMedicaments
        System.out.println("\nListe de tous les médicaments :");
        ArrayList<Medicament> listeMedicaments = MedicamentDao.retournerCollectionDesMedicaments();

        for (Medicament med : listeMedicaments) {
            System.out.println("- " + med.getMed_depotlegal() + " : " + med.getMed_nomcommercial());
        }

        // Test de la méthode retournerDictionnaireDesMedicaments
        System.out.println("\nDictionnaire des médicaments :");
        SortedMap<String, Medicament> dicoMedicaments = MedicamentDao.retournerDictionnaireDesMedicaments();

        for (String key : dicoMedicaments.keySet()) {
            Medicament med = dicoMedicaments.get(key);
            System.out.println("Clé : " + key + ", Nom : " + med.getMed_nomcommercial());
        }

        // Test de la méthode creer
        System.out.println("\nCréation d'un nouveau médicament...");
        Medicament nouveauMedicament = new Medicament(
            "B002", // depotlegal
            "Paracetamol 500mg", // nomcommercial
            "Paracetamol", // composition
            "Soulagement de la douleur", // effets
            "Hypersensibilité au paracétamol", // contreindic
            1.50f, // prixechantillon
            "F001", // fam_code
            "Antalgique" // fam_libelle
        );

        int result = MedicamentDao.creer(nouveauMedicament);

        if (result > 0) {
            System.out.println("Médicament créé avec succès !");
        } else {
            System.out.println("Échec de la création du médicament.");
        }
    }
}
