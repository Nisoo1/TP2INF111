package tests;

import modele.ListeActifs;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestListeActifs {

    @Test
    public void TestPhase1ListeActifs() throws IOException {

        ListeActifs la = new ListeActifs(
                "src/modele/donnees/liste_actifs.txt"
        );

        assertEquals(13, la.nbActifs());

        assertEquals("a1", la.getIdActif(0));

        assertEquals(
                "Maison",
                la.getDescriptionActif(5)
        );

        assertEquals(
                295865.54,
                la.getValeurActif(4),
                0.001
        );

        assertEquals(
                -0.2,
                la.getPourcentageActif(7),
                0.001
        );

        assertEquals(
                3,
                la.getIndiceActif("a14")
        );

        la.setValeurActif("a5", 315000);

        assertEquals(
                315000.0,
                la.getValeurActif(4),
                0.001
        );

        la.setPourcentageActif("a8", -0.15);

        assertEquals(
                -0.15,
                la.getPourcentageActif(7),
                0.001
        );

        assertEquals(
                0,
                la.getNbPassifsLies(0)
        );

        assertEquals(
                3,
                la.getNbPassifsLies(5)
        );

        assertNull(
                la.getPassifsLies(0)
        );

        ArrayList<String> passifsMaison =
                la.getPassifsLies(5);

        assertEquals(
                "p5",
                passifsMaison.get(0)
        );

        assertEquals(
                "p6",
                passifsMaison.get(1)
        );

        assertEquals(
                "p7",
                passifsMaison.get(2)
        );
    }
}