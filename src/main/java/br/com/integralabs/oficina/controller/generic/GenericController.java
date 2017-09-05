package br.com.integralabs.oficina.controller.generic;

import br.com.integralabs.oficina.exception.RestResponseException;
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
    public RestResponseException handleHttpServerErrorException(HttpServerErrorException ex, HttpServletRequest request) {
        return new RestResponseException(ex.getStatusCode(), ex.getMessage(), request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResponseException handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        return new RestResponseException(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

}
