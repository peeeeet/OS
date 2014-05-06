package Video;

import Memory.Memory;

public class VidMem extends STRUCT {
	
public static final VidMem vid = (VidMem) MAGIC.cast2Struct(Memory.VIDEO);

@SJC(count=2000)
public VidChar[] digit;

}