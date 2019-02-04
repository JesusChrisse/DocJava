
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Classe représentant l'interface principale
 * @version 2.0 (Hiver 2018)
 */
public class Interface {

	/**
	 * Barre de menus
	 */
	private MenuBar mainMenu;

	/**
	 * Menu Trier Livres pour avoir accès aux options de tri des livres
	 */
	private Menu menuTrier;

	/**
	 * Option de menu Trier par cote permettant de trier le tableau de livres par cote
	 */
	protected MenuItem menuItemTrierCote;

	/**
	 * Option de menu Trier par titre permettant de trier le tableau de livres par titre
	 */
	protected MenuItem menuItemTrierTitre;

	/**
	 * Option de menu Trier par nombre de pages permettant de trier le tableau de livres par nombre de pages
	 */
	protected MenuItem menuItemTrierNbPage;

	/**
	 * Menu Recherche de Livres pour avoir accès aux options de recherche des livres
	 */
	private Menu menuRecherche;

	/**
	 * Option de menu Recherche par cote permettant de faire une recherche d'un livre selon sa cote
	 */
	protected MenuItem menuItemRechCote;

	/**
	 * Option de menu Recherche par titre permettant de faire une recherche de tous les livres selon le début du titre.
	 */
	protected MenuItem menuItemRechTitre;

	/**
	 * Menu Fusion pour avoir accès à l'option de fusion des deux tableaux de livres
	 */
	private Menu menuFusion;

	/**
	 * Option de menu Fusion permettant de faire la fusion entre le tableau de livre interne et un tableau de livres provenant de la lecture d'un fichier.
	 */
	protected MenuItem menuItemFusion;

	/**
	 * Menu Quitter pour avoir accès à l'option qui permet de quitter l'application
	 */
	private Menu menuQuitter;

	/**
	 * Option de menu Quitter permettant de quitter l'application
	 */
	protected MenuItem menuItemQuitter;

	/**
	 * Pour la scène
	 */
	protected Scene scene;

	/**
	 * Pour le conteneur racine
	 */
	private BorderPane root;

	/**
	 * Pour la barre de menus
	 */
	private VBox zoneHaut;

	/**
	 * Pour les références des livres affichées à gauche
	 */
	private VBox zoneCentre;

	/**
	 * Zone de texte pour afficher la liste des livres
	 */
	protected TextArea zoneTexte;

	/**
	 * Constructeur pour l'interface graphique. Instancie et initialise l'ensemble des composants pour que l'interface soit prête pour l'affichage.
	 */
	public Interface() {
		
	}

	/**
	 * Méthode qui s'occupe de construire la partie du haut de l'interface, contenant les menus
	 */
	public void creerZoneMenus() {
		
	}

	/**
	 * Méthode qui s'occupe de construire la partie du centre de l'interface, contenant un TextArea pour mettre les informations sur les livres.
	 */
	public void creerZoneCentre() {
		
	}
}