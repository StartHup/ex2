public class VideoFile extends Media {
    
    public VideoFile(String fileName, int fileLength){
        //Input validation happens in MediaPlayerApp.java
        this.fileName = fileName;
        this.fileLength = fileLength;
    }
    
    public String getMediaType() {
        return "Video";
    }
    
    public void executeFile() {
        System.out.println("Video file " + this.getName() + "playing for " 
            + this.formatLength());
    }
    
}
