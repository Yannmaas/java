package gsb.vue;

import gsb.modele.Medicament;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	protected JLabel JLmed_depotlegal;
	protected JLabel JLmed_nomcommercial;
	protected JLabel JLmed_composition;
	protected JLabel JLmed_effets;
	protected JLabel JLmed_contreindic;
    protected JLabel JLfam_code;
    protected JLabel JLfam_libelle;
    
	protected JTextField JTmed_depotlegal;
	protected JTextField JTmed_nomcommercial;
	protected JTextField JTmed_composition;
	protected JTextField JTmed_effets;
	protected JTextField JTmed_contreindic;
    protected JTextField JTfam_code;
    protected JTextField JTfam_libelle;
    
    // Ajout du bouton fermer
    protected JButton btnFermer;
	
    public JIFMedicament() {
    	p = new JPanel();  // panneau principal de la fenetre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(7,2));
     
        
    	
        JLmed_depotlegal = new JLabel("depot_legal");
        JLmed_nomcommercial = new JLabel("nom_commercial");
        JLmed_composition = new JLabel("composition");
        JLmed_effets = new JLabel("effets");
        JLmed_contreindic = new JLabel("contreindic");
        JLfam_code = new JLabel("code");
        JLfam_libelle = new JLabel("libelle");
         
        JTmed_depotlegal = new JTextField();
   
        JTmed_nomcommercial = new JTextField();
        JTmed_composition = new JTextField();
        JTmed_effets = new JTextField();   
        JTmed_effets.setColumns(20);
        JTmed_contreindic = new JTextField();
        JTmed_contreindic.setColumns(20);
        JTfam_code = new JTextField();
        JTfam_libelle = new JTextField();
        
        // Ajout des composants au panneau texte
        pTexte.add(JLmed_depotlegal);
        pTexte.add(JTmed_depotlegal);
        pTexte.add(JLmed_nomcommercial);
        pTexte.add(JTmed_nomcommercial);
        pTexte.add(JLmed_composition);
        pTexte.add(JTmed_composition);
        pTexte.add(JLmed_effets);
        pTexte.add(JTmed_effets);
        pTexte.add(JLmed_contreindic);
        pTexte.add(JTmed_contreindic);
        pTexte.add(JLfam_code);
        pTexte.add(JTfam_code);
        pTexte.add(JLfam_libelle);
        pTexte.add(JTfam_libelle);
		
        // Création du bouton "Fermer"
        btnFermer = new JButton("Fermer");
        
        // Ajout d'un action listener pour fermer la fenêtre
        btnFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre
            }
        });
        
        // Ajout du bouton au panneau des boutons
        pBoutons.add(btnFermer);
        
        // Ajout des panneaux au conteneur principal
        p.add(pTexte);
        p.add(pBoutons);
        Container contentPane = getContentPane();
        contentPane.add(p);
	}
    
    public void remplirText(Medicament unMedicament) {
    	// Remplir les champs de texte avec les données du médicament
    	JTmed_depotlegal.setText(unMedicament.getMed_depotlegal());        
    	JTmed_nomcommercial.setText(unMedicament.getMed_nomcommercial());
    	JTmed_composition.setText(unMedicament.getMed_composition());
    	JTmed_effets.setText(unMedicament.getMed_effets());    
    	JTmed_contreindic.setText(unMedicament.getMed_contreindic());
    	JTfam_code.setText(unMedicament.getFam_code());
    	JTfam_libelle.setText(unMedicament.getFam_libelle());
    }
     
    public void viderText() {
    	// Vider les champs de texte
    	JTmed_depotlegal.setText("");        
    	JTmed_nomcommercial.setText("");
    	JTmed_composition.setText("");
    	JTmed_effets.setText("");    
    	JTmed_contreindic.setText("");
    	JTfam_code.setText("");
    	JTfam_libelle.setText("");
    }
}
