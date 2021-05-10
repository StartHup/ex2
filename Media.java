public abstract class Media{
    String fileName;
    int fileLength;
    //C'tor
    
    public String getName() {
        return fileName;
    }
        
    public int getLength() {
        return fileLength;
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
