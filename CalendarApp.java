import java.util.*;

public class CalendarApp implements App {
    
    //List of days with events/meetings
    protected BusyDate[] calendar;
    
    public CalendarApp(){
        //calendar = new BusyDate[30];
        ArrayList<BusyDate>[] cal = new ArrayList[30];  //Change to calendar
    }
    
    public printCalendar(){
        // I will take your function of print by day and run for all days.
    }
    
    public printAllMeatingForContact(){

    }

    public overlapsCheck(){


    }

    @Override
    public void runApp() {
        // TODO Auto-generated method stub
        System.out.println("Calendar not ready");
    }
  
    @Override
    public void exitApp() {
        // TODO Auto-generated method stub

    }
    @Override 
    public String getAppName(){
        return "Calendar";
    }

    @Override
    public void printAllContents() {
        // TODO Auto-generated method stub
        this.printCalendar();
    }

}
