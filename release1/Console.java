

import java.util.*;

public class Console {
	
	static Scanner in = new Scanner(System.in);
	
	
	/**
	 * 
	 * @return le nombre de ligne choisis par le joueur.
	 * le try catch permet de vérifier que l'utilisateur rentre bien une valeur correct
	 * c'est à dire un chiffre
	 *
	 */
	
	
	public static int getSize() {
	
		
		
		boolean chiffre = false;  
		String str;
		do {
			System.out.println("Avec combien de ligne voulez vous jouez ?");
			str = in.nextLine();
		
		try {
			
			  int test = Integer.parseInt(str);
			    chiffre = true; 
			  } catch(NumberFormatException e) {
			    System.out.println("Cette valeur n'est pas un chiffre, essaie encore !");
			  }
			} while (chiffre != true);
			 	
			int nbLigne = Integer.parseInt(str);
		
			return nbLigne ; 			
	}


	/**
	 * 
	 * @param numeroJoueur : represente le numero du joueur
	 * @return  le nom du joueur sous forme de String 
	 */

	public static String demanderNomJoueur (int numeroJoueur) {
	System.out.println("Quel est le nom du joueur " + numeroJoueur);
	
	 String nomJoueur = in.next();
	 
	 return nomJoueur;
}


	/**
	 *  affiche un message indiquant que le nombre de ligne ne peut pas être inferieur ou egal a 0
	 */
	public static void nbDeLigne0(){
		
		System.out.println(" 0 ou moins n'est pas une valeur vide");
	}

	
	
	
	/**
	 * 	represente le plateau de jeu en forme de pyramide d'allumettes
	 * @param board : on prend en parametre le tableau du gamestate qui represente chaque allumettes sur chaque lignes
	 */
	public static void showBoard(int [] board) {
		
		for (int i = 0 ; i < board.length ; i++) {
			
			System.out.print("["+board[i]+"]" + " ");
		}
		
		System.out.println("");
		System.out.println("------------------------------------------------------------------------------");
			
		
		for (int i = 1 ; i <= board.length;i++)
		{
				for (int j = i ; j < board.length; j++) {
						System.out.print(" ");
				}
				for (int k=0; k <board[i-1] ; k++) {
						System.out.print("|");
				}
				System.out.println();
		}
		
		System.out.println();
	}
	
	
	
	
	public static Move getMove(String name) {
		
		System.out.println( name + " � toi de jouer ! ");
		System.out.println("S�lectionne une ligne non vide de la pyramide et retire de une � trois allumettes de cette ligne.");
		System.out.println("Saisis ton coup sous la forme 'ligne allumettes' ");
		
		int ligne = 0;	
		int nbAllumette = 0;
		
		boolean isEntier;
		do { isEntier = true;	
			  in = new Scanner(System.in);
			  try{
				  ligne = in.nextInt();		      
				  nbAllumette = in.nextInt();
			     } catch (InputMismatchException e) 
			             {
			               System.out.println("La valeur saisie n'est pas un entier");
			               isEntier = false;
			             }  
			} while (isEntier != true );
		
		Move move = new Move(ligne , nbAllumette);
		System.out.println("Vous avez choisis de retirer � la ligne " + move.ligne + " ce nombre d'allumettes => " + move.nbAllumettes);
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
					
			return move;
	
	}
	
	public static void invalidMove(Move move) {
		
		System.out.println("Vous ne pouvez pas faire ce mouvement consistant � retirer � la ligne " + move.ligne + " ce nombre => " + move.nbAllumettes +" d'allumettes.");
		System.out.println();
		System.out.println("Rentrez un nombre d'alumettes compris entre 1 et 3 svp");
		System.out.println("Rentrez une ligne o� il reste des allumettes.");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
		

	}
	
	public static void showWinner (String name) {
		System.out.println(name + " gagne la partie ");
	}
	
	
	public static void messageBienvenue() {
		System.out.println("Bienvenue dans ce jeu de Nim en mode console !");
		System.out.println("Commencez par d�finir les diff�rents param�tres de votre partie");
		System.out.println(" ------------------------------------------------------------------");
		System.out.println();
	}
	
	
	
}

	
	 
		
	
	
	
	
	




