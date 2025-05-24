import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Okno extends JFrame
{
    JPanel jmenoHryPanel, menuPanel, textHerniPanel, tlacitkaHerniPanel, statistikyPanel, vyberHrac;
    JTextArea hlavniText;
    JButton zacatekTlacitko, konecTlacitko,vyber1,vyber2,vyber3,vyber4, potvrzeni;
    JLabel jmenoHry, zivoty, zivotyCislo, zbran, zbranNazev, jmeno_hrac_Label, jmeno_hrac_Info, info_jmeno,info_class;
    JTextField zadej_jmeno;
    JRadioButton vyber_class1,vyber_class2;

    Font mainFont = new Font("Tahoma", Font.PLAIN, 70);
    Font textFont = new Font("Tahoma", Font.PLAIN, 25);

    static final Color MODRA = new Color(4, 21, 36);
    static final Color BILA = new Color(253, 242, 212);
    static final Color ZLUTA = new Color(222, 175, 93);

    public void vytvorOkno (Main.VyberHandler vHandler, Main.VyberClass vClass)
    {
        //hlavni okno
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(MODRA);
        this.setLayout(null); //pro vlastni layout

        this.setTitle("Vesmírná cesta - NF");

        ImageIcon image = new ImageIcon("obrazky/logo.png");
        this.setIconImage(image.getImage());

        this.setResizable(false); //nelze zmenit velikost okna
        this.setLocationRelativeTo(null); //otevre okno uprostred


        //panel pro nazev hry
        jmenoHryPanel = new JPanel();
        jmenoHryPanel.setLayout(null);

        jmenoHryPanel.setBounds(100,100,600,200);
        jmenoHryPanel.setBackground(MODRA);

        jmenoHry = new JLabel("VESMÍRNÁ CESTA");
        jmenoHry.setForeground(ZLUTA);
        jmenoHry.setFont(mainFont);
        jmenoHry.setBounds(0, 0, 600, 100);

        jmenoHryPanel.add(jmenoHry);

        this.add(jmenoHryPanel);

        //panel pro menu hry
        menuPanel = new JPanel();
        menuPanel.setBounds(250, 300, 300, 200);
        menuPanel.setBackground(MODRA);

        menuPanel.setLayout(new GridLayout(2, 1, 5, 5));

        //tlacitka pro menu hry
        zacatekTlacitko = new JButton("Zapnout");
        konecTlacitko = new JButton("Ukončit");

        zacatekTlacitko.setBackground(MODRA);
        zacatekTlacitko.setForeground(ZLUTA);

        konecTlacitko.setBackground(MODRA);
        konecTlacitko.setForeground(ZLUTA);

        konecTlacitko.setBorder(new LineBorder(ZLUTA, 1));
        zacatekTlacitko.setBorder(new LineBorder(ZLUTA, 1));


        zacatekTlacitko.setFocusable(false); //aby nevypadalo divne po kliknuti
        konecTlacitko.setFocusable(false);

        zacatekTlacitko.setFont(textFont);
        konecTlacitko.setFont(textFont);


        zacatekTlacitko.addActionListener(vHandler);
        zacatekTlacitko.setActionCommand("zacatek");
        konecTlacitko.addActionListener(vHandler);
        konecTlacitko.setActionCommand("konec");


        menuPanel.add(zacatekTlacitko);
        menuPanel.add(konecTlacitko);

        this.add(menuPanel);


        // Okno ve hre
        textHerniPanel = new JPanel();
        textHerniPanel.setBounds(100, 130, 600, 200);
        textHerniPanel.setBackground(MODRA);

        this.add(textHerniPanel);

        hlavniText = new JTextArea("Problém. Restartujte hru!");
        hlavniText.setBounds(100, 130, 600, 200);

        hlavniText.setBackground(MODRA);
        hlavniText.setForeground(BILA);
        hlavniText.setFont(textFont);

        hlavniText.setLineWrap(true); //at to dela spravne radky
        hlavniText.setWrapStyleWord(true);
        hlavniText.setEditable(false);

        textHerniPanel.add(hlavniText);

        tlacitkaHerniPanel = new JPanel();
        tlacitkaHerniPanel.setBounds(250,350,300,150);
        tlacitkaHerniPanel.setBackground(MODRA);
        tlacitkaHerniPanel.setLayout(new GridLayout(4, 1));

        this.add(tlacitkaHerniPanel);

        //samostatny herni tlacitka
        vyber1= new JButton("prvni");
        vyber2= new JButton("druha");
        vyber3= new JButton("treti");
        vyber4= new JButton("ctvrta");

        vyber1.setBorder(new LineBorder(ZLUTA, 1));
        vyber2.setBorder(new LineBorder(ZLUTA, 1));
        vyber3.setBorder(new LineBorder(ZLUTA, 1));
        vyber4.setBorder(new LineBorder(ZLUTA, 1));


        vyber1.setBackground(MODRA);
        vyber2.setBackground(MODRA);
        vyber3.setBackground(MODRA);
        vyber4.setBackground(MODRA);


        vyber1.setForeground(BILA);
        vyber2.setForeground(BILA);
        vyber3.setForeground(BILA);
        vyber4.setForeground(BILA);


        vyber1.setFocusable(false);
        vyber2.setFocusable(false);
        vyber3.setFocusable(false);
        vyber4.setFocusable(false);

        vyber1.setFont(textFont);
        vyber2.setFont(textFont);
        vyber3.setFont(textFont);
        vyber4.setFont(textFont);

        vyber1.addActionListener(vHandler);
        vyber2.addActionListener(vHandler);
        vyber3.addActionListener(vHandler);
        vyber4.addActionListener(vHandler);

        vyber1.setActionCommand("v1");
        vyber2.setActionCommand("v2");
        vyber3.setActionCommand("v3");
        vyber4.setActionCommand("v4");

        tlacitkaHerniPanel.add(vyber1);
        tlacitkaHerniPanel.add(vyber2);
        tlacitkaHerniPanel.add(vyber3);
        tlacitkaHerniPanel.add(vyber4);

    //horni statistiky
        statistikyPanel = new JPanel();
        statistikyPanel.setBounds(100, 20, 600, 60);
        statistikyPanel.setBackground(MODRA);
        statistikyPanel.setLayout(new GridLayout(1,6));

        statistikyPanel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(ZLUTA, 2),
                new EmptyBorder(10, 15, 10, 15)
        ));

        this.add(statistikyPanel);


        zivoty = new JLabel("Životy:");
        zivoty.setForeground(BILA);
        zivoty.setFont(textFont);
        statistikyPanel.add(zivoty);


        zivotyCislo = new JLabel("error");
        zivotyCislo.setForeground(BILA);
        zivotyCislo.setFont(textFont);
        statistikyPanel.add(zivotyCislo);


        zbran = new JLabel("Zbraň:");
        zbran.setForeground(BILA);
        zbran.setFont(textFont);
        statistikyPanel.add(zbran);


        zbranNazev = new JLabel("error");
        zbranNazev.setForeground(BILA);
        zbranNazev.setFont(textFont);
        statistikyPanel.add(zbranNazev);


        jmeno_hrac_Info = new JLabel("Hráč:");
        jmeno_hrac_Info.setForeground(BILA);
        jmeno_hrac_Info.setFont(textFont);
        statistikyPanel.add(jmeno_hrac_Info);


        jmeno_hrac_Label = new JLabel("error");
        jmeno_hrac_Label.setForeground(BILA);
        jmeno_hrac_Label.setFont(textFont);
        statistikyPanel.add(jmeno_hrac_Label);


        // vyber pro postavu a jmeno
        vyberHrac = new JPanel();
        vyberHrac.setBounds(100, 100, 600, 350);
        vyberHrac.setBackground(MODRA);
        vyberHrac.setLayout(new GridLayout(6, 1, 10, 10)); // mezery mezi řádky
        vyberHrac.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(ZLUTA, 2),
                new EmptyBorder(10, 20, 10, 20)
        ));
        this.add(vyberHrac);

        info_jmeno = new JLabel("Zadej jméno (Max. 6 znaků)");
        info_class = new JLabel("Vyber si postavu.");


        info_jmeno.setForeground(BILA);
        info_jmeno.setBackground(MODRA);
        info_jmeno.setFont(textFont);

        info_class.setForeground(BILA);
        info_class.setBackground(MODRA);
        info_class.setFont(textFont);


        vyber_class1 = new JRadioButton("Průzkumník");
        vyber_class2 = new JRadioButton("Opravář");
        potvrzeni = new JButton("Potvrdit");


        zadej_jmeno = new JTextField("");
        zadej_jmeno.setForeground(MODRA);
        zadej_jmeno.setBackground(ZLUTA);
        zadej_jmeno.setFont(textFont);
        zadej_jmeno.setBorder(new LineBorder(BILA, 2));

        vyber_class1.setBackground(MODRA);
        vyber_class1.setForeground(BILA);
        vyber_class1.setFont(textFont);
        vyber_class1.setActionCommand("class1");
        vyber_class1.setSelected(true);
        vyber_class1.setFocusable(false);


        vyber_class2.setBackground(MODRA);
        vyber_class2.setForeground(BILA);
        vyber_class2.setFont(textFont);
        vyber_class2.setActionCommand("class2");
        vyber_class2.setFocusable(false);

        vyber_class1.setSelected(true);


        ButtonGroup vyberClass = new ButtonGroup();
        vyberClass.add(vyber_class1);
        vyberClass.add(vyber_class2);

        potvrzeni.setBackground(MODRA);
        potvrzeni.setForeground(BILA);
        potvrzeni.setFont(textFont);
        potvrzeni.setFocusable(false);
        potvrzeni.setBorder(new LineBorder(ZLUTA, 1));
        potvrzeni.setActionCommand(vyber_class1.isSelected() ? "class1" : "class2");
        potvrzeni.addActionListener(vClass);


        vyberHrac.add(info_class);
        vyberHrac.add(vyber_class1);
        vyberHrac.add(vyber_class2);
        vyberHrac.add(info_jmeno);
        vyberHrac.add(zadej_jmeno);
        vyberHrac.add(potvrzeni);

        this.setVisible(true);

    }

}
