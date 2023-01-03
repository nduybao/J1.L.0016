package MyException;

/**
 *
 * @author duyba
 */
public class GeneralException  extends Exception{
    public GeneralException(String str){
        super(str);
    }
    
    public GeneralException(String str, Throwable cause){
        super(str, cause);
    }
}
