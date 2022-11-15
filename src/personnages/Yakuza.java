package personnages;

public class Yakuza extends Humain{
	private String clan;
	private int reputation = 4;
	
	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}
	
	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		super.parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int vol = victime.seFaireExtorquer();
		reputation ++;
		super.gagnerArgent(vol);
		super.parler("J'ai piqué les " + vol + " sous de " + victime.getNom() + ", ce qui me fait " + super.getArgent()
		+ " sous dans ma poche. Hi ! Hi !");
	}
	
	public int perdre() {
		int perte = super.getArgent();
		if (reputation > 0) {
			reputation --;
		}
		parler("J’ai perdu mon duel et mes "+ perte + " sous, snif... J'ai déshonoré le clan de " + clan);
		super.perdreArgent(perte);
		return perte;
	}
	
	public void gagner(int gain) {
		super.parler("Ce ronin pensait vraiment battre "+ super.getNom() + " du clan de " + clan + 
				" ? Je l'ai dépouillé de ses " + gain + " sous.");
		 super.gagnerArgent(gain);
		 reputation ++;
	}
	
}
