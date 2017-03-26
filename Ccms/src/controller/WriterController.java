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
		//<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=d50647cd9336a4e78521e23964fe3e1e&plugin=AMap.Geocoder"></script>
	}
}
