package sg.com.studymama.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.com.studymama.Entity.User;
import sg.com.studymama.repository.RecommendationRepository;
import sg.com.studymama.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {
	
	@Autowired
	private RecommendationRepository repository;

	@Override
	public Collection<User> getAll() {
		// TODO Auto-generated method stub
		return repository.getAll();
	}

}
