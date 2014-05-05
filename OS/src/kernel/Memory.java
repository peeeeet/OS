package kernel;

public class Memory 
{

	public final static int INTERRUPT_TABLE_ADDRESS = 0x7E00;	// Nach Bootstrap-Code
	public final static int INTERRUPT_TABLE_SIZE = 48*8-1;		// Größe der Tabelle
	public final static int MEMORY_MAP_ADDRESS = 0x7F80;		// 0x7E00 + 48*8
	public final static int VIDEO = 0xB8000;					// Video Start Adresse;
	public final static int STACK_START_ADDRESS = 0x9BFFC;		// Stack Start Addresse
	
	public static int getFreeAddress()
	{
		int add = 0;
		// Berechnen anhand der Größen neue Startaddresse
		add = MAGIC.imageBase + MAGIC.rMem32(MAGIC.imageBase + 4);
		// Auf 4Byte Alignieren
		while(add % 4 != 0) add++;
		
		return add;
		
	}
	
}
