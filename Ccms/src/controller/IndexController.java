package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.AdminService;
import service.UserService;
import startup.Config;

@Controller
public class IndexController {

	@Autowired
	private AdminService adminService;
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
	@RequestMapping("/adminconsole")
	public String adminLogin() {
		return "admin/login";
	}

	@RequestMapping("/adminlogin-submit")
	public String adminLoginSubmit(HttpServletRequest request,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "pw", required = false) String pw) {
		User adm = this.adminService.checkAdmin(email, pw);
		if (adm == null) {
			return "redirect:/adminconsole";
		}

		request.getSession().setAttribute("admin", adm);

		return "redirect:/admin/index";
	}
	
	
	//////////////////处理编辑///////////////////////////
	@RequestMapping("/writerlogin")
	public String writerLogin() {
		return "admin/login";
	}
	
	@RequestMapping("/writerlogin-submit")
	public String writerLoginSubmit(HttpServletRequest request,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "pw", required = false) String pw)
	{
		User writer = this.userService.checkUser(email, pw);
		if (writer == null) {
			return "redirect:/writerlogin";
		}
	
		request.getSession().setAttribute("writer", writer);
	
		return "redirect:/writer/index";
	}
	
	//////////////////登出///////////////////////////
	@RequestMapping("/logout")
	public String adminLogout(HttpServletRequest request,@RequestParam(value = "goback", required = false) String goback) {
		request.getSession().setAttribute("admin", null);
		request.getSession().setAttribute("writer", null);
		
		if(goback!=null)
		{
			return "redirect:" + Config.getConfig().getRootPath() + goback;
		}
		
		return "redirect:/index";
	}
}
