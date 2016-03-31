import java.util.Scanner;

public class Adventure {

	private static Scanner choice;

	public static void main(String[] args) {

		choice = new Scanner(System.in);

		System.out.println("Welcome, What is your name? (enter your name)");
		String name = choice.nextLine();

		System.out.println("Hello, " + name + " would you like to play a game (y/n)");
		String choice1 = choice.nextLine();

		extracted(choice1);

		
			String choice4 = null;
			
				System.out.println("Would you like to engage? (y/n) ");
				String choice3 = choice.nextLine();
			do {
				if (choice3.equalsIgnoreCase("y")) {
					System.out.println(name + " dies!");
				}

				else if (choice3.equalsIgnoreCase("n")) {

					System.out.println(name + " runs home and lives to see another day.");

				} else {
					System.out.println("You only have two choices!  Pick one (y/n)");
					choice4 = choice.nextLine();

				} 
			} while (choice4.equalsIgnoreCase("y") | choice4.equalsIgnoreCase("n")); 
		

	}

	private static void extracted(String choice1) {
		if (choice1.equalsIgnoreCase("y")) {

			System.out.println("You take a walk. Choose a path (enter 1, 2, or 3):");
			String choice2 = choice.nextLine();

			switch (choice2) {
			case "1":
				System.out.println("You take a walk down by the river and meet a water nymph.\n");
				break;
			case "2":
				System.out.println("You take a walk along the railroad tracks and meet a hobo. \n");
				break;
			case "3":
				System.out.println("You take a walk to the store and meet an old lady. \n");
				break;

			}
		} else {
			System.out.println("Don't you like me? ");
			System.exit(0);

		}
	}
}

// look into a boolean do while statement in order to do the error handling for
// the end choice.
