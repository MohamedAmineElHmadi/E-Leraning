package esprit.codegeeks.elearningfeedbackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ELearningFeedbackServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ELearningFeedbackServiceApplication.class, args);
    }

}