package fly.mgr.common.util;

import java.util.Collections;
import com.alibaba.fastjson.annotation.JSONField;
import fly.mgr.common.consant.SysConstant;

/** 
 * 返回数据
 * @date 2019年10月15日
 * @Version 1.0
 */
public class Result {
    
    private int code;
    private String msg;
    private Object data;
    
    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    /** 
     * 失败
     * @param msg
     * @return
     */
    public static Result fail(String msg) {
        return new Result(SysConstant.ERROR_CODE, msg, Collections.emptyMap());
    }
    
    /**
     * 成功(默认信息)
     * @return
     */
    public static Result success() {
        return new Result(SysConstant.SUCCESS_CODE, SysConstant.DEFAULT_SUCCESS_MSG, Collections.emptyMap());
    }
    
    /**
     * 成功（自定义信息）
     * @param msg
     * @return
     */
    public static Result success(String msg) {
        return new Result(SysConstant.SUCCESS_CODE, msg, Collections.emptyMap());
    }
    
    /**
     * 成功(自定义信息与数据)
     * @param msg
     * @return
     */
    public static Result success(String msg, Object data) {
        return new Result(SysConstant.SUCCESS_CODE, msg, data);
    }
    
    @JSONField(serialize = false)
    public boolean isSuccess() {
        return SysConstant.SUCCESS_CODE == this.code;
    }
    
}
