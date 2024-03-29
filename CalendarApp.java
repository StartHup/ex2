import java.util.*;

public class CalendarApp implements App {

    private static Scanner s = new Scanner(System.in);

    // List of days with events/meetings
    protected ArrayList<ArrayList<BusyDate>> Calendar;

    public CalendarApp() {
        // Up to and including day 30, we will ignore day 0
        Calendar = new ArrayList<ArrayList<BusyDate>>();
        // initializing
        for (int i = 0; i < 31; i++) {
            Calendar.add(new ArrayList<BusyDate>());
        }
    }

    public void createNewBusyDate() {
        // Retrieve entry type
        System.out.print("Choose the type of the new entry (1 for meeting, 2 for event): ");
        String entryType = s.nextLine();

        // Check valid entry type
        if (!(isStringDigits(entryType)))
            return;

        // Convert input to int
        int entryTypeInt = Integer.parseInt(entryType);

        // Check valid occasion type number
        if (entryTypeInt != 1 && entryTypeInt != 2) {
            System.out.println("Invalid input!");
            return;
        }

        // Retrieve date of month
        System.out.print("Enter the date of entry (between 1-30): ");
        String entryDate = s.nextLine();

        // Check valid input
        if (!(isStringDigits(entryDate)))
            return;

        // Convert input to int
        int entryDateInt = Integer.parseInt(entryDate);

        // Check valid date
        if (entryDateInt < 1 || entryDateInt > 30) {
            System.out.println("Invalid input!");
            return;
        }

        // Retrieve hour of event
        System.out.print("Enter hour of event (0-23): ");
        String hour = s.nextLine();

        // Check valid format
        if (!(isStringDigits(hour)))
            return;

        int hourInt = Integer.parseInt(hour);
        if (hourInt < 0 || hourInt > 23) {
            System.out.println("Invalid input!");
            return;
        }

        // Retrieve minutes of event
        System.out.print("Enter minute of event (0-59): ");
        String minutes = s.nextLine();

        // Check valid format
        if (!(isStringDigits(minutes)))
            return;

        int minutesInt = Integer.parseInt(minutes);
        if (minutesInt < 0 || minutesInt > 59) {
            System.out.println("Invalid input!");
            return;
        }

        // Retrieve duration of event
        System.out.print("Enter the duration of entry (1-60 minutes): ");
        String duration = s.nextLine();

        // Check valid input
        if (!(isStringDigits(duration)))
            return;

        // Convert input to int
        int durationInt = Integer.parseInt(duration);

        // Check valid duration
        if (durationInt < 1 || durationInt > 60) {
            System.out.println("Invalid input!");
            return;
        }

        if (entryTypeInt == 1) {
            System.out.print("Enter name of contact for meeting: ");
            String con = s.nextLine();
            // check that contact exists
            try {
                Contact contact = ((PhoneBookApp) (TestMobilePhone.apps[1])).getContactByName(con);
                // CALL CONSTRUCTOR HERE
                Date date = new Date(0, 0, entryDateInt, hourInt, minutesInt);
                Meeting meeting = new Meeting(date, durationInt, contact);

                // If first meeting on day - add to beginning of list
                if (Calendar.get(entryDateInt).size() == 0) {
                    Calendar.get(entryDateInt).add(meeting);
                    System.out.println("Meeting added.");
                }
                // If not first meeting - find the proper index
                else {
                    int count = 0;
                    // Iterate through list of meetings on date
                    for (BusyDate bd : Calendar.get(entryDateInt)) {
                        if (bd.date.after(date)) {
                            Calendar.get(entryDateInt).add(count, meeting);
                            System.out.println("Meeting added.");
                            return;
                        }
                        count++;
                    }
                    // If reached end of list - add to the end
                    Calendar.get(entryDateInt).add(count, meeting);
                    System.out.println("Meeting added.");
                }
            }
            // If contact doesn't exist (method throws exception)
            catch (Exception err) {
                System.out.println("Contact does not exist!");
                return;
            }
        }

        if (entryTypeInt == 2) {
            System.out.print("Enter short description of event: ");
            String description = s.nextLine();

            // CALL CONSTRUCTOR HERE
            Date date = new Date(0, 0, entryDateInt, hourInt, minutesInt);
            Event event = new Event(date, durationInt, description);

            // If first event on day - add to beginning of list
            if (Calendar.get(entryDateInt).size() == 0) {
                Calendar.get(entryDateInt).add(event);
                System.out.println("Event added.");
            }
            // If not first event - find the proper index
            else {
                int count = 0;
                // Iterate through list of events on date
                for (BusyDate bd : Calendar.get(entryDateInt)) {
                    if (bd.date.after(date)) {
                        Calendar.get(entryDateInt).add(count, event);
                        System.out.println("Event added.");
                        return;
                    }
                    count++;
                }
                // If reached end of list - add to the end
                Calendar.get(entryDateInt).add(count, event);
                System.out.println("Event added.");
            }

        }

    }

