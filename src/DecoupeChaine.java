/******************************************************
 Cours :             LOG120
 Session :           Saison automne 2009
 Groupe :            03
 Projet :            Laboratoire #1
 �tudiant(e)(s) :    Gabriel Desmarais
 Code(s) perm. :     DESG24078908
 Professeur :        Jocelyn Beno�t
 Charg� de labo.:    Vincent Carrier
 					 Yanick Rochon
 Nom du fichier :	 DecoupeChaine.java 					 
 Date cr��e :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import ca.etsmtl.log.util.IDLogger;

public class DecoupeChaine
{
	private static IDLogger logger = IDLogger.getInstance();
	
	/**
	 * Cr�e un paquet d'information et le retourne
	 * 
	 * @param cmd
	 * @return info
	 */
	public InformationsPaquet Decouper(String cmd)
	{
		String type = null;
		int nseq = 0;
		int[] param = new int[4];

		/* Valide la chaine re�ue du serveur */
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

		/* Log le ID du dernier paquet re�u */ 
		logger.logID(nseq);
		
		/* Cr�ation du paquet d'information */
		InformationsPaquet info = new InformationsPaquet(nseq, type, param[0],
				param[1], param[2], param[3]);

		return info;
	}
}
