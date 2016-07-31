package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.UserService;
import startup.Config;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request)
	{
		return "index";
	}
	
	@RequestMapping("/building")
	public String building()
	{
		return "building";
	}
	
	
	//////////////////处理管理员///////////////////////////
	@RequestMapping("/writerlogin")
	public String adminLogin() {
		return "admin/login";
	}
	
	@RequestMapping("/writerlogin-submit")
	public String adminLoginSubmit(HttpServletRequest request,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "pw", required = false) String pw)
	{
		User adm = this.userService.checkUser(email, pw);
		if (adm == null) {
			return "redirect:/writerlogin";
		}
	
		request.getSession().setAttribute("admin", adm);
	
		return "redirect:/writer/index";
	}
	
	@RequestMapping("/logout")
	public String adminLogout(HttpServletRequest request,@RequestParam(value = "goback", required = false) String goback) {
		request.getSession().setAttribute("admin", null);
		
		if(goback!=null)
		{
			return "redirect:" + Config.getConfig().getRootPath() + goback;
		}
		
		return "redirect:/index";
	}
}
