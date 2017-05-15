package com.mana.ftp;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
//import com.arvato.admins.models.Message;
//import com.arvato.admins.services.shop.ParamCodeService;
//import com.arvato.admins.util.ftp.FtpClient;
//import com.arvato.handy.models.ParamCode;

/**
 * Created by TS on 2014/6/6
 */
@Controller
@Slf4j
public class FileUploadController {
//    @Autowired
//    private ParamCodeService servcie;
    

    @RequestMapping("/fileUpload")
    @ResponseBody
    public Message upload(@RequestParam("file") MultipartFile multipartFile, ServletRequest request, ServletResponse response) {
        String dirPath = getDirPath();
        String newFileName = getNewFileName(multipartFile.getOriginalFilename());
      //取图片的地址
        String basePath = "";
        try {
//            ParamCode code = servcie.getParamList("FTP").get(0);
//            ParamCode path = servcie.getParamList("basePath").get(0);
//            String paramValue = code.getParamValue();
//            String ftpConfig[] = paramValue.split(":");
            
//            String basePath = "";
            FtpClient client = new FtpClient();
            client.connectServer("127.0.0.1", "1", "123456");
            client.changeDir(dirPath);
            client.uploadFile(multipartFile.getInputStream(), newFileName);
            client.close();
//            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(fullFileName));
        } catch (Exception e) {
        	e.printStackTrace();
            log.error("上传文件异常", e);
            return Message.EXCEPTION;
        }
        return new Message(true, StringUtils.replaceChars((dirPath + File.separator + newFileName), File.separator, "/"),basePath);
    }
    
    public String convert(String utfString){  
        StringBuilder sb = new StringBuilder();  
        int i = -1;  
        int pos = 0;  
          
        while((i=utfString.indexOf("\\u", pos)) != -1){  
            sb.append(utfString.substring(pos, i));  
            if(i+5 < utfString.length()){  
                pos = i+6;  
                sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16));  
            }  
        }  
          
        return sb.toString();  
    } 

    @RequestMapping("/deleteFile")
    @ResponseBody
    public Message deleteFile(@RequestParam String filePath, ServletRequest request) {
//        File file = new File(physicalPath + File.separator + filePath);
//        if (file.exists() && file.isFile()) {
//            log.info("删除文件：{}，结果：{}", filePath, file.delete());
//            return Message.SUCCESS;
//        }
        return Message.SUCCESS;
    }

    private String getNewFileName(String originalFilename) {
        return System.nanoTime() + "." + StringUtils.substringAfterLast(originalFilename, ".");
    }

    private String getDirPath() {
        String physicalDirPath = new SimpleDateFormat("yyyyMMdd").format(new Date());
//        File dir = new File(physicalDirPath);
//
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }
        return physicalDirPath;
    }
}