    public void printEntriesByDay() {
        System.out.print("Enter day to print: ");
        String day = s.nextLine();

        // Check valid input
        if (!(isStringDigits(day)))
            return;

        int dayInt = Integer.parseInt(day);
        if (dayInt < 1 || dayInt > 30) {
            System.out.println("Invalid input!");
            return;
        }

        // If day empty
        if (Calendar.get(dayInt).size() == 0) {
            System.out.println("No entries on this day!");
            return;
        }

        // Iterate through each entry and print
        for (BusyDate entry : Calendar.get(dayInt)) {
            entry.printEntry();
        }

    }

    public void printCalendar() {
        int numOfEmptyDays = 0;
        for (int i = 1; i < 31; i++) {
                // If day empty
                if (Calendar.get(i).size() == 0) {
                    numOfEmptyDays++;
                } 
                for (BusyDate entry : Calendar.get(i)) {
                    entry.printEntry();
                } 
            if (numOfEmptyDays == 30){
                System.out.println("Calendar empty!");
            }
        }
    } 

     public void printAllMeetingsForContact(){
        System.out.print("Enter name of contact for meeting: ");
        String con = s.nextLine();
        int meetingExist = 0;
        // check that contact exists
        try {
            Contact contact = ((PhoneBookApp) (TestMobilePhone.apps[1])).getContactByName(con);
            for (ArrayList<BusyDate> day : Calendar) {
                // Iterate through all BusyDates in day
                Iterator<BusyDate> itr = day.iterator();
                while (itr.hasNext()) {
                    BusyDate bd = itr.next();
                    // Only check if entry is meeting (not event)
                    if (bd instanceof Meeting) {
                        // If meeting with wanted contact - remove
                        if (((Meeting) bd).contact.getName().equals(con)) {
                            bd.printEntry();
                            meetingExist++;
                        }
                    }
                }
            }
            if( meetingExist == 0)
            System.out.println("Meeting with that contact doesn't exist");  
        }   
        // If contact doesn't exist (method throws exception)
        catch (Exception err) {
            System.out.println("Contact does not exist!");
            return;
        }
 }
     

     public void overlapsCheck(){
        int minute, hours = 0;
        for(int i = 1; i<31; i++){
            for(int k = 0; k<Calendar.get(i).size();k++){
                BusyDate bd = Calendar.get(i).get(k);
                for (int j = k+1;  j<Calendar.get(i).size();j++){
                    BusyDate bdnext = Calendar.get(i).get(j);
                    minute = bd.getDuration();
                    int x = bd.date.getMinutes() + minute;
                    if(x >= 60){
                       hours ++;
                       x = bd.date.getMinutes() + minute - 60;
                   }
                   Date newdate = new Date(0, 0, i , bd.date.getHours() + hours, x);
                   if(newdate.after(bdnext.date)){
                    System.out.println("Conflict removed");
                    removeByEntry(bdnext.busyDateID);
                    }
                }
            }
        }     
}

