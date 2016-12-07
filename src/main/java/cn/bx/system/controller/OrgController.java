package cn.bx.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.entity.Org;
import cn.bx.system.service.OrgService;

@Controller
@RequestMapping("system/org")
public class OrgController {
	
	@Resource(name="OrgService")
	OrgService service;
	@RequestMapping(value={"list",""})
	@RequiresRoles(value={"role_admin","role_leader","role_dept"},logical=Logical.OR)
	public @ResponseBody List<Org> listOrg(@RequestBody Map<String,String> param){
		List<Org> list =  service.list(param);
		return list;
	}
	@RequestMapping(value="add")
	@RequiresPermissions("sys:org:add")
	public @ResponseBody DataMessage addOrg(Org org){
		if(service.add(org) > 0)
			return DataMessage.success("组织机构增加成功", org);
		else
			return DataMessage.error("组织机构增加失败", org);
	}
	@RequestMapping(value="save")
	@RequiresPermissions("sys:org:save")
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
