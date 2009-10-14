/******************************************************
 * Cours : LOG120 Session : Saison automne 2009 Groupe : 03 Projet : Laboratoire
 * #1 Étudiant(e)(s) : Gabriel Desmarais Code(s) perm. : DESG24078908 Professeur
 * : Jocelyn Benoît Chargé de labo.: Vincent Carrier Yanick Rochon Nom du
 * fichier : CreateurForme.java Date créée : 2009-09-29 Date dern. modif. :
 * 2009-09-29
 * 
 ******************************************************* 
 * Historique des modifications
 ******************************************************* 
 * 2009-09-29 : Status Initial
 *******************************************************/

public class CreateurForme
{
	/**
	 * Crée une forme et la retourne
	 * 
	 * @param paquet
	 * @return nouvelleCreation
	 */
	public Forme creerForme(InformationsPaquet paquet, int original)
	{
		Forme nouvelleCreation = null;

		/* Détermine si c'est un Cercle */
		if (paquet.getType().equals("CERCLE"))
		{
			nouvelleCreation = new Cercle(paquet.getParams(0), paquet
					.getParams(1), paquet.getParams(2), original, paquet.getNseq());
		}

		/* Détermine si c'est un Carre */
		if (paquet.getType().equals("CARRE"))
		{
			nouvelleCreation = new Carre(paquet.getParams(0), paquet
					.getParams(1), paquet.getParams(2), paquet.getParams(3),
					original, paquet.getNseq());
		}

		/* Détermine si c'est un Rectangle */
		if (paquet.getType().equals("RECTANGLE"))
		{
			nouvelleCreation = new Rectangle(paquet.getParams(0), paquet
					.getParams(1), paquet.getParams(2), paquet.getParams(3),
					original, paquet.getNseq());
		}

		/* Détermine si c'est un Ovale */
		if (paquet.getType().equals("OVALE"))
		{
			nouvelleCreation = new Ovale(paquet.getParams(0), paquet
					.getParams(1), paquet.getParams(2), paquet.getParams(3),
					original, paquet.getNseq());
		}

		/* Détermine si c'est un Ligne */
		if (paquet.getType().equals("LIGNE"))
		{
			nouvelleCreation = new Ligne(paquet.getParams(0), paquet
					.getParams(1), paquet.getParams(2), paquet.getParams(3),
					original, paquet.getNseq());
		}
		
		return nouvelleCreation;
	}
}
