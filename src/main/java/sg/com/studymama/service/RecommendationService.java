package sg.com.studymama.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import sg.com.studymama.Entity.Post;
import sg.com.studymama.Entity.UserData;
@Service
public interface RecommendationService {

	Collection<Post> getAll();
	
	Post save(Post post);
	
	

}
