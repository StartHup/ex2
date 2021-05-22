import java.util.*;
import java.text.*;

public class Event extends BusyDate {
    protected String description;

    public String getDescription(){
        return description;
    }
    

    public Event(Date date, int duration, String description){
        this.date = date;
        this.duration = duration;
        this.description = description;
    }

    public void printEntry(){

        System.out.println();
        SimpleDateFormat formattedTime = new SimpleDateFormat("'Day of event: 'd' at 'HH:mm");

        System.out.println(formattedTime.format(this.date));

        System.out.println("Description: " + this.description);
    }

}
