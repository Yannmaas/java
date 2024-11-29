package gsb.vue;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class JIFMedicamentFamille extends JInternalFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    protected JPanel p;
    protected JScrollPane scrollPane;
    protected JPanel pSaisie;
    protected MenuPrincipal fenetreContainer;
    protected JTable table;
    protected JComboBox<String> comboBoxFamilles;
    protected JPanel pBoutons;
    private JButton fermer;

    // Constructeur principal
    public JIFMedicamentFamille(MenuPrincipal uneFenetreContainer) {
        fenetreContainer = uneFenetreContainer;

        // Initialisation du panneau principal
        p = new JPanel();
        p.setLayout(new BorderLayout());

        // Initialisation du panneau pour les boutons
        pBoutons = new JPanel();
        fermer = new JButton("FERMER");
        fermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Ferme la fenêtre lorsqu'on clique sur "FERMER"
            }
        });
        pBoutons.add(fermer);

        // Initialisation de la JComboBox pour les familles de médicaments
        comboBoxFamilles = new JComboBox<>();
        comboBoxFamilles.addItem("Tous"); // Option pour afficher tous les médicaments
        comboBoxFamilles.addItem("Sélectionnez une famille");

        // Remplissage de la liste déroulante sans doublons
        HashSet<String> familles = new HashSet<>();
        for (Medicament medicament : MedicamentDao.retournerDictionnaireDesMedicaments().values()) {
            familles.add(medicament.getFam_libelle());
        }
        for (String famille : familles) {
            comboBoxFamilles.addItem(famille);
        }

        // Écouteur pour le filtrage des médicaments selon la famille sélectionnée
        comboBoxFamilles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String familleSelectionnee = (String) comboBoxFamilles.getSelectedItem();
                if (!familleSelectionnee.equals("Sélectionnez une famille")) {
                    afficherMedicamentsParFamille(familleSelectionnee);
                }
            }
        });

        // Initialisation du panneau de saisie et ajout des éléments
        pSaisie = new JPanel();
        pSaisie.add(new JLabel("Famille :"));
        pSaisie.add(comboBoxFamilles);

        // Initialisation des données de la JTable
        String[] columnNames = {"Depot légal", "Nom commercial", "Composition", "Effets", "Contre indications"};
        table = new JTable(new String[0][5], columnNames);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 200));

        // Ajout des composants au panneau principal
        p.add(pSaisie, BorderLayout.NORTH);
        p.add(scrollPane, BorderLayout.CENTER);
        p.add(pBoutons, BorderLayout.SOUTH);

        // Mise en forme de la fenêtre
        Container contentPane = getContentPane();
        contentPane.add(p);

        // Affichage initial de tous les médicaments
        afficherMedicamentsParFamille("Tous");
    }

    // Constructeur supplémentaire pour afficher les détails d'un médicament spécifique
    public JIFMedicamentFamille(MenuPrincipal uneFenetreContainer, Medicament unMedicament) {
        this(uneFenetreContainer); // Appel du constructeur principal pour l'initialisation de base
        // Remplissez la JTable avec les informations du médicament spécifique
        afficherMedicamentsParFamille(unMedicament.getFam_libelle());
    }

    // Méthode pour afficher les médicaments en fonction de la famille sélectionnée
    private void afficherMedicamentsParFamille(String familleSelectionnee) {
        ArrayList<String[]> dataListe = new ArrayList<>();

        for (Medicament medicament : MedicamentDao.retournerDictionnaireDesMedicaments().values()) {
            if (familleSelectionnee.equals("Tous") || medicament.getFam_libelle().equals(familleSelectionnee)) {
                String[] row = {
                    medicament.getMed_depotlegal(),
                    medicament.getMed_nomcommercial(),
                    medicament.getMed_composition(),
                    medicament.getMed_effets(),
                    medicament.getMed_contreindic()
                };
                dataListe.add(row);
            }
        }

        // Conversion de l'ArrayList en tableau 2D pour la JTable
        String[][] data = new String[dataListe.size()][5];
        dataListe.toArray(data);

        // Mise à jour du modèle de la JTable avec les médicaments filtrés
        table.setModel(new javax.swing.table.DefaultTableModel(
            data,
            new String[]{"Depot légal", "Nom commercial", "Composition", "Effets", "Contre indications"}
        ));
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // Aucun code spécifique ici, car JBafficherFiche et JTcodeMedicament ont été supprimés
    }
}
