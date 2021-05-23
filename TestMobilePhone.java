import java.util.*;

class TestMobilePhone{

    public static App[] apps = new App[4];
    static Scanner s = new Scanner(System.in);
    //all apps can see all apps
    public static App[] apps = new App[4];
    public static void main(String[] args){

        apps[0] = new CalendarApp();
        apps[1] = new PhoneBookApp();
        apps[2] = new MessengerApp();
        apps[3] = new MediaPlayerApp();      

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