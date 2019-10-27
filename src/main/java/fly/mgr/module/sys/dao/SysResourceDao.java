package fly.mgr.module.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import fly.mgr.module.sys.entity.SysResourceEntity;

/**
 * 系统菜单资源
 * @Date 2019年10月27日
 */
@Mapper
public interface SysResourceDao extends BaseMapper<SysResourceEntity>{
    
}
