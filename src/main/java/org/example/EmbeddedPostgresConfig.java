package org.example;

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class EmbeddedPostgresConfig {

    @Bean
    public DataSource dataSource() throws IOException {
        return EmbeddedPostgres.builder()
                .setPort(5433) // Фиксированный порт (необязательно)
                .start()
                .getPostgresDatabase();
    }

}