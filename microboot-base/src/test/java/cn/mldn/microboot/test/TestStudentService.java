package cn.mldn.microboot.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.microboot.StartSpringBootMain;
import cn.mldn.microboot.service.IStudentService;
import cn.mldn.microboot.vo.Student;

@SpringBootTest(classes = StartSpringBootMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestStudentService {
	@Resource
	private IStudentService studentService;
	@Test
	public void testList() throws Exception{
		System.out.println(this.studentService.list());
	}
	@Test
	public void testAdd() throws Exception{
		Student student = new Student();
		student.setAge(26);
		student.setName("来来来");
		student.setBirthday("2018/03/01");
		student.setSex(true);
		System.out.println(this.studentService.add(student));
	}
}
