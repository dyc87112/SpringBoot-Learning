package com.didispace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ClientApplication.class)
public class ApplicationTests {

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void compute() throws Exception {

		System.out.println(restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody());

	}

}
