package factory;
import strategy.PaymentStrategy;

public class RegularRoom extends Room {
	
	/////INSTANCE VARIABLES/////
	public static final double COST = 50;
	
	/////METHODS/////
	public RegularRoom(){
		super();
		this.description = "Regular Room";
	}
	public RegularRoom(String desc, int rNumber, int numOfDays){
		super("Regular Room",rNumber,numOfDays);
	}
	public int cost(){
		return (int) (this.getNumberOfDaysStayed() * COST);
	}
	public String pay(PaymentStrategy paymentMethod){
		double amount = this.cost();
		return paymentMethod.pay(amount);
	}
}