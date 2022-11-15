package personnages;

import java.util.Random;

public class Traitre extends Samourai{
	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}
	
	public int getNiveauTraitrise() {
		return niveauTraitrise;
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est :" + getNiveauTraitrise() + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise >= 3) {
			parler("Mince je ne peut plus rançonner personne sinon un samourai risque de me démasquer !");
		} else {
			int argentCommercant = commercant.getArgent();
			int argentRanconner = argentCommercant * 2/10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			parler("Si tu veux ma protection contre les Yakuzas il va falloir payer! Donne-moi "
					+ argentCommercant + " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom());
		}
	}
	
	public void faireLeGentil() {
		if (super.nbConnaisance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne! Snif.");
		} else {
			int rangAmi;
			Random rand = new Random();
			rangAmi = rand.nextInt(super.nbConnaisance);
			Humain ami = super.memoire[rangAmi];
			int don = getArgent() / 20;
			String nomAmi = ami.getNom();
			parler("Il faut absoluement remonter ma cote de confiance. je vais faire ami ami avec " + nomAmi);
			parler("Bonjour l'ami. Je voudrais vous aider en vous donnant "+ don +" sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			ami.parler("Merci "+ getNom() + ". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise --;
			}
		}
	}
	

}
