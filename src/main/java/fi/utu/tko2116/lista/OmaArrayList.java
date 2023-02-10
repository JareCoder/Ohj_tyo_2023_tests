package fi.utu.tko2116.lista;
/**
 * Tämä luokka on yksinkertainen versio ArrayLististä. Oikeasta ArrayLististä
 * poiketen tähän voidaan tallentaa ainoastaan kokonaislukuja, eikä tästä löydy
 * edes kaikkia tarvittavia samoja metodeja.
 *
 * Jos kloonasit tämän luokan kurssin tehtävärepositoriosta, tässä luokassa on
 * valitettavasti VIRHEITÄ. Jos ajat esimerkiksi main-metodin luokasta Main,
 * lista tuntuu tavallaan toimivan, mutta ei kuitenkaan aina.
 *
 * Tämän harjoituksen tarkoituksena on suorittaa yksikkötestit. Suorita
 * yksikkötestit ohjeen mukaan. Ne kertovat, missä tilanteissa koodi
 * epäonnistuu. Korjaa sen jälkeen koodia niin, että yksikkötestit menevät läpi.
 *
 * Älä missään nimessä muuta yksikkötestejä! Koodi täytyy saada toimimaan
 * nimenomaan testien määräämillä ehdoilla.
 *
 * Kun olet saanut luokan korjattua, voit tutustua tämän avulla siihen, miten
 * ArrayListin voisi toteuttaa. Kannattaa tutustua myöhemmin, esimerkiksi
 * kurssin jälkeen mun oikean ArrayListin koodiin ja sen perintähierarkiaan. *
 *
 * @author vilho
 *
 */
public class OmaArrayList {

    private int[] sisalto;

    private int koko;

    /**
     * Uusi tyhjä OmaArrayList
     */
    public OmaArrayList() {
        sisalto = new int[10];
        koko = 0;
    }

    /**
     * / Uusi tyhjä OmaArrayList jolla on tietty alkukapasiteetti. Alkukapasiteetti
     * määrittää, kuinka monta arvoa taulukkoon mahtuu alkutilanteessa. Listan koko
     * on tietenkin 0, eli lista on tyhjä, mutta jos aikoo lisätä 100 arvoa
     * taulukkoon, kannattaa luoda lista jonka koko on 100 jolloin taulukkoa ei
     * tarvitse kasvattaa kesken kaiken.
     *
     * @param alkuKapasiteetti
     */
    public OmaArrayList(int alkuKapasiteetti) {
        sisalto = new int[alkuKapasiteetti];
        koko = 0;
    }

    /**
     * Uusi OmaArrayList, jonka sisältönä haetaan kopioimalla toinen, jo olemassa
     * oleva OmaArrayList. Parametrina tulevasta listasta haetaan arvot siinä
     * järjestyksesä kuin ne ovat.
     *
     * @param toinen
     */
    public OmaArrayList(OmaArrayList toinen) {
        sisalto = new int[toinen.koko];
        koko = 0;

        for (int i = 0; i < toinen.koko; i++) {
            lisaa(toinen.hae(i));
        }
    }

    /**
     * Lisää taulukollisen arvoja listaan yksi kerrallaan siinä järjestyksessä,
     * jossa arvot ovat taulukossa..
     *
     * @param taulukko
     */
    public void lisaaKaikki(int[] taulukko) {
        for (int luku : taulukko) {
            lisaa(luku);
        }
    }

    /**
     * Lisää taulukollisen arvoja listaan yksi kerrallaan siinä järjestyksessä,
     * jossa arvot ovat taulukossa..
     *
     * @param oma toinen OmaArrayList josta arvot lisätään
     */
    public void lisääKaikki(OmaArrayList oma) {
        for (int i = 0; i < oma.koko; i++) {
            lisaa(oma.hae(i));
        }
    }

    /**
     * Lisää luvun seuraavaan tyhjään indeksiin.
     *
     * @param luku joka lisätään.
     */
    public void lisaa(int luku) {
        varmistaKoko();
        sisalto[koko] = luku;
        koko++;
    }

