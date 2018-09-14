package virtualPet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("What is your cat's name?");
		VirtualPet kittyCat = new VirtualPet(in.nextLine() + " the cat");

		boolean stillPlaying = true;

		do {
			boolean angryCat = kittyCat.tick(4);

			// if two or more reach 50 kitty will take care of their own needs
			// by rampaging through the house and eating everything
			if (angryCat == true) {
				System.out.println(kittyCat.name + " is very angry and rampages through your house,"
						+ "\ndestroying most of the furniture and eating all of your food.");
				do {
					System.out.println("Tell your kitty \"sorry\"");
				} while (!in.next().equals("sorry"));

				kittyCat.hunger = 15;
				kittyCat.thirst = 15;
				kittyCat.boredom = 15;
				kittyCat.tiredness = 15;
			}

			System.out.println("~" + kittyCat.name + "~");
			System.out.println();
			System.out.println(kittyCat.appearance);
			System.out.println();
			System.out.println(kittyCat.name + " is " + kittyCat.mood);
			System.out.println("Hunger: " + kittyCat.hunger + "/50");
			System.out.println("Thirst: " + kittyCat.thirst + "/50");
			System.out.println("Boredom: " + kittyCat.boredom + "/50");
			System.out.println("Tiredness: " + kittyCat.tiredness + "/50");

			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1 - Feed your cat");
			System.out.println("2 - Give your cat water");
			System.out.println("3 - Play with your cat");
			System.out.println("4 - Put your cat to bed");
			System.out.println("5 - Quit the game");

			switch (in.nextInt()) {
			case 1:
				System.out.println("What do you want to feed your cat?");
				System.out.println("Options: \n1 - Treats \n2 - Tuna");
				kittyCat.feed(in.nextInt());
				break;
			case 2:
				kittyCat.giveWater();
				break;
			case 3:
				kittyCat.play();
				break;
			case 4:
				kittyCat.putToBed();
				break;
			case 5:
				stillPlaying = false;
				break;
			default:
				System.out.println();
			}

		} while (stillPlaying == true);

		in.close();
	}

}
