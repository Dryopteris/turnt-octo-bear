package lab22;

public class RaceApp {
	
	public static Thread hare;
	public static Thread tortoise;
	
	public static void main(String[] args) {
		
		hare = new ThreadRunner("Hare", 80, 100);
		tortoise = new ThreadRunner("Tortoise", 0, 10);
		
		System.out.println("Get ready.... Go!");
		hare.start();
		tortoise.start();
	}
	
	synchronized public static void finished(Thread winner) {
		if (winner.getName().equals("Hare")) {
			tortoise.interrupt();
		} else if (winner.getName().equals("Tortoise")) {
			hare.interrupt();
		}
	} 
}
