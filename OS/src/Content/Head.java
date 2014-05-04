package Content;

import Stream.Colors;
import Stream.Cursor;
import Stream.Output;
import Stream.Print;
import Stream.Screen;
import Video.Display;

public class Head 
{

private static final int width = 20;
public static int fg = Colors.green;
public static int bg = Colors.black;


public static void cls()
{
	Output.setMode(Display.HeadMode);
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
