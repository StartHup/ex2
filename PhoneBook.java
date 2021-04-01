import java.util.*; 
class PhoneBook{
    static Scanner s = new Scanner(System.in);
    ArrayList<Contact> phoneBook;

    public PhoneBook(){
        phoneBook = new ArrayList<Contact>();
    } 
    public PhoneBook(PhoneBook other){
        this.phoneBook = new ArrayList<Contact>(other.phoneBook);
    }

    public void addContact(Contact contact){
        phoneBook.add(contact);
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
            if (itr.next().getName().equals(name)){
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
    }

    public void reversePhoneBook(){
        //new list that we will elements into
        ArrayList<Contact> reversedList = new ArrayList<Contact>();
        for (Contact contact : phoneBook){
            //add next contact at index 0, which will push all other contacts to the right.
            //After iterating over list the new list will be the original reversed
            reversedList.add(0,contact);
        }
        this.phoneBook = reversedList;

    }

    public void searchByName(){
        boolean nameFound = false;
        System.out.println("Enter name you are seaching for:");
        String name = s.nextLine();
        for (Contact contact : phoneBook){
            if(contact.getName().equals(name)){
                if(!nameFound){
                    System.out.println("Here are the contacts found with the name " +name+":");
                }
                System.out.println(contact);
                nameFound = true;
            }
        }
        if(!nameFound){
            System.out.println("Coulnd't find " + name);
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
}