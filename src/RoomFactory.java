
public class RoomFactory {
	
	/////METHODS/////
	public Room getRoomType(String colonyName, int rNumber, int numOfStays, String type){
		Room room = null;
		
		if(type.equals("Regular Room")){
			room = new RegularRoom(colonyName,rNumber,numOfStays);
		}else if(type.equals("Deluxe Room")){
			room = new DeluxeRoom(colonyName,rNumber,numOfStays);
		}else if(type.equals("Suite")){
			room = new Suite(colonyName,rNumber,numOfStays);
		}
		return room;
	}
}