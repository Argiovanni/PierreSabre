package personnages;

public class Commercant extends Humain{
	
	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}

	public int seFaireExtorquer() {
		int bourse = getArgent();
		super.perdreArgent(getArgent());
		super.parler("J’ai tout perdu! Le monde est trop injuste...");
		return bourse;
	}
	
	public void recevoir(int argent) {
		super.gagnerArgent(argent);
		super.parler(argent + " sous ! Je te remercie généreux donateur !");
	}

}
