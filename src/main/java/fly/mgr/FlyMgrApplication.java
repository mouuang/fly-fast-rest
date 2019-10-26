package fly.mgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlyMgrApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(FlyMgrApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FlyMgrApplication.class, args);
		logger.info("FlyMgrApplication start success.");
	}

}
