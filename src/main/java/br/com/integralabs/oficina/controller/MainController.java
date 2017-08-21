package br.com.integralabs.oficina.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by robson on 16/08/17.
 */
@RestController
public class MainController extends GenericController {

    @RequestMapping("/ping")
    public String ping() {
        LOGGER.info("Ping Request detected.");
        return String.format("now: %s, UUID: %s", Calendar.getInstance().getTime(), UUID.randomUUID().toString());
    }
}
