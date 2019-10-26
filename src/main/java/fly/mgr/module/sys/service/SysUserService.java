package fly.mgr.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;

import fly.mgr.module.sys.entity.SysUserEntity;

/**
 * 系统用户
 * @Date 2019年10月26日
 */
public interface SysUserService extends IService<SysUserEntity>{

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    SysUserEntity queryByUserCode(String userCode);
}
