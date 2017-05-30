package cn.bx.system.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.bx.bframe.entity.DataMessage;
import cn.bx.system.service.FileService;

@RestController
@RequestMapping("system/file")
public class FileController {
	@Resource(name="FileService")
	FileService fileService;
	@RequestMapping(value="list/{ownerid}/{type}")
	public DataMessage listFile(@PathVariable("ownerid") String ownerid,
			@PathVariable("type") String type){
		HashMap<String,String> params = new HashMap<String,String>();
		params.put("ownerid", ownerid);
		params.put("type", type);
		return DataMessage.success("", fileService.selectList("listFile", params));
	}
	@RequestMapping(value="upload/{ownerid}/{type}")
	public DataMessage uploadFile(@PathVariable("ownerid") String ownerid,
			@PathVariable("type") String type,
			@RequestParam MultipartFile file){
		return fileService.uploadFile(ownerid, type, file);
	}
	
	@RequestMapping(value="drop/{id}")
	public DataMessage dropFile(@PathVariable("id") String id){
		return fileService.dropFile(id);
	}
}
