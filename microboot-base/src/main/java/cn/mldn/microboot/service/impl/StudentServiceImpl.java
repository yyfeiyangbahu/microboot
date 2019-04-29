package cn.mldn.microboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.microboot.dao.IStudentDAO;
import cn.mldn.microboot.service.IStudentService;
import cn.mldn.microboot.vo.Student;
@Service
public class StudentServiceImpl implements IStudentService {
	@Resource
	private IStudentDAO studentDao;
	@Override
	public List<Student> list() {
		return this.studentDao.findAll();
	}
	@Override
	public boolean add(Student vo) {
		return this.studentDao.doCreate(vo);
	}
    @Override
    public boolean update(Student vo) {
        return this.studentDao.doUpdate(vo);
    }
    @Override
    public boolean delete(Integer id) {
        return this.studentDao.doDelete(id);
    }
}
