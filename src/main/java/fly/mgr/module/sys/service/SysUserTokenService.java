package fly.mgr.module.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;

import fly.mgr.module.sys.entity.SysUserTokenEntity;

/**
 * token管理
 * @Date 2019年10月28日
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity>{
    /**
     * 生成token
     * @param userId
     * @return token
     */
    String createToken(String userId);
    
    /**
     * 退出
     * @param userId
     */
    void logout(String userId);
}
