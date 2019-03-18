enum Shape
{
	BOOT, RACECAR, THIMBLE;
	
	public String toString()
	{
		return this.name();
	}
}

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

public class GamePieceAppearance
{

}
