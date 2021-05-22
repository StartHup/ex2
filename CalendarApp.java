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
        if (!(isStringDigits(entryType))) {
            System.out.println("Invalid input!");
            return;
        }

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
        if (!(isStringDigits(entryDate))) {
            System.out.println("Invalid input!");
            return;
        }

        // Convert input to int
        int entryDateInt = Integer.parseInt(entryDate);

        // Check valid date
        if (entryDateInt < 1 || entryDateInt > 30) {
            System.out.println("Invalid input!");
            return;
        }

        // Retrieve hour of event
        System.out.print("Enter hour of event (0-24): ");
        String hour = s.nextLine();

        // Check valid format
        if (!(isStringDigits(hour))) {
            System.out.println("Invalid input!");
            return;
        }

        int hourInt = Integer.parseInt(hour);
        if (hourInt < 0 || hourInt > 23) {
            System.out.println("Invalid input!");
        }

        // Retrieve minutes of event
        System.out.print("Enter minute of event (0-59): ");
        String minutes = s.nextLine();

        // Check valid format
        if (!(isStringDigits(minutes))) {
            System.out.println("Invalid input!");
            return;
        }

        int minutesInt = Integer.parseInt(minutes);
        if (minutesInt < 0 || minutesInt > 59) {
            System.out.println("Invalid input!");
        }

        // Retrieve duration of event
        System.out.print("Enter the duration of entry (in minutes): ");
        String duration = s.nextLine();

        // Check valid input
        if (!(isStringDigits(duration))) {
            System.out.println("Invalid input!");
            return;
        }

        // Convert input to int
        int durationInt = Integer.parseInt(duration);

        // Check valid duration
        if (durationInt < 1) {
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
        if (!(isStringDigits(day))) {
            System.out.println("Invalid input!");
            return;
        }

        int dayInt = Integer.parseInt(day);
        if (dayInt < 1 || dayInt > 30) {
            System.out.println("Invalid input!");
            return;
        }

        // Iterate through each entry and print
        for (BusyDate entry : Calendar.get(dayInt)) {
            entry.printEntry();
        }

    }

    public void printCalendar() {
        // I will take your function of print by day and run for all days.
    }

    // public printAllMeetingsForContact(){

    // }

    // public overlapsCheck(){

    // }

    public void userRemoveEntry() {
        System.out.print("Enter day of entry to be removed: ");
        String day = s.nextLine();
        int dayInt = Integer.parseInt(day);

        System.out.print("Enter ");
    }

    public void removeEntry(int index, int day) {
        Calendar.get(day).remove(index);
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
                    break;

                case "3":
                    printEntriesByDay();
                    break;

                case "7":
                    // Exit gracefully
                    System.out.println("Exiting Calendar App...");
                    break;

                default:
                    System.out.println("Invalid input. Please try again.\n");
            }
        }
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
        // this.printCalendar();
    }

    public boolean isStringDigits(String string) {
        try {
            // If parseInt completes properly => string is entirely digits
            Integer.parseInt(string);
            return true;
        }

        // If NumberFormatException caught => there is a nondigit somewhere
        catch (NumberFormatException e) {
            return false;
        }
    }
}