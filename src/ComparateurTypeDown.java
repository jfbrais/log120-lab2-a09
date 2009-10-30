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
 Nom du fichier :	 ComparateurTypeDown.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.util.Comparator;

/**
 * Comparateur de type pour le tri.
 * 
 * @author Gab
 *
 */
public class ComparateurTypeDown implements Comparator<Forme>
{
	/**
	 * Retourne l'entier 1 s'il doit interchanger les objets ou non, -1 s'il ne doit pas.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Forme forme1, Forme forme2)
	{
		int valForme1 = 0;
		int valForme2 = 0;

		if (forme1 instanceof Carre)
			valForme1 = 1;
		else if (forme1 instanceof Rectangle)
			valForme1 = 2;
		else if (forme1 instanceof Cercle)
			valForme1 = 3;
		else if (forme1 instanceof Ovale)
			valForme1 = 4;
		else if (forme1 instanceof Ligne)
			valForme1 = 5;
		
		if (forme2 instanceof Carre)
			valForme2 = 1;
		else if (forme2 instanceof Rectangle)
			valForme2 = 2;
		else if (forme2 instanceof Cercle)
			valForme2 = 3;
		else if (forme2 instanceof Ovale)
			valForme2 = 4;
		else if (forme2 instanceof Ligne)
			valForme2 = 5;

		int value = -1;
		if (valForme1 < valForme2)
		{
			value = 1;
		}
		return value;
	}
}
