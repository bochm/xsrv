package cn.bx.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.service.SystemService;
import cn.bx.system.utils.RsSysConstants;
import cn.bx.system.utils.UserUtils;

@RestController
public class SystemController {
	@Resource(name="SystemService")
	SystemService service;
	@RequestMapping(value="/login")
	public DataMessage login(HttpServletRequest request){
		return DataMessage.success("",UserUtils.getUserByLoginName(request.getHeader(RsSysConstants.RS_PARAM_USERNAME)));
	}
	@RequestMapping(value="/system/index/menu/{userId}")
	public DataMessage queryMenuList(@PathVariable("userId") String userId){
		return DataMessage.success("",service.listMenuByUser(userId));
	}
	@RequestMapping(value="/system/permissions/{userId}/{pagePermission}")
	public DataMessage queryPermissions(@PathVariable("userId") String userId,
			@PathVariable("pagePermission") String pagePermission){
		return DataMessage.success("",service.queryPermissions(userId,pagePermission));
	}
}
