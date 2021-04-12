package sg.com.studymama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public String searchCategory(@RequestParam("cat") String cat) {
		String search = "SEARCH CATEGORY: " + cat;
		LOG.info(cat);
		return search;
	}
}
