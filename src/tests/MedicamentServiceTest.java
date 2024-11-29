/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.tests;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MedicamentServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Medicament unMedicament = MedicamentService.rechercherMedicament("ADIMOL9");
		System.out.println(unMedicament.getMed_nomcommercial());
		System.out.println(unMedicament.getMed_composition());
		System.out.println(unMedicament.getMed_effets());
		System.out.println(unMedicament.getMed_contreindic());
		System.out.println(unMedicament.getFam_code());
		System.out.println(unMedicament.getFam_libelle());
		
		

	}

}
