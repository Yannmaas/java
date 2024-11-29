/*
 * Crééé le 17 nov. 2021
 *
 * TODO Pour changer le modele de ce fichier genere allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
package gsb.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * @author Isabelle
 * 17 nov. 2021
 * TODO Pour changer le modeele de ce commentaire de type genere, allez :
 * Fenetre - Preferences - Java - Style de code - Modeles de code
 */
public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2591453837113855452L;

	protected JInternalFrame myJInternalFrame;
	protected JDesktopPane desktopPane;
	protected JMenuBar mbar;
	protected JMenu mMedecins;
	protected JMenu mMedicaments;
	protected JMenu mVisiteur;

	JMenu mVisites;

	/**
	 * 
	 */
	public MenuPrincipal() {

		myJInternalFrame = new JInternalFrame(); // pour affichage d'une seule
													// JInternalFrame a la fois
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.gray);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);

		setTitle("GSB");
		setSize(500, 400);

		// Ajout d'une barre de menus a la fenetre
		mbar = new JMenuBar();
		mMedecins = new JMenu("Medecins");
		JMenuItem mC1 = new JMenuItem("Consultation Medecin");
		mC1.addActionListener(this); // installation d'un ecouteur d'action
		mMedecins.add(mC1);
		JMenuItem mC2 = new JMenuItem("Liste Medecins");
		mC2.addActionListener(this);
		mMedecins.add(mC2);

		mMedicaments = new JMenu("Medicaments");
		JMenuItem mE1 = new JMenuItem("Liste Medicaments");
		mE1.addActionListener(this); // installation d'un ecouteur d'action
		mMedicaments.add(mE1);
		JMenuItem mE2 = new JMenuItem("Ajout Medicaments");
		mE2.addActionListener(this);
		mMedicaments.add(mE2);
		JMenuItem mE3 = new JMenuItem("Medicaments Famille");
        mE3.addActionListener(this);
        mMedicaments.add(mE3);
        
        mVisiteur = new JMenu("Visiteur");
		JMenuItem mD1 = new JMenuItem("Liste des visiteurs");
		mD1.addActionListener(this); // installation d'un ecouteur d'action
		mVisiteur.add(mD1);
		JMenuItem mD2 = new JMenuItem("ajouter visiteur");
		mD2.addActionListener(this); // installation d'un ecouteur d'action
		mVisiteur.add(mD2);
		JMenuItem mD3 = new JMenuItem("stock visiteur");
		mD3.addActionListener(this); // installation d'un ecouteur d'action
		mVisiteur.add(mD3);
		JMenuItem mD4 = new JMenuItem("stock ajouter visiteur");
		mD4.addActionListener(this); // installation d'un ecouteur d'action
		mVisiteur.add(mD4);
		

		mVisites = new JMenu("Visites");
		JMenuItem mA1 = new JMenuItem("Mise à jour d'une visite");
		mA1.addActionListener(this); // installation d'un ecouteur d'action
		mVisites.add(mA1);
		JMenuItem mA2 = new JMenuItem("Ajout d'une visite");
		mA2.addActionListener(this);
		mVisites.add(mA2);
		JMenuItem mA3 = new JMenuItem("Liste des visites");
		mA3.addActionListener(this);
		mVisites.add(mA3);

		mbar.add(mMedecins);
		mbar.add(mMedicaments);
		mbar.add(mVisiteur);
		mbar.add(mVisites);
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Raccord de methode auto-genere
		if (evt.getSource() instanceof JMenuItem) {
			String ChoixOption = evt.getActionCommand();

			if (ChoixOption.equals("Consultation Medecin")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFMedecinCons());

			} else if (ChoixOption.equals("Liste Medecins")) {
				ouvrirFenetre(new JIFMedecinListeDic(this));
			}
			else if (ChoixOption.equals("Liste Medicaments")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFMedicamentListeDic(this));
			}
			else if (ChoixOption.equals("Ajout Medicaments")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFMedicamentAjouter(this));
			}
			else if (ChoixOption.equals("Medicaments Famille")) {
                // Creation d'une sous-fenetre
                ouvrirFenetre(new JIFMedicamentFamille(this));
			}
			else if (ChoixOption.equals("Liste des visiteurs")) {
                // Creation d'une sous-fenetre
                ouvrirFenetre(new JIFVisiteurListDic(this));
			}
			else if (ChoixOption.equals("ajouter visiteur")) {
                // Creation d'une sous-fenetre
                ouvrirFenetre(new JIFVisiteurAjouter(this));
			}
			else if (ChoixOption.equals("stock visiteur")) {
			    ouvrirFenetre(new JIFStockVisiteur());
			}
			else if (ChoixOption.equals("stock ajouter visiteur")) {
			    ouvrirFenetre(new JIFStockAjouter());
			}
			else if (ChoixOption.equals("Mise à jour d'une visite")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFVisiteMaj(this));}
			
			else if (ChoixOption.equals("Liste des visites")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFListVisite(this));}
			
			else if (ChoixOption.equals("Ajout d'une visite")) {
				// Creation d'une sous-fenetre
				ouvrirFenetre(new JIFVisiteAjouter(this));}
			


		}

	}

	public void ouvrirFenetre(JInternalFrame uneFenetre) {
		myJInternalFrame.dispose(); // si une fenetre etait deja affichee, elle
									// est liberee
		myJInternalFrame = uneFenetre;
		myJInternalFrame.setVisible(true);
		myJInternalFrame.setResizable(true);
		myJInternalFrame.setMaximizable(true);
		myJInternalFrame.setClosable(true);
		myJInternalFrame.setSize(480, 380);
		desktopPane.add(myJInternalFrame);
	}

}
