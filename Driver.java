
/*
 * A class to do full-scale testing of the project
 */
public class Driver
{

	public static void main(String[] args)
	{
		//A sequence of typical play of the BoardGame
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		System.out.println("Jeff's game piece is the " + game.getPlayerGamePiece("Jeff"));
		System.out.println("The player with the blue boot is " + game.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		game.movePlayer("Jeff", Location.BILLIARD_ROOM);
		System.out.println("Jeff is now in the " + game.getPlayersLocation("Jeff"));
		game.addPlayer("Alice", GamePiece.BLUE_RACER, Location.BALLROOM);
		String[] order = game.moveTwoPlayers(new String[] {"Jeff", "Alice"}, new Location[] {Location.BALLROOM, Location.BILLIARD_ROOM});
		System.out.println(order[0] + " then " + order[1] + " moved to different locations");
		System.out.println("The players " + game.getPlayersAtLocation(Location.BALLROOM) + " are in the ballroom.");
		System.out.println("The pieces " + game.getGamePiecesAtLocation(Location.BALLROOM) + " are in the ballroom.");
		System.out.println("The current players are " + game.getPlayers());
		System.out.println("The current locations are " + game.getPlayerLocations());
		System.out.println("The current pieces are " + game.getPlayerPieces());
	}

}
