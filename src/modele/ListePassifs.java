package modele;

import java.util.ArrayList;

//requis 1, 2, 3 et 4 pour le moment

public class ListePassifs {

    private ArrayList<Passif> passifs;

    private class Passif {
        private String id;
        private String description;
        private double solde;


        public Passif(String id, String description, double solde) {
            this.id = id;
            this.description = description;
            this.solde = solde;
        }
    }
}
