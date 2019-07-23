package com.java.nas.cassie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application to run boot application.
 *
 * @author Naser Amed
 * @version 1.0
 */
@SpringBootApplication
public class CassieApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CassieApplication.class, args);
    }
}
