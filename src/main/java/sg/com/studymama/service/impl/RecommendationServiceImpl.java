package sg.com.studymama.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.com.studymama.Entity.Post;
import sg.com.studymama.Entity.UserData;
import sg.com.studymama.repository.RecommendationRepository;
import sg.com.studymama.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {
	
	@Autowired
	private RecommendationRepository repository;

	@Override
	public Collection<Post> getAll() {
		// TODO Auto-generated method stub
		return repository.getAll();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return repository.save(post);
	}

}
