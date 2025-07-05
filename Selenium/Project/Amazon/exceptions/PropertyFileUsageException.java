package Amazon.exceptions;
// Custom exception class for handling issues related to improper usage of property files
// This class extends FrameworkException to represent a framework-level error
public class PropertyFileUsageException extends FrameworkException {
    // Constructor that accepts only a custom error message
    public PropertyFileUsageException(String message){
        // Pass the message to the parent FrameworkException class
        super(message);
    }
    // Constructor that accepts a message and a cause (another throwable error)
    public PropertyFileUsageException(String message,Throwable cause){
        // Pass both the message and the cause to the parent class
        super(message,cause);
    }
}
