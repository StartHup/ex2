public class AudioFile extends Media {
    
    public String getMediaType() {
        return "Audio";
    }
    
    public void executeFile() {
        System.out.println("Audio file " + this.getName() + "playing for " 
            + this.formatLength());
    }
    
}
