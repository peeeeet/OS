package kernel;
import Stream.Grafic;
import Stream.Out;
import Stream.Output;
import Stream.Colors;
import System.BIOS;
import Video.Display;
import Video.VidMem;
import Content.*;
import Control.*;
import devices.Keyboard;
public class Kernel {
	

	public static void main()
	{
		// Bildschirmbereiche initialisieren
		Head.init();
		Body.init();
		Foot.init();
		
		// Bildschirmbereiche clear
		Head.cls();
		Body.cls();
		Foot.cls();
		
		// Speicherverwaltung initialisieren
		Memory.Manager.init();		
		// Interrupt initialisieren
		Interrupt.init();
		// VGA Modus
	    Display.vgaMode();
		// Bios Screen
		Grafic.biosScreen();
		// Text Modus
		Display.textMode();
		// Aktiviere Interrupts
		Interrupt.activate();
		
		Scheduler.init();
		
		int mth = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Body"))+MAGIC.mthdOff("Body","frame_01"))+MAGIC.getCodeOff();
		Task task1 = new Task(1,"Body","frame_01",mth);
		mth = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Body"))+MAGIC.mthdOff("Body","printMem"))+MAGIC.getCodeOff();
		Task task2 = new Task(2,"Body","printMem",mth);
		Scheduler.addTask(task1);
		Scheduler.addTask(task2);
		Scheduler.run();
			
	}
}
	

