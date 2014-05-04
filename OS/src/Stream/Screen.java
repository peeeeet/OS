package Stream;

import Video.Display;
import Video.VidPos;

public class Screen extends Out {

	public static void clear(int bg) {

		if (mode == 0) {
			Display.colHead.setColor(0, bg);
			VidPos.poshead = start;
			for (int j = start; j < end; j++)
				print(' ');
		}
		if (mode == 1) {
			Display.colBody.setColor(0, bg);
			VidPos.posbody = start;
			for (int j = start; j < end; j++)
				print(' ');
		}
		if (mode == 2) {
			Display.colFoot.setColor(0, bg);
			VidPos.posfoot = start;
			for (int j = start; j < end; j++)
				print(' ');
		}
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
				if (mode == Display.HeadMode)
					Display.vidHead.digit[pos++].color  = Color.getColor(fg, bg);
				if (mode == Display.BodyMode)
					Display.vidBody.digit[pos++].color  = Color.getColor(fg, bg);
				if (mode == Display.FootMode)
					Display.vidFoot.digit[pos++].color  = Color.getColor(fg, bg);
			
			}
	}


	
}
