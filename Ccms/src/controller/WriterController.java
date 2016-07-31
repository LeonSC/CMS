package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/writer")
public class WriterController {
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request)
	{
		return "writer/index";
	}
}
