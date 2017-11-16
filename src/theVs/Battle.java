package theVs;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
//Author: Tristan Hoenninger
//Date last modified: 11/8/17
//Battle.java
//This program simulates a battle between you and an opponent.
public class Battle extends DealingDamage {
	static int OpponentBlasterHealth = 15;
	static int OwnBlasterHealth = 15;
	final static int OwnHealth = 64;
	final static int OpponentHealth = 64;
	private String WhichPart;
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		ArrayList<String> EnemyChoice = new ArrayList<String>();
		EnemyChoice.add("Legs");
		EnemyChoice.add("Head");
		EnemyChoice.add("Arms");
		EnemyChoice.add("Chest");
		EnemyChoice.add("Blaster");
		int OpponentTotalDamageTaken = 0;
		int OwnTotalDamageTaken =0;
		int damage = 0;
		int Color = 0;
		int YourColor = 0;
		Random gen = new Random();
		String WhichPartOfEnemy, WhichPartOfYou;
		Scanner scan = new Scanner(System.in);
		System.out.println("You are now in a duel with an opponent.");
		System.out.println("Let's test your luck.");
		while (OwnTotalDamageTaken <= OwnHealth && OpponentTotalDamageTaken <= OpponentHealth){
			System.out.print("Where do you fire at? (Legs, Head, Arms, Chest, Blaster)");
			WhichPartOfEnemy = scan.nextLine();
			if (WhichPartOfEnemy.equals("Legs")){
				Color = 1;
			}
			if (WhichPartOfEnemy.equals("Head")) {
				Color = 2;
			}
			if (WhichPartOfEnemy.equals("Arms")) {
				Color = 3;
			}
			if (WhichPartOfEnemy.equals("Chest")) {
				Color = 4;
			}
			if (WhichPartOfEnemy.equals("Blaster")) {
				Color = 5;
			}
			DealingDamageToOpponent(Color);
			System.out.println("You take aim at "+ WhichPartOfEnemy +".");
			if( damage == 0) {
				System.out.println("You fired but missed.");
			}
			else {
				System.out.println("You hit and dealt "+ damage +" damage.");
			}
			System.out.println( );
			int BodyPartNum = gen.nextInt(5);
			WhichPartOfYou = EnemyChoice.get(BodyPartNum);
			if (WhichPartOfYou.equals("Legs")){
				YourColor = 1;
			}
			if (WhichPartOfYou.equals("Head")) {
				YourColor = 2;
			}
			if (WhichPartOfYou.equals("Arms")) {
				YourColor = 3;
			}
			if (WhichPartOfYou.equals("Chest")) {
				YourColor = 4;
			}
			if (WhichPartOfYou.equals("Blaster")) {
				YourColor = 5;
			}
			OpponentDealingDamageToYou(YourColor);
			System.out.println("Opponent take aim at your "+ WhichPartOfYou +".");
			if( damage == 0) {
				System.out.println("Opponent fired but missed.");
			}
			else {
				System.out.println("You were hit and took "+ damage +" damage.");
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
