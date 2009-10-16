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
	private int centreX, centreY, rayonH, rayonV, centreXori, centreYori;

	/**
	 * Constructeur personnalisé
	 * 
	 * @param centreX
	 * @param centreY
	 * @param rayonH
	 * @param rayonV
	 */
	public Ovale(int centreX, int centreY, int rayonH, int rayonV, int ori,
			int nseq)
	{
		super();
		this.centreX = centreX;
		this.centreXori = centreX;
		this.centreY = centreY;
		this.centreYori = centreY;
		this.rayonH = rayonH;
		this.rayonV = rayonV;
		this.setOriginal(ori);
		this.nseq = nseq;

		couleur = Color.blue;
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
			g.fillOval(centreXori - rayonV, centreYori - rayonH, rayonH * 2,
					rayonV * 2);
		else
			g.fillOval(centreX - rayonV, centreY - rayonH, rayonH * 2,
					rayonV * 2);
	}

	public void setNewPoint(int emplacement)
	{
		centreX = emplacement + rayonV;
		centreY = emplacement + rayonH;
	}

	public void setOriginalPoint()
	{
		centreX = centreXori;
		centreY = centreYori;
	}

	public double getAire()
	{
		return Math.PI * rayonV * rayonH;
	}

	public int getWidth()
	{
		return (this.rayonH * 2);
	}

	public int getHeight()
	{
		return (this.rayonV * 2);
	}

	public double getDistance()
	{
	}
}
