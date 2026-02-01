package main.java.com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        int result = calc.calculate(10, 5, "add");
        logger.info("Calculation result: {}", result);

        UserService service = new UserService();
        service.findUser("admin");
    }
}
