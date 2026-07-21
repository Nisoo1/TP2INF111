package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListeActifs {

    private ArrayList<Actif> lesActifs;

    // Constructeur qui charge les actifs à partir du fichier
    public ListeActifs(String nomFichier) throws IOException {

        lesActifs = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(nomFichier)
        );

        // On ignore la première ligne contenant les titres
        reader.readLine();

        String ligne;

        while ((ligne = reader.readLine()) != null) {

            String[] donnees = ligne.split(",");

            String id = donnees[0].trim();

            int annee;

            if (donnees[1].trim().equals("---")) {
                annee = 0;
            } else {
                annee = Integer.parseInt(donnees[1].trim());
            }

            String description = donnees[2].trim();

            double valeur = Double.parseDouble(
                    donnees[3].trim()
            );

            double pourcentage = Double.parseDouble(
                    donnees[4].trim()
            );

            int type = Integer.parseInt(
                    donnees[5].trim()
            );

            ArrayList<String> passifsLies = null;

            // S'il y a des données après les six premières colonnes,
            // elles représentent les passifs liés
            if (donnees.length > 6) {

                passifsLies = new ArrayList<>();

                for (int i = 6; i < donnees.length; i++) {
                    passifsLies.add(donnees[i].trim());
                }
            }

            Actif actif = new Actif(
                    id,
                    annee,
                    description,
                    valeur,
                    pourcentage,
                    type,
                    passifsLies
            );

            lesActifs.add(actif);
        }

        reader.close();
    }

    // Retourne le nombre d'actifs
    public int nbActifs() {
        return lesActifs.size();
    }

    // Retourne l'identification d'un actif
    public String getIdActif(int indice) {
        return lesActifs.get(indice).id;
    }

    // Retourne la description d'un actif
    public String getDescriptionActif(int indice) {
        return lesActifs.get(indice).description;
    }

    // Retourne la valeur d'un actif
    public double getValeurActif(int indice) {
        return lesActifs.get(indice).valeur;
    }

    // Retourne le pourcentage d'un actif
    public double getPourcentageActif(int indice) {
        return lesActifs.get(indice).pourcentage;
    }

    // Cherche l'indice d'un actif grâce à son identification
    public int getIndiceActif(String id) {

        for (int i = 0; i < lesActifs.size(); i++) {

            if (lesActifs.get(i).id.equals(id)) {
                return i;
            }
        }

        return -1;
    }

    // Modifie la valeur d'un actif
    public void setValeurActif(String id, double nouvelleValeur) {

        int indice = getIndiceActif(id);

        lesActifs.get(indice).valeur = nouvelleValeur;
    }

    // Modifie le pourcentage d'un actif
    public void setPourcentageActif(
            String id,
            double nouveauPourcentage
    ) {

        int indice = getIndiceActif(id);

        lesActifs.get(indice).pourcentage =
                nouveauPourcentage;
    }

    // Retourne le nombre de passifs liés à un actif
    public int getNbPassifsLies(int indice) {

        if (lesActifs.get(indice).passifsLies == null) {
            return 0;
        }

        return lesActifs.get(indice).passifsLies.size();
    }

    // Retourne la liste des passifs liés à un actif
    public ArrayList<String> getPassifsLies(int indice) {
        return lesActifs.get(indice).passifsLies;
    }

    // Classe interne représentant un actif
    private class Actif {

        private String id;
        private int annee;
        private String description;
        private double valeur;
        private double pourcentage;
        private int type;
        private ArrayList<String> passifsLies;

        public Actif(
                String id,
                int annee,
                String description,
                double valeur,
                double pourcentage,
                int type,
                ArrayList<String> passifsLies
        ) {

            this.id = id;
            this.annee = annee;
            this.description = description;
            this.valeur = valeur;
            this.pourcentage = pourcentage;
            this.type = type;
            this.passifsLies = passifsLies;
        }
    }
}