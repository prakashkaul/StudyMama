package sg.com.studymama.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import sg.com.studymama.Entity.User;
@Service
public interface RecommendationService {

	Collection<User> getAll();
	
	

}
