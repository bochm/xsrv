package cn.bx.demo.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.demo.entity.Classes;
import cn.bx.demo.service.ClassesService;

@RestController
@RequestMapping("demo/datatable/maindetail")
public class DemoTableController {
	@Resource(name="ClassesService")
	ClassesService service;
	@RequestMapping("classes")
	public DataMessage listMain(@RequestBody Map<String,Object> param){
		return DataMessage.data(service.selectList("listClasses", param));
	} 
	@RequestMapping("student")
	public DataMessage listDetail(@RequestBody Map<String,Object> param){
		return DataMessage.data(service.selectList("listStudent", param));
	} 
	@RequestMapping("classes/add")
	public DataMessage add(@RequestBody Classes classes){
		System.out.println(classes.getStudents().size());
		return service.addClass(classes);
	} 
	@RequestMapping("classes/edit")
	public DataMessage save(@RequestBody Classes classes){
		return service.updateClass(classes);
	}
	@RequestMapping("classes/delete")
	public DataMessage delete(@RequestBody String[] ids){
		return service.deleteClass(ids);
	}
}
