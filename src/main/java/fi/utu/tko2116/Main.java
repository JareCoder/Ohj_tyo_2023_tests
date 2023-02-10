package fi.utu.tko2116;

import fi.utu.tko2116.lista.OmaArrayList;

public class Main {
    public static void main(String[] args) {

        OmaArrayList o = new OmaArrayList();

        System.out.println("Uuden listan koko:"+o.koko());

        o.lisaa(7);

        System.out.println("Koko lisäyksen jälkeen:"+o.koko());

        System.out.println("Onko lisätty arvo listassa..");
        if(o.sisaltaako(7)){
            System.out.println("Arvo on listassa!");
        }else{
            System.out.println("Arvoa ei ole listassa!");
        }

        o.poista(0);

        System.out.println("luvun 888 indeksi:"+o.indeksi(888));
        System.out.println();
        System.out.println("Luodaan lista, johon mahtuu aluksi 5 arvoa ");
        OmaArrayList o2 = new OmaArrayList(5);

        o2.lisaa(1);
        o2.lisaa(2);
        o2.lisaa(3);
        o2.lisaa(4);
        o2.lisaa(5);

        System.out.println(o2.koko());

        System.out.println(o2);

        o2.tyhjenna();
        System.out.println(o2);


    }
}