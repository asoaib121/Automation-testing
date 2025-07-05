package Amazon.exceptions;

//Custom exception class for handling framework-related runtime issues
public class FrameworkException extends RuntimeException {
    //Constructor that accepts only a custom message
    public FrameworkException(String message){
        //Passes the message to the parent RuntimeException class
        super(message);
    }
    //Constructor that accepts a custom message and a cause (another exception)
    public FrameworkException(String message,Throwable cause){
        //Passes both message and root cause to the parent class.
        super(message,cause);
    }
}