    /**
     * Tyhjentää listan kokonaan siten, ettei listassa ole enää yhtään arvoa ja että
     * sen koko on 0.
     */
    public void tyhjenna() {
        for (int i = 0; i < koko - 1; i++) {
            sisalto[i] = 0;
        }
        koko = 0;

    }

    /**
     * Yksityinen metodi, joka varmistaa, että taulukossa on tarpeeksi tilaa
     * lisäyksiä varten. Kun taulukkoon lisätään arvoja, se kasvaa aina 1.5
     * kertaiseksi. Jos taulukon oletuskoko on 0, taulukko kasvaa joka tapauksessa
     * vähintään yhdellä.
     *
     * Metodi varmistaa koon ja jos taulukko on täysi, taulukko kasvaa.
     */
    private void varmistaKoko() {
        if (koko == sisalto.length) {
            int[] uusiTaulukko = new int[1 + (int) (koko * 1.5)];
            for (int i = 0; i < sisalto.length; i++) {
                uusiTaulukko[i] = sisalto[i];
            }
            sisalto = uusiTaulukko;
        }
    }

    /**
     * Yksityinen metodi, käytetään indeksin selvittämiseen ja virheiden
     * heittmäiseen, jos pyydetty indeksi ei ole sellainen, joka taulukossa on.
     *
     * Tämä ei liity todellisen taulukon {@link OmaArrayList#sisalto} indeksiin.
     * Vaikka kyseinen indeksi löytyisikin taulukosta, se ei välttämättä ole
     * kelvollinen: taulukossa voisi olla vaikka 10 paikkaa, mutta näistä vasta 3 on
     * käytetty listaan tallentamiseen. Indeksi 7 on tällöin virheellinen.
     *
     * @param indeksi jota kysytään.
     */
    private void tarkistaIndeksi(int indeksi) {
        if (indeksi >= koko || indeksi < 0) {
            throw new ArrayIndexOutOfBoundsException("Listassa ei ole indeksiä " + indeksi + " (koko: " + koko + ")");
        }
    }

    /**
     * Hakee (get) arvon listasta.
     *
     * @param indeksi jossa oleva arvo otetaan
     * @return arvo halutusta indeksistä.
     */
    public int hae(int indeksi) {
        tarkistaIndeksi(indeksi);
        return sisalto[indeksi];
    }

    /**
     * Asettaa arvon tiettyyn indeksiin.
     *
     * @param indeksi johon arvo asetetaan
     * @param arvo    joka asetetaan listaan.
     */
    public void aseta(int indeksi, int arvo) {
        tarkistaIndeksi(indeksi);
        sisalto[indeksi] = arvo;
    }

    /**
     * Palauttaa tiedon siitä, mikä on parametrina tulevan luvun indeksi.
     *
     * @param luku jonka indeksiä haetaan
     * @return luvun indeksi listassa, tai -1 jos lukua ei löydy.
     */
    public int indeksi(int luku) {
        for (int i = 0; i < koko; i++) {
            if (sisalto[i] == luku) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Palauttaa tiedon siitä, sisältääkö taulukko tietyn luvun
     *
     * @param luku jota taulukosta etsitään
     * @return true jos arvo löytyy, false jos ei.
     */
    public boolean sisaltaako(int luku) {
        return indeksi(luku) >= 0;
    }

    /**
     * Palauttaa tiedon siitä, miten suuri OmaArrayList on tällä hetkellä. Toisin
     * sanoen, montako arvoa siihen on tallennettu.
     *
     * @return listan koko.
     */
    public int koko() {
        return koko;
    }

    /**
     * Poistaa ja palauttaa arvon tietystä indeksistä.
     *
     * @param indeksi jossa oleva arvo poistetaan.
     * @return poistettu arvo, joka palautetaan.
     */
    public int poista(int indeksi) {
        tarkistaIndeksi(indeksi);
        int poistettava = sisalto[indeksi];

        for (int i = indeksi; i < koko - 1; i++) {
            sisalto[i] = sisalto[i + 1];
        }
        sisalto[koko - 1] = 0;
        koko = koko-1;

        return poistettava;
    }

    /**
     * Uudelleentoteutus toString -metodille.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < koko; i++) {
            sb.append(sisalto[i]);

            if (i != koko - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
