import java.util.*; 
public class Ex1 {
    public static void main(String[] args) {
        //Testing code
        Contact jacob = new Contact("Jacob L", "0507093602");
        
        Contact zach = new Contact("Zack", "0524524856");
        Contact bach = new Contact("Zadk", "0521524856");
        
        Contact cach = new Contact("Cack", "0000000000");
        Contact aach = new Contact("Aack", "1111111111");
        Contact bbach = new Contact("Back", "2222222222");

        //Create actual phonebook
        PhoneBook phoneBook = new PhoneBook(); 
        
        phoneBook.addContact(jacob);
        phoneBook.addContact(zach);
        phoneBook.addContact(bach);
        phoneBook.addContact(cach);
        phoneBook.addContact(aach);
        phoneBook.addContact(bbach);
        
        menu(phoneBook);
        
        
    }
    
    //Switchcase for menu
    public static void menu(PhoneBook phoneBook){
        Scanner s = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("11")){
            printMenu();
            
            System.out.println("Enter a number to make a selection: ");
            input = s.nextLine();
            
            switch (input){
                case "1":
                    phoneBook.addContact();
                break;
                
                case "2":
                    phoneBook.removeContact();
                break;
                
                case "3":
                    phoneBook.printPhonebook();
                break;
                
                case "4":
                    phoneBook.searchByName();
                break;
                
                case "5":
                    phoneBook.sortByName();
                break;
                
                case "6":
                    phoneBook.sortByNumber();
                break;
                                
                case "7":
                    //Remove duplicates function here
                    phoneBook.removeDuplicates();
                break;
                
                case "8":
                    //Reverse order of phonebook function here
                    phoneBook.reversePhoneBook();
                break;
                
                case "9":
                    //Export contacts to txt file function here
                    phoneBook.exportToFile();
                break;
                
                case "10":
                    //Import contacts from txt file function here
                    phoneBook.importFromFile();
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
        s.close();
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

}