package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("")
	public String root()
	{
		return "redirect:/admin/index";
	}
	
	@RequestMapping("/")
	public String home()
	{
		return "redirect:/admin/index";
	}
	
	
	@RequestMapping("/index")
	public String index()
	{
		return "admin/index";
	}
	
}
