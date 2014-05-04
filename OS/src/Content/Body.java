package Content;

import kernel.Memory;
import Stream.*;
import System.BIOS;
import Video.Display;
import Video.VidPos;

public class Body 
{

	public static final int MODE = 1;
	
	public static int fg = Colors.black;
	public static int bg = Colors.white;	
	public static Color col;
	public static Color colCompl;	
	public static int pos = 80;
	public static int start = 80;
	public static int end = 1840;

	public static void init()
	{
		col.setColor(bg, fg);
		colCompl.setColor(fg, bg);	
	}
	
	public static void cls()
	{
		Out.putMode(MODE);
		Screen.clear();
	}
	
	public static void frame(String str)
	{
		Out.putMode(MODE);
		Out.print(str);
	}
	
	public static void frame(int i)
	{
		Out.putMode(MODE);
		Out.print(i);
	}
	
	public static void frame(long l)
	{
		Out.putMode(MODE);
		Out.print(l);
	}
	
	public static void frameHex(long l)
	{
		Out.putMode(MODE);
		Hex.print(l);
	}
	
	public static void frameHex(int i)
	{
		Out.putMode(MODE);
		Hex.print(i);
	}
	
	public static void frame_01(String str)
	{
		
	}

	public void frame_02(String str)
	{
		
	}
		
	public void frame_03(String str)
	{
		
	}

	public void frame_04(String str)
	{
		
	}
	
	public static void ret()
	{
		Output.putMode(MODE);
		Cursor.set(-1, 0);
		Out.print("  ");
		Cursor.set(-2, 0);	
	}
	
	public static void newLine()
	{
		Output.putMode(MODE);
		Output.putNewLine(); // Function Enter

	}

	public static void Up()
	{
		Output.putMode(MODE);
		Cursor.set(0, 1);

	}
	public static void Right()
	{
		Output.putMode(MODE);
		Cursor.set(1, 0);

	}
	public static void Left()
	{
		Output.putMode(MODE);
		Cursor.set(-1, 0);

	}
	public static void Down()
	{
		Output.putMode(MODE);
		Cursor.set(0, 1);
	}
	
	public static void Space()
	{
		Output.putMode(MODE);
		Output.putSpace();
	}
	
	public static void Pos1()
	{
		Output.putMode(MODE);
		Output.putPos1();
	}
	
	public static void entf()
	{
		Output.putMode(MODE);
		Output.removeChar();
	}
	
	public static void printMem()
	{
		Output.putMode(MODE);
		
		int i = 3;
		int type;
		long base;
		long leng;
		int startAdd = Memory.MEMORY_MAP_ADDRESS;
		
		BIOS.regs.EBX=0x00;
		do
		{
		BIOS.regs.EAX=0x0000E820;
		BIOS.regs.EDX=0x534D4150;
		BIOS.regs.ECX=0x14;
		BIOS.regs.ES=0x0;
		BIOS.regs.EDI=startAdd;
		BIOS.rint(0x15);
		base = MAGIC.rMem64(startAdd);
		leng = MAGIC.rMem64(startAdd+8);
		type = MAGIC.rMem32(startAdd+16);
		if(type == 1)
		{
		Output.putColor(Colors.white, Colors.green);
		Output.setCursor(0, i);
		Output.printHex(base);
		Output.setCursor(20, i);
		Output.printHex(leng);
		Output.setCursor(40, i);
		Output.printHex(type);
		Output.setCursor(60, i);
		Output.printHex(BIOS.regs.EBX);
		}
		if(type == 2)
		{
		Output.setMode(Display.BodyMode);
		Output.setCursorAbs(0, i);
		Output.setColor(Colors.white, Colors.red);
		Output.printHex(base);
		Output.setCursor(20, i);
		Output.printHex(leng);
		Output.setCursor(40, i);
		Output.printHex(type);
		Output.setCursor(60, i);
		Output.printHex(BIOS.regs.EBX);
		}
		i++;
		}
		while(BIOS.regs.EBX!=0x00);
	}
		
	}
		
}
