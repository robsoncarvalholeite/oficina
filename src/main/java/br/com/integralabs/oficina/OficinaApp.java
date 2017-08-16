package br.com.integralabs.oficina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OficinaApp {
    public static void main(String[] args) {
        SpringApplication.run(OficinaApp.class, args);
    }
}
