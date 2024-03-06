/* 
  This is for the basic program that you asked for. I thiiiiink that it followed the rules and pointed to the correct methods.
  The other program below is me just wanting to practice with loops, choices, and integer checks so that I can better
  commit them to "muscle memory" such as it is.
 
public class PaintCalculator {
	
public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);
			//Prompts for wall inputs.
			System.out.println("Please enter the length of the long sides in feet: ");
			double longLength = scanner.nextDouble();
			System.out.println("Please enter the width of the long sides in feet: ");
			double longWidth = scanner.nextDouble();
			System.out.println("Please enter the length of the short sides in feet: ");
			double shortLength = scanner.nextDouble();
			System.out.println("Please enter the width of the short sides in feet: ");
			double shortWidth = scanner.nextDouble();
			//Calculations for area and gallons needed.
			double wallArea = calculateWallArea(longLength, longWidth, shortLength, shortWidth);
			double gallonsNeeded = calculateGallons(wallArea);
			//Display gallons needed with 2 decimal floating point and carriage return to price on next line.
			System.out.printf("Gallons needed: %.2f%n", gallonsNeeded);
			double price = calculatePrice(gallonsNeeded);
			System.out.println("Total price 'gouge': $" + price);
}
			//Method to do "Algebra".
public static double calculateWallArea(double longLength, double longWidth, double shortLength, double shortWidth) {
	
			double areaLong = 2 * (longLength * longWidth);
			double areaShort = 2 * (shortLength * shortWidth);
			return areaLong + areaShort;
}
			//Method to calc the gallons.
public static double calculateGallons(double area) {
			final double coveragePerGallon = 350;
			return area / coveragePerGallon;
}
			//Method to get price.
public static double calculatePrice(double gallonsNeeded) {
			final double pricePerGallon = 32;
			return gallonsNeeded * pricePerGallon;
}
	
}
*/

package paintingrooms;
//Michael S. Pearson JAVA 1 0830 Tue-Thur.
import java.util.Scanner;

public class PaintCalculator {
			//Testing Self-Encapsulation for larger classes even though it's not really needed here.
			private static double totalGallons = 0;
			private static double totalPrice = 0;
			private static int allRooms = 0;
			// Nobody needs more than 100 rooms.
			private static double[] roomGallons = new double[100];
			private static double[] roomPrice = new double[100]; 

public static void main(String[] args) {
     		Scanner scanner = new Scanner(System.in);

     		while (true) {
     			
        	//Prompts for wall inputs.
     			
            int longLength = getIntInput(scanner, "Please enter the length of the long sides in feet: ");
            int longWidth = getIntInput(scanner, "Please enter the width of the long sides in feet: ");
            int shortLength = getIntInput(scanner, "Please enter the length of the short sides in feet: ");
            int shortWidth = getIntInput(scanner, "Please enter the width of the short sides in feet: ");
            
            // Calculate the 3 main components.
            
            double wallArea = calculateWallArea(longLength, longWidth, shortLength, shortWidth);
            double gallonsNeeded = calculateGallons(wallArea);
            double price = calculatePrice(gallonsNeeded);  
            
            // Update room data if needed.
            
            updateRooms(gallonsNeeded, price);
            
            //Display gallons needed with 2 decimal floating point and carriage returns to price on next line.
            
            System.out.printf("For this room, you need: %.2f%n gallons", gallonsNeeded);
            System.out.printf("For this room, this will cost you: $%.2f%n", price);

            // "You-Call-Its" user options.
            
            System.out.println("Do you want to: 1. Add another room, 2. Change room size, or 3. Exit?");
            int choice = getIntInput(scanner, "Please choose: (1, 2, or 3):");
            if (choice == 2) {
            	
            // If changing room size, ask for room number (maybe should add displaying how many rooms/what room you're on in a bit)
            	
            allRooms = getIntInput(scanner, "Enter room number to change:") - 1;
            if (allRooms < 0 || allRooms >= 100) {
            	
            //Kick the user out if they don't even remember their room number.
            	
            System.out.println("Invalid room number. Bye-bye");
            break;
}
         } 	else if (choice == 3) {
        	 
            // Exit the loop
        	 
            break;
         } 	else {
        	 
            // Move to next room for new room data
        	 
            allRooms++;
}
}       
            calculateTotals();
            
        	// Display the total gallons of paint needed and the price for all rooms
            
            System.out.printf("Total gallons needed for all rooms: %.2f%n", totalGallons);
            System.out.printf("Total price for all rooms: $%.2f%n", totalPrice);
}
    		//. V .All of my additional methods below. V .

public static void updateRooms(double gallonsNeeded, double price) {
        	roomGallons[allRooms] = gallonsNeeded;
        	roomPrice[allRooms] = price;
}
public static void calculateTotals() {
        	totalGallons = 0;
        	totalPrice = 0;
        	for (int i = 0; i <= allRooms; i++) {
            totalGallons += roomGallons[i];
            totalPrice += roomPrice[i];
}
}
    		//Short checks to make sure only valid stuff is input into the program.

public static int getIntInput(Scanner scanner, String prompt) {
			System.out.println(prompt);
			while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an actual number.");
            
            // Get rid of garbage input.
            
            scanner.next();
            System.out.println(prompt);
}
          	return scanner.nextInt();
}
    		//Method to do "Algebra".

public static double calculateWallArea(int longLength, int longHeight, int shortLength, int shortHeight) {
        	double areaLongWalls = 2 * (longLength * longHeight);
        	double areaShortWalls = 2 * (shortLength * shortHeight);
            return areaLongWalls + areaShortWalls;
}
public static double calculateGallons(double area) {
        	final double coveragePerGallon = 350;
        	return area / coveragePerGallon;
 }
public static double calculatePrice(double gallonsNeeded) {
        	final double pricePerGallon = 32;
        	return gallonsNeeded * pricePerGallon;
}
}