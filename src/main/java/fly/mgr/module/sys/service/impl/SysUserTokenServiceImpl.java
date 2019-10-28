package fly.mgr.module.sys.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import fly.mgr.common.consant.SysConstant;
import fly.mgr.common.util.DateUtils;
import fly.mgr.common.util.Md5Utils;
import fly.mgr.common.util.RandomUtils;
import fly.mgr.module.sys.dao.SysUserTokenDao;
import fly.mgr.module.sys.entity.SysUserTokenEntity;
import fly.mgr.module.sys.service.SysUserTokenService;

/**
 * token管理
 * @Date 2019年10月28日
 */
@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
    /**
     * token 随机数长度
     */
    private static final int TOKEN_LENTH = 18;

    @Override
    public String createToken(String userId) {
        // 生成token
        String token = Md5Utils.getMd5(RandomUtils.generate(TOKEN_LENTH));
        
        // 当前时间
        Date now = new Date();
        
        // 过期时间
        Date expireDate = DateUtils.getDateAddHour(now, SysConstant.TOKEN_VALIDITY_HOUR);
        
        SysUserTokenEntity tokenEntity = this.getById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireDate);
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireDate);
            this.updateById(tokenEntity);
        }
        return token;
    }

    @Override
    public void logout(String userId) {
        // 生成token
        String token = Md5Utils.getMd5(RandomUtils.generate(TOKEN_LENTH));
        //修改token
        SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
        tokenEntity.setUserId(userId);
        tokenEntity.setToken(token);
        this.updateById(tokenEntity);
    }

}
