/*
 * An enumeration of all possible GamePiece shapes
 */
enum Shape
{
	BOOT, RACECAR, THIMBLE;
	
	public String toString()
	{
		return this.name().toLowerCase();
	}
}

/*
 * An enumeration of all possible GamePiece colors, represented with RBG values.
 */
enum Color
{
	BLUE(0,0,255), CYAN(0,255,255), GREEN(0,255,0), MAGENTA(255,0,255), RED(255,0,0), YELLOW(255,255,0);
	
	private int r;
	private int g;
	private int b;
	
	private Color(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public int getR()
	{
		return r;
	}
	
	public int getG()
	{
		return g;
	}
	
	public int getB()
	{
		return b;
	}
}

/*
 * A class describing the appearance of one GamePiece, with one shape and one color.
 */
public class GamePieceAppearance
{
	private Color color;
	private Shape shape;
	
	public GamePieceAppearance(Color color, Shape shape)
	{
		this.color = color;
		this.shape = shape;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public Shape getShape()
	{
		return shape;
	}
}
