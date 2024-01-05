package khouini.yacine.assuranceexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AssuranceExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceExamApplication.class, args);
	}

}
