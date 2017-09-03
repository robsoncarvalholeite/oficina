package br.com.integralabs.oficina.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by robson on 16/08/17.
 */
@Configuration
public class AppConfig {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    /**
     * Thread pool size.
     */
    @Value("${scheduledExecutorService.corePoolSize:1}")
    private Integer corePoolSize;

    /**
     * Create default Spring ScheduledExecutorService config.
     *
     * @return Default ScheduledExecutorService.
     */
    @Bean
    public ScheduledExecutorService createScheduledExecutorService() {
        LOGGER.info("Creating ThreadPoolTaskExecutor [CorePoolSize: {}]", this.corePoolSize);
        return Executors.newScheduledThreadPool(this.corePoolSize);
    }
}
