/******************************************************
 Cours :             LOG120
 Session :           Saison automne 2009
 Groupe :            03
 Projet :            Laboratoire #1
 �tudiant(e)(s) :    Gabriel Desmarais
 					 Jean-Fran�ois Brais-Villemur
 Code(s) perm. :     DESG24078908
 					 BRAJ14088901
 Professeur :        Jocelyn Beno�t
 Charg� de labo.:    Vincent Carrier
 					 Yanick Rochon
 Nom du fichier :	 ComparateurLargeurDown.java 					 
 Date cr��e :        2009-10-29
 Date dern. modif. : 2009-10-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-10-29 : Status Initial
 *******************************************************/

import java.util.Comparator;

/**
 * Comparateur de largeur pour le tri.
 * 
 * @author Gab
 *
 */
public class ComparateurLargeurDown implements Comparator<Forme>
{
	/**
	 * Retourne l'entier 1 s'il doit interchanger les objets ou non, -1 s'il ne doit pas.
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Forme forme1, Forme forme2)
	{
		int value = -1;
		if (forme1.getWidth() < forme2.getWidth())
		{
			value = 1;
		}
		return value;
	}
}
