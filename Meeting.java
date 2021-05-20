import java.util.Date;

public class Meeting extends BusyDate {
    protected Contact contact;

    public Contact getContact(){
        return contact;
    }

    public Meeting(Date date, int duration, Contact contact){
        this.date = date;
        this.duration = duration;
        this.contact = contact;
    }


}
