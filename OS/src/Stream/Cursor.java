package Stream;

import Video.Display;
import Video.VidPos;

public class Cursor extends Output{

	public static void setCursorAbs(int newX, int newY) {
		if (mode == 0) {
			VidPos.poshead = start;
			VidPos.poshead = VidPos.poshead
					+ (newX);
			if (VidPos.poshead < start
					|| VidPos.poshead >= end)
				VidPos.poshead = start;
		}
		if (mode == 1) {
			VidPos.posbody = start;
			VidPos.posbody = VidPos.posbody
					+ (newY * 80 + newX);
			if (VidPos.posbody < start
					|| VidPos.posbody >= end)
				VidPos.posbody = start;
		}
		if (mode == 2) {
			VidPos.posfoot = start;
			VidPos.posfoot = VidPos.posfoot
					+ (newX);
			if (VidPos.posfoot < start
					|| VidPos.posfoot >= end)
				VidPos.posfoot = start;
		}

	}

	public static void setCursor(int newX, int newY) {
		int y;
		int x;

		if (mode == Display.HeadMode) {
			if ((char) Display.vidHead.digit[VidPos.poshead].ascii == ' ')
				Display.vidHead.digit[VidPos.poshead].color = Display.colHead.col();

			x = VidPos.poshead % xSize;
			x += newX;
			if (VidPos.poshead < start
					|| VidPos.poshead >= end)
				VidPos.poshead = start;
		}
		if (mode == Display.BodyMode) {
			if ((char) Display.vidBody.digit[VidPos.posbody].ascii == ' ')
				Display.vidBody.digit[VidPos.posbody].color = Display.colBody.col();

			y = VidPos.posbody / xSize;
			x = VidPos.posbody % xSize;
			y += newY;
			x += newX;
			VidPos.posbody = x + y * xSize;
			if (VidPos.posbody < start
					|| VidPos.posbody >= end)
				VidPos.posbody = start;
		}
		if (mode == Display.FootMode) {
			VidPos.getInstance();
			if ((char) Display.vidFoot.digit[VidPos.posfoot].ascii == ' ')
				Display.vidFoot.digit[VidPos.posfoot].color = Display.colFoot.col();

			x = VidPos.posfoot % xSize;
			x += newX;
			VidPos.posfoot = x;
			if (VidPos.posfoot < start
					|| VidPos.posfoot >= end)
				VidPos.posfoot = start;
		}

	}


	
}
