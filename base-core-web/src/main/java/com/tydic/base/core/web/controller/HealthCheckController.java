
package com.tydic.base.core.web.controller;


import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 健康检查页，应用属性抽取
 * @author tianshuo
 * @version Id: LoginController.java, v 0.1 2016/7/28 0028 15:28 tianshuo Exp $$
 */
@Controller
@Slf4j
public class HealthCheckController {

    /**
     * 应用打包相关信息
     *
     * @return project.version
     */
    @RequestMapping("/healthcheck.html")
    @ResponseBody
    public String healthCheck() {
        String opsInfo = null;
        BufferedInputStream inputStream = null;
        try{
            inputStream = new BufferedInputStream(HealthCheckController.class.getResourceAsStream("/healthcheck.html"));
            StringBuilder sb = new StringBuilder();
            byte[] line = new byte[2048];
            while (inputStream.read(line) != -1) {
                sb.append(new String(line));
            }
            opsInfo = sb.toString();
            inputStream.close();
        } catch (FileNotFoundException e) {
            opsInfo = "ops info not exist";
            log.error("msg:{}",e);
        } catch (IOException e) {
            opsInfo = "ops info read error";
            log.error("msg:{}",e);
        } finally{
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("msg:{}",e);
                }
            }
        }
        return opsInfo;
    }

}






