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
 Nom du fichier :	 Ovale.java 					 
 Date créée :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.awt.Color;
import java.awt.Graphics;

public class Ovale extends Forme
{
	private int centreX,centreY,rayonH,rayonV;
	
	/**
	 * Constructeur personnalisé
	 * 
	 * @param centreX
	 * @param centreY
	 * @param rayonH
	 * @param rayonV
	 */
	public Ovale(int centreX, int centreY, int rayonH, int rayonV)
	{
		super();
		this.centreX=centreX;
		this.centreY=centreY;
		this.rayonH=rayonH;
		this.rayonV=rayonV;
		
		couleur=Color.blue;
	}
	
	/**
	 * Redéfinition de la méthode abstraite
	 * 
	 * @see Forme#dessiner(java.awt.Graphics)
	 */
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.fillOval(centreX-rayonV, centreY-rayonH, rayonH*2, rayonV*2);
	}
}
