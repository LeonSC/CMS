package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.UserService;
import service.WriterService;

@Controller
@RequestMapping("/personal")
public class PersonalController {

	@Autowired
	private UserService userService;
	@Autowired
	private WriterService writerService;
	
	@RequestMapping("/index")
	public String index()
	{
		return "personal/index";
	}
	
	@RequestMapping("/edit-submit")
	public String submitEditPersonal(HttpServletRequest request,
			@RequestParam(value="headericon", required=false)String headericon,
			@RequestParam(value="gender", required=false)Integer gender,
			@RequestParam(value="nickname", required=false)String nickname)
	{
		User user=(User)request.getSession().getAttribute("mem");
		
		user=this.userService.editUserByBMID(user.getBM_ID(), headericon, nickname, gender);
		
		request.getSession().setAttribute("mem", user);
		
		return "redirect:/personal/index";
	}
	
	/**
	 * 申请成为编辑, 管理员
	 * @return
	 */
	@RequestMapping("/apply")
	public String apply()
	{
		return "personal/apply";
	}
	
	/**
	 * 申请成为编辑, 管理员
	 * 提交
	 * @return
	 */
	@RequestMapping("/apply-submit-writer")
	public String applySubmitWriter(HttpServletRequest request)
	{
		User user=(User)request.getSession().getAttribute("mem");
		
		user=this.writerService.setUserToWriter(user.getBM_ID());
		
		request.getSession().setAttribute("mem",user);
		
		return "personal/apply";
	}
}
