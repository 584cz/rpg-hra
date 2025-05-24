public class Hrac
{
  String jmeno;
  float zivoty;
  public Zbrane zbran;

  public Hrac(String jmeno)
  {
    this.jmeno = jmeno;
    this.zivoty = 20;
    this.zbran = new Nuz();
  }
}

class Pruzkumnik extends Hrac
{
  public Pruzkumnik(String jmeno)
  {
    super(jmeno);
    this.zivoty = 40;
    this.zbran = new Nuz();
  }
}

class Opravar extends Hrac
{
  public Opravar(String jmeno)
  {
    super(jmeno);
    this.zivoty = 30;
    this.zbran = new Dyka();
  }
}
