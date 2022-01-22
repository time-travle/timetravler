package org.joven.gateway;

import org.joven.gateway.utils.StartCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        new StartCommand(args);
        SpringApplication.run(GatewayApplication.class, args);
    }
}
