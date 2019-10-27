package fly.mgr.module.sys.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import fly.mgr.common.consant.SysConstant;
import fly.mgr.module.sys.dao.SysResourceDao;
import fly.mgr.module.sys.entity.SysResourceEntity;
import fly.mgr.module.sys.service.SysResourceService;

/**
 * 菜单资源管理
 * @Date 2019年10月27日
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceDao, SysResourceEntity> implements SysResourceService {

    @Autowired
    private SysResourceDao resDao;
    
    @Override
    public Set<String> getUserResource(String userCode) {
        Set<String> permsSet = new HashSet<>();
        if (SysConstant.ADMIN_USER.equals(userCode)) {
            List<SysResourceEntity> resList = resDao.selectList(null);
            resList.forEach(s -> {
                permsSet.add(s.getResCode());
            });
        } 
        
        return permsSet;
    }

}
