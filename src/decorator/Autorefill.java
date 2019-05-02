package decorator;
import factory.Room;
import strategy.PaymentStrategy;

public class Autorefill extends AmenitiesDecorator {
	
	/////INSTANCE VARIABLES/////
	protected Room room;
	public static final double COST = 5;
	
	/////METHODS/////
	public Autorefill(Room r){
		this.room = r;
	}
	public String getDescription(){
		return this.room.getDescription() + " with Autorefill of the food bar,";
	}
	public int cost(){
		return (int) (this.room.cost() + COST);
	}
	public String pay(PaymentStrategy paymentMethod){
		double amount = this.cost();
		return paymentMethod.pay(amount);
	}
}