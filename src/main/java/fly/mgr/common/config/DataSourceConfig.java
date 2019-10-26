package fly.mgr.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

import fly.mgr.common.util.DesUtils;

/**
 * 数据源的配置
 * @date 2019年8月31日
 */
@Configuration
public class DataSourceConfig {
	
	/**
	 * database encrypt key
	 */
	public static final String ENCRYPT_KEY = "RyFVTt4UMdF6O8sT";
	
	/**
	 * 数据源配置 
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 * @param maxActive
	 * @return DataSource
	 */
	@Bean
	public DataSource getDruidDataSource(
			@Value("${spring.datasource.druid.driver-class-name}") String driver
			,@Value("${spring.datasource.druid.url}") String url
			,@Value("${spring.datasource.druid.username}") String username
			,@Value("${spring.datasource.druid.password}") String password
			,@Value("${spring.datasource.druid.max-active}") int maxActive) {
		
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(url);
		druidDataSource.setMaxActive(maxActive);
		
		try {
			//对用户名和密码进行解密操作
			druidDataSource.setUsername(DesUtils.decrypt(username, ENCRYPT_KEY));
			druidDataSource.setPassword(DesUtils.decrypt(password, ENCRYPT_KEY));
			
			druidDataSource.setFilters("stat, wall");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return druidDataSource;
	}
	
}
