import java.util.*; 
public class MediaPlayerApp implements App{
    
    static Scanner s = new Scanner(System.in);
    
    //Linked list to store all the media
    ArrayList<Media> mediaList;
    
    //Constructor
    public MediaPlayerApp() {
        mediaList = new ArrayList<Media>();
    } 
    
    public void addNewMediaFile(Media mediaFile){
        if (mediaFile != null){
            mediaList.add(mediaFile);
        }
    }
    
    public void createNewMediaFile(){
        
        //Retrieve file type
        System.out.println("Enter the type of the new file (video or audio): ");
        String fileType = s.nextLine();
        
        //Check valid file type
        
        //Retrieve name of new file
        System.out.println("Enter the name of the new file (case sensitive): ");
        String fileName = s.nextLine();
        
        //Check name validity
        if (fileName.length() < 1){
            System.out.println("Improper name length! Must be at least 1 character.");
            return;
        }
        
        //Input new file length
        System.out.println("Enter file length in seconds: ");
        String number = s.nextLine();

        //Check number validity
        if (!(isStringDigits(number))){
            System.out.println("Only digits allowed in file length!");
            return;
        }

        //Create contact
        Media contact = new Contact(name, number);
        
        //Add contact to phonebook
        phoneBook.add(contact);
        System.out.println("Contact " + contact + " added successfully");
        return;
    }
    
    public boolean isListEmpty(){
        return mediaList.size() == 0;
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
    
    @Override
    public void runApp(){
        Scanner s = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("4")){
            printMenu();
            
            System.out.println("Enter a number to make a selection: ");
            input = s.nextLine();
            
            switch (input){
                case "1":
                    System.out.println("Add new file.");
                    //mediaPlayer.addNewFile();
                break;
                                
                case "2":
                    System.out.println("Play file");
                    //mediaPlayer.playMediaFile();
                break;
                
                case "3":
                    System.out.println("playAllFilesByType");
                    //mediaPlayer.playAllFilesByType();
                break;
                
                case "4":
                    //Exit gracefully
                    System.out.println("Exiting Media Player App...");
                    //mediaPlayer.exitApp();
                break;
                
                default:
                System.out.println("Invalid input. Please try again.\n");
            }
            System.out.println("");
        }
        s.close();
    }
    
    public void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println(" 1 - Add a new media file.");
        System.out.println(" 2 - Play a media file (by name).");
        System.out.println(" 3 - Play all media files by type (audio or video).");
        System.out.println(" 4 - Exit Media Player App.");
    }
    
    @Override
    public void exitApp() {
        // TODO Auto-generated method stub

    }

} 
