import java.util.Scanner;

public class Class {

	public static void main(String[] args) {

		

		System.out.println("Welcome to the Letter Grade Converter!");

			
			
			String answer;
			do {
				Scanner sc = new Scanner(System.in);
				System.out.println("Please enter a numerical grade: ");
				int nograde = Integer.parseInt(sc.nextLine());
				if (nograde >= 88 & nograde <= 100) {
					System.out.println("A");
				} else if (nograde >= 80 & nograde <= 87) {
					System.out.println("B");

				} else if (nograde >= 67 & nograde <= 79) {
					System.out.println("C");
				} else if (nograde >= 60 & nograde <= 66) {
					System.out.println("D");

				} else if (nograde >= 0 & nograde <= 59) {
					System.out.println("F");
				} else {
					System.out.println("Please enter a number 0-100");

				}
				System.out.println("Would you like to add another grade?");
				answer = sc.nextLine();
								
			} while (answer.equalsIgnoreCase("y"));
			
			System.out.println("Thank you for using the Grade Converter.");
			
					
		}
	}

	





