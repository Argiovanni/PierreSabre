package personnages;

public class Ronin extends Humain {
	private int honneur = 1;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = super.getArgent() / 10;
		super.parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		super.perdreArgent(don);
		beneficiaire.recevoir(don);
	}

	public void provoquer(Yakuza adversaire) {
		int force = honneur * 2;
		int reputationAdversaire = adversaire.getReputation();
		int bourse = 0;
		
		if (force >= reputationAdversaire) {
			super.parler("Je t'ai eu petit Yakuza !");
			bourse = adversaire.perdre();
			honneur += 1;
			super.gagnerArgent(bourse);			
		} else {
			bourse = super.getArgent();
			super.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			honneur -= 1;
			super.argent -= bourse;
			adversaire.gagner(bourse);
			
		}
	}
	
}
