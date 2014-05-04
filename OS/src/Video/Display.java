package Video;

import Stream.Color;
import Stream.Colors;
import System.BIOS;

public class Display {

public static final int HeadMode = 0;
public static final int BodyMode = 1;
public static final int FootMode = 2;

public static VidPos posHead;
public static VidPos posBody;
public static VidPos posFoot;

public static Color colHead;
public static Color colBody;
public static Color colFoot;

public static Color colComplHead;
public static Color colComplBody;
public static Color colComplFoot;

public static void init()
{
	colHead.setColor(Colors.green, Colors.black);
	colBody.setColor(Colors.black, Colors.white);
	colFoot.setColor(Colors.green, Colors.black);
	
	colComplHead.setColor(Colors.black, Colors.green);
	colComplBody.setColor(Colors.white, Colors.black);
	colComplFoot.setColor(Colors.black, Colors.green);
	
}

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
