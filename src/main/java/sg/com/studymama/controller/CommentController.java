package sg.com.studymama.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.CrossOrigin;

import sg.com.studymama.DTO.CommentDTO;
import sg.com.studymama.service.CommentService;

@CrossOrigin(origins = "*")
@Controller
public class CommentController {
	private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/commentSubmit")
	public ResponseEntity<CommentDTO> commentSubmit(@RequestBody CommentDTO commentDTO, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		
		
		try {
			commentService.save(commentDTO);
			redirectAttributes.addAttribute("notificationType", "success");
			redirectAttributes.addAttribute("notificationMessage", "Success");
			LOG.info(commentDTO.toString());
			return ResponseEntity.ok(commentDTO);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("submittedDTO", commentDTO);
			redirectAttributes.addAttribute("notificationType", "error");
			redirectAttributes.addAttribute("notificationMessage", e.getMessage());
			return null;
		}

	}
	
	@RequestMapping(value = "/commentDelete/{commentId}",method= RequestMethod.DELETE)
	public void commentDelete(@PathVariable(value="commentId") Integer commentId) { 
		LOG.info("comment ID IS " + commentId);
		
		commentService.deleteComment(commentId);
	}


}
