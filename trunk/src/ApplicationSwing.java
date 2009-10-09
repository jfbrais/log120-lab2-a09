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
 Nom du fichier :	 ApplicationSwing.java
 Date créée :        2002-05-28
 Date dern. modif. : 2009-09-29
 
 *******************************************************
 Historique des modifications
 *******************************************************
  2002-05-28	Cris Fuhrman : Version initiale
  
  2004-03-07	Cris Fuhrman : Intégration de SwingWorker 
                requierant la classe additionnelle 
                SwingWorker.java, utilisation des variables 
                constantes, formatage de code source, 
                organisation des imports, etc.

  2005-05-01	Cris Fuhrman : Intégration de ApplicationSupport
  				requierant la classe additionnelle
  				ApplicationSupport.java et les fichiers
  				prefs.properties, app_xx.properties (où xx est le
  				code de la langue, p. ex. fr = français, en = anglais).
  				Suppression de l'interface Shape.
  				
  2006-05-03	Sébastien Adam :
  
                Uniformisation et maintenance du code.

                Ajout des classes pour la gestion des
                items de menu. Un écouteur ajouté pour chaque item 
                (DemarrerListener, ArreterListener, QuitterListener, 
                AProposDeListener).  
                
                La classe ApplicationSwing n'implémente plus ActionListener. 
                Elle délègue la gestion des items.
                
                Plus besion d'un "if else if" dans la methode actionPerformed pour 
                exécuter l'action associée à un item. Le code est plus
                simple à comprendre, lire et maintenir.	
                
  2009-09-29	Gabriel Desmarais :
  				Ajout des fonctionnalitées réseau et respect des spécifications du Laboratoire 1.
  				
  2009-10-03	Gabriel Desmarais :
  				Ajustement des classes pour respecter l'idée générale du projet.

 La distribution originale se trouve à 
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

	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;

	private static final int MENU_CONNECTION_CONNECTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_CONNECTION_CONNECTER_TOUCHE_RACC = KeyEvent.VK_C;

	private static final int MENU_CONNECTION_DECONNECTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_CONNECTION_DECONNECTER_TOUCHE_RACC = KeyEvent.VK_V;

	private static final String MENU_FICHIER_TITRE = "app.frame.menus.file.title",
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

	private boolean workerActif, connected;

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

	/**
	 * Traiter l'item "Stop".
	 * 
	 * @author Gab
	 *
	 */
	class ArreterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			workerActif = false;
			rafraichirMenus();
		}
	}

	/**
	 * Traiter l'item "Start".
	 * 
	 * @author Gab
	 *
	 */
	class DemarrerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			final SwingWorker worker = new SwingWorker()
			{
				public Object construct()
				{
					dessinerFormes();
					workerActif = false;
					rafraichirMenus();
					return new Integer(0);
				}
			};
			worker.start();
			workerActif = true;
			rafraichirMenus();
		}

		/**
		 * Boucle qui récupère les formes et les affiches.
		 */
		protected void dessinerFormes()
		{
			while (workerActif && connected)
			{
				String cmd = maConnection.getForme();
				if (cmd != null)
				{
					/*Crée un paquet d'information avec la chaine,
					 *Crée une Forme avec le paquet d'information,
					 *Ajoute la forme au stocker de forme*/
					monStocker.stocker(new CreateurForme().creerForme(new DecoupeChaine().decouper(cmd)));
					
					repaint();
				}
				else
				{
					connected = maConnection.seDeconnecter();
				}
				
				try
				{
					Thread.sleep(DELAI_ENTRE_FORMES_MSEC);
				}
				catch (InterruptedException e)
				{
					JOptionPane
							.showMessageDialog(null, "GET delay interrupted");
				}
			}
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
			if (workerActif)
			{
				workerActif = false;
			}

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
	 * Créer le panneau sur lequel les formes sont dessinées.
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
				if (monStocker.getTableau(i) != null)
				{
					monStocker.getTableau(i).dessiner(g);
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
			rafraichirMenus();
		}
	}

	/**
	 * Traiter l'item "Deconnect".
	 * 
	 * @author Gab
	 *
	 */
	class DeconnecterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			if (workerActif)
			{
				workerActif = false;
			}

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
			rafraichirMenus();
		}
	}

	/**
	 *  Constructeur - Créer le cadre dans lequel les formes sont dessinées.
	 */
	public ApplicationSwing()
	{
		getContentPane().add(new JScrollPane(new CustomCanvas()));
		/* Gère l'envoie du END lors du clic dans le X de l'application */
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent closing)
			{
				if (workerActif)
				{
					workerActif = false;
				}

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

	/* Créer le menu "Connect". */
	private JMenu creerMenuConnection()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_CONNECTION_TITRE,
				new String[]
				{ MENU_CONNECTION_CONNECTER, MENU_CONNECTION_DECONNECTER });

		connectionMenuItem = menu.getItem(0);
		connectionMenuItem.addActionListener(new ConnecterListener());
		connectionMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_CONNECTION_CONNECTER_TOUCHE_RACC,
				MENU_CONNECTION_CONNECTER_TOUCHE_MASK));

		deconnectionMenuItem = menu.getItem(1);
		deconnectionMenuItem.addActionListener(new DeconnecterListener());
		deconnectionMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_CONNECTION_DECONNECTER_TOUCHE_RACC,
				MENU_CONNECTION_DECONNECTER_TOUCHE_MASK));

		return menu;
	}

	/* Créer le menu "Draw". */
	private JMenu creerMenuDessiner()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_DESSIN_TITRE,
				new String[]
				{ MENU_DESSIN_DEMARRER, MENU_DESSIN_ARRETER });

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new DemarrerListener());
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_DEMARRER_TOUCHE_RACC,
				MENU_DESSIN_DEMARRER_TOUCHE_MASK));

		arreterMenuItem = menu.getItem(1);
		arreterMenuItem.addActionListener(new ArreterListener());
		arreterMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				MENU_DESSIN_ARRETER_TOUCHE_RACC,
				MENU_DESSIN_ARRETER_TOUCHE_MASK));

		return menu;
	}

	/* Créer le menu "File". */
	private JMenu creerMenuFichier()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_FICHIER_TITRE,
				new String[]
				{ MENU_FICHIER_QUITTER });

		menu.getItem(0).addActionListener(new QuitterListener());
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(MENU_FICHIER_QUITTER_TOUCHE_RACC,
						MENU_FICHIER_QUITTER_TOUCHE_MASK));

		return menu;
	}

	/* Créer le menu "Help". */
	private JMenu creerMenuAide()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_AIDE_TITRE,
				new String[]
				{ MENU_AIDE_PROPOS });

		menu.getItem(0).addActionListener(new AProposDeListener());

		return menu;
	}

	/* Activer ou désactiver les items du menu selon la sélection. */
	private void rafraichirMenus()
	{
		demarrerMenuItem.setEnabled(!workerActif && connected);
		arreterMenuItem.setEnabled(workerActif);
		connectionMenuItem.setEnabled(!connected);
		deconnectionMenuItem.setEnabled(connected);
	}

	/* Lancer l'exécution de l'application. */
	public static void main(String[] args)
	{

		/* Créer la fenêtre de l'application. */
		ApplicationSwing cadre = new ApplicationSwing();

		cadre.creerMenuFichier();
		cadre.creerMenuConnection();
		cadre.creerMenuDessiner();
		cadre.creerMenuAide();
		cadre.rafraichirMenus();

		/* Centrer la fenêtre. */
		cadre.setLocationRelativeTo(null);

		/* Lancer l'application. */
		ApplicationSupport.launch(cadre, ApplicationSupport
				.getResource("app.frame.title"), 0, 0, CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
}