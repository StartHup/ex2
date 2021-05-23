import java.util.*;
public class MediaPlayerApp implements App{
    
    private static Scanner s = new Scanner(System.in);
    
    //Linked list to store all the media
    private ArrayList<Media> mediaList;
    
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
        System.out.print("Choose the type of the new file (1 for video, 2 for audio): ");
        String fileType = s.nextLine();
        
        //Check valid file type
        if (!(isStringDigits(fileType))){
            System.out.println("Invalid input!");
            return;
        }
        
        //Convert input to int
        int fileTypeInt = Integer.parseInt(fileType);

        //Check valid file type number
        if (fileTypeInt != 1 && fileTypeInt != 2){
            System.out.println("Invalid input!");
            return;
        }

        //Retrieve name of new file
        System.out.print("Enter the name of the new file (case sensitive): ");
        String fileName = s.nextLine();
        
        //Check name validity
        if (fileName.length() < 1){
            System.out.println("Improper name length! Must be at least 1 character.");
            return;
        }
        
        //Input new file length
        System.out.print("Enter file length in seconds: ");
        String fileLength = s.nextLine();

        //Check input validity
        if (!(isStringDigits(fileLength))){
            System.out.println("Only digits allowed in file length!");
            return;
        }
        
        //Convert length to int
        int fileLengthInt = Integer.parseInt(fileLength);
        
        //Check number validity: must be positive and less than 2,000,000,000
        if (fileLengthInt < 0){
            System.out.println("File length must be positive!");
            return;
        }
        if (fileLengthInt > 2000000000){
            System.out.println("File length must not exceed 2 billion seconds!");
            return;
        }
        
        //Create new file object per chosen type
        if (fileTypeInt == 1) { // 1 = video as defined above
            Media newFile = new VideoFile(fileName, fileLengthInt);
            addNewMediaFile(newFile);
        }
        
        else if (fileTypeInt == 2) { // 2 = audio as defined above
            Media newFile = new AudioFile(fileName, fileLengthInt);
            addNewMediaFile(newFile);
        }
                
        //Add new file to file list
        System.out.println("File \"" + fileName + "\" added successfully.");
        
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
    
    public void playFileByName(){
        System.out.print("Enter file you would like to play: ");
        String name = s.nextLine();
        
        for (Media file : mediaList){
            if(file.getName().equals(name)){
                file.executeFile();
                return;
            }
        }
        
        System.out.println("Coulnd't find the file \"" + name + "\".");
        
    }

    @Override
    public void printAllContents(){
        playAllFiles();
    }

    public void playAllFiles(){
        for (Media file : mediaList){
            file.executeFile();
        }
    }

    
    @Override
    public void runApp(){
        Scanner s = new Scanner(System.in);
        String input = "";
        
        while (!input.equals("4")){
            printMenu();
            
            System.out.print("Enter a number to make a selection: ");
            input = s.nextLine();
            
            switch (input){
                case "1":
                    createNewMediaFile();
                break;
                                
                case "2":
                    playFileByName();
                break;
                
                case "3":
                    playAllFiles();
                break;
                
                case "4":
                    //Exit gracefully
                    System.out.println("Exiting Media Player App...");
                    //mediaPlayer.exitApp();
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
        System.out.println(" 1 - Add a new media file.");
        System.out.println(" 2 - Play a media file (by name).");
        System.out.println(" 3 - Play all media files by type (audio or video).");
        System.out.println(" 4 - Exit Media Player App.");
    }
    
    @Override
    public void exitApp() {
        s.close();
        System.out.println("Exiting media");

    }

    @Override
    public String getAppName() {
        return "Media";
    }

} 
