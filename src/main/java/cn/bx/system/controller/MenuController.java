package cn.bx.system.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.entity.Menu;
import cn.bx.system.service.MenuService;

@RestController
@RequestMapping("system/menu")
public class MenuController {
	
	@Resource(name="MenuService")
	MenuService menuService;
	@RequestMapping(value={"list",""})
	@RequiresRoles(value={"role_admin","role_leader","role_dept"},logical=Logical.OR)
	public DataMessage listMenu(@RequestBody Map<String,String> param){
		return DataMessage.data(menuService.list(param));
	}
	@RequestMapping(value="add")
	@RequiresPermissions("sys:menu:add")
	public DataMessage addMenu(Menu menu){
		if(menuService.add(menu) > 0)
			return DataMessage.success("菜单保存成功", menu);
		else
			return DataMessage.error("菜单保存失败", menu);
	}
	@RequestMapping(value="edit")
	@RequiresPermissions("sys:menu:edit")
	public DataMessage saveMenu(Menu menu){
		if(menuService.save(menu) == 1)
			return DataMessage.success("菜单保存成功", menu);
		else
			return DataMessage.error("菜单保存失败", menu);
	}
	@RequestMapping(value="delete")
	@RequiresPermissions("sys:menu:delete")
	public DataMessage deleteMenu(@RequestBody String[] ids){
		if(menuService.removeListWithChildren(ids) > 0)
			return DataMessage.success("菜单删除成功", ids);
		else
			return DataMessage.error("菜单保存失败", ids);
	}
}
