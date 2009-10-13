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
 Nom du fichier :	 ApplicationSwing.java
 Date cr��e :        2002-05-28
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
  2002-05-28	Cris Fuhrman : Version initiale
  
  2004-03-07	Cris Fuhrman : Int�gration de SwingWorker 
                requierant la classe additionnelle 
                SwingWorker.java, utilisation des variables 
                constantes, formatage de code source, 
                organisation des imports, etc.

  2005-05-01	Cris Fuhrman : Int�gration de ApplicationSupport
  				requierant la classe additionnelle
  				ApplicationSupport.java et les fichiers
  				prefs.properties, app_xx.properties (o� xx est le
  				code de la langue, p. ex. fr = fran�ais, en = anglais).
  				Suppression de l'interface Shape.
  				
  2006-05-03	S�bastien Adam :
  
                Uniformisation et maintenance du code.

                Ajout des classes pour la gestion des
                items de menu. Un �couteur ajout� pour chaque item 
                (DemarrerListener, ArreterListener, QuitterListener, 
                AProposDeListener).  
                
                La classe ApplicationSwing n'impl�mente plus ActionListener. 
                Elle d�l�gue la gestion des items.
                
                Plus besion d'un "if else if" dans la methode actionPerformed pour 
                ex�cuter l'action associ�e � un item. Le code est plus
                simple � comprendre, lire et maintenir.	
                
  2009-09-29	Gabriel Desmarais :
  				Ajout des fonctionnalit�es r�seau et respect des sp�cifications du Laboratoire 1.
  				
  2009-10-03	Gabriel Desmarais :
  				Ajustement des classes pour respecter l'id�e g�n�rale du projet.

 La distribution originale se trouve � 
 https://cours.ele.etsmtl.ca/academique/log120/notesdecours/exemples/lab/lab1/ApplicationSwing.zip
 ********************************************************/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

/*
 * <code>ApplicationSwing</code> est un exemple d'une application en Java qui
 * fournit une interface Swing, avec un simple menu et un dessin.
 * 
 * <h4>References</h4>
 * <ul>
 * 
 * <li>C. Fuhrman, &quot;Notes de cours de LOG120,&quot; &Eacute;cole de
 * technologie sup&eacute;rieure, Montr&eacute;al, Qu&eacute;bec, Canada, 2002
 * 
 * <li>Xemacs (for generation of the initial template), <a target="_top"
 * href="http://www.xemacs.org">www.xemacs.org</a>, 2002
 * 
 * <li><a target="_top" href=
 * "http://java.sun.com/docs/books/tutorial/uiswing/painting/overview.html"
 * >Overview of Custom Painting</a>, une partie du tutoriel Java de Sun, 2002.
 * 
 * <li>Java Software, <a target="_top"
 * href="http://java.sun.com/j2se/javadoc/writingdoccomments/index.html"
 * >&quot;How to Write Doc Comments for the Javadoc<sup>TM</sup> Tool,&quot;</a>
 * 2002
 * 
 * </ul>
 * 
 * Distribution originale &agrave; partir du <a target="_top"
 * href="https://cours.ele.etsmtl.ca/academique/log120/">site Web</a> du cours
 * LOG120.
 * 
 * Created: Tue May 28 11:31:18 2002
 * 
 * @author <a href="mailto:christopher.fuhrman@etsmtl.ca">Christopher
 *         Fuhrman</a>
 * 
 * @version 1.1
 */

/**
 * @author Gab
 * @version 1.3
 */
public class ApplicationSwing extends JFrame
{

	private static final int CANEVAS_HAUTEUR = 500;

	private static final int CANEVAS_LARGEUR = 500;

	private static final int DELAI_ENTRE_FORMES_MSEC = 500;

	private static final int DELAI_QUITTER_MSEC = 200;

	private static final int DELAI_DECONNECTER_MSEC = 200;

	private static final int MARGE_H = 50;

	private static final int MARGE_V = 60;

	private static final int MENU_DESSIN_ARRETER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_DESSIN_ARRETER_TOUCHE_RACC = KeyEvent.VK_A;

	private static final int MENU_DESSIN_DEMARRER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_DESSIN_DEMARRER_TOUCHE_RACC = KeyEvent.VK_D;
	
	private static final int MENU_FICHIER_OBTENIR_TOUCHE_MASK = ActionEvent.CTRL_MASK;
	
	private static final char MENU_FICHIER_OBTENIR_TOUCHE_RACC = KeyEvent.VK_X;

	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;

	private static final int MENU_CONNECTION_CONNECTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_CONNECTION_CONNECTER_TOUCHE_RACC = KeyEvent.VK_C;

	private static final int MENU_CONNECTION_DECONNECTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_CONNECTION_DECONNECTER_TOUCHE_RACC = KeyEvent.VK_V;

	private static final String MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_OBTENIR = "app.frame.menus.file.get",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_CONNECTION_TITRE = "app.frame.menus.connection.title",
			MENU_CONNECTION_CONNECTER = "app.frame.menus.connection.connect",
			MENU_CONNECTION_DECONNECTER = "app.frame.menus.connection.disconnect",
			MENU_DESSIN_TITRE = "app.frame.menus.draw.title",
			MENU_DESSIN_DEMARRER = "app.frame.menus.draw.start",
			MENU_DESSIN_ARRETER = "app.frame.menus.draw.stop",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";

	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	private static final long serialVersionUID = 1L;

