package controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.UploadedImageFile;

@Controller
public class UploadController {
	@RequestMapping("uploadImage")
	public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)throws Exception{
		String name = RandomStringUtils.randomAlphanumeric(10);
		String filename = name+".jpg";
		File newfile = new File(request.getServletContext().getRealPath("/image"),filename);
		newfile.getParentFile().mkdirs();
		file.getImage().transferTo(newfile);
		ModelAndView ma = new ModelAndView("showUploadFile");
		ma.addObject("imageName", filename);
		return ma;
		
	}
}
