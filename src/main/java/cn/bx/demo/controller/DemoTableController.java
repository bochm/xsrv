package cn.bx.demo.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.demo.service.ClassesService;

@RestController
@RequestMapping("demo/datatable")
public class DemoTableController {
	@Resource(name="ClassesService")
	ClassesService service;
	@RequestMapping("maindetail")
	public DataMessage listMain(@RequestBody Map<String,Object> param){
		return DataMessage.data(service.selectList("listClasses", param));
	} 
}
