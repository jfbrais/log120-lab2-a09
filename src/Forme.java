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
 Nom du fichier :	 Forme.java 					 
 Date cr��e :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.awt.Color;
import java.awt.Graphics;

/* Classe abstraite */
public abstract class Forme
{
	protected int original;
	protected Color couleur;
	private Forme previous,
				  next;
	protected int nseq;

	/**
	 * M�thode abstraite � ref�finir dans les autres classes h�ritant de Forme
	 * @param g
	 * @param isOriginal
	 */
	public abstract void dessiner(Graphics g, boolean isOriginal);
	
	/**
	 * @param emplacement
	 */
	public abstract void setNewPoint(int emplacement);
	
	/**
	 * 
	 */
	public abstract void setOriginalPoint();
	
	/**
	 * @return double
	 */
	public abstract double getAire();
	
	/**
	 * @return int
	 */
	public abstract int getWidth();
	
	/**
	 * @return int
	 */
	public abstract int getHeight();
	
	/**
	 * @return double
	 */
	public abstract double getDistance();

	/**
	 * @param previous
	 */
	public void setPrevious(Forme previous)
	{
		this.previous = previous;
	}

	/**
	 * @return previous
	 */
	public Forme getPrevious()
	{
		return previous;
	}

	/**
	 * @param next
	 */
	public void setNext(Forme next)
	{
		this.next = next;
	}

	/**
	 * @return next
	 */
	public Forme getNext()
	{
		return next;
	}

	/**
	 * @param nseq
	 */
	public void setNseq(int nseq)
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
	 * @param original
	 */
	public void setOriginal(int original)
	{
		this.original = original;
	}
	
	/**
	 * @return original
	 */
	public int getOriginal()
	{
		return original;
	}
}