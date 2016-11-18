package cn.bx.system.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.system.entity.User;
import cn.bx.system.utils.UserUtils;

@RestController
public class LoginController {
	@RequestMapping(value="/login")
	@CrossOrigin(origins="http://localhost",methods={RequestMethod.POST,RequestMethod.OPTIONS},allowedHeaders="*")
	public User login(){
		return UserUtils.getUser();
	}
}
