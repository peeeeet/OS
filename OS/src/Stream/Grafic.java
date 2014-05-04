package Stream;

public class Grafic extends Output {

	public static void rasterCircle(int x0, int y0, int radius, int color) {
		int f = 1 - radius;
		int ddF_x = 0;
		int ddF_y = -2 * radius;
		int x = 0;
		int y = radius;

		putPixel(x0, y0 + radius, color);
		putPixel(x0, y0 - radius, color);
		putPixel(x0 + radius, y0, color);
		putPixel(x0 - radius, y0, color);

		while (x < y) {
			if (f >= 0) {
				y--;
				ddF_y += 2;
				f += ddF_y;
			}
			x++;
			ddF_x += 2;
			f += ddF_x + 1;

			putPixel(x0 + x, y0 + y, color);
			putPixel(x0 - x, y0 + y, color);
			putPixel(x0 + x, y0 - y, color);
			putPixel(x0 - x, y0 - y, color);
			putPixel(x0 + y, y0 + x, color);
			putPixel(x0 - y, y0 + x, color);
			putPixel(x0 + y, y0 - x, color);
			putPixel(x0 - y, y0 - x, color);
		}
	}

	public static void biosScreen()
{	
	
	// Muster
	for(int i=0;i < 200;i++)
	{
		for(int j=0; j<320;j++)
			putPixel(j, i, Colors.blue);
	}
	
	for(int i=20;i>=0;i--)
		rasterCircle(200, 100, i, Colors.black); // yellow 0x2D
	
	for(int i=30;i>=0;i--)
		rasterCircle(60, 120, i, Colors.black); // organge 0x2C
	
	for(int i=30;i>=0;i--)
		rasterCircle(240, 80, i, Colors.black); // organge 0x2C
	
	for(int i=20;i>=0;i--)
		rasterCircle(100, 100, i, Colors.black); // organge/red 0x2B
	
	for(int i=40;i>=0;i--)
		rasterCircle(150, 100, i, Colors.black); // 
	
	for(int i=0; i<60;i++)
	{
		for(int j=0;j<320;j++)
		{
		putPixel(j,i,Colors.black);
		}
	}
	
	for(int i=140;i < 200;i++)
	{
		for(int j=0;j<320;j++)
			putPixel(j, i, Colors.black);			
	}
	
	for(int i=20;i>=0;i--)
		rasterCircle(140, 30, i, Colors.blue); // organge 0x2C
	


	for(int i=10;i>=0;i--)
		rasterCircle(140, 30, i, Colors.black); // organge 0x2C
	
	// S kreise
	rasterCircle(180, 40, 10, Colors.blue); // 
	rasterCircle(180, 21, 10, Colors.blue); // organge 0x2C

	
	// S quadrad
	for(int i=178;i < 195;i++)
	{
		for(int j=21;j<30;j++)
			putPixel(i, j, Colors.black);			
	}
	// S quadrat
	for(int i=163;i < 175;i++)
	{
		for(int j=31;j<40;j++)
			putPixel(i, j, Colors.black);			
	}
	
}
	
}
