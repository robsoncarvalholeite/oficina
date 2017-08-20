package br.com.integralabs.oficina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan({"br.com.integralabs.oficina"})
public class OficinaApp {
    public static void main(String[] args) {
        SpringApplication.run(OficinaApp.class, args);
    }
}
