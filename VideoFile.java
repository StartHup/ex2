public class VideoFile extends Media {
    
    public VideoFile(String fileName, Integer fileLength){
        //Input validation happens in MediaPlayerApp.java
        this.fileName = fileName;
        this.fileLength = fileLength;
    }
    
    public String getMediaType() {
        return "Video";
    }
    
    public void executeFile() {
        System.out.println();
        System.out.println("Video file \"" + this.getName() 
            + "\" is now playing for " + this.formatLength());
    }
    
}
