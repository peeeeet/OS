package Stream;

public class Screen {

	public static void clear() 
	{
			for (int j = Output.start; j < Output.end; j++)
				Output.putChar(' ');
			
	}
	
	public static void setColor(byte color) 
	{
			for (int j = Output.start; j < Output.end; j++)
				Output.putColor(color);
			
	}
	
	public static void setAreaColor(int x1, int x2, int y1, int y2, int fg, int bg) {
		int pos = Output.start + x1 + y1*80;
		int pos2 = Output.start + x2 + y2*80;
		
			if (pos < Output.start || pos >= Output.end)
				pos = Output.start;
			
			if (pos2 < Output.start || pos2 >= Output.end)
				pos2 = Output.start;


			while(pos != pos2)
			{
					Output.putColor(Color.getColor(fg, bg));			
			}
	}
	
	
	public static void blue() 
	{
			for (int j = Output.start; j < Output.end; j++)
				Output.putColor(Color.getColor(Colors.white, Colors.blue));
			
	}


	
}
