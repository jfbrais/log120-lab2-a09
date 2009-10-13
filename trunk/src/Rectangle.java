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
 Nom du fichier :	 Rectangle.java 					 
 Date cr��e :        2009-09-29
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
 2009-09-29 : Status Initial
 *******************************************************/

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Forme
{
	private int x1,y1,x2,y2;
	
	/**
	 * Constructeur personnalis�
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public Rectangle(int x1, int y1, int x2, int y2, int ori)
	{
		super();
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.original = ori;
		
		couleur=Color.green;
	}
	
	/**
	 * Red�finition de la m�thode abstraite
	 * 
	 * @see Forme#dessiner(java.awt.Graphics)
	 */
	public void dessiner(Graphics g)
	{
		g.setColor(couleur);
		g.fillRect(x1, y1, x2-x1, y2-y1);
	}
}