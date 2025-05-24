import javax.swing.*;
import java.util.Objects;

public class Pribeh
{
    Main main;
    Okno okno;
    PrepinaniOken prepnuti;
    Nepratele nepritel;
    Hrac hrac_tes;

    JOptionPane chyba_jmeno;

    String jmeno;
    int pocitadlo_heal = 0;
    int karticka;
    String classVyberHrace;

    public Pribeh(Main main2, Okno okno2, PrepinaniOken prepnuti2)
    {
        okno = okno2;
        main = main2;
        prepnuti = prepnuti2;
    }

    //Nastavi hru :)
    public void nastaveniZaklad()
    {
        classVyberHrace = Main.vybranaClass;
        jmeno = okno.zadej_jmeno.getText();

        if (jmeno.length() > 6 || jmeno.isEmpty()) {
            prepnuti.zapnoutMenu();

            chyba_jmeno = new JOptionPane();
            JOptionPane.showMessageDialog(null, "Jméno může mít maximálně 6 znaků a nesmí být prázdné!", "CHYBA JMÉNA", JOptionPane.WARNING_MESSAGE);

            return;
        }

        if (Objects.equals(classVyberHrace, "class1"))
        {
            hrac_tes = new Pruzkumnik(jmeno);
        }
        else if (Objects.equals(classVyberHrace, "class2"))
        {
            hrac_tes = new Opravar(jmeno);
        }
        else {
            return;
        }

        okno.zivotyCislo.setText(String.valueOf(hrac_tes.zivoty));
        okno.zbranNazev.setText(hrac_tes.zbran.nazev);
        okno.jmeno_hrac_Label.setText(jmeno);

        karticka = 0;

        okno.vyber1.setVisible(true);
        okno.vyber2.setVisible(true);
        okno.vyber3.setVisible(true);
        okno.vyber4.setVisible(true);
    }

    public void potvrdit_hrac()
    {
        prepnuti.zapnoutPrvniLokaci();
        zacatekHry();
        nastaveniZaklad();
    }

    //Pro tlacitka kroky
    public void vyberKroku(String dalsikrok)
    {
        switch(dalsikrok)
        {
            case "" : break;
            case "pokracovat": pokracovat(); break;
            case "rozcesti" : rozcesti(); break;
            case "mluvitStrazce" : mluvitStrazce(); break;
            case "zautocitStrazce" : zautocitStrazce(); break;
            case "opusteny_bunkr" : opusteny_bunkr(); break;
            case "tovarna" : tovarna(); break;
            case "laborator" : laborator(); break;
            case "bojovaniRobot" : bojovaniRobot(); break;
            case "actually_fight" : actually_fight() ; break;
            case "hracUtok" : hracUtok(); break;
            case "nepritel_utok" : nepritel_utok() ; break;
            case "vyhra" :  vyhra() ; break;
            case "smrt_hrace" : smrt_hrace(); break;

            case "uvodni_obrazovka" : uvodni_obrazovka(); break;
            case "konec":  System.exit(0);

        }
    }

    public void zacatekHry()
    {
        okno.hlavniText.setText("Tvá loď nouzově přistála. Záznamy jsou poškozené a moc si toho nepamatuješ. " +
                "Skeny odhalují přítomnost základny - možná jediného místa, odkud se dá dostat zpět do vesmíru.  " +
                "V okolí jsou známky nedávného boje. U vstupu stojí voják. Mlčí, ale jeho zbraň tě sleduje.");

        okno.vyber1.setText("Jít na základnu");
        okno.vyber2.setText("");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        main.dalsikrok1 = "pokracovat";
        main.dalsikrok2 = "";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }

    public void pokracovat()
    {
            okno.hlavniText.setText("LOKACE: Základna 584\n\nVoják:\nNepřibližuj se! Vstup zakázán bez identifikace. Tahle základna je pod karanténou." +
                    " Jestli nemáš přístupovou kartičku, tak se otoč a vypadni, dokud můžeš.");

            okno.vyber1.setText("Mluvit");
            okno.vyber2.setText("Odejít");
            okno.vyber3.setText("Zaútočit");
            okno.vyber4.setText("");

            main.dalsikrok1 = "mluvitStrazce";
            main.dalsikrok2 = "rozcesti";
            main.dalsikrok3 = "zautocitStrazce";
            main.dalsikrok4 = "";

    }

