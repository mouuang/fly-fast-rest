package fly.mgr.module.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import fly.mgr.module.sys.entity.SysUserEntity;
import fly.mgr.module.sys.service.SysUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTest {
    
    @Autowired
    private SysUserService userService;
    
    @Test
    public void queryByUserCode() {
        String userCode = "admin";
        SysUserEntity user = userService.queryByUserCode(userCode);
        System.out.println(JSON.toJSONString(user));
    }
}
