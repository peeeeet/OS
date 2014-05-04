package kernel;

public class Debug {

	
	
	
public static void MethCall(int add)
	{
		int mthdAddr = add;
		MAGIC.inline(0x57, 0x56);
		MAGIC.inline(0x8B, 0x75,0x10);
		MAGIC.inline(0x8B,0x7D,0x0C);
		MAGIC.inline(0xFF,0x55,0x08);
		MAGIC.inline(0x5E,0x5F);
	}
}
