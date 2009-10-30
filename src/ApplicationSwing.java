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
 Nom du fichier :	 ApplicationSwing.java
 Date créée :        2002-05-28
 Date dern. modif. : 2009-10-29
 
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
  
  2009-10-29	Gabriel Desmarais :
  				Modifications pour les exigences du TP2.

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
 * Classe centrale du programme utilisée pour faire toutes les opérations.
 * 
 * @author Gab
 * @version 1.3
 */
public class ApplicationSwing extends JFrame
{

	private static final int CANEVAS_HAUTEUR = 500;

	private static final int CANEVAS_LARGEUR = 500;

	private static final int DELAI_QUITTER_MSEC = 200;

	private static final int DELAI_DECONNECTER_MSEC = 200;

	private static final int MARGE_H = 50;

	private static final int MARGE_V = 60;

	private static final int MENU_FICHIER_OBTENIR_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_FICHIER_OBTENIR_TOUCHE_RACC = KeyEvent.VK_X;

	private static final int MENU_FICHIER_QUITTER_TOUCHE_MASK = ActionEvent.CTRL_MASK;

	private static final char MENU_FICHIER_QUITTER_TOUCHE_RACC = KeyEvent.VK_Q;

	private static final String MENU_FICHIER_TITRE = "app.frame.menus.file.title",
			MENU_FICHIER_OBTENIR = "app.frame.menus.file.get",
			MENU_FICHIER_QUITTER = "app.frame.menus.file.exit",
			MENU_TRIER_TITRE = "app.frame.menus.sort.title",
			MENU_TRIER_SEQUP = "app.frame.menus.sort.seqUp",
			MENU_TRIER_SEQDOWN = "app.frame.menus.sort.seqDown",
			MENU_TRIER_SURFUP = "app.frame.menus.sort.surfUp",
			MENU_TRIER_SURFDOWN = "app.frame.menus.sort.surfDown",
			MENU_TRIER_TYPEUP = "app.frame.menus.sort.typeUp",
			MENU_TRIER_TYPEDOWN = "app.frame.menus.sort.typeDown",
			MENU_TRIER_WIDTHUP = "app.frame.menus.sort.widthUp",
			MENU_TRIER_WIDTHDOWN = "app.frame.menus.sort.widthDown",
			MENU_TRIER_HEIGHTUP = "app.frame.menus.sort.heightUp",
			MENU_TRIER_HEIGHTDOWN = "app.frame.menus.sort.heightDown",
			MENU_TRIER_DIST = "app.frame.menus.sort.distance",
			MENU_TRIER_ORI = "app.frame.menus.sort.original",
			MENU_AIDE_TITRE = "app.frame.menus.help.title",
			MENU_AIDE_PROPOS = "app.frame.menus.help.about";

	private static final String MESSAGE_DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	private JMenuItem sortOriginalMenuItem;
	
	private JMenu sortMenu;

	private static final long serialVersionUID = 1L;

	private boolean connected;

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
	 * Traiter l'item "Get...".
	 *  
	 * @author Gab
	 *
	 */
	class GetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			connected = maConnection.seConnecter();

