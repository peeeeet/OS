package Content;

import Stream.Colors;
import Stream.Output;
import Video.Display;
import Stream.*;

public class Foot 
{
	
	
	private static final int width = 20;
	public static int fg = Colors.green;
	public static int bg = Colors.black;
	
	
	public static void cls()
	{
		Output.setMode(Display.FootMode);
		Screen.clear(bg);
	}
	
	
	public static void frame_01(String str)
	{
		Output.setMode(Display.FootMode);
		Cursor.setCursorAbs(0, 0);
		
		for(int i = 0; i < width; i++)
			Print.print(" ");
		
		Cursor.setCursorAbs(0, 0);
		Print.print(str);		
	}

	public static void frame_02(String str)
	{
		Output.setMode(Display.FootMode);
		Cursor.setCursorAbs(20, 0);
		
		for(int i = 0; i < width; i++)
			Print.print(" ");
		
		Cursor.setCursorAbs(20, 0);
		Print.print(str);
	}
		
	public static void frame_03(String str)
	{
		Output.setMode(Display.FootMode);
		Cursor.setCursorAbs(40, 0);
		
		for(int i = 0; i < width; i++)
			Print.print(" ");
		
		Cursor.setCursorAbs(40, 0);
		Print.print(str);
	}

	public static void frame_04(String str)
	{
		Output.setMode(Display.FootMode);
		Cursor.setCursorAbs(60, 0);
		
		for(int i = 0; i < width; i++)
			Print.print(" ");
		
		Cursor.setCursorAbs(60, 0);
		Print.print(str);
	}
	
	
}
/*
 * 
 * AUSAGABE Timer
Output.setMode(Display.FootMode);
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
