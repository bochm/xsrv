package cn.bx.system.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.entity.Org;
import cn.bx.system.service.OrgService;

@RestController
@RequestMapping("system/org")
public class OrgController {
	
	@Resource(name="OrgService")
	OrgService service;
	@RequestMapping(value={"list",""})
	@RequiresRoles(value={"role_admin","role_leader","role_dept"},logical=Logical.OR)
	public DataMessage listOrg(@RequestBody Map<String,String> param){
		return DataMessage.data(service.list(param));
	}
	@RequestMapping(value="add")
	@RequiresPermissions("sys:org:add")
	public @ResponseBody DataMessage addOrg(Org org){
		if(service.add(org) > 0)
			return DataMessage.success("组织机构增加成功", org);
		else
			return DataMessage.error("组织机构增加失败", org);
	}
	@RequestMapping(value="edit")
	@RequiresPermissions("sys:org:edit")
	public @ResponseBody DataMessage saveOrg(Org org){
		if(service.save(org) == 1)
			return DataMessage.success("组织机构保存成功", org);
		else
			return DataMessage.error("组织机构保存失败", org);
	}
	@RequestMapping(value="delete")
	@RequiresPermissions("sys:org:delete")
	public @ResponseBody DataMessage deleteOrg(@RequestBody String[] ids){
		if(service.removeListWithChildren(ids) > 0)
			return DataMessage.success("组织机构删除成功", ids);
		else
			return DataMessage.error("组织机构保存失败", ids);
	}
}
