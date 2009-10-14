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
 Nom du fichier :	 Cercle.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.awt.Color;
import java.awt.Graphics;

public class Cercle extends Forme
{
	private int centreX, centreY, rayon, centreXori, centreYori;

	/**
	 * Constructeur personnalisé
	 * 
	 * @param centreX
	 * @param centreY
	 * @param rayon
	 */
	public Cercle(int centreX, int centreY, int rayon, int ori, int nseq)
	{
		super();
		this.centreX = centreX;
		this.centreXori = centreX;
		this.centreY = centreY;
		this.centreYori = centreY;
		this.rayon = rayon;
		this.original = ori;
		this.nseq = nseq;

		couleur = Color.pink;
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
			g.fillOval(centreXori - rayon, centreYori - rayon, 2 * rayon,
					2 * rayon);
		else
			g.fillOval(centreX - rayon, centreY - rayon, 2 * rayon, 2 * rayon);
	}
	
	public void setNewPoint(int emplacement)
	{
		centreX = emplacement + rayon;
		centreY = emplacement + rayon;
	}
}
