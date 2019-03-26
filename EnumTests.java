import org.junit.Assert;
import org.junit.Test;

/*
 * A class to test the values and functions of the Shape, Color, and Location enums.
 * GamePiece enum is tested in GamePieceTest class.
 */

public class EnumTests
{
	@Test
	public void ShapeTest()
	{
		Shape shp = null;
		shp = Shape.THIMBLE;
		Assert.assertEquals("Incorrect enum value", "thimble", shp.toString());
		
		shp = Shape.BOOT;
		Assert.assertEquals("Incorrect enum value", "boot", shp.toString());
		
		shp = Shape.RACECAR;
		Assert.assertEquals("Incorrect enum value", "racecar", shp.toString());
	}
	
	@Test
	public void ColorTest()
	{
		Color col = null;
		
		col = Color.RED;
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getR());
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getG());
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getB());
		
		col = Color.GREEN;
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getR());
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getG());
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getB());
		
		col = Color.BLUE;
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getR());
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getG());
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getB());
		
		col = Color.YELLOW;
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getR());
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getG());
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getB());
		
		col = Color.CYAN;
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getR());
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getG());
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getB());
		
		col = Color.MAGENTA;
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getR());
		Assert.assertEquals("Incorrect value for: " + col.name(), 0, col.getG());
		Assert.assertEquals("Incorrect value for: " + col.name(), 255, col.getB());
	}
	
	@Test
	public void locationTest()
	{
		Assert.assertEquals("Location values incorrect", Location.KITCHEN, Location.valueOf("KITCHEN"));
		Assert.assertEquals("Location values incorrect", Location.CONSERVATORY, Location.valueOf("CONSERVATORY"));
		Assert.assertEquals("Location values incorrect", Location.DINING_ROOM, Location.valueOf("DINING_ROOM"));
		Assert.assertEquals("Location values incorrect", Location.BALLROOM, Location.valueOf("BALLROOM"));
		Assert.assertEquals("Location values incorrect", Location.STUDY, Location.valueOf("STUDY"));
		Assert.assertEquals("Location values incorrect", Location.HALL, Location.valueOf("HALL"));
		Assert.assertEquals("Location values incorrect", Location.LOUNGE, Location.valueOf("LOUNGE"));
		Assert.assertEquals("Location values incorrect", Location.LIBRARY, Location.valueOf("LIBRARY"));
		Assert.assertEquals("Location values incorrect", Location.BILLIARD_ROOM, Location.valueOf("BILLIARD_ROOM"));
		
	}
}
