import org.junit.Assert;
import org.junit.Test;

public class GamePieceAppearanceTest
{
	@Test
	public void GamePieceAppearanceConstructorTest()
	{
		GamePieceAppearance piece = new GamePieceAppearance(Color.RED, Shape.BOOT);
		
		Assert.assertEquals("Incorrect color", Color.RED, piece.getColor());
		Assert.assertEquals("Incorrect shape", Shape.BOOT, piece.getShape());
		
	}
	
	@Test
	public void getColorTest()
	{
		GamePieceAppearance piece = new GamePieceAppearance(Color.BLUE, Shape.THIMBLE);
		Assert.assertEquals("Incorrect color", Color.BLUE, piece.getColor());
	}
	
	@Test
	public void getShapeTest()
	{
		GamePieceAppearance piece = new GamePieceAppearance(Color.CYAN, Shape.RACECAR);
		Assert.assertEquals("Incorrect shape value", Shape.RACECAR, piece.getShape());
	}
}
