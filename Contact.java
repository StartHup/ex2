
public class Contact {
    private String name, phoneNumber;
    
    public Contact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Contact)) {return false;}
        
        Contact temp = (Contact)obj;
        
        return name.equals(temp.name) && phoneNumber.equals(temp.phoneNumber);
    }
    
    @Override
    public String toString(){
        return name + " - " + phoneNumber;
    }    
    
    public String getName(){
        return this.name;
    }
    public String getNumber(){
        return this.phoneNumber;
    }
}