package Control;

import Content.Foot;
import Content.Head;
import kernel.Interrupt;

public class Scheduler 
{
private static int NUM_TASKS=10;
private static int count = 0;
private static Task[] tasks;
public static boolean start = true;
public static boolean run = true;

public static void init()
{
	tasks = new Task[NUM_TASKS];	
}

public static void addTask(Task task)
{
	if(count < NUM_TASKS)
	{
		tasks[count++] = task;
	}
}

public static void removeTask(int id)
{
	boolean idAvailable = false;
	int j = 0;
	
	// Alle Tasks nach Id durchsuchen
	// Wenn vorhanden dann set idAvailable true
	for(int i = 0;i<NUM_TASKS;i++)
	{
		if(tasks[i].id == id);
		{
			tasks[i] = null;
			idAvailable = true;
		}
	}
	
	// Wenn id gefunden und gelöscht dann
	// Array neu sortieren
	if(idAvailable)
	{
		NUM_TASKS--;
		Task[] t = new Task[NUM_TASKS];
		
		for(int i = 0; i < NUM_TASKS+1; i++)
		{
			if(tasks[i]!=null)
			{
				t[j] = tasks[i];
				j++;
			}
		}
		tasks = t;
	}
	
}


public static void run()
{
int i = 0;
	while(start)
	{
		if(Interrupt.tick_flag)
		{
			if(i < count )
			{									
					if(run)							// Applications nicht unterbrochen ruf nur Prio 2
					{
						Head.frame_04("Editor Input");
						if(tasks[i].prio == 2)
							MethCall(tasks[i].mth);	
					}
					else
					{
						
						if(tasks[i].prio == 1)		// Application unterbrochen ruf nur Prio 1
						{
							Head.frame_04("Sys Input");
							MethCall(tasks[i].mth);	
						}
					}
					i++;					
			}
			else	
				i=0;
			
			Interrupt.tick_flag = false;
		}
								
	}
		
		
}

	
public static void MethCall(int add)
{
	int mthdAddr = add;
	MAGIC.inline(0x57, 0x56);
	MAGIC.inline(0x8B, 0x75,0x10);
	MAGIC.inline(0x8B,0x7D,0x0C);
	MAGIC.inline(0xFF,0x55,0x08);
	MAGIC.inline(0x5E,0x5F);
}

}
