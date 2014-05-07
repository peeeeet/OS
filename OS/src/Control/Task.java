package Control;
import devices.Keyboard;
public class Task 
{
public int id;
public String clsName;
public String mthName;
public int mth;
public int prio;

public Task(int _id, String _clsName, String _mthName, int _mth, int _prio)
{
id = _id;
prio = _prio;
mthName = _mthName;
clsName = _clsName;
mth = _mth;
}



}
