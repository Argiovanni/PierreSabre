package personnages;

public class Humain {
	protected String nom;
	protected String boissonFavorite;
	protected int argent;
	
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
	
	
}
