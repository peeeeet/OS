package Stream;

import Video.VidMem;

public class Cursor extends Output{

	public static void setAbs(int newX, int newY) 
	{

			curPos = start;
			curPos = curPos + (newY * 80 + newX);
			if (curPos < start || curPos >= end)
				curPos = start;
	}

	public static void set(int newX, int newY) 
	{
		int y;
		int x;

			if ((char) VidMem.vid.digit[curPos].ascii == ' ')
				VidMem.vid.digit[curPos].color = curCol;

			y = curPos / xSize;
			x = curPos % xSize;
			y += newY;
			x += newX;
			curPos = x + y * xSize;
			if (curPos < start || curPos >= end)
				curPos = start;
	}


	
}
