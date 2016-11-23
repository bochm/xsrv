package cn.bx.system.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.system.entity.User;
import cn.bx.system.utils.UserUtils;

@RestController
public class LoginController {
	@RequestMapping(value="/login/{loginname}")
	public User login(@PathVariable("loginname") String loginname){
		return UserUtils.getUserByLoginName(loginname);
	}
}
