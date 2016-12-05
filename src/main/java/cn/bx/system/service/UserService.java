package cn.bx.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bx.bframe.service.SimpleService;
import cn.bx.system.entity.User;

@Service("UserService")
@Transactional(rollbackFor=Exception.class)
public class UserService extends SimpleService<User>{
}
