package fly.mgr.common.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import fly.mgr.common.util.ResultMap;

/**
 * 全局异常处理
 * @Date 2019年10月27日
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    /**
     * 路径不存在
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResultMap handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultMap.error("404", "路径不存在，请检查路径是否正确");
    }
    
    /**
     * 没有权限
     * @param e
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    public ResultMap handleAuthorizationException(AuthorizationException e){
        logger.error(e.getMessage(), e);
        return ResultMap.error("没有权限，请联系管理员授权");
    }
    
    /**
     * 普通异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultMap handleException(Exception e){
        logger.error(e.getMessage(), e);
        return ResultMap.error("系统异常，请稍后重试");
    }
}
