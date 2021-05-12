import java.util.*;
class TestMobilePhone{
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        App[] apps = new App[3];
        MediaPlayerApp vlc = new MediaPlayerApp();
        apps[2] = vlc;
        vlc.addNewMediaFile(new VideoFile("video 1",1000000));
        vlc.addNewMediaFile(new AudioFile("song 1", 17));
        System.out.println("To choose app enter 1. To print all all contens enter 2. To exit enter 3");
        String choice = s.next();
        while (!choice.equals("3")){
            switch (choice){
                case "1":
                    app(apps);
                break;
                case "2":
                    allApps(apps);
                break;  
                case "3":
                    System.out.println("Exiting.");
                break;
                default:
                    System.out.println("Bad input!");    
            }
            System.out.println("To choose app enter 1. To print all all contens, enter 2. To exit enter 3");
        }
    }
    public static void app(App[] apps){
        System.out.println("For SMS enter 1. For Calander enter 2. For Media enter 3");
        int choice = s.nextInt();
        if (choice >=1 && choice <=  3){
            apps[choice - 1].runApp();
        }else{
            System.out.println("Number out of range");
        }
    }
    public static void allApps(App[] apps){
        for(App app: apps){
            app.runApp();
        }
    }
}