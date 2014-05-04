package devices;

import Content.Body;
import Content.Head;

public class Keyboard {

	private boolean caps = false;
	private boolean numb = false;
	private boolean scrolllock = false;
	private boolean b1 = false;
	private boolean b3 = false;
	private boolean b2 = false;
	private String tab = "      ";

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

			Body.frame(getregularSymbol(cod));
		}
		else if (b2==true)
		{   
			
		}
		else if (b3==true)
		{
			
		}
		
		
		
	}

	public String getregularSymbol(byte cod) {
		int val = (int) cod;
		val = val & 0x000000FF;
		String symbol = null;
		switch (val) {
		case 0x01:
			Head.frame_01("[ESC]    ");
			break;
		case 0x02:
			if (caps)
				symbol = "!";
			else
				symbol = "1";
			break;
		case 0x03:
			if (caps)
				symbol = "\"";
			else
				symbol = "2";
			break;
		case 0x04:
			if (caps)
				symbol = "§";
			else
				symbol = "3";
			break;
		case 0x05:
			if (caps)
				symbol = "$";
			else
				symbol = "4";
			break;
		case 0x06:
			if (caps)
				symbol = "%";
			else
				symbol = "5";
			break;
		case 0x07:
			if (caps)
				symbol = "&";
			else
				symbol = "6";
			break;
		case 0x08:
			if (caps)
				symbol = "/";
			else
				symbol = "7";
			break;
		case 0x09:
			if (caps)
				symbol = "(";
			else
				symbol = "8";
			break;
		case 0x0A:
			if (caps)
				symbol = ")";
			else
				symbol = "9";
			break;
		case 0x0B:
			if (caps)
				symbol = "=";
			else
				symbol = "0";
			break;
		case 0x0C:
			if (caps)
				symbol = "?";
			else
				symbol = "ss";
			break;
		case 0x0D:
			if (caps)
				symbol = "´";
			else
				symbol = "`";
			break;
		case 0x0E: // Function Return
			Body.ret();
			break;
		case 0x0F:
			Body.frame(tab); // Function Tab
			break;
		case 0x10:
			if (caps)
				symbol = "Q";
			else
				symbol = "q";
			break;
		case 0x11:
			if (caps)
				symbol = "W";
			else
				symbol = "w";
			break;
		case 0x12:
			if (caps)
				symbol = "E";
			else
				symbol = "e";
			break;
		case 0x13:
			if (caps)
				symbol = "R";
			else
				symbol = "r";
			break;
		case 0x14:
			if (caps)
				symbol = "T";
			else
				symbol = "t";
			break;
		case 0x15:
			if (caps)
				symbol = "Z";
			else
				symbol = "z";
			break;
		case 0x16:
			if (caps)
				symbol = "U";
			else
				symbol = "u";
			break;
		case 0x17:
			if (caps)
				symbol = "I";
			else
				symbol = "i";
			break;
		case 0x18:
			if (caps)
				symbol = "O";
			else
				symbol = "o";
			break;
		case 0x19:
			if (caps)
				symbol = "P";
			else
				symbol = "p";
			break;
		case 0x1A:
			if (caps)
				symbol = "UE";
			else
				symbol = "ue";
			break;
		case 0x1B:
			if (caps)
				symbol = "*";
			else
				symbol = "+";
			break;
		case 0x1C:
			Body.newLine(); // Enter 28
			break;
		case 0x1D:
			Head.frame_01("[STRG]   ");
			// Function STRG
			break;
		case 0x1E:
			if (caps)
				symbol = "A";
			else
				symbol = "a";
			break;
		case 0x1F:
			if (caps)
				symbol = "S";
			else
				symbol = "s";
			break;
		case 0x20:
			if (caps)
				symbol = "D";
			else
				symbol = "d";
			break;
		case 0x21:
			if (caps)
				symbol = "F";
			else
				symbol = "f";
			break;
		case 0x22:
			if (caps)
				symbol = "G";
			else
				symbol = "g";
			break;
		case 0x23:
			if (caps)
				symbol = "H";
			else
				symbol = "h";
			break;
		case 0x24:
			if (caps)
				symbol = "J";
			else
				symbol = "j";
			break;
		case 0x25:
			if (caps)
				symbol = "K";
			else
				symbol = "k";
			break;
		case 0x26:
			if (caps)
				symbol = "L";
			else
				symbol = "l";
			break;
		case 0x27:
			if (caps)
				symbol = "OE";
			else
				symbol = "oe";
			break;
		case 0x28:
			if (caps)
				symbol = "AE";
			else
				symbol = "ae";
			break;
		case 0x29:
			if (caps)
				symbol = "°";
			else
				symbol = "^";
			break;
		case 0x2A:
			if (caps)
				caps = false;
			else
				caps = true; // Function Gross
			break;
		case 0x2B:
			if (caps)
				symbol = "'";
			else
				symbol = "#"; // 43
			break;
		case 0x2C:
			if (caps)
				symbol = "Y";
			else
				symbol = "y";
			break;
		case 0x2D:
			if (caps)
				symbol = "X";
			else
				symbol = "x";
			break;
		case 0x2E:
			if (caps)
				symbol = "C";
			else
				symbol = "c";
			break;
		case 0x2F:
			if (caps)
				symbol = "V";
			else
				symbol = "v";
			break;
		case 0x30:
			if (caps)
				symbol = "B";
			else
				symbol = "b";
			break;
		case 0x31:
			if (caps)
				symbol = "!";
			else
				symbol = "N";
			break;
		case 0x32:
			if (caps)
				symbol = "M";
			else
				symbol = "m";
			break;
		case 0x33:
			if (caps)
				symbol = ";";
			else
				symbol = ",";
			break;
		case 0x34:
			if (caps)
				symbol = ":";
			else
				symbol = ".";
			break;
		case 0x35:
			if (caps)
				symbol = "_";
			else
			symbol = "-"; // Function Strich 53
			break;
		case 0x36:
			if (caps)
				caps = false;
			else
				caps = true; // Function Gross 54
			break;
		case 0x37:
			symbol = "*"; // Function 55
			break;
		case 0x38:
			Head.frame_01("[Alt Gr] ");
			// Function AltGr 56
			break;
		case 0x39:
				// Function Space 57
			Body.Space();
			break;
		case 0x3A:
			Head.frame_01("[Caps]   ");
			caps = true; // Function Capslock 58
			break;
		case 0x3B:
			Head.frame_01("[F1]     ");
			// Function F1 59
			break;
		case 0x3C:
			Head.frame_01("[F2]     ");
			// Function F2 60
			break;
		case 0x3D:
			Head.frame_01("[F3]     ");
			// Function F3 61
			break;
		case 0x3E:
			Head.frame_01("[F4]     ");
			// Function F4 62
			break;
		case 0x3F:
			Head.frame_01("[F5]     ");
			// Function F5 63
			break;
		case 0x40:
			Head.frame_01("[F6]     ");
			// Function F6 64
			break;
		case 0x41:
			Head.frame_01("[F7]     ");
			// Function F7 65
			break;
		case 0x42:
			Head.frame_01("[F8]     ");
			// Function F8 66
			break;
		case 0x43:
			Head.frame_01("[F9]     ");
			// Function F9 67
			break;
		case 0x44:
			Head.frame_01("[F10]    ");
			// Function F10 68
			break;
		case 0x45:
			if (numb == false) {
				Head.frame_01("[Num]    ");
				// Function Number 69
				numb = true;
			} else {
				Head.frame_01("       ");
				// Function Number 69
				numb = false;
			}
			break;
		case 0x46:
			if (this.scrolllock == false) {
				Head.frame_01("[Rollen] ");
				// Function Rollen runter 70
				this.scrolllock = true;
			} else {
				Body.frame(tab);
				// Function Rollen runter 70
				this.scrolllock = false;
			}
			break;
		case 0x47:
			if (numb == false) {
				Body.Pos1(); // Function Pos1 71 // mit
														// Num Zahl 7
			} else
				symbol = "7";
			break;
		case 0x48:
			if (numb == false) {
				Head.frame_01("[Pfeil U]");
				// Function Pfeil Oben 72 // mit Num Zahl 8
				Body.Up();
			} else
				symbol = "8";
			break;
		case 0x49:
			if (numb == false) {
				Head.frame_01("[Bild O] ");
				// Function Bild Oben 73 // mit Num Zahl 9
			} else
				symbol = "9";
			break;
		case 0x4A:
			symbol = "-"; // Function Strich 74
			break;
		case 0x4B:
			if (numb == false) {
				Head.frame_01("[Pfeil L]");
				// Function Pfeil links 75 // mit Num Zahl 4
				Body.Left();
			} else
				symbol = "4";
			break;
		case 0x4C:
			if (numb == true) // Function mit Num Zahl 5 76
				symbol = "5";
			break;
		case 0x4D:
			if (numb == false) {
				Head.frame_01("[Pfeil R]");
				// Function Pfeil rechts 77 // mit Num Zahl 6
				Body.Right();
			} else
				symbol = "6";
			break;
		case 0x4E:
			symbol = "+"; // Function Plus 78
			break;
		case 0x4F:
			if (numb == false) {
				Head.frame_01("[End]    ");
				// Function End 79 // mit Num Zahl 1
			} else
				symbol = "1";
			break;
		case 0x50:
			if (numb == false) {
				Head.frame_01("[Pfeil O]");
				// Function Pfeil runter 80 // mit Num Zahl 2
				Body.Down();
			} else
				symbol = "2";

			break;
		case 0x51:
			if (numb == false) {
				Head.frame_01("[Bild D] ");
				// Function Bild runter 81 // mit Num Zahl 3
			} else
				symbol = "3";
			break;
		case 0x52:
			if (numb == false) {
				Head.frame_01("[Einf]   ");
				// Function Einf 82 // mit Num Zahl 0
			} else
				symbol = "0";
			break;
		case 0x53:
			if (numb == false) {
				Head.frame_01("[Entf]   ");
				// Function Entf 83 // mit Num Zahl
				Body.entf();
			} else
				symbol = ",";
			break;
		case 0x54:
			symbol = ""; // Function Nicht belegt 84
			break;
		case 0x55:
			if (caps)
				caps = false;
			else
				symbol = ""; // Function Nicht belegt 85
			break;
		case 0x56:
			if (caps)
				symbol = ">";
			else
				symbol = "<"; // Function < 86
			break;
		case 0x57:
			Head.frame_01("[F11]   ");
			// Function F11 87
			break;
		case 0x58:
			Head.frame_01("[F12]    ");
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


}
