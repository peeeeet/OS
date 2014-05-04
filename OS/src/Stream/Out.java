package Stream;

public class Out extends Output
{
	public static Hex hex;
	public static Line ln;
	public static Screen screen;
	
	public static void print(char c) 
	{
		putChar(c);
	}

	public static void print(String str) {
	
		for (int i = 0; i < str.length(); i++)
			putChar(str.charAt(i));
	
	}
	
	public static void print(int x) {

		// Schreibe - wenn x < 0
		if (x < 0)
			print('-');

		if (x != 0) {
			// Zahl in Char umwandeln
			rekint2char(x);
		}
		// Wenn Zahl = 0 dann Sonderfall
		else {
			outputChar((char) (aciiPosInt));
		}
	}

	public static void print(long x) {
		// Schreibe - wenn x < 0
		if (x < 0)
			print('-');

		if (x != 0) {
			// Zahl in Char umwandeln
			reklong2char(x);
		}
		// Wenn Zahl = 0 dann Sonderfall
		else {
			setChar((char) (aciiPosInt));
		}

	}
	
	private static void rekint2char(int x) {
		int c;
		// Rekrusiv Abbruch bei x == 0
		if (x != 0) {
			rekint2char(x / 10);
			c = (x >= 0) ? (x % 10) : (x % 10) * -1;
			setChar((char) (c + aciiPosInt));
		}
	}

	private static void reklong2char(long x) 
	{
		long c;
		// Rekrusiv Abbruch bei x == 0
		if (x != 0) {
			reklong2char(x / 10);
			c = (x >= 0) ? (x % 10) : (x % 10) * -1;
			setChar((char) (c + aciiPosInt));
		}
	}

	
	
}
