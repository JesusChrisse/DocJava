
import java.io.File;
import java.lang.Object;
import java.lang.String;

/**
 * Classe permettant la manipulation de tableaux de livres, lecture, tri, fusion et recherche.
 * @version 2.0 (Hiver 2018)
 */
public class GestionLivresextends Object {

	public GestionLivres() {
		
	}

	/**
	 * Effectue le tri en ordre croissant d'un tableau, reçu en entrée, en fonction de la cote des livres. Utilise l'algorithme de tri à bulle amélioré. Attention: Vous n'avez pas besoin de vérifier si "pTab" est égale à null, mais le tableau peut être vide (0 objet). IMPORTANT : la classe "String" est "Comparable".
	 * @param pTab le tableau de livres à trier
	 */
	public static void trierParCote(Livre[] pTab) {
		
	}

	/**
	 * Effectue le tri en ordre croissant d'un tableau, reçu en entrée, en fonction du titre des livres. Utilise l'algorithme de tri par insertion. Attention: Vous n'avez pas besoin de vérifier si "pTab" est égale à null, mais le tableau peut être vide (0 objet). IMPORTANT : la classe "String" est "Comparable".
	 * @param pTab le tableau à trier
	 */
	public static void trierParTitre(Livre[] pTab) {
		
	}

	/**
	 * Effectue le tri en ordre croissant d'un tableau, reçu en entrée, en fonction du nombre de pages des livres. Utilise l'algorithme de tri par sélection. Attention: Vous n'avez pas besoin de vérifier si "pTab" est égale à null, mais le tableau peut être vide (0 objet). IMPORTANT : la classe "Livre" est "Comparable".
	 * @param pTab le tableau à trier
	 */
	public static void trierParPages(Livre[] pTab) {
		
	}

	/**
	 * Recherche séquentielle, dans le tableau reçu en entrée (pTab), d'un titre qui commence par la chaîne reçue en entrée (pTitre). Les livres trouvés seront tous ceux pour lesquels le titre commence par la chaîne pTitre. Il peut y avoir plusieurs titres pour lesquels le titre (ou le début du titre) correspond à la chaîne. Cette méthode retourne un tableau des indices des livres trouvés ou null s’il y en a aucun. (Voir algorithme de recherche séquentielle). Attention aux minuscules et majuscules. Attention: Vous n'avez pas besoin de vérifier si "pTab" est égale à null, mais le tableau peut être vide (0 objet). IMPORTANT : la méthode "startsWith()" de la classe "String" pourrait peut-être vous aider.
	 * @param pTitre le début du titre à rechercher
	 * @param pTab le tableau de livres
	 * @return int[], un tableau des indices des livres correspondant ou "null"
	 */
	public static int[] rechercherTitre(String pTitre, Livre[] pTab) {
		
	}

	/**
	 * Recherche dichotomique, dans un tableau de livres trié par cote, reçu en entrée (pTab), d'un livre ayant une cote correspondant de façon identique à celle reçue en entrée (pCote) (Voir algorithme de recherche dichotomique). La cote est unique et un seul livre pourra être trouvé. La méthode retourne l'indice du livre trouvé ou –1 si la cote n'existe pas. Attention aux minuscules et majuscules. Attention: Vous n'avez pas besoin de vérifier si "pTab" est égale à null, mais le tableau peut être vide (0 objet). IMPORTANT : la classe "String" est "Comparable".
	 * @param pCote la cote du livre à rechercher
	 * @param pTab un tableau de livres
	 * @return int, l'indice du livre trouvé ou -1 si pas trouvé
	 */
	public static int rechercherCote(String pCote, Livre[] pTab) {
		
	}

	/**
	 * Effectue la fusion de 2 tableaux de livres triés par cote, reçus en entrée. Elle retourne le nouveau tableau fusionné. (Voir algorithme de fusion). Attention: Vous n'avez pas besoin de vérifier si "pTab1" ou "pTab2" sont égale à null, mais les tableaux peuvent être vides (0 objet). IMPORTANT : la classe "String" est "Comparable".
	 * @param pTab1 un premier tableau de livres
	 * @param pTab2 un deuxième tableau de livres
	 * @return Livre[], un tableau de livres, le résultat de la fusion
	 */
	public static Livre[] fusionnerTableau(Livre[] pTab1, Livre[] pTab2) {
		
	}

	/**
	 * Créer un tableau de livres à partir d'un fichier de données lues.
	 * @param pFichier le chemin et le nom (path) du fichier à récupérer.
	 * @return Livre[], un tableau d'objets "Livres".
	 */
	public static Livre[] recupererFichier(File pFichier) {
		
	}

	/**
	 * Construire une String contenant l'information (cote et titre, i.e. sous forme de chaîne abrégée) sur tous les livres du tableau, un livre par ligne. Elle servira pour l’affichage dans la liste de la fenêtre graphique.
	 * @param pTab le tableau de livres
	 * @return String, la chaîne construite
	 */
	public static String formaterListeLivres(Livre[] pTab) {
		
	}
}