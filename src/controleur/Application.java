package controleur;

import modele.ListeActifs;
import modele.ListePassifs;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {

        ListeActifs lesActifs = new ListeActifs(
                "src/modele/donnees/liste_actifs.txt"
        );

        ListePassifs lesPassifs = new ListePassifs(
                "src/modele/donnees/liste_passifs.txt"
        );

        System.out.println(
                "Nombre d'actifs : " + lesActifs.nbActifs()
        );

        System.out.println(
                "Nombre de passifs : " + lesPassifs.nbPassifs()
        );
    }
}