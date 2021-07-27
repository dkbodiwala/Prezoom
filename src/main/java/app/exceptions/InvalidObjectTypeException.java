package app.exceptions;

/**
 * Class : This class handles an exception for invalid objects selected.
 * This class extends the default Exception class.
 */
@SuppressWarnings("serial")
public class InvalidObjectTypeException extends Exception {
     /**
     * This is a constructor for the class InvalidObjectTypeException.
     * @param invalidType It returns a string value for the display message.
     */
    public InvalidObjectTypeException(String invalidType) {
        super("Invalid object type requested : " + invalidType);
    }
}
