package obiecte;

public class Caine {

	String specie;
	String tipUrechi;
	String culoare;
	static String nume;
	int nrPicioare;
	double greutate;
	int varsta;

	public void latra() {
		System.out.println("whof whof! " + specie);
	}

	public boolean handicap() {
		if (nrPicioare != 4) {
			return true;
		}
		return false;
	}

	public void afiseazaInformatii() {
		System.out.println(specie + " " + tipUrechi + " " + culoare + " "
				+ nume + " " + nrPicioare + " " + greutate + " " + varsta);
	}
}
