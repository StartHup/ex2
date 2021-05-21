import java.util.ArrayList;

class MessegaChain{
    private ArrayList<String> messages;
    private Contact recipient;

    public MessegaChain(Contact other){
        this.recipient = other;
        messages = new ArrayList<String>();
    }

    public MessegaChain(Contact other, String firstMessage){
        this.recipient = other;
        messages = new ArrayList<String>();
        messages.add(firstMessage);
    }

    public void addMessage(String content){
        this.messages.add(content);
    }

    public void eraseChain(){
        this.messages.clear();
    }

    public String toString(){
        String ret = "Conversation with " + recipient.getName() + ":\n";
        for(String message: messages){
            ret += message +"\n";
        }
        ret += "";
        return ret;
    }

    public boolean doesStringExist(String text){
        for(String message: messages){
            if(message.indexOf(text) >-1){
                return true;
            }
        }
        return false;
    }

    public Contact getRecipient(){
        return this.recipient;
    }

    public ArrayList<String> getMessages(){
        return this.messages;
    }
}