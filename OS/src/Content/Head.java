package Content;

import Stream.*;

public class Head 
{
	public static final int MODE = 0;
	
	private static final int width = 20;
	
	public static int fg = Colors.black;
	public static int bg = Colors.white;	
	public static Color col;
	public static Color colCompl;	
	public static int pos = 0;
	public static int start = 0;
	public static int end = 80;

	public static void init()
	{
		col.setColor(bg, fg);
		colCompl.setColor(fg, bg);	
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

	public static void frame_02(String str)
	{
		Output.putMode(MODE);
		Cursor.setAbs(20, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(20, 0);
		Out.print(str);
	}
		
	public static void frame_03(String str)
	{
		Output.putMode(MODE);
		Cursor.setAbs(40, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(40, 0);
		Out.print(str);
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
