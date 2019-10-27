package fly.mgr.module.sys.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fly.mgr.common.util.ResultMap;

/**
 * 系统用户登陆
 * @Date 2019年10月27日
 */
@RestController
public class LoginController {
    
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 登陆
     * @param name      
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResultMap login(@RequestBody Map<String, String> params) {
        // 使用shiro编写认证操作
        Subject subject = SecurityUtils.getSubject();
        
        // 1.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(params.get("userCode"), params.get("password"));
        
        // 2.调用shiro中的认证方法
        try {
            subject.login(token);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResultMap.error(e.getMessage());
        } 
        
        return ResultMap.success("登陆成功");
    }
}
