import fi.utu.tko2116.lista.OmaArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestArrayListLisaysJaPoisto {


    @Test
    public void testaaTyhjaanListaanLisattyKasvattaaKokoa() {
        OmaArrayList oma = new OmaArrayList();
        oma.lisaa(5);
        assertEquals(1,oma.koko());
    }

    @Test
    public void testaaLisattyArvoOnSamaKuinHaettuArvo() {
        int arvo = 9;
        OmaArrayList oma = new OmaArrayList();
        oma.lisaa(arvo);
        assertEquals(arvo,oma.hae(0));
    }



    @Test
    public void testaaArvonLisaaminenKasvattaaKokoa() {
        int arvo = 9;
        OmaArrayList oma = new OmaArrayList();
        oma.lisaa(arvo);


        assertEquals(1,oma.koko());
    }

    @Test
    public void testaaArvonPoistaminenPienentaaKokoa() {
        int arvo = 9;
        OmaArrayList oma = new OmaArrayList();
        oma.lisaa(arvo);

        oma.poista(0);

        assertEquals(0,oma.koko());
    }

    @Test
    public void testaaPoistettuArvoPalautuuListasta() {
        int arvo = 9;
        OmaArrayList oma = new OmaArrayList();
        oma.lisaa(arvo);

        int poistettu = oma.poista(0);
        assertEquals(arvo,poistettu);
    }





    @Test
    public void testaaTyhjennyksenJalkeenKokoOnNolla() {
        int arvo = 9;
        OmaArrayList oma = new OmaArrayList();
        oma.lisaa(arvo);
        oma.lisaa(arvo);
        oma.lisaa(arvo);
        oma.lisaa(arvo);

        oma.tyhjenna();
        assertEquals(0,oma.koko());
    }






}
