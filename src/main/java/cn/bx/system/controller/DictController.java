package cn.bx.system.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.entity.Dict;
import cn.bx.system.service.DictService;

@RestController
@RequestMapping("system/dict")
public class DictController {
	@Resource(name="DictService")
	DictService service;
	@RequestMapping(value={"list",""})
	@RequiresRoles(value={"role_admin","role_leader","role_dept"},logical=Logical.OR)
	public DataMessage listDict(@RequestBody Map<String,String> param){
		return DataMessage.data(service.selectList("list", param));
	}
	@RequestMapping(value="query/{type}")
	public DataMessage getDictByType(@PathVariable("type") String type){
		return DataMessage.data(service.findDictByType(type));
	}
	@RequestMapping(value="add")
	@RequiresPermissions("sys:dict:add")
	public DataMessage addDict(Dict dict){
		if(service.insert("add", dict) > 0)
			return DataMessage.success("保存字典数据成功", dict);
		else
			return DataMessage.error("保存失败", dict);
	}
	@RequestMapping(value="save")
	@RequiresPermissions("sys:dict:save")
	public DataMessage saveDict(Dict dict){
		if(service.update("save", dict) > 0)
			return DataMessage.success("保存字典数据成功", dict);
		else
			return DataMessage.error("保存失败", dict);
	}
	@RequestMapping(value="delete")
	@RequiresPermissions("sys:dict:delete")
	public DataMessage deleteDict(@RequestBody String[] ids){
		if(service.delete("delete", ids)  == ids.length)
			return DataMessage.success("删除成功", ids);
		else
			return DataMessage.error("删除失败", ids);
	}
}
