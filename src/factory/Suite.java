package factory;
import strategy.PaymentStrategy;

public class Suite extends Room {
	
	/////INSTANCE VARIABLES/////
	public static final double COST = 100;
	
	/////METHODS/////
	public Suite(){
		super();
		this.description = "Suite";
	}
	public Suite(String desc, int rNumber, int numOfDays){
		super("Suite",rNumber,numOfDays);
	}
	public int cost(){
		return (int) (this.getNumberOfDaysStayed() * COST);
	}
	public String pay(PaymentStrategy paymentMethod){
		double amount = this.cost();
		return paymentMethod.pay(amount);
	}
}