package devices;

import Stream.Colors;
import Stream.Output;
import Video.Display;

public class Keyboard {

	private boolean caps = false;
	private boolean numb = false;
	private boolean scrolllock = false;
	private boolean b1 = false;
	private boolean b3 = false;
	private boolean b2 = false;

	public void decodInput(byte cod) {
		
		if(cod <= 0xDF)
		{
			b1 =true;
		} else if (cod==0xE0) {
			b2 =true;
		} else if (cod==0xE1) {
			b3 =true;
		}
		
		if(b1==true)
		{
			if (caps)
				Output.print(getregularCapSymbol(cod));
			else
				Output.print(getregularSymbol(cod));
		}
		else if (b2==true)
		{   
			Output.print(get2byteSymbol(cod));
		}
		else if (b3==true)
		{
			Output.print(get3byteSymbol(cod));
		}
		
		
		
	}

	public String getregularSymbol(byte cod) {
		int val = (int) cod;
		val = val & 0x000000FF;
		String symbol = null;
		switch (val) {
		case 0x01:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[ESC]    ");
			break;
		case 0x02:
			symbol = "1";
			break;
		case 0x03:
			symbol = "2";
			break;
		case 0x04:
			symbol = "3";
			break;
		case 0x05:
			symbol = "4";
			break;
		case 0x06:
			symbol = "5";
			break;
		case 0x07:
			symbol = "6";
			break;
		case 0x08:
			symbol = "7";
			break;
		case 0x09:
			symbol = "8";
			break;
		case 0x0A:
			symbol = "9";
			break;
		case 0x0B:
			symbol = "0";
			break;
		case 0x0C:
			symbol = "ß";
			break;
		case 0x0D:
			symbol = "`";
			break;
		case 0x0E: // Function Return
			Output.setMode(Display.BodyMode);
			Output.setCursor(-1, 0);
			Output.print("  ");
			Output.setCursor(-2, 0);
			break;
		case 0x0F:
			Output.setMode(Display.BodyMode);
			Output.print("      "); // Function Tab
			break;
		case 0x10:
			symbol = "q";
			break;
		case 0x11:
			symbol = "w";
			break;
		case 0x12:
			symbol = "e";
			break;
		case 0x13:
			symbol = "r";
			break;
		case 0x14:
			symbol = "t";
			break;
		case 0x15:
			symbol = "z";
			break;
		case 0x16:
			symbol = "u";
			break;
		case 0x17:
			symbol = "i";
			break;
		case 0x18:
			symbol = "o";
			break;
		case 0x19:
			symbol = "p";
			break;
		case 0x1A:
			symbol = "ü";
			break;
		case 0x1B:
			symbol = "*";
			break;
		case 0x1C:
			Output.setMode(Display.BodyMode);
			Output.printNewLine(); // Function Enter
			break;
		case 0x1D:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[STRG]   ");
			// Function STRG
			break;
		case 0x1E:
			symbol = "a";
			break;
		case 0x1F:
			symbol = "s";
			break;
		case 0x20:
			symbol = "d";
			break;
		case 0x21:
			symbol = "f";
			break;
		case 0x22:
			symbol = "g";
			break;
		case 0x23:
			symbol = "h";
			break;
		case 0x24:
			symbol = "j";
			break;
		case 0x25:
			symbol = "k";
			break;
		case 0x26:
			symbol = "l";
			break;
		case 0x27:
			symbol = "ö";
			break;
		case 0x28:
			symbol = "ä";
			break;
		case 0x29:
			symbol = "^";
			break;
		case 0x2A:
			caps = true; // Function Groß
			break;
		case 0x2B:
			symbol = "#"; // 43
			break;
		case 0x2C:
			symbol = "y";
			break;
		case 0x2D:
			symbol = "x";
			break;
		case 0x2E:
			symbol = "c";
			break;
		case 0x2F:
			symbol = "v";
			break;
		case 0x30:
			symbol = "b";
			break;
		case 0x31:
			symbol = "n";
			break;
		case 0x32:
			symbol = "m";
			break;
		case 0x33:
			symbol = ",";
			break;
		case 0x34:
			symbol = ".";
			break;
		case 0x35:
			symbol = "-"; // Function Strich 53
			break;
		case 0x36:
			caps = true; // Function Groß 54
			break;
		case 0x37:
			symbol = "*"; // Function 55
			break;
		case 0x38:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[Alt Gr] ");
			// Function AltGr 56
			break;
		case 0x39:
			Output.setMode(Display.BodyMode);
			Output.setSpace(); // Function Space 57
			break;
		case 0x3A:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(60, 0);
			Output.print("[Caps]   ");
			caps = true; // Function Capslock 58
			break;
		case 0x3B:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F1]     ");
			// Function F1 59
			break;
		case 0x3C:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F2]     ");
			// Function F2 60
			break;
		case 0x3D:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F3]     ");
			// Function F3 61
			break;
		case 0x3E:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F4]     ");
			// Function F4 62
			break;
		case 0x3F:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F5]     ");
			// Function F5 63
			break;
		case 0x40:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F6]     ");
			// Function F6 64
			break;
		case 0x41:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F7]     ");
			// Function F7 65
			break;
		case 0x42:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F8]     ");
			// Function F8 66
			break;
		case 0x43:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F9]     ");
			// Function F9 67
			break;
		case 0x44:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F10]    ");
			// Function F10 68
			break;
		case 0x45:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Num]    ");
				// Function Number 69
				numb = true;
			} else {
				Output.setMode(Display.BodyMode);
				Output.setCursorAbs(0, 0);
				Output.print("       ");
				// Function Number 69
				numb = false;
			}
			break;
		case 0x46:
			if (this.scrolllock == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Rollen] ");
				// Function Rollen runter 70
				this.scrolllock = true;
			} else {
				Output.setMode(Display.BodyMode);
				Output.setCursorAbs(0, 0);
				Output.print("       ");
				// Function Rollen runter 70
				this.scrolllock = false;
			}
			break;
		case 0x47:
			if (numb == false) {
				Output.setMode(Display.BodyMode);
				Output.setPos1(); // Function Pos1 71 // mit
														// Num Zahl 7
			} else
				symbol = "7";
			break;
		case 0x48:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil U]");
				// Function Pfeil Oben 72 // mit Num Zahl 8
				Output.setCursor(0, -1);
			} else
				symbol = "8";
			break;
		case 0x49:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Bild O] ");
				// Function Bild Oben 73 // mit Num Zahl 9
			} else
				symbol = "9";
			break;
		case 0x4A:
			symbol = "-"; // Function Strich 74
			break;
		case 0x4B:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil L]");
				// Function Pfeil links 75 // mit Num Zahl 4
				Output.setCursor(-1, 0);
			} else
				symbol = "4";
			break;
		case 0x4C:
			if (numb == true) // Function mit Num Zahl 5 76
				symbol = "5";
			break;
		case 0x4D:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil R]");
				// Function Pfeil rechts 77 // mit Num Zahl 6
				Output.setCursor(1, 0);
			} else
				symbol = "6";
			break;
		case 0x4E:
			symbol = "+"; // Function Plus 78
			break;
		case 0x4F:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[End]    ");
				// Function End 79 // mit Num Zahl 1
			} else
				symbol = "1";
			break;
		case 0x50:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil O]");
				// Function Pfeil runter 80 // mit Num Zahl 2
				Output.setCursor(0, 1);
			} else
				symbol = "2";

			break;
		case 0x51:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Bild D] ");
				// Function Bild runter 81 // mit Num Zahl 3
			} else
				symbol = "3";
			break;
		case 0x52:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Einf]   ");
				// Function Einf 82 // mit Num Zahl 0
			} else
				symbol = "0";
			break;
		case 0x53:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Entf]   ");
				// Function Entf 83 // mit Num Zahl
				Output.setMode(Display.BodyMode);
				Output.removeChar();
			} else
				symbol = ",";
			break;
		case 0x54:
			symbol = ""; // Function Nicht belegt 84
			break;
		case 0x55:
			symbol = ""; // Function Nicht belegt 85
			break;
		case 0x56:
			symbol = "<"; // Function < 86
			break;
		case 0x57:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F11]   ");
			// Function F11 87
			break;
		case 0x58:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F12]    ");
			// Function F12 88
			break;
		case 0x5D:
			symbol = ""; // Function WIN 91
			break;
		case 0x5E:
			symbol = ""; // Function WIN 92
			break;
		case 0x5F:
			symbol = ""; // Function Rechtklick 93
			break;
		}
		return symbol;
	}

	
	
	public String getregularCapSymbol(byte cod) {
		int val = (int) cod;
		val = val & 0x000000FF;
		String symbol = null;
		switch (val) {
		case 0x01:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[ESC]    ");
			break;
		case 0x02:
			symbol = "!";
			break;
		case 0x03:
			symbol = "\"";
			break;
		case 0x04:
			symbol = "§";
			break;
		case 0x05:
			symbol = "$";
			break;
		case 0x06:
			symbol = "%";
			break;
		case 0x07:
			symbol = "&";
			break;
		case 0x08:
			symbol = "/";
			break;
		case 0x09:
			symbol = "(";
			break;
		case 0x0A:
			symbol = ")";
			break;
		case 0x0B:
			symbol = "=";
			break;
		case 0x0C:
			symbol = "?";
			break;
		case 0x0D:
			symbol = "`";
			break;
		case 0x0E: // Function Return
			Output.setCursor(-1, 0);
			Output.print("  ");
			Output.setCursor(-2, 0);
			break;
		case 0x0F:
			Output.setMode(Display.BodyMode);
			Output.print("      "); // Function Tab
			break;
		case 0x10:
			symbol = "Q";
			break;
		case 0x11:
			symbol = "W";
			break;
		case 0x12:
			symbol = "E";
			break;
		case 0x13:
			symbol = "R";
			break;
		case 0x14:
			symbol = "T";
			break;
		case 0x15:
			symbol = "Z";
			break;
		case 0x16:
			symbol = "U";
			break;
		case 0x17:
			symbol = "I";
			break;
		case 0x18:
			symbol = "O";
			break;
		case 0x19:
			symbol = "P";
			break;
		case 0x1A:
			symbol = "Ü";
			break;
		case 0x1B:
			symbol = "*";
			break;
		case 0x1C:
			Output.setMode(Display.BodyMode);
			Output.printNewLine(); // Function Enter
			break;
		case 0x1D:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[STRG]   ");
			// Function STRG
			break;
		case 0x1E:
			symbol = "A";
			break;
		case 0x1F:
			symbol = "S";
			break;
		case 0x20:
			symbol = "D";
			break;
		case 0x21:
			symbol = "F";
			break;
		case 0x22:
			symbol = "G";
			break;
		case 0x23:
			symbol = "H";
			break;
		case 0x24:
			symbol = "J";
			break;
		case 0x25:
			symbol = "K";
			break;
		case 0x26:
			symbol = "L";
			break;
		case 0x27:
			symbol = "Ö";
			break;
		case 0x28:
			symbol = "Ä";
			break;
		case 0x29:
			symbol = "°";
			break;
		case 0xAA:
			caps = false; // Function Groß
			break;
		case 0x2B:
			symbol = "'";
			break;
		case 0x2C:
			symbol = "Y";
			break;
		case 0x2D:
			symbol = "X";
			break;
		case 0x2E:
			symbol = "C";
			break;
		case 0x2F:
			symbol = "V";
			break;
		case 0x30:
			symbol = "B";
			break;
		case 0x31:
			symbol = "N";
			break;
		case 0x32:
			symbol = "M";
			break;
		case 0x33:
			symbol = ";";
			break;
		case 0x34:
			symbol = ":";
			break;
		case 0x35:
			symbol = "_"; // Function Strich 53
			break;
		case 0xB6:
			caps = false; // Function Groß 54
			break;
		case 0x37:
			symbol = "*"; // Function 55
			break;
		case 0x38:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[Alt Gr] ");
			// Function STRG
			break;
		case 0x39:
			Output.setMode(Display.BodyMode);
			Output.setSpace();
			break;
		case 0x3A:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(60, 0);
			Output.print("         ");
			caps = false; // Function Capslock 58
			break;
		case 0x3B:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F1]     ");
			// Function F1 59
			break;
		case 0x3C:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F2]     ");
			// Function F2 60
			break;
		case 0x3D:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F3]     ");
			// Function F3 61
			break;
		case 0x3E:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F4]     ");
			// Function F4 62
			break;
		case 0x3F:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F5]     ");
			// Function F5 63
			break;
		case 0x40:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F6]     ");
			// Function F6 64
			break;
		case 0x41:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F7]     ");
			// Function F7 65
			break;
		case 0x42:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F8]     ");
			// Function F8 66
			break;
		case 0x43:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F9]     ");
			// Function F9 67
			break;
		case 0x44:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F10]    ");
			// Function F10 68
			break;
		case 0x45:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Num]    ");
				// Function Number 69
				numb = true;
			} else {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("         ");
				// Function Number 69
				numb = false;
			}
			break;
		case 0x46:
			if (this.scrolllock == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Rollen] ");
				// Function Rollen runter 70
				this.scrolllock = true;
			} else {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("         ");
				// Function Rollen runter 70
				this.scrolllock = false;
			}
			break;
		case 0x47:
			if (numb == false) {
				Output.setMode(Display.BodyMode);
				Output.setPos1(); // Function Pos1 71 // mit
														// Num Zahl 7
			} else
				symbol = "7";
			break;
		case 0x48:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil O]");
				// Function Pfeil Oben 72 // mit Num Zahl 8
				Output.setCursor(0, -1);
			} else
				symbol = "8";
			break;
		case 0x49:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Bild O] ");
				// Function Bild Oben 73 // mit Num Zahl 9
			} else
				symbol = "9";
			break;
		case 0x4A:
			symbol = "-"; // Function Strich 74
			break;
		case 0x4B:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil L]");
				// Function Pfeil links 75 // mit Num Zahl 4
				Output.setCursor(-1, 0);
			} else
				symbol = "4";
			break;
		case 0x4C:
			if (numb == true) // Function mit Num Zahl 5 76
				symbol = "5";
			break;
		case 0x4D:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil R]");
				// Function Pfeil rechts 77 // mit Num Zahl 6
				Output.setCursor(1, 0);
			} else
				symbol = "6";
			break;
		case 0x4E:
			symbol = "+"; // Function Plus 78
			break;
		case 0x4F:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[End]    ");
				// Function End 79 // mit Num Zahl 1
			} else
				symbol = "1";
			break;
		case 0x50:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Pfeil O]");
				// Function Pfeil runter 80 // mit Num Zahl 2
				Output.setCursor(0, 1);
			} else
				symbol = "2";

			break;
		case 0x51:
			if (numb == false) {
				Output.setMode(Display.HeadMode);	
				Output.setCursorAbs(0, 0);
				Output.print("[Bild D] ");
				// Function Bild runter 81 // mit Num Zahl 3
			} else
				symbol = "3";
			break;
		case 0x52:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Einf]   ");
				// Function Einf 82 // mit Num Zahl 0
			} else
				symbol = "0";
			break;
		case 0x53:
			if (numb == false) {
				Output.setMode(Display.HeadMode);
				Output.setCursorAbs(0, 0);
				Output.print("[Entf]   ");
				// Function Entf 83 // mit Num Zahl ,
				Output.setMode(Display.BodyMode);
				Output.removeChar();
			} else
				symbol = ",";
			break;
		case 0x54:
			symbol = ""; // Function Nicht belegt 84
			break;
		case 0x55:
			symbol = ""; // Function Nicht belegt 85
			break;
		case 0x56:
			symbol = ">"; // Function < 86
			break;
		case 0x57:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F11]    ");
			// Function F11 87
			break;
		case 0x58:
			Output.setMode(Display.HeadMode);
			Output.setCursorAbs(0, 0);
			Output.print("[F12]    ");
			// Function F12 88
			break;
		case 0x5D:
			symbol = ""; // Function WIN 91
			break;
		case 0x5E:
			symbol = ""; // Function WIN 92
			break;
		case 0x5F:
			symbol = ""; // Function Rechtklick 93
			break;
		}
		return symbol;
	}

	public String get2byteSymbol(byte cod) {
		String symbol = null;
		Output.printHex(cod);
		Output.print(" ");
		Output.printHex(cod);
		Output.println();
		switch (cod) {
		case 0x01:
			symbol = "ESC";
			break;
		case 0x02:
			symbol = "1";
			break;
		case 0x03:
			symbol = "2";
			break;
		case 0x04:
			symbol = "3";
			break;
		case 0x05:
			symbol = "4";
			break;
		case 0x06:
			symbol = "5";
			break;
		case 0x07:
			symbol = "6";
			break;
		case 0x08:
			symbol = "7";
			break;
		case 0x09:
			symbol = "8";
			break;
		case 0x0A:
			symbol = "9";
			break;
		case 0x0B:
			symbol = "0";
			break;

		}
		return symbol;
	}

	public String get3byteSymbol(byte cod) {
		String symbol = null;
		switch (cod) {
		case 0x01:
			symbol = "ESC";
			break;
		case 0x02:
			symbol = "1";
			break;
		case 0x03:
			symbol = "2";
			break;
		case 0x04:
			symbol = "3";
			break;
		case 0x05:
			symbol = "4";
			break;
		case 0x06:
			symbol = "5";
			break;
		case 0x07:
			symbol = "6";
			break;
		case 0x08:
			symbol = "7";
			break;
		case 0x09:
			symbol = "8";
			break;
		case 0x0A:
			symbol = "9";
			break;
		case 0x0B:
			symbol = "0";
			break;

		}
		return symbol;
	}

}
