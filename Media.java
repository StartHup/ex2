public abstract class Media{
    protected String fileName;
    protected Integer fileLength;
    //C'tor
    
    public String getName() {
        return fileName;
    }
        
    public Integer getLength() {
        return fileLength;
    }

    public String formatLength() {
        //Trust the math, it works :)
        Integer hours = this.getLength() / 3600;
        Integer minutes = (this.getLength() / 60) % 60;
        Integer seconds = this.getLength() % 60;
        
        String length = hours +  " hours, " + minutes + " minutes, and " 
            + seconds + " seconds.";

        return length;
    }
    
    public abstract void executeFile();
    public abstract String getMediaType();
} 
