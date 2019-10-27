package fly.mgr.module.sys.service;

import java.util.Set;

import com.baomidou.mybatisplus.extension.service.IService;

import fly.mgr.module.sys.entity.SysResourceEntity;

/**
 * 菜单资源管理
 * @Date 2019年10月27日
 */
public interface SysResourceService extends IService<SysResourceEntity> {
    
    /**
     * 获取用户拥有的权限
     * @param userCode
     * @param resType
     * @return
     */
    Set<String> getUserResource(String userCode);
}
