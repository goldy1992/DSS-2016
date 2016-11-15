package practica2.comunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);
    }
}