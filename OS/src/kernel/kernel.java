package kernel;
import Stream.Grafic;
import Stream.Out;
import Stream.Output;
import Stream.Colors;
import System.BIOS;
import Video.Display;
import Video.VidMem;
public class Kernel {
	
private static Interrupt INTController;
private static int count = 0;

	public static void main()
	{
		
		// VGA Modus
		Display.vgaMode();
		// Bios Screen
		Grafic.biosScreen();
		// Text Modus
		Display.textMode();
		// Clear Screen
		//Output.directclearScreen(0, Colors.black);
		//Output.directclearScreen(1, Colors.white);
		//Output.directclearScreen(2, Colors.black);
		
		//Display & Interrupt init
		Interrupt.init();	
		Display.init();
		//Interrupt.activate();
		
		//4c
		//getMemoryMap();
		
		Content.Head.cls();
		Content.Body.cls();
		Content.Foot.cls();
		
		
		Interrupt.activate();
		
	}
	
	private static void getMemoryMap()
	{
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
		Output.setMode(Display.BodyMode);
		Output.setColor(Colors.white, Colors.green);
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
