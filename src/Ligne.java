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
 Nom du fichier :	 Ligne.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.awt.Color;
import java.awt.Graphics;

public class Ligne extends Forme
{
	private int x1, y1, x2, y2, x1ori, y1ori, x2ori, y2ori;

	/**
	 * Constructeur personnalisé
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Ligne(int x1, int y1, int x2, int y2, int ori, int nseq)
	{
		super();
		this.x1 = x1;
		this.x1ori = x1;
		this.y1 = y1;
		this.y1ori = y1;
		this.x2 = x2;
		this.x2ori = x2;
		this.y2 = y2;
		this.y2ori = y2;
		this.original = ori;
		this.nseq = nseq;

		couleur = Color.cyan;
	}

	/**
	 * Redéfinition de la méthode abstraite
	 * 
	 * @see Forme#dessiner(java.awt.Graphics)
	 */
	public void dessiner(Graphics g, boolean isOriginal)
	{
		g.setColor(couleur);
		if (isOriginal)
			g.drawLine(x1ori, y1ori, x2ori, y2ori);
		else
			g.drawLine(x1, y1, x2, y2);
	}
	
	public void setNewPoint(int emplacement)
	{
		x2 = x2-(x1-emplacement);
		y2 = y2-(y1-emplacement);
		x1 = emplacement;
		y1 = emplacement;
	}
}
