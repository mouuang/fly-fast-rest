
package fly.mgr.module.sys.oauth2;

import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fly.mgr.common.util.Md5Utils;
import fly.mgr.module.sys.entity.SysUserEntity;
import fly.mgr.module.sys.service.SysResourceService;
import fly.mgr.module.sys.service.SysUserService;

/**
 * Shiro 认证
 * 
 * @Date 2019年10月26日
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;
    
    private SysResourceService resourceService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        //用户权限列表
        Set<String> permsSet = resourceService.getUserResource(user.getUserCode());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 查询用户信息
        SysUserEntity userEntity = userService.queryByUserCode(upToken.getUsername());
        // 验证密码
        if (userEntity == null) {
            throw new AccountException("用户名不存在");
        }
        
        boolean pswSucc = Md5Utils.checkSaltMD5(String.valueOf(upToken.getPassword()), userEntity.getPassword());
        if (!pswSucc) {
            throw new AccountException("密码错误");
        }

        //账号锁定
        if (userEntity.getStatus() != 1) {
            throw new LockedAccountException("账号已被锁定，请联系管理员");
        }
        
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), getName());
        return info;
    }
}
