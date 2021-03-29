import java.util.*; 


public class main {
    public static void main(String[] args) {
        //Testing code
        Contact jacob = new Contact("Jacob L", "0507093602");
        
        Contact zach = new Contact("Zack", "0524524856");
        
        //Create actual phonebook
        ArrayList<Contact> phoneBook = new ArrayList<Contact>(); 
        
        phoneBook.add(jacob);
        phoneBook.add(zach);
        
        System.out.println(phoneBook);
        
        menu();
    }
    
    //Switchcase for menu
    public static void menu(){
                
        Scanner s = new Scanner(System.in);
        while (true){
            printMenu();
            
            System.out.println("Enter a number to make a selection: ");
            String input = s.nextLine();
            
            switch (input){
                case "1":
                    //Add contact function here
                    System.out.println("Add a new contact.");
                break;
                
                case "2":
                    //Delete contact function here
                    System.out.println("Delete a contact.");
                break;
                
                case "3":
                    //Print phonebook function here
                    System.out.println("Print phonebook.");
                break;
                
                case "4":
                    //Search for contact function here
                    System.out.println("Search for contact.");
                break;
                
                case "5":
                    //Sort phonebook by name function here
                    System.out.println("Sort phonebook by name.");
                break;
                
                case "6":
                    //Sort phonebook by phone number function here
                    System.out.println("Sort phonebook by phone number.");
                break;
                                
                case "7":
                    //Remove duplicates function here
                    System.out.println("Remove duplicates.");
                break;
                
                case "8":
                    //Reverse order of phonebook function here
                    System.out.println("Reverse order of phonebook.");
                break;
                
                case "9":
                    //Export contacts to txt file function here
                    System.out.println("Export contacts to txt file.");
                break;
                
                case "10":
                    //Import contacts from txt file function here
                    System.out.println("Import contacts from txt file.");
                break;
                
                case "11":
                    //Exit gracefully
                    System.out.println("Exiting...");
                break;
                
                default:
                System.out.println("Invalid input. Please try again.\n");
            }
            System.out.println("");
            
        }

        
    }
    public static void printMenu(){
        System.out.println("What would you like to do?");
        System.out.println(" 1 - Add a new contact.");
        System.out.println(" 2 - Delete a contact.");
        System.out.println(" 3 - Print phonebook.");
        System.out.println(" 4 - Search for contact.");
        System.out.println(" 5 - Sort phonebook by name.");
        System.out.println(" 6 - Sort phonebook by phone number.");
        System.out.println(" 7 - Remove duplicates.");
        System.out.println(" 8 - Reverse order of phonebook.");
        System.out.println(" 9 - Export contacts to txt file.");
        System.out.println("10 - Import contacts from txt file.");
        System.out.println("11 - Exit");
    }

    public static void addContact(){
        Scanner s = new Scanner(System.in);

        //Input new contact name
        System.out.println("Enter name of new contact: ");
        //Limitations on contact name? Length 30
        String name = s.nextLine();

        //Check name validity
        if (!(isStringProperLength(name, 1, 30))){
            System.out.println("Improper name length! Must be between 1 and 30 characters.");
            s.close();
            return;
        }
        
        //Input new contact number
        System.out.println("Enter phone number. Must be exactly 9 or 10 digits long: ");
        String number = s.nextLine();

        //Check number validity
        if (!(isStringDigits(number))){
            System.out.println("Only digits allowed in phone number!");
            s.close();
            return;
        }
        if (!(isStringProperLength(number, 9, 10))){
            System.out.println("Only 9 or 10 digit numbers allowed!");
            s.close();
            return;
        }


        s.close();
    }

    public static boolean isStringProperLength(String name, int min, int max){
        return (name.length() >= min && name.length() <= max); 
    }

    public static boolean isStringDigits(String string){
        try{
            //If parseInt completes properly => string is entirely digits
            Integer intValue = Integer.parseInt(string);
            //No use for intValue
            return true;
        }
        //If NumberFormatException caught => there is a nondigit somewhere
        catch (NumberFormatException e){
            return false;
        }
    }
}
