package fly.mgr.common.util;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Network工具类
 * @date 2019年9月1日
 */
public class NetworkUtils {
    
    private NetworkUtils() { }
    
    /** 默认主机ip */
    private static final String DEFAULT_HOST_IP = "10.10.10.10";
    
    
    /**
     * 获取当前进程id
     */
    public static String getPid(){
        return ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
    }
    
    
    /**
     * 获取当前进程的主机IP地址
     * @param
     * @return String
     * @throws
     */
    public static String getHostIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return DEFAULT_HOST_IP;
        }
    }
    
}
