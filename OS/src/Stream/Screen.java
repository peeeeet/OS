package Stream;

public class Screen extends Out {

	public static void clear() 
	{
			for (int j = start; j < end; j++)
				print(' ');
			
	}
	
	public static void setAreaColor(int x1, int x2, int y1, int y2, int fg, int bg) {
		int pos = start + x1 + y1*80;
		int pos2 = start + x2 + y2*80;
		
			if (pos < start || pos >= end)
				pos = start;
			
			if (pos2 < start || pos2 >= end)
				pos2 = start;


			while(pos != pos2)
			{
					Output.putColor(Color.getColor(fg, bg));			
			}
	}


	
}
