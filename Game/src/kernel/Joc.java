package kernel;
import java.applet.Applet;
import java.awt.*;

public class Joc extends Applet 
{
	private Jucator _user;
	private Jucator _pc;
	
	public Joc()
	{
		
	}
	
	
	public void Start()
	{
		Desfasurare();
	}
	
	private void Desfasurare ()
	{
		int runda = 1;
		Zar zar = new Zar();
		while (!this._user.SuntFalit() && !this._pc.SuntFalit())
		{
			System.out.println("Runda "+runda);
			System.out.println("");
			
			System.out.println("User");
			this._user.DumpLocalitati();
			int user = this._user.Arunca(zar);
			System.out.println("");
			
			System.out.println("PC");
			this._pc.DumpLocalitati();
			int pc = this._pc.Arunca(zar);
			System.out.println("");
			
			if (user>pc)
			{
				Localitate localitate = this._pc.StergeLocalitate();
				if (localitate.getClass() == Oras.class)
					((Oras)localitate).InchinaOrasul(this._user);
				else
					((Resedinta)localitate).InchinaResedinta(this._user);
				System.out.println("Userul a castigat si a inchinat localitatea "+localitate.getNume()+" (Oras) acumuland "+this._user.getPunctaj()+" puncte");
			}
			else
			{
				Localitate localitate = this._user.StergeLocalitate();
				if (localitate.getClass() == Oras.class)
					((Oras)localitate).InchinaOrasul(this._pc);
				else
					((Resedinta)localitate).InchinaResedinta(this._pc);
				System.out.println("PC a castigat si a inchinat localitatea "+localitate.getNume()+" (Resedinta) acumuland "+this._pc.getPunctaj()+" puncte");
			}
			System.out.println("");
			runda++;
		}
		Stop();
	}
	
	private void Stop()
	{
		if (this._user.SuntFalit())
			System.out.println("PC a castigat");
		else
			System.out.println("Userului a castigat");
	}
	
	public Joc(Jucator user,Jucator pc)
	{
		this._user = user;
		this._pc = pc;
	}
	
	Image city;
	Image rcity;
	Image player;
	Jucator user;
	Jucator pc;
	
	public void init()
	{
		Oras oras;
		Resedinta resedinta;
	
		user = new Jucator();
		
		resedinta = new Resedinta();
		resedinta.setNume("Alexandria");
		user.AdaugaLocalitate(resedinta);
		
		resedinta = new Resedinta();
		resedinta.setNume("Bucuresti");
		user.AdaugaLocalitate(resedinta);
		
		resedinta = new Resedinta();
		resedinta.setNume("Calarasi");
		user.AdaugaLocalitate(resedinta);
		
		resedinta = new Resedinta();
		resedinta.setNume("Giurgiu");
		user.AdaugaLocalitate(resedinta);
		
		oras = new Oras();
		oras.setNume("Buftea");
		user.AdaugaLocalitate(oras);
		
		oras = new Oras();
		oras.setNume("Mizil");
		user.AdaugaLocalitate(oras);
		
		oras = new Oras();
		oras.setNume("Urziceni");
		user.AdaugaLocalitate(oras);	
		
		pc = new Jucator();
		
		resedinta = new Resedinta();
		resedinta.setNume("Alba-Iulia");
		pc.AdaugaLocalitate(resedinta);
		
		resedinta = new Resedinta();
		resedinta.setNume("Brasov");
		pc.AdaugaLocalitate(resedinta);
		
		resedinta = new Resedinta();
		resedinta.setNume("Sibiu");
		pc.AdaugaLocalitate(resedinta);
		
		resedinta = new Resedinta();
		resedinta.setNume("Targu-Mures");
		pc.AdaugaLocalitate(resedinta);
		
		oras = new Oras();
		oras.setNume("Copsa Mica");
		pc.AdaugaLocalitate(oras);
		
		oras = new Oras();
		oras.setNume("Ocna Sibiului");
		pc.AdaugaLocalitate(oras);
		
		oras = new Oras();
		oras.setNume("Sighisoara");
		pc.AdaugaLocalitate(oras);		
		
		Joc joc = new Joc(user,pc);
		joc.Start();
		
		city = getImage(getDocumentBase(),"city.jpg");
		rcity = getImage(getDocumentBase(),"resedinta.jpg");
		player = getImage(getDocumentBase(),"player.png");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim);
	}
	 
	
	public void paint(Graphics g) 
	{
		int w = this.size().width;
		int h = this.size().height;
		int x = 0;
		int y = 0;
		
		g.setColor(Color.black);
		g.fillRect(x,y,250,40);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.setColor(Color.white);
        g.drawString("PC", x+5, y+25);

        y+=40;
		g.setColor(Color.lightGray);
		g.fillRect(x,y,250,20);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(Color.black);
        g.drawString("Localitati stapanite", x+5, y+14);
        
        
        y+=30;
        int temp = y;
        for (Localitate localitate : pc.getLocalitati()) 
        {
        	g.drawImage((localitate.getClass()==Oras.class?city:rcity), x+5,y,50,50, this);
        	g.drawString(localitate.getNume(), x+5, y+65);
        	g.drawString((localitate.getClass()==Oras.class?"(Oras)":"(Resedinta)"), x+5, y+85);
        	y+=100;
        	if (y>temp+700)
        		y=temp;
		}
        y = temp;
        x=250;
        y=0;
		g.setColor(Color.black);
		g.fillRect(x,y,1,h);
		g.setColor(Color.darkGray);
		g.fillRect(x-50,y,50,60);
		
		g.setFont(new Font("Arial", Font.BOLD, 32));
        g.setColor(Color.lightGray);
        g.drawString(pc.getPunctaj()+"", x-35, y+30);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.lightGray);
        g.drawString("puncte", x-43, y+50);
		
		
		
		g.setColor(Color.black);
		g.fillRect(w-x,y,250,40);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.setColor(Color.white);
        g.drawString("USER", w-x+5+175, y+25);

        y+=40;
		g.setColor(Color.lightGray);
		g.fillRect(w-x,y,250,20);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.setColor(Color.black);
        g.drawString("Localitati stapanite", w-x+5+110, y+14);
        
        
        y+=30;
        temp = y;
        for (Localitate localitate : pc.getLocalitati()) 
        {
        	g.drawImage((localitate.getClass()==Oras.class?city:rcity), w-x+5,y,50,50, this);
        	g.drawString(localitate.getNume(), w-x+5, y+65);
        	g.drawString((localitate.getClass()==Oras.class?"(Oras)":"(Resedinta)"), w-x+5, y+85);
        	y+=100;
        	if (y>temp+700)
        		y=temp;
		}
        y = temp;
        x=250;
        y=0;
		g.setColor(Color.black);
		g.fillRect(w-x,y,1,h);
		g.setColor(Color.darkGray);
		g.fillRect(w-x,y,50,60);
		
		g.setFont(new Font("Arial", Font.BOLD, 32));
        g.setColor(Color.lightGray);
        g.drawString(pc.getPunctaj()+"", w-x+15, y+30);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.lightGray);
        g.drawString("puncte", w-x+6, y+50);

        
        g.drawImage(player, x+100,h/2-300,400,400, this);
        
        g.drawImage(player, (x+650)+400,h/2-300,-400,400, this);
        
 
    }
	
}
