package fly.mgr.common.consant;

/**
 * 系统常量
 * @Date 2019年10月19日
 */
public interface SysConstant {
    
    /**
     * admin 用户账号
     */
    String ADMIN_USER = "admin";
    
    /**
     * 通用正常
     */
    String SUCCESS_CODE = "1";
    
    /**
     * 通用异常
     */
    String ERROR_CODE = "0";
    
    /**
     * 默认消息
     */
    String DEFAULT_SUCCESS_MSG = "ok";
    
    String DEFAULT_ERROR_MSG = "系统异常：请稍后重试。";
    
    /**
     * token 有效期
     */
    int TOKEN_VALIDITY_HOUR = 4;
}
