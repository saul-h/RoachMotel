package observer;
import java.util.ArrayList;

import factory.Room;

public class RoachMotel implements RoachMotelSubject {

	/////INSTANCE VARIABLES/////
	private String name;
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private boolean vacancy;
	private int[] roomAvailable = {101,102,103,104,105};
	private static RoachMotel roachMotelInstance;
	//subject//
	private ArrayList<RoachObserver> observers = new ArrayList<RoachObserver>();
	
	/////METHODS/////
	public RoachMotel(){
		this.name = "Roach Motel";
		this.vacancy = true;
	}
	public RoachMotel(String n){
		this.name = n;
		this.vacancy = true;
	}
	public String getName(){
		return this.name;
	}
	public ArrayList<Room> getRooms(){
		return this.rooms;
	}
	public int getRoomsAvailable(){
		return this.roomAvailable.length - this.rooms.size();
	}
	public Boolean getVacancySign(){
		return this.vacancy;
	}
	public void bookRoom(Room room){
		if(this.rooms.size() < this.roomAvailable.length){
			this.rooms.add(room);
		}else{
			this.vacancy = false;
			////Send message about no rooms available, waitlist
			this.addRoachObserver(room.getOccupants());
		}
	}
	public void checkOutRoom(int index){
		this.rooms.remove(index);
		if(this.rooms.size() < this.roomAvailable.length){
			this.vacancy = true;
		}else{
			//send message to roach colony
			this.notifyObservers();
		}
	}
	public synchronized static RoachMotel getInstance(){
		if(roachMotelInstance == null){
			roachMotelInstance = new RoachMotel();
		}
		return roachMotelInstance;
	}
	public void sprayRoom(int index){
		double populationChange = 0;
		if(this.rooms.get(index).getDescription().contains("Spray Resistant Shower")){
			populationChange = (this.rooms.get(index).getOccupants().getPopulation() * (1 - .25));
			this.rooms.get(index).getOccupants().setPopulation((int)populationChange);
		}else{
			populationChange = (this.rooms.get(index).getOccupants().getPopulation() * (1 - .50));
			this.rooms.get(index).getOccupants().setPopulation((int)populationChange);
		}
	}
	
	///subject methods
	public void addRoachObserver(RoachObserver o){
		observers.add(o);
		RoachColony tempRoach = (RoachColony) o;
		System.out.println("Not enough room, " + tempRoach.getName() + " was added to waitlist.");
	}
	public void removeRoachObserver(RoachObserver o){
		observers.remove(0);
	}
	public void notifyObservers(){
		for(int i = 0; i < observers.size(); i++){
			System.out.println(observers.size());
			RoachObserver roachObserver = observers.get(i);
			roachObserver.informRoachColony();
		}
	}
}