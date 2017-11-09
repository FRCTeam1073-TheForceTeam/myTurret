package theVs;
import java.util.Scanner;
//Author: Tristan Hoenninger
//Date last modified: 11/8/17
//Battle.java
//This program simulates a battle between you and an opponent.
public class Battle {
	public int OpponentBlasterHealth = 15;
	public int OwnBlasterHealth = 15;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int OwnHealth = 64;
		final int OpponentHealth = 64; 
		int OpponentTotalDamageTaken = 0;
		int OwnTotalDamageTaken =0;
		int damage = 0;
		String WhichPart;
		Scanner scan = new Scanner(System.in);
		System.out.println("You are now in a duel with an opponent.");
		System.out.println("Let's test your luck.");
		while (OwnTotalDamageTaken <= OwnHealth && OpponentTotalDamageTaken <= OpponentHealth){
			System.out.print("Where do you fire at? (Legs, Head, Arms, Chest, Blaster)");
			WhichPart = scan.nextLine();
			if (WhichPart.equals("Legs")){
			
			}
			if (WhichPart.equals("Head")) {
				
			}
			if (WhichPart.equals("Arms")) {
				
			}
			if (WhichPart.equals("Chest")) {
				
			}
			if (WhichPart.equals("Blaster")) {
				
			}
			System.out.println("You take aim at "+ WhichPart +".");
			if( damage == 0) {
				System.out.println("You fired but missed.");
			}
			else {
				
			}
		}
		if (OwnTotalDamageTaken >= OwnHealth){
			System.out.println("Sorry Bud, but you were just unlucky.");
			System.out.println("Your opponenet is the winner of this confrentation.");
		}
		else {
			System.out.println("Wow you're really good.");
			System.out.println("You are the winner in this confrentation.");
		}
	}

}
