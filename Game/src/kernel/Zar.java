package kernel;

import java.util.Random;

public class Zar 
{
	public int Roztogolire()
	{
		int maximum = 9;
		int minimum = 1;
		int numar = minimum + (int)(Math.random() * maximum); 
		
		System.out.println("A aruncat "+numar);
		return numar;
	}
}
