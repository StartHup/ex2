public class VideoFile extends Media {
    
    public String getMediaType() {
        return "Video";
    }
    
    public void executeFile() {
        System.out.println("Video file " + this.getName() + "playing for " 
            + this.formatLength());
    }
    
}
