package cn.lhx.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author lee549
 * @date 2020/3/1 21:55
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping("/test1")
    public String test1(MultipartFile file ,String username) throws IOException {
        // 获取文件原名称
        String originalFilename = file.getOriginalFilename();
        // 存入磁盘
        file.transferTo(new File("f:\\"+originalFilename));
        return "forward:/WEB-INF/success.jsp";
    }
    @RequestMapping("/test2")
    public String test2(MultipartFile file , String username, HttpSession session) throws IOException {
        //1.全局文件名,相同文件的命名
        String filename = UUID.randomUUID().toString();

        String originalFilename = file.getOriginalFilename();
        //获取文件后缀 jpg mp4...
        String extension = FilenameUtils.getExtension(originalFilename);
        //拼接全局文件名
        String uniqueFileName = filename+"."+extension;
        //2.上传文件类型
        String contentType = file.getContentType();
        System.out.println("文件类型："+contentType);
        if ("image/jpeg".equals(contentType) || "image/png".equals(contentType)||"image/gif".equals(contentType)){
            //3。将文件存入项目下的upload_file中
            //实际磁盘路径
            String realPath = session.getServletContext().getRealPath("/upload_file");
            System.out.println("磁盘路径:"+realPath);
            // file.transferTo(new File(realPath+"\\"+uniqueFileName));
            file.transferTo(new File(realPath+File.separator+uniqueFileName));
            return "forward:/WEB-INF/success.jsp";
        }
        return "forward:/WEB-INF/error.jsp";
    }

}
