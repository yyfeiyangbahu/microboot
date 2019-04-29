package cn.mldn.microboot.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
		private Integer id;
		private String name;
		private Integer age;
		private boolean sex;
		private String birthday;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public boolean getSex() {
			return sex;
		}
		public void setSex(boolean sex) {
			this.sex = sex;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", age=" + age
					+ ", sex=" + sex + ", birthday=" + birthday + "]";
		}
		
}
