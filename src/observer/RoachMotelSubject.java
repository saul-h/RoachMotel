package observer;

public interface RoachMotelSubject {

	/////METHODS/////
	public void addRoachObserver(RoachObserver o);
	public void removeRoachObserver(RoachObserver o);
	public void notifyObservers();
}