import org.junit.Assert;
import org.junit.Test;

/*
 * A class for testing the values and methods of the GamePiece enum
 */

public class GamePieceTest
{
	@Test
	public void getColorTest()
	{
		GamePiece piece = GamePiece.BLUE_BOOT;
		Assert.assertEquals("Incorrect color", Color.BLUE, piece.getColor());
	}
	
	@Test
	public void getShapeTest()
	{
		GamePiece piece = GamePiece.RED_THIMBLE;
		Assert.assertEquals("Incorrect shape", Shape.THIMBLE, piece.getShape());
	}
	
	@Test
	public void movesFirstTest()
	{
		//GREEN_BOOT's priority is lower than RED_THIMBLE's
		Assert.assertEquals("Incorrect ordering", GamePiece.GREEN_BOOT, GamePiece.movesFirst(GamePiece.GREEN_BOOT,  GamePiece.RED_THIMBLE));
		Assert.assertEquals("Incorrect ordering", GamePiece.BLUE_RACER, GamePiece.movesFirst(GamePiece.BLUE_BOOT,  GamePiece.BLUE_RACER));
	}
	
	@Test
	public void toStringTest()
	{
		String expected = "BLUE_RACER: a BLUE RACECAR with priority 2";
		Assert.assertEquals("Incorrect toString method", expected, GamePiece.BLUE_RACER.toString());
	}
}
