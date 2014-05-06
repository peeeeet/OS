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

		// VGA Modus
	    Display.vgaMode();
		//	 Bios Screen
		Grafic.biosScreen();
		// Text Modus
		Display.textMode();
		
		//Display & Interrupt init
		Interrupt.init();	
		Interrupt.activate();
		
		// Bildschirmbereiche initialisieren
		Head.init();
		Body.init();
		Foot.init();
		// Bildschirmbereiche clear
		Head.cls();
		Body.cls();
		Foot.cls();
		// Print Mem
		Body.printMem();
		
		
				
	}
	
}
	

