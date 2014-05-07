package kernel;
import Stream.Grafic;
import Stream.Out;
import Stream.Output;
import Stream.Colors;
import System.BIOS;
import System.GarbageCollection;
import Video.Display;
import Video.VidMem;
import Content.*;
import Control.*;
import devices.Keyboard;
import Application.*;
import System.Handler;
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
		/*
		Scheduler.init();
		
		// Prio 2 Editor Programm
		int mth = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Editor"))+MAGIC.mthdOff("Editor","run"))+MAGIC.getCodeOff();
		Task task1 = new Task(1,"Editor","run",mth,2);
		// Prio 1 Systemhandler
		mth = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Handler"))+MAGIC.mthdOff("Handler","keyboard"))+MAGIC.getCodeOff();
		Task task2 = new Task(2,"Body","printMem",mth,1);
		*/
		Out out = new Out();
		Out out2 = new Out();
		devices.Test t = new devices.Test();
		
		devices.Test t2 = new devices.Test();

		Body.frameHex(MAGIC.cast2Ref(out));		
		Body.frameHex(MAGIC.cast2Ref(out2));
		Body.frameHex(MAGIC.cast2Ref(t));	
		Body.frameHex(MAGIC.cast2Ref(t2));	
		GarbageCollection.run();
		
		
		out = null;		
		out = null;
		out2 = null;
		t = null;
		t2 = null;
		
		int l = t.cal();
		Out.print(l);
		GarbageCollection.run();
		
		
		//Scheduler.addTask(task1);
		//Scheduler.addTask(task2);
		//Scheduler.run();
		
		
			
	}
}
	

