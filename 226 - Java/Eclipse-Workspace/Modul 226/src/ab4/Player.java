package ab4;

public class Player {
	
	private String name;
	private int score;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void score(int s) {
		score += s;
	}
	
	public int getScore() {
		return score;
	}



}
