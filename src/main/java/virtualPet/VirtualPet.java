package virtualPet;

import java.util.Scanner;

public class VirtualPet {
	int hunger = 0;
	int thirst = 0;
	int boredom = 0;
	int tiredness = 0;
	
	String mood = "happy";
	
	String appearance = " ^  ^\n(=�.�=)S";
	String name = "Kitty the Cat";

	public VirtualPet() {

	}

	public VirtualPet(String name) {
		this.name = name;
	}

	public boolean tick(int ticks) {
		for (int i = 0; i < ticks; i++) {
			hunger++;
			thirst++;
			boredom++;
			tiredness++;

			hunger = stayInLimits(hunger);
			thirst = stayInLimits(thirst);
			boredom = stayInLimits(boredom);
			tiredness = stayInLimits(tiredness);
		}

		int maxed = 0;
		if (hunger == 50) {
			maxed++;
		}
		if (thirst == 50) {
			maxed++;
		}
		if (boredom == 50) {
			maxed++;
		}
		if (tiredness == 50) {
			maxed++;
		}
		
		if (maxed >= 2) {
			return true;
		}
		if(maxed==1) {
			mood = "unhappy";
		}
		return false;
	}

	public void feed() {
		hunger -= 15;
		thirst += 5;
	}

	public void play() {
		boredom -= 15;
		tiredness += 10;
	}

	public void giveWater() {
		thirst -= 15;
	}

	public void putToBed() {
		tiredness -= 25;
		thirst += 5;
		hunger += 5;
		boredom += 5;
	}

	public int stayInLimits(int number) {
		if (number > 50) {
			return 50;
		}
		if (number < 0) {
			return 0;
		}
		return number;
	}

}