
public class DeluxeRoom extends Room {
	
	/////INSTANCE VARIABLES/////
	public static final double COST = 75;
	
	/////METHODS/////
	public DeluxeRoom(){
		super();
		this.description = "Deluxe Room";
	}
	public DeluxeRoom(String desc, int rNumber, int numOfDays){
		super("Deluxe Room",rNumber,numOfDays);
	}
	public int cost(){
		return (int) (this.getNumberOfDaysStayed() * COST);
	}
	public String pay(PaymentStrategy paymentMethod){
		double amount = this.cost();
		return paymentMethod.pay(amount);
	}
}