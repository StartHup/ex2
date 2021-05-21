import java.util.*;

public abstract class BusyDate extends Date{
    //private ArrayList<BusyDate> busyDateList;   //Take this away
    protected Date date;
    protected int duration;

    public int getDuration(){
        return duration;
    }

    // public Date getDateandTime(){
    //     return 
    // }

    // public ArrayList<BusyDate> getMeetingList(){
    //     return busyDateList;
    // }

    /* constructor
    * In: Day of month 
    * (note - this whole assigment takes place in one month, so no month or year)
    * Out - the busydate
    */
    // public BusyDate(long dateLong, int duration){
    //     //implement here
    //     Date date = new Date(dateLong);
    //     this.duration = duration;
    //     Iterator<BusyDate> dateItr = meetingList.iterator();
    // }



}
