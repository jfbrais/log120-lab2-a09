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
 Nom du fichier :	 Forme.java 					 
 Date créée :        2009-09-29
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
 * Classe abstraite comportant les méthodes de base à redéfinir dans toutes les classes héritant de forme.
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
	 * Méthode qui gère l'affichage des formes.
	 * 
	 * @param g
	 * @param isOriginal
	 */
	public abstract void dessiner(Graphics g, boolean isOriginal);
	
	/**
	 * Méthode qui gère l'affectation de nouvelles coordonnées.
	 * 
	 * @param emplacement
	 */
	public abstract void setNewPoint(int emplacement);
	
	/**
	 * Méthode replacant les coordonées à leur état initiale.
	 */
	public abstract void setOriginalPoint();
	
	/**
	 * Méthode retournant l'aire de la forme.
	 * 
	 * @return double
	 */
	public abstract double getAire();
	
	/**
	 * Méthode retournant la largeur de la forme.
	 * 
	 * @return int
	 */
	public abstract int getWidth();
	
	/**
	 * Méthode retournant la hauteur de la forme.
	 * 
	 * @return int
	 */
	public abstract int getHeight();
	
	/**
	 * Méthode retournant la distance de la forme.
	 * 
	 * @return double
	 */
	public abstract double getDistance();

	/**
	 * Méthode configurant la forme précédante dans la liste chainée.
	 * 
	 * @param previous
	 */
	public void setPrevious(Forme previous)
	{
		this.previous = previous;
	}

	/**
	 * Méthode retournant la forme précédante dans la liste chainée.
	 * 
	 * @return previous
	 */
	public Forme getPrevious()
	{
		return previous;
	}

	/**
	 * Méthode configurant la forme suivante dans la liste chainée.
	 * 
	 * @param next
	 */
	public void setNext(Forme next)
	{
		this.next = next;
	}

	/**
	 * Méthode retournant la forme suivante dans la liste chainée.
	 * 
	 * @return next
	 */
	public Forme getNext()
	{
		return next;
	}

	/**
	 * Méthode configurant le no de séquence de la forme.
	 * 
	 * @param nseq
	 */
	public void setNseq(int nseq)
	{
		this.nseq = nseq;
	}

	/**
	 * Méthode retournant le no de séquence de la forme
	 * 
	 * @return nseq
	 */
	public int getNseq()
	{
		return nseq;
	}
	
	/**
	 * Méthode configurant le no de forme pour garder l'ordre dans lequel le serveur nous l'a envoyé.
	 * 
	 * @param original
	 */
	public void setOriginal(int original)
	{
		this.original = original;
	}
	
	/**
	 * Méthode retournant le no de la forme dans l'ordre original du serveur.
	 * 
	 * @return original
	 */
	public int getOriginal()
	{
		return original;
	}
}