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
 Nom du fichier :	 ComparateurSurfUp.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.util.Comparator;

/**
 * Comparateur de surface pour le tri.
 * 
 * @author Gab
 *
 */
public class ComparateurSurfUp implements Comparator<Forme>
{
	/**
	 * Retourne l'entier 1 s'il doit interchanger les objets ou non, -1 s'il ne doit pas.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getAire()>forme2.getAire())
		{
			value = 1;
		}
		return value;
	}
}
