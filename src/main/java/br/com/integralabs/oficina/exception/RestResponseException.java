package br.com.integralabs.oficina.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Calendar;

/**
 * Created by robson on 03/09/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"stackTrace", "suppressed"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseException extends Exception {

    private Long timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;

    public RestResponseException(HttpStatus status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.error = status.getReasonPhrase();
        this.timestamp = Calendar.getInstance().getTimeInMillis();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public RestResponseException setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public String getError() {
        return error;
    }

    public RestResponseException setError(String error) {
        this.error = error;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public RestResponseException setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public RestResponseException setPath(String path) {
        this.path = path;
        return this;
    }
}
