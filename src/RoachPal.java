import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RoachPal implements PaymentStrategy {

	/////INSTANCE VARIABLES/////
	private String name;
	private String email;
	
	/////METHODS/////
	public RoachPal(String na, String em){
		this.name = na;
		this.email = em;
	}
	public String toString(){
		return String.format("Name: %\nEmail: %",this.name,this.email);
	}
	@Override
	public String pay(double p) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return (name + " paid with RoachPal: $" + formatter.format(p));
	}
}