
public class Contact {
    private String name, phoneNumber;
    
    public boolean equals(Object obj){
        if(!(obj instanceof Contact)) {return false;}
        
        Contact temp = (Contact)obj;
        
        return name.equals(temp.name) && phoneNumber.equals(temp.phoneNumber);
    }
    
    
    
    
    
    public String getName(){
        return this.name;
    }
    public String getNumber(){
        return this.phoneNumber;
    }
}