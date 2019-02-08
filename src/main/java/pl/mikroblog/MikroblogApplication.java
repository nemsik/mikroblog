package pl.mikroblog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.mikroblog.Service.UserService;
import pl.mikroblog.model.User;

import javax.transaction.Transactional;

@SpringBootApplication
public class MikroblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MikroblogApplication.class, args);
    }

}

