package kernel;

public class Localitate 
{
	private String _nume;
	
	public String getNume()
	{
		return this._nume;
	}
	
	public void setNume(String nume)
	{
		this._nume = nume;
	}
	
	private int _punctaj;
	
	
	public int getPunctaj()
	{
		return this._punctaj;
	}
	
	public void setPunctaj(int punctaj)
	{
		this._punctaj = punctaj;
	}
	
	private Jucator _detinator;
	
	
	public Jucator getDetinator()
	{
		return this._detinator;
	}
	
	public void setDetinator(Jucator jucator)
	{
		this._detinator = jucator;
	}
	
	
	public Localitate()
	{
		this._nume = "";
		this._punctaj = 0;
	}
}
