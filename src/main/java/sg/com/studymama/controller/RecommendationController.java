package sg.com.studymama.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.com.studymama.Entity.Post;
import sg.com.studymama.Entity.UserData;
import sg.com.studymama.service.RecommendationService;

@RestController
@RequestMapping("/Recommendation")
public class RecommendationController {
	
	@Autowired
	private RecommendationService service;
	
	@GetMapping
	public Collection<Post> getAll(){
		return service.getAll();
	}
	

}
