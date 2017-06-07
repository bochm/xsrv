package cn.bx.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.bx.bframe.common.util.IdGen;
import cn.bx.bframe.entity.DataMessage;
import cn.bx.bframe.service.SimpleService;
import cn.bx.demo.entity.Classes;
import cn.bx.demo.entity.Student;
@Service("ClassesService")
@Transactional(rollbackFor=Exception.class)
public class ClassesService extends SimpleService<Classes>{
	public DataMessage addClass(Classes classes){
		if(this.insert("addClass", classes) > 0){
			IdGen idGen = new IdGen(0,0);
			for(Student student : classes.getStudents()){
				student.setId(idGen.getId());
				student.setClassId(classes.getId());
			}
			if(!CollectionUtils.isEmpty(classes.getStudents())) this.insert("addStudents", classes.getStudents());
			return DataMessage.success("新增成功", classes);
		}
		return DataMessage.error("新增失败", classes);
	}
	public DataMessage updateClass(Classes classes){
		if(this.update("updateClass", classes) > 0){
			if(!CollectionUtils.isEmpty(classes.getStudents()))
				this.update("updateStudents", classes.getStudents());
			return DataMessage.success("修改成功", classes);
		}
		return DataMessage.error("修改失败", classes);
	}
	public DataMessage deleteClass(String[] ids){
		this.delete("deleteStudents", ids);
		if(this.delete("deleteClass", ids) > 0){
			return DataMessage.success("删除成功", ids);
		}
		return DataMessage.error("删除失败", ids);
	}
}
