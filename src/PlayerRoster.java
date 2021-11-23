import java.util.Scanner;

public class PlayerRoster {

	public static void main(String[] args) {
		Scanner scnr = new Scanner (System.in); 
		int playerVal [][] = new int [5][2]; 
		int i; 
		char menuInput; 
		boolean activePlayer = true; 
		
		for (i = 0; i < 5; ++i) { 
			System.out.println("Enter player " + (i + 1) + "'s " + "jersey number:"); 
			playerVal [i][0]= scnr.nextInt(); 
			System.out.println("Enter player " + (i + 1) + "'s " + "rating:"); 
			playerVal [i][1] = scnr.nextInt(); 
			System.out.println(); 
	} 
		OutPutRoster(playerVal, 0); // call method to print roster

	while (activePlayer) { // while player is active
		OutPutMenu();
		menuInput = scnr.next().charAt(0); // prompt user to choose menu option
			if (menuInput =='q') {       // if player quits then break
				activePlayer = false; 
				break; 
			}
			else if (menuInput == 'o') {     // output roster if user input is o
				OutPutRoster(playerVal, 0); 
			}
			else if (menuInput == 'u') {      // update the player rating if the user input is u
				System.out.println("Enter a jersey number: "); 
				int newJerseyNum = scnr.nextInt(); 
				System.out.println("Enter a new rating for player: "); 
				int newPlayerRating = scnr.nextInt(); 
				for (int a = 0; a < 5; a++) { //      <-------- nested loop different letter
					if (playerVal [a][0] == newJerseyNum){ 
						playerVal [a][1] = newPlayerRating;  
					}
				}
			}
			else if (menuInput == 'a') { 
				System.out.println("Enter a rating: "); 
				int newRating = scnr.nextInt(); 
				OutPutRosterAbove(playerVal, newRating);                                         //FIXME may have to edit
				
			}
			else if (menuInput == 'r') { 
				System.out.println("Enter a jersey number: "); 
				int jerseyNumber = scnr.nextInt(); 
				boolean boolVal = true;                                                 // FIXME add boolean? 
				for (int a = 0; a < 5; a++) {             //<-------- nested loop different letter
					if (playerVal[a][0] == jerseyNumber) { 
				System.out.println("Enter a new jersey number: "); 
				playerVal [a][0] = scnr.nextInt(); 
				System.out.println("Enter a rating for the new player: "); 
				playerVal [a][1] = scnr.nextInt(); 
				}	
			}
	   }
	}
			return; 
	}
	
	
	//Methods for printing roster and menu listed below
	//method for outputting the roster
	public static void OutPutRoster (int playerVal [][], int minVal) { 
		System.out.println("ROSTER"); 
		for (int i = 0; i < playerVal.length; ++i) {         //FIXME may have to change loop
			if (playerVal [i][1] > minVal) { 
			System.out.println("Player " + (i+1) + " -- Jersey number: " + playerVal[i][0] + ", Rating: " + playerVal[i][1]); 
		}	 
    }
		System.out.println(); 
}
	
	public static void OutPutRosterAbove (int playerVal [][], int minVal) { 
		System.out.println("ABOVE " + minVal); 
		for (int i = 0; i < playerVal.length; ++i) {         //FIXME may have to change loop
			if (playerVal [i][1] > minVal) { 
			System.out.println("Player " + (i+1) + " -- Jersey number: " + playerVal[i][0] + ", Rating: " + playerVal[i][1]); 
		}
    }
		System.out.println(); 
}
	//method for outputting the menu
	public static void OutPutMenu () { 
		System.out.println("MENU"); 
		System.out.println("u - Update player rating");
	    System.out.println("a - Output players above a rating");
	    System.out.println("r - Replace player");
	    System.out.println("o - Output roster");
	    System.out.println("q - Quit\n");
	    System.out.println("Choose an option:");  
	}
}
	
//Ryan Knapp Purpose of Project: Store Roster and Rating Information for a Soccer Team
