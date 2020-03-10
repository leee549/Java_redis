package cn.lhx.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author lee549
 * @date 2020/3/1 21:55
 */
@Controller
@RequestMapping("/down")
public class DownloadController {
    @RequestMapping("/test1")
    public void test1(String name, HttpSession session, HttpServletResponse response) throws IOException {
        //查找目标文件
        String realPath = session.getServletContext().getRealPath("/upload_file");
        String filePath = realPath+File.separator+name;
        //设置相应头，告诉浏览器本地保存文件而不是在线打开
        response.setHeader("Content-Disposition", "attachment;filename="+name);
        //下载
        IOUtils.copy(new FileInputStream(filePath),response.getOutputStream());
    }


}
