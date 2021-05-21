import java.util.*;
import java.text.*;

public class Meeting extends BusyDate {
    protected Contact contact;

    public Contact getContact(){
        return contact;
    }

    public Meeting(Date date, int duration, Contact contact){
        //Input validation happens in app
        this.date = date;
        this.duration = duration;
        this.contact = contact;
    }

    public void printEntry(){
        System.out.println("Day of meeting: " + this.getDate() + " ");

        SimpleDateFormat formattedTime = new SimpleDateFormat("'at' HH:mm");

        System.out.println(formattedTime.format(this.date));

        System.out.println("Contact: " + this.contact.toString());
    }

}
