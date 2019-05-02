
public class RoachColony implements RoachObserver{
	
	/////INSTANCE VARIABLES/////
	private String name;
	private int initialPopulation;
	private double growthRate;
	
	/////METHODS/////
	public RoachColony(){
		this.name = "Colony";
		this.initialPopulation = 100;
		this.growthRate = 10;
	}
	public RoachColony(String n, int inPop, double growth){
		this.name = n;
		this.initialPopulation = inPop;
		this.growthRate = growth;
	}
	public String getName(){
		return this.name;
	}
	public int getPopulation(){
		return this.initialPopulation;
	}
	public double getGrowthRate(){
		return this.growthRate;
	}
	public void setName(String n){
		this.name = n;
	}
	public void setPopulation(int inPop){
		this.initialPopulation = inPop;
	}
	public void setGrowthRate(double growth){
		this.growthRate = growth;
	}
	public void throwsParty(){
		double addingPopulation = 0;
		addingPopulation = (((this.growthRate)/100) * this.initialPopulation);
		this.initialPopulation = this.initialPopulation + (int)addingPopulation;
	}
	/////observer/////
	public void informRoachColony() {
		System.out.println("Room available at Roach Motel");
	}
}