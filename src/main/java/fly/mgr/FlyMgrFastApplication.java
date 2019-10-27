package fly.mgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlyMgrFastApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(FlyMgrFastApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FlyMgrFastApplication.class, args);
		logger.info("FlyMgrFastApplication start success.");
	}

}
