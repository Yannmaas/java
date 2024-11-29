/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.utils.ValidationUtils;

import java.util.ArrayList;
/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MedicamentService {
	
	public static Medicament rechercherMedicament(String unCodeMedicament){
		Medicament unMedicament = null;
		try{
		if (unCodeMedicament==null) {
            throw new Exception("Donnee obligatoire : code");
        }
		unMedicament = MedicamentDao.rechercher(unCodeMedicament);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
	public int creerMedicament(String med_depotlegal, String med_nomcommercial,  String med_composition, String med_effets, String med_contreindic,
			Float med_prixechantillon, String fam_code,String fam_libelle){
		Medicament unMedicament = null;
		int resultat = 0;
		try{ // controle des paramètres d'entrée
			 // Si une donnée est manquante on lève une exception
	        if (med_depotlegal==null || med_nomcommercial == null || med_composition == null || med_effets == null || med_contreindic == null || med_prixechantillon == null || fam_code == null || fam_libelle == null) {
	            throw new Exception("Données obligatoires : med_depotlegal, med_nomcommercial, med_composition, med_effets, med_contreindic, med_prixechantillon, fam_code,  fam_libelle");
	        }
	        if (MedicamentDao.rechercher(med_depotlegal) != null) {
	            // Si la base de donnée contient déjà un client ayant ce code on envoie une exception
	            throw new Exception("Un contact avec le code " + med_depotlegal  + " existe déjà");
	        }
	        unMedicament = new Medicament(med_depotlegal, med_nomcommercial, med_composition, med_effets, med_contreindic, med_prixechantillon, fam_code, fam_libelle);
	        resultat = MedicamentDao.creer(unMedicament);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}		
		return resultat;	
	}
	
	 public static ArrayList<String> getListeMedicaments()
	    {
	        ArrayList<String> laListe = new ArrayList<String>();
			try
	        {
			    ArrayList<Medicament> medicaments = MedicamentDao.retournerCollectionDesMedicaments();
	            for (Medicament medicament : medicaments)
	            {
	                laListe.add(medicament.getMed_depotlegal());
	            }
			}
			catch(Exception e){
				System.out.println( e.getMessage());
			}
			return laListe;
		}
	
	
}
