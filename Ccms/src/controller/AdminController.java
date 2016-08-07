package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Page;
import model.User;
import service.WriterService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private WriterService writerService;
	
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
	
	@RequestMapping("/writerlist")
	public String editorList(HttpServletRequest request,
			@RequestParam(value = "act", required = false) String act,
			@RequestParam(value = "page", required = false) Integer page)
	{
		if(act==null)
		{
			act="wait";
		}
		if(page==null||page<1)
		{
			page=1;
		}
		
		request.setAttribute("act", act);
		request.setAttribute("page", page);
		
		Page<User> writerList=null;
		if(act.equals("wait"))
		{
			writerList=this.writerService.getWriterWaitList(page);
		}
		else if(act.equals("passed"))
		{
			writerList=this.writerService.getWriterPassedList(page);
		}
		else if(act.equals("banned"))
		{
			writerList=this.writerService.getWriterBannedList(page);
		}
		
		request.setAttribute("writerList", writerList);
		
		return "admin/writerlist";
	}
	
	@RequestMapping("/writerwaittopass")
	public String writerWaitToPass(
			@RequestParam(value = "bmid", required = false) String bmid,
			@RequestParam(value = "act", required = false) String act,
			@RequestParam(value = "page", required = false) Integer page)
	{
		this.writerService.setWriterToPassed(bmid);
		
		return "redirect:/admin/writerlist?act="+act+"&page="+page;
	}
}
