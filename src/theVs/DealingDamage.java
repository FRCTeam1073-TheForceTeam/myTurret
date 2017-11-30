package theVs;
import java.util.Random;

public class DealingDamage {

	protected static int DealingDamageToOpponent(int which){
		// TODO Auto-generated method stub
		int damage = 0;
		Random gen = new Random();
		switch (which){
		//legs
		case 1 :

			if (Battle.OwnBlasterHealth <= 0){
				damage = 4;
			}
			else {
				int LegMissChance = gen.nextInt(8) + 1;
				if (LegMissChance == 1) {
					damage = 0;
				}
				if (LegMissChance != 1) {
					damage = 7;
				}
			}
			break;
			//Head
		case 2:
			if (Battle.OwnBlasterHealth <= 0){
				damage = 5;
			}
			else {
				int HeadMissChance = gen.nextInt(5) + 1;
				if (HeadMissChance == 1) {
					damage = 0;
				}
				if (HeadMissChance != 1) {
					damage = 10;
				}
			}
			break;
			//Arms
		case 3:
			if (Battle.OwnBlasterHealth <= 0){
				damage = 3;
			}
			else {
				int ArmMissChance = gen.nextInt(6) + 1;
				if (ArmMissChance == 1) {
					damage = 0;
				}
				if (ArmMissChance != 1) {
					damage = 6;
				}
			}
			//Chest
			break;
		case 4 :
			if (Battle.OwnBlasterHealth <= 0){
				damage = 2;
			}
			else {
				int ChestMissChance = gen.nextInt(15) + 1;
				if (ChestMissChance == 1) {
					damage = 0;
				}
				if (ChestMissChance != 1) {
					damage = 5;
				}
			}
			break;
			//Blaster
		case 5 :
			if (Battle.OwnBlasterHealth <= 0){
				damage = 1;
			}
			else {
				int BlasterMissChance = gen.nextInt(2) + 1;
				if (BlasterMissChance == 1) {
					damage = 0;
				}
				if (BlasterMissChance != 1) {
					damage = 4;
				}
			}
			break;
		}
		return damage;
	}
	protected static int OpponentDealingDamageToYou(int which) {
		// TODO Auto-generated method stub
		int damage = 0;
		Random gen = new Random();
		switch (which){
		//Legs
		case 1 :
			if (Battle.OpponentBlasterHealth <= 0){
				damage = 4;
			}
			else {
				int LegMissChance = gen.nextInt(8) + 1;
				if (LegMissChance == 1) {
					Battle.damage = 0;
				}
				if (LegMissChance != 1) {
					Battle.damage = 7;
				}
			}
			break;
			//Head
		case 2:
			if (Battle.OpponentBlasterHealth > 0){
				damage = 5;
			}
			else {
				int HeadMissChance = gen.nextInt(5) + 1;
				if (HeadMissChance == 1) {
					damage = 0;
				}
				if (HeadMissChance != 1) {
					damage = 10;
				}
			}
			break;
			//Arms
		case 3:
			if (Battle.OpponentBlasterHealth <= 0){
				damage = 3;
			}
			else {
				int ArmMissChance = gen.nextInt(6) + 1;
				if (ArmMissChance == 1) {
					damage = 0;
				}
				if (ArmMissChance != 1) {
					damage = 6;
				}
			}
			break;
			//Chest
		case 4 :
			if (Battle.OpponentBlasterHealth <= 0){
				damage = 2;
			}
			else {
				int ChestMissChance = gen.nextInt(15) + 1;
				if (ChestMissChance == 1) {
					damage = 0;
				}
				if (ChestMissChance != 1) {
					damage = 5;
				}
			}
			break;
			//Blaster
		case 5 :
			if (Battle.OpponentBlasterHealth <= 0){
				damage = 1;
			}
			else {
				int BlasterMissChance = gen.nextInt(2) + 1;
				if (BlasterMissChance == 1) {
					damage = 0;
				}
				if (BlasterMissChance != 1) {
					damage = 4;
				}
			}
			break;
		}
		return damage;
	}

}