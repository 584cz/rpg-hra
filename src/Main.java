import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    VyberClass vClass = new VyberClass();
    VyberHandler vHandler = new VyberHandler();
    Okno okno = new Okno();
    PrepinaniOken prepnuti = new PrepinaniOken(okno);
    Pribeh pribeh = new Pribeh(this, okno, prepnuti);

    String dalsikrok1,dalsikrok2,dalsikrok3,dalsikrok4;

    static String vybranaClass = "";

    public static void main(String[] args)
    {
        new Main();
    }

    public Main()
    {
        okno.vytvorOkno(vHandler, vClass);
        prepnuti.zapnoutMenu();
    }

    public class VyberHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String vyberHrace = event.getActionCommand();

            switch (vyberHrace)
            {
                case "zacatek": prepnuti.vyberHrace();  break;
                case "v1": pribeh.vyberKroku(dalsikrok1) ; break;
                case "v2": pribeh.vyberKroku(dalsikrok2) ; break;
                case "v3": pribeh.vyberKroku(dalsikrok3) ; break;
                case "v4": pribeh.vyberKroku(dalsikrok4) ; break;
                case "konec":  System.exit(0);
            }
        }
    }

    public class VyberClass implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (okno.vyber_class1.isSelected())
            {
                vybranaClass = "class1";
            } else if (okno.vyber_class2.isSelected())
            {
                vybranaClass = "class2";
            }

            switch (vybranaClass)
            {
                case "class1", "class2": pribeh.potvrdit_hrac(); break;

            }
        }
    }
}