package fly.mgr.module.sys.oauth2;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

import fly.mgr.common.util.Md5Utils;

/**
 * 自定义密码验证规则
 * @Date 2019年10月27日
 */
public class CustomerCredentialsMatcher implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String rawPassword = String.valueOf((char[]) token.getCredentials());
        String encodedPassword = String.valueOf(info.getCredentials());
        
        return Md5Utils.checkSaltMD5(rawPassword, encodedPassword);
    }

}
