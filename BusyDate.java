import java.util.*;

public abstract class BusyDate extends Date{
    //private ArrayList<BusyDate> busyDateList;   //Take this away
    protected Date date;
    protected int duration;

    public int getDuration(){
        return duration;
    }

   public abstract void printEntry();


}
