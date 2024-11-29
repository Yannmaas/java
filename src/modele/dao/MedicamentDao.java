/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.modele.dao;

import gsb.modele.Medicament;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MedicamentDao {
	 
	public static Medicament rechercher(String codeMedicament){


		Medicament  unMedicament=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL ='"+codeMedicament+"'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),  null, reqSelection.getString(7), reqSelection.getString(8));	
			}
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requete - select * from MEDICAMENT where MED_DEPOTLEGAL ='"+codeMedicament+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	public static ArrayList<Medicament> retournerCollectionDesMedicaments(){
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT ORDER BY MED_DEPOTLEGAL ASC");
		try{
		while (reqSelection.next()) {
			String codeMedicament = reqSelection.getString(1);
		    collectionDesMedicaments.add(MedicamentDao.rechercher(codeMedicament));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedicaments;
	}
		public static SortedMap<String,Medicament> retournerDictionnaireDesMedicaments(){
			SortedMap<String, Medicament> diccoDesMedicaments = new TreeMap<String, Medicament>();
			ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
			try{
			while (reqSelection.next()) {
				
				String codeMedicament = reqSelection.getString(1);
				
				diccoDesMedicaments.put(codeMedicament, MedicamentDao.rechercher(codeMedicament));
				System.out.println(MedicamentDao.rechercher(codeMedicament).getMed_depotlegal());
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.out.println("erreur retournerDiccoDesMedicaments()");
			}
			return diccoDesMedicaments;
		}
		
		public static int creer(Medicament unMedicament){
			int result = 0;
			String requeteInsertion;
			String depotlegal= unMedicament.getMed_depotlegal();
			String nomcommercial = unMedicament.getMed_nomcommercial();
			String composition = unMedicament.getMed_composition();
			String effets =  unMedicament.getMed_effets();
			String contreindic = unMedicament.getMed_contreindic();
			Float prixechantillon=  unMedicament.getMed_prixechantillon();
			String Fam_code = unMedicament.getFam_code();
			String fam_libelle = unMedicament.getFam_libelle();
			requeteInsertion = "insert into MEDICAMENT values('"+depotlegal+"','"+nomcommercial+"','"+composition+"','"+effets+"','"+contreindic+"','"+prixechantillon+"','"+Fam_code+"','"+fam_libelle+"')";
			try{
				result = ConnexionMySql.execReqMaj(requeteInsertion);
			}
			catch(Exception e){
				System.out.println("echec insertion Medicament");
			}
			ConnexionMySql.fermerConnexionBd();
			return result;
		}

	}
