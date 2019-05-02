package decorator;
import factory.Room;
import strategy.PaymentStrategy;

public class SprayResistantShower extends AmenitiesDecorator {
	
	/////INSTANCE VARIABLES/////
	protected Room room;
	public static final double COST = 25;
	
	/////METHODS/////
	public SprayResistantShower(Room r){
		this.room = r;
	}
	public String getDescription(){
		return this.room.getDescription() + " with Spray Resistant Shower,";
	}
	public int cost(){
		return (int) (this.room.cost() + COST);
	}
	public String pay(PaymentStrategy paymentMethod){
		double amount = this.cost();
		return paymentMethod.pay(amount);
	}
}