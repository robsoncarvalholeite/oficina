package br.com.integralabs.oficina.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by a.moreira.rodrigues on 19/08/2017.
 */
@Configuration
public class PersistenceConfig {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(this.env.getProperty("jdbc.driverClassName", "org.postgresql.Driver"));
        config.setJdbcUrl(this.env.getProperty("jdbc.url"));
        config.setUsername(this.env.getProperty("jdbc.username"));
        config.setPassword(this.env.getProperty("jdbc.password"));
        config.setMaximumPoolSize(this.env.getProperty("jdbc.maxPoolSize", Integer.class, 10));
        return new HikariDataSource(config);
    }
}
