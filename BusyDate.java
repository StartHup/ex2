import java.util.*;

public abstract class BusyDate extends Date {
    // private ArrayList<BusyDate> busyDateList; //Take this away
    protected Date date;
    protected int duration;

    // To track which event/meeting is which we have a static id for all BusyDate
    // objects
    static protected int masterID = 0;
    // Each object will also save its own id
    protected int busyDateID;

    public int getDuration() {
        return duration;
    }

    public int getMasterID() {
        return masterID;
    }

    public abstract void printEntry();

}
