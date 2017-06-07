package cn.bx.demo.entity;

import cn.bx.bframe.entity.BaseBean;

public class Student extends BaseBean{
	private static final long serialVersionUID = 1L;
	private String classId;
	private String no;
	private String name;
	private int age;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
}
