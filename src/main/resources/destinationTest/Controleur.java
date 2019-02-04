
import Controleur.EcouteurMenu;
import java.lang.String;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Classe permettant la manipulation des écouteurs et les actions associées.
 * @version 2.0 (Hiver 2018)
 */
public class Controleur extends Application {

	/**
	 * Chemin et nom du fichier de livres lu à l'ouverture de l'application.
	 * @see Constant Field Values
	 */
	public static final String FICHIER_LIVRES;

	/**
	 * Chemin et nom du fichier de livres lu lors de la demande de fusion.
	 * @see Constant Field Values
	 */
	public static final String FICHIER_FUSION;

	/**
	 * Un pointeur pour l'interface
	 */
	private Interface vue;

	/**
	 * Un pointeur Stage pour le stage
	 */
	private Stage stage;

	/**
	 * Un tableau (vecteur) de livres. Il sera rempli au début à partir du contenu du fichier livres.dat depuis data
	 */
	private Livre[] tabDeLivres;

	public Controleur() {
		
	}

	/**
	 * Méthode qui instancie l'interface, ajoute les écouteurs sur les sous menu, récupère le fichier de livres et affiche l'interface de départ
	 */
	public void start(Stage pStage) {
		
	}

	/**
	 * Méthode qui permet de récupérer le fichier, le trier par cote et le placer dans la zone de texte
	 */
	private void restaurerFichier() {
		
	}

	/**
	 * Méthode qui permet d'ajouter un écouteur d'évenements à chacun des sous menu de la zone de menus
	 */
	private void ajouterEcouteurs() {
		
	}

	/**
	 * Effectue les opérations nécessaires pour que le tableau de livres soit trié par cote (trierParCote) et réaffiche correctement la liste de livres dans le TextArea.
	 */
	public void gestionTrierCote() {
		
	}

	/**
	 * Effectue les opérations nécessaires pour que le tableau de livres soit trié par titre (trierParTitre) et réaffiche correctement la liste de livres dans le TextArea.
	 */
	public void gestionTrierTitre() {
		
	}

	/**
	 * Effectue les opérations nécessaires pour que le tableau de livres soit trié par nombre de pages (trierParPages) et réaffiche correctement la liste de livres dans le TextArea.
	 */
	public void gestionTrierPages() {
		
	}

	/**
	 * Effectue la gestion de la recherche d'un livre selon une cote. Elle demande la cote. Assurez-vous que la saisie de la cote n’a pas été annulée et que la cote filtrée soit valide (Saisie avec feedback). Effectue ensuite la recherche et affiche le livre trouvé ou un message approprié si cote inexistante.
	 */
	public void gestionRechercheCote() {
		
	}

	/**
	 * Effectue la gestion de la recherche de titres de livres. Elle demande un titre. Assurez-vous que la saisie du titre n’a pas été annulée et que le titre filtré ait au moins un caractère. (Saisie avec feedback). Effectue ensuite la recherche et affiche dans des boîtes de message le ou les livres dont le titre commence par la chaîne saisie ou un message approprié si aucun livre n'existe avec ce titre.
	 */
	public void gestionRechercheTitre() {
		
	}

	/**
	 * Effectue la gestion de la fusion. Elle récupère le contenu du fichier FICHIER_FUSION (Appel de la méthode recupererFichier) et trie par cote le tableau résultant de cette récupération de fichier s'il n'est pas à "null". Elle trie aussi par cote le tableau courant "tabDeLivres" s'il n'est pas à "null" et fusionne ces 2 tableaux triés. Le résultat de la fusion est remis dans le tableau courant "tabDeLivres". Attention, il faut prévoir les cas où un des 2 tableaux (ou les 2) soit null. Après la fusion, elle réaffiche correctement les informations du tableau fusionné dans le TextArea et désactive le sous menu "Fusion".
	 */
	public void gestionFusionSelonCote() {
		
	}

	/**
	 * Effectue les opérations nécessaires pour permettre une sortie conviviale du programme.
	 */
	public void gestionQuitter() {
		
	}

	public static void main(String[] args) {
		
	}

	/**
	 * Classe permettant d'implémenter la méthode pour l'écoute des clics sur les sous menu de la zone de menu
	 */
	private class EcouteurMenu implements EventHandler<ActionEvent> {

		private EcouteurMenu() {
			
		}

		public void handle(ActionEvent e) {
			
		}
	}
}