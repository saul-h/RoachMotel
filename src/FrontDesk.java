import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FrontDesk {

	public static String makePayment(int index, String paymentMethod, RoachMotel roachMotel){
		roachMotel.getRooms().get(index).cost();
		if(paymentMethod.equals("MasterRoach")){
			MasterRoach masterRoach = new MasterRoach(roachMotel.getRooms().get(index).getOccupants().getName(),"12345","678","12/22");
			return roachMotel.getRooms().get(index).pay(masterRoach);
		}else if(paymentMethod.equals("RoachPal")){
			RoachPal roachPal = new RoachPal(roachMotel.getRooms().get(index).getOccupants().getName(), roachMotel.getRooms().get(index).getOccupants().getName() + "@mail.com");	
			return roachMotel.getRooms().get(index).pay(roachPal);
		}
		return null;
	}
	
	public static void transaction(File fileName, ArrayList<String> transactions){
		try{
			PrintWriter transactionOut = new PrintWriter(fileName);
			System.out.println("\t\tRoachMotel Transaction Logs");
			transactionOut.println("\t\tRoachMotel Transaction Logs");
			for(String transaction: transactions){
				transactionOut.println("  " + transaction);
				System.out.println("  " + transaction);
			}
			transactionOut.close();
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
	
	/**Checks the parameter input if input is either a double or integer
	 * @param input - input to be checked
	 * @return false if input is not a double or integer
	 * @return true if input is a double or integer*/
	static boolean checkInput(String input){
		try{
			Integer.parseInt(input);
			Double.parseDouble(input);
		}catch(NumberFormatException ex){
			return false;
		}
		return true;
	}
	
	/**allows a user to input*/
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		/**
		File transactionLog = new File("transactionLog.txt");
		ArrayList<String> transactions = new ArrayList<String>();
		
		System.out.println("Welcome");
		
		RoomFactory roomFactory = new RoomFactory();
		Room room = roomFactory.getRoomType("Regular Room");
		System.out.println(room.toString());
		
		Room room2 = roomFactory.getRoomType("Deluxe Room");
		System.out.println("\n" + room2.toString());
		
		Room room3 = roomFactory.getRoomType("Suite");
		System.out.println("\n" + room3.toString());
		
		room = new FoodBar(new Spa(new SprayResistantShower(new Autorefill(room))));
		System.out.println("\n" + room.toString());
		
		room.getOccupants().setGrowthRate(20);
		room.getOccupants().setPopulation(1000);
		room.getOccupants().throwsParty();
		System.out.println(room.getOccupants().getPopulation());
		
		RoachMotel roachMotel = new RoachMotel();
		System.out.println("Available rooms: " + roachMotel.getRoomsAvailable());
		System.out.println("Vacancy: " + roachMotel.getVacancySign());
		
		roachMotel.bookRoom(room);
		roachMotel.bookRoom(room2);
		roachMotel.bookRoom(room3);
		roachMotel.bookRoom(room2);
		roachMotel.bookRoom(room2);
		roachMotel.bookRoom(room2);
		
		System.out.println(roachMotel.getRooms().size());
		System.out.println("Available rooms: " + roachMotel.getRoomsAvailable());
		System.out.println("Vacancy: " + roachMotel.getVacancySign());
		
		roachMotel.checkOutRoom(2);
		System.out.println("\n\n" + roachMotel.getRooms().size());
		System.out.println("Available rooms: " + roachMotel.getRoomsAvailable());
		System.out.println("Vacancy: " + roachMotel.getVacancySign());
		
		
		System.out.println(roachMotel.getRooms().get(1).toString());
		System.out.println(roachMotel.getRooms().get(1).getDescription().contains("Spray Resistant Shower"));
		
		System.out.println("\n\nPopulation: " + roachMotel.getRooms().get(1).getOccupants().getPopulation());
		roachMotel.getRooms().get(1).getOccupants().throwsParty();
		System.out.println("New Population: " + roachMotel.getRooms().get(1).getOccupants().getPopulation());
		roachMotel.sprayRoom(1);
		System.out.println("Newer Population: " + roachMotel.getRooms().get(1).getOccupants().getPopulation());
		
		transactions.add(makePayment(0, "MasterRoach", roachMotel));
		transactions.add(makePayment(1, "RoachPal", roachMotel));
		
		transaction(transactionLog, transactions);
		
		////testing observer and subjects
		roachMotel.addRoachObserver(new RoachColony());
		roachMotel.addRoachObserver(new RoachColony());
		roachMotel.addRoachObserver(new RoachColony());

		roachMotel.notifyObservers();
		
		*/
		
		File transactionLog = new File("transactionLog.txt");
		ArrayList<String> transactions = new ArrayList<String>();
		RoomFactory roomFactory = new RoomFactory();
		RoachMotel roachMotel = new RoachMotel();
		
		String firstChoice = null;
		do{
			System.out.println("/////////////////////////////////////////////");
			System.out.println(String.format("%28s", "Roach Motel"));
			System.out.println("/////////////////////////////////////////////");
			System.out.println(" 1. Check in Roach Guest");
			System.out.println(" 2. Check out Roach Guest");
			System.out.println(" 3. Check Rooms(Roach Throws Party)");
			System.out.println(" 4. Check Roach Guest Waitlist");
			System.out.println(" 5. Exit");
			
			System.out.print("Enter Option: ");
			firstChoice = console.next();
			//checks whoAreYou user input
			while(checkInput(firstChoice) == false || (Integer.parseInt(firstChoice) > 5) || (Integer.parseInt(firstChoice) < 1)){
				firstChoice = "";
				System.out.print("Inccorect Input, Try Again: ");
				firstChoice = console.next();
			}
			
			switch(Integer.parseInt(firstChoice)){
				case 1:{
					// Check in Roach Guest
					String colonyName;
					String numberOfOccupants;
					String growthRate;
					String numberOfStays;
					String typeOfRoom;
					String numberOfAmenitiesWanted;
					ArrayList<String> amenities = new ArrayList<String>();
					
					System.out.println();
					System.out.println("---------------------------------------------");
					System.out.println(String.format("%28s", "Checking In"));
					System.out.println("---------------------------------------------");
					System.out.print(" 1. Name of Colony: ");
					colonyName = console.next();
					
					System.out.print(" 2. Number of Occupants (1-50000): ");
					numberOfOccupants = console.next();
					while(checkInput(numberOfOccupants) == false || (Integer.parseInt(numberOfOccupants) > 50000) || (Integer.parseInt(numberOfOccupants) < 1)){
						numberOfOccupants = "";
						System.out.print("Inccorect Input, Try Again: ");
						numberOfOccupants = console.next();
					}
					
					System.out.print(" 3. Colony's Growth Rate(1-100)%: ");
					growthRate = console.next();
					while(checkInput(growthRate) == false || (Integer.parseInt(growthRate) > 100) || (Integer.parseInt(growthRate) < 1)){
						growthRate = "";
						System.out.print("Inccorect Input, Try Again: ");
						growthRate = console.next();
					}
					
					System.out.print(" 4. Number of Stay(1-10): ");
					numberOfStays = console.next();
					while(checkInput(numberOfStays) == false || (Integer.parseInt(numberOfStays) > 10) || (Integer.parseInt(numberOfStays) < 1)){
						numberOfStays = "";
						System.out.print("Inccorect Input, Try Again: ");
						numberOfStays = console.next();
					}
					
					System.out.println(" 5. Type of Room:");
					System.out.println("   1. Regular Room");
					System.out.println("   2. Deluxe Room");
					System.out.println("   3. Suite");
					System.out.print("Enter Option: ");
					typeOfRoom = console.next();
					while(checkInput(typeOfRoom) == false || (Integer.parseInt(typeOfRoom) > 3) || (Integer.parseInt(typeOfRoom) < 1)){
						typeOfRoom = "";
						System.out.print("Inccorect Input, Try Again: ");
						typeOfRoom = console.next();
					}
					
					System.out.println(" 6. Amenities List:");
					System.out.println("   1. Autorefill Food Bar");
					System.out.println("   2. Food Bar");
					System.out.println("   3. Spa");
					System.out.println("   4. Spray Resistant Shower");
					System.out.print("Number of Amenites Wanted(1-4): ");
					numberOfAmenitiesWanted = console.next();
					while(checkInput(numberOfAmenitiesWanted) == false || (Integer.parseInt(numberOfAmenitiesWanted) > 4) || (Integer.parseInt(numberOfAmenitiesWanted) < 1)){
						numberOfAmenitiesWanted = "";
						System.out.print("Inccorect Input, Try Again: ");
						numberOfAmenitiesWanted = console.next();
					}
					for(int i = 0; i < Integer.parseInt(numberOfAmenitiesWanted); i++){
						String tempAmen = "";
						System.out.print("Amenity " + (i+1) + "(1-4): ");
						tempAmen = console.next();
						while(checkInput(tempAmen) == false || (Integer.parseInt(tempAmen) > 4) || (Integer.parseInt(tempAmen) < 1)){
							tempAmen = "";
							System.out.print("Inccorect Input, Try Again: ");
							tempAmen = console.next();
						}
						if(tempAmen.equals("1")){
							amenities.add("Autorefill");
						}else if(tempAmen.equals("2")){
							amenities.add("FoodBar");
						}else if(tempAmen.equals("3")){
							amenities.add("Spa");
						}else{
							amenities.add("SprayResistantShower");
						}
					}
					
					
					
					
					break;
				}
				case 2:{
					// Check out Roach Guest
					System.out.println("CHOICE 2");
					break;
				}
				case 3:{
					// Check Rooms(Roach Throws Party)
					System.out.println("CHOICE 3");
					break;
				}
				case 4:{
					// Check Roach Guest Waitlist
					System.out.println("CHOICE 4");
					break;
				}
				case 5:{
					// Exit
					System.exit(0);
					break;
				}
			}
		}while(Integer.parseInt(firstChoice) != 5);
		
	}
}