package java.lang;

public class String 
{
	  private char[] value;
	  private int count;
	  
	  @SJC.Inline
	  public int length() {
	    return count;
	  }
	  
	  @SJC.Inline
	  public char charAt(int i) 
	  {
	    return value[i];
	  }

	  /*
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
				outputChar((char) (aciiPosInt));
			}

		}
		
		private static char rekint2char(int x) {
			int c;
			// Rekrusiv Abbruch bei x == 0
			if (x != 0) {
				rekint2char(x / 10);
				c = (x >= 0) ? (x % 10) : (x % 10) * -1;
				return((char) (c + aciiPosInt));
			}
		}
	  
	  public static String toString(int i)
	  {
		  
	  }
	  
	  public static String toString(long i)
	  {
		  
	  }
	  
	  public static String toString(byte i)
	  {
		  
	  }
	  
	  public static String toString(short i)
	  {
		  
	  }

	  public static String toHexString(short i)
	  {
		  
	  }
	  
	  public static String toHexString(int i)
	  {
		  
	  }
	  
	  public static String toHexString(long i)
	  {
		  
	  }
	  
	  public static String toHexString(byte i)
	  {
		  
	  }
	*/  
}