	private boolean connected;

	private JMenuItem arreterMenuItem, demarrerMenuItem, connectionMenuItem,
			deconnectionMenuItem;

	private Connection maConnection = new Connection();

	private FormeStocker monStocker = new FormeStocker();
	
	/**
	 * Traiter l'item "About...".
	 * 
	 * @author Gab
	 *
	 */
	class AProposDeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			JOptionPane.showMessageDialog(null, ApplicationSupport
					.getResource(MESSAGE_DIALOGUE_A_PROPOS), ApplicationSupport
					.getResource(MENU_AIDE_PROPOS),
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	class GetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			connected = maConnection.seConnecter();
			
			for (int i=0;i<10;i++)
				dessinerFormes();
			
			try
			{
				Thread.sleep(DELAI_DECONNECTER_MSEC);
			}
			catch (InterruptedException e)
			{
				JOptionPane.showMessageDialog(null,
						"Close connection delay interrupted");
			}

			connected = maConnection.seDeconnecter();
		}
	}

	/**
	 * Traiter l'item "Exit".
	 * 
	 * @author Gab
	 *
	 */
	class QuitterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if (connected)
			{
				try
				{
					Thread.sleep(DELAI_QUITTER_MSEC);
				}
				catch (InterruptedException e)
				{
					JOptionPane.showMessageDialog(null,
							"Quit delay interrupted");
				}
				maConnection.seDeconnecter();
			}

			System.exit(0);
		}
	}

	/**
	 * Cr�er le panneau sur lequel les formes sont dessin�es.
	 * 
	 * @author Gab
	 *
	 */
	class CustomCanvas extends JPanel
	{
		private static final long serialVersionUID = 1L;

		public CustomCanvas()
		{
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			CustomCanvas.this.setBackground(Color.white);
		}

		public Dimension getPreferredSize()
		{
			return new Dimension(CANEVAS_LARGEUR, CANEVAS_HAUTEUR);
		}

		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			for (int i = 0; i < 10; i++)
			{
				if (monStocker.getForme(i) != null)
				{
					monStocker.getForme(i).dessiner(g);
				}
			}
		}
	}

	/**
	 * Traiter l'item "Connect".
	 * 
	 * @author Gab
	 *
	 */
	class ConnecterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			connected = maConnection.seConnecter();
			//rafraichirMenus();
		}
	}

	/**
	 *  Constructeur - Cr�er le cadre dans lequel les formes sont dessin�es.
	 */
	public ApplicationSwing()
	{
		getContentPane().add(new JScrollPane(new CustomCanvas()));
		/* G�re l'envoie du END lors du clic dans le X de l'application */
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent closing)
			{
				if (connected)
				{
					try
					{
						Thread.sleep(DELAI_QUITTER_MSEC);
					}
					catch (InterruptedException e)
					{
						JOptionPane.showMessageDialog(null,
								"Quit delay interrupted");
					}
					connected = maConnection.seDeconnecter();
				}
			}
		});
	}

	/* Cr�er le menu "File". */
	private JMenu creerMenuFichier()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_FICHIER_TITRE,
				new String[]
				{ MENU_FICHIER_OBTENIR, MENU_FICHIER_QUITTER });

		menu.getItem(0).addActionListener(new GetListener());
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_OBTENIR_TOUCHE_RACC,
						MENU_FICHIER_OBTENIR_TOUCHE_MASK));
		
		menu.getItem(1).addActionListener(new QuitterListener());
		menu.getItem(1).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));

		return menu;
	}
	
	/* Cr�er le menu "Sort". */
	private JMenu creerMenuSort()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_AIDE_TITRE,
				new String[]
				{ MENU_AIDE_PROPOS });

		menu.getItem(0).addActionListener(new AProposDeListener());

		return menu;
	}

	/* Cr�er le menu "Help". */
	private JMenu creerMenuAide()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_AIDE_TITRE,
				new String[]
				{ MENU_AIDE_PROPOS });

		menu.getItem(0).addActionListener(new AProposDeListener());

		return menu;
	}
	
	private void dessinerFormes()
	{
		String cmd = maConnection.getForme();
		if (cmd != null)
		{
			/*Cr�e un paquet d'information avec la chaine,
			 *Cr�e une Forme avec le paquet d'information,
			 *Ajoute la forme au stocker de forme*/
			monStocker.add(new CreateurForme().creerForme(new DecoupeChaine().decouper(cmd)));
			
			repaint();
		}
		else
		{
			connected = maConnection.seDeconnecter();
		}
	}

	/* Lancer l'ex�cution de l'application. */
	public static void main(String[] args)
	{

		/* Cr�er la fen�tre de l'application. */
		ApplicationSwing cadre = new ApplicationSwing();

		cadre.creerMenuFichier();
		cadre.creerMenuSort();
		cadre.creerMenuAide();
		//cadre.rafraichirMenus();

		/* Centrer la fen�tre. */
		cadre.setLocationRelativeTo(null);

		/* Lancer l'application. */
		ApplicationSupport.launch(cadre, ApplicationSupport
				.getResource("app.frame.title"), 0, 0, CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
}