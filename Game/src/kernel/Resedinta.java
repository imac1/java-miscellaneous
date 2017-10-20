package kernel;

public class Resedinta extends Localitate 
{
	final public static int PUNCTE = 10;
	
	public void InchinaResedinta(Jucator castigator)
	{
		castigator.AdaugaLocalitate(this);
		castigator.setPunctaj(PUNCTE);
		
	}
	
	public Resedinta()
	{
		super();
		this.setPunctaj(0);
	}
}
