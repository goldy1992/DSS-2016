package practica2.comunication;

import org.springframework.http.HttpStatus;

/**
 * Created by Mike on 14/11/2016.
 */
public class ErrorResponse {

    private HttpStatus errorCode;
    private String message;


    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

