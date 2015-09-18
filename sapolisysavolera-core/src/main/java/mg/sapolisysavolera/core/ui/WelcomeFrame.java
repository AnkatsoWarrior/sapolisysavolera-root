package mg.sapolisysavolera.core.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
 * Mg : Ity rakitra ity dia ampahany amin'ny tetikasa saPolisySaVolera
 * Fr : Ce fichier fait partie du projet saPolisySaVolera
 * En : This file is part of saPolisySaVolera project
 * <br>
 * Modif. : 18 sept. 2015
 * Creat. : 18 sept. 2015
 *
 * @author nabil.arrowbase at gmail
 * @since r-1.0
 * @version r-1.0
 */
public final class WelcomeFrame extends JFrame {

	// Titre de l'ecran d'acceuil
	private static final String WELCOME_FRAME_TITLE = "Bienvenue dans SaPolisySaVolera !";

	// Dimension de l'ecran d'acceuil
	private static final Dimension WELCOME_FRAME_DIMENSION = new Dimension(
			1000, 500);

	private JPanel container;

	/**
	 * Constructeur
	 * 
	 * @throws HeadlessException
	 */
	public WelcomeFrame() throws HeadlessException {
		super();
		setSize(WELCOME_FRAME_DIMENSION);
		setTitle(WELCOME_FRAME_TITLE);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(buildContentPane());
	}

	/**
	 * creation du contenu du panneau de l'ecran d'acceuil
	 * 
	 * @return le panneau cree
	 */
	private Component buildContentPane() {
		container = new JPanel();

		container.setLayout(null);

		return container;
	}

	private static final long serialVersionUID = -2321320150336193161L;

}