    public void mluvitStrazce()
    {
        if(karticka== 0)
        {
            okno.hlavniText.setText("LOKACE: Základna 584\n\nVoják:\nPokud se sem chceš dostat, najdi si kartu – nebo skončíš jako ti, co to zkusili bez ní!");

            okno.vyber1.setText("Odejít");
            okno.vyber2.setText("Zaútočit");
            okno.vyber3.setText("");
            okno.vyber4.setText("");

            main.dalsikrok1 = "rozcesti";
            main.dalsikrok2 = "zautocitStrazce";
            main.dalsikrok3 = "";
            main.dalsikrok4 = "";
        }

            else if(karticka == 1)
        {
            good_ending();
        }
    }

    public void zautocitStrazce()
    {
        okno.hlavniText.setText("LOKACE: Základna 584\n\nVoják:\nCo zkoušíš?! Než stihneš cokoliv udělat, voják tě jediným úderem odhodí několik metrů zpět." +
                "\n(Obdržíš 3 poškození)");
        hrac_tes.zivoty -= 3;
        okno.zivotyCislo.setText(String.valueOf(hrac_tes.zivoty));

        okno.vyber1.setText("Pokračovat");
        okno.vyber2.setText("");
        okno.vyber3.setText("");
        okno.vyber4.setText("");


        if(hrac_tes.zivoty > 0)
        {
            main.dalsikrok1 = "rozcesti";
        }
        else
        {
            main.dalsikrok1 = "smrt_hrace";
        }

        main.dalsikrok2 = "";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }

    public void rozcesti()
    {
        okno.hlavniText.setText("LOKACE: Rozcestí\n\n" +
                "Na východě je Základna 584. Na západě slyšíš mechanické vrčení." +
                " Na jihu zahlédneš zasypaný bunkr, možná tam jsou cennosti." +
                " A na severu je stará vědecká laboratoř, možná tam najdeš zásoby.");

        okno.vyber1.setText("Jít na sever - laboratoř");
        okno.vyber2.setText("Jít na jih - bunkr");
        okno.vyber3.setText("Jít na západ - továrna");
        okno.vyber4.setText("Jít na východ - základna");

        main.dalsikrok1 = "laborator";
        main.dalsikrok2 = "opusteny_bunkr";
        main.dalsikrok3 = "tovarna";
        main.dalsikrok4 = "pokracovat";
    }

    public void opusteny_bunkr()
    {
        okno.hlavniText.setText("LOKACE: Bunkr\n\nVe tmě zakopneš o něco kovového. Po krátkém prohledávání nacházíš starou, ale funkční pistoli. Možná ti zachrání život...");
        hrac_tes.zbran = new Pistol();
        okno.zbranNazev.setText(hrac_tes.zbran.nazev);

        okno.vyber1.setText("Vrátit se zpět");
        okno.vyber2.setText("");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        main.dalsikrok1 = "rozcesti";
        main.dalsikrok2 = "";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }

    public void laborator()
    {

        pocitadlo_heal += 1;

        okno.vyber1.setText("Vrátit se zpět");
        okno.vyber2.setText("");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        main.dalsikrok1 = "rozcesti";
        main.dalsikrok2 = "";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";

        if(pocitadlo_heal > 2)
        {
            okno.hlavniText.setText("LOKACE: Laboratoř\n\nKdyž se natáhneš pro další lahvičku, sklouzne ti z ruky a roztříští se o podlahu. Víc jich tu není. Musíš pokračovat bez další pomoci.");

        }
        else
        {
            okno.hlavniText.setText("LOKACE: Laboratoř\n\nSterilní místnost je plná rozbitých ampulí a přístrojů pokrytých prachem." +
                    " Jedna lékařská lahvička však zůstala neporušená. Vypiješ její obsah a vráti se ti síly.   (Vyléčiš si 2 životy)");
            hrac_tes.zivoty += 2;
            okno.zivotyCislo.setText(String.valueOf(hrac_tes.zivoty));
        }

    }

    public void tovarna()
    {
        okno.hlavniText.setText("LOKACE: Továrna\n\nStojíš před zarostlým vchodem do opuštěné továrny." +
                " Zevnitř slyšíš bzučení a rytmické klepání, které připomíná kroky. Vidíš rozbité okno, vypadá nebezpečně, ale možná tu najdeš něco důležitého.");

        okno.vyber1.setText("Jít do továrny");
        okno.vyber2.setText("Vrátit se zpět");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        main.dalsikrok1 = "bojovaniRobot";
        main.dalsikrok2 = "rozcesti";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }


