

/**
 * 
 * @author BALTACI , LANGARD , MBONGO PASSI
 *
 */
public class Board {
	
	
	HumanPlayer j1;
	HumanPlayer j2;
	GameState g ;
	
	
	/**
	 * 
	 * @param j1 représente le premier joueur
	 * @param j2 représente le deuxieme joueur
	 * @param g représente l'état courrant du plateau de jeu
	 */
	
public Board (HumanPlayer j1,HumanPlayer j2, GameState g){
		
		this.j1 = j1;
		this.j2 = j2;
		this.g= g;
		
	}
}
