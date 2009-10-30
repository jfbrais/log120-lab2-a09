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
 Nom du fichier :	 Cercle.java 					 
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
 * Classe Cercle pour faire afficher des Cercles dans le programme.
 * 
 * @author Gab
 *
 */
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
		this.setOriginal(ori);
		this.nseq = nseq;

		couleur = Color.magenta;
		couleur = new Color(couleur.getRed(), couleur.getGreen(), couleur
				.getBlue(), 75);
	}

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
	
	public void setOriginalPoint()
	{
		centreX = centreXori;
		centreY = centreYori;
	}
	
	public double getAire()
	{
		return Math.PI*rayon*rayon;
	}
	
	public int getWidth()
	{
		return (rayon*2);
	}
	
	public int getHeight()
	{
		return (rayon*2);
	}
	
	public double getDistance()
	{
		return (rayon*2);
	}
}
