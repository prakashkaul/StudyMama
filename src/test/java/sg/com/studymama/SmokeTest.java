package sg.com.studymama;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.com.studymama.controller.AuthenticationController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private AuthenticationController authenticationController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(authenticationController).isNotNull();
	}
}
