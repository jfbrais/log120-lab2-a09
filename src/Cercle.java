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
 Nom du fichier :	 Cercle.java 					 
 Date cr��e :        2009-09-29
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
	private int centreX, centreY, rayon;

	/**
	 * Constructeur personnalis�
	 * 
	 * @param centreX
	 * @param centreY
	 * @param rayon
	 */
	public Cercle(int centreX, int centreY, int rayon)
	{
		super();
		this.centreX = centreX;
		this.centreY = centreY;
		this.rayon = rayon;

		couleur = Color.pink;
	}

	/**
	 * Red�finition de la m�thode abstraite
	 * 
	 * @see Forme#dessiner(java.awt.Graphics)
	 */
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.fillOval(centreX - rayon, centreY - rayon, 2 * rayon, 2 * rayon);
	}
}
