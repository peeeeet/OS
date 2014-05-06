package Memory;

import rte.SClassDesc;

public class EmptyObject 
{
	/*
	  public static Object newEmptyObj(int scalarSize, int relocEntries, int startAddress) 
  	  {	
		// Variablen
		  int memsize;
		  int nextFreeAddress;

		  // Groesse berechnen
		  memsize = scalarSize + relocEntries * 4;
		  
		  // Auf 4Byte Alignieren
		  while(memsize % 4 != 0) memsize++;
		  
		  // Speicherbereich festlegen
		  nextFreeAddress += memsize;
		  
		  // Speicherbereich initialisieren
		  for(int i=startAddress; i<nextFreeAddress; i+=4) 
			  {
			  MAGIC.wMem32(i, 0);
			  }
		  
		  // Object Variable initialisieren
		  Object obj;
		  obj = MAGIC.cast2Obj(startAddress+relocEntries*4);
		  
		  // Ref und Scalar Größen im Obj speichern
		  MAGIC.assign(obj._r_scalarSize , scalarSize); 
		  MAGIC.assign(obj._r_relocEntries , relocEntries);
		  MAGIC.assign(obj._r_type , type);
		  
		  // Nächstes Objekt
		  MAGIC.assign(lastObj._r_next, obj);
		  // letztes Objekt speichern
		  lastObj = obj;
		  
		  return obj;
  	  }
  	  */
}
