package cookieMethod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"cookieMethod", "swagger"})
public class Appliction {
    public static void main(String[] args) {
        SpringApplication.run(Appliction.class, args);
    }
}