    public void userRemoveEntry() {
        // Get day of entry
        System.out.print("Enter day of entry to be removed: ");
        String input = s.nextLine();
        if (!(isStringDigits(input)))
            return;
        int dayInt = Integer.parseInt(input);

        // Get hour of entry
        System.out.print("Enter hour of entry: ");
        input = s.nextLine();
        if (!(isStringDigits(input)))
            return;
        int hourInt = Integer.parseInt(input);

        // Get minute of entry
        System.out.print("Enter day of entry: ");
        input = s.nextLine();
        if (!(isStringDigits(input)))
            return;
        int minuteInt = Integer.parseInt(input);

        // Create Date object with desired time to be removed, to use for comparison
        Date removeDate = new Date(0, 0, dayInt, hourInt, minuteInt);

        // Iterate through BusyDates on requeted day to find entry
        int count = 0;
        for (BusyDate bd : Calendar.get(dayInt)) {
            // If same time - remove
            if (bd.date.equals(removeDate)) {
                removeEntry(dayInt, count);
                System.out.println("Entry removed");
                return;
            }
            count++;
        }
        // If reached end of list - no such entry!
        System.out.println("No such entry!");
    }

    public void removeEntry(int day, int index) {
        Calendar.get(day).remove(index);
    }

    public void removeMeetingsByContact(String contact) {
        // Iterate through all days
        for (ArrayList<BusyDate> day : Calendar) {
            // Iterate through all BusyDates in day
            Iterator<BusyDate> itr = day.iterator();
            while (itr.hasNext()) {
                BusyDate bd = itr.next();
                // Only check if entry is meeting (not event)
                if (bd instanceof Meeting) {
                    // If meeting with wanted contact - remove
                    if (((Meeting) bd).contact.getName().equals(contact)) {
                        itr.remove();
                    }
                }
            }
        }
    }
    public void removeByEntry(int id){
        for(int i = 1; i<31; i++){
                if (Calendar.get(i).size()!=0){
                    for(int k = 0; k<Calendar.get(i).size();k++){
                    int currentId = Calendar.get(i).get(k).busyDateID;
                    if (currentId == id){
                        Calendar.get(i).remove(k);
                        return;
                    }
                }    
            }
        }
    }

    @Override
    public void runApp() {
        Scanner s = new Scanner(System.in);
        String input = "";

        while (!input.equals("7")) {
            printMenu();

            System.out.print("Enter a number to make a selection: ");
            input = s.nextLine();

            switch (input) {
                case "1":
                    createNewBusyDate();
                    break;

                case "2":
                    userRemoveEntry();
                    break;

                case "3":
                    printEntriesByDay();
                    break;

                case "4":
                    printAllMeetingsForContact();
                    break;

                case "5":
                    overlapsCheck();
                    break;

                case "6":
                    printAllContents();
                    break;

                case "7":
                    // Exit gracefully
                    System.out.println("Exiting Calendar App...");
                    break;

                default:
                    System.out.println("Invalid input. Please try again.\n");
            }
        }
        s.close();
    }

    public void printMenu() {
        System.out.println();
        System.out.println("------------------------");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println(" 1 - Add entry to calendar.");
        System.out.println(" 2 - Remove entry from calendar.");
        System.out.println(" 3 - Print all entries of day in order.");
        System.out.println(" 4 - Print all meetings with specific contact.");
        System.out.println(" 5 - Find and resolve conflicts.");
        System.out.println(" 6 - Print all entries.");
        System.out.println(" 7 - Exit app.");

    }

    @Override
    public void exitApp() {
        s.close();
        System.out.println("Exiting Calendar");

    }

    @Override
    public String getAppName() {
        return "Calendar";
    }

    @Override
    public void printAllContents() {
        // TODO Auto-generated method stub
         this.printCalendar();
    }

    public boolean isStringDigits(String string) {
        try {
            // If parseInt completes properly => string is entirely digits
            Integer.parseInt(string);
            return true;
        }

        // If NumberFormatException caught => there is a nondigit somewhere
        catch (NumberFormatException e) {
            System.out.println("Invalid input!");
            return false;
        }
    }
}