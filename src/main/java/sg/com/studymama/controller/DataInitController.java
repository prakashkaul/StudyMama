package sg.com.studymama.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

import sg.com.studymama.DTO.CommentDTO;
import sg.com.studymama.DTO.PostsDTO;
import sg.com.studymama.Entity.Post;
import sg.com.studymama.Entity.PostsEntity;
import sg.com.studymama.model.PostData;
import sg.com.studymama.repository.RecommendationRepository;
import sg.com.studymama.service.PostService;
import sg.com.studymama.service.SpringDataPostService;

@CrossOrigin(origins = "*")
@RestController
public class DataInitController {

	private static final Logger LOG = LoggerFactory.getLogger(DataInitController.class);

	@Autowired
	private PostService postService;

	@Autowired
	private SpringDataPostService springDataPostService;

	@Autowired
	private RecommendationRepository recommendService;

	@RequestMapping(value = "/initPostData/{numberOfRows}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<PostsDTO> initPostData(@PathVariable("numberOfRows") Integer rows) {
		PostsDTO postDTO = new PostsDTO();
		try {
			LOG.info("Init Post Data");
			Faker faker = new Faker(new Locale("en-SG"));
			postDTO = new PostsDTO();
			try {
				for (int i = 2; i < rows + 2; i++) {
					postDTO.setAccountId(faker.number().numberBetween(1, 3));
					postDTO.setCategory(faker.company().industry());
					postDTO.setContact(faker.phoneNumber().subscriberNumber(8));
					postDTO.setDescription(faker.address().fullAddress());
					postDTO.setGpsX(Double.parseDouble(faker.address().longitude()));
					postDTO.setGpsY(Double.parseDouble(faker.address().latitude()));
					postDTO.setImages("");
					postDTO.setPrice(faker.number().numberBetween(20, 100) + "");
					postDTO.setStatus("1");
					postDTO.setScore(new BigDecimal(0.0));
					postDTO.setTitle(faker.commerce().department());
					postDTO.setWebsite("www." + faker.internet().domainName());
					PostsEntity post = postService.save(postDTO);
					LOG.info(postDTO.toString());
					springDataPostService.createPost(new PostData(post));
					recommendService.save(new Post(post));
				}
			} catch(Exception e) {
				LOG.error(e.getLocalizedMessage());
			}
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			e.printStackTrace();
			return null;
		}
		return ResponseEntity.ok(postDTO);
	}
}
