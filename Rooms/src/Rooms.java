import java.util.Scanner;

public class Rooms {

	public static void main(String[] args) {

		char a = 0;

		Scanner measurement = new Scanner(System.in);

		do {
			System.out.println("Enter room length: ");
			double length = Double.parseDouble(measurement.nextLine());
			
			System.out.println("Enter room width: ");
			double width = Double.parseDouble(measurement.nextLine());
			
			System.out.println("Enter room height: ");
			double height = Double.parseDouble(measurement.nextLine());
			
			if (length >= 0 && width >= 0 && height >= 0 ) {

				double area = (length * width);
				double perimeter = (length * 2) + (width * 2);
				double volume = (length * width * height);

				displayValues(area, perimeter, volume);

			}

			else if (length <= 0 || width <= 0 || height <= 0) {
				System.out.println("Please enter a measurement");
			}
			
			System.out.println("Would you like to continue? (y/n) ");
			String answer = measurement.nextLine();
			a = answer.charAt(0);
			
				

		} while (a == 'y' || a == 'Y');
		
		measurement.close();

	}

	private static void displayValues(double area, double perimeter, double volume) {
		System.out.println("Area of the room: " + area + " feet.");
		System.out.println("Perimeter of the room: " + perimeter + " feet.");
		System.out.println("Volume of the room: " + volume + " feet.");
	}

}
