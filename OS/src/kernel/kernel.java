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
		//Interrupt.activate();
		
		//4c
		//getMemoryMap();
		
		Content.Head.cls();
		Content.Body.cls();
		Content.Foot.cls();
		
		
		Interrupt.activate();
		
	}
	
}
	

