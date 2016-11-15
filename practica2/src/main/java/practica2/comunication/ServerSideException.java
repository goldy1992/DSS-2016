package practica2.comunication;

import org.springframework.http.HttpStatus;

/**
 * Created by Mike on 14/11/2016.
 */
public class ServerSideException extends Exception{

    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private HttpStatus errorCode;

    public String getErrorMessage() { return errorMessage;    }
    public HttpStatus getErrorCode() { return  errorCode; }

    public ServerSideException(String errorMessage, HttpStatus errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ServerSideException() {
        super();
    }
}
