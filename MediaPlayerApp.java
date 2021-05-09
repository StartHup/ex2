import java.util.*; 
public class MediaPlayerApp implements App{

    @Override
<<<<<<< HEAD
    public void runApp() {
        // TODO Auto-generated method stub

=======
    public void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println(" 1 - Add a new media file.");
        System.out.println(" 2 - Play a media file (by name).");
        System.out.println(" 3 - Play all media files by type (audio or video).");
        System.out.println(" 4 - Exit Media Player App.");
        
>>>>>>> c8fcff7 (Create Media Player App menus)
    }
    
    public static void menu(MediaPlayerApp mediaPlayer){
        Scanner s = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("4")){
            mediaPlayer.printMenu();
            
            System.out.println("Enter a number to make a selection: ");
            input = s.nextLine();
            
            switch (input){
                case "1":
                    mediaPlayer.addNewFile();
                break;
                
                case "2":
                    mediaPlayer.playMediaFile();
                break;
                
                case "3":
                    mediaPlayer.playAllFilesByType();
                break;
                
                case "4":
                    //Exit gracefully
                    System.out.println("Exiting Media Player App...");
                    mediaPlayer.exitApp();
                break;
                
                default:
                System.out.println("Invalid input. Please try again.\n");
            } 
        }
    }
    
    
    
    @Override
    public void exitApp() {
        // TODO Auto-generated method stub

    }

} 
