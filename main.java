import java.util.*; 


public class Main {

    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        //Testing code
        Contact jacob = new Contact("Jacob L", "0507093602");
        
        Contact zach = new Contact("Zack", "0524524856");
        Contact bach = new Contact("Zack", "0521524856");
        
        //Create actual phonebook
        ArrayList<Contact> phoneBook = new ArrayList<Contact>(); 
        
        phoneBook.add(jacob);
        phoneBook.add(zach);
        phoneBook.add(bach);

        System.out.println(phoneBook);
        
        menu(phoneBook);

        
    }
    
    //Switchcase for menu
    public static void menu(ArrayList<Contact> phoneBook){
                
        //Scanner s = new Scanner(System.in);
        while (true){
            printMenu();
            
            System.out.println("Enter a number to make a selection: ");
            String input = s.nextLine();
            
            switch (input){
                case "1":
                    addContact(phoneBook);
                    //System.out.println("Add a new contact.");
                break;
                
                case "2":
                    removeContact(phoneBook);
                    //System.out.println("Delete a contact.");
                break;
                
                case "3":
                    printPhonebook(phoneBook);
                    //System.out.println("Print phonebook.");
                break;
                
                case "4":
                    //Search for contact function here
                    searchByName(phoneBook);
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
                    phoneBook = removeDuplicates(phoneBook);
                break;
                
                case "8":
                    //Reverse order of phonebook function here
                    phoneBook = reversePhoneBook(phoneBook);
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

    public static void addContact(ArrayList<Contact> phoneBook){
        //Scanner s = new Scanner(System.in);

        //Input new contact name
        System.out.println("Enter name of new contact (case sensitive): ");
        //Limitations on contact name? Length 30
        String name = s.nextLine();

        //Check name validity
        if (!(isStringProperLength(name, 1, 30))){
            System.out.println("Improper name length! Must be between 1 and 30 characters.");
            return;
        }
        
        //Input new contact number
        System.out.println("Enter phone number. Must be exactly 9 or 10 digits long: ");
        String number = s.nextLine();

        //Check number validity
        if (!(isStringDigits(number))){
            System.out.println("Only digits allowed in phone number!");
            return;
        }
        if (!(isStringProperLength(number, 9, 10))){
            System.out.println("Only 9 or 10 digit numbers allowed!");
            return;
        }

        //Create contact
        Contact contact = new Contact(name, number);
        //Add contact to phonebook
        phoneBook.add(contact);
        System.out.println("Contact " + contact + " added successfully");
        return;
    }

    public static void removeContact(ArrayList<Contact> phoneBook){

        //Check if phonebook already empty
        if (isListEmpty(phoneBook)){
            System.out.println("Phonebook already empty!");
            return;
        }

        //Input name to be removed
        System.out.println("Enter name of contact to be removed (case sensitive): ");
        String name = s.nextLine();

        //Check if name even possible
        if (!(isStringProperLength(name, 1, 30))){
            System.out.println("No such contact!");
            return;
        }

        //Iterate through phonebook
        Iterator<Contact> itr = phoneBook.iterator();
        while (itr.hasNext()){
            //Check if next contact matches name
            if (itr.next().getName().equals(name)){
                itr.remove();
                System.out.println("Successfully removed " + name);
                return;
            }
        }

        System.out.println("No such contact!");

    }

    public static ArrayList<Contact> reversePhoneBook(ArrayList<Contact> phoneBook){
        ArrayList<Contact> reversedList = new ArrayList<Contact>();
        for (Contact contact : phoneBook){
            reversedList.add(0,contact);
        }
        return reversedList;
    }
    public static ArrayList<Contact> removeDuplicates(ArrayList<Contact> phoneBook){
        Set<Contact> removesDupsSet = new HashSet<Contact>(phoneBook);
        ArrayList<Contact> removeDups = new ArrayList<Contact>(removesDupsSet);
        return removeDups;
    }
    public static void searchByName(ArrayList<Contact> phoneBook){
        boolean found = false;
        System.out.println("Enter name you are seaching for:");
        String name = s.nextLine();
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        for (Contact contact : phoneBook){
            if(contact.getName().equals(name)){
                contacts.add(contact);
                System.out.println(contact);
                found = true;
            }
        }
        if(!found){
            System.out.println("Coulnd't find " + name);
        }
    }
    public static void printPhonebook(ArrayList<Contact> phoneBook){
        //Check if phonebook empty
        if (isListEmpty(phoneBook)){
            System.out.println("No contacts in phonebook!");
            return;
        }

        System.out.println("Here is your phonebook:");

        for (Contact contact : phoneBook){
            System.out.println(contact);
        }
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

    public static boolean isListEmpty(ArrayList<Contact> phoneBook){
        return (phoneBook.size() == 0);
    }
}
