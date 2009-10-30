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
 Nom du fichier :	 InformationsPaquet.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-10-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 
 2009-10-29	Gabriel Desmarais :
  			Modifications pour les exigences du TP2.
 *******************************************************/

/**
 * Classe contenant les informations séparées de la chaine de caractère reçue du serveur.
 * 
 * @author Gab
 *
 */
public class InformationsPaquet
{
	private int nseq;
	private String type;
	private int[] params = new int[4];
	
	/**
	 * Constructeur personnalisé
	 * 
	 * @param nseq
	 * @param type
	 * @param param1
	 * @param param2
	 * @param param3
	 * @param param4
	 */
	public InformationsPaquet(int nseq, String type, int param1, int param2, int param3, int param4)
	{
		this.setNseq(nseq);
		this.setType(type);
		this.setParams(param1,0);
		this.setParams(param2,1);
		this.setParams(param3,2);
		this.setParams(param4,3);
	}

	/**
	 * Configure le no de séquence.
	 * 
	 * @param nseq
	 */
	private void setNseq(int nseq)
	{
		this.nseq = nseq;
	}

	/**
	 * Retourne le no de séquence.
	 * 
	 * @return nseq
	 */
	public int getNseq()
	{
		return nseq;
	}

	/**
	 * Configure le type.
	 * 
	 * @param type
	 */
	private void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Retourne le type.
	 * 
	 * @return type
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * Configure un paramètre.
	 * 
	 * @param param
	 * @param numParam
	 */
	private void setParams(int param, int numParam)
	{
		this.params[numParam] = param;
	}

	/**
	 * Retourne un paramètre.
	 * 
	 * @param numParam
	 * @return param[numParam]
	 */
	public int getParams(int numParam)
	{
		return params[numParam];
	}
	
}
