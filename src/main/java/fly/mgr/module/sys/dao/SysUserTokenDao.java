package fly.mgr.module.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import fly.mgr.module.sys.entity.SysUserTokenEntity;

/**
 * token 管理
 * @Date 2019年10月28日
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {
    
}
