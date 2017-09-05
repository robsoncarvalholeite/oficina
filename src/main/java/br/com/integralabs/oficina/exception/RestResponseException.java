package br.com.integralabs.oficina.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * Created by robson on 03/09/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"stackTrace", "suppressed"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseException extends Exception {

    private final Long timestamp;
    private final HttpStatus status;
    private final String error;
    private final String message;
    private final String path;
    private final String method;
    public RestResponseException(HttpStatus status, String message, HttpServletRequest request) {

        this.status = status;
        this.message = message;
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.error = status.getReasonPhrase();
        this.timestamp = Calendar.getInstance().getTimeInMillis();
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getError() {
        return this.error;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public String getPath() {
        return this.path;
    }

    public String getMethod() {
        return this.method;
    }
}
