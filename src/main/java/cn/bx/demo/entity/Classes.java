package cn.bx.demo.entity;

import java.util.List;

import cn.bx.bframe.entity.BaseBean;

public class Classes extends BaseBean{
	private static final long serialVersionUID = 1L;
	private String className;
	private List<Student> students;
	private String classMaster;
	private int studentCount;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getClassMaster() {
		return classMaster;
	}
	public void setClassMaster(String classMaster) {
		this.classMaster = classMaster;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
