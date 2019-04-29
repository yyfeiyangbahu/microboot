package cn.mldn.microboot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.microboot.service.IStudentService;
import cn.mldn.microboot.util.controller.AbstractBaseController;
import cn.mldn.microboot.vo.Student;

//@RestController
@Controller
public class StudentController extends AbstractBaseController {
	@Resource
	private IStudentService studentService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public Object list(){
		return this.studentService.list();
	}
	
	@RequestMapping(value = "/updateStudentPre", method = RequestMethod.GET)
    public String updatePre() {
        return "student/student_update";
    }
	
	@RequestMapping(value = "/delStudentPre", method = RequestMethod.GET)
    public String delPre() {
        return "student/student_del";
    }
	
	@RequestMapping(value = "/addStudentPre", method = RequestMethod.GET)
    public String addPre() {
        return "student/student_add";
    }
	
	@RequestMapping(value = "/studentAdd", method = RequestMethod.POST)
    @ResponseBody
    public Object studentAdd(Student student) {
	    this.studentService.add(student);
        return student;
    }
	
	@RequestMapping(value = "/studentUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Object studentUpdate(Student student) {
        this.studentService.update(student);
        return student;
    }
	
	
	@RequestMapping(value = "/studentDel", method = RequestMethod.POST)
    @ResponseBody
    public Object studentUpdate(Integer id) {
        return this.studentService.delete(id);
    }
}
