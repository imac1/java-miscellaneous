package obiecte;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class TestMain {
	
	static String specieCaine1;
	static int nrPicioareCaine1;
	
	static String specieCaine2;
	static int nrPicioareCaine2;
	
	static String[]specieCaine = new String[2];
	static int[]nrPicioare = new int[2];
	
	public static void main(String[] args) {
		//Varianta 1
		specieCaine1 = "westie";
		nrPicioareCaine1 = 4;
		
		specieCaine2 = "maidanez";
		nrPicioareCaine2 = 3;
		
		//Varianta 2
		specieCaine[0] = "westie";
		nrPicioare[0] = 4;
		
		specieCaine[1] = "maidanez";
		nrPicioare[1] = 3;
		
		//Varianta 3
		Caine[] listaCaini = new Caine[2];
		
		Caine caine = new Caine();
		caine.specie = "westie";
		caine.nrPicioare = 4;
		caine.nume = "Yogi";
		listaCaini[0] = caine;
		
		Caine altCaine = new Caine();
		altCaine.specie = "maidanez";
		altCaine.nrPicioare = 3;
		altCaine.nume = "John Doe";
		
		System.out.println(caine);
		System.out.println(caine == altCaine);
		System.out.println(listaCaini[0].specie + " " + listaCaini[0].nrPicioare);
		System.out.println(altCaine.specie + " " + altCaine.nrPicioare);
		
		
		caine.latra();
		if (caine.handicap()) {
			System.out.println(caine.specie + " are probleme");
		}
		
		altCaine.latra();
		if (altCaine.handicap()) {
			System.out.println(altCaine.specie + " are probleme");
		}
		
		caine.greutate = 6.1;
		
		caine.afiseazaInformatii();
		altCaine.afiseazaInformatii();
		
		
	}
}
