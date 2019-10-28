package fly.mgr.module.sys.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fly.mgr.common.util.Md5Utils;
import fly.mgr.common.util.ResultMap;
import fly.mgr.module.sys.entity.SysUserEntity;
import fly.mgr.module.sys.service.SysUserService;
import fly.mgr.module.sys.service.SysUserTokenService;

/**
 * 系统用户登陆
 * @Date 2019年10月27日
 */
@RestController
public class LoginController {
    
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private SysUserService userService;
    
    @Autowired
    private SysUserTokenService tokenService;

    /**
     * 登陆
     * @param name      
     * @param password
     * @return
     * @throws Exception 
     */
    @PostMapping("/login")
    public ResultMap login(@RequestBody Map<String, String> params) {
        String userCode = params.get("userCode");
        String password = params.get("password");
        SysUserEntity user = userService.queryByUserCode(userCode);
        if (user == null || !Md5Utils.checkSaltMD5(password, user.getPassword())) {
            return ResultMap.error("用户名或密码错误");
        }
        
        if (user.getStatus() != 1) {
            return ResultMap.error("账号已被锁定，请联系管理员");
        }
        logger.info("user={}", user.getUserId());
        // 生成token
        String token = tokenService.createToken(user.getUserId());
        return ResultMap.success("登陆成功").put("token", token);
    }
}
