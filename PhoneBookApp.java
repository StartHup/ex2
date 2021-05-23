import java.util.*; 
import java.io.*;  // Import the File class

class PhoneBookApp implements App{
    static Scanner s = new Scanner(System.in);
    ArrayList<Contact> phoneBook;

    //constructor
    public PhoneBookApp() {
        phoneBook = new ArrayList<Contact>();
    } 
    
    //copy constructor
    public PhoneBookApp(PhoneBookApp other) {
        this.phoneBook = new ArrayList<Contact>(other.phoneBook);
    }

    public void addContact(Contact contact){
        if(contact != null){
            phoneBook.add(contact);
        }
    }

    public void addContact(){
        //Input new contact name
        System.out.println("Enter name of new contact (case sensitive): ");
        String name = s.nextLine();
        
        //Check name validity
        if (!(isStringProperLength(name, 1, 30))){
            System.out.println("Improper name length! Must be between 1 and 30 characters.");
            return;
        }

        //Check if the name doesn't exist
        for (Contact contact : phoneBook){
            if(contact.getName().equals(name)){
                System.out.println("There is a contact with that same name.");
                return;
            }           
        }
        
        //Input new contact number
        System.out.println("Enter phone number. Must be exactly 9 or 10 digits long (and start with 0): ");
        String number = s.nextLine();

        //Check number validity
        if (!(isStringDigits(number))){
            System.out.println("Number must be only digits and start with 0!");
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


    public void removeContact(){
        //Check if phonebook already empty
        if (isListEmpty()){
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
            Contact contact = itr.next();
            if (contact.getName().equals(name)){
              
                //Call MessengerApp to remove all messages with contact
                ((MessengerApp)(TestMobilePhone.apps[2])).removeContact(contact.getName());
              
                //Call CalendarApp to remove all meetings with contact
                ((CalendarApp)(TestMobilePhone.apps[0])).removeMeetingsByContact(name);  
                
                //Delete actual contact from phonebook
                itr.remove();
              
                System.out.println("Successfully removed " + name);
                return;
            }
        }

        System.out.println("No such contact!");
    }

    public void printPhonebook(){
        //Check if phonebook empty
        if (isListEmpty()){
            System.out.println("No contacts in phonebook!");
            return;
        }

        System.out.println("Here is your phonebook:");

        for (Contact contact : phoneBook){
            System.out.println(contact);
        }
    }

    public void removeDuplicates(){
        //move to set to remove duplicates
        Set<Contact> removesDupsSet = new HashSet<Contact>(phoneBook);
        
        //bring back to ArrayList
        this.phoneBook = new ArrayList<Contact>(removesDupsSet);
        
        System.out.println("Duplicates successfully removed.");
    }

    public void reversePhoneBook(){
        //new list that we will insert elements into
        ArrayList<Contact> reversedList = new ArrayList<Contact>();
        
        for (Contact contact : phoneBook){
            //add next contact at index 0, which will push all other contacts to the right.
            //After iterating over list the new list will be the original reversed
            reversedList.add(0,contact);
        }
        
        this.phoneBook = reversedList;
        
        System.out.println("Phonebook reversed.");
    }

    public Contact getContactByName(String name) throws Exception{
        for (Contact contact : phoneBook){
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        throw new Exception("Not found");
    }
    public void searchByName(){
        boolean nameFound = false;
        System.out.println("Enter name you are seaching for:");
        String name = s.nextLine();
        
        for (Contact contact : phoneBook){
            if(contact.getName().equals(name)){
                //if this is our first contact found with this name
                if(!nameFound){
                    nameFound = true; 
                    //print this message only first time we are printing to screen
                    System.out.println("Here are the contacts found with the name " + name + ":");
                }
                System.out.println(contact);
            }
        }
        
        if(!nameFound){
            System.out.println("Coulnd't find " + name);
        }
    }

    public void sortByName(){
        if (isListEmpty()){
            System.out.println("Phonebook empty!");
            return;
        }

        Collections.sort(this.phoneBook, new Comparator<Contact>(){
            public int compare(Contact c1, Contact c2){
                return String.valueOf(c1.getName()).compareTo(c2.getName());
            }
        });
    }

    public void sortByNumber(){
        if (isListEmpty()){
            System.out.println("Phonebook empty!");
            return;
        }

        this.phoneBook = quickSortNumber();
        
    }
    
    public void exportToFile(){
        System.out.println("Please enter the file name");
        String name = s.nextLine();
        String fileContent = "";
        for (Contact contact : phoneBook){
            fileContent = fileContent.concat(contact + "\n");
        }
        try{
            FileWriter writer = new FileWriter(name);
            writer.write(fileContent);
            writer.close();
        }
        catch(IOException ioexc){
            System.out.println(ioexc);
        }
    }
    
    public void importFromFile(){
        System.out.println("Please enter the file name");
        String name = s.nextLine();
        String line;
        String[] splitLine;
        File file = new File(name);
        
        try{
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine())
            {
                //read next line from file
                line = scan.nextLine();
                //split it to name and number
                splitLine = line.split(": ");
                Contact newContact = new Contact(splitLine[0], splitLine[1]);
                phoneBook.add(newContact);
            }
            scan.close();
        }
        
        catch(FileNotFoundException fnfe){
            System.out.println(fnfe);
        }
        
    }
    
    public boolean isStringProperLength(String name, int min, int max){
        return name.length() >= min && name.length() <= max; 
    }

    public boolean isStringDigits(String string){
        try{
            //If parseInt completes properly => string is entirely digits
            Integer.parseInt(string);
            return true;
        }
      
        //If NumberFormatException caught => there is a nondigit somewhere
        catch (NumberFormatException e){
            return false;
        }
    }

    public boolean isListEmpty(){
        return phoneBook.size() == 0;
    }

    public Contact getContactByName(String name) throws Exception{
        for (Contact contact : phoneBook){
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        throw new Exception("Not found");
    }


    public ArrayList<Contact> quickSortNumber(){
        if (isListEmpty()) //base case
            return phoneBook;

        ArrayList<Contact> sorted;
        ArrayList<Contact> smaller = new ArrayList<Contact>(); 
        ArrayList<Contact> greater = new ArrayList<Contact>(); 
        Contact pivot = phoneBook.get(0); // pivot is the first element

        int i,k = 0,c;

        Contact j;  
        
        for (i=1;i<phoneBook.size();i++) //loop the phoneBook
        {
            k = 0;
            j=phoneBook.get(i);
            c = j.getNumber().length();
            while(j.getNumber().charAt(k)==pivot.getNumber().charAt(k) && k<c-1)//dealing with Numbers begin identicaly 
                k++;
            if (j.getNumber().charAt(k)<pivot.getNumber().charAt(k)) // compare each contact to pivot 
                smaller.add(j);
            else
                greater.add(j);
        }
        
        this.phoneBook = smaller;
        smaller = quickSortNumber();
        this.phoneBook = greater;  
        greater = quickSortNumber();  // sort both halfs recursively
        smaller.add(pivot);          // add initial pivot to the end of the smaller 
        smaller.addAll(greater);     // add the  greater  to the smaller ones 
        sorted = smaller;            // assign it to sorted

        return sorted;
    }
    @Override
    public void runApp(){
        menu();
    }

    @Override
    public void printAllContents(){
        this.printPhonebook();
    }

    @Override
    public void exitApp(){
        System.out.println("Exiting Phonebook app and returning to main menu.");
        s.close();
    }
    
    @Override
    public String getAppName(){
        return "PhoneBook";
    }
    //Switchcase for menu
    private void menu(){
        Scanner s = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("11")){
            printMenu();
            
            System.out.println("Enter a number to make a selection: ");
            input = s.nextLine();
            
            switch (input){
                case "1":
                    this.addContact();
                break;
                
                case "2":
                    this.removeContact();
                break;
                
                case "3":
                    this.printPhonebook();
                break;
                
                case "4":
                    this.searchByName();
                break;
                
                case "5":
                    this.sortByName();
                break;
                
                case "6":
                    this.sortByNumber();
                break;
                                
                case "7":
                    //Remove duplicates function here
                    this.removeDuplicates();
                break;
                
                case "8":
                    //Reverse order of phonebook function here
                    this.reversePhoneBook();
                break;
                
                case "9":
                    //Export contacts to txt file function here
                    this.exportToFile();
                break;
                
                case "10":
                    //Import contacts from txt file function here
                    this.importFromFile();
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
    private void printMenu(){
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
