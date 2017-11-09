package theVs;

public class Battle {
	static int OpponentBlasterHealth = 15;
	static int OwnBlasterHealth = 15;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int OwnHealth = 64;
		final int OpponentHealth = 64; 
		int OpponentTotalDamageTaken = 0;
		int OwnTotalDamageTaken =0;
		int damage;
		while (OwnTotalDamageTaken <= OwnHealth && OpponentTotalDamageTaken <= OpponentHealth){
			
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
