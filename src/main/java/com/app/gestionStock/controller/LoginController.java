/**
 * 
 */
package com.app.gestionStock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.gestionStock.dto.UserDTO;

/**
 * @author mohamed
 *
 */
@Controller
class LoginController {

	@GetMapping("/login")
	String login(UserDTO user,Model model) {
		model.addAttribute("user", user);
        return "login";
	}

	@GetMapping("/logout")
	String logout() {
        return "redirect:/login?logout";
	}
	
	@GetMapping("/403")
	public String accessDeniedPage() {
		return "403";
	}
	
	


}
