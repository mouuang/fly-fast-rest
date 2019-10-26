package fly.mgr.common.util;


/**
 * Id生成工具类
 * @date 2019年9月1日
 */
public class IdGenerator {
    
    /** 标志-8位 */
    private static String middle = "";
    
    static {
        StringBuffer sb = new StringBuffer(8);
        sb.append(StringUtils.fillZeroToLength(String.valueOf(NetworkUtils.getHostIP().hashCode()), 4));
        sb.append(StringUtils.fillZeroToLength(String.valueOf(NetworkUtils.getPid().hashCode()), 4));
        middle = sb.toString();
    }

	private IdGenerator () { }
	
	
	/**
	 * 生成Id
	 * @return String 32位 (14位时间 + 8位标志 + 3位线程 + 7位随机数)
	 */
	public static String getGuid() {
	    StringBuffer sb = new StringBuffer(32);
	    // 时间撮-14位
	    sb.append(DateUtils.getCurrentDateDigit())
	    // 标志-8位
	    .append(middle)
	    .append(StringUtils.fillZeroToLength(String.valueOf(Thread.currentThread().hashCode()), 3))
	    // 7位随机数
	    .append(RandomUtils.generateNumber(7));
	    
	    return sb.toString();
	}
	
}
