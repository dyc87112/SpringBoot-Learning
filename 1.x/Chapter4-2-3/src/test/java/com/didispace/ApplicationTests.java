package com.didispace;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void test() throws Exception {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}

}
