import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Room {
	
	/////INSTANCE VARIABLES/////
	protected String description;
	private int roomNumber;
	private RoachColony occupants;
	private int numberOfDaysStayed;

	/////METHODS/////
	public Room(){
		this.description = "Room";
		this.roomNumber = 0;
		this.numberOfDaysStayed = 1;
		this.occupants = new RoachColony();
	}
	public Room(String desc, int rNumber, int numOfDays){
		this.description = desc;
		this.roomNumber = rNumber;
		this.numberOfDaysStayed = numOfDays;
	}
	public String getDescription(){
		return this.description;
	}
	public int getRoomNumber(){
		return this.roomNumber;
	}
	public int getNumberOfDaysStayed(){
		return this.numberOfDaysStayed;
	}
	public RoachColony getOccupants(){
		return this.occupants;
	}
	public void setRoomNumber(int roomNum){
		this.roomNumber = roomNum;
	}
	public void setNumberOfDaysStayed(int days){
		this.numberOfDaysStayed = days;
	}
	public abstract int cost();
	public abstract String pay(PaymentStrategy paymentMethod);
	public String toString(){		
		NumberFormat formatter = new DecimalFormat("#0.00");
		return (String.format("  Room Type: %-20s \n  Room Number: %-10s \n  Number Of Occupant(s): %-10s \n  Number Of Stay(s): %-10s \n  Total Cost: $%-10s"
				,this.getDescription(),this.getRoomNumber(),this.occupants.getPopulation(),this.getNumberOfDaysStayed(),formatter.format(this.cost())));
	}
}