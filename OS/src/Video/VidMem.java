package Video;

import Memory.Const;

public class VidMem extends STRUCT {
	
public static final VidMem vid = (VidMem) MAGIC.cast2Struct(Const.VIDEO);

@SJC(count=2000)
public VidChar[] digit;

}