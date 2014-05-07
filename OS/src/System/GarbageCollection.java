package System;

import Content.Body;

public class GarbageCollection 
{

	public static void run()
	{
		int i = 0;
		int q = 0;
		int start = 0;
		Object o = rte.DynamicRuntime.getFirstObj();
		while(o._r_next != null)
		{
			/*
			Body.frameHexTable(o._r_relocEntries, o._r_scalarSize, MAGIC.cast2Ref(o._r_type), MAGIC.cast2Ref(o), MAGIC.cast2Ref(o._r_next));
			
			start = MAGIC.cast2Ref(o);
			start -=8;
			for(int j=0; j < o._r_relocEntries; j++)
			{
				start -=4;
				start = MAGIC.rMem32(start);
				Body.frameHex(start);			
			}*/
			i++;
			if(o != null)
				mark(o);
			else
				unmark(o);
			
			Body.frameHexTable(o._r_relocEntries, o._r_scalarSize, MAGIC.cast2Ref(o._r_type), MAGIC.cast2Ref(o), MAGIC.cast2Ref(o._r_next), o.marked);	
			
			o = o._r_next;	
						
		}
		if(o != null)
			mark(o);
		else
			unmark(o);
		
		Body.frameHexTable(o._r_relocEntries, o._r_scalarSize, MAGIC.cast2Ref(o._r_type), MAGIC.cast2Ref(o), MAGIC.cast2Ref(o._r_next), o.marked);
		/*
		Body.frameHexTable(o._r_relocEntries, o._r_scalarSize, MAGIC.cast2Ref(o._r_type), MAGIC.cast2Ref(o), MAGIC.cast2Ref(o._r_next));
		start = MAGIC.cast2Ref(o);
		start -=8;
		for(int j=0; j < o._r_relocEntries; j++)
		{
			start -=4;
			start = MAGIC.rMem32(start);
			Body.frameHex(start);			
		}
		i++;
	*/
	
	}

	public static void mark(Object o)
	{
			
		if(!o.marked)
		{
			o.marked = true;
			
		}
		
	}
	
	public static void unmark(Object o)
	{
				
		if(o.marked)
		{
			o.marked = false;			
		}
		
	}
	
	public static void sweep()
	{
		
		
	}

	
}
