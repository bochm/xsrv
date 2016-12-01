package cn.bx.system.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bx.bframe.service.SimpleService;
import cn.bx.system.entity.Dict;

@Service("RoleService")
@Transactional(rollbackFor=Exception.class)
public class RoleService extends SimpleService<Dict>{
}
