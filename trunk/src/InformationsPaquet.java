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
 Nom du fichier :	 InformationsPaquet.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

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

	/* Différents Sets et Gets */
	/**
	 * @param nseq
	 */
	private void setNseq(int nseq)
	{
		this.nseq = nseq;
	}

	/**
	 * @return nseq
	 */
	public int getNseq()
	{
		return nseq;
	}

	/**
	 * @param type
	 */
	private void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return type
	 */
	public String getType()
	{
		return type;
	}
	
	/**
	 * @param param
	 * @param numParam
	 */
	private void setParams(int param, int numParam)
	{
		this.params[numParam] = param;
	}

	/**
	 * @param numParam
	 * @return param[numParam]
	 */
	public int getParams(int numParam)
	{
		return params[numParam];
	}
	
}
