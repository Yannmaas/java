/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.modele;

/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class Medicament {
	protected String med_depotlegal ;
	protected String med_nomcommercial;
	protected String med_composition;
	protected String med_effets;
	protected String med_contreindic;
	protected Float med_prixechantillon;
	protected String fam_code;
	protected String fam_libelle;
	/**
	 * @param med_depotlegal
	 * @param med_nomcommercial
	 * @param med_composition
	 * @param med_effets
	 * @param med_contreindic
	 * @param med_prixechantillon
	 * @param fam_code
	 * @param fam_libelle
	 */
	public Medicament(String med_depotlegal, String med_nomcommercial, String med_composition,
			String med_effets, String med_contreindic, Float med_prixechantillon,
			String fam_code, String fam_libelle) {
		this.med_depotlegal = med_depotlegal;
		this.med_nomcommercial = med_nomcommercial;
		this.med_composition = med_composition;
		this.med_effets = med_effets;
		this.med_contreindic = med_contreindic;
		this.med_prixechantillon = med_prixechantillon;
		this.fam_code = fam_code;
		this.fam_libelle = fam_libelle;
	}
	public String getMed_depotlegal() {
		return med_depotlegal;
	}
	public void setMed_depotlegal(String med_depotlegal) {
		this.med_depotlegal = med_depotlegal;
	}
	public String getMed_nomcommercial() {
		return med_nomcommercial;
	}
	public void setMed_nomcommercial(String med_nomcommercial) {
		this.med_nomcommercial = med_nomcommercial;
	}
	public String getMed_composition() {
		return med_composition;
	}
	public void setMed_composition(String med_composition) {
		this.med_composition = med_composition;
	}
	public String getMed_effets() {
		return med_effets;
	}
	public void setMed_effets(String med_effets) {
		this.med_effets = med_effets;
	}
	public String getMed_contreindic() {
		return med_contreindic;
	}
	public void setMed_contreindic(String med_contreindic) {
		this.med_contreindic = med_contreindic;
	}
	public Float getMed_prixechantillon() {
		return med_prixechantillon;
	}
	public void setMed_prixechantillon(Float med_prixechantillon) {
		this.med_prixechantillon = med_prixechantillon;
	}
	public String getFam_code() {
		return fam_code;
	}
	public void setFam_code(String fam_code) {
		this.fam_code = fam_code;
	}
	public String getFam_libelle() {
		return fam_libelle;
	}
	public void setFam_libelle(String fam_libelle) {
		this.fam_libelle = fam_libelle;
	}

	
	
	

}
