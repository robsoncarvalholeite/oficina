package br.com.integralabs.oficina.controller.generic;

import java.util.Calendar;

/**
 * Created by robson on 03/09/17.
 */
public class RestResponseException extends Exception {

    private Long timestamp;
    private String status;
    private String error;
    private String message;
    private String path;

    public RestResponseException(String status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = Calendar.getInstance().getTimeInMillis();
    }

    public String getStatus() {
        return status;
    }

    public RestResponseException setStatus(String status) {
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
