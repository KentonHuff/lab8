import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

//An enum describing the location of a player's piece in the game
enum Location
{
	KITCHEN, CONSERVATORY, DINING_ROOM, BALLROOM, STUDY, HALL, LOUNGE, LIBRARY, BILLIARD_ROOM;
}

/* Enumeration of the available game pieces
 * A piece's priority defines whether it moves first when two pieces move at the same time
 */
enum GamePiece
{
	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5),
	BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2),
	GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8),
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1),
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0),
	RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10),
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
	
	private GamePieceAppearance appearance;
	private int priority;
	
	private GamePiece(GamePieceAppearance appearance, int priority)
	{
		this.appearance = appearance;
		this.priority = priority;
	}
	
	public Color getColor()
	{
		return this.appearance.getColor();
	}
	
	public Shape getShape()
	{
		return this.appearance.getShape();
	}
	
	public static GamePiece movesFirst(GamePiece a, GamePiece b)
	{
		if(a.priority < b.priority)
		{
			return a;
		}
		return b;
	}
	
	public String toString()
	{
		return String.format("%s: a %s %s with priority %d", this.name(), this.getColor().name(), this.getShape().name(), this.priority);
	}
}

/*
 * A class simulating a board game, with player names associated with pieces at locations.
 */
public class BoardGame
{
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame()
	{
		playerPieces = new LinkedHashMap<>();
		playerLocations = new LinkedHashMap<>();
	}
	
	//Adds a new player to the game if the requested gamePiece is not already in use
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation)
	{
		if(playerPieces.containsValue(gamePiece))
		{
			return false;
		}
		
		playerPieces.put(playerName, gamePiece);
		playerLocations.put(playerName, initialLocation);
		return true;
	}
	
	public GamePiece getPlayerGamePiece(String playerName)
	{
		return playerPieces.get(playerName);
	}
	
	//Returns the player associated with a GamePiece if one exists, otherwise returns null
	public String getPlayerWithGamePiece(GamePiece gamePiece)
	{
		String result = null;
		for(Entry<String, GamePiece> entry : playerPieces.entrySet())
		{
			if(entry.getValue() == gamePiece)
			{
				result = entry.getKey();
				break;
			}
		}
		return result;
	}
	
	public void movePlayer(String playerName, Location newLocation)
	{
		playerLocations.put(playerName, newLocation);
	}
	
	/*
	 * Moves two players and returns their name's in the order of movement.
	 * Ordering is determined by GamePiece's movesFirst method
	 */
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations)
	{
		String[] result = new String[2];
		//If the first of playerNames moves first...
		if(GamePiece.movesFirst(getPlayerGamePiece(playerNames[0]), getPlayerGamePiece(playerNames[1])) == getPlayerGamePiece(playerNames[0]))
		{
			movePlayer(playerNames[0], newLocations[0]);
			movePlayer(playerNames[1], newLocations[1]);
			result = Arrays.copyOf(playerNames, playerNames.length);
		}
		else
		{
			movePlayer(playerNames[1], newLocations[1]);
			movePlayer(playerNames[0], newLocations[0]);
			result[0] = playerNames[1];
			result[1] = playerNames[0];
		}
		return result;
	}
	
	public Location getPlayersLocation(String player)
	{
		return playerLocations.get(player);
	}
	
	//Returns an arrayList of the names of all of the players at a given location
	public ArrayList<String> getPlayersAtLocation(Location loc)
	{
		ArrayList<String> result = new ArrayList<>();
		
		for(Entry<String, Location> entry : playerLocations.entrySet())
		{
			if(entry.getValue() == loc)
			{
				result.add(entry.getKey());
			}
		}
		
		return result;
	}
	
	//Returns an arrayList of the GamePieces of all of the players at a given location
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
	{
		ArrayList<GamePiece> result = new ArrayList<>();
		
		for(String player : getPlayersAtLocation(loc))
		{
			result.add(getPlayerGamePiece(player));
		}
		
		return result;
	}
	
	public Set<String> getPlayers()
	{
		return playerPieces.keySet();
	}
	
	//Returns the Set (no repeats) of current locations of players
	public Set<Location> getPlayerLocations()
	{
		return new HashSet<Location>(playerLocations.values());
	}
	
	public Set<GamePiece> getPlayerPieces()
	{
		return new HashSet<GamePiece>(playerPieces.values());
	}
}
