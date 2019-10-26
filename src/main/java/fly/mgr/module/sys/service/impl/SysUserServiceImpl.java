package fly.mgr.module.sys.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fly.mgr.module.sys.dao.SysUserDao;
import fly.mgr.module.sys.entity.SysUserEntity;
import fly.mgr.module.sys.service.SysUserService;

/**
 * 系统用户
 * @Date 2019年10月26日
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Override
    public SysUserEntity queryByUserCode(String userCode) {
        return baseMapper.queryByUserCode(userCode);
    }
    
}
