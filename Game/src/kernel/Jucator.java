package kernel;

import java.util.ArrayList;
import java.util.Collections;

public class Jucator 
{
	private ArrayList<Localitate> _list;
	private int _punctaj;
	
	
	public int getPunctaj()
	{
		return this._punctaj;
	}
	
	public void setPunctaj(int punctaj)
	{
		this._punctaj += punctaj;
	}
	 
	public Jucator()
	{
		_list = new ArrayList<Localitate>();
		_punctaj = 0;
	}

	public int Arunca(Zar zar)
	{
		return zar.Roztogolire();
	}
	
	public void AdaugaLocalitate(Localitate localitate)
	{
		localitate.setDetinator(this);
		_list.add(localitate);
		Collections.sort(_list, (o1, o2) -> o1.getNume().compareTo(o2.getNume()));
	}
	
	public Localitate StergeLocalitate()
	{
		return _list.remove(0);
	}
	
	public boolean SuntFalit()
	{
		if (this._list.size()==0)
			return true;
		
		return false;
			
	}
	
	public void DumpLocalitati()
	{
		for (Localitate localitate : _list) 
		{
			System.out.print(localitate.getNume()+" ("+(localitate.getClass()==Oras.class?"Oras":"Resedinta")+") ");
		}
		System.out.println();
	}
	
	ArrayList<Localitate> getLocalitati()
	{
		return this._list;
	}
}
