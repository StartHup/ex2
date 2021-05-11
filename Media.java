public abstract class Media{
    protected String fileName;
    protected int fileLength;
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
        
        String length = hours +  " hours, " + minutes + " minutes, and " 
            + seconds + " seconds.";

        return length;
    }
    
    public abstract void executeFile();
    public abstract String getMediaType();
} 
