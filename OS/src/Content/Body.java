package Content;

import kernel.Memory;
import Stream.*;
import System.BIOS;
import Video.Display;

public class Body 
{

	public static final int MODE = 1;
	
	public static int fg = Colors.black;
	public static int bg = Colors.white;	
	public static byte color;
	public static byte colorCompl;	
	public static int pos = 80;
	public static int start = 80;
	public static int end = 1840;

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
	
	public static void blueScreen()
	{
		color = Color.getColor(Colors.white, Colors.blue);
		Output.putMode(MODE);	
		Screen.clear();
	}
	
	public static void frame(String str)
	{
		Output.putMode(MODE);
		Out.print(str);
	}
	
	public static void frame(int i)
	{
		Output.putMode(MODE);
		Out.print(i);
	}
	
	public static void frame(long l)
	{
		Output.putMode(MODE);
		Out.print(l);
	}
	
	public static void frameHex(long l)
	{
		Output.putMode(MODE);
		Hex.print(l);
	}
	
	public static void frameHexTable(int num, int i)
	{

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
	
	
	public static void printPushA()
	{
		Output.putMode(MODE);
		int ebp=0;
		int val;
		MAGIC.inline(0x89, 0x6D); 
		MAGIC.inlineOffset(1, ebp); //mov [ebp+xx],ebp
		
		// Ebp Addresse
		// Erste PUSHA Adresse EDI
	    ebp+=4;


	    Line.println(" ");
	    Out.print("                   ");
		Line.println("Breakpoint O_O");
		
		Out.print("                   ");
		Out.print(1);
		Out.print("      ");
		Out.print("EDI");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));	
		ebp += 4;
		Line.println("");
		
		Out.print("                   ");
		Out.print(2);
		Out.print("      ");
		Out.print("ESI");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));	
		ebp += 4;
		Line.println("");
		
		Out.print("                   ");
		Out.print(3);
		Out.print("      ");
		Out.print("EBP");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));	
		ebp += 4;
		Line.println("");
		
		Out.print("                   ");
		Out.print(4);
		Out.print("      ");
		Out.print("ESP");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));	
		ebp += 4;
		Line.println("");
		
		Out.print("                   ");
		Out.print(5);
		Out.print("      ");
		Out.print("EBX");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));	
		ebp += 4;
		Line.println("");
		
		Out.print("                   ");
		Out.print(6);
		Out.print("      ");
		Out.print("EDX");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));
		ebp += 4;
		Line.println("");
		
		Out.print("                   ");
		Out.print(7);
		Out.print("      ");
		Out.print("ECX");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));
		ebp += 4;
		Line.println("");
		
		Out.print("                   ");
		Out.print(8);
		Out.print("      ");
		Out.print("EAX");
		Out.print("      ");
		Hex.print(MAGIC.rMem32(ebp));
		ebp += 4;
		Line.println("");
		
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
		
		Cursor.setAbs(0, 2);
		Out.print("BASE");
		Cursor.setAbs(20, 2);
		Out.print("LENGTH");
		Cursor.setAbs(40, 2);
		Out.print("TYPE");
		Cursor.setAbs(60, 2);
		Out.print("EBX");
		
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
		Output.setColor(Colors.green, Colors.white);
		Cursor.setAbs(0, i);
		Hex.print(base);
		Cursor.setAbs(20, i);
		Hex.print(leng);
		Cursor.setAbs(40, i);
		Hex.print(type);
		Cursor.setAbs(60, i);
		Hex.print(BIOS.regs.EBX);
		}
		if(type == 2)
		{
		Output.setColor(Colors.red, Colors.white);
		Cursor.setAbs(0, i);
		Hex.print(base);
		Cursor.setAbs(20, i);
		Hex.print(leng);
		Cursor.setAbs(40, i);
		Hex.print(type);
		Cursor.setAbs(60, i);
		Hex.print(BIOS.regs.EBX);
		}
		if(type > 2 || type < 1)
		{
		Cursor.setAbs(0, i);
		Output.setColor(Colors.organge,Colors.white);
		Hex.print(base);
		Cursor.setAbs(20, i);
		Hex.print(leng);
		Cursor.setAbs(40, i);
		Hex.print(type);
		Cursor.setAbs(60, i);
		Hex.print(BIOS.regs.EBX);
		}
		i++;
		}
		while(BIOS.regs.EBX!=0x00);
	}
		
}
		

