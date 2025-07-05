package Amazon.exceptions;
//Suppress serialization-related warnings since no serialVersionUID is defined
@SuppressWarnings("serial")
//Custom exception class for handling invalid property file paths
//This class extends InvalidPathForExcelException to reuse its structure
 public class InvalidPathForProertyFileException extends InvalidPathForExcelException {
    //Constructor that accepts only a message
    public InvalidPathForProertyFileException(String message) {
        // Pass the message to the parent class (InvalidPathForExcelException)
        super(message);
    }
    //Constructor that accepts both a message and a cause (original exception)
    public InvalidPathForProertyFileException(String message,Throwable cause) {
        // Pass the message and cause to the parent class
        super(message,cause);
    }
}
