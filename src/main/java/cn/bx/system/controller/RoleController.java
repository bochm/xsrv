package cn.bx.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.entity.Dict;
import cn.bx.system.entity.Role;
import cn.bx.system.service.RoleService;

@RestController
@RequestMapping("system/role")
public class RoleController {
	@Resource(name="RoleService")
	RoleService service;
	@RequestMapping(value={"list",""})
	public @ResponseBody List<Dict> listRole(@RequestBody Map<String,String> param){
		return service.selectList("list", param);
	}
	@RequestMapping(value="add")
	public @ResponseBody DataMessage addRole(Role role){
		if(service.insert("add", role) > 0)
			return DataMessage.success("保存角色数据成功", role);
		else
			return DataMessage.error("保存失败", role);
	}
	@RequestMapping(value="save")
	public @ResponseBody DataMessage saveRole(Role role){
		if(service.update("save", role) > 0)
			return DataMessage.success("保存角色数据成功", role);
		else
			return DataMessage.error("保存失败", role);
	}
	@RequestMapping(value="delete")
	public @ResponseBody DataMessage deleteRole(@RequestBody String[] ids){
		if(service.delete("delete", ids)  == ids.length)
			return DataMessage.success("删除成功", ids);
		else
			return DataMessage.error("删除失败", ids);
	}
	
	@RequestMapping(value="menu/{roleId}")
	public @ResponseBody DataMessage saveRoleMenu(@PathVariable("roleId") String roleId,@RequestBody String[] menuIds){
		return service.permissionsRole(roleId, menuIds);
	}
	@RequestMapping(value="user/{roleId}")
	public @ResponseBody DataMessage saveRoleUser(@PathVariable("roleId") String roleId,@RequestBody String[] userIds){
		return service.assignRole(roleId, userIds);
	}
}
