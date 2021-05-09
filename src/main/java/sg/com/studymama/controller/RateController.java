package sg.com.studymama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.CrossOrigin;

import sg.com.studymama.DTO.RateDTO;
import sg.com.studymama.service.RateService;

@CrossOrigin(origins = "*")
@Controller
public class RateController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RateController.class);
	
	@Autowired
	private RateService rateService;
	
	@PostMapping("/rateSubmit")
	public String rateScoreSubmit(@RequestBody RateDTO rateDTO, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {
		
		try {
			rateService.save(rateDTO);
			redirectAttributes.addAttribute("notificationType", "success");
			redirectAttributes.addAttribute("notificationMessage", "Success");
			LOG.info(rateDTO.toString());
			return "redirect:/post";//?
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("submittedDTO", rateDTO);
			redirectAttributes.addAttribute("notificationType", "error");
			redirectAttributes.addAttribute("notificationMessage", e.getMessage());
			return "redirect:/post";//?
		}

	}

}
