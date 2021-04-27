package sg.com.studymama.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jdk.internal.org.jline.utils.Log;
import sg.com.studymama.DTO.PostDTO;
import sg.com.studymama.DTO.PostsDTO;
import sg.com.studymama.Entity.PostEntity;
import sg.com.studymama.model.PaginationParamDTO;
import sg.com.studymama.model.PaginationResultDTO;
import sg.com.studymama.repository.PostRepository;
import sg.com.studymama.service.PostService;

@RestController
public class PostController {
//	
//	private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
//	
//	@Autowired
//	private PostService postService;
//	
//	@GetMapping("post")
//	public String postList() {
//		return "/PostList";//overall post page include some basic info
//	}
//    
//	@GetMapping("/postData")
//	@ResponseBody
//	public List<PostDTO> getPostData(@RequestParam(value = "accountId", required = false) Integer accountId) {
//
////		List<PostsDTO> postDTOList = new ArrayList<PostDTO>();
//		postDTOList = postService.getPosts(accountId);
//
//		return postDTOList;
//	}
//    
//	@GetMapping("/post/{postId}")
//	public String postData(@PathVariable("postId")Integer id, Model model) {
//		
//		PostDTO postDTO = null;
//		if(id != null && id>0 ) {
//			postDTO = postService.findById(id);
//		} else {
//			postDTO = new PostDTO();
//		}
//		
//		model.addAttribute("DTO", postDTO);
//		return "post/postForm";
//	}
//
//	@PostMapping("/postFormSubmit")
//	public String postFormSubmit(@RequestBody PostDTO postDTO, BindingResult bindingResult,
//			RedirectAttributes redirectAttributes, Model model) {
//		
//		
//		try {
//			postService.save(postDTO);
//			redirectAttributes.addAttribute("notificationType", "success");
//			redirectAttributes.addAttribute("notificationMessage", "Success");
//			LOG.info(postDTO.toString());
//			return "redirect:/post";
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("submittedDTO", postDTO);
//			redirectAttributes.addAttribute("notificationType", "error");
//			redirectAttributes.addAttribute("notificationMessage", e.getMessage());
//			return "redirect:/post";
//		}
//
//	}
//	
//	@RequestMapping(value = "/postDelete",method= RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
//	public String postDelete(@RequestParam(name="postId")Integer postId) { 
//		LOG.info("pOST ID IS " + postId);
//		
//		postService.deletePost(postId);
//		
//		return "redirect:/post";
//	}

}
