package sg.com.studymama;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudymamaApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(StudymamaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(StudymamaApplication.class, args);
		LOG.info("Study Mama Application Started");
	}

}
