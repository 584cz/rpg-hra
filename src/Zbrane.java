public class Zbrane
{
    public String nazev;
    public int utok;

    public Zbrane(String nazev, int utok)
    {
        this.nazev = nazev;
        this.utok = utok;
    }
}

class Nuz extends Zbrane
{

    public Nuz()
    {
        super("Nůž",5);
    }
}

class Dyka extends Zbrane
{
    public Dyka()
    {
        super("Dýka",7);
    }
}

class Pistol extends Zbrane
{
    public Pistol()
    {
        super("Pistol", 13);
    }
}

