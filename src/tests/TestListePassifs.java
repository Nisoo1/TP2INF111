package tests;

import modele.ListePassifs;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestListePassifs {

    @Test
    public void TestPhase1ListePassifs() throws IOException {

        ListePassifs lp = new ListePassifs(
                "src/modele/donnees/liste_passifs.txt"
        );

        assertEquals(9, lp.nbPassifs());

        assertEquals("p5", lp.getIdPassif(3));

        assertEquals(
                "Pret REER/CELI",
                lp.getDescriptionPassif(8)
        );

        assertEquals(3, lp.getIndicePassif("p5"));

        lp.setSoldePassif("p9", 15000);

        assertEquals(
                15000.0,
                lp.getSoldePassif(7),
                0.001
        );
    }
}