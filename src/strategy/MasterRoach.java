package strategy;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MasterRoach implements PaymentStrategy {
	
	/////INSTANCE VARIABLES/////
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
	
	/////METHODS/////
	public MasterRoach(String na, String cardN, String cVV, String dateOE){
		this.name = na;
		this.cardNumber = cardN;
		this.cvv = cVV;
		this.dateOfExpiry = dateOE;
	}
	public String toString(){
		return String.format("Name on Card: %\nCard Number: %\nCVV: %\nDate Of Expiry: %",this.name,this.cardNumber,this.cvv,this.dateOfExpiry);
	}
	@Override
	public String pay(double p) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return (name + " paid with MasterRoach: $" + formatter.format(p));
	}
}