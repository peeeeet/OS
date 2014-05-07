package Application;

import devices.Keyboard;
import Stream.Color;
import Stream.Colors;
import Stream.Cursor;
import Stream.Out;
import Stream.Output;
import Stream.Screen;
import Content.*;
public class Editor 
{
	public static int cursor = 80;
	public static int fg = Colors.white;
	public static int bg = Colors.green;
	
	
	public static void run()
	{
		String val = Keyboard.handleInput();
		Body.setframe1();
		Screen.setColor(Color.getColor(fg, bg));
		Out.print(val);		
		Body.setWhole();	
	}

	
	public static void ret()
	{
		Body.setframe1();
		Cursor.set(-1, 0);
		Out.print("  ");
		Cursor.set(-2, 0);	
		Body.setWhole();
	}
	
	public static void newLine()
	{
		Body.setframe1();
		Output.putNewLine(); // Function Enter
		Body.setWhole();

	}

	public static void Up()
	{
		Body.setframe1();
		Cursor.set(0, 1);
		Body.setWhole();

	}
	public static void Right()
	{
		Body.setframe1();
		Cursor.set(1, 0);
		Body.setWhole();

	}
	public static void Left()
	{
		Body.setframe1();
		Cursor.set(-1, 0);
		Body.setWhole();

	}
	public static void Down()
	{
		Body.setframe1();
		Cursor.set(0, 1);
		Body.setWhole();
	}
	
	public static void Space()
	{
		Body.setframe1();
		Output.putSpace();
		Body.setWhole();
	}
	
	public static void Pos1()
	{
		Body.setframe1();
		Output.putPos1();
		Body.setWhole();
	}
	
	public static void entf()
	{
		Body.setframe1();
		Output.removeChar();
		Body.setWhole();
	}
	
}
