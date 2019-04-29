package cn.mldn.microboot.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.mldn.microboot.util.controller.AbstractBaseController;

@Controller
public class UploadController extends AbstractBaseController {
	@RequestMapping(value="/uploadPre",method=RequestMethod.GET)
	public String uploadPre(){
		return "upload/upload_page";
	}
	
	/**
	 * 多个上传
	 * @param name
	 * @param photo
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(String name,HttpServletRequest request){
		if(request instanceof MultipartHttpServletRequest){
			MultipartHttpServletRequest mrequest= (MultipartHttpServletRequest)request;
			List<MultipartFile> files = mrequest.getFiles("photo");
			Iterator<MultipartFile> iterator = files.iterator();
			System.out.println(System.getProperty("user.dir"));
			while (iterator.hasNext()) {
				MultipartFile photo=iterator.next();
				if(photo !=null){
					System.out.println("文件上传name:"+name);
					System.out.println("文件上传photoName:"+photo.getName());
					System.out.println("文件上传photoContentType:"+photo.getContentType());
					System.out.println("文件上传photoSize:"+photo.getSize());
				}
			}
		}
		return "upload/upload_file";
	}

//单个上传	
/*	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(String name,MultipartFile photo){
		if(photo !=null){
			System.out.println("文件上传name:"+name);
			System.out.println("文件上传photoName:"+photo.getName());
			System.out.println("文件上传photoContentType:"+photo.getContentType());
			System.out.println("文件上传photoSize:"+photo.getSize());
		}
		return "upload/upload_file";
	}*/
}
