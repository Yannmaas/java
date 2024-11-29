package gsb.vue;



import gsb.modele.Medecin;
import gsb.modele.Medicament;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class JIFMedicamentFiche extends JIFMedicament {

	private static final long serialVersionUID = 1L;

	public JIFMedicamentFiche(Medicament unMedicament) {
		super();
		this.remplirText(unMedicament);

	}
	

}
