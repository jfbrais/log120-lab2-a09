/******************************************************
 Cours :             LOG120
 Session :           Saison automne 2009
 Groupe :            03
 Projet :            Laboratoire #1
 Étudiant(e)(s) :    Gabriel Desmarais
 					 Jean-François Brais-Villemur
 Code(s) perm. :     DESG24078908
 					 BRAJ14088901
 Professeur :        Jocelyn Benoît
 Chargé de labo.:    Vincent Carrier
 					 Yanick Rochon
 Nom du fichier :	 DecoupeChaine.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-10-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 
 2009-10-29	Gabriel Desmarais :
  			Modifications pour les exigences du TP2.
 *******************************************************/

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import ca.etsmtl.log.util.IDLogger;

/**
 * Classe gérant la séparations des informations reçues dans un format plus utile et compréhensible.
 * @author Gab
 *
 */
public class DecoupeChaine
{
	private static IDLogger logger = IDLogger.getInstance();
	
	/**
	 * Crée un paquet d'information et le retourne
	 * 
	 * @param cmd
	 * @return info
	 */
	public InformationsPaquet decouper(String cmd)
	{
		String type = null;
		int nseq = 0;
		int[] param = new int[4];

		/* Valide la chaine reçue du serveur */
		Pattern detect = Pattern
				.compile("(\\d+)\\s[<](\\w+)[>]\\s(\\d+)\\s(\\d+)\\s(\\d+)\\s(\\d+)?");
		Matcher search = detect.matcher(cmd);
		if (search.find())
		{
			nseq = Integer.parseInt(search.group(1));
			type = search.group(2);
			for (int i = 0; i < 4; i++)
			{
				if (search.group(i + 3) != null)
					param[i] = Integer.parseInt(search.group(i + 3));
			}
		}

		/* Log le ID du dernier paquet reçu */ 
		logger.logID(nseq);
		
		/* Création du paquet d'information */
		InformationsPaquet info = new InformationsPaquet(nseq, type, param[0],
				param[1], param[2], param[3]);

		return info;
	}
}
