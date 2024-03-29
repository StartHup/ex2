import java.util.*;
class MessengerApp implements App{
    //Map from contact to their chain of messages
    private HashMap<Contact, MessegaChain> chains;
    static Scanner s = new Scanner(System.in);
    //Ctor
    public MessengerApp(){
        chains = new HashMap<Contact, MessegaChain>();
    }
    //Send a message
    public void addMessage(){
        System.out.println("To who would you like to write?");
        String name = s.nextLine();
        Contact recipient;
        //Try to find this contact in phone book app
        try{
            recipient = ((PhoneBookApp)(TestMobilePhone.apps[1])).getContactByName(name);
            System.out.println("What would you like to send to " + name + "?");
            String content = s.nextLine();
            //check if we've sent a message:
            if(chains.containsKey(recipient)){
                chains.get(recipient).addMessage(content);
            }
            else{
                chains.put(recipient, new MessegaChain(recipient, content));
            }
            System.out.println("Message sent successfuly");
        } catch(Exception ex){
            System.out.println(name + " is not a contact");
        }

    }
    //Deletes conversation with contact
    public void deleteConversation() {
        System.out.println("Who would you like to erase?");
        String name = s.nextLine();
        Contact recipient;
        try{
            recipient = ((PhoneBookApp)(TestMobilePhone.apps[1])).getContactByName(name);
            if(chains.containsKey(recipient)){
                chains.get(recipient).eraseChain();
            }
            System.out.println("Deleted messages with " + name);
        } catch(Exception ex){
            System.out.println(name + " is not a contact");
        }
    }
    //Display all conversations with certain contact
    public void printConversation(){
        System.out.println("Who's messages would you like to view?");
        String name = s.nextLine();
        Contact recipient;
        try{
            recipient = ((PhoneBookApp)(TestMobilePhone.apps[1])).getContactByName(name);
            if(chains.containsKey(recipient)){
                System.out.println(chains.get(recipient).toString());
            } else{
                System.out.println("No messages with " + name);
            }
        } catch(Exception ex){
            System.out.println(name + " is not a contact");
        }
    }
    //This function removes a contact, and gets the contact's reference as variable
    public void romoveContact(Contact c){
        if(chains.containsKey(c)){
            chains.remove(c);
        }
    }
    // Remove function when it gets the contact's name
    public void removeContact(String name){
        Contact recipient;
        try{
            recipient = ((PhoneBookApp)(TestMobilePhone.apps[1])).getContactByName(name);
            if(!(chains.containsKey(recipient))){
                System.out.println("No messages with " + name);
            }
            else{
                this.romoveContact(recipient);
            }
        } 
        catch(Exception ex){
            System.out.println(name + " is not a contact");
        }
        
    }

    //Search in all chains for a certain phrase
    public void searchForPhrase(){
        System.out.println("What phrase should we find?");
        String text = s.nextLine();
        boolean found = false;
        for(Contact contact: chains.keySet()){
            if(chains.get(contact).doesStringExist(text)){
                //if we havn't found yet, print header
                if(!found){
                    found = true;
                    System.out.println("Contacts with your phrase:");
                }
                System.out.println(contact.getName());
            }
        }
        if(!found){
            System.out.println("Phrase not foundd");
        }
    }
    
    @Override
    public void runApp() {
        menu();
    }

    @Override
    public void printAllContents() {
        for(MessegaChain chain: chains.values()){
            System.out.println(chain.toString());
        }
        
    }

    @Override
    public String getAppName() {
        return "Messanger";
    }

    @Override
    public void exitApp() {
        System.out.println("Exiting messanger app");
    }

    private void menu(){
        String input = "";
        
        while (!input.equals("6")){
            printMenu();
            
            System.out.println("Enter a number to make a selection: ");
            input = s.nextLine();
            
            switch (input){
                case "1":
                    this.addMessage();
                break;
                
                case "2":
                    this.deleteConversation();
                break;
                
                case "3":
                    this.printConversation();
                break;
                
                case "4":
                    this.searchForPhrase();
                break;
                
                case "5":
                    this.printAllContents();
                break;
                
                case "6":
                    this.exitApp();
                break;
                default:
                System.out.println("Invalid input. Please try again.");
            }
            
        }
    }
    
    private void printMenu(){
        System.out.println("What would you like to do?");
        System.out.println(" 1 - Add new message.");
        System.out.println(" 2 - Delete conversation.");
        System.out.println(" 3 - Print conversation with contact.");
        System.out.println(" 4 - Search for phrase.");
        System.out.println(" 5 - Print all conversations.");
        System.out.println(" 6 - exit.");
    }

}
