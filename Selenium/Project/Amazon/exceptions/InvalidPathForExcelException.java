package Amazon.exceptions;
//Suppresses serialization-related warnings (since we are not defining serialVersionUID)
@SuppressWarnings("serial")
//Custom exception specifically for invalid Excel file paths.
//This extends another custom exception named InvalidPathForFilesException
public class InvalidPathForExcelException extends InvalidPathForFilesException{
    //Constructor that accepts only a message
    public InvalidPathForExcelException (String massage){
        //Pass the message to the parent constructor
        super(massage);
    }
        //Constructor that accepts both a message and a cause (another exception)
        public InvalidPathForExcelException (String massage,Throwable cause){
        //Pass both message and cause to the parent constructor
        super(massage,cause);
        }
}
