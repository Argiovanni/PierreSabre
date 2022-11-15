package personnages;

public class Humain {
	public static final int TAILLEMEMOIRE = 30;
	
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected Humain[] memoire = new Humain[TAILLEMEMOIRE];
	protected int nbConnaisance = 0;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	
	protected String prendreParole() {
		return "(" + nom +")- ";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour, je m'appelle " + nom + " et j'aime boire du " + boissonFavorite);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à "+ prix + " sous.");
			perdreArgent(prix);
		} else {
			parler ("Je n'ai plus que " + argent + " sous en poche. Je ne paux même pas m'offrir un " + bien + " à "+ prix + " sous.");
		}
	}
	
	protected void gagnerArgent(int gain) {
		this.argent += gain;
	}
	
	protected void perdreArgent(int perte) {
		if (perte > argent) { // autorise humain à avoir des dettes ? ou fixe sur 0 anyways ?
			this.argent = 0; 
		} else {
			this.argent -= perte;
		}
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		memoriser(autreHumain);
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaisance < TAILLEMEMOIRE) {
			memoire[nbConnaisance]= humain;
			nbConnaisance ++;
		} else {
			for (int i = 0; i < TAILLEMEMOIRE-1; i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[TAILLEMEMOIRE -1] = humain;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		if (nbConnaisance > 0) {
			String texte = "Je connais beaucoup de monde dont: ";
			for (int i = 0; i < nbConnaisance; i++) {
				texte += memoire[i].getNom() + ", ";
			}
			parler(texte);
		} else {
			parler("Je ne connais personnes.");
		}
		
	}
	
}
