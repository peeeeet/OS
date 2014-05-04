package Stream;

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
		if (Output.curPos % xSize != 0)
			Output.curPos += (xSize - Output.curPos % xSize);
	}


	
	
}
