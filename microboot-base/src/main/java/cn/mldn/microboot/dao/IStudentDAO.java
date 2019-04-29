package cn.mldn.microboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.mldn.microboot.vo.Student;
@Mapper
public interface IStudentDAO {
		public List<Student> findAll();
		public boolean doCreate(Student vo);
		public boolean doUpdate(Student vo);
		public boolean doDelete(Integer id);
}