    public void bojovaniRobot()
    {
        int random_cislo = new java.util.Random().nextInt(100)+1;

        if(random_cislo<70)
        {
            nepritel = new Robot();

        }else{
            nepritel = new RobotMK2();
        }


        okno.hlavniText.setText("LOKACE: Továrna\n\nZ hlubin temné továrny se vynořil hlídací robot - jeho senzory tě zaměřily.\nPřiprav se na boj, nebo uteč, dokud je čas!");


        okno.vyber1.setText("Bojovat");
        okno.vyber2.setText("Utéct");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        main.dalsikrok1 = "actually_fight";
        main.dalsikrok2 = "rozcesti";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }

    public void actually_fight()
    {
        okno.hlavniText.setText("LOKACE: Továrna\n\n" +
                "Zaútočil na tebe "+ nepritel.jmeno +" !"+ "\n\nZdraví nepřítele: " + nepritel.zdravi + "\nSíla nepřítele: " + nepritel.utok_monstra );

        okno.vyber1.setText("Útok");
        okno.vyber2.setText("Utéct");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        main.dalsikrok1 = "hracUtok";
        main.dalsikrok2 = "rozcesti";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }

    public void hracUtok()
    {
        int utokHrace = new java.util.Random().nextInt(hrac_tes.zbran.utok); //nahodne cislo podle zbrane

        okno.hlavniText.setText("LOKACE: Továrna\n\nÚtočíš na " + nepritel.jmeno + " a způsobíš nepříteli " + utokHrace + " poškození!");

        nepritel.zdravi -= utokHrace;

        okno.vyber1.setText("Pokračovat");
        okno.vyber2.setText("");
        okno.vyber3.setText("");
        okno.vyber4.setText("");


        if(nepritel.zdravi > 0)
        {
            main.dalsikrok1 = "nepritel_utok";
        }
        else
        {
            main.dalsikrok1 = "vyhra";
        }

        main.dalsikrok2 = "";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";

    }

    public void nepritel_utok()
    {
        int utokMonstra = new java.util.Random().nextInt(nepritel.utok_monstra);

        okno.hlavniText.setText("LOKACE: Továrna\n\n"+ nepritel.jmeno + " tě zasáhne a ubírá ti " + utokMonstra + " životů!");
        hrac_tes.zivoty -= utokMonstra;

        okno.zivotyCislo.setText(String.valueOf(hrac_tes.zivoty));

        okno.vyber1.setText("Pokračovat");
        okno.vyber2.setText("");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        if(hrac_tes.zivoty > 0)
        {
            main.dalsikrok1 = "actually_fight";
        }
        else
        {
            main.dalsikrok1 = "smrt_hrace";
        }

        main.dalsikrok2 = "";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }

    public void vyhra()
    {
        okno.hlavniText.setText("LOKACE: Továrna\n\n" + nepritel.jmeno + " se rozpadá na kusy kovu." +
                " Vypadla z něj stará identifikační kartička – je na ní vyraženo 'ZÁKLADNA 584'. Třeseš se, ale cítíš, že se někam můžeš posunout");

        karticka = 1;

        okno.vyber1.setText("Vrátit se");
        okno.vyber2.setText("");
        okno.vyber3.setText("");
        okno.vyber4.setText("");

        main.dalsikrok1 = "rozcesti";
        main.dalsikrok2 = "";
        main.dalsikrok3 = "";
        main.dalsikrok4 = "";
    }

    public void good_ending()
    {
        okno.hlavniText.setText("Voják je překvapen, že máš kartičku. Bez dalších slov ustoupí a otevře ti dveře základny. " +
                "Nevíš, co tě čeká, ale aspoň jsi udělal první krok k záchraně. " +
                "Vstupuješ dovnitř. Dveře se za tebou zavírají.\n<<KONEC>>");

        okno.vyber1.setText("Úvodní obrazovka");
        okno.vyber2.setText("Ukončit hru");
        okno.vyber3.setVisible(false);
        okno.vyber4.setVisible(false);

        main.dalsikrok1 = "uvodni_obrazovka";
        main.dalsikrok2 = "konec";

    }

    public void smrt_hrace()
    {
        okno.hlavniText.setText("Tvůj zrak se rozmazává a svět kolem mizí. Padl jsi v boji.\n<<KONEC>>");

        okno.vyber1.setText("Úvodní obrazovka");
        okno.vyber2.setText("Ukončit hru");
        okno.vyber3.setVisible(false);
        okno.vyber4.setVisible(false);


        main.dalsikrok1 = "uvodni_obrazovka";
        main.dalsikrok2 = "konec";
    }

    public void uvodni_obrazovka()
    {
        nastaveniZaklad();
        prepnuti.zapnoutMenu();
    }
}