package Stream;

import Video.Display;
import Video.VidMem;
import Video.VidPos;
import kernel.Segments;

public class Output {
	
	protected static int xSize = 80;
	protected static int ySize = 23;
	protected static int aciiPosInt = 48;
	protected static int start = 0;
	protected static int end = 0;
	protected static int mode = 0;
	protected static boolean trig = false;
	
	protected Output() {
		putMode(1);
	}

	protected Output(int m) {
		putMode(m);
	}

	protected static void putChar(char c) 
	{
		if (mode == Display.HeadMode) 
		{
			if (VidPos.posHead < start || VidPos.posHead >= end)
				VidPos.posHead = start;
			VidMem.vid.digit[VidPos.posHead].ascii = (byte) c;
			VidMem.vid.digit[VidPos.posHead++].color = Display.colHead.col();	
		}
		if (mode == Display.BodyMode) 
		{
			if (VidPos.posBody < start || VidPos.posBody >= end)
				VidPos.posBody = start;
			VidMem.vid.digit[VidPos.posBody].ascii = (byte) c;
			VidMem.vid.digit[VidPos.posBody++].color = Display.colBody.col();
		}
		if (mode == Display.FootMode) 
		{
			if (VidPos.posFoot < start || VidPos.posFoot >= end)
				VidPos.posFoot = start;
			
			VidMem.vid.digit[VidPos.posFoot].ascii = (byte) c;
			VidMem.vid.digit[VidPos.posFoot++].color = Display.colFoot.col();
		}
	}
	
	protected static void putColor(byte color)
	{
		if (mode == Display.HeadMode) {
			if (VidPos.posHead < start || VidPos.posHead >= end)
				VidPos.posHead = start;
			
			VidMem.vid.digit[VidPos.posHead++].ascii = color;			
		}
		if (mode == Display.BodyMode) {
			if (VidPos.posBody < start || VidPos.posBody >= end)
				VidPos.posBody = start;
			
			VidMem.vid.digit[VidPos.posBody++].color = color;
		}
		if (mode == Display.FootMode) {
			if (VidPos.posFoot < start || VidPos.posFoot >= end)
				VidPos.posFoot = start;
			
			VidMem.vid.digit[VidPos.posFoot++].color = color;
		}
		
	}
	
	protected static void putPixel(int x, int y, int color) 
	{
		int start = 0xA0000;

		start += x + (y * 320);
		MAGIC.wMem8(start, (byte) color);
	}
		
	public static void putMode(int m) {
		// 0 Head
		if (m == 0) {
			mode = 0;
			start = 0;
			end = 80;
		}
		// 1 Body
		if (m == 1) {
			mode = 1;
			start = 0;
			end = 1840;
		}
		// 2 Foot
		if (m == 2) {
			mode = 2;
			start = 0;
			end = 80;
		}

	}
		
	protected static void putSpace() {
		int pos;

		if (mode == Display.HeadMode) {
			pos = VidPos.posHead;
			for (int i = end; i > pos; i--) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i - 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i - 1].color;
			}
			VidMem.vid.digit[VidPos.posHead].color = Display.colHead.col();
			VidMem.vid.digit[VidPos.posHead++].ascii = ' ';
			if (VidPos.posHead < start
					|| VidPos.posHead >= end)
				VidPos.posHead = start;
		}
		if (mode == Display.BodyMode) {
			pos = VidPos.posBody;
			for (int i = end; i > pos; i--) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i - 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i - 1].color;
			}
			VidMem.vid.digit[VidPos.posBody].color = Display.colBody.col();
			VidMem.vid.digit[VidPos.posFoot++].ascii = ' ';
			if (VidPos.posBody < start
					|| VidPos.posBody >= end)
				VidPos.posBody = start;
		}
		if (mode == 2) {
			pos = VidPos.posFoot;
			for (int i = end; i > pos; i--) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i - 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i - 1].color;
			}
			VidMem.vid.digit[VidPos.posFoot].color = Display.colHead.col();
			VidMem.vid.digit[VidPos.posFoot++].ascii = ' ';
			if (VidPos.posFoot < start
					|| VidPos.posFoot >= end)
				VidPos.posFoot = start;
		}

	}

	protected static void removeChar() {
		int pos;

		if (mode == 0) {
			pos = VidPos.posHead;
			for (int i = pos; i < end - 1; i++) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i + 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i + 1].color;
			}
			if (VidPos.posHead < start
					|| VidPos.posHead >= end)
				VidPos.posHead = start;
		}
		if (mode == 1) {
			pos = VidPos.posBody;
			for (int i = pos; i < end - 1; i++) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i + 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i + 1].color;
			}
			if (VidPos.posBody < start
					|| VidPos.posBody >= end)
				VidPos.posBody = start;
		}
		if (mode == 2) {
			pos = VidPos.posFoot;
			for (int i = pos; i < end - 1; i++) {
				VidMem.vid.digit[i].ascii = VidMem.vid.digit[i + 1].ascii;
				VidMem.vid.digit[i].color = VidMem.vid.digit[i + 1].color;
			}
			if (VidPos.posFoot < start
					|| VidPos.posFoot >= end)
				VidPos.posFoot = start;
		}

	}

	protected static void setPos1() {
		int y;
		int x;

		if (mode == 0) {
			x = 0;
			VidPos.posHead = x;
			if (VidPos.posHead < start
					|| VidPos.posHead >= end)
				VidPos.posHead = start;
		}
		if (mode == 1) {
			x = VidPos.posBody % xSize;
			VidPos.posBody = VidPos.posBody - x;
			if (VidPos.posBody < start
					|| VidPos.posBody >= end)
				VidPos.posBody = start;
		}
		if (mode == 2) {
			x = 0;
			VidPos.posFoot = x;
			if (VidPos.posFoot < start
					|| VidPos.posFoot >= end)
				VidPos.posFoot = start;
		}

	}

	protected static void triggerCursor() {
		if (trig) {
			if (mode == 0) {

				VidMem.vid.digit[VidPos.posHead].color = Display.colHead.col();
			}
			if (mode == 1) {

				VidMem.vid.digit[VidPos.posBody].color = Display.colBody.col();
			}
			if (mode == 2) {
				VidMem.vid.digit[VidPos.posFoot].color = Display.colFoot.col();
			}
			trig = false;
		} else {
			if (mode == 0) {
				VidMem.vid.digit[VidPos.posHead].color = Display.colComplHead.col();
			}
			if (mode == 1) {

				VidMem.vid.digit[VidPos.posBody].color = Display.colComplBody.col();

			}
			if (mode == 2) {
				VidMem.vid.digit[VidPos.posFoot].color = Display.colComplFoot.col();
			}
			trig = true;
		}
	}

	protected static void printNewLine() {
		if ((char) VidMem.vid.digit[VidPos.posBody].ascii == ' ') {
			VidMem.vid.digit[VidPos.posBody].color = Display.colBody.col();
		}

		if (VidPos.posBody % xSize != 0)
			VidPos.posBody += (xSize - VidPos.posBody
					% xSize);
		else
			VidPos.posBody += xSize;
	}


}