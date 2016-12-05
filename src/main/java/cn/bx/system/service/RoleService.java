package cn.bx.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.bframe.service.SimpleService;
import cn.bx.system.entity.Dict;

@Service("RoleService")
@Transactional(rollbackFor=Exception.class)
public class RoleService extends SimpleService<Dict>{
	public DataMessage permissionsRole(String roleId,String[] menuIds){
		this.delete("deleteRoleMenu", roleId);
		List<Object> paras = new ArrayList<Object>();
		for(String mid : menuIds){
			Map<String,String> para = new HashMap<String,String>();
			para.put("roleId", roleId);
			para.put("menuId", mid);
			paras.add(para);
		}
		if(this.executeBatch("addRoleMenu", paras)>0) return DataMessage.success("授权成功", roleId);
		else return DataMessage.error("授权失败", roleId);
	}
	public DataMessage assignRole(String roleId,String[] userIds){
		this.delete("deleteRoleUser", roleId);
		List<Object> paras = new ArrayList<Object>();
		for(String uid : userIds){
			Map<String,String> para = new HashMap<String,String>();
			para.put("roleId", roleId);
			para.put("userId", uid);
			paras.add(para);
		}
		if(this.executeBatch("addRoleUser", paras)>0) return DataMessage.success("分配成功", roleId);
		else return DataMessage.error("分配失败", roleId);
	}
}
