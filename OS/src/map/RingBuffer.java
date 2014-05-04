package map;


public class RingBuffer {
	

private byte[] buffer;
private int curPos = 0;
private int readPos = 0;
private int count = 0;
private final int size = 50;

public void init()
{
	buffer = new byte[size];
}

public int getPos()
{
	return curPos;
}

public int getreadPos()
{
	return readPos;
}

public int getCount()
{
	return count;
}

public void add(byte val)
{
	
	if(curPos == size || curPos > size) curPos = 0;
	buffer[curPos++] = val;	
	count++;

}

public byte getCode()
{
	byte b = buffer[readPos];
	buffer[readPos++] = 0x0;
	count--;
	if(readPos == size || readPos > size) readPos = 0;
	return b;

}



}
