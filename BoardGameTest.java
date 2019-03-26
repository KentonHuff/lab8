import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 * A class to test all of the methods in the BoardGame class
 */
public class BoardGameTest
{
	@Test
	public void BoadGameConstructorTest()
	{
		HashSet<Location> locs = new HashSet<>();
		HashSet<GamePiece> pieces = new HashSet<>();
		
		BoardGame game = new BoardGame();
		Assert.assertEquals("Incorrect locations", locs, game.getPlayerLocations());
		Assert.assertEquals("Incorrect pieces", pieces, game.getPlayerPieces());
	}
	
	@Test
	public void addPlayerTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		//Should return false on repeat of piece
		Assert.assertFalse("Failed to forbid duplicates", game.addPlayer("Lisa", GamePiece.BLUE_BOOT, Location.BILLIARD_ROOM));
		//Should return true with unique piece
		Assert.assertTrue("Failed to add new player", game.addPlayer("Jeff", GamePiece.GREEN_BOOT, Location.BALLROOM));
	}
	
	@Test
	public void getPlayerGamePieceTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		Assert.assertEquals("Returned wrong piece", GamePiece.BLUE_BOOT, game.getPlayerGamePiece("Jeff"));
	}
	
	@Test
	public void getPlayerWithGamePieceTest()
	{
		BoardGame game = new BoardGame();
		
		Assert.assertEquals("Found player when shouldn't have", null, game.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
		
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		Assert.assertEquals("Failed to find present player", "Jeff", game.getPlayerWithGamePiece(GamePiece.BLUE_BOOT));
	}
	
	@Test
	public void movePlayerTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		Assert.assertEquals("Jeff isn't in the ballroom", Location.BALLROOM, game.getPlayersLocation("Jeff"));
		
		game.movePlayer("Jeff", Location.BILLIARD_ROOM);
		Assert.assertEquals("Jeff isn't in the billiard room", Location.BILLIARD_ROOM, game.getPlayersLocation("Jeff"));
	}
	
	@Test
	public void moveTwoPlayersTest()
	{
		BoardGame game = new BoardGame();
		//Lisa moves before Jeff
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game.addPlayer("Lisa", GamePiece.BLUE_RACER, Location.BILLIARD_ROOM);
		
		Assert.assertEquals("Jeff isn't in the ballroom", Location.BALLROOM, game.getPlayersLocation("Jeff"));
		Assert.assertEquals("Lisa isn't in the billiard room", Location.BILLIARD_ROOM, game.getPlayersLocation("Lisa"));
		
		String[] expected = {"Lisa", "Jeff"};
		String[] names = {"Lisa", "Jeff"};
		Location[] newLocs = {Location.BALLROOM, Location.BILLIARD_ROOM};
		
		Assert.assertArrayEquals("Players moved in wrong order", expected, game.moveTwoPlayers(names, newLocs));
		Assert.assertEquals("Jeff isn't in the billiard room", Location.BILLIARD_ROOM, game.getPlayersLocation("Jeff"));
		Assert.assertEquals("Lisa isn't in the ballroom", Location.BALLROOM, game.getPlayersLocation("Lisa"));
		
		names[0] = "Jeff";
		names[1] = "Lisa";
		
		Assert.assertArrayEquals("Players moved in wrong order", expected, game.moveTwoPlayers(names, newLocs));
		Assert.assertEquals("Jeff isn't in the ballroom", Location.BALLROOM, game.getPlayersLocation("Jeff"));
		Assert.assertEquals("Lisa isn't in the billiard room", Location.BILLIARD_ROOM, game.getPlayersLocation("Lisa"));
	}
	
	@Test
	public void getPlayersLocationTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		
		Assert.assertEquals("Incorrect player location", Location.BALLROOM, game.getPlayersLocation("Jeff"));
	}
	
	@Test
	public void getPlayersAtLocationTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game.addPlayer("Lisa", GamePiece.RED_THIMBLE, Location.BALLROOM);
		game.addPlayer("Alice", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("Jeff");
		expected.add("Lisa");
		
		Assert.assertEquals("Unexpected contents of location", expected, game.getPlayersAtLocation(Location.BALLROOM));
	}
	
	@Test
	public void getGamePiecesAtLocationTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game.addPlayer("Lisa", GamePiece.RED_THIMBLE, Location.BALLROOM);
		game.addPlayer("Alice", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		ArrayList<GamePiece> expected = new ArrayList<>();
		expected.add(GamePiece.BLUE_BOOT);
		expected.add(GamePiece.RED_THIMBLE);
		
		Assert.assertEquals("Unexpected contents of location", expected, game.getGamePiecesAtLocation(Location.BALLROOM));
	}
	
	@Test
	public void getPlayersTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game.addPlayer("Lisa", GamePiece.RED_THIMBLE, Location.BALLROOM);
		game.addPlayer("Alice", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		Set<String> players = game.getPlayers();
		ArrayList<String> expectedPlayers = new ArrayList<>();
		
		expectedPlayers.add("Jeff");
		expectedPlayers.add("Lisa");
		expectedPlayers.add("Alice");
		
		//Test if every element of expectedPlayers is in players, and vice versa
		for(String player : expectedPlayers)
		{
			Assert.assertTrue("Wrong players returned", players.contains(player));
		}
		
		for(String player : players)
		{
			Assert.assertTrue("Wrong players returned", expectedPlayers.contains(player));
		}
	}
	
	@Test
	public void getPlayerLocationsTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game.addPlayer("Lisa", GamePiece.RED_THIMBLE, Location.BALLROOM);
		game.addPlayer("Alice", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		Set<Location> locs = game.getPlayerLocations();
		
		ArrayList<Location> expectedLocs = new ArrayList<>();
		expectedLocs.add(Location.BALLROOM);
		expectedLocs.add(Location.BILLIARD_ROOM);
		
		//Test that every expected location is in the locations and vice versa
		for(Location loc : expectedLocs)
		{
			Assert.assertTrue("Wrong locations returned", locs.contains(loc));
		}
		
		for(Location loc : locs)
		{
			Assert.assertTrue("Wrong locations returned", expectedLocs.contains(loc));
		}
	}
	
	@Test
	public void getPlayerPiecesTest()
	{
		BoardGame game = new BoardGame();
		game.addPlayer("Jeff", GamePiece.BLUE_BOOT, Location.BALLROOM);
		game.addPlayer("Lisa", GamePiece.RED_THIMBLE, Location.BALLROOM);
		game.addPlayer("Alice", GamePiece.GREEN_BOOT, Location.BILLIARD_ROOM);
		
		Set<GamePiece> pieces = game.getPlayerPieces();
		ArrayList<GamePiece> expectedPieces = new ArrayList<>();
		
		expectedPieces.add(GamePiece.BLUE_BOOT);
		expectedPieces.add(GamePiece.RED_THIMBLE);
		expectedPieces.add(GamePiece.GREEN_BOOT);
		
		//Test that every piece in expectedPieces is in pieces and vice versa
		for(GamePiece piece : expectedPieces)
		{
			Assert.assertTrue("Wrong pieces returned", pieces.contains(piece));
		}
		
		for(GamePiece piece : pieces)
		{
			Assert.assertTrue("Wrong pieces returned", expectedPieces.contains(piece));
		}
	}
	
	
}
