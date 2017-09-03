package br.com.integralabs.oficina.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by robson on 16/08/17.
 */
public class GenericController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(GenericController.class);

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handleAppException(HttpServerErrorException ex, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", Calendar.getInstance().getTimeInMillis());
        map.put("status", ex.getStatusCode());
        map.put("error", ex.getStatusText());
        map.put("message", ex.getMessage());
        map.put("path", request.getRequestURI());
        return new ResponseEntity(map, ex.getStatusCode());
    }
}
