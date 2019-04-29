package cn.mldn.microboot.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.mldn.microboot.vo.Student;

public interface IStudentService {
	@Transactional(readOnly = true)
	public List<Student> list();
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean add(Student vo);
	@Transactional(propagation=Propagation.REQUIRED)
    public boolean update(Student vo);
	@Transactional(propagation=Propagation.REQUIRED)
    public boolean delete(Integer id);
}
