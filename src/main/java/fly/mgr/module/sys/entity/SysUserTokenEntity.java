package fly.mgr.module.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户token
 * 
 * @Date 2019年10月28日
 */
@TableName("sys_user_token")
public class SysUserTokenEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(type = IdType.INPUT)
    private String userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
