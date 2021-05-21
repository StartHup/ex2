import java.util.*;

public class CalendarApp implements App {

    private static Scanner s = new Scanner(System.in);
    
    //List of days with events/meetings
    protected ArrayList<BusyDate>[] Calendar;
    
    public CalendarApp(){
        //Up to and including day 30, we will ignore day 0
        Calendar = new ArrayList[31];
        // initializing
        for (int i = 1; i < 31; i++){
            Calendar[i] = new ArrayList<BusyDate>();
        }  
    }

    public void createNewBusyDate(){
        //Retrieve occasion type
        System.out.print("Choose the type of the new entry (1 for meeting, 2 for event): ");
        String entryType = s.nextLine();
        
        //Check valid occasion type
        if (!(isStringDigits(entryType))){
            System.out.println("Invalid input!");
            return;
        }

        //Convert input to int
        int entryTypeInt = Integer.parseInt(entryType);

        //Check valid occasion type number
        if (entryTypeInt != 1 && entryTypeInt != 2){
            System.out.println("Invalid input!");
            return;
        }

        //Retrieve date of month
        System.out.print("Enter the date of entry (between 1-30): ");
        String entryDate = s.nextLine();

        //Check valid input
        if (!(isStringDigits(entryDate))){
            System.out.println("Invalid input!");
            return;
        }

        //Convert input to int
        int entryDateInt = Integer.parseInt(entryDate);

        //Check valid date
        if (entryDateInt < 1 || entryDateInt > 30){
            System.out.println("Invalid input!");
            return;
        }


        //Retrieve duration of event
        System.out.print("Enter the duration of entry (in minutes): ");
        String duration = s.nextLine();

        //Check valid input
        if (!(isStringDigits(duration))){
            System.out.println("Invalid input!");
            return;
        }

        //Convert input to int
        int durationInt = Integer.parseInt(duration);

        //Check valid duration
        if (durationInt < 1){
            System.out.println("Invalid input!");
            return;
        }

        if (entryTypeInt == 1){
            System.out.print("Enter name of contact for meeting: ");
            String con = s.nextLine();
            //check that contact exists
            try{
                Contact contact = ((PhoneBookApp)(TestMobilePhone.apps[2])).getContactByName(con);
                //CALL CONSTRUCTOR HERE
            }
            //If contact doesn't exist (function throws exception)
            catch(Exception err){
                System.out.println("Contact does not exist!");
                return;
            }
        }

        if (entryTypeInt == 2){
            System.out.print("Enter short description of event: ");
            //CALL CONSTRUCTOR HERE
        }

    }

    
    public printCalendar(){
        // I will take your function of print by day and run for all days.
    }
    
    public printAllMeetingsForContact(){

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

public boolean isStringDigits(String string){
    try {
        //If parseInt completes properly => string is entirely digits
        Integer.parseInt(string);
        return true;
    }
  
    //If NumberFormatException caught => there is a nondigit somewhere
    catch (NumberFormatException e){
        return false;
    }
}