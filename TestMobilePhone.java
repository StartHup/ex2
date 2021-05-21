import java.util.*;
class TestMobilePhone{
    static Scanner s = new Scanner(System.in);
    //all apps can see all apps
    public static App[] apps = new App[4];
    public static void main(String[] args){
        
        MessangerApp whatsapp = new MessangerApp(); 
        apps[0] = new CalendarApp();
        apps[1] = new PhoneBookApp();
        apps[2] = whatsapp;
        MediaPlayerApp vlc = new MediaPlayerApp();

        apps[3] = vlc;
        vlc.addNewMediaFile(new VideoFile("video 1",1000000));
        vlc.addNewMediaFile(new AudioFile("song 1", 17));

        PhoneBookApp pb = (PhoneBookApp)(apps[1]);
        pb.addContact(new Contact("Shira", "123123"));
        pb.addContact(new Contact("J", "12313"));
        whatsapp.addMessage();
        whatsapp.addMessage();
        whatsapp.addMessage();

        System.out.println("To choose app enter 1. To print all contents enter 2. To exit enter 3");
        String choice = s.next();
        while (!choice.equals("3")){
            switch (choice){
                case "1":
                    app(apps);
                break;
                case "2":
                    printAllAppsContents(apps);
                break;  
                case "3":
                    System.out.println("Exiting.");
                break;
                default:
                    System.out.println("Bad input!");    
            }
            System.out.println("To choose app enter 1. To print all contents enter 2. To exit enter 3");
            choice = s.next();
        }
    }
    public static void app(App[] apps){
        for(int i=0; i<apps.length; i++){
            System.out.println("For " + apps[i].getAppName() + " enter " + i + ".");
        }
        int choice = s.nextInt();
        if (choice >=0 && choice < apps.length){
            apps[choice].runApp();
        }else{
            System.out.println("Bad input");
        }
    }
    public static void printAllAppsContents(App[] apps){
        for(App app: apps){
            app.printAllContents();
        }
    }
}