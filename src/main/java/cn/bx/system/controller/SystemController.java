package cn.bx.system.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(value="/system/index/menu")
	public List<HashMap<String,String>> queryMenuList(@RequestBody String[] ruleIds){
		return service.listMenuByRules(ruleIds);
	}
}
