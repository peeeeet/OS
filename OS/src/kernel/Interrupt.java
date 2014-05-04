package kernel;

import map.RingBuffer;
import Stream.Colors;
import Stream.Output;
import Stream.Grafic;
import Video.Display;
import Video.VidMem;
import rte.DynamicRuntime;
import devices.Keyboard;


public class Interrupt {
private final static int MASTER = 0x20;
private final static int SLAVE = 0xA0;

private static int curAdd = 0;
private static int mask = 0x8E00; // 1000 1110 0000 0000
public static int count=0;
private static RingBuffer buffer;
private static Keyboard key;
private static boolean trigCol = false;



public static void init()
{
	// Aktuelle Addresse initialisieren
	curAdd = Memory.INTERRUPT_TABLE_ADDRESS;
	// Initialisiere PIC
	initPic();
	// Tabelle zusammenbauen
	buildIntTable();
	// Exception Descriptor Table laden
	loadDescTable(1);	
}

public static void activate()
{
	// Ring Buffer
	buffer = new RingBuffer();
	// Keyboard
	key = new Keyboard();
	// Buffer und Keyboard initialisieren
	buffer.init();
	activateInterrupts();
}

public static void buildIntTable()
{
int seg = 0x08;

// Codestart Methode Interrupt Handler1
int m00, m01, m02, m03, m04, m05, m06, m07, m08, m09, m13, m14, m15, m32, m33, m34;

// Divide Error
m00 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx00" ))+MAGIC.getCodeOff();
buildEntry(seg,m00);
// Debug Exception
m01 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx01" ))+MAGIC.getCodeOff();
buildEntry(seg,m01);
// NMI
m02 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx02" ))+MAGIC.getCodeOff();
buildEntry(seg,m02);
// Breakpoint
m03 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx03" ))+MAGIC.getCodeOff();
buildEntry(seg,m03);
// INTO Overflow
m04 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx04" ))+MAGIC.getCodeOff();
buildEntry(seg,m04);
// Index out of Range
m05 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx05" ))+MAGIC.getCodeOff();
buildEntry(seg,m05);
//Invalid Opcode
m06 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx06" ))+MAGIC.getCodeOff();
buildEntry(seg,m06);
//Reserviert
m07 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx07" ))+MAGIC.getCodeOff();
buildEntry(seg,m07);
//Double Fault
m08 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx08" ))+MAGIC.getCodeOff();
buildEntry(seg,m08);
//Reserviert
m09 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx09" ))+MAGIC.getCodeOff();
for(int i = 9; i < 13;i++)
	buildEntry(seg,m09);
//General Protection Error
m13 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx13" ))+MAGIC.getCodeOff();
buildEntry(seg,m13);
//Page Fault
m14 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx14" ))+MAGIC.getCodeOff();
buildEntry(seg,m14);
//Reserviert
m15 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx15" ))+MAGIC.getCodeOff();
for(int i = 15; i < 32;i++)
	buildEntry(seg,m15);
//Timer
m32 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx32" ))+MAGIC.getCodeOff();
buildEntry(seg,m32);
//Tastatur
m33 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx33" ))+MAGIC.getCodeOff();
buildEntry(seg,m33);
//Weitere
m34 = MAGIC.rMem32(MAGIC.cast2Ref(MAGIC.clssDesc("Interrupt"))+MAGIC.mthdOff("Interrupt","HandlerEx34" ))+MAGIC.getCodeOff();
for(int i = 34; i < 48;i++)
	buildEntry(seg,m34);
	
}

public static void buildEntry(int seg, int offset)
{
	int val = seg << 16;
	
	MAGIC.wMem32(curAdd,(offset & 0x0000FFFF) | val);
	curAdd +=4;
	
	MAGIC.wMem32(curAdd,(offset & 0xFFFF0000) | mask );
	curAdd +=4;
}

public static void initPic()
{
	programmChip(MASTER,0x20,0x04);
	programmChip(SLAVE,0x28,0x02);
}
	
private static void programmChip(int port, int offset, int icw3)
{
	MAGIC.wIOs8(port++, (byte)0x11); // ICW1
	MAGIC.wIOs8(port, (byte)offset); // ICW2
	MAGIC.wIOs8(port, (byte)icw3);	// ICW3
	MAGIC.wIOs8(port, (byte)0x01);	// ICW4
}

private static void activateInterrupts()
{
MAGIC.inline(0xFB);
}

private static void deactivateInterrupts()
{
MAGIC.inline(0XFA);	
}

public static void loadDescTable(int mode)
{
	long tmp = (long)1023;
	if(mode ==0)	// RealMode
	{
		tmp = (long)1023;
	}
	else if(mode ==1) // Protect Mode
	{
	tmp = (((long)Memory.INTERRUPT_TABLE_ADDRESS)<<16)|(long)Memory.INTERRUPT_TABLE_SIZE;
	}
	MAGIC.inline(0x0F, 0x01, 0x5D);
	MAGIC.inlineOffset(1, tmp);
}

private static void confirmMAInterrupt()
{
	MAGIC.wIOs8(MASTER, (byte)0x20);
}

private static void confirmSLInterrupt()
{
	MAGIC.wIOs8(SLAVE, (byte)0x20);
}

@SJC.Interrupt
public static void HandlerEx00()
{
	Content.Foot.frame_01("Divide Error");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx01()
{
	Content.Foot.frame_01("Debug Exc");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx02()
{
	Content.Foot.frame_01("NMI");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx03()
{
	Content.Foot.frame_01("Breakpoint");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx04()
{
	Content.Foot.frame_01("INTO");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx05()
{
	Content.Foot.frame_01("Idx out of Range");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx06()
{
	Content.Foot.frame_01("Invalid Opcode");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx07()
{
	Content.Foot.frame_01("Reserviert");
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx08(int x)
{
	Content.Foot.frame_01("Double Fault");
	confirmSLInterrupt();
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx09(int x)
{
	Content.Foot.frame_01("Double Fault");
	confirmSLInterrupt();
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx13(int x)
{
	Content.Foot.frame_01("General Protection Error");
	confirmSLInterrupt();
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx14(int x)
{
	Content.Foot.frame_01("Page Fault");
	confirmSLInterrupt();
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx15(int x)
{
	Content.Foot.frame_01("Reserviert");
	confirmSLInterrupt();
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx32()
{
	
	if(buffer.getCount()>0)
	{
			key.decodInput((buffer.getCode()));	
	}
	else
	{
		// Courser Trigger
		
		if(count == 1)
		{
			//Output.triggerCursor();
		}

	}

	Content.Head.frame_02("P");

	//Output.print(buffer.getPos());
	Content.Head.frame_03("R");
	//Output.print(buffer.getreadPos());
	


	//count ++;
	
	confirmSLInterrupt();
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx33()
{
	
	byte val;
	Content.Foot.frame_01("Keyboard");
	val = MAGIC.rIOs8(0x60);
	
	//Content.Foot.frame_02(val);
	
	buffer.add(val);
	
	confirmSLInterrupt();
	confirmMAInterrupt();
}

@SJC.Interrupt
public static void HandlerEx34()
{
	Content.Foot.frame_01("Weitere");
	confirmSLInterrupt();
	confirmMAInterrupt();
}

}
