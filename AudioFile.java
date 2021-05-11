public class AudioFile extends Media {
    
    public AudioFile(String fileName, Integer fileLength){
        //Input validation happens in MediaPlayerApp.java
        this.fileName = fileName;
        this.fileLength = fileLength;
    }
    
    public String getMediaType() {
        return "Audio";
    }
    
    public void executeFile() {
        System.out.println();
        System.out.println("Audio file \"" + this.getName() 
            + "\" is now playing for " + this.formatLength());
    }
    
}
