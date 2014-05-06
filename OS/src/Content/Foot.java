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
	private static boolean trigCol = false;
	private static int count = 0;
	private static int s = 0;
	private static int m = 0;
	private static int h = 0;

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

	public static void frame_02(int val)
	{
		Output.putMode(MODE);
		Cursor.setAbs(20, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(20, 0);
		Hex.print(val);
	}
		
	public static void frame_03(int val)
	{
		Output.putMode(MODE);
		Cursor.setAbs(40, 0);
		
		for(int i = 0; i < width; i++)
			Out.print(" ");
		
		Cursor.setAbs(40, 0);
		Out.print("ARRAY Lenght: ");
		Hex.print(val);
	}

	public static void frame_04_Timer()
	{
		Output.putMode(MODE);
		Cursor.setAbs(60, 0);
		
		if(s<60)
		{
			s+=1;
		}
		else
		{
			m+=1;
			s=0;
		}
		if(m>60)
		{
			h+=1;
			m=0;
		}
		
		Out.print(h);
		Out.print(" : ");
		Out.print(m);
		Out.print(" : ");
		Out.print(s);
		Out.print("  ");
		
		if(count == 4)
			Out.print("+   ");
		if(count == 8)
			Out.print("++  ");
		if(count == 12)
			Out.print("+++ ");
		if(count == 16 )
		{
			Out.print("++++");
			count = 0;
		}

		count++;
	}
	
	
}
