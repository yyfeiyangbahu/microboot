package cn.mldn.microboot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.mldn.microboot.util.controller.AbstractBaseController;

@Controller
//@RestController//等于Controller+@ResponseBody
public class MessageController extends AbstractBaseController {
	@RequestMapping(value="/show",method=RequestMethod.GET)
	public String echo(String mid,Model model){
		model.addAttribute("url", "www.mldn.cn");
		model.addAttribute("mid", mid);
		model.addAttribute("curl", "<span style='color:red'>www.mldn.cn</span>");
		return "message/message_show";
	}
	@RequestMapping(value="/message/inner",method=RequestMethod.GET)
	public String inner(HttpServletRequest request,Model model){
		request.setAttribute("requestMessage", "requestMessage");
		request.getSession().setAttribute("sessionMessage", "sessionMessage");
		request.getServletContext().setAttribute("applicationMessage", "applicationMessage");
		model.addAttribute("url", "www.mldn.cn");
		return "message/message_inner";
	}
	@RequestMapping("/")
	//@ResponseBody//将控制器中方法的返回值变为rest内容
	public String home(){
		return "Hello World!";
	}
	@RequestMapping("/test")
	public String test(){
		return "test2";
	}
	@RequestMapping("/object")
	public String object(HttpServletRequest request,HttpServletResponse respinse){
		System.out.println("ip:"+request.getRemoteAddr());
		System.out.println("bm:"+request.getCharacterEncoding());
		System.out.println("sessionId:"+request.getSession().getId());
		System.out.println("path:"+request.getServletContext().getRealPath("/upload/"));
		return "oo";
	}
}
