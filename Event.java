import java.util.Date;

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


}
