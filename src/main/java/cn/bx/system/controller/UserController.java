package cn.bx.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.bx.bframe.common.security.PasswordUtil;
import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.entity.User;
import cn.bx.system.service.UserService;

@RestController
@RequestMapping("system/user")
public class UserController {
	
	@Resource(name="UserService")
	UserService userService;
	
	@RequestMapping("checkLoginName")
	public boolean checkLoginName(@RequestBody Map<String,Object> param){
		User u = userService.selectOne("checkUserExists", param.get("param"));
		return u == null || u.getId() == null;
	}
	@RequestMapping(value={"list",""})
	@RequiresRoles(value={"role_admin","role_leader","role_dept"},logical=Logical.OR)
	public List<User> listUser(@RequestBody Map<String,String> param){
		System.out.println("list user");
		return userService.selectList("listUser", param);
	}
	@RequestMapping(value="add")
	@RequiresPermissions("sys:user:add")
	public DataMessage addUser(User user,@RequestParam(value="ph",required=false) MultipartFile file){
		if(file != null)
			System.out.println(file.getOriginalFilename()+"#########");
		
		user.setPassword(PasswordUtil.entryptPassword(user.getPassword()));
		if(userService.insert("addUser", user) > 0)
			return DataMessage.success("保存成功", user);
		else
			return DataMessage.error("保存失败", user);
	}
	@RequestMapping(value="save")
	@RequiresPermissions("sys:user:save")
	public  DataMessage saveUser(User user,@RequestParam(value="ph",required=false) MultipartFile file){
		if(!StringUtils.isEmpty(user.getPassword()))
			user.setPassword(PasswordUtil.entryptPassword(user.getPassword()));
		if(userService.update("saveUser", user) > 0)
			return DataMessage.success("保存成功", user);
		else
			return DataMessage.error("保存失败", user);
	}
	@RequestMapping(value="delete")
	@RequiresPermissions("sys:user:delete")
	public  DataMessage deleteUser(@RequestBody String[] ids){
		if(userService.delete("deleteUser", ids)  == ids.length)
			return DataMessage.success("删除成功", ids);
		else
			return DataMessage.error("删除失败", ids);
	}
}
