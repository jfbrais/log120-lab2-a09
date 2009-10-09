/******************************************************
 Cours :             LOG120
 Session :           Saison automne 2009
 Groupe :            03
 Projet :            Laboratoire #1
 Étudiant(e)(s) :    Gabriel Desmarais
 Code(s) perm. :     DESG24078908
 Professeur :        Jocelyn Benoît
 Chargé de labo.:    Vincent Carrier
 					 Yanick Rochon
 Nom du fichier :	 FormeStocker.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

public class FormeStocker
{
	
	private Forme[] tableau = new Forme[10];
	
	public void stocker(Forme newForme)
	{
		int emplacement = 0;
		boolean noMore = false;
		
		/* Trouve l'emplcement vide */ 
		while (emplacement < 10 && !noMore)
		{
			if (tableau[emplacement] == null)
			{
				noMore = true;
			}
			else
			{
				emplacement++;
			}
		}

		/* S'il n'y en a pas, transfère les formes et utilise le dernier emplacement */ 
		if (!noMore)
		{
			for (int i = 0; i < 9; i++)
			{
				tableau[i] = tableau[i + 1];
			}
			emplacement = 9;
		}

		/* Ajoute la forme au tableau à l'aide du CreateurForme */ 
		tableau[emplacement] = newForme;
	}
	
	public Forme getTableau(int emplacement)
	{
		return tableau[emplacement];
	}
}
