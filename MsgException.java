package abelhinha;

class MsgException extends RuntimeException{ 
    
    public MsgException(String message){
        super(message);
    };
    
    public String eMessage(){
        return getMessage();
    }
}
