package fly.mgr.module.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fly.mgr.module.sys.service.SysResourceService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysResourceServiceTest {

    @Autowired
    private SysResourceService sysResource;
    
    @Test
    public void test() {
        System.out.println(sysResource.getUserResource("admin"));
    }
}
