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
 Nom du fichier :	 Forme.java 					 
 Date cr��e :        2009-09-29
 Date dern. modif. : 2009-10-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 
 2009-10-29	Gabriel Desmarais :
  			Modifications pour les exigences du TP2.
 *******************************************************/

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe abstraite comportant les m�thodes de base � red�finir dans toutes les classes h�ritant de forme.
 * 
 * @author Gab
 *
 */
public abstract class Forme
{
	protected int original;
	protected Color couleur;
	private Forme previous,
				  next;
	protected int nseq;

	/**
	 * M�thode qui g�re l'affichage des formes.
	 * 
	 * @param g
	 * @param isOriginal
	 */
	public abstract void dessiner(Graphics g, boolean isOriginal);
	
	/**
	 * M�thode qui g�re l'affectation de nouvelles coordonn�es.
	 * 
	 * @param emplacement
	 */
	public abstract void setNewPoint(int emplacement);
	
	/**
	 * M�thode replacant les coordon�es � leur �tat initiale.
	 */
	public abstract void setOriginalPoint();
	
	/**
	 * M�thode retournant l'aire de la forme.
	 * 
	 * @return double
	 */
	public abstract double getAire();
	
	/**
	 * M�thode retournant la largeur de la forme.
	 * 
	 * @return int
	 */
	public abstract int getWidth();
	
	/**
	 * M�thode retournant la hauteur de la forme.
	 * 
	 * @return int
	 */
	public abstract int getHeight();
	
	/**
	 * M�thode retournant la distance de la forme.
	 * 
	 * @return double
	 */
	public abstract double getDistance();

	/**
	 * M�thode configurant la forme pr�c�dante dans la liste chain�e.
	 * 
	 * @param previous
	 */
	public void setPrevious(Forme previous)
	{
		this.previous = previous;
	}

	/**
	 * M�thode retournant la forme pr�c�dante dans la liste chain�e.
	 * 
	 * @return previous
	 */
	public Forme getPrevious()
	{
		return previous;
	}

	/**
	 * M�thode configurant la forme suivante dans la liste chain�e.
	 * 
	 * @param next
	 */
	public void setNext(Forme next)
	{
		this.next = next;
	}

	/**
	 * M�thode retournant la forme suivante dans la liste chain�e.
	 * 
	 * @return next
	 */
	public Forme getNext()
	{
		return next;
	}

	/**
	 * M�thode configurant le no de s�quence de la forme.
	 * 
	 * @param nseq
	 */
	public void setNseq(int nseq)
	{
		this.nseq = nseq;
	}

	/**
	 * M�thode retournant le no de s�quence de la forme
	 * 
	 * @return nseq
	 */
	public int getNseq()
	{
		return nseq;
	}
	
	/**
	 * M�thode configurant le no de forme pour garder l'ordre dans lequel le serveur nous l'a envoy�.
	 * 
	 * @param original
	 */
	public void setOriginal(int original)
	{
		this.original = original;
	}
	
	/**
	 * M�thode retournant le no de la forme dans l'ordre original du serveur.
	 * 
	 * @return original
	 */
	public int getOriginal()
	{
		return original;
	}
}