package Content;

import Stream.Color;
import Stream.Colors;
import Stream.Output;
import Video.Display;

import Stream.*;

public class Foot 
{
	public static final int MODE = 2;
	
	private static final int width = 20;
	
	public static int fg = Colors.green;
	public static int bg = Colors.black;	
	public static byte color;
	public static byte colorCompl;	
	public static int pos = 1840;
	public static int start = 1840;
	public static int end = 2000;

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
/*
 * 
 * AUSAGABE Timer
Output.putMode(MODE);
Output.setCursorAbs(76, 0);
if(count == 1)
	Output.print(" ");
if(count == 3)
	Output.print("  ");
if(count == 5)
	Output.print("   ");
if(count == 7 )
{
	Output.print("    ");
	count = 0;
}
if(count == 0)
{
	if(trigCol)
	{
	Output.setAreaColor(75,79,0,0,Colors.white, Colors.green);
	trigCol = false;
	}
	else
	{
		Output.setAreaColor(75,79,0,0,Colors.white, Colors.black);
		trigCol = true;
	}
}
*/
