public class Nepratele
{
    public String jmeno;
    public int zdravi;
    public int utok_monstra;

    public Nepratele(String jmeno, int zdravi, int utok_monstra)
    {
        this.jmeno = jmeno;
        this.zdravi = zdravi;
        this.utok_monstra = utok_monstra;
    }
}

class Robot extends Nepratele
{

    public Robot()
    {
        super("Robot", 20, 5);
    }
}

class RobotMK2 extends Nepratele
{

    public RobotMK2()
    {
        super("Velký robot", 50, 10);
    }
}