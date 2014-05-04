package Stream;
import Video.VidMem;
import Content.*;


public class Output {
	
	protected static int xSize = 80;
	protected static int ySize = 23;
	protected static int aciiPosInt = 48;
	protected static int start = 80;
	protected static int end = 1840;
	protected static int mode = 1;
	protected static boolean trig = false;
	protected static int curPos = 0;
	protected static byte curCol;
	protected static byte curColComp;
	
	protected Output() {
		putMode(1);
	}

	protected Output(int m) {
		putMode(m);
	}

	
	public static void putMode(int m) {
		
		// Letzte VidPos nach Modus speichern
		if(mode==Head.MODE)
			Head.pos = curPos;
		if(mode==Body.MODE)
			Body.pos = curPos;
		if(mode==Foot.MODE)
			Foot.pos = curPos;
		
		//  Neue VidPos und Startwerte setzten nach Modus
		if (m == Head.MODE) 
		{
			mode = Head.MODE;
			start = Head.start;
			end = Head.end;
			curPos =  Head.pos;
			curCol = Head.color;
			curColComp = Head.colorCompl;
		}
		// 1 Body
		if (m == Body.MODE) 
		{
			mode = Body.MODE;
			start = Body.start;
			end = Body.end;
			curPos =  Body.pos;
			curCol = Body.color;
			curColComp = Body.colorCompl;
		}
		// 2 Foot
		if (m == Foot.MODE) 
		{
			mode = Foot.MODE;
			start = Foot.start;
			end = Foot.end;
			curPos =  Foot.pos;
			curCol = Foot.color;
			curColComp = Foot.colorCompl;
		}

	}

	
	protected static void putChar(char c) 
	{
			if (curPos < start || curPos  >= end)
				curPos  = start;
			VidMem.vid.digit[curPos ].ascii = (byte) c;
			VidMem.vid.digit[curPos++].color = curCol;	
	}
	
	protected static void putColor(byte color)
	{
			if (curPos < start || curPos >= end)
				curPos = start;
			
			VidMem.vid.digit[curPos].ascii = color;			
		
	}
	
	public static void setColor(int fg, int bg)
	{
		curCol = Color.getColor(fg, bg);			
	}
	
	protected static void putPixel(int x, int y, int color) 
	{
		int start = 0xA0000;

		start += x + (y * 320);
		MAGIC.wMem8(start, (byte) color);
	}
				
	public static void putSpace() {
		int pos;

			pos = curPos;
			for (int i = end; i > pos; i--) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i - 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i - 1].color;
			}
			VidMem.vid.digit[curPos].color = curCol;
			VidMem.vid.digit[curPos++].ascii = ' ';
			if (curPos < start || curPos >= end)
				curPos = start;


	}

	public static void removeChar() {
		int pos;

			pos = curPos;
			for (int i = pos; i < end - 1; i++) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i + 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i + 1].color;
			}
			if (curPos < start|| curPos >= end)
				curPos = start;
	}

	public static void putPos1() {
		int y;
		int x;
		x = 0;
		curPos = x;
		if (curPos < start || curPos >= end)
				curPos = start;


	}

	protected static void triggerCursor() {
		if (trig) 
		{
			VidMem.vid.digit[curPos].color = curCol;

			trig = false;
		} 
			else 
		{
			VidMem.vid.digit[curPos].color = curCol;
			trig = true;
		}
	}

	public static void putNewLine() {
		if ((char) VidMem.vid.digit[curPos].ascii == ' ') {
			VidMem.vid.digit[curPos].color = curCol;
		}

		if (curPos % xSize != 0) 
			curPos += (xSize - curPos% xSize);
		else
			curPos += xSize;
	}


}