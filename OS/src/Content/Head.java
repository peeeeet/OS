package Content;

import Stream.*;

public class Head 
{
	public static final int MODE = 0;
	
	private static final int width = 20;
	
	public static int fg = Colors.green;
	public static int bg = Colors.black;	
	public static byte color;
	public static byte colorCompl;	
	public static int pos = 0;
	public static int start = 0;
	public static int end = 80;

	public static void init()
	{
		color = Color.getColor(fg, bg);
		colorCompl= Color.getColor(bg, fg);	
	}
	
public static void cls()
{
	Output.putMode(MODE);
	Screen.clear();
}
	
	public static void frame_01(String str)
	{
		Output.putMode(MODE);
		Cursor.setAbs(0, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(0, 0);
		Out.print(str);		
	}

	public static void frame_02(String str, int pos)
	{
		Output.putMode(MODE);
		Cursor.setAbs(20, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(20, 0);
		Out.print(str);
		Out.print("  ");
		Out.print(pos);
	}
		
	public static void frame_03(String str,int pos)
	{
		Output.putMode(MODE);
		Cursor.setAbs(40, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(40, 0);
		Out.print(str);
		Out.print("  ");
		Out.print(pos);
	}

	public static void frame_04Hex(String str, int val)
	{
		Output.putMode(MODE);
		Cursor.setAbs(60, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(60, 0);
		Out.print(str);
		Hex.print(val);

	}
	
	public static void frame_04(String str, int val)
	{
		Output.putMode(MODE);
		Cursor.setAbs(60, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(60, 0);
		Out.print(str);
		Out.print(val);

	}
	
	public static void frame_04(String str)
	{
		Output.putMode(MODE);
		Cursor.setAbs(60, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(60, 0);
		Out.print(str);

	}
	
}
