package com.shubao.controller;

import com.alibaba.fastjson.JSONObject;
import com.shubao.util.IDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public void upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String newName = IDUtils.getImageName();
        // uploads文件夹位置
        String rootPath = request.getSession().getServletContext().getRealPath("resource/uploads/");
        // 原始名称
        String originalFileName = file.getOriginalFilename();
        // 新文件名
//        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        String newFileName = newName + originalFileName.substring(originalFileName.lastIndexOf("."));

        // 创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1) + File.separator + date.get(Calendar.DAY_OF_MONTH));

        // 新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // 判断目标文件所在目录是否存在
        if (!newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        // 完整的url
//        HttpServletRequest request = ServletActionContext.getRequest();
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = request.getContextPath();
        // root根路径
        String webappRootUrl = scheme + "://" + serverName + ":" + serverPort + contextPath;
        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.DAY_OF_MONTH) + "/" + newFileName;
        // 将相对路径写回（json格式）
//        JSONObject jsonObject = new JSONObject();
        //http://47.100.37.150:8080/upload/resource/uploads/2020/5/17/1589710957689305.png

        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("state", "success");
        resultMap.put("path", webappRootUrl + "/resource/uploads/"+fileUrl);

        // 将图片上传到本地
//        jsonObject.put("state", "success");
//        jsonObject.put("path", webappRootUrl + "/resource/uploads/"+fileUrl);

        //读取文件夹下的资源
        File[] viewAll = viewAll(rootPath);

        // 设置响应数据的类型json
        response.setContentType("application/json; charset=utf-8");
        // 写回
        response.getWriter().write(JSONObject.toJSONString(resultMap));
    }


    public File[] viewAll(String contextPath){
        //申明变量
        HashMap<String, String> hashMap = new HashMap<>();

        System.out.println(contextPath);

        File f=new File(contextPath);
        showName(f,1, hashMap);

        return null;
    }


    public static void showName(File file,int level, HashMap<String, String> hashMap){//File file=f
        File[] listFiles = file.listFiles();
        for(File f:listFiles){
            for(int i=1;i<=level;i++){
                System.out.print("-  ");
            }

            if(f.isDirectory()){//是文件夹
                System.out.println(f.getName());

                hashMap.put(f.getName(), f.getName() + "/");

                showName(f,level+1, hashMap);
            }else{//是文件
                System.out.println(f.getName());
            }
        }
    }

}
