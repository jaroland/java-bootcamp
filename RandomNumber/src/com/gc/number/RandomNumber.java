package com.gc.number;

import java.util.Random;
import java.util.Scanner;
import java.math.*;

public class RandomNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int guess;
		int noguess = 0;

		System.out.println("Do you want to play a game (y/n)? ");
		// answer =
		while (sc.next().equalsIgnoreCase("y")) {
			Random randomNumber = new Random();
			int randomInt = randomNumber.nextInt(100);

			do {
				System.out.println("Guess a numer 1-100: ");
				guess = sc.nextInt();
				if (guess < randomInt) {
					System.out.println("Your guess is too low");

				} else if (guess > randomInt) {
					System.out.println("Your guess is too high");

				}
				
				noguess++;

			} while (guess != randomInt);

			if (guess == randomInt)
				;
			{
				System.out.println("You guessed correctly with: " + noguess + " guesses. Good Job!");
			}

		}
	}
}
