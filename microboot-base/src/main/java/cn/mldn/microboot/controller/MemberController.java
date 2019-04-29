package cn.mldn.microboot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.microboot.service.IMemberService;
import cn.mldn.microboot.util.controller.AbstractBaseController;
import cn.mldn.microboot.vo.Member;

@Controller
public class MemberController extends AbstractBaseController {
	@RequestMapping(value="/get")
	@ResponseBody
	public String get(){
		System.out.println(10/0);
		return "hello world";
	}
	@Resource
	private IMemberService memberService;
	@RequestMapping(value="/member_get",method=RequestMethod.GET)
	@ResponseBody
	public Object getMember(String mid){
		return this.memberService.get(mid);
	}
	
	@RequestMapping(value = "/message/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Member> all = new ArrayList<Member>();
		for (int i = 0; i < 10; i++) {
			Member vo = new Member();
			vo.setMid("101"+i);
			vo.setAge(9);
			vo.setSelary(99999.99);
			vo.setBirthday(new Date());
			all.add(vo);
		}
		model.addAttribute("memberAll", all);
		return "message/member_list";
	}
	
	@RequestMapping(value = "/message/set", method = RequestMethod.GET)
	public String set(Model model) {
		Set<String> names=new HashSet<String>();
		List<Integer> ids=new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			names.add("mldn"+i);
			ids.add(i);
		}
		model.addAttribute("names", names);
		model.addAttribute("ids", ids);
		model.addAttribute("mydate", new java.util.Date());
		return "message/member_set";
	}
	
	@RequestMapping(value = "/message/map", method = RequestMethod.GET)
	public String map(Model model) {
		Map<String,Member> all = new HashMap<String,Member>();
		for (int i = 0; i < 10; i++) {
			Member vo = new Member();
			vo.setMid("101"+i);
			vo.setAge(9);
			vo.setSelary(99999.99);
			vo.setBirthday(new Date());
			all.put("mldn"+i, vo);
		}
		model.addAttribute("memberAll", all);
		return "message/member_map";
	}
	
	@RequestMapping(value = "/message/member_show", method = RequestMethod.GET)
	public String memberShow(Model model) {
		Member vo = new Member();
		vo.setMid("101");
		vo.setAge(9);
		vo.setSelary(99999.99);
		vo.setBirthday(new Date());
		model.addAttribute("member", vo);
		return "message/member_show";
	}
	
	@RequestMapping(value = "/memberAddPre", method = RequestMethod.GET)
	public String memberAddPre() {
		return "member_addpre";
	}
	
	@RequestMapping(value = "/memberAdd", method = RequestMethod.POST)
	@ResponseBody
	public Object memberAdd(Member member) {
		return member;
	}
	
	@RequestMapping(value = "/addPre", method = RequestMethod.GET)
	public String addPre() {
		return "member_add";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@Valid Member vo,BindingResult result){
		if(result.hasErrors()){
			Iterator<ObjectError> iterator = result.getAllErrors().iterator();
			while(iterator.hasNext()){
				ObjectError error = iterator.next();
				System.out.println("错误信息code="+error.getCode()+",message="+error.getDefaultMessage());
			}
			return result.getAllErrors();
		}else{
			return vo;
		}
	}
}
