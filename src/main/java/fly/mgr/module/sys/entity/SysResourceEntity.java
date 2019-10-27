package fly.mgr.module.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 系统权限资源
 * 
 * @Date 2019年10月27日
 */
@TableName("sys_resource")
public class SysResourceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String resId;

    private String resCode;

    private String resName;

    private String resUrl;

    /** 类型 1-菜单 2-按钮 */
    private byte resType;

    private byte resOrder;

    private Date createTime;

    private String createUser;

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public byte getResType() {
        return resType;
    }

    public void setResType(byte resType) {
        this.resType = resType;
    }

    public byte getResOrder() {
        return resOrder;
    }

    public void setResOrder(byte resOrder) {
        this.resOrder = resOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
