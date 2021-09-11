package br.com.elastic.elastic;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class elasticController {

	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		
		
		
		return "index";
		

	}
}