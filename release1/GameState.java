

/**
 * 
 * @author BALTACI , LANGARD , MBONGO PASSI
 *
 */

public class GameState {
	
	
int[] tableauAllumette;
int nbLignesPyramide ;

	
	/**
	 * GameState represente l'état courrant du plateau de jeu
	 * @param nbLignes : represente le nombre de ligne 
	 */
	
	public GameState(int nbLignes) {
		
		this.tableauAllumette = new int [nbLignes];
		
		
		for (int i = 0 ; i<tableauAllumette.length ; i++ ) {
			tableauAllumette[i] = (2 * i + 1);
			
		}
	}
	
	
	public int nbAllumettesRestante(int tableau[]) {
		int sommeTableau = 0;
		for (int i = 0 ; i < tableau.length ; i++) {
			 sommeTableau = tableau[i] + sommeTableau;
		}
		return sommeTableau;
	}
	
	
	
	public int nbLignesNonVide (int tableau[]) {
		
		int lignesNonVide = 0;
		
		for (int i = 0 ; i < tableau.length ; i++) {
			if (tableau[i] != 0)
				lignesNonVide++;
		}
		return lignesNonVide;
	
				
	}
	
	public int [] retirerAllumettes(Move move) {
		
		this.tableauAllumette[move.ligne-1] = this.tableauAllumette[move.ligne-1] - move.nbAllumettes;        // - 1 pour l'index du tableau
		return this.tableauAllumette;
	}
	

}
