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
 Nom du fichier :	 Forme.java 					 
 Date créée :        2009-09-29
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
	 * Méthode abstraite à reféfinir dans les autres classes héritant de Forme
	 * 
	 * @param g
	 */
	public abstract void dessiner(Graphics g, boolean isOriginal);
	public abstract void setNewPoint(int emplacement);
	public abstract void setOriginalPoint();
	public abstract double getAire();

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

	public void setNseq(int nseq)
	{
		this.nseq = nseq;
	}

	public int getNseq()
	{
		return nseq;
	}
	public void setOriginal(int original)
	{
		this.original = original;
	}
	public int getOriginal()
	{
		return original;
	}
}