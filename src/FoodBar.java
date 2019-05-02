
public class FoodBar extends AmenitiesDecorator {
	
	/////INSTANCE VARIABLES/////
	protected Room room;
	public static final double COST = 10;
	
	/////METHODS/////
	public FoodBar(Room r){
		this.room = r;
	}
	public String getDescription(){
		return this.room.getDescription() + " with Food Bar,";
	}
	public int cost(){
		return (int) (this.room.cost() + COST);
	}
	public String pay(PaymentStrategy paymentMethod){
		double amount = this.cost();
		return paymentMethod.pay(amount);
	}
}