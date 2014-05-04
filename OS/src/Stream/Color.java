package Stream;

public class Color {
	
private static int fg = 0x00;
private static int bg = 0x00;

public Color(int _fg,int _bg)
{
	fg = _fg;
	bg = _bg;
}

public void setColor(int _fg,int _bg)
{
	fg = _fg;
	bg = _bg;
}

public byte col()
{
	return getColor(fg,bg);
}

public static byte getColor(int fg, int bg)
{
	  int color = bg;
	    // Color
	    // Set 4-6 Bits
	    color = color << 4;
	    // Set 0-2 Bits
	    color = color | fg;
	  
	  return (byte)color;
}

}
