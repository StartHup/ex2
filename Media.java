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
    
    public abstract String getMediaType();
} 
