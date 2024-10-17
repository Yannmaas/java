/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.modele.dao;

import gsb.modele.Medicament;
import gsb.modele.Medicament;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



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
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
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
		public static HashMap<String,Medicament> retournerDictionnaireDesMedicaments(){
			HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
			ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
			try{
			while (reqSelection.next()) {
				String codeMedicament = reqSelection.getString(1);
				diccoDesMedicaments.put(codeMedicament, MedicamentDao.rechercher(codeMedicament));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.out.println("erreur retournerDiccoDesMedicaments()");
			}
			return diccoDesMedicaments;
		}

	}
