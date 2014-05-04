package Video;

import System.BIOS;

public class Display {



private Display(){}
		
public static void vgaMode()
{
	BIOS.regs.EAX=0x0013;
	BIOS.rint(0x10);	
}
	
public static void textMode()
{
	BIOS.regs.EAX=0x0003;
	BIOS.rint(0x10);
}

}
