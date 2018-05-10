

import java.util.Scanner;


public class Main {
	
	
	public static void main (String[] args){
		Scanner in = new Scanner (System.in) ;
		
		Console c = new Console();
		
				
		
		
		
						//////////////////////  Initialisation d'un plateau de jeu de d�part ///////////////////////
		Console.messageBienvenue();
		
		int nbLignes  = Console.getSize();
	
		while (nbLignes <= 0 ) {
			
		
			Console.nbDeLigne0();
			 nbLignes  = Console.getSize();
		}
			
		
		String pseudoj1 = Console.demanderNomJoueur(1);
		String pseudoj2 = Console.demanderNomJoueur(2);
		
		Board board = new Board (new HumanPlayer(pseudoj1, false), new HumanPlayer(pseudoj2, false) , new GameState(nbLignes)) ;
		
		
		

		
					////////////////////////////    Affichage du plateau de jeu de d�part /////////////////////////

		
		
		Console.showBoard(board.g.tableauAllumette);
		
		
		
		
						/////////////////////////  Initialisation des Maillons joueurs ///////////////////////////
		
		Maillon<HumanPlayer> premier;
		Maillon<HumanPlayer> deuxieme;
		
		premier = new Maillon<HumanPlayer>(board.j1);
		deuxieme = new Maillon<HumanPlayer>(board.j2);
		
	
		premier.next = deuxieme;
		deuxieme.next = premier;
		
		Maillon<HumanPlayer> current = premier;
		
		
														///////////////// Boucle dans laquelle se d�roule la partie  ///////////////////////
			
		boolean keep_playing;
		do {
				
				
				Move move = Console.getMove(current.info.nom);
				
				
									/////////// Verification si le move est valide ///////////////////////
				
				while ((move.nbAllumettes < 1 || move.nbAllumettes > 3 ) ||  (move.ligne <= 0  || move.ligne > board.g.tableauAllumette.length) || (  board.g.tableauAllumette[move.ligne - 1] - move.nbAllumettes < 0)) {
					
					Console.invalidMove(move);
					Console.showBoard(board.g.tableauAllumette);
							
					 move = Console.getMove(current.info.nom);
			
				}	
				
				board.g.tableauAllumette = board.g.retirerAllumettes(move);
				
				Console.showBoard(board.g.tableauAllumette);
							
				keep_playing = (board.g.nbAllumettesRestante(board.g.tableauAllumette) > 1); 
			
				if (keep_playing)
					current = current.next;
				
				
				
		} while (keep_playing);
		Console.showWinner(current.info.nom);
	}

}
