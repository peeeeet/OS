package Stream;

public class Hex 
{

	protected static int aciiPosHex = 55;
	protected static int aciiPosInt = 48;
	
	public static void print(byte b) {
		int m = 0;
		// Rekursion mit Abbruchbedingung bei == 0
		if ((m = b >>> 4) != 0)
			print(m);

		Out.print((char) ((m = b & 0x0F) + (m < 10 ? aciiPosInt : aciiPosHex)));
		
	}

	public static void print(short s) {
		int m = 0;
		// Rekursion mit Abbruchbedingung bei == 0
		if ((m = s >>> 4) != 0)
			print(m);

		Out.print((char) ((m = s & 0x0F) + (m < 10 ? aciiPosInt : aciiPosHex)));

	}

	public static void print(int x) {
		int m = 0;
		// Rekursion mit Abbruchbedingung bei == 0
		if ((m = x >>> 4) != 0)
			print(m);

		Out.print((char) ((m = x & 0x0F) + (m < 10 ? aciiPosInt : aciiPosHex)));
	}

	public static void print(long x) {
		long m = 0;
		// Rekursion mit Abbruchbedingung bei == 0
		if ((m = x >>> 4) != 0)
			print(m);

		Out.print((char) ((m = x & 0x0F) + (m < 10 ? aciiPosInt : aciiPosHex)));
	}
}
