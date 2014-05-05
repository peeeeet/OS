package kernel;
import Stream.Grafic;
import Stream.Out;
import Stream.Output;
import Stream.Colors;
import System.BIOS;
import Video.Display;
import Video.VidMem;
import Content.*;
public class Kernel {
	
private static Interrupt INTController;
private static int count = 0;

	public static void main()
	{
		// Initialisiere für New Instance
		rte.DynamicRuntime.init();
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
		Head.init();
		Body.init();
		Foot.init();
		//4c

		
		Head.cls();
		Body.cls();
		Foot.cls();
		
		//Body.printMem();
				
		Interrupt.activate();
		
	}
	
}
	

