
import java.lang.Comparable;
import java.lang.String;

/**
 * Definition de la classe Livre. Attributs et méthodes pour un livre.
 * @version 2.0 (Hiver 2018)
 */
public class Livre implements Comparable<Livre> {

	/**
	 * La cote par défaut
	 * @see Constant Field Values
	 */
	public static final String COTE_PAR_DEFAUT;

	/**
	 * La longueur d'une cote
	 * @see Constant Field Values
	 */
	public static final int NBR_CAR_COTE;

	/**
	 * Un titre par défaut
	 * @see Constant Field Values
	 */
	public static final String TITRE_PAR_DEFAUT;

	/**
	 * La longueur minimum d'un titre
	 * @see Constant Field Values
	 */
	public static final int LONGUEUR_TITRE_MIN;

	/**
	 * La longueur maximum d'un titre
	 * @see Constant Field Values
	 */
	public static final int LONGUEUR_TITRE_MAX;

	/**
	 * Le nombre de pages par défaut
	 * @see Constant Field Values
	 */
	public static final int PAGES_PAR_DEFAUT;

	/**
	 * Nombre de pages minimum
	 * @see Constant Field Values
	 */
	public static final int PAGES_MIN;

	/**
	 * Prix d'un livre par défaut
	 * @see Constant Field Values
	 */
	public static final float VALEUR_PAR_DEFAUT;

	/**
	 * Prix d'un livre minimum
	 * @see Constant Field Values
	 */
	public static final float VALEUR_MIN;

	/**
	 * La cote d'un livre
	 */
	private String cote;

	/**
	 * Le titre d'un livre
	 */
	private String titre;

	/**
	 * Le nombre de pages d'un livre
	 */
	private int pages;

	/**
	 * Le prix d'un livre
	 */
	private float valeur;

	/**
	 * Constructeur avec paramètres
	 * @param pCote la cote du livre
	 * @param pTitre le titre du livre
	 * @param pPages le nombre de pages du livre
	 * @param pValeur la valeur (prix) du livre
	 */
	public Livre(String pCote, String pTitre, int pPages, float pValeur) {
		
	}

	/**
	 * Obtenir la valeur de la cote
	 * @return String, la cote
	 */
	public String getCote() {
		
	}

	/**
	 * Obtenir le titre du livre
	 * @return String, le titre
	 */
	public String getTitre() {
		
	}

	/**
	 * Obtenir la valeur du nombre de pages du livre
	 * @return int, la valeur du nombre de pages
	 */
	public int getPages() {
		
	}

	/**
	 * Obtenir le prix du livre
	 * @return float, le prix
	 */
	public float getValeur() {
		
	}

	/**
	 * Mettre à jour la cote du livre
	 * @param pCote la valeur de la cote à mettre à jour
	 * @return boolean, vrai si la valeur a été mise à jour
	 */
	public boolean setCote(String pCote) {
		
	}

	/**
	 * Mettre à jour le titre du livre
	 * @param pTitre la valeur du titre à mettre à jour
	 * @return boolean, vrai si la valeur a été mise à jour
	 */
	public boolean setTitre(String pTitre) {
		
	}

	/**
	 * Mettre à jour le nombre de pages du livre
	 * @param pPages la valeur du nombre de pages à mettre à jour
	 * @return boolean, vrai si la valeur a été mise à jour
	 */
	public boolean setPages(int pPages) {
		
	}

	/**
	 * Mettre à jour le prix du livre
	 * @param pValeur la valeur du prix à mettre à jour
	 * @return boolean, vrai si la valeur a été mise à jour
	 */
	public boolean setValeur(float pValeur) {
		
	}

	/**
	 * Valider la cote du livre. La cote doit être obligatoirement du format suivant soit 2 lettres majuscules suivies de 3 chiffres.
	 * @param pCote la cote à valider
	 * @return boolean, vrai si la valeur est valide
	 */
	public static boolean validerCote(String pCote) {
		
	}

	/**
	 * Valider le titre du livre
	 * @param pTitre le titre à valider
	 * @return boolean, vrai si la valeur est valide
	 */
	public static boolean validerTitre(String pTitre) {
		
	}

	/**
	 * Valider le nombre de pages du livre
	 * @param pPages le nombre de pages à valider
	 * @return boolean, vrai si la valeur est valide
	 */
	public static boolean validerPages(int pPages) {
		
	}

	/**
	 * Valider le prix du livre
	 * @param pValeur le prix à valider
	 * @return boolean, vrai si la valeur est valide
	 */
	public static boolean validerValeur(float pValeur) {
		
	}

	/**
	 * Permet de mettre en forme, sans validation, une chaîne de caractères qui représente le titre d'un livre. Enlève les espaces inutiles de début et de fin et met la chaîne en majuscules.
	 * @param pTitre la chaîne à filtrer.
	 * @return String, la chaîne filtrée
	 */
	public static String filtrerTitre(String pTitre) {
		
	}

	/**
	 * Permet de mettre en forme, sans validation, une chaîne de caractères qui représente une cote. Enlève les espaces inutiles de début et de fin, met la chaîne en majuscules et ajuste sa longueur.
	 * @param pCote la chaîne à filtrer.
	 * @return String, la chaîne filtrée
	 */
	public static String filtrerCote(String pCote) {
		
	}

	/**
	 * Permet de comparer deux livres en considérant leur nombre de pages. - Si le livre courant a un nombre de pages plus petit que le livre reçu en entrée, une valeur négative sera retournée. - Si le livre courant a un nombre de pages plus grand que le livre reçu en entrée, une valeur positive sera retournée. - Si le livre courant a un nombre de pages égale au livre reçu en entrée, la valeur 0 sera retournée. Attention: L'adresse de l'objet livre reçu en entrée peut être nulle, dans ce cas, le livre courant est toujours plus grand.
	 * @param pLivre le livre avec lequel il faut comparer le livre courant.
	 * @return int, une valeur négative si inférieur, positive si supérieur et 0 si égale.
	 */
	public int compareTo(Livre pLivre) {
		
	}

	/**
	 * Construire une chaîne longue ou complète avec les informations du livre Exemple: 
	 *  Cote:  BV378     Titre:  LA VIE DEVANT SOI
	 *  Pages: 1640      Valeur: 56.32 $
	 * @return String, la chaîne construite
	 */
	public String enChaineComplete() {
		
	}

	/**
	 * Construire une chaîne courte avec les informations du livre Exemple: 
	 *  BV378  (1640)  LA VIE DEVANT SOI
	 * @return String, la chaîne construite
	 */
	public String enChaineAbregee() {
		
	}

	public static void main(String[] args) {
		
	}
}