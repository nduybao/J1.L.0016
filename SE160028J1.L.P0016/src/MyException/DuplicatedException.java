package MyException;

/**
 *
 * @author duyba
 */
public class DuplicatedException extends Exception{
    public DuplicatedException(String str) {
        super(str);
    }

    public DuplicatedException(String str, Throwable cause) {
        super(str, cause);
    }
}
