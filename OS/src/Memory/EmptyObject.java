package Memory;

import Content.Body;
import Content.Head;
import rte.DynamicRuntime;
import rte.SClassDesc;

public class EmptyObject extends SClassDesc
{
	
	
	 public static void create(int scalarSize)
	 {
	  // Variablen
	  int memsize;
	  int startAddress;
	  int nextFreeAddress = 0;
	  
	  // Startaddresse
	  startAddress = Memory.Manager.START_ADDRESS;

	  // Groesse berechnen

	  memsize = scalarSize;
	  
	  // Auf 4Byte Alignieren
	  while(memsize % 4 != 0) memsize++;
	  
	  // Speicherbereich festlegen
	  nextFreeAddress += memsize;
	  Head.frame_01("Init EmptyObj");
	  // Speicherbereich initialisieren
	  for(int i=startAddress; i<nextFreeAddress; i+=4) 
		  {
		  MAGIC.wMem32(i, 0);
		  }
	  
	  // Object Variable initialisieren
	  Object obj;
	  obj = MAGIC.cast2Obj(startAddress);
	  
	  // Ref und Scalar Größen im Obj speichern
	  MAGIC.assign(obj._r_scalarSize , scalarSize); 
	  //MAGIC.assign(obj._r_relocEntries , relocEntries);
	  //MAGIC.assign(obj._r_type , type);
	  
	  // Nächstes Objekt
	  //MAGIC.assign(lastObj._r_next, obj);
	  // letztes Objekt speichern
	  //lastObj = obj;
	  
	 // return obj;
	 }


}
