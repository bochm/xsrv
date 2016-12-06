package cn.bx.system.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.system.service.SystemService;
import cn.bx.system.utils.UserUtils;

@RestController
public class SystemController {
	@Resource(name="SystemService")
	SystemService service;
	@RequestMapping(value="/login/{loginname}")
	public HashMap<String, String> login(@PathVariable("loginname") String loginname){
		return UserUtils.getUserByLoginName(loginname);
	}
	@RequestMapping(value="/system/index/menu/{userId}")
	public List<HashMap<String,String>> queryMenuList(@PathVariable("userId") String userId){
		return service.listMenuByUser(userId);
	}
	@RequestMapping(value="/system/permissions/{userId}/{pagePermission}")
	public List<String> queryPermissions(@PathVariable("userId") String userId,
			@PathVariable("pagePermission") String pagePermission){
		return service.queryPermissions(userId,pagePermission);
	}
}
