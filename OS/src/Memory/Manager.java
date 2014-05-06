package Memory;

import Content.Body;
import Content.Foot;
import System.BIOS;

public class Manager 
{

	public static int START_ADDRESS = 0;
	public static int START_LENGTH = 0;
	public static int count = 1;

	
	public static void init()
	{
		// Überprüft alle Speicherbereiche und wählt den größten für NewInstance
		checkMemory();
		// Erstellt Empty Object
		alloc(0);
	}
	
	private static void checkMemory()
	{
	
		int type;
		long base;
		long leng;
		int startAdd = Const.MEMORY_MAP_ADDRESS;
		
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
				if(base <= Const.getFreeAddress() && base > 0)
				{
					START_ADDRESS = (int)base + MAGIC.rMem32(MAGIC.imageBase + 4);
					START_LENGTH = (int)leng - MAGIC.rMem32(MAGIC.imageBase + 4) - 1024;
					Foot.frame_03(START_ADDRESS);
				}
			}
		}
		while(BIOS.regs.EBX!=0x00);
		
	}
	
	public static int alloc(int size)
	{
		// Berechne neue größe des Empty Object
		START_LENGTH -= size;
		Body.frameTable(count, START_LENGTH);
		count ++;
		// Erzeuge neues Empty Object
				EmptyObject.create(START_LENGTH);
				
		// Berechne Startadresse des neuen Objekts
		return (START_ADDRESS + START_LENGTH);
				
	}
}
