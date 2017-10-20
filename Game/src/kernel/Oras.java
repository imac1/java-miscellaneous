package kernel;

public class Oras extends Localitate 
{	
	final public static int PUNCTE = 5;
	
	public void InchinaOrasul(Jucator castigator)
	{
		castigator.AdaugaLocalitate(this);
		castigator.setPunctaj(PUNCTE);
	}
	
	public Oras()
	{
		super();
		this.setPunctaj(0);
	}
}
