package gsb.vue;

import gsb.service.MedicamentService;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class JIFMedicamentAjouter extends JInternalFrame {

    private MenuPrincipal menuPrincipal;
    private JTextField txtDepotLegal, txtNomCommercial, txtComposition, txtEffets, txtContreIndic, txtPrixEchantillon, txtFamLibelle;
    private JComboBox<String> comboFamCode;
    private JButton btnAjouter;
    
    // Map pour relier les codes de famille à leurs libellés
    private Map<String, String> familleLibelles;

    public JIFMedicamentAjouter(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        setTitle("Ajouter un Médicament");
        setSize(400, 300);
        setLayout(new GridLayout(9, 2));

        // Initialiser la map des codes famille et libellés
        initFamilleLibelles();

        // Champs de saisie
        txtDepotLegal = new JTextField();
        txtNomCommercial = new JTextField();
        txtComposition = new JTextField();
        txtEffets = new JTextField();
        txtContreIndic = new JTextField();
        txtPrixEchantillon = new JTextField();
        
        // Champ du libellé famille non modifiable
        txtFamLibelle = new JTextField();
        txtFamLibelle.setEditable(false);

        // Initialisation du JComboBox pour les codes famille
        comboFamCode = new JComboBox<>(familleLibelles.keySet().toArray(new String[0]));

        // Ajouter un écouteur pour mettre à jour automatiquement le libellé famille
        comboFamCode.addActionListener(e -> {
            String selectedFamCode = (String) comboFamCode.getSelectedItem();
            txtFamLibelle.setText(familleLibelles.get(selectedFamCode));
        });

        // Bouton d'ajout
        btnAjouter = new JButton("Ajouter Médicament");

        // Ajout des éléments à la fenêtre
        add(new JLabel("Code Dépôt Légal:"));
        add(txtDepotLegal);
        add(new JLabel("Nom Commercial:"));
        add(txtNomCommercial);
        add(new JLabel("Composition:"));
        add(txtComposition);
        add(new JLabel("Effets:"));
        add(txtEffets);
        add(new JLabel("Contre-indications:"));
        add(txtContreIndic);
        add(new JLabel("Prix Échantillon:"));
        add(txtPrixEchantillon);
        add(new JLabel("Code Famille:"));
        add(comboFamCode);
        add(new JLabel("Libellé Famille:"));
        add(txtFamLibelle);

        // Ajout du bouton
        add(new JLabel(""));
        add(btnAjouter);

        // Gestionnaire d'événements pour le bouton
        btnAjouter.addActionListener(e -> {
            String depotLegal = txtDepotLegal.getText().toUpperCase();
            String nomCommercial = txtNomCommercial.getText();
            String composition = txtComposition.getText();
            String effets = txtEffets.getText();
            String contreIndic = txtContreIndic.getText();

            Float prixEchantillon = null;
            if (!txtPrixEchantillon.getText().isEmpty()) {
                try {
                    prixEchantillon = Float.parseFloat(txtPrixEchantillon.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Prix échantillon doit être un nombre valide.");
                    return;
                }
            }

            String famCode = (String) comboFamCode.getSelectedItem();
            String famLibelle = txtFamLibelle.getText();

            MedicamentService service = new MedicamentService();
            int resultat = service.creerMedicament(depotLegal, nomCommercial, composition, effets, contreIndic, prixEchantillon, famCode, famLibelle);

            if (resultat == 1) {
                JOptionPane.showMessageDialog(this, "Médicament ajouté avec succès.");
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout du médicament.");
            }
        });
    }

    private void initFamilleLibelles() {
        familleLibelles = new HashMap<>();
        familleLibelles.put("CTR", "Corticoïde, antibiotique et antifongique à  usage");
        familleLibelles.put("ABP", "Antibiotique de la famille des béta-lactamines");
        familleLibelles.put("ALO", "Antibiotique local (ORL)");
        familleLibelles.put("ABC", "Antibiotique antiacnéique local");
        familleLibelles.put("AFM", "Antibiotique de la famille des macrolides");
        familleLibelles.put("AAA", "Antalgiques antipyrétiques en association");
        familleLibelles.put("AIM", "Antidépresseur imipraminique (tricyclique)");
        familleLibelles.put("AAC", "Antidépresseur d'action centrale");
        familleLibelles.put("HYP", "Hypnotique antihistaminique");
        familleLibelles.put("AAH", "Antivertigineux antihistaminique H1");
        familleLibelles.put("PSA", "Psychostimulant, antiasthénique");
        familleLibelles.put("AH", "Antihistaminique H1 local");
        familleLibelles.put("AFC", "Antibiotique de la famille des cyclines");
        familleLibelles.put("AP", "Antipsychotique normothymique");
        familleLibelles.put("AA", "Antalgiques en association");
        familleLibelles.put("ABA", "Antibiotique antituberculeux");
        familleLibelles.put("AO", "Antibiotique ophtalmique");
    }
}
