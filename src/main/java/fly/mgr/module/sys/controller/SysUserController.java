package fly.mgr.module.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fly.mgr.common.util.ResultMap;
import fly.mgr.module.sys.service.SysUserService;

/**
 * 系统用户管理
 * @Date 2019年10月27日
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    
    @Autowired
    private SysUserService sysUserService;
    
    /**
     * 所有用户列表
     * @param params
     * @return
     */
    @PostMapping("/list")
    public ResultMap list(@RequestParam Map<String, Object> params){
        //只有超级管理员，才能查看所有管理员列表
        //PageUtils page = sysUserService.queryPage(params);

        return ResultMap.success("ok");
    }
}
