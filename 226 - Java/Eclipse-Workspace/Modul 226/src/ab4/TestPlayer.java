package ab4;


	class TestPlayer {
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			int[] test = new int[5];
			for (int i : test) { System.out.println(i);}
			System.out.println(test);
			Player p = new Player("Daisy");
			p.score(99);
			Player q = new Player("Donald");
			Player[] players = new Player[3];
			players[0] = q;
			players[2] = p;
			players[0].score(100);
		}
	}
