package fly.mgr.common.util;

import java.util.HashMap;

import fly.mgr.common.consant.SysConstant;

/** 
 * 返回数据
 * @date 2019年10月15日
 * @Version 1.0
 */
public class ResultMap extends HashMap<String, Object> {
    
    private static final long serialVersionUID = 1L;
    
    private ResultMap() {
        put("code", SysConstant.SUCCESS_CODE);
        put("msg", SysConstant.DEFAULT_SUCCESS_MSG);
    }
    
    public static ResultMap error() {
        return error(SysConstant.ERROR_CODE, "哎呀，出错了");
    }
    
    public static ResultMap error(String msg) {
        return error(SysConstant.ERROR_CODE, msg);
    }
    
    public static ResultMap error(String code, String msg) {
        ResultMap r = new ResultMap();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    
    public static ResultMap success() {
        return new ResultMap();
    }
    
    public static ResultMap success(String msg) {
        ResultMap r = new ResultMap();
        r.put("msg", msg);
        return r;
    }
    
}
