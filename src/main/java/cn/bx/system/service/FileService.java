package cn.bx.system.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.bx.bframe.common.util.IdGen;
import cn.bx.bframe.entity.DataMessage;
import cn.bx.bframe.service.SimpleService;
@Service("FileService")
@Transactional(rollbackFor=Exception.class)
public class FileService extends SimpleService<HashMap<String,String>>{
	public static final String FILE_DIR = "D:/work/bcmwork/bxprojects/upfiles/" ; 
	public DataMessage uploadFile(String ownerid,String type,MultipartFile file){
		String path = type+"/"+ownerid+"/"+file.getOriginalFilename();
		File newFile = new File(FILE_DIR + path);
		Map<String,String> fileBean = new HashMap<String,String>();
		fileBean.put("id", new IdGen(0,0).getId());
		fileBean.put("ownerid", ownerid);
		fileBean.put("type", type);
		fileBean.put("name", file.getOriginalFilename());
		fileBean.put("path", path);
		
		try {
			
			if(this.insert("addFile", fileBean) > 0){
				FileUtils.writeByteArrayToFile(newFile, file.getBytes());
				return DataMessage.success("上传成功", fileBean);
			}
			else{
				FileUtils.deleteQuietly(newFile);
				return DataMessage.error("上传失败", fileBean);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return DataMessage.error("上传失败:"+e.getLocalizedMessage(), null);
		}
	}
	
	public DataMessage dropFile(String id){
		HashMap<String,String> file = this.selectOne("getFile", id);
		if(file == null || !id.equals(file.get("id"))) 
			return DataMessage.error("文件不存在", null);
		
		FileUtils.deleteQuietly(new File(FILE_DIR + file.get("type") + "/"+file.get("ownerid") + "/" +file.get("name")));
		if(this.delete("dropFile", id) > 0) return DataMessage.success("删除成功", null);
		else return DataMessage.error("删除失败", null);
		
	}
}
