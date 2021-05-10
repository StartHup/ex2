import java.util.*; 
public abstract class Media{
    String name;
    int length;
    //C'tor
    
    public String getName() {
        return name;
    }
        
    public int getLength() {
        return length;
    }

    public String formatLength() {
        //Trust the math, it works :)
        int hours = this.getLength() / 3600;
        int minutes = (this.getLength() / 60) % 60;
        int seconds = this.getLength() % 60;
        
        String length = hours + ":" + minutes + ":" + seconds;

        //For testing only
        System.out.println(length);

        return length;
        
    }
    
    public abstract void executeFile();
    
    public abstract String getMediaType();
} 
