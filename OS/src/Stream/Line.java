package Stream;

import Video.Display;
import Video.VidMem;
import Video.VidPos;

public class Line extends Out
{

	public static void println(String str) {
		print(str);
		println();
	}

	public static void println(char c) {
		print(c);
		println();
	}

	public static void println(int i) {
		print(i);
		println();
	}

	public static void println(long l) {
		print(l);
		println();
	}
	
	private static void println() {
		if (VidPos.posbody % xSize != 0)
			VidPos.posbody += (xSize - VidPos.posbody
					% xSize);
	}


	
	
}
