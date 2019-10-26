package fly.mgr.module.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import fly.mgr.module.sys.entity.SysUserEntity;

/**
 * 系统用户
 * @Date 2019年10月26日
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 根据用户名，查询系统用户
     * @param userName
     * @return
     */
    SysUserEntity queryByUserCode(String userCode);
}
