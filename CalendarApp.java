public class CalendarApp implements App {
    
    //List of days with events/meetings
    protected BusyDate[] calendar;
    
    public CalendarApp(){
        calendar = new BusyDate[30];
    }
  
    @Override
    public void runApp() {
        // TODO Auto-generated method stub
        System.out.println("Calender not ready");
    }
  
    @Override
    public void exitApp() {
        // TODO Auto-generated method stub

    }
    @Override 
    public String getAppName(){
        return "Calender";
    }

}
