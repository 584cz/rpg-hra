public class PrepinaniOken
{
    Okno okno;

    public PrepinaniOken(Okno okno2)
    {
        okno = okno2;
    }

    public void vyberHrace()
    {
        //zapne vybiraci obrazovku
        okno.vyberHrac.setVisible(true);

        okno.jmenoHryPanel.setVisible(false);
        okno.menuPanel.setVisible(false);
        okno.textHerniPanel.setVisible(false);
        okno.tlacitkaHerniPanel.setVisible(false);
        okno.statistikyPanel.setVisible(false);
    }

    public void zapnoutMenu()
    {
        //zapne hlavni obrazovku
        okno.jmenoHryPanel.setVisible(true);
        okno.menuPanel.setVisible(true);

        //vypne obrazovku hry
        okno.textHerniPanel.setVisible(false);
        okno.tlacitkaHerniPanel.setVisible(false);
        okno.statistikyPanel.setVisible(false);
        okno.vyberHrac.setVisible(false);
    }

    public void zapnoutPrvniLokaci()
    {
        //zapne hru
        okno.statistikyPanel.setVisible(true);
        okno.textHerniPanel.setVisible(true);
        okno.tlacitkaHerniPanel.setVisible(true);

        //vypne obrazovku hry
        okno.jmenoHryPanel.setVisible(false);
        okno.menuPanel.setVisible(false);
        okno.vyberHrac.setVisible(false);
    }
}