			if (connected)
			{
				sortMenu.setEnabled(true);
				
				for (int i = 0; i < 10; i++)
					dessinerFormes(i);

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
	 * Menu du tri par no de séquence
	 * 
	 * @author Gab
	 *
	 */
	class SeqUpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurNSeqUp());
			repaint();
		}
	}

	/**
	 * Menu du tri par no de séquence
	 * 
	 * @author Gab
	 *
	 */
	class SeqDownListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurNSeqDown());
			repaint();
		}
	}

	/**
	 * Menu du tri par surface
	 * 
	 * @author Gab
	 *
	 */
	class SurfUpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurSurfUp());
			repaint();
		}
	}

	/**
	 * Menu du tri par surface
	 * 
	 * @author Gab
	 *
	 */
	class SurfDownListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurSurfDown());
			repaint();
		}
	}

	/**
	 * Menu du tri par type
	 * 
	 * @author Gab
	 *
	 */
	class TypeUpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurTypeUp());
			repaint();
		}
	}

	/**
	 * Menu du tri par type
	 * 
	 * @author Gab
	 *
	 */
	class TypeDownListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurTypeDown());
			repaint();
		}
	}

	/**
	 * Menu du tri par largeur
	 * 
	 * @author Gab
	 *
	 */
	class WidthUpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurLargeurUp());
			repaint();
		}
	}

	/**
	 * Menu du tri par largeur
	 * 
	 * @author Gab
	 *
	 */
	class WidthDownListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurLargeurDown());
			repaint();
		}
	}

	/**
	 * Menu du tri par hauteur
	 * 
	 * @author Gab
	 *
	 */
	class HeightUpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurHauteurUp());
			repaint();
		}
	}

	/**
	 * Menu du tri par hauteur
	 * 
	 * @author Gab
	 *
	 */
	class HeightDownListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurHauteurDown());
			repaint();
		}
	}

	/**
	 * Menu du tri par distance
	 * 
	 * @author Gab
	 *
	 */
	class DistanceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurDistance());
			repaint();
		}
	}

	/**
	 * Menu du tri original
	 * 
	 * @author Gab
	 *
	 */
	class OriginalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			monStocker.sort(new ComparateurOriginal());
			monStocker.setOriginalEmplacement();
			repaint();
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
				if (monStocker.getForme(i) != null)
				{
					monStocker.getForme(i).dessiner(g,
							sortOriginalMenuItem.isSelected());
				}
			}
		}
	}

	/**
	 * Constructeur - Créer le cadre dans lequel les formes sont dessinées.
	 */
	public ApplicationSwing()
	{
		getContentPane().add(new JScrollPane(new CustomCanvas()));
		/* Gère l'envoie du END lors du clic dans le X de l'application */
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

	/**
	 * Créer le menu "File". 
	 * 
	 * @return menu
	 */
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

	/**
	 * Créer le menu "Sort".
	 * 
	 * @return menu
	 */
	private JMenu creerMenuSort()
	{
		JMenu menu = ApplicationSupport
				.addRadioButton(this, MENU_TRIER_TITRE,
						new String[]
						{ MENU_TRIER_SEQUP, MENU_TRIER_SEQDOWN,
								MENU_TRIER_SURFUP, MENU_TRIER_SURFDOWN,
								MENU_TRIER_TYPEUP, MENU_TRIER_TYPEDOWN,
								MENU_TRIER_WIDTHUP, MENU_TRIER_WIDTHDOWN,
								MENU_TRIER_HEIGHTUP, MENU_TRIER_HEIGHTDOWN,
								MENU_TRIER_DIST, MENU_TRIER_ORI });

		menu.getItem(0).addActionListener(new SeqUpListener());
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		menu.getItem(1).addActionListener(new SeqDownListener());
		menu.getItem(1).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		menu.getItem(3).addActionListener(new SurfUpListener());
		menu.getItem(3).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		menu.getItem(4).addActionListener(new SurfDownListener());
		menu.getItem(4).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
		menu.getItem(6).addActionListener(new TypeUpListener());
		menu.getItem(6).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.CTRL_MASK));
		menu.getItem(7).addActionListener(new TypeDownListener());
		menu.getItem(7).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.CTRL_MASK));
		menu.getItem(9).addActionListener(new WidthUpListener());
		menu.getItem(9).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.CTRL_MASK));
		menu.getItem(10).addActionListener(new WidthDownListener());
		menu.getItem(10).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_8, ActionEvent.CTRL_MASK));
		menu.getItem(12).addActionListener(new HeightUpListener());
		menu.getItem(12).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.CTRL_MASK));
		menu.getItem(13).addActionListener(new HeightDownListener());
		menu.getItem(13).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.CTRL_MASK));
		menu.getItem(15).addActionListener(new DistanceListener());
		menu.getItem(15).setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
		sortOriginalMenuItem = menu.getItem(16);
		sortOriginalMenuItem.addActionListener(new OriginalListener());
		sortOriginalMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK));

		menu.setEnabled(false);
		
		sortMenu = menu;
		
		return menu;
	}

	/**
	 * Créer le menu "Help".
	 * 
	 * @return menu
	 */
	private JMenu creerMenuAide()
	{
		JMenu menu = ApplicationSupport.addMenu(this, MENU_AIDE_TITRE,
				new String[]
				{ MENU_AIDE_PROPOS });

		menu.getItem(0).addActionListener(new AProposDeListener());

		return menu;
	}

	/**
	 * Dessine les formes reçues.
	 * 
	 * @param original
	 */
	private void dessinerFormes(int original)
	{
		String cmd = maConnection.getForme();
		if (cmd != null)
		{
			/*
			 * Crée un paquet d'information avec la chaine,Crée une Forme avec
			 * le paquet d'information,Ajoute la forme au stocker de forme
			 */
			monStocker.add(new CreateurForme().creerForme(new DecoupeChaine()
					.decouper(cmd), original));

			repaint();
		}
		else
		{
			connected = maConnection.seDeconnecter();
		}
	}

	/**
	 * Lancer l'exécution de l'application.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		/* Créer la fenêtre de l'application. */
		ApplicationSwing cadre = new ApplicationSwing();

		cadre.creerMenuFichier();
		cadre.creerMenuSort();
		cadre.creerMenuAide();
		// cadre.rafraichirMenus();

		/* Centrer la fenêtre. */
		cadre.setLocationRelativeTo(null);

		/* Lancer l'application. */
		ApplicationSupport.launch(cadre, ApplicationSupport
				.getResource("app.frame.title"), 0, 0, CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
}