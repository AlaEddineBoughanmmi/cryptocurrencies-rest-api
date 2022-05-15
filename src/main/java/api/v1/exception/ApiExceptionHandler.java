package api.v1.exception;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConversionFailedException.class)
    public Map<String, String> handleInvalidDateFormat(ConversionFailedException e) {
        Map<String, String> error = new HashMap<>();
        error.put("msg", "The passed value " + e.getValue() + " is invalid: expected date format : yyyy-mm-dd ");
        error.put("timestamp", String.valueOf(new Date()));
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public Map<String, String> handleNumberFormatException(NumberFormatException e) {
        Map<String, String> error = new HashMap<>();
        error.put("msg", "The passed value " + e.getMessage() + " is invalid: expected number");
        error.put("timestamp", String.valueOf(new Date()));
        return error;
    }
}
