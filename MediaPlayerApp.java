import java.util.*; 
public class MediaPlayerApp implements App{

    @Override
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void runApp() {
        // TODO Auto-generated method stub

=======
=======
>>>>>>> 3ed5e63 (Create Media Player App menus)
=======
>>>>>>> e0e2a9e (Create Media Player App menus)
    public void printMenu() {
        System.out.println("What would you like to do?");
        System.out.println(" 1 - Add a new media file.");
        System.out.println(" 2 - Play a media file (by name).");
        System.out.println(" 3 - Play all media files by type (audio or video).");
        System.out.println(" 4 - Exit Media Player App.");
        
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> c8fcff7 (Create Media Player App menus)
=======
>>>>>>> 3ed5e63 (Create Media Player App menus)
=======
>>>>>>> e0e2a9e (Create Media Player App menus)
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
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> e0e2a9e (Create Media Player App menus)
                    mediaPlayer.addNewFile();
                break;
                
                case "2":
                    mediaPlayer.playMediaFile();
                break;
                
                case "3":
                    mediaPlayer.playAllFilesByType();
<<<<<<< HEAD
>>>>>>> 3ed5e63 (Create Media Player App menus)
=======
>>>>>>> e0e2a9e (Create Media Player App menus)
                break;
                
                case "4":
                    //Exit gracefully
                    System.out.println("Exiting Media Player App...");
<<<<<<< HEAD
<<<<<<< HEAD
                    //mediaPlayer.exitApp();
=======
                    mediaPlayer.exitApp();
>>>>>>> 3ed5e63 (Create Media Player App menus)
=======
                    mediaPlayer.exitApp();
>>>>>>> e0e2a9e (Create Media Player App menus)
                break;
                
                default:
                System.out.println("Invalid input. Please try again.\n");
<<<<<<< HEAD
<<<<<<< HEAD
            }
            System.out.println("");
        }
        s.close();
=======
            } 
        }
>>>>>>> 3ed5e63 (Create Media Player App menus)
=======
            } 
        }
>>>>>>> e0e2a9e (Create Media Player App menus)
    }
    
    
    
    @Override
    public void exitApp() {
        // TODO Auto-generated method stub

    }

} 
