package cn.bx.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.bx.bframe.service.SimpleService;

/**
 * 系统服务类，包含用户、角色、菜单等系统安全数据
 * @author bcm
 * @version 2016-05-19
 */
@Service("SystemService")
@Transactional(readOnly=true)
public class SystemService extends SimpleService<HashMap<String,String>>{
	public HashMap<String,String> findUserByLoginName(String loginname){
		return this.selectOne("findUserByLoginName", loginname);
	}
	public List<HashMap<String,String>> listMenuByUser(String userId){
		return this.selectList("listMenuByUser", userId);
	}
	public List<String> queryPermissions(String userId,String pagePermission){
		Map<String,String> param = new HashMap<String,String>();
		param.put("userId", userId);
		param.put("permission", pagePermission);
		System.out.println(userId+","+pagePermission);
		List<HashMap<String,String>> plist = this.selectList("queryPermissions", param);
		List<String> permissions = new ArrayList<String>();
		for(HashMap<String,String> p : plist){
			permissions.add(p.get("permission"));
		}
		return permissions;
	}
	public Set<String> queryRolesByUserId(String userId){
		List<HashMap<String,String>> list = this.selectList("queryRolesByUserId", userId);
		Set<String> rules = new HashSet<String>();
		for(HashMap<String,String> s : list){
			rules.add(s.get("enname"));
		}
		return rules;
	}
	public Set<String> queryPermissionsByUserId(String userId){
		List<HashMap<String,String>> list = this.selectList("queryPermissionsByUserId", userId);
		Set<String> permissions = new HashSet<String>();
		for(HashMap<String,String> s : list){
			permissions.add(s.get("permission"));
		}
		return permissions;
	}
}
